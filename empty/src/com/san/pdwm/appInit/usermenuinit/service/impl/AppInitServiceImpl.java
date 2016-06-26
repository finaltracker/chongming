package com.san.pdwm.appInit.usermenuinit.service.impl;


import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;



import com.san.pdwm.appInit.usermenuinit.dao.AppInitDao;
import com.san.pdwm.appInit.usermenuinit.model.ParentMenu;
import com.san.pdwm.appInit.usermenuinit.model.SecondMenu;
import com.san.pdwm.appInit.usermenuinit.model.ThirdMenu;
import com.san.pdwm.appInit.usermenuinit.service.AppInitService;
import com.san.share.pmi.LdapApplication;

public class AppInitServiceImpl implements AppInitService {

    
	private AppInitDao dao;
	
	public AppInitDao getDao() {
		return dao;
	}

	public void setDao(AppInitDao dao) {
		this.dao = dao;
	}
	
	//��ʼ���û�Ȩ�޲˵����
	public List initMenu(String userId) throws Exception {
		
           return getParentMenuInfo(userId);
	}


	
	
	
	
	
	
	//���һ���˵���Ϣ
	private List getParentMenuInfo(String userId) throws Exception{
		
		List parentMenuList = new ArrayList();
		
		StringBuffer hqlStr = new StringBuffer();
		hqlStr.append("select item.WorkflowName from  LADP_APPLICATION item ");
		hqlStr.append(" where item.Application_Id in (select item1.Application_Id  ");
		hqlStr.append(" from Sys_Appauthorize item1 where item1.Authto_Id = '" + userId +"')");
		hqlStr.append(" order by  item.order_id ");
		List  ladpAppList =  dao.getRsBySql(hqlStr.toString());
		Object ldapApp = null;
		ParentMenu parentMenu = null;
		
		try{
	        for(int i=0;i<ladpAppList.size();i++){
	        	ldapApp = ladpAppList.get(i);
	        	if(!isExist(ldapApp.toString(),parentMenuList,"parentObj"))
	        	{
		        	parentMenu = new ParentMenu();
		        	parentMenu.setParentName(ldapApp.toString());
		        	parentMenu.setSecondMenuSet(getSecondMenuInfo(parentMenu.getParentName(),userId));
		        	parentMenuList.add(parentMenu);
	        	}

	        }
	        return parentMenuList;
		}catch(NullPointerException ex){
			
			throw new Exception("NullPointerException . error address is getParentMenuInfo method");
		}
		catch(ArrayIndexOutOfBoundsException ex){
			
			throw new Exception("ArrayIndexOutOfBoundsException . error address is getParentMenuInfo method");
		}
		
       
	}
	
	
		

	private boolean isExist(Object obj,List objList,String objName) {
	
		   if(null == objList || objList.size() == 0) return false;
		   
	       String objV = obj.toString();
		   ParentMenu parentMenu = null;
		   SecondMenu secondMenu = null;
		   
		   for(int i=0;i<objList.size();i++){
			  if(objName.equals("parentObj"))
			  {
				  parentMenu = (ParentMenu)objList.get(i);
				  if(objV.equals(parentMenu.getParentName()))
				  {
					  return true;
				  }
			  }
			  else
			  {
				  secondMenu = (SecondMenu)objList.get(i);
				  if(objV.equals(secondMenu.getSecondMenuName()))
				  {
					  return true;
				  }
			  }

	   }
	   return false;
	}
	

	
	
	//��ö����˵���Ϣ
	private List getSecondMenuInfo(String menuName,String userId) throws Exception{
		
		List secondMenuSet = new ArrayList();
		
		StringBuffer hqlStr = new StringBuffer();
		hqlStr.append("select item.WorkflowName from LADP_APPLICATION item ");
		hqlStr.append(" where  item.Application_Id in (select item1.Application_Id  ");
		//��˵�ʹ��
		/*hqlStr.append(" where item.SubsystemName ='" + menuName + "' and item.Application_Id in (select item1.Application_Id  ");*/
		hqlStr.append(" from Sys_Appauthorize item1 where item1.Authto_Id = '" + userId +"')");
		hqlStr.append(" order by item.order_id");
		
		List  ladpAppList =  dao.getRsBySql(hqlStr.toString());

		Object ldapApp = null;
		SecondMenu secondMenu = null;
		try{
	        for(int i=0;i<ladpAppList.size();i++){
	        	ldapApp = ladpAppList.get(i);
	        	if(!isExist(ldapApp.toString(),secondMenuSet,"secondObj"))
	        	{
		        	secondMenu = new SecondMenu();
		        	secondMenu.setSecondMenuName(ldapApp.toString());
		        	secondMenu.setThirdMenuSet(getThirdMenuInfo(secondMenu.getSecondMenuName(),userId));
		        	secondMenuSet.add(secondMenu);
	        	}

	        }
	        
			return secondMenuSet;
			
		}catch(NullPointerException ex){
			
			throw new Exception("NullPointerException . error address is getSecondMenuInfo method");
		}
		catch(ArrayIndexOutOfBoundsException ex){
			
			throw new Exception("ArrayIndexOutOfBoundsException . error address is getSecondMenuInfo method");
		}

	}
	
	//�����˵���Ϣ
	private List getThirdMenuInfo(String menuName,String userId) throws Exception{
		
		
		List thirdMenuSet = new ArrayList();
		
		StringBuffer hqlStr = new StringBuffer();
		hqlStr.append("select item.Application_Id,item.StepName,item.StepPage from LADP_APPLICATION item ");
		hqlStr.append(" where item.WorkflowName ='" + menuName + "' and item.Application_Id in (select item1.Application_Id  ");
		hqlStr.append(" from Sys_Appauthorize item1 where item1.Authto_Id = '" + userId +"') order by item.order_id");
		
		List  ladpAppList =  dao.getRsBySql(hqlStr.toString());
		Object[] ldapApp = null;
		ThirdMenu thirdMenu = null;
		try{
	        for(int i=0;i<ladpAppList.size();i++){
	        	ldapApp = (Object[])ladpAppList.get(i);
	        	thirdMenu = new ThirdMenu();
	        	thirdMenu.setMenuId(ldapApp[0].toString());
	        	thirdMenu.setMenuName(ldapApp[1].toString());
	        	if(ldapApp[2] != null) {
	        		thirdMenu.setMenuUrl(ldapApp[2].toString());
	        	}
	        	
	        	thirdMenuSet.add(thirdMenu);
	        }
			return thirdMenuSet;
		}catch(NullPointerException ex){
			
			throw new Exception("NullPointerException . error address is getThirdMenuInfo method");
		}
		catch(ArrayIndexOutOfBoundsException ex){
			
			throw new Exception("ArrayIndexOutOfBoundsException . error address is getThirdMenuInfo method");
		}

	}
	
	
	
	
	
}


