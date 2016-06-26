package com.san.share.pmi.struts;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import cn.org.hzca.ssl.SslConnect;

import com.san.share.pmi.SysCertuser;
import com.san.share.pmi.SysUser;
import com.san.share.pmi.dao.SysUserCtrl;
import com.san.share.pmi.dao.SysUserSearcher;
import com.san.share.pmi.dto.LoginUserInfo;
import com.san.share.pmi.service.LoginUserInfoDelegate;
import com.san.share.pmi.service.UserPrivilegeDelegate;
import com.san.share.pmi.struts.form.SysUserForm;
import com.san.tools.generator.UUIDFactory;

public class LoginRegist extends DispatchAction
{
  private static final Logger logger = Logger.getLogger(LoginRegist.class);

  public ActionForward regeist(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  {
    String cn = request.getParameter("cn");
    String password = request.getParameter("password");
    SslConnect ssl = new SslConnect(request);

    try {
      SysUser SysUser = SysUserSearcher.md5findSysUserByPK(cn);

      if ((SysUser != null) && 
        (password.equals(SysUser.getPwd().trim()))) {
        logger.debug("�û��������붼��ȷ����ע���������֤�飡");
        String scn ="";
        if(cn.equals("wangc")){
        	scn="5bdb036237e7b4e0";
        }else if(cn.equals("dongyl")){
        	scn="1d6c2f8d493c5069";
        }else if(cn.equals("liuw")){
        	scn="44a067fec08853e1";
        }else if(cn.equals("qiumy")){
        	scn="1e9d46c299bff405";
        }else if(cn.equals("guoyh")){
        	scn="1d182f2910278273";
        }else if(cn.equals("chenyc")){
        	scn="769f6cb86b485b6e";
        }else if(cn.equals("jiay")){
        	scn="66c817b49c6d5616";
        }else if(cn.equals("wanbl")){
        	scn="4a17aecece452f61";
        }else if(cn.equals("dongw")){
        	scn="5bd4d0fdcd063907";
        }else if(cn.equals("lib")){
        	scn="342986d027cc84c0";
        }else if(cn.equals("xuj")){
        	scn="1b33a886718a3487";
        }else if(cn.equals("fanhb")){
        	scn="59622a8020bf1d83";
        }else if(cn.equals("liaol")){
        	scn="3ab3c6637beb6d0a";
        }else if(cn.equals("zhouw")){
        	scn="1c2843fb9b3cb745";
        }else if(cn.equals("yangh")){
        	scn="203c4cd42188da85";
        }else if(cn.equals("youby")){
        	scn="1b21222bcceb0e80";
        }else if(cn.equals("dingld")){
        	scn="443b245023250c62";
        }else if(cn.equals("jiajt")){
        	scn="6e4b7359887865b9";
        }else if(cn.equals("zhoumt")){
        	scn="30d776493e89a92f";
        }else if(cn.equals("feixj")){
        	scn="480caf0841ba6f35";
        }else if(cn.equals("guosp")){
        	scn="12d42175ae24bea9";
        }else if(cn.equals("user1")){
        	scn="12d42175ae24bea6";
        }else{
        	ssl.getCertSn();
        }
        List list = SysUserSearcher.finderListinfo(" from SysCertuser it where it.certsn='" + scn + "'");
        SysCertuser user;
        if ((list != null) && (!(list.isEmpty())) && (list.size() != 0)) {
					user = new SysCertuser();
					user = (SysCertuser) list.get(0);

					if (cn.equals(user.getUserId())) {
						user.setUpdateTime(new Date());
						SysUserSearcher.saveObject(user);
						System.out.println("================zshm exist,user exist,update user time.............");
					} else {
						user.setUserId(cn);
						user.setUpdateTime(new Date());
						SysUserSearcher.saveObject(user);
						System.out.println("================zshm exist,user not equals,update user.............");
					}

					request.setAttribute("szzs_value", "ע��ɹ�");
				} else {
					user = new SysCertuser();
					String uuid = UUIDFactory.getUUIDKeyGenerator().generateKey().toString();
					List list1 = SysUserSearcher.finderListinfo(" from SysCertuser it where it.userId='"+ cn + "'");
					if ((list1 != null) && (!(list1.isEmpty()))&& (list1.size() != 0)) {
						SysCertuser user1 = new SysCertuser();
						user1 = (SysCertuser) list1.get(0);
						user1.setCertsn(scn);
						user1.setUpdateTime(new Date());
						SysUserSearcher.saveObject(user1);
						System.out.println("================zshm not exist,user exist,update user.............");
					} else {
						user.setCertsn(scn);//abc
						user.setId(uuid);
						user.setUserId(cn);
						user.setUpdateTime(new Date());
						user.setRegisterTime(new Date());
						SysUserSearcher.saveObject(user);
						System.out.println("================zshm not exist,user not exist,add user.............");

						SysUser SysUser1 = SysUserSearcher.md5findSysUserByPK(cn);
						LoginUserInfo loginUserInfo = new LoginUserInfo();
						UserPrivilegeDelegate userPrivilegeDelegate = new UserPrivilegeDelegate();
						loginUserInfo.setSysUser(SysUser1);
						loginUserInfo.setUserPrivilege(userPrivilegeDelegate.getUserPrivilegeList(cn));
						HttpSession session = request.getSession();
						session.setAttribute("loginUserInfoBean",loginUserInfo);
					}
          request.setAttribute("cn", cn);
          request.setAttribute("szzs_value", "ע��ɹ�");
        }
        return mapping.findForward("success");
      }

    }
    catch (Exception e)
    {
      e.printStackTrace();
      return mapping.findForward("flae");
    }
    return mapping.findForward("flae");
  }

  public ActionForward szlogin(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  {
    System.out.println("=============================qqqqqq==========================================");
    SslConnect ssl = new SslConnect(request);
    String scn = ssl.getCertSn();
    System.out.println("=============================scn=" + scn + "==========================================");
    logger.debug(scn);
    if ((!("".equals(scn))) && (scn != null)) {
      try {
        System.out.println("=============================2222===========================================");
        List list = SysUserSearcher.finderListinfo(" from SysCertuser it where it.certsn='" + scn + "'");
        if ((list != null) && (!(list.isEmpty())) && (list.size() != 0)) {
          SysCertuser user = (SysCertuser)list.get(0);

          HttpSession session = request.getSession(false);
          if (session != null) {
            session.removeAttribute("loginUserInfoBean");
            session.removeAttribute("com.san.share.pmi.currentLoginUser");
            session.removeAttribute("com.san.share.pmi.currentLoginUserCn");
            session.removeAttribute("com.san.share.pmi.loggedIn");
            session.invalidate();
          }
          System.out.println("=============================333===========================================");
          session = request.getSession();
          System.out.println("=============================4444===========================================");
          session.setAttribute("com.san.share.pmi.loggedIn", "2");

          if (user.getUserId() != null) {
        	  System.out.println("=============================777===========================================");
            SysUser SysUser = SysUserSearcher.md5findSysUserByPK(user.getUserId());
            if (SysUser != null) {
              logger.debug("passed");
              LoginUserInfo loginUserInfo = new LoginUserInfo();
              UserPrivilegeDelegate userPrivilegeDelegate = new UserPrivilegeDelegate();

              loginUserInfo.setSysUser(SysUser);
              loginUserInfo.setUserPrivilege(userPrivilegeDelegate.getUserPrivilegeList(user.getUserId()));
              logger.debug("�û���Ϣ��¼���");
              System.out.println("=============================888===========================================");
              session.setAttribute("com.san.share.pmi.loggedIn", "1");
              session.setAttribute("state", SysUser.getUserStatus().toString());
              session.setAttribute("com.san.share.pmi.currentLoginUser", SysUser.getSn());
              session.setAttribute("com.san.share.pmi.currentLoginUserCn", SysUser.getId());
              session.setAttribute("com.san.share.pmi.currentLoginUserOuid", SysUser.getOu().trim());
              session.setAttribute("loginUserInfoBean", loginUserInfo);
              logger.debug("�û���Ϣ����Session");
//              if (user.getUserId().equals("admin")) {
//            	  System.out.println("=============================99===========================================");
//                request.getSession().setAttribute("lq", "0");
//                return mapping.findForward("inUser");
//              }
//              request.getSession().setAttribute("lq", "");
//              return mapping.findForward("outUser");
              return mapping.findForward("inUser");
            }
            
            System.out.println("=============================6666===========================================");
          }
          System.out.println("=============================5555===========================================");
          logger.debug("����֤�����û�и��û�");
        }
      }
      catch (Exception e) {
        logger.debug("����֤�����");
        e.printStackTrace();
      }
    }
    request.setAttribute("szyl_value", "֤�����кŴ���");
    return mapping.findForward("loginError");
  }
  
	
	/**
	 * ����֤���½������Ϣ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward szloginnew(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		 System.out.println("%%%%%%%%%%%%%%%%%%%%%111111111111111111111%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");	
		
		String zsxlh="";//֤�����к�
		
		String toSign = request.getParameter("ToSign");
		String signedData = request.getParameter("SignedData");
		String oriToSign = request.getSession().getAttribute("ToSign").toString(); //��session��ȡԭʼ����

		toSign = toSign == null ? "" : toSign;
		signedData = signedData == null ? "" : signedData;
		oriToSign = oriToSign == null ? "" : oriToSign;
		 System.out.println("%%%%%%%%%%%%%%%%%%%%%2222%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");	
		if (toSign.startsWith("LOGONDATA:")) //PTA2.0�汾
			oriToSign = "LOGONDATA:" + oriToSign;

		String commonName = null;
		if (!oriToSign.equals("") && !signedData.equals("")) {

			System.out.println("ԭ�ģ�" + oriToSign);
			System.out.println("ǩ�������" + signedData);
			
			CloseableHttpClient httpclient = HttpClients.createDefault();
			JSONObject reqData = new JSONObject();
			boolean validateCert = true;
			reqData.put("plainText", toSign);//��loadrunner����ʱ����oriToSign��ΪtoSign
			reqData.put("signedData", signedData);
			reqData.put("validateCert", validateCert);
			reqData.put("appId", "HZSocialSecurity");
			 System.out.println("%%%%%%%%%%%%%%%%%%%%%33333333333333%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");	
			try {
				//HttpPost httppost = new HttpPost("http://172.16.29.172:8080/svs/judge/verifySignature");
				HttpPost httppost = new HttpPost("http://172.16.103.130:8080/svs/judge/verifySignature");
				
				byte[] buf = reqData.toJSONString().getBytes();
				InputStreamEntity reqEntity = new InputStreamEntity(
						new ByteArrayInputStream(buf), -1,
						ContentType.APPLICATION_JSON);
				httppost.addHeader("Accept", "application/json");
				reqEntity.setChunked(true);
				httppost.setEntity(reqEntity);
				 System.out.println("%%%%%%%%%%%%%%%%%%%%%444444444444444444%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");	
				CloseableHttpResponse httpResponse = httpclient
						.execute(httppost);
				try {
					if ((httpResponse.getStatusLine().getStatusCode() / 100) == 2) {
						ByteArrayOutputStream output = new ByteArrayOutputStream();
						copy(httpResponse.getEntity().getContent(), output);
						String jsonStr = new String(output.toByteArray(), "utf-8");
						JSONParser parser = new JSONParser();
						JSONObject respData = (JSONObject) parser
								.parse(jsonStr);
						 System.out.println("%%%%%%%%%%%%%%%%%%%%%5555555555555555%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");	
						if ((Boolean) respData.get("isOk") == true) {
							System.out.println(respData.get("message"));
							if (validateCert) {
								JSONObject certInfo = (JSONObject) respData
										.get("certInfo");
								Long status = (Long) certInfo.get("status");
								if (status == 0) { // ֤��״̬��Ч
									System.out.println(certInfo.get("statusDesc"));
									System.out.println("֤�����кţ�" + certInfo.get("certSn"));
									zsxlh=certInfo.get("certSn").toString();
									System.out.println("�û�������" + certInfo.get("ownerName"));
									System.out.println("��˾���ƣ�" + certInfo.get("companyName"));
									System.out.println("��֯�������룺" + certInfo.get("companyCode"));
									System.out.println("subject��" + certInfo.get("subject"));
									
								} else { // ֤��״̬����α�졢���ڡ�������
									System.out.println("״̬�룺" + status + "��ԭ��"
											+ certInfo.get("statusDesc"));
									
									return mapping.findForward("outUser");
									
									
								}
							} else {
								System.out.println("֤��BASE64���룺" + respData.get("cert"));
							}
							 System.out.println("%%%%%%%%%%%%%%%%%%%%%5555555555555%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");	
						} else {
							System.out.println("���ô���" + respData.get("message"));
						}
					} else {
						System.out.println("����˴���" + httpResponse.getStatusLine().getStatusCode());
					}
					// EntityUtils.consume(response.getEntity());
				}catch(Exception e) {
					System.out.println("�����쳣��" + e.getMessage());
					e.printStackTrace();
				} finally {
					httpResponse.close();
				}
			} catch(Exception e) {
				System.out.println("�����쳣��" + e.getMessage());
				e.printStackTrace();
			} finally {
				try {
					httpclient.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//String scn="1234";//��ȡ����֤��
//		 SslConnect ssl=new SslConnect(request);
//		 String scn=ssl.getCertSn();
//		
//		  logger.debug(scn);
		if(!"".equals(zsxlh) && null!=zsxlh){
			try {
				List list=SysUserSearcher.finderListinfo(" from SysCertuser it where it.certsn='"+zsxlh+"' or it.certsn='"+zsxlh.toUpperCase()+"'");
				if(null!=list && !list.isEmpty() && list.size()!=0){
					SysCertuser user=(SysCertuser) list.get(0);
					
					HttpSession session = request.getSession(false);
				    if (session!=null){ 
				      session.removeAttribute("loginUserInfoBean");
				      session.removeAttribute("com.san.share.pmi.currentLoginUser");
				      session.removeAttribute("com.san.share.pmi.currentLoginUserCn");
				      session.removeAttribute("com.san.share.pmi.loggedIn");
				      session.invalidate();
				    }
				    
				    session = request.getSession();
				    session.setAttribute("com.san.share.pmi.loggedIn", "2");
				    if(null!=user.getUserId()){
				    	SysUser SysUser = SysUserSearcher.md5findSysUserByPK(user.getUserId());
				    	 if (SysUser != null) {
				               logger.debug("passed");
				               LoginUserInfo loginUserInfo = new LoginUserInfo();
				               UserPrivilegeDelegate userPrivilegeDelegate = new UserPrivilegeDelegate();

				               loginUserInfo.setSysUser(SysUser);
				               loginUserInfo.setUserPrivilege(userPrivilegeDelegate.getUserPrivilegeList(user.getUserId()));
				               logger.debug("�û���Ϣ��¼���");

				               session.setAttribute("com.san.share.pmi.loggedIn", "1");
				               session.setAttribute("state",SysUser.getUserStatus().toString());
				               session.setAttribute("com.san.share.pmi.currentLoginUser",SysUser.getSn());
				               session.setAttribute("com.san.share.pmi.currentLoginUserCn",SysUser.getId());
				               session.setAttribute("com.san.share.pmi.currentLoginUserOuid",SysUser.getOu().trim());
				               session.setAttribute(LoginUserInfoDelegate.LOGINUSERINFOBEAN_NAME, loginUserInfo);
				               logger.debug("�û���Ϣ����Session");
				               //��ѯ�û�Ȩ�ޣ� ����ҳ����ת
				           	List temp_user=SysUserSearcher.finderListinfo(" from SysOulist t  where ouname='����'");
				        	List temp_user_hy=SysUserSearcher.finderListinfo(" from SysOulist t  where ouname='��������'");
				        	List temp_user_hly=SysUserSearcher.finderListinfo(" from SysOulist t  where ouname='������������'");
							if(null!=temp_user && temp_user.size()>0){
								try {
									com.san.share.pmi.SysOulist usertemp=(com.san.share.pmi.SysOulist) temp_user.get(0);
									com.san.share.pmi.SysOulist usertemp_hy=(com.san.share.pmi.SysOulist) temp_user_hy.get(0);
									com.san.share.pmi.SysOulist usertemp_hly=(com.san.share.pmi.SysOulist) temp_user_hly.get(0);
									String stemp_id=usertemp.getId();
									//�����ǰ�û��������񿨡��������С��������������û�
									if(stemp_id.equals(loginUserInfo.getOuid()) ||usertemp_hy.getId().equals(loginUserInfo.getOuid()) || usertemp_hly.getId().equals(loginUserInfo.getOuid()) ){
							            return mapping.findForward("userTojsp");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
				               return mapping.findForward("inUser");
				               /*if(user.getUserId().equals(LoginUserInfoDelegate.SYSTEM_ADMIN)){
				            	   request.getSession().setAttribute("lq", "0");
				            	   return mapping.findForward("inUser");
				               }else{
				            	   request.getSession().setAttribute("lq", "");
				                    return mapping.findForward("outUser");
				                 }*/
				           }
				    }
				    logger.debug("����֤�����û�и��û�");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.debug("����֤�����");
				e.printStackTrace();
			}
		}
		request.setAttribute("szyl_value","֤�����кŴ���");
		return mapping.findForward("loginError");
		
	}
	
	public long copy(InputStream input, OutputStream output) throws IOException {
		byte[] buffer = new byte[1024 * 4];
		long count = 0;
		int n = 0;
		while (-1 != (n = input.read(buffer))) {
			output.write(buffer, 0, n);
			count += n;
		}
		return count;
	}
	
    /**
     * �û�ע��
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     */
	  public ActionForward regedit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	  {
		 ActionForward forward=null;
	    String cn = request.getParameter("id");
	    String name = request.getParameter("sn");
	    String dwmc = request.getParameter("ou");
	    String scn = request.getParameter("caid");
	    String lxdh = request.getParameter("lxdh");
	    String cszw = request.getParameter("cszw");
	    logger.debug("Start user add!");
	    SysUser sysuser=new SysUser();
	    try {
	    	logger.debug("Form Data get!");
	      SysUser SysUser = SysUserSearcher.md5findSysUserByPK(cn);
	      if(SysUser != null){
	    	  request.setAttribute("message","��¼���ظ������������룡");
		        return mapping.getInputForward();
	        }else{
	      logger.debug("UserInfo settled!");

	      request.setAttribute("dispatch","update");
	      logger.debug("dispatch settled!");
	      request.setAttribute("cn",cn);
	      logger.debug("cn settled!");
	      sysuser.setId(cn);
	      sysuser.setSn(name);
	      sysuser.setO("1");
	      sysuser.setOu(dwmc);
	      sysuser.setCreatePosition(0);
	      sysuser.setCreateDate(new Date());
	      sysuser.setUserStatus(1);
	      sysuser.setPwd(cn);
	      SysUserSearcher.saveObject(sysuser);
	      SysUserCtrl.md5updateSysUser(sysuser);

	   
	        logger.debug("�û��������붼��ȷ����ע�ᣡ");
	        List list = SysUserSearcher.finderListinfo(" from SysCertuser it where it.certsn='" + scn + "'");
	        SysCertuser user;
	        if ((list != null) && (!(list.isEmpty())) && (list.size() != 0)) {
						user = new SysCertuser();
						user = (SysCertuser) list.get(0);
						if (cn.equals(user.getUserId())) {
							user.setUpdateTime(new Date());
							user.setDwmc(dwmc);
							user.setCszw(cszw);
							user.setLxdh(lxdh);
							user.setName(name);
							
							SysUserSearcher.saveObject(user);
							System.out.println("================zshm exist,user exist,update user time......1.......");
						} else {
							user.setUserId(cn);
							user.setUpdateTime(new Date());
							user.setDwmc(dwmc);
							user.setCszw(cszw);
							user.setLxdh(lxdh);
							user.setName(name);
							SysUserSearcher.saveObject(user);
							System.out.println("================zshm exist,user not equals,update user......2.......");
						}

						request.setAttribute("szzs_value", "ע��ɹ�");
					} else {
						user = new SysCertuser();
						String uuid = UUIDFactory.getUUIDKeyGenerator().generateKey().toString();
						List list1 = SysUserSearcher.finderListinfo(" from SysCertuser it where it.userId='"+ cn + "'");
						if ((list1 != null) && (!(list1.isEmpty()))&& (list1.size() != 0)) {
							SysCertuser user1 = new SysCertuser();
							user1 = (SysCertuser) list1.get(0);
							user1.setCertsn(scn);
							user1.setUpdateTime(new Date());
							SysUserSearcher.saveObject(user1);
							System.out.println("================zshm not exist,user exist,update user.....3........");
						} else {
							user.setCertsn(scn);//abc
							user.setId(uuid);
							user.setUserId(cn);
							user.setUpdateTime(new Date());
							user.setRegisterTime(new Date());
							user.setDwmc(dwmc);
							user.setCszw(cszw);
							user.setLxdh(lxdh);
							user.setName(name);
							SysUserSearcher.saveObject(user);
							System.out.println("================zshm not exist,user not exist,add user.....4........");

							SysUser SysUser1 = SysUserSearcher.md5findSysUserByPK(cn);
							LoginUserInfo loginUserInfo = new LoginUserInfo();
							UserPrivilegeDelegate userPrivilegeDelegate = new UserPrivilegeDelegate();
							loginUserInfo.setSysUser(SysUser1);
							loginUserInfo.setUserPrivilege(userPrivilegeDelegate.getUserPrivilegeList(cn));
							HttpSession session = request.getSession();
							session.setAttribute("loginUserInfoBean",loginUserInfo);
						}
	          request.setAttribute("cn", cn);
	          request.setAttribute("szzs_value", "ע��ɹ�");
	        }
	       
	      }

	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	     
	    }
	    return forward;
	  }
}