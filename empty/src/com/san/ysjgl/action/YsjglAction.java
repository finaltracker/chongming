package com.san.ysjgl.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.san.chengxin.common.web.struts.action.BaseAction;
import com.san.share.pmi.service.LoginUserInfoDelegate;
import com.san.tools.pagetag.util.PageFindUtil;
import com.san.util.Escape;
import com.san.util.NewCsv;
import com.san.util.NewExcel2003;
import com.san.util.NewExcel2007;
import com.san.util.NewJsplUtileTools;
import com.san.util.NewZip;
import com.san.util.ReadExcel2003;
import com.san.util.ReadExcel2007;
import com.san.util.SetJsonObject;
import com.san.util.Util;
import com.san.util.Vo;
import com.san.ysjgl.model.ImproTable;
import com.san.ysjgl.model.SysMxzb;
import com.san.ysjgl.model.SysMxzbQz;
import com.san.ysjgl.model.SysZd;
import com.san.ysjgl.model.SysZsgl;
import com.san.ysjgl.model.Sysfield;
import com.san.ysjgl.model.Systable;
import com.san.ysjgl.model.Sysypfj;
import com.san.ysjgl.model.Xyjlmb;
import com.san.ysjgl.model.Ypfjzb;
import com.san.ysjgl.model.Ypfjzbval;
import com.san.ysjgl.model.Ypfjzhu;
import com.san.ysjgl.service.YsjglService;

public class YsjglAction extends BaseAction {
	private static final String SERVICENAME="ysjglserviceimpl";//元数据管理
	
	/**
	 * 查询所有部门
	 */
	public ActionForward getdepFid(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String sql=" select  ouid,ouname from sys_oulist t where 1=1 ";
		sql+=" order by t.displayorder ";
		Vo v =service.getSQL(sql);
		SetJsonObject j=Util.return_JSON(new String[]{"ouid","ouname"}, v);
		Util.responseResult4Json(response, Util.ObjecttoJsonString(j));
		return null;
	}
	/**
	 * 查询部门下的表结构
	 */
	public ActionForward bmgettable(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String style=request.getParameter("style");
		//查询表
		if("getb".equals(style)){
			String lx=request.getParameter("lx");
			String sjlx=request.getParameter("sjlx");
			String cjzt=request.getParameter("cjzt");
			if(!Util.isNull(sjlx) && sjlx.equals("0")){
				sjlx=" and sjlx in ('0','2') ";
			}else if(!Util.isNull(sjlx) && sjlx.equals("1")){
				sjlx=" and sjlx in ('1','2','3') ";
			}else{sjlx="";}
			if(!Util.isNull(cjzt)){
				cjzt=" and sfcj='1' ";
			}else{cjzt="";}
			Vo v =service.getSQL(" select  tableid,cname from sys_table where depid='"+request.getParameter("depid")+"' "+sjlx+cjzt+" and lx='"+lx+"' order by shunx  desc ");
			SetJsonObject j=Util.return_JSON(new String[]{"tableid","cname"}, v);
			Util.responseResult4Json(response, Util.ObjecttoJsonString(j));
		}else if("getf".equals(style)){
			String sfypfjcx=request.getParameter("sfypfjcx");
			if(!Util.isNull(sfypfjcx)){
				sfypfjcx=" and sfypfjcx='1' ";
			}else{sfypfjcx="";}
			//根据表查询列
			Vo v =service.getSQL(" select  fieldid,cname from sys_field where tableid='"+request.getParameter("tableid")+"' "+sfypfjcx+" order by xsxx desc ");
			SetJsonObject j=Util.return_JSON(new String[]{"fieldid","cname"}, v);
			Util.responseResult4Json(response, Util.ObjecttoJsonString(j));
		}else if("getfidinfo".equals(style)){
			//查询列详情
			Vo v =service.getHQL(" from Sysfield where fieldid='"+request.getParameter("fiedid")+"' ");
			SetJsonObject j=new SetJsonObject(v);
			Util.responseResult4Json(response, Util.ObjecttoJsonString(j));
		}else if("getbminfo".equals(style)){
			//查询部门详情
			Vo v =service.getSQL(" select  ouid,ouname from sys_oulist t where t.ouid='"+request.getParameter("bmid")+"' ");
			SetJsonObject j=new SetJsonObject(v);
			Util.responseResult4Json(response, Util.ObjecttoJsonString(j));
		}else if("gettabinfo".equals(style)){
			//查询表详情
			Vo v =service.getHQL(" from Systable where tableid='"+request.getParameter("tabid")+"' ");
			SetJsonObject j=new SetJsonObject(v);
			Util.responseResult4Json(response, Util.ObjecttoJsonString(j));
		}
		return null;
	}
	/**
	 * 查询字典表
	 */
	public ActionForward getcodeTable(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String style=request.getParameter("style");
		String code=request.getParameter("code");
		String sql="select code,code_type_name,description from code_table where code_type='"+style+"' ";
		if(!Util.isNull(code)){
			code=Escape.unescape(code);
			if(code.indexOf("','")>=0){
				sql+=" and code in ( "+code+")";
			}else{
				if(code.startsWith("'") && code.endsWith("'")){
					sql+=" and code="+code;
				}else{
					sql+=" and code='"+code+"'";
				}
			}
		}
		Vo v=service.getSQL(sql);
		SetJsonObject j=Util.return_JSON(new String[]{"id","code","description"}, v);
		Util.responseResult4Json(response, Util.ObjecttoJsonString(j));
		return null;
	}
	/**
	 * 查询编码表所有数据
	 */
	public ActionForward getcodeTableall(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String style=request.getParameter("style");
		String sql=" select code_type,description from code_table where code_type is not null  group by code_type,description ";
		Vo v=service.getSQL(sql);
		SetJsonObject j=Util.return_JSON(new String[]{"id","code"}, v);
		Util.responseResult4Json(response, Util.ObjecttoJsonString(j));
		return null;
	}
	
	
	/**
	 * 查询
	 */	
	public ActionForward getinfo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		ActionForward actionForward=null;
		String pagename=request.getParameter("pagename");
		String style=request.getParameter("style");
		request.setAttribute("lx",request.getParameter("lx"));
		if("table".equals(style)){
			//查询部门详情
			Vo v =service.getSQL(" select  ouid,ouname,syscharger from sys_oulist where ouid='"+request.getParameter("depid")+"' ");
			if(null!=v && null!=v.getList() && v.getPageCount()>0){
				request.setAttribute("bm", v.getList().get(0));
			}
			//部门下的表
			Vo v_ta =service.getHQL(" from Systable where depid='"+request.getParameter("depid")+"' and lx='"+request.getParameter("lx")+"'");
			request.setAttribute("v_talist", v_ta.getList());
			
			actionForward=mapping.findForward(pagename);
		}else{
			//查询部门详情
			Vo v =service.getSQL(" select  tableid,cname,depid,sjlx,lx from sys_table where tableid='"+request.getParameter("tablid")+"' ");
			if(null!=v && null!=v.getList() && v.getPageCount()>0){
				request.setAttribute("tab", v.getList().get(0));
				
				//表所有字段
				Vo v_ta=service.getHQL(" from Sysfield where tableid ='"+request.getParameter("tablid")+"'  order by xsxx desc");
				if(null!=v_ta && null!=v_ta.getList() && v_ta.getPageCount()>0){
					request.setAttribute("feld_table", v_ta.getList());
				}
				
				Object[] obj=(Object[])v.getList().get(0);
				Vo v2 =service.getSQL(" select  ouid,ouname from sys_oulist where ouid='"+obj[2]+"' ");
				if(null!=v2 && null!=v2.getList() && v2.getPageCount()>0){
					request.setAttribute("bm", v2.getList().get(0));
				}
			}
			actionForward=mapping.findForward(pagename);
		}
		return actionForward;
	}
	/**
	 * 添加 ,查看， 修改
	 */
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		ActionForward actionForward=null;
		YsjglForm aform=(YsjglForm) form;
		
		String style=request.getParameter("style");
		if(style.equals("addtable")){//添加表
			Systable ta=aform.getTable();
			ta.setTableid(Util.returnid(5));
			if(!Util.isNumber(request.getParameter("table_shunx"))){
				ta.setShunx(new BigDecimal(request.getParameter("table_shunx")));
			}else{ta.setShunx(null);}
			
			
			if(null!=ta.getLx() && ta.getLx().equals("table")){
				ta.setSfcj("2");
				//自动生成表名
				//查询表名sequences
				Vo v_seq=service.getSQL(" select seq_table_view_name.Nextval,'s' from dual ");
				String tableOrviewName=ta.getEname();//缩写
				if(null!=v_seq && v_seq.getPageCount()>0 && null!=v_seq.getList() && v_seq.getList().size()>0){
					Object[] seqName=(Object[]) v_seq.getList().get(0);
					tableOrviewName="L_"+tableOrviewName+"_"+seqName[0].toString();//表名格式:L+部门缩写+sequences
				}
				ta.setEname(tableOrviewName.toUpperCase());
				service.add(ta);
				request.setAttribute("tableTemp",ta);
				//添加表后自动添加SYS_ID字段
				Sysfield zd=new Sysfield();
				zd.setFieldid("sys_id_"+Util.returnid(5));//自动添加的主键以“sys_id_”开头
				zd.setTableid(ta.getTableid());
				zd.setCname("主键编号");
				zd.setEname("SYS_ID");
				zd.setZdlx("string");
				zd.setZfsize("50");
				zd.setXsxx(new BigDecimal("0"));
				zd.setGjxx(new BigDecimal("-1"));
				zd.setSfzj("1");
				zd.setGjxx(new BigDecimal("0"));
				zd.setSjclclfa("1");
				zd.setSfglcfsj("0");
				zd.setSfbd(new BigDecimal("0"));
				zd.setSflj("0");
				zd.setSfxs("0");
				zd.setSfcx("0");
				zd.setSfypfjcx("0");
				zd.setSfbmb("0");
				service.add(zd);
			}else{
				//查询视图字段
				ta.setSfcj("1");
				ta.setEname(request.getParameter("tableywm"));
				service.add(ta);
				//查询视图字段
				Vo v=service.getSQL("SELECT c.table_name,c.column_name,c.data_type,c.data_length  FROM user_tab_cols c left join user_objects u on u.object_name=c.table_name   WHERE c.table_name='"+ta.getEname()+"' and u.object_type='VIEW' ");
				if(!Util.isVoNull(v)){
					for (int i = 0; i < v.getList().size(); i++) {
						Object[] obj=(Object[])v.getList().get(i);
						Sysfield zd=new Sysfield();
						zd.setFieldid(Util.returnid(5));
						zd.setTableid(ta.getTableid());
						zd.setCname(null!=obj[1]?obj[1].toString():" ");
						zd.setEname(null!=obj[1]?obj[1].toString():" ");
						zd.setZdlx(null!=obj[2]?obj[2].toString():"");
						zd.setZfsize(null!=obj[3]?obj[3].toString():"");
						zd.setXsxx(new BigDecimal(i));
						zd.setGjxx(new BigDecimal(i-1));
						zd.setSfzj("0");
						zd.setGjxx(new BigDecimal(i));
						zd.setSjclclfa("1");
						zd.setSfglcfsj("0");
						zd.setSfbd(new BigDecimal("0"));
						zd.setSflj("0");
						zd.setSfxs("0");
						zd.setSfcx("0");
						zd.setSfypfjcx("0");
						zd.setSfbmb("0");
						service.add(zd);
					}
				}
			}			
			return new ActionForward("/ysjgl.do?dispatch=save&style=updatetable&tableid="+ta.getTableid());
		}else if(style.equals("updatetable")){//表修改前
			Vo v=service.getHQL(" from Systable where tableid ='"+request.getParameter("tableid")+"'");
			Systable ta=(Systable) v.getList().get(0);
			request.setAttribute("tableTemp",ta);
			
			//表所有字段
			Vo v_ta=service.getHQL(" from Sysfield where tableid ='"+request.getParameter("tableid")+"'  order by xsxx desc");
			if(null!=v_ta && null!=v_ta.getList() && v_ta.getPageCount()>0){
				request.setAttribute("feld_table", v_ta.getList());
			}
			
			Vo v2 =service.getSQL(" select  ouid,ouname from sys_oulist where ouid='"+ta.getDepid()+"' ");
			if(null!=v2 && null!=v2.getList() && v2.getPageCount()>0){
				request.setAttribute("bm", v2.getList().get(0));
			}
			return mapping.findForward("uptable");
		}else if(style.equals("update")){//修改表
			Systable ta=aform.getTable();
			if(null!=ta.getLx() && ta.getLx().equals("view")){
				ta.setSfcj("1");//视图默认创建
			}
			
			if(!Util.isNumber(request.getParameter("table_shunx"))){
				ta.setShunx(new BigDecimal(request.getParameter("table_shunx")));
			}else{ta.setShunx(null);}
			//如果数据表已创建
			if(null!=ta.getSfcj() && ta.getSfcj().equals("1") && null!=ta.getLx() && ta.getLx().equals("table")){				
				//查询原有的表结构
				Vo tempv_ta=service.getHQL(" from Systable where tableid ='"+ta.getTableid()+"'");
				Systable tempta=(Systable) tempv_ta.getList().get(0);

				//旧表名
				String old_l_tabname=tempta.getEname(),old_z_tabname="Z_"+tempta.getEname().substring(2,tempta.getEname().length());
				String old_h_tabname="H_"+tempta.getEname().substring(2,tempta.getEname().length());
				//新表明:正式表，临时表，历史表
				String new_l_tabname=ta.getEname(),new_z_tabname="Z_"+ta.getEname().substring(2,ta.getEname().length());
				String new_h_tabname="H_"+ta.getEname().substring(2,ta.getEname().length());
				
				if(!tempta.getEname().equals(ta.getEname())){
					service.exedeleteSQL(" alter table "+old_l_tabname+" rename to "+new_l_tabname);//修改临时表表明
					service.exedeleteSQL(" alter table "+old_z_tabname+" rename to "+new_z_tabname);//修改正式时表表明
					service.exedeleteSQL(" alter table "+old_h_tabname+" rename to "+new_h_tabname);//修改历史表表明
				}
				//修改数据类型
				if(!tempta.getSjlx().equals(ta.getSjlx())){
					//从xxx修改到xxx  如:企业-->>个人 （企业修改为个人） 一共12种情况需要处理
					if(null!=tempta.getSjlx() && "0".equals(tempta.getSjlx())){//企业
						if(null!=ta.getSjlx() && "1".equals(ta.getSjlx())){
							//企业-->>个人：把企业id改为个人id
							service.exedeleteSQL("ALTER TABLE "+new_l_tabname+" RENAME COLUMN ENTERPRISE_ID TO PERSONAL_ID");
							//历史表
							service.exedeleteSQL("ALTER TABLE "+new_h_tabname+" RENAME COLUMN ENTERPRISE_ID TO PERSONAL_ID");
							
							//正式表
							service.exedeleteSQL("ALTER TABLE "+new_z_tabname+" RENAME COLUMN ENTERPRISE_ID TO PERSONAL_ID");
							
						}else if(null!=ta.getSjlx() && "2".equals(ta.getSjlx())){
							//企业-->>企业+个人：加入个人id，加入个人id的数据处理状态
							service.exedeleteSQL(" ALTER TABLE "+new_l_tabname+" ADD(PERSONAL_ID VARCHAR2(50) null)");
							service.exedeleteSQL(" ALTER TABLE "+new_l_tabname+" ADD(MSG_OP_GR  NUMBER default 0  null)");
							//历史表
							service.exedeleteSQL(" ALTER TABLE "+new_h_tabname+" ADD(PERSONAL_ID VARCHAR2(50) null)");
							service.exedeleteSQL(" ALTER TABLE "+new_h_tabname+" ADD(MSG_OP_GR  NUMBER default 0  null)");
							
							//正式表
							service.exedeleteSQL(" ALTER TABLE "+new_z_tabname+" ADD(PERSONAL_ID VARCHAR2(50) null)");
							//service.exedeleteSQL(" ALTER TABLE "+new_z_tabname+" ADD(MSG_OP_GR  NUMBER default 0  null)");
							
						}else if(null!=ta.getSjlx() && "3".equals(ta.getSjlx())){
							//企业-->>个人+个人:把企业id改为个人id，加入第二个人的id和数据状态
							service.exedeleteSQL("ALTER TABLE "+new_l_tabname+" RENAME COLUMN ENTERPRISE_ID TO PERSONAL_ID");
							service.exedeleteSQL(" ALTER TABLE "+new_l_tabname+" ADD(PERSONAL_ID1 VARCHAR2(50) null)");
							service.exedeleteSQL(" ALTER TABLE "+new_l_tabname+" ADD(MSG_OP_GR  NUMBER default 0  null)");
							//历史表
							service.exedeleteSQL("ALTER TABLE "+new_h_tabname+" RENAME COLUMN ENTERPRISE_ID TO PERSONAL_ID");
							service.exedeleteSQL(" ALTER TABLE "+new_h_tabname+" ADD(PERSONAL_ID1 VARCHAR2(50) null)");
							service.exedeleteSQL(" ALTER TABLE "+new_h_tabname+" ADD(MSG_OP_GR  NUMBER default 0  null)");
							
							//正式表
							service.exedeleteSQL("ALTER TABLE "+new_z_tabname+" RENAME COLUMN ENTERPRISE_ID TO PERSONAL_ID");
							service.exedeleteSQL(" ALTER TABLE "+new_z_tabname+" ADD(PERSONAL_ID1 VARCHAR2(50) null)");
							//service.exedeleteSQL(" ALTER TABLE "+new_z_tabname+" ADD(MSG_OP_GR  NUMBER default 0  null)");
						}
					}else if(null!=tempta.getSjlx() && "1".equals(tempta.getSjlx())){//个人
						if(null!=ta.getSjlx() && "0".equals(ta.getSjlx())){
							//个人-->>企业:把个人id改为企业id
							service.exedeleteSQL("ALTER TABLE "+new_l_tabname+" RENAME COLUMN PERSONAL_ID TO ENTERPRISE_ID");
							//历史表
							service.exedeleteSQL("ALTER TABLE "+new_h_tabname+" RENAME COLUMN PERSONAL_ID TO ENTERPRISE_ID");
							
							//正式表
							service.exedeleteSQL("ALTER TABLE "+new_z_tabname+" RENAME COLUMN PERSONAL_ID TO ENTERPRISE_ID");
							
						}else if(null!=ta.getSjlx() && "2".equals(ta.getSjlx())){
							//个人-->>企业+个人：加企业id，加第二个数据状态 
							service.exedeleteSQL(" ALTER TABLE "+new_l_tabname+" ADD(ENTERPRISE_ID VARCHAR2(50) null)");
							service.exedeleteSQL(" ALTER TABLE "+new_l_tabname+" ADD(MSG_OP_GR  NUMBER default 0  null)");
							//历史表
							service.exedeleteSQL(" ALTER TABLE "+new_h_tabname+" ADD(ENTERPRISE_ID VARCHAR2(50) null)");
							service.exedeleteSQL(" ALTER TABLE "+new_h_tabname+" ADD(MSG_OP_GR  NUMBER default 0  null)");
							
							//正式表
							service.exedeleteSQL(" ALTER TABLE "+new_z_tabname+" ADD(ENTERPRISE_ID VARCHAR2(50) null)");
							//service.exedeleteSQL(" ALTER TABLE "+new_z_tabname+" ADD(MSG_OP_GR  NUMBER default 0  null)");
							
						}else if(null!=ta.getSjlx() && "3".equals(ta.getSjlx())){
							//个人-->>个人+个人:加个人id，加第二个数据状态
							service.exedeleteSQL(" ALTER TABLE "+new_l_tabname+" ADD(PERSONAL_ID1 VARCHAR2(50) null)");
							service.exedeleteSQL(" ALTER TABLE "+new_l_tabname+" ADD(MSG_OP_GR  NUMBER default 0  null)");
							//历史表
							service.exedeleteSQL(" ALTER TABLE "+new_h_tabname+" ADD(PERSONAL_ID1 VARCHAR2(50) null)");
							service.exedeleteSQL(" ALTER TABLE "+new_h_tabname+" ADD(MSG_OP_GR  NUMBER default 0  null)");
							//正式表
							service.exedeleteSQL(" ALTER TABLE "+new_z_tabname+" ADD(PERSONAL_ID1 VARCHAR2(50) null)");
							//service.exedeleteSQL(" ALTER TABLE "+new_z_tabname+" ADD(MSG_OP_GR  NUMBER default 0  null)");
							
						}
					}else if(null!=tempta.getSjlx() && "2".equals(tempta.getSjlx())){//企业+个人
						if(null!=ta.getSjlx() && "0".equals(ta.getSjlx())){
							//企业+个人-->>企业:删除个人id和第二个数据状态
							service.exedeleteSQL(" alter table "+new_l_tabname+" drop column PERSONAL_ID");
							service.exedeleteSQL(" alter table "+new_l_tabname+" drop column MSG_OP_GR");
							//历史表
							service.exedeleteSQL(" alter table "+new_h_tabname+" drop column PERSONAL_ID");
							service.exedeleteSQL(" alter table "+new_h_tabname+" drop column MSG_OP_GR");
							
							//正式表
							service.exedeleteSQL(" alter table "+new_z_tabname+" drop column PERSONAL_ID");
							//service.exedeleteSQL(" alter table "+new_z_tabname+" drop column MSG_OP_GR");
						}else if(null!=ta.getSjlx() && "1".equals(ta.getSjlx())){
							//企业+个人-->>个人：删除企业id，和第二个数据状态
							service.exedeleteSQL(" alter table "+new_l_tabname+" drop column ENTERPRISE_ID");
							service.exedeleteSQL(" alter table "+new_l_tabname+" drop column MSG_OP_GR");
							//历史表
							service.exedeleteSQL(" alter table "+new_h_tabname+" drop column ENTERPRISE_ID");
							service.exedeleteSQL(" alter table "+new_h_tabname+" drop column MSG_OP_GR");
							
							//正式表
							service.exedeleteSQL(" alter table "+new_z_tabname+" drop column ENTERPRISE_ID");
							//service.exedeleteSQL(" alter table "+new_z_tabname+" drop column MSG_OP_GR");

						}else if(null!=ta.getSjlx() && "3".equals(ta.getSjlx())){
							//企业+个人-->>个人+个人：把企业id改为第二个个人id
							service.exedeleteSQL("ALTER TABLE "+new_l_tabname+" RENAME COLUMN ENTERPRISE_ID TO PERSONAL_ID1");
							//历史表
							service.exedeleteSQL("ALTER TABLE "+new_h_tabname+" RENAME COLUMN ENTERPRISE_ID TO PERSONAL_ID1");
							
							//正式表
							service.exedeleteSQL("ALTER TABLE "+new_z_tabname+" RENAME COLUMN ENTERPRISE_ID TO PERSONAL_ID1");
						}
						
					}else if(null!=tempta.getSjlx() && "3".equals(tempta.getSjlx())){//个人+个人
						if(null!=ta.getSjlx() && "0".equals(ta.getSjlx())){
							//个人+个人-->>企业：删除第二个个人id，删除第二个数据状态，把第一个个人id，改为企业id，
							service.exedeleteSQL(" alter table "+new_l_tabname+" drop column PERSONAL_ID1");
							service.exedeleteSQL(" alter table "+new_l_tabname+" drop column MSG_OP_GR");
							service.exedeleteSQL(" ALTER TABLE "+new_l_tabname+" RENAME COLUMN PERSONAL_ID TO ENTERPRISE_ID");
							//历史表
							service.exedeleteSQL(" alter table "+new_h_tabname+" drop column PERSONAL_ID1");
							service.exedeleteSQL(" alter table "+new_h_tabname+" drop column MSG_OP_GR");
							service.exedeleteSQL(" ALTER TABLE "+new_h_tabname+" RENAME COLUMN PERSONAL_ID TO ENTERPRISE_ID");

							//正式表
							service.exedeleteSQL(" alter table "+new_z_tabname+" drop column PERSONAL_ID1");
							//service.exedeleteSQL(" alter table "+new_z_tabname+" drop column MSG_OP_GR");
							service.exedeleteSQL("ALTER TABLE "+new_z_tabname+" RENAME COLUMN PERSONAL_ID TO ENTERPRISE_ID");
						}else if(null!=ta.getSjlx() && "1".equals(ta.getSjlx())){
							//个人+个人-->>个人：删除第二个个人id，和第二个数据状态
							service.exedeleteSQL(" alter table "+new_l_tabname+" drop column PERSONAL_ID1");
							service.exedeleteSQL(" alter table "+new_l_tabname+" drop column MSG_OP_GR");
							//历史表
							service.exedeleteSQL(" alter table "+new_h_tabname+" drop column PERSONAL_ID1");
							service.exedeleteSQL(" alter table "+new_h_tabname+" drop column MSG_OP_GR");
							//正式表
							service.exedeleteSQL(" alter table "+new_z_tabname+" drop column PERSONAL_ID1");
							//service.exedeleteSQL(" alter table "+new_z_tabname+" drop column MSG_OP_GR");
						}else if(null!=ta.getSjlx() && "2".equals(ta.getSjlx())){
							//个人+个人-->>企业+个人：把第二个个人id改为企业id
							service.exedeleteSQL("ALTER TABLE "+new_l_tabname+" RENAME COLUMN PERSONAL_ID1 TO ENTERPRISE_ID");
							//历史表
							service.exedeleteSQL("ALTER TABLE "+new_h_tabname+" RENAME COLUMN PERSONAL_ID1 TO ENTERPRISE_ID");
							
							//正式表
							service.exedeleteSQL("ALTER TABLE "+new_z_tabname+" RENAME COLUMN PERSONAL_ID1 TO ENTERPRISE_ID");
						}
						
					}
				}
			}
			service.update(ta);
			request.setAttribute("tableTemp",ta);
			return new ActionForward("/ysjgl.do?dispatch=save&style=updatetable&tableid="+ta.getTableid());
		}else if(style.equals("feld")){//添加列或修改列
			Sysfield ta=aform.getF();
			if(!Util.isNumber(request.getParameter("f_xsxx"))){
				ta.setXsxx(new BigDecimal(request.getParameter("f_xsxx")));
			}else{ta.setXsxx(null);}
			if(!Util.isNumber(request.getParameter("f_gjxx"))){
				ta.setGjxx(new BigDecimal(Integer.parseInt(request.getParameter("f_gjxx"))-1));
			}else{ta.setGjxx(null);}
			if(!Util.isNumber(request.getParameter("f_sfbd"))){
				ta.setSfbd(new BigDecimal(request.getParameter("f_sfbd")));
			}else{ta.setSfbd(null);}
			if(!Util.isNumber(request.getParameter("f_bdyxj"))){
				ta.setBdyxj(new BigDecimal(request.getParameter("f_bdyxj")));
			}else{ta.setBdyxj(null);}
			if(!Util.isNumber(request.getParameter("f_bddyzszd"))){
				ta.setBddyzszd(new BigDecimal(request.getParameter("f_bddyzszd")));
			}else{ta.setBddyzszd(null);}
			ta.setSjclclfa(Util.arrToStr(request.getParameterValues("f_sjclclfa")));//数据处理方案，以逗号分割
			if(Util.isNull(ta.getFieldid())){
				ta.setFieldid(Util.returnid(5));
				//自动生成列名id
				Vo lies=service.getSQL("select substr(ename,2) s,ename from Sys_Field where sfzj='0' and tableid ='"+ta.getTableid()+"'  order by fieldid desc");
				String liename="01";
				if(!Util.isVoNull(lies) && null!=lies.getList() && lies.getList().size()>0){
					Object[] liesobj=(Object[]) lies.getList().get(0);
					liename=(Integer.parseInt(liesobj[0].toString())+1)+"";
				}
				if(liename.length()<2){
					liename="0"+liename;
				}
				ta.setEname("F"+liename);//列名生成规则:F+最大数加1
				
				//查询原有的表结构
				Vo tempv_ta=service.getHQL(" from Systable where tableid ='"+ta.getTableid()+"'");
				Systable tempta=(Systable) tempv_ta.getList().get(0);
				
				//修改数据库结构
				if(null!=tempta.getSfcj() && tempta.getSfcj().equals("1") && null!=tempta.getLx() && tempta.getLx().equals("table")){
					String lx_addfie="";
					if(ta.getZdlx().equals("string")){
						lx_addfie="VARCHAR2("+ta.getZfsize()+")";
					}else{
						lx_addfie=ta.getZdlx();
					}
					//添加临时表的列 
					service.exedeleteSQL(" ALTER TABLE "+tempta.getEname()+" ADD("+ta.getEname()+" "+lx_addfie+" null) ");
					//添加正式表的列 
					service.exedeleteSQL(" ALTER TABLE Z_"+tempta.getEname().substring(2,tempta.getEname().length())+" ADD("+ta.getEname()+" "+lx_addfie+" null) ");
					//添加历史表的列
					service.exedeleteSQL(" ALTER TABLE H_"+tempta.getEname().substring(2,tempta.getEname().length())+" ADD("+ta.getEname()+" "+lx_addfie+" null) ");
					//主键约束  先删除主键约束  再添加新的约束
					if(ta.getSfzj().equals("1")){
						//删除数据中的主键约束
						service.exedeleteSQL(" update SYS_FIELD set sfzj='0' where tableid='"+ta.getTableid()+"'");
						//删除数据库中的主键
						Vo zj=service.getSQL(" SELECT   constraint_name, table_name,column_name  from   user_cons_columns c where c.table_name = '"+tempta.getEname()+"'");
						Vo z_zj=service.getSQL(" SELECT   constraint_name, table_name,column_name  from   user_cons_columns c where c.table_name = 'Z_"+tempta.getEname().substring(2,tempta.getEname().length())+"'");
						Vo h_zj=service.getSQL(" SELECT   constraint_name, table_name,column_name  from   user_cons_columns c where c.table_name = 'H_"+tempta.getEname().substring(2,tempta.getEname().length())+"'");
						if(null!=zj && null!=zj.getList() && zj.getList().size()>0){
							Object[] objzj=(Object[])zj.getList().get(0);
							service.exedeleteSQL("  alter table  "+tempta.getEname()+" drop constraint "+objzj[0].toString());
						}
						if(null!=z_zj && null!=z_zj.getList() && z_zj.getList().size()>0){
							Object[] objzj=(Object[])z_zj.getList().get(0);
							Object[] obhzj=(Object[])h_zj.getList().get(0);
							service.exedeleteSQL("  alter table  Z_"+tempta.getEname().substring(2,tempta.getEname().length())+" drop constraint "+objzj[0].toString());
							service.exedeleteSQL("  alter table  H_"+tempta.getEname().substring(2,tempta.getEname().length())+" drop constraint "+obhzj[0].toString());
						}
						//添加新的主键
						service.exedeleteSQL("alter table "+tempta.getEname()+" add constraint PK_"+tempta.getEname()+"_"+ta.getEname()+" primary key("+ta.getEname()+")");
						service.exedeleteSQL("alter table Z_"+tempta.getEname().substring(2,tempta.getEname().length())+" add constraint PK_Z_"+tempta.getEname().substring(2,tempta.getEname().length())+"_"+ta.getEname()+" primary key("+ta.getEname()+")");
						service.exedeleteSQL("alter table H_"+tempta.getEname().substring(2,tempta.getEname().length())+" add constraint PK_H_"+tempta.getEname().substring(2,tempta.getEname().length())+"_"+ta.getEname()+" primary key("+ta.getEname()+")");
					}
				}
				service.add(ta);
			}else{
				//查询原有的列
				Vo tempv_fie=service.getHQL(" from Sysfield where fieldid ='"+ta.getFieldid()+"'");
				Sysfield tempv_fieobj=(Sysfield)tempv_fie.getList().get(0);
				
				//查询原有的表结构
				Vo tempv_ta=service.getHQL(" from Systable where tableid ='"+ta.getTableid()+"'");
				Systable tempta=(Systable) tempv_ta.getList().get(0);
				
				//修改数据库结构
				if(null!=tempta.getSfcj() && tempta.getSfcj().equals("1") && null!=tempta.getLx() && tempta.getLx().equals("table")){
					String lx_addfie="";
					if(ta.getZdlx().equals("string")){
						lx_addfie="VARCHAR2("+ta.getZfsize()+")";
					}else{
						lx_addfie=ta.getZdlx();
					}
					//修改临时表的数据类型
					service.exedeleteSQL(" ALTER TABLE "+tempta.getEname()+" modify("+tempv_fieobj.getEname()+" "+lx_addfie+") ");
					//修改正式表的数据类型
					service.exedeleteSQL(" ALTER TABLE Z_"+tempta.getEname().substring(2,tempta.getEname().length())+" modify("+tempv_fieobj.getEname()+" "+lx_addfie+") ");
					//修改历史表的数据类型
					service.exedeleteSQL(" ALTER TABLE H_"+tempta.getEname().substring(2,tempta.getEname().length())+" modify("+tempv_fieobj.getEname()+" "+lx_addfie+") ");
					//列明相同时不需要修改
					if(!tempv_fieobj.getEname().equals(ta.getEname())){
						//修改临时表的名字
						service.exedeleteSQL(" ALTER TABLE "+tempta.getEname()+" RENAME COLUMN "+tempv_fieobj.getEname()+" to "+ta.getEname()+" ");
						//修改正式表的名字
						service.exedeleteSQL(" ALTER TABLE Z_"+tempta.getEname().substring(2,tempta.getEname().length())+" RENAME COLUMN "+tempv_fieobj.getEname()+" to "+ta.getEname()+" ");
						//修改历史表的名字
						service.exedeleteSQL(" ALTER TABLE H_"+tempta.getEname().substring(2,tempta.getEname().length())+" RENAME COLUMN "+tempv_fieobj.getEname()+" to "+ta.getEname()+" ");
					}
					
					//主键约束  先删除主键约束  再添加新的约束
					if(ta.getSfzj().equals("1")){
						//删除数据中的主键约束
						service.exedeleteSQL(" update SYS_FIELD set sfzj='0' where tableid='"+ta.getTableid()+"'");
						//删除数据库中的主键
						Vo zj=service.getSQL(" SELECT   constraint_name, table_name,column_name  from   user_cons_columns c where c.table_name = '"+tempta.getEname()+"'");
						Vo z_zj=service.getSQL(" SELECT   constraint_name, table_name,column_name  from   user_cons_columns c where c.table_name = 'Z_"+tempta.getEname().substring(2,tempta.getEname().length())+"'");
						Vo h_zj=service.getSQL(" SELECT   constraint_name, table_name,column_name  from   user_cons_columns c where c.table_name = 'H_"+tempta.getEname().substring(2,tempta.getEname().length())+"'");
						if(null!=zj && null!=zj.getList() && zj.getList().size()>0){
							Object[] objzj=(Object[])zj.getList().get(0);
							service.exedeleteSQL("  alter table  "+tempta.getEname()+" drop constraint "+objzj[0].toString());
						}
						if(null!=z_zj && null!=z_zj.getList() && z_zj.getList().size()>0){
							Object[] objzj=(Object[])z_zj.getList().get(0);
							Object[] objhzj=(Object[])h_zj.getList().get(0);
							service.exedeleteSQL("  alter table  Z_"+tempta.getEname().substring(2,tempta.getEname().length())+" drop constraint "+objzj[0].toString());
							service.exedeleteSQL("  alter table  H_"+tempta.getEname().substring(2,tempta.getEname().length())+" drop constraint "+objhzj[0].toString());
						}
						//添加新的主键
						service.exedeleteSQL("alter table "+tempta.getEname()+" add constraint PK_"+tempta.getEname()+"_"+ta.getEname()+" primary key("+ta.getEname()+")");
						service.exedeleteSQL("alter table Z_"+tempta.getEname().substring(2,tempta.getEname().length())+" add constraint PK_Z_"+tempta.getEname().substring(2,tempta.getEname().length())+"_"+ta.getEname()+" primary key("+ta.getEname()+")");
						service.exedeleteSQL("alter table H_"+tempta.getEname().substring(2,tempta.getEname().length())+" add constraint PK_H_"+tempta.getEname().substring(2,tempta.getEname().length())+"_"+ta.getEname()+" primary key("+ta.getEname()+")");
					}
				}
				//修改数据
				service.update(ta);
			}
			return new ActionForward("/ysjgl.do?dispatch=save&style=feldinfo&feldid="+ta.getFieldid());
		}else if(style.equals("feldinfo")){//修改前的查看
			Vo v=service.getHQL(" from Sysfield where fieldid ='"+request.getParameter("feldid")+"'");
			Sysfield ta=(Sysfield) v.getList().get(0);
			request.setAttribute("fiedl",ta);
			
			Vo v2 =service.getSQL(" select  tableid,cname,depid,sjlx,lx from sys_table where tableid='"+ta.getTableid()+"' ");
			if(null!=v2 && null!=v2.getList() && v2.getPageCount()>0){
				//表名
				request.setAttribute("tab", v2.getList().get(0));
				//表所有字段
				Vo v_ta=service.getHQL(" from Sysfield where tableid ='"+ta.getTableid()+"' order by xsxx desc");
				if(null!=v_ta && null!=v_ta.getList() && v_ta.getPageCount()>0){
					request.setAttribute("feld_table", v_ta.getList());
				}
				//部门名字
				Object[] ta_=(Object[]) v2.getList().get(0);
				Vo v3 =service.getSQL(" select  ouid,ouname from sys_oulist where ouid='"+ta_[2]+"' ");
				if(null!=v3 && null!=v3.getList() && v3.getPageCount()>0){
					request.setAttribute("bm", v3.getList().get(0));
				}
				
				if(ta_[4].equals("table")){
					return mapping.findForward("bzdwh");	
				}else{
					return mapping.findForward("stzdwh");
				}
			}
			
		}else if(style.equals("deldtefied")){//删除列
			//查询原有的表结构
			Vo tempv_ta=service.getSQL(" select tableid,ename,sfcj,lx from sys_table where tableid =(select tableid from sys_field where fieldid ='"+request.getParameter("delid")+"' ) ");
			//删除列
			service.exedeleteSQL(" delete sys_field where fieldid ='"+request.getParameter("delid")+"'");	
			//如果当前表结构已建创建， 那同时删除数据库中的列
			Object[]  tempta_obj=(Object[]) tempv_ta.getList().get(0);
			if(null!=tempta_obj && null!=tempta_obj[2] && tempta_obj[2].toString().equals("1") && null!=tempta_obj[3] && tempta_obj[3].toString().equals("table")){
				//删除临时表的列
				service.exedeleteSQL(" ALTER TABLE "+tempta_obj[1]+" DROP COLUMN "+request.getParameter("fieldname"));
				//删除正式表的列
				service.exedeleteSQL(" ALTER TABLE Z_"+tempta_obj[1].toString().substring(2,tempta_obj[1].toString().length())+" DROP COLUMN "+request.getParameter("fieldname"));
				service.exedeleteSQL(" ALTER TABLE H_"+tempta_obj[1].toString().substring(2,tempta_obj[1].toString().length())+" DROP COLUMN "+request.getParameter("fieldname"));
			}
			return null;
		}else if(style.equals("deldtetab")){//删除表
			service.exedeleteSQL(" delete sys_table where tableid ='"+request.getParameter("tabid")+"'");	
			service.exedeleteSQL(" delete sys_field where tableid ='"+request.getParameter("tabid")+"'");	
			//如果当前数据表已建， 还得删除数据表
			String lx=request.getParameter("lx");
			if(!Util.isNull(request.getParameter("sfcj")) && "1".equals(request.getParameter("sfcj")) && !Util.isNull(request.getParameter("tabname")) && !Util.isNull(lx) && lx.equals("table")){
				//删除临时表
				service.exedeleteSQL(" drop table "+request.getParameter("tabname") );
				//删除正式表
				service.exedeleteSQL(" drop table Z_"+request.getParameter("tabname").substring(2,request.getParameter("tabname").length()) );
				service.exedeleteSQL(" drop table H_"+request.getParameter("tabname").substring(2,request.getParameter("tabname").length()) );
			}
			//删除视图
			if(null!=lx && lx.equals("view")){
				service.exedeleteSQL(" drop view "+request.getParameter("tabname") );
			}
			
			return null;
		}else if(style.equals("cjtable")){
			List list_re=new ArrayList();
			Vo v =service.getHQL(" from Systable where tableid='"+request.getParameter("tabid")+"' ");
			if(null==v || null==v.getList() || v.getList().size()<=0){
				list_re.add(new Object[]{"0","表结构错误,无法创建!"});
				Vo vlist_=new Vo();vlist_.setList(list_re);vlist_.setPageCount(1);
				SetJsonObject j=Util.return_JSON(new String[]{"style","jieg"},vlist_);
				Util.responseResult4Json(response, Util.ObjecttoJsonString(j));
				return null;
			}
			Systable tab=(Systable) v.getList().get(0);
			Vo v2 =service.getHQL(" from Sysfield where tableid='"+tab.getTableid()+"' ");
			if(null==v2 || null==v2.getList() || v2.getList().size()<=0){
				list_re.add(new Object[]{"1","未找到字段信息,无法创建!"});
				Vo vlist_=new Vo();vlist_.setList(list_re);vlist_.setPageCount(1);
				SetJsonObject j=Util.return_JSON(new String[]{"style","jieg"},vlist_);
				Util.responseResult4Json(response, Util.ObjecttoJsonString(j));
				return null;
			}
			String sql="create table "+tab.getEname()+" (";//临时表
			String sql2="create table  Z_"+tab.getEname().substring(2,tab.getEname().length())+" (";//正式表
			String sql3="create table  H_"+tab.getEname().substring(2,tab.getEname().length())+" (";//历史表
			boolean b=false;
			String sfzj="";
			//字段类型
			
			for (int i = 0; i < v2.getList().size(); i++) {
				Sysfield fie=(Sysfield) v2.getList().get(i);
				if(Util.isNull(fie.getEname())){
					b=true;
					break;
				}
				String def="";
				if(fie.getFieldid().startsWith("sys_id_")){
					def=" default sys_guid() ";
				}
				//是否为空
				String isnull="null";
				//是否主键
				if(null!=fie && null!=fie.getSfzj() && fie.getSfzj().equals("1")){
					isnull=" not null";
					sfzj=fie.getEname();
				}
				//sql语句
				String str_zf="";
				if(fie.getZdlx().equals("string")){
					str_zf=fie.getZfsize()+")";
				}
				String lx="";
				if("string".equals(fie.getZdlx())){
					lx="varchar(";
				}else{
					lx=fie.getZdlx();
				}
				
				sql+="	   "+fie.getEname()+"    "+lx+str_zf+"  "+def+"    "+isnull+",";
				sql2+="	   "+fie.getEname()+"    "+lx+str_zf+"     "+def+"  "+isnull+",";
				sql3+="	   "+fie.getEname()+"    "+lx+str_zf+"     "+def+"  "+isnull+",";
			}
			if(b){
				list_re.add(new Object[]{"2","字段错误,无法创建!"});
				Vo vlist_=new Vo();vlist_.setList(list_re);vlist_.setPageCount(1);
				SetJsonObject j=Util.return_JSON(new String[]{"style","jieg"},vlist_);
				Util.responseResult4Json(response, Util.ObjecttoJsonString(j));
				return null;
			}
			//默认字段
			sql+=" INPUT_DATE  date null ,";
			sql+=" MSG_OP  NUMBER default 0 null ,";
			sql+=" SEQ_VALUE  NUMBER null ,";
			sql+=" YCYY  VARCHAR2(2000) null ,";
			//------------
			sql2+=" INPUT_DATE  date null ,";
			//sql2+=" MSG_OP  NUMBER default 0 null ,";
			sql2+=" SEQ_VALUE  NUMBER null ,";
			//sql2+=" YCYY  VARCHAR2(2000) null ,";
			
			//历史表
			sql3+=" INPUT_DATE  date null ,";
			sql3+=" MSG_OP  NUMBER default 0 null ,";
			sql3+=" SEQ_VALUE  NUMBER null ,";
			sql3+=" YCYY  VARCHAR2(2000) null ,";
			
			//控制企业和个人
			String temp_sql="";
			if("0".equals(tab.getSjlx())){//企业
				sql+=" ENTERPRISE_ID  VARCHAR2(50) null ,";

				sql2+=" ENTERPRISE_ID  VARCHAR2(50) null ,";
				sql3+=" ENTERPRISE_ID  VARCHAR2(50) null ,";
			}else if("1".equals(tab.getSjlx())){//个人
				sql+=" PERSONAL_ID  VARCHAR2(50) null ,"; 

				sql2+=" PERSONAL_ID  VARCHAR2(50) null ,"; 
				sql3+=" PERSONAL_ID  VARCHAR2(50) null ,"; 
			}else if("2".equals(tab.getSjlx())){//企业+个人
				sql+=" ENTERPRISE_ID  VARCHAR2(50) null ,";//企业
				sql+=" PERSONAL_ID  VARCHAR2(50) null ,";//个人
				sql+=" MSG_OP_GR  NUMBER default 0  null ,";//个人的状态
				
				sql2+=" ENTERPRISE_ID  VARCHAR2(50) null ,";//企业
				sql2+=" PERSONAL_ID  VARCHAR2(50) null ,";//个人
				//sql2+=" MSG_OP_GR  NUMBER default 0  null ,";//个人的状态
				

				sql3+=" ENTERPRISE_ID  VARCHAR2(50) null ,";//企业
				sql3+=" PERSONAL_ID  VARCHAR2(50) null ,";//个人
				sql3+=" MSG_OP_GR  NUMBER default 0  null ,";//个人的状态
				
			}else if("3".equals(tab.getSjlx())){//个人+个人
				sql+=" PERSONAL_ID  VARCHAR2(50) null ,";//个人0
				sql+=" PERSONAL_ID1  VARCHAR2(50) null ,";//个人1
				sql+=" MSG_OP_GR  NUMBER default 0  null ,";//个人1的状态
				
				sql2+=" PERSONAL_ID  VARCHAR2(50) null ,";//个人0
				sql2+=" PERSONAL_ID1  VARCHAR2(50) null ,";//个人1
				//sql2+=" MSG_OP_GR  NUMBER default 0  null ,";//个人1的状态
				
				sql3+=" PERSONAL_ID  VARCHAR2(50) null ,";//个人0
				sql3+=" PERSONAL_ID1  VARCHAR2(50) null ,";//个人1
				sql3+=" MSG_OP_GR  NUMBER default 0  null ,";//个人1的状态
			}	
			
			//添加主键
			if(Util.isNull(sfzj)){
				sql=sql.substring(0,sql.length()-1);
				sql2=sql2.substring(0,sql2.length()-1);
				sql3=sql2.substring(0,sql2.length()-1);
			}else{
				sql+=" constraint PK_SYS_"+tab.getEname()+"_"+sfzj+" primary key ("+sfzj+")";
				sql2+=" constraint PK_SYS_Z_"+tab.getEname().substring(2,tab.getEname().length())+"_"+sfzj+" primary key ("+sfzj+")";
				sql3+=" constraint PK_SYS_H_"+tab.getEname().substring(2,tab.getEname().length())+"_"+sfzj+" primary key ("+sfzj+")";
			}
			sql+="		)";
			sql2+="		)";
			sql3+="		)";
			String jg="";
			//创建前先删除原表
			if(!Util.isNull(tab.getEname())){
				//service.exedeleteSQL(" drop table "+tab.getEname());	
				//service.exedeleteSQL(" drop table Z_"+tab.getEname().substring(2,tab.getEname().length()));	
			}
			if(!Util.isNull(tab.getEname()) && service.exedeleteSQL(sql) && service.exedeleteSQL(sql2)  && service.exedeleteSQL(sql3) ){
				//修改创建状态
				tab.setSfcj("1");
				service.update(tab);
				jg="创建成功!";
			}else{
				//创建失败时删除已创建的表
				service.exedeleteSQL(" drop table "+tab.getEname());	
				service.exedeleteSQL(" drop table Z_"+tab.getEname().substring(2,tab.getEname().length()));	
				service.exedeleteSQL(" drop table H_"+tab.getEname().substring(2,tab.getEname().length()));	
				jg="创建失败!";
			}

			list_re.add(new Object[]{"3",jg});
			Vo vlist_=new Vo();vlist_.setList(list_re);vlist_.setPageCount(1);
			SetJsonObject j=Util.return_JSON(new String[]{"style","jieg"},vlist_);
			Util.responseResult4Json(response, Util.ObjecttoJsonString(j));
			return null;
		}
		return actionForward;
	}
	/**
	 * 查询节点
	 */
	public ActionForward getuserOrywlx(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String style=request.getParameter("style");
		if(style.equals("lx")){//一级菜单:根据类型查询
			String lx=request.getParameter("lx");
			String sql="select 's' as a ,"+lx+" from sys_table where 1=1 and lx='table' and "+lx+" is not null ";
			if(lx.equals("sjlx")){
				sql+=" and sjlx in (0,1) ";
			}
			sql+=" group by "+lx+" order by "+lx;
			Vo v =service.getSQL(sql);
			SetJsonObject j=Util.return_JSON(new String[]{"temp","name"}, v);
			Util.responseResult4Json(response, Util.ObjecttoJsonString(j));
			return null;
		}else if(style.equals("bm")){//二级菜单:根据类型查询部门节点
			String id=request.getParameter("id");
			String lx=request.getParameter("lx");	
			String temp_sql="";
			if(lx.equals("sjlx") && id.equals("0")){
				temp_sql+=" or sjlx='2' ";
			}else if(lx.equals("sjlx") && id.equals("1")){
				temp_sql+=" or sjlx='2' or sjlx='3' ";
			}else{temp_sql="";}
			
			Vo v =service.getSQL(" select t.depid,o.ouname from sys_table t "+
								"	left join sys_oulist o  on o.ouid=t.depid"+
								"	where "+lx+"='"+id+"' "+temp_sql+"  and t.lx='table' "+
								"	group by t.depid,o.ouname"+
								"	order by  sum(t.shunx)");
			SetJsonObject j=Util.return_JSON(new String[]{"depid","ouname"}, v);
			Util.responseResult4Json(response, Util.ObjecttoJsonString(j));
			return null;
			
		}else if(style.equals("tab")){//三级菜单:根据类型和部门查询表节点
			String lxvalue=request.getParameter("lxvalue");
			String depid=request.getParameter("depid");
			String lx=request.getParameter("lx");	
			
			
			String temp_sql="";
			if(lx.equals("sjlx") && lxvalue.equals("0")){
				temp_sql+=" or sjlx='2' ";
			}else if(lx.equals("sjlx") && lxvalue.equals("1")){
				temp_sql+=" or sjlx='2' or sjlx='3' ";
			}else{temp_sql="";}
			
			Vo v =service.getHQL(" from Systable where ("+lx+"='"+lxvalue+"' "+temp_sql+") and depid='"+depid+"' and lx='table'");
			SetJsonObject j=new SetJsonObject();j.setRows(v.getList());j.setTotal(v.getPageCount());
			Util.responseResult4Json(response, Util.ObjecttoJsonString(j));
			return null;
		}else if(style.equals("fide")){//四级菜单:查询列节点
			String tabid=request.getParameter("tabid");
			Vo v =service.getHQL(" from Sysfield where tableid='"+tabid+"'");
			SetJsonObject j=new SetJsonObject();j.setRows(v.getList());j.setTotal(v.getPageCount());
			Util.responseResult4Json(response, Util.ObjecttoJsonString(j));
			return null;
		}else if(style.equals("tabinfo")){//查看表详情
			Vo v=service.getHQL(" from Systable where tableid ='"+request.getParameter("tableid")+"'");
			Systable ta=(Systable) v.getList().get(0);
			request.setAttribute("tableTemp",ta);
			
			Vo v2 =service.getSQL(" select  ouid,ouname from sys_oulist where ouid='"+ta.getDepid()+"' ");
			if(null!=v2 && null!=v2.getList() && v2.getPageCount()>0){
				request.setAttribute("bm", v2.getList().get(0));
			}
			return mapping.findForward("tabinfo");
		}else if(style.equals("fiedinfo")){//查看列详情
			Vo v=service.getHQL(" from Sysfield where fieldid ='"+request.getParameter("feldid")+"'");
			Sysfield ta=(Sysfield) v.getList().get(0);
			request.setAttribute("fiedl",ta);
	
			Vo v2 =service.getSQL(" select  tableid,cname,depid,sjlx,lx from sys_table where tableid='"+ta.getTableid()+"' ");
			if(null!=v2 && null!=v2.getList() && v2.getPageCount()>0){
				request.setAttribute("tab", v2.getList().get(0));
				
				Object[] ta_=(Object[]) v2.getList().get(0);
				Vo v3 =service.getSQL(" select  ouid,ouname from sys_oulist where ouid='"+ta_[2]+"' ");
				if(null!=v3 && null!=v3.getList() && v3.getPageCount()>0){
					request.setAttribute("bm", v3.getList().get(0));
				}
			}
			return mapping.findForward("fiedinfo");
		}
		return null;
	}
	/**
	 *查询信用记录模板 
	 */
	public ActionForward getxyjl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String style=request.getParameter("style");
		if(null!=style && style.equals("update")){
			Vo v=service.getHQL(" from Xyjlmb where xyjlmbid='"+request.getParameter("id")+"'");
			if(null!=v && null!=v.getList() && v.getList().size()>0){
				request.setAttribute("xyjl", (Xyjlmb)v.getList().get(0));	
			}
			return mapping.findForward("update_xyjl");
		}else{
			Vo v=service.getHQL(" from Xyjlmb ");
			request.setAttribute("list", v.getList());
			return mapping.findForward("xyjlmb");
		}
	}
	/**
	 * 添加或修改信用模板
	 */
	public ActionForward updateOradd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		YsjglForm objform=(YsjglForm)form;
		Xyjlmb xyjl=objform.getXyjl();
		boolean b=false;
		if(Util.isNull(xyjl.getXyjlmbid())){
			xyjl.setXyjlmbid(Util.returnid(5));
			xyjl.setCjtime(Util.getDate("yyyy-MM-dd HH:mm:ss"));
			b=service.add(xyjl);
		}else{
			b=service.update(xyjl);
		}
		if(b){
			String url=this.getServlet().getServletContext().getRealPath("/file/jsp/");
			//生成jsp文件
			NewJsplUtileTools.fileJspOperation(url,xyjl.getXyjlmbid(),xyjl.getContext(),xyjl.getJlname(),xyjl.getSsqt());
		}
		return new ActionForward("/ysjgl.do?dispatch=getxyjl");
	}
	
	/**
	 * 得到指标 
	 */
	public ActionForward getzb(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String style=request.getParameter("style");
		//查询二级菜单
		if("top1".equals(style)){
			String ssqt=request.getParameter("ssqt");
			String sql=" select index_type_code,'s' from sys_index t where 1=1 and index_type_code is not null ";
			if(!Util.isNull(ssqt)){
				sql+=" and t.index_type='"+ssqt+"'";
			}
			sql+=" group by index_type_code ";
			Vo v=service.getSQL(sql);
			SetJsonObject j=Util.return_JSON(new String[]{"code","temp"}, v);
			Util.responseResult4Json(response, Util.ObjecttoJsonString(j));
			return null;
		}else if("top2".equals(style)){
			//查询三级菜单
			String sjlxvalue=request.getParameter("sjlxvalue");
			String ssqt=request.getParameter("ssqt");
			String sql=" select index_id,index_name,index_type_code,index_type,create_time from sys_index t where state='1' ";
			if(!Util.isNull(sjlxvalue)){
				sql+=" and t.index_type_code2='"+sjlxvalue+"'";
			}if(!Util.isNull(ssqt)){
				sql+=" and t.index_type='"+ssqt+"'";
			}
			sql+=" order by t.create_time desc";
			Vo v=service.getSQL(sql);
			SetJsonObject j=Util.return_JSON(new String[]{"id","name","sjlx","ssqt","createdate"}, v);
			Util.responseResult4Json(response, Util.ObjecttoJsonString(j));
			return null;
		}
		return null;
	}
	/**
	 * 指数管理
	 */
	public ActionForward getzsgl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String style=request.getParameter("style_get");
		if(Util.isNull(style)){
			String id=request.getParameter("id");
			String hql=" from SysZsgl where 1=1 ";
			String request_name="";
			if(!Util.isNull(id)){//查看详情
				hql+=" and zsglid='"+id+"' ";
				request_name="zsgl";
				Vo v=service.getHQL(hql);
				if(null!=v && null!=v.getList() && v.getPageCount()>0 && v.getList().size()>0){
					request.setAttribute(request_name,(SysZsgl)v.getList().get(0));
				}
			}else{//查询所有
				Vo v=service.getHQL(hql+" order by creattime desc");
				request_name="zsgllist";
				if(null!=v && null!=v.getList() && v.getPageCount()>0 && v.getList().size()>0){
					request.setAttribute(request_name,v.getList());
				}
			}
			return mapping.findForward(request_name);
		}else if(!Util.isNull(style) && "getcheck".equals(style)){
			
			return null;
		}
		return null;
	}
	/**
	 * 指数添加或修改
	 */
	public ActionForward addzsgl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String style=request.getParameter("style");
		if(null!=style && "addOrUpdate".equals(style)){
			YsjglForm objform=(YsjglForm)form;
			SysZsgl zsgl=objform.getZsgl();
			if(!Util.isNull(zsgl.getZsglid())){
				service.update(zsgl);
			}else{
				zsgl.setZsglid(Util.returnid(5));
				zsgl.setCreattime(Util.getDate(""));
				service.add(zsgl);
			}
			return null;
		}else if(null!=style && "delete".equals(style)){
			String id=request.getParameter("deleteid");
			service.exedeleteSQL(" delete from SYS_ZSGL where ZSGLID='"+id+"'");
			return new ActionForward("/ysjgl.do?dispatch=getzsgl");
		}else{
			return null;
		}
	}
	/**************************************************************************************************************/
	
	/**
	 * 查询一票否决模板
	 */
	public ActionForward getypfjMb(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String userId = LoginUserInfoDelegate.getCnFromRequest(request);
		String sql=" select ypfjzhuid,case style when '0' then '企业 ' when '1' then  '个人 ' end style,ouname,z.depid,pztime,yuliu1 from  ypfjzhu z"+
					"	left join sys_oulist ou on ou.ouid=z.depid 	where 1=1 ";
		if(!"admin".equals(userId)){
			sql+=" z.depid='"+LoginUserInfoDelegate.getOuidFromRequest(request)+"'";
		}
		sql+=" order by pztime desc ";
		Vo v=service.getSQL(PageFindUtil.getPageNo(request), PageFindUtil.getPageSize(request,10), sql);
		if(Util.isVoNull(v)){
			return mapping.findForward("addUpdypfj");
		}else{
			request.setAttribute("totalCount",v.getPageCount());
			request.setAttribute("list",v.getList());
			return mapping.findForward("ypfj");
		}
	}
	/**
	 * 查询一票否决历史匹配情况
	 */
	public ActionForward ypfjhispp(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String id=request.getParameter("id");
		Vo v=service.getSQL(PageFindUtil.getPageNo(request), PageFindUtil.getPageSize(request,10),"select stype,yuliu2,yuliu3,(select count(ypfjid) from sys_ypfj where stype=ypfj.stype) zts,(select count(ypfjid) from sys_ypfj where stype=ypfj.stype and yuliu1='yes') ppcgts ,(select count(ypfjid) from sys_ypfj where stype=ypfj.stype and ypfjstart='1') ypfjs,yuliu4 from sys_ypfj  ypfj group by stype,yuliu2,yuliu3,yuliu4 having yuliu2='"+id+"' order by yuliu3 desc ");
		if(!Util.isVoNull(v)){
			request.setAttribute("totalCount",v.getPageCount());
			request.setAttribute("list",v.getList());
		}
		return mapping.findForward("hisypfj");
	}
	
	/**
	 * 一票否决修改前的查看
	 */
	public ActionForward updateInfoYpfj(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String id=request.getParameter("id");
		Vo v=service.getHQL(" from Ypfjzhu where ypfjzhuid='"+id+"'");
		if(!Util.isVoNull(v)){
			Ypfjzhu zhu=(Ypfjzhu)v.getList().get(0);
			request.setAttribute("zhu", zhu);
		}
		String sjdr=request.getParameter("sjdr");
		if(!Util.isNull(sjdr)){
			return mapping.findForward("sjdr");
		}else{
			return mapping.findForward("addUpdypfj");
		}
	}
	/**
	 * 一票否决修改前的子表的值
	 */
	public ActionForward updateInfoYpfj_zbval(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String id=request.getParameter("id");
		Vo v=service.getSQL(" select zbval.ypfjzbvalid,zbval.fiedid,zbval.contstyle,zbval.val_1,zbval.val_2,zb.tableid,zb.bmid,(select count(v.ypfjzbvalid) from Sys_ypfjzbVal v where v.yuliu1=zb.ypfjzbid) sl ,ou.ouname ou_name,ta.cname ta_name,fie.cname fie_name  from Sys_ypfjzbVal zbval"+
							"	left join ypfjzb zb on zb.ypfjzbid=zbval.yuliu1"+
							"	left join sys_field fie on fie.fieldid=zbval.fiedid"+
							"	left join sys_table ta on ta.tableid=zb.tableid"+
							"	left join sys_oulist ou on ou.ouid=zb.bmid"+
							"	where zb.yuliu1='"+id+"'"+
							"	order by zb.yuliu2,zbval.yuliu2");
		Util.responseResult4Json(response,Util.ObjecttoJsonString(Util.return_JSON(new String[]{"ypfjzbvalid","fiedid","contstyle","val_1","val_2","tableid","bmid","sl","bmname","tabname","fiename"}, v)));	
		return null;
	}	
	/**
	 * 添加或修改一票否决模板
	 */
	public ActionForward updateOraddypfjmb(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String sjlx=request.getParameter("sjlx");//数据类型
		String[] contstyle=request.getParameterValues("contstyle");//值类型  时间 ：teim_1  time_2  time_3   time_>   time_<   time_>=   time_<=   time_null(自定义)
		String[] bm=request.getParameterValues("bm"); //部门
		String[] tab=request.getParameterValues("tab");//表
		String[] fid=request.getParameterValues("fid");//字段
		String[] val_1=request.getParameterValues("val_1");//值1
		String[] val_2=request.getParameterValues("val_2");//值2
		String[] fid_number=request.getParameterValues("fid_number");//值的数量
		
		//主表
		String ypfjzhuid=request.getParameter("ypfjzhuid");
		Ypfjzhu zhu=new Ypfjzhu();
		zhu.setYuliu1(request.getParameter("yuliu1"));
		zhu.setStyle(sjlx);
		if(!Util.isNull(ypfjzhuid)){//修改
			zhu.setYpfjzhuid(ypfjzhuid);
			zhu.setPztime(request.getParameter("pztime"));
			zhu.setDepid(request.getParameter("depid"));
			service.update(zhu);
		}else{//添加
			zhu.setYpfjzhuid(Util.returnid(5));
			zhu.setPztime(Util.getDate("yyyy-MM-dd HH:mm:ss"));
			zhu.setDepid(LoginUserInfoDelegate.getOuidFromRequest(request));
			service.add(zhu);
		}
		//子表 
		 //先删除子表数据
		 service.exedeleteSQL(" delete Sys_ypfjzbVal where yuliu1 in (select ypfjzbid from ypfjzb where yuliu1='"+zhu.getYpfjzhuid()+"')");
		 service.exedeleteSQL(" delete ypfjzb where yuliu1='"+zhu.getYpfjzhuid()+"' ");
		 //再添加所有配置项
		 int fid_temp_r=0;
		 if(null!=bm && bm.length>0){
			 for (int i = 0; i <bm.length; i++) {
				 Ypfjzb zb=new Ypfjzb();
				 zb.setYpfjzbid(Util.returnid(5));
				 zb.setYuliu1(zhu.getYpfjzhuid());
				 zb.setBmid(bm[i]);
				 zb.setTableid(tab[i]);
				 zb.setYuliu2(i+"");
				 if(null!=fid_number && fid_number.length>0 && null!=fid_number[i] && !Util.isNumber(fid_number[i])){
					 int fid_n=Integer.parseInt(fid_number[i]);
					 for (int j = 0; j <fid_n; j++) {
						 Ypfjzbval zbval=new Ypfjzbval();
						 zbval.setYpfjzbvalid(Util.returnid(5));
						 zbval.setFiedid(fid[fid_temp_r]);
						 zbval.setYuliu1(zb.getYpfjzbid());
						 zbval.setYuliu2(j+"");
						 if(null!=contstyle && fid_temp_r<contstyle.length){
							 zbval.setContstyle(contstyle[fid_temp_r]);
						 }
						 if(null!=contstyle && fid_temp_r<val_1.length){
							 zbval.setVal_1(val_1[fid_temp_r]);
						 }if(null!=contstyle && fid_temp_r<val_2.length){
							 zbval.setVal_2(val_2[fid_temp_r]);
						 }
						 service.add(zbval);
						 fid_temp_r++;
					}
				 }
				 
				 service.add(zb);
			 }
		 }
		return new ActionForward("/ysjgl.do?dispatch=getypfjMb");//查询列表
	}

	public ActionForward deleteypfj(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		//主表id
		String ypfjzhuid=request.getParameter("ypfjzhuid");
		 //先删除子表数据
		 service.exedeleteSQL(" delete Sys_ypfjzbVal where yuliu1 in (select ypfjzbid from ypfjzb where yuliu1='"+ypfjzhuid+"')");
		 service.exedeleteSQL(" delete ypfjzb where yuliu1='"+ypfjzhuid+"' ");
		 //主表 
		 service.exedeleteSQL(" delete ypfjzhu where ypfjzhuid='"+ypfjzhuid+"' ");
		return new ActionForward("/ysjgl.do?dispatch=getypfjMb");//查询列表
	}	
	/**
	 * 解析excel， 查询是否为一票否决,并绑定数据
	 */
	public ActionForward getqy(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String style=request.getParameter("style");
		try {
			String basePath =request.getRealPath("../");
			String ypfjzhuid=request.getParameter("ypfjzhuid");
			HashMap<String, String> hash=Util.upfile(form, request, response, Util.returnid(5));
			List<String> list=getqy(basePath+hash.get("file_name"));
			
			//处理sql语句
			String sql=" ";
			String str_tempQyid=Util.returnid(8);
			Vo zv=service.getHQL(" from Ypfjzb where yuliu1='"+ypfjzhuid+"'");
			if(null!=list && list.size()>0 && !Util.isVoNull(zv)){
				for (int i = 0; i < zv.getList().size(); i++) {
					Ypfjzb tempzb=(Ypfjzb) zv.getList().get(i);
					Vo temp_tablename=service.getSQL(" select tableid,ename from sys_table where tableid =(select tableid from ypfjzb  y where y.ypfjzbid='"+tempzb.getYpfjzbid()+"')  ");
					if(!Util.isVoNull(temp_tablename)){
						Object[] tabnamearr=(Object[])temp_tablename.getList().get(0);
						//筛选
						sql+=" select  count(*) s from "+tabnamearr[1]+" where 1=1 ";
						Vo temp_fiedename=service.getSQL("select fieldid,ename,contstyle,val_1,val_2 from sys_field  fie right join Sys_ypfjzbVal va  on fie.fieldid=va.fiedid where va.yuliu1='"+tempzb.getYpfjzbid()+"' ");
						if(!Util.isVoNull(temp_fiedename)){
							for(int k=0;k<temp_fiedename.getList().size();k++){
								Object[] fiednamearr=(Object[])temp_fiedename.getList().get(k);
								if(null!=fiednamearr && null!=fiednamearr[1] && null!=fiednamearr[2] && !Util.isNull(fiednamearr[1].toString()) && !Util.isNull(fiednamearr[2].toString())){
									if(fiednamearr[2].equals("time_1")){
										sql+=" and  to_char("+fiednamearr[1]+",'yyyy-MM-dd')  >='"+Util.tcNyearTime(1)+"' and   to_char("+fiednamearr[1]+",'yyyy-MM-dd') <= '"+Util.getDate("")+"' ";
									}else if(fiednamearr[2].equals("time_2")){
										sql+=" and   to_char("+fiednamearr[1]+",'yyyy-MM-dd') >='"+Util.tcNyearTime(2)+"' and   to_char("+fiednamearr[1]+",'yyyy-MM-dd') <= '"+Util.getDate("")+"' ";
									}else if(fiednamearr[2].equals("time_3")){
										sql+=" and   to_char("+fiednamearr[1]+",'yyyy-MM-dd') >='"+Util.tcNyearTime(3)+"' and   to_char("+fiednamearr[1]+",'yyyy-MM-dd') <= '"+Util.getDate("")+"' ";
									}
									
									else if(fiednamearr[2].equals("time_>")&& null!=fiednamearr[3] && !Util.isNull(fiednamearr[3].toString())){//大于N年：数据库查询N年以前的数据
										sql+=" and   to_char("+fiednamearr[1]+",'yyyy') <'"+Util.tcNyearTime(Integer.parseInt(fiednamearr[3].toString()),"yyyy")+"'  ";
									}else if(fiednamearr[2].equals("time_<")&& null!=fiednamearr[3] && !Util.isNull(fiednamearr[3].toString())){//小于N年：数据库查询N年以后的数据
										sql+=" and   to_char("+fiednamearr[1]+",'yyyy') >'"+Util.tcNyearTime(Integer.parseInt(fiednamearr[3].toString()),"yyyy")+"'  ";
									}else if(fiednamearr[2].equals("time_1>=")&& null!=fiednamearr[3] && !Util.isNull(fiednamearr[3].toString())){
										sql+=" and   to_char("+fiednamearr[1]+",'yyyy')>='"+Util.tcNyearTime(Integer.parseInt(fiednamearr[3].toString()),"yyyy")+"'  ";
									}else if(fiednamearr[2].equals("time_1<=")&& null!=fiednamearr[3] && !Util.isNull(fiednamearr[3].toString())){
										sql+=" and   to_char("+fiednamearr[1]+",'yyyy') <='"+Util.tcNyearTime(Integer.parseInt(fiednamearr[3].toString()),"yyyy")+"'  ";
									}
									
									else if(fiednamearr[2].equals("time_null")){
										if(null!=fiednamearr[3] && !Util.isNull(fiednamearr[3].toString())){
											sql+=" and   to_char("+fiednamearr[1]+",'yyyy-MM-dd') >='"+fiednamearr[3].toString()+"' ";
										}	
										if(null!=fiednamearr[4] && !Util.isNull(fiednamearr[4].toString())){
											sql+=" and   to_char("+fiednamearr[1]+",'yyyy-MM-dd') <='"+fiednamearr[4].toString()+"' ";
										}
									}else if(fiednamearr[2].equals("string")){
										if(null!=fiednamearr[3] && !Util.isNull(fiednamearr[3].toString())  && fiednamearr[3].toString().equals("jq") && null!=fiednamearr[4] && !Util.isNull(fiednamearr[4].toString())){
											sql+=" and "+fiednamearr[1]+" ='"+fiednamearr[4]+"' ";
										}if(null!=fiednamearr[3] && !Util.isNull(fiednamearr[3].toString())  && fiednamearr[3].toString().equals("mh") && null!=fiednamearr[4] && !Util.isNull(fiednamearr[4].toString())){
											sql+=" and "+fiednamearr[1]+" like '%"+fiednamearr[4]+"%'";
										}
									}else if(fiednamearr[2].equals("number")){
										if(null!=fiednamearr[3] && !Util.isNumber(fiednamearr[3].toString())){
											sql+=" and "+fiednamearr[1]+" >="+fiednamearr[3];
										}if(null!=fiednamearr[4] && !Util.isNumber(fiednamearr[4].toString())){
											sql+=" and "+fiednamearr[1]+" <="+fiednamearr[4];
										}
									}else if(fiednamearr[2].equals("code") &&  null!=fiednamearr[3] && !Util.isNull(fiednamearr[3].toString()) && null!=fiednamearr[4] && !Util.isNull(fiednamearr[4].toString())){
										if(fiednamearr[4].toString().indexOf("','")>=0){
											sql+=" and  "+fiednamearr[1]+" in ( "+fiednamearr[4]+")";
										}else{
											sql+=" and "+fiednamearr[1]+"="+fiednamearr[4]+"";
										}	
										//Vo temp_codeename=service.getSQL("select code,code_type_name from code_table where 1=1  "+tp_sql+" and code_type='"+fiednamearr[3]+"' ");
										//if(!Util.isVoNull(temp_codeename)){
										//	Object[] codenamearr=(Object[])temp_codeename.getList().get(0);
										//	sql+=" and "+fiednamearr[1]+" ='"+codenamearr[1]+"' ";
										//}
									}
									
								}
							}
						}
						
					}
					if(!Util.isNull(style) && style.equals("0")){
						sql+=" and  enterprise_id='"+str_tempQyid+"'";//预留企业id接口
					}else{
						sql+=" and  personal_id='"+str_tempQyid+"'";//预留个人id接口
					}
					if(i<zv.getList().size()-1){
						sql+=" union ";
					}
				}
				System.out.println("一票否决筛选的sql："+sql);
			}
			
			//查询数据
			if(null!=list && list.size()>0){
				String stype=Util.returnid(5);
				String pptime=Util.getDate("yyyy-MM-dd HH:mm:ss");
				for (int i = 0; i < list.size(); i++) {
					Object[] arr=new Object[3];//分别保存：企业id，企业名称，组织机构代码，一票否决,匹配结果
					//匹配企业
					String cxsql="";
					if(!Util.isNull(style) && style.equals("0")){
						cxsql=" select enterprise_id, qymc, zzjgdm,'' ypfj ,'' sfcg  from hzcx_qy_base qy where qymc='"+list.get(i).trim()+"'";
					}else{
						cxsql=" select personal_id, xm, sfzhm,'' ypfj ,'' sfcg  from hzcx_gr_base gr where xm='"+list.get(i).trim()+"'";
					}
					Vo v_obj=service.getSQL(cxsql);
					if(null==v_obj || v_obj.getPageCount()==0 || null==v_obj.getList() || v_obj.getList().size()<=0){
						arr=new String[]{"",list.get(i).trim(),"","0","no"};
					}else{
						arr=(Object[])v_obj.getList().get(0);
						arr[3]="0";
						arr[4]="yes";
						//查询是否一票否决
						Vo v_ypfj=service.getSQL(" select sum(s) s,'' tempval from ( "+sql.replaceAll(str_tempQyid,arr[0].toString())+" ) temp_table");
						if(!Util.isVoNull(v_ypfj)){
							Object[] ypfjarrobj=(Object[])v_ypfj.getList().get(0);
							if(null!=ypfjarrobj && !Util.isNumber(ypfjarrobj[0].toString())){
								if(Integer.parseInt(ypfjarrobj[0].toString())>0){
									arr[3]="1";
								}
							}
						}
					}
					 //保存
					 Sysypfj ypfj=new Sysypfj();
					 ypfj.setYpfjid(Util.returnid(5));
					 ypfj.setQyid(arr[0].toString());
					 ypfj.setQyname(arr[1].toString());
					 ypfj.setZzjgdm(arr[2].toString());
					 ypfj.setYpfjstart(arr[3].toString());
					 ypfj.setYuliu1(arr[4].toString());//是否匹配成功
					 ypfj.setStype(stype);//下次根据此id可查询所有数据
					 ypfj.setYuliu2(ypfjzhuid);//模板id：查询历史匹配记录是根据模板id查询
					 ypfj.setYuliu3(pptime);//匹配时间
					 ypfj.setYuliu4(style);//类型 ：0企业，1个人
					 service.add(ypfj);
				}
				request.setAttribute("stype",stype);
				request.setAttribute("style",style);
				return new ActionForward("/ysjgl.do?dispatch=getypfj&type="+stype+"&style="+style);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("stype",Util.returnid(5));
		request.setAttribute("style",style);
		return new ActionForward("/ysjgl.do?dispatch=getypfj&type="+Util.returnid(5)+"&style="+style);
	}
	/**
	 * 读取企业
	 */
	public List<String> getqy(String fileurl) throws FileNotFoundException, IOException{
		File file = new File(fileurl);
	    List list=new ArrayList();list.add(0);//要跳过的行
	    List list2=new ArrayList();list2.add(0);//要查询的列
	    if(fileurl.endsWith(".xlsx")){//2007
	    	ReadExcel2007 parser3 = new ReadExcel2007(file,list2,list);
		    return parser3.getDatasInSheet(0);
	    }else if(fileurl.endsWith(".xls")){//2003
	    	ReadExcel2003 parser3 = new ReadExcel2003(file,list2,list);
		    return parser3.getDatasInSheet(0);
	    }else{
	    	return new ArrayList<String>();
	    }
	}
	/**
	 * 查询excel中的数据(保存在Sysypfj表， 以stype区分) 
	 */
	public ActionForward getypfj(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String type=request.getParameter("type");
		String qyname=request.getParameter("qyname");
		String zzjgdm=request.getParameter("zzjgdm");
		String sfypcx=request.getParameter("sfypcx");
		String daocu=request.getParameter("daocu");
		//导出
		if(!Util.isNull(daocu)){
			String sql="select qyname,zzjgdm, CASE   WHEN ypfjstart=1 THEN '是' WHEN ypfjstart=0 THEN '否' END as ypfjstart, CASE   WHEN yuliu1='yes' THEN '是' WHEN yuliu1='no' THEN '否' END as yuliu1  from sys_ypfj where stype='"+type+"' ";
			if(!Util.isNull(qyname)){
				sql+=" and qyname like '%"+qyname+"%'";
			}if(!Util.isNull(zzjgdm)){
				sql+=" and zzjgdm like '%"+zzjgdm+"%'";
			}if(!Util.isNull(sfypcx)){
				sql+=" and ypfjstart ='"+sfypcx+"'";
			}
			Vo v=service.getSQL(sql);
    	    String filepath=request.getRealPath("file")+File.separator+"temp_xls"+File.separator+Util.returnid(5);//文件地址
			v.getList().add(0,new String[]{"企业名称","组织机构代码","是否一票否决","是否匹配成功"});
			NewExcel2003.initExcel(v.getList(), filepath, "企业一票否决信息.xls");
    	    Util.downFile(response, filepath+File.separator+"企业一票否决信息.xls");//文件下载
		}else{
			int pageNo = PageFindUtil.getPageNo(request);
			int pageSize = PageFindUtil.getPageSize(request,10);
			//查询
			String hql=" from Sysypfj where stype='"+type+"' ";
			if(!Util.isNull(qyname)){
				hql+=" and qyname like '%"+qyname+"%'";
				request.setAttribute("qyname", qyname);
			}if(!Util.isNull(zzjgdm)){
				hql+=" and zzjgdm like '%"+zzjgdm+"%'";
				request.setAttribute("zzjgdm", zzjgdm);
			}if(!Util.isNull(sfypcx)){
				hql+=" and ypfjstart ='"+sfypcx+"'";
				request.setAttribute("sfypcx", sfypcx);
			}
			Vo v=service.getHQL(pageNo,pageSize,hql);
			request.setAttribute("totalCount",v.getPageCount());
			request.setAttribute("list", v.getList());
			request.setAttribute("stype", type);
			request.setAttribute("style", request.getParameter("style"));
			return mapping.findForward("qycx");
		}
		return null;
	}
	/**********************************************************************************/
	
	/**
	 * 查询数据导出
	 */

	public ActionForward getimprolist(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		int pageNo = PageFindUtil.getPageNo(request);
		int pageSize = PageFindUtil.getPageSize(request,10);
		Vo v=service.getHQL(pageNo,pageSize," from ImproTable where 1=1 order by dctime desc ");
		request.setAttribute("totalCount",v.getPageCount());
		request.setAttribute("list", v.getList());
		return mapping.findForward("improList");
	}
	/**
	 * 数据导出
	 */
	public ActionForward pathimpro(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		
		//导出数据
		int bmNumber=0,tabNumber=0,fiedNumber=0;//结果统计
		String zongfiel=request.getRealPath("file")+File.separator+"improPath"+File.separator+Util.returnid(5);
		//查询部门
		Vo bmv=service.getSQL(" select  ouid,ouname from sys_oulist t where 1=1 ");
		if(!Util.isVoNull(bmv)){
			for (int i = 0; i < bmv.getList().size(); i++) {
				Object[] bmobj=(Object[])bmv.getList().get(i);
				//查询部门下的表：参数：等级A,类型为表，数据库状态已建,部门id
				Vo tabv=service.getHQL(" from Systable where kfdj='A' and lx='table' and sfcj='1' and depid='"+bmobj[0]+"'");
				if(!Util.isVoNull(tabv)){
					//查询表下的字段:参数：等级A，表名
					for (int j = 0; j <tabv.getList().size(); j++) {
						Systable tabobj=(Systable)tabv.getList().get(j);
						Vo fiedv=service.getHQL(" from Sysfield  where fiekfdj='A' and tableid='"+tabobj.getTableid()+"' order by gjxx  ");
						if(!Util.isVoNull(fiedv)){
							//字段等级为A并且不为空的数据开始进行导出:拼接字段
							String queryfied="";//列明
							String[] fiedTitle=null;
							if(fiedv.getList().size()==1){
								fiedTitle=new String[2];//列中文名
							}else{
								fiedTitle=new String[fiedv.getList().size()];//列中文名
							}
							for (int k = 0; k <fiedv.getList().size(); k++) {
								Sysfield fiedobj=(Sysfield)fiedv.getList().get(k);
								//查询当前部门下  当前表结构是数据 字段为fiedobj的数据
								queryfied+=fiedobj.getEname();
								fiedTitle[k]=fiedobj.getCname();
								if(k<fiedv.getList().size()-1){
									queryfied+=",";
								}
							}
							//如果查询结果只有一列， 那再手动加一个为空的列， 保证查询时返回的是一个list
							if(fiedv.getList().size()==1){
								queryfied+=",' ' ";
							}
							String sqlexq="select "+queryfied+" from "+tabobj.getEname();//最后得出的sql语句
							Vo queryv=service.getSQL(sqlexq);
							queryv.getList().add(0,fiedTitle);//把标题加入list的第一个
							//生成文件  并统计
							if(fiedv.getList().size()>0){
								if(j==0){
									bmNumber++;//统计部门数量
									tabNumber+=tabv.getList().size();//统计表数量
								}
								fiedNumber+=queryv.getPageCount();//统计数据条数
								//生成xls文件
					    	    String filepath=zongfiel+File.separator+bmobj[1];//文件地址:file/improPath/当前时间+5位随机数/当前部门名称
								//NewCsv.initExcel(queryv.getList(), filepath, tabobj.getCname()+".csv");//创建，写入，生成文件
								NewExcel2007.initExcel(queryv.getList(), filepath, tabobj.getCname()+".xlsx");//创建，写入，生成文件
							}
						}
					}
				}
			}
		}
		
		//导出结构
		//企业
		String sql="select ou.ouname ou_ouname, ta.cname ta_cname,ta.ename ta_ename,fied.cname fied_cname,fied.ename fied_ename from sys_field fied "+
						" left join sys_table ta on fied.tableid=ta.tableid"+
						" left join sys_oulist ou on ou.ouid=ta.depid"+
						" where fied.fiekfdj='A' and ta.kfdj='A' and ta.lx='table' ";
		Vo sql_val_qy=service.getSQL(sql+"  and ta.sjlx in ('0','2') ");
		sql_val_qy.getList().add(0,new String[]{"部门名称","表中文名","表英文名","字段中文名","字段英文名"});
		//NewCsv.initExcel(sql_val_qy.getList(), zongfiel,"企业.csv");//创建，写入，生成文件
		NewExcel2007.initExcel(sql_val_qy.getList(), zongfiel,"企业.xlsx");//创建，写入，生成文件
		
	    //个人
		Vo sql_val_gr=service.getSQL(sql+"  and ta.sjlx in ('1','2','3') ");
		sql_val_gr.getList().add(0,new String[]{"部门名称","表中文名","表英文名","字段中文名","字段英文名"});
		//NewCsv.initExcel(sql_val_gr.getList(), zongfiel,"个人.csv");//创建，写入，生成文件
		NewExcel2007.initExcel(sql_val_gr.getList(), zongfiel,"个人.xlsx");//创建，写入，生成文件
	    
		//生成zip文件
		String zipUrl=zongfiel+".zip";
		 NewZip.zip(zongfiel,zipUrl);
		//添加导出记录
	    addimpro(zipUrl.substring(zipUrl.indexOf(File.separator+"web"+File.separator)));
		
		//统计
		String tj="";
		if(tabNumber==0){
			tj="导出成功!";
		}else{
    	    //计算结果
    	    tj="导出成功!\r\n共："+bmNumber+" 个部门";
    	    tj+="\r\n      "+tabNumber+" 张数据表";
			if(tabNumber!=0){
				tj+="\r\n      "+fiedNumber+" 条数据";
			}
		}
		List tempList=new ArrayList();tempList.add(tj);Vo tempv=new Vo();tempv.setList(tempList);tempv.setPageCount(tempList.size());
		Util.responseResult4Json(response,Util.ObjecttoJsonString(new SetJsonObject(tempv)));
		return null;
	}
	
	/**
	 * 添加导出记录
	 */
	public void addimpro(String zipUrl){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		ImproTable impta=new ImproTable();
		impta.setImprotable(Util.returnid(5));
		impta.setDctime(Util.getDate("yyyy-MM-dd HH:mm:ss"));
		impta.setYsurl(zipUrl);
		service.add(impta);
	}
	/********************************************************************************************************************/
	/**
	 * 查看日志信息
	 */
	public ActionForward getloglist(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String tableid=request.getParameter("tableid");
		String style=request.getParameter("style");
		String bmsel=request.getParameter("bmsel");
		String sql="select log_id,log_user,u.sn,log_tableid,ta.cname,log_sun_size,log_replay_size,log_upload_size,TO_CHAR(log_time,'yyyy-MM-dd HH:mm:ss') time_gs,bdcgs,bdsbs  from t_upload_logs t left join sys_user u on u.cn=t.log_user left join sys_table ta on ta.tableid=t.log_tableid where 1=1 ";
		if(!Util.isNull(style)){
			sql+=" and log_tableid = '"+tableid+"' ";
			request.setAttribute("style",style);
			request.setAttribute("tableid",tableid);
		}if(!Util.isNull(bmsel)){
			sql+="  and ta.depid= '"+bmsel+"' ";
			request.setAttribute("bmsel",bmsel);
		}
		sql+=" order by log_time desc ";
		int pageNo = PageFindUtil.getPageNo(request);
		int pageSize = PageFindUtil.getPageSize(request,10);
		Vo v=service.getSQL(pageNo, pageSize, sql);
		request.setAttribute("totalCount",v.getPageCount());
		request.setAttribute("list",v.getList());
		
		//查询部门下拉框
		String sql2=" select  ouid,ouname from sys_oulist t where 1=1 ";
		sql2+=" order by t.displayorder ";
		Vo v2 =service.getSQL(sql2);
		request.setAttribute("bmlist",v2.getList());
		
		return mapping.findForward("log_list");
	}
	
	/**
	 * 信用档案
	 */
	public ActionForward getqy_xyda(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String qymc=request.getParameter("qymc");
		String zzjgdm=request.getParameter("zzjgdm");
		String frdbxm=request.getParameter("frdbxm");
		String sql=" select qybs_id,enterprise_id,replace(qymc,'杭州','浦东') as qymc,zzjgdm,gszch,frdbxm from hzcx_qy_base t   where 1=1 ";
		String sql2="select count(*) count , 's' s  from hzcx_qy_base t   where 1=1 ";
		if(!Util.isNull(qymc)){
			sql+=" and qymc like '%"+qymc+"%' ";
			sql2+=" and qymc like '%"+qymc+"%' ";
			request.setAttribute("qymc",qymc);
		}if(!Util.isNull(zzjgdm)){
			sql+=" and zzjgdm like '%"+zzjgdm+"%' ";
			sql2+=" and zzjgdm like '%"+zzjgdm+"%' ";
			request.setAttribute("zzjgdm",zzjgdm);
		}if(!Util.isNull(frdbxm)){
			sql+=" and frdbxm like '%"+frdbxm+"%' ";
			sql2+=" and frdbxm like '%"+frdbxm+"%' ";
			request.setAttribute("frdbxm",frdbxm);
		}
		sql+=" order by enterprise_id desc ";
		int pageNo = PageFindUtil.getPageNo(request);
		int pageSize = PageFindUtil.getPageSize(request,10);
		Vo v=service.getSQL_2(1, 1, sql);
		//查询总条数
		Vo vcou=service.getSQL(sql2);
		if(!Util.isVoNull(vcou)){
			Object[] objcount=(Object[])vcou.getList().get(0);
			if(null!=objcount[0]){
				v.setPageCount(Integer.parseInt(objcount[0].toString()));
			}
		}
		
		request.setAttribute("totalCount",v.getPageCount());
		request.setAttribute("list",v.getList());
		return mapping.findForward("qy_list");
	}
	/**
	 * 个人信用档案 
	 */
	public ActionForward getgr_xyda(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String qymc=request.getParameter("qymc");
		String zzjgdm=request.getParameter("zzjgdm");
		String sql=" select gebs_id,personal_id,xm,sfzhm from hzcx_gr_base t   where 1=1 ";
		String sql2="select count(*) count , 's' s  from hzcx_gr_base t   where 1=1 ";
		if(!Util.isNull(qymc)){
			sql+=" and xm like '%"+qymc+"%' ";
			sql2+=" and xm like '%"+qymc+"%' ";
			request.setAttribute("qymc",qymc);
		}if(!Util.isNull(zzjgdm)){
			sql+=" and sfzhm like '%"+zzjgdm+"%' ";
			sql2+=" and sfzhm like '%"+zzjgdm+"%' ";
			request.setAttribute("zzjgdm",zzjgdm);
		}
		sql+="";
		int pageNo = PageFindUtil.getPageNo(request);
		int pageSize = PageFindUtil.getPageSize(request,10);
		Vo v=service.getSQL_2(pageNo, pageSize, sql);
		//查询总条数
		Vo vcou=service.getSQL(sql2);
		if(!Util.isVoNull(vcou)){
			Object[] objcount=(Object[])vcou.getList().get(0);
			if(null!=objcount[0]){
				v.setPageCount(Integer.parseInt(objcount[0].toString()));
			}
		}
		
		request.setAttribute("totalCount",v.getPageCount());
		request.setAttribute("list",v.getList());
		return mapping.findForward("gr_list");
	}
	

	/**
	 * 查询字典表 
	 */
	public ActionForward getzd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String  querystyle=request.getParameter("querystyle");//查询类型：ajax查询返回null， 其他的返回指定结果
		String style=request.getParameter("style");//类型	
		String ssyw=request.getParameter("ssyw");//所属业务菜单
		int pageNo = PageFindUtil.getPageNo(request);
		int pageSize = PageFindUtil.getPageSize(request,10);
		String sql="select zdid,zdname, CASE   WHEN ssyw!='0'  THEN (select zdname from sys_zd where zdid=zd.ssyw) WHEN ssyw=0 THEN '' END ssyw ,px,zdstyle,yuliu1,yuliu2,yuliu3 from sys_zd zd where 1=1 ";
		if(!Util.isNull(style)){
			sql+=" and zdstyle='"+style+"' ";
			request.setAttribute("style", style);
		}if(!Util.isNull(ssyw)){
			sql+=" and ssyw='"+ssyw+"' ";
			request.setAttribute("ssyw", ssyw);
		}else {
			sql+=" and (ssyw='' or ssyw is null or ssyw = null)";
		}
		sql+="  order by zdstyle asc ,px+0 desc ";
		if(null!=querystyle && "ajax".equals(querystyle)){
			Vo v=service.getSQL(sql);
			Util.responseResult4Json(response,Util.ObjecttoJsonString(new SetJsonObject(v)));
			return null;
		}else{
			Vo v=service.getSQL(pageNo, pageSize,sql);
			request.setAttribute("list", v.getList());
			request.setAttribute("totalCount",v.getPageCount());
			return mapping.findForward("zdlist");
		}
		
	}
	
	/**
	 * 修改前的查看
	 */
	public ActionForward getinfo_zd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String style=request.getParameter("style");
		Vo v=service.getHQL(" from SysZd where zdid='"+request.getParameter("zdid")+"'");
		if(!Util.isNull(style) && style.equals("ajax")){
			Util.responseResult4Json(response,Util.ObjecttoJsonString(new SetJsonObject(v)));
			return null;
		}else{
			if(!Util.isVoNull(v)){
				SysZd zd=(SysZd)v.getList().get(0);
				request.setAttribute("zd",zd);
			}
			return mapping.findForward("addzd");
		}
	}
	/**
	 *添加或修改字典 
	 */
	public ActionForward zdupdateOradd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		YsjglForm ysjf=(YsjglForm)form;
		SysZd zd=ysjf.getZd();
		zd.setSsyw(request.getParameter("zd_ssyw_select"));
		String[] yuliu1_arr=request.getParameterValues("zd_yuliu1");
		String temp_yuliu1="";
		if(null!=yuliu1_arr && yuliu1_arr.length>0){
			for (int i = 0; i < yuliu1_arr.length; i++) {
				temp_yuliu1+=yuliu1_arr[i];
				if(i<yuliu1_arr.length-1){
					temp_yuliu1+=",";
				}
			}
		}
		zd.setYuliu1(temp_yuliu1);
		if(Util.isNull(zd.getZdid())){
			zd.setZdid(Util.returnid(5));
			service.add(zd);
		}else{
			service.update(zd);
		}
		return mapping.findForward("zdlist");
	}
	
	/**
	 * 查询字典表的菜单
	 */
	public ActionForward getzdCaid(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		String sscd=request.getParameter("sscd");//所属菜单， 为空就查询一级菜单
		String style=request.getParameter("style");//菜单类型 ywlb:业务类别
		String zdid=request.getParameter("zdid");//需要排除的字典id
		String zhibOrtable=request.getParameter("zhibOrtable");//查询指标或表
		String hql=" from SysZd where zdstyle='"+style+"' ";
		if(!Util.isNull(sscd)){
			hql+=" and ssyw='"+sscd+"'";
		}else {
			hql+=" and (ssyw='' or ssyw is null or ssyw = null)";
		}
		if(!Util.isNull(zhibOrtable)){
			hql+=" and yuliu1 like '%"+zhibOrtable+"%' ";
		}
		if(!Util.isNull(zdid)){
			hql+=" and zdid != '"+zdid+"'";
		}
		hql+=" order by px+0 ";
		Vo v=service.getHQL(hql);
		Util.responseResult4Json(response, Util.ObjecttoJsonString(new SetJsonObject(v)));
		return null;
	}

	/**
	 *查询企业信息 
	 */
	public ActionForward getqybyid(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		Vo v=service.getSQL(" select  enterprise_id,qymc,gsnm,zzjgdm,frdbxm  from hzcx_qy_base qy where enterprise_id='"+request.getParameter("enterprise_id")+"' ");
		Util.responseResult4Json(response, Util.ObjecttoJsonString(new SetJsonObject(v)));
		return null;
	}
	/**
	 *查询个人信息 
	 */
	public ActionForward getgrbyid(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		YsjglService service=(YsjglService) this.getBean(SERVICENAME);
		Vo v=service.getSQL(" select  gebs_id,xm,sfzhm  from hzcx_gr_base gr where personal_id='"+request.getParameter("personal_id")+"' ");
		Util.responseResult4Json(response, Util.ObjecttoJsonString(new SetJsonObject(v)));
		return null;
	}
	
	
	/**
	 * 生成静态信用档案
	 */
	public ActionForward jthtml(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		String contextDiv=request.getParameter("contextDiv");
		String id=request.getParameter("jt_id");
		String name=request.getParameter("jt_name");
		String savetype=request.getParameter("savetype");//0无水印，1有水印

		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		String url=this.getServlet().getServletContext().getRealPath("/file/html/");
		NewJsplUtileTools.NewFileHtml(url, name+"["+id+"]_"+Util.getDate("yyyy_MM_dd HHmmssSS"), contextDiv,basePath,savetype);
		return null;
	}
	
	
	/**
	 * 查询视图是否存在
	 */
		public ActionForward viewSfcz(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
			YsjglService service=(YsjglService) this.getBean(SERVICENAME);
			Vo v=service.getSQL("SELECT c.table_name,c.column_name,c.data_type,c.data_length  FROM user_tab_cols c left join user_objects u on u.object_name=c.table_name   WHERE c.table_name='"+request.getParameter("viewname")+"' and u.object_type='VIEW' ");
			if(Util.isVoNull(v)){
				Util.responseResult4Json(response, "1");//视图存在
				return null;
			}
			Vo v2=service.getSQL(" select tableid,cname from sys_table where lx='view' and ename='"+request.getParameter("viewname")+"' ");
			if(!Util.isVoNull(v2)){//视图已经存在于sys_table中  不能创建 
				Util.responseResult4Json(response, "2");//不能重复创建
				return null;
			}
			Util.responseResult4Json(response, "0");//可以创建
			return null;
		}
		
		
		/**************************************************** 分类分级配置  *************************************************************************/

		/**
		 * 添加或修改分类分级配置主表
		 */
		public ActionForward addOrUpdateflfjzb(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
			YsjglService service=(YsjglService) this.getBean(SERVICENAME);
			String[] checkbox_inputValue=request.getParameterValues("checkbox_inputValue");//被选中的值
			String[] checkbox_inputValue_qz=request.getParameterValues("checkbox_inputValue_qz");//被选中值的权重
			YsjglForm ysjf=(YsjglForm)form;
			//主表数据
			SysMxzb zb=ysjf.getMxzb(); 
			String zbid=zb.getMxzbid();
			boolean b=false;
			if(Util.isNull(zbid)){
				zbid=Util.returnid(5);
				zb.setMxzbid(zbid);
				zb.setTjsj(Util.getDate("yyyy-MM-dd HH:mm:ss"));
				b=service.add(zb);
			}else{
				b=service.update(zb);
			}
			//主表所对应的指标数据
			if(b){
				//删除原有的数据
				service.exedeleteSQL(" delete sys_mxzb_zbqz where mxzbid='"+zbid+"'");
				//添加新数据
				if(null!=checkbox_inputValue && checkbox_inputValue.length>0){
					for (int i = 0; i < checkbox_inputValue.length; i++) {
						SysMxzbQz qz=new SysMxzbQz();
						qz.setZbqzid(Util.returnid(8));
						qz.setMxzbid(zbid);
						qz.setXh(i+"");
						qz.setIndexid(checkbox_inputValue[i]);
						qz.setParamt1(checkbox_inputValue_qz[i]);
						service.add(qz);
					}
				}
			}
			return new ActionForward("/ysjgl.do?dispatch=getflfjList");
		}
		/**
		 * 查询
		 */
		public ActionForward getflfjList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
			YsjglService service=(YsjglService) this.getBean(SERVICENAME);
			String hql=" from SysMxzb where 1=1 ",forname="flfjlist";//默认查询所有
			String id=request.getParameter("id");
			if(!Util.isNull(id)){//修改前的查看
				hql+=" and mxzbid='"+id+"'";
				forname="flfjinfo";
				
				//得到指标的权重
				Vo qz=service.getSQL("select zbqzid,indexid,paramt1,ind.index_name from sys_mxzb_zbqz qz left join sys_index ind on qz.indexid=ind.index_id where qz.mxzbid='"+id+"' order by qz.xh+0 ");
				request.setAttribute("qzlist",qz.getList());
				
			}
			int pageNo = PageFindUtil.getPageNo(request);
			int pageSize = PageFindUtil.getPageSize(request,10);
			Vo v=service.getHQL(pageNo,pageSize,hql);
			request.setAttribute("list", v.getList());
			request.setAttribute("totalCount",v.getPageCount());
			return mapping.findForward(forname);
		}
		/**
		 * 分类分级配置中的指标
		 */
		public ActionForward getflfjzb(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
			YsjglService service=(YsjglService) this.getBean(SERVICENAME);
			String sql="select ind.index_id,ind.index_name,ind.index_type_code,ind.index_type_code2,ind.bm_id,ou.ouname,(select zd1.zdname from sys_zd zd1 where zd1.zdid=ind.index_type_code ) zd1name,(select zd1.zdname from sys_zd zd1 where zd1.zdid=ind.index_type_code2 ) zd2name,ind.index_view,' ' bzz ,ind.remark  from sys_index ind left join sys_oulist ou on ou.ouid=ind.bm_id where  state='1' " +
					"   and index_yt like '%3%' ";
			sql+="  order by ind.index_type_code,ind.index_type_code2,ind.sx ";
			Vo v=service.getSQL(sql);
			Util.responseResult4Json(response, Util.ObjecttoJsonString(new SetJsonObject(v)));
			return null;
		}

		/**
		 * 查询最大值和最小值
		 */
		public ActionForward getmaxmin(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
			YsjglService service=(YsjglService) this.getBean(SERVICENAME);
			String viewName=request.getParameter("name");
			Vo v=service.getSQL(" select max(RESULT) maxr ,min(RESULT) minr from "+viewName);
			Util.responseResult4Json(response, Util.ObjecttoJsonString(new SetJsonObject(v)));
			return null;
		}
		
		
}













