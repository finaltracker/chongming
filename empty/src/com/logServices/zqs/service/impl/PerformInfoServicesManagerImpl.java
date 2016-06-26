package com.logServices.zqs.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.hql.ast.SqlASTFactory;

import com.logServices.zqs.dao.PerformInfoDao;
import com.logServices.zqs.model.PerformaceStatisInfo;
import com.logServices.zqs.services.PerformInfoServicesManager;
import com.logServices.zqs.util.DateFormatUtil;
import com.san.share.ca.newtest;

public class PerformInfoServicesManagerImpl implements PerformInfoServicesManager{
	
	
	public PerformInfoDao iperformdao;
	
	public List<PerformaceStatisInfo> getListAllManger(String depart, String fristDate, String endDate,int pageNo, int pageSize) {
		
		List<PerformaceStatisInfo> listTempl = new ArrayList<PerformaceStatisInfo>();
		try {
			StringBuffer buffSql = new StringBuffer("select t.pid,t.p_dapart,t.p_usernamer,t.p_pointall,to_char(t.p_startdate,'yyyy-MM-dd hh24:mi:ss'),t.P_UPTYPE from perform_info t where 1=1 ");
			//带条件的sql
			if((null!=depart)&&(!"".equals(depart))){
				buffSql.append("and t.p_dapart = '" + depart + "'");
			}
			if((null!=fristDate)&&(!"".equals(fristDate))){
				buffSql.append(" and t.p_date >= to_date('" + fristDate + "', 'yyyy-MM-dd') ");
			}
			if((null!=endDate)&&(!"".equals(endDate))){
				buffSql.append("and t.p_date <= to_date('" + endDate + " 23:59:59', 'yyyy-MM-dd hh24:mi:ss') ");
			}
			buffSql.append("order by t.p_date desc");
			List list = iperformdao.getListAll(buffSql.toString(), pageNo, pageSize);
			if((null != list)&&(list.size()>0)){
            	for(int i = 0; i<list.size(); i++){
            		PerformaceStatisInfo performInfo = new PerformaceStatisInfo();
            		Object[] objects = (Object[])list.get(i);
            		if(null != objects && objects.length >0){
//            			//封装对象
            			performInfo.setPid(String.valueOf(objects[0]));
            			performInfo.setDapart(String.valueOf(objects[1]));
            			performInfo.setUserNamer(String.valueOf(objects[2]));
            			performInfo.setPointAll(Integer.valueOf(String.valueOf(objects[3])));
            			performInfo.setStartDate(DateFormatUtil.parseStrToDateTime(String.valueOf(objects[4])));
            			performInfo.setUpType(String.valueOf(objects[5]));
            			listTempl.add(performInfo);
            		}
            	}
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listTempl;
	}

	public List<PerformaceStatisInfo> getListDetailManager(int pageNo, int pageSize) {
		List<PerformaceStatisInfo> listTempl = new ArrayList<PerformaceStatisInfo>();
		try {
			//计算出当前部门总积分
			StringBuffer buffSql = new StringBuffer("select t.p_dapart, sum(t.p_pointall) total from perform_info t ");
			buffSql.append("group by t.p_dapart order by sum(t.p_pointall) desc");
			List list = iperformdao.getListDetail(buffSql.toString(), pageNo, pageSize);
			
			//计算出部门用户总数
//			StringBuffer buffSqls = new StringBuffer("select t.sn sns,count(*) tot from sys_user t group by t.sn");
//			List listTempls = iperformdao.queryInfopu(buffSqls.toString());
			
			
			if((null != list)&&(list.size()>0)){
            	for(int i = 0; i<list.size(); i++){
//            		//根据部门下的用户加权平均计算总分（部门总分/部门下的员工）
//            		if((null != listTempls)&&(listTempls.size()>0)){
//	            		for(int a=0; a<listTempls.size(); a++){
//	            			PerformaceStatisInfo performInfo = new PerformaceStatisInfo();
//	                		Object[] objects = (Object[])list.get(i);
//	                		Object[] objectTempls = (Object[])listTempls.get(a);
//	                		if(null != objects && objects.length >0 && null != objectTempls && objectTempls.length >0){
//	                			String depart = String.valueOf(objects[0]);
//	                			String departs = String.valueOf(objectTempls[0]);
//	                			if ((!"".equals(depart)) && (!"".equals(departs)) && (null!=depart) && (null!=departs)) {
//									if(depart.equals(departs)){
//										int x = Integer.valueOf(String.valueOf(objects[1]));
//										int y = Integer.valueOf(String.valueOf(objectTempls[1]));
//										performInfo.setPointAll(x/y);
//									}
//									else {
//										performInfo.setPointAll(Integer.valueOf(String.valueOf(objects[1])));
//									}
//								}
//	                			else {
////	                				封装对象
//		                			performInfo.setDapart(String.valueOf(objects[0]));
//		                			performInfo.setPointAll(Integer.valueOf(String.valueOf(objects[1])));
//		                			listTempl.add(performInfo);
//								}
//	                			performInfo.setDapart(String.valueOf(objects[0]));
//	                			listTempl.add(performInfo);
//	                		}
//	            		}
//            		}
            		PerformaceStatisInfo performInfo = new PerformaceStatisInfo();
                	Object[] objects = (Object[])list.get(i);
                	if(null != objects && objects.length >0){
//                		//封装对象
                		performInfo.setDapart(String.valueOf(objects[0]));
                		performInfo.setPointAll(Integer.valueOf(String.valueOf(objects[1])));
                		listTempl.add(performInfo);
                	}
            	}
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listTempl;
	}
	
	public List<PerformaceStatisInfo> getListCondititonDetailManger(String dapart, String fristDate, String endDat, int pageNo, int pageSize) {
		List<PerformaceStatisInfo> listTempl = new ArrayList<PerformaceStatisInfo>();
		try {
			StringBuffer buffSql = new StringBuffer("select t.p_dapart, sum(t.p_pointall) total from perform_info t where 1=1 ");
			//带条件的sql
			if((null!=dapart)&&(!"".equals(dapart))){
				buffSql.append("and t.p_dapart = '" + dapart + "'");
			}
			if((null!=fristDate)&&(!"".equals(fristDate))){
				buffSql.append(" and t.p_date >= to_date('" + fristDate + "', 'yyyy-MM-dd') ");
			}
			if((null!=endDat)&&(!"".equals(endDat))){
				buffSql.append("and t.p_date <= to_date('" + endDat + " 23:59:59', 'yyyy-MM-dd hh24:mi:ss') ");
			}
			buffSql.append("group by t.p_dapart");
			List list = iperformdao.getListDetail(buffSql.toString(), pageNo, pageSize);
			if((null != list)&&(list.size()>0)){
            	for(int i = 0; i<list.size(); i++){
            		PerformaceStatisInfo performInfo = new PerformaceStatisInfo();
            		Object[] objects = (Object[])list.get(i);
            		if(null != objects && objects.length >0){
            			//封装对象
            			performInfo.setDapart(String.valueOf(objects[0]));
            			performInfo.setPointAll(Integer.valueOf(String.valueOf(objects[1])));
            			listTempl.add(performInfo);
            		}
            	}
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listTempl;
	}

	public int queryPerInfoManager(String str,String dapart, String fristDate, String endDate) {
		int count = 0;
		StringBuffer buffSql = new StringBuffer("select t.pid from perform_info t where 1=1 ");
		if((null!=str) && (!"".equals(str))){
			if("1".equals(str)){//带条件查询
//				带条件的sql
				if((null!=dapart)&&(!"".equals(dapart))){
					buffSql.append("and t.p_dapart = '" + dapart + "'");
				}
				if((null!=fristDate)&&(!"".equals(fristDate))){
					buffSql.append(" and t.p_date >= to_date('" + fristDate + "', 'yyyy-MM-dd') ");
				}
				if((null!=endDate)&&(!"".equals(endDate))){
					buffSql.append("and t.p_date <= to_date('" + endDate + " 23:59:59', 'yyyy-MM-dd hh24:mi:ss')");
				}
			}
		}
		count = iperformdao.queryPerInfo(buffSql.toString());
		return count;
	}

	public int updatePerInfoManager(String pid,String flag,int jf) {
		int i = -1;
		try{
			StringBuffer buffer = new StringBuffer("update PerformaceStatisInfo p");
			if((null!=flag)&&(!"".equals(flag))){
//				//查询
//				if("1".equals(flag)){
//					buffer.append(" set p.pointAll = p.pointAll+" + jf );
//				}
//				if("2".equals(flag)){
//					buffer.append(" set p.pointAll = p.pointAll+5");
//				}
				if(jf>0){
					buffer.append(" set p.pointAll = p.pointAll+" + jf );
				}
				if((null!=pid)&&(!"".equals(pid))){
					buffer.append(" where p.pid='" + pid +"'");
				}
				i = iperformdao.updatePerInfo(buffer.toString());
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return i;
	}

	public String vailDatePerInfoManager(String nowDate, String usName, String uptype,String pid) {
		String x = "";
		try {
			StringBuffer sqls = new StringBuffer("select t.P_CONTSTAT from perform_info t where 1=1 ");
			if((null!=pid) && (!"".equals(pid))){
				sqls.append("and t.pid  = '" + pid + "' ");
			}
			if((null!=usName) && (!"".equals(usName))){
				sqls.append("and t.p_usernamer  = '" + usName + "' ");
			}
			if((null!=uptype) && (!"".equals(uptype))){
				sqls.append("and t.p_uptype = '" + uptype + "' ");
			}
			if((null!=nowDate) && (!"".equals(nowDate))){
				sqls.append("and t.P_STARTDATE <= to_date('"+ nowDate + "','yyyy-MM-dd hh24:mi:ss') and t.P_ENDDATE >= to_date('" + nowDate + "','yyyy-MM-dd hh24:mi:ss')");
			}
			sqls.append(" order by t.P_DATE desc");
			x = iperformdao.vaildateImpPerInfo(sqls.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	
	public void savePerInfoManager(Object obj) {
		try {
			iperformdao.saveObject(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public List<PerformaceStatisInfo> querUserNamesManger(String sql) {
		List<PerformaceStatisInfo> listTempl = new ArrayList<PerformaceStatisInfo>();
		try {
			if("2".equals(sql)){
				StringBuffer buffSql = new StringBuffer("select t.p_dapart from perform_info t group by t.p_dapart ");
				List list = iperformdao.queryUserNames(buffSql.toString());
				if((null != list)&&(list.size()>0)){
	            	for(int i = 0; i<list.size(); i++){
	            		PerformaceStatisInfo performInfo = new PerformaceStatisInfo();
	            		String depart = (String)list.get(i);
	            		if(null != depart && !"".equals(depart)){
	            			//封装对象
	            			performInfo.setDapart(depart);
	            			listTempl.add(performInfo);
	            		}
//	            		Object[] objects = (Object[])list.get(i);
//	            		if(null != objects && objects.length >0){
////	            			//封装对象
//	            			performInfo.setDapart(String.valueOf(objects[0]));
//	            			performInfo.setUserNamer(String.valueOf(objects[1]));
//	            			listTempl.add(performInfo);
//	            		}
	            	}
	            }
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTempl;
	}
	
	public List<PerformaceStatisInfo> querAnyCharAllManger(String sql) {
		List<PerformaceStatisInfo> listTempl = new ArrayList<PerformaceStatisInfo>();
		try {
			StringBuffer buffSql = new StringBuffer("select t.p_dapart, sum(t.p_pointall) total from perform_info t where 1=1 ");
			buffSql.append("group by t.p_dapart order by sum(t.p_pointall) desc");
			List list = iperformdao.getRsBySql(buffSql.toString());
			if((null != list)&&(list.size()>0)){
//				获取前五条记录
				if(list.size()>6){
					for(int i = 0; i<5; i++){
	            		PerformaceStatisInfo performInfo = new PerformaceStatisInfo();
	            		Object[] objects = (Object[])list.get(i);
	            		if(null != objects && objects.length >0){
	            			//封装对象
	            			performInfo.setDapart(String.valueOf(objects[0]).replaceAll("0", ""));
	            			performInfo.setPointAll(Integer.valueOf(String.valueOf(objects[1])));
	            			listTempl.add(performInfo);
	            		}
	            	}
				}
				else{
					for(int i = 0; i<list.size(); i++){
	            		PerformaceStatisInfo performInfo = new PerformaceStatisInfo();
	            		Object[] objects = (Object[])list.get(i);
	            		if(null != objects && objects.length >0){
	            			//封装对象
	            			performInfo.setDapart(String.valueOf(objects[0]).replaceAll("0", ""));
	            			performInfo.setPointAll(Integer.valueOf(String.valueOf(objects[1])));
	            			listTempl.add(performInfo);
	            		}
	            	}
				}
            	
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listTempl;
	}
	
	
	public PerformInfoDao getIperformdao() {
		return iperformdao;
	}

	public void setIperformdao(PerformInfoDao iperformdao) {
		this.iperformdao = iperformdao;
	}
	
	public int vailDateLogManager(String nowDate, String usName, String uptype,String pid) {
		int x = -1;
		try {
			StringBuffer sqls = new StringBuffer("select t.pid from perform_info t where 1=1 ");
			if((null!=pid) && (!"".equals(pid))){
				sqls.append("and t.pid  = '" + pid + "' ");
			}
			if((null!=usName) && (!"".equals(usName))){
				sqls.append("and t.p_usernamer  = '" + usName + "' ");
			}
			if((null!=uptype) && (!"".equals(uptype))){
				sqls.append("and t.p_uptype = '" + uptype + "' ");
			}
			if((null!=nowDate) && (!"".equals(nowDate))){
				sqls.append("and t.P_STARTDATE <= to_date('"+ nowDate + "','yyyy-MM-dd hh24:mi:ss') and t.P_ENDDATE >= to_date('" + nowDate + "','yyyy-MM-dd hh24:mi:ss')");
			}
			sqls.append(" order by t.P_DATE desc");
			x = iperformdao.vailDatePerInfo(sqls.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	public String vailDateJingTaiManager(String nowDate, String usName, String uptype,String pid) {
		String x = "";
		try {
			StringBuffer sqls = new StringBuffer("select t.p_contstat from perform_info t where 1=1 ");
			if((null!=pid) && (!"".equals(pid))){
				sqls.append("and t.pid  = '" + pid + "' ");
			}
			if((null!=usName) && (!"".equals(usName))){
				sqls.append("and t.p_usernamer  = '" + usName + "' ");
			}
			if((null!=uptype) && (!"".equals(uptype))){
				sqls.append("and t.p_uptype = '" + uptype + "' ");
			}
			if((null!=nowDate) && (!"".equals(nowDate))){
				sqls.append("and t.P_STARTDATE <= to_date('"+ nowDate + "','yyyy-MM-dd hh24:mi:ss') and t.P_ENDDATE >= to_date('" + nowDate + "','yyyy-MM-dd hh24:mi:ss')");
			}
			x = iperformdao.vailJingPerInfo(sqls.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	public int vailDateupFileManager(String nowDate, String usName, String pointType, String tableid) {
		int x = -1;
		try {
			StringBuffer sqls = new StringBuffer("select t.pid from perform_info t where 1=1 ");
			if((null!=usName) && (!"".equals(usName))){
				sqls.append("and t.p_usernamer = '" + usName + "' ");
			}
			if((null!=pointType) && (!"".equals(pointType))){
				sqls.append("and t.p_uptype = '" + pointType + "' ");
			}
			if((null!=tableid) && (!"".equals(tableid))){
				sqls.append("and t.p_contstat = '" + tableid + "' ");
			}
			if((null!=nowDate) && (!"".equals(nowDate))){
				sqls.append("and t.P_STARTDATE <= to_date('"+ nowDate + "','yyyy-MM-dd hh24:mi:ss') and t.P_ENDDATE >= to_date('" + nowDate + "','yyyy-MM-dd hh24:mi:ss')");
			}
			x = iperformdao.vailDatePerInfo(sqls.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}


	public List<PerformaceStatisInfo> querAnyCharEmployManger(String sql) {
		List<PerformaceStatisInfo> listTempl = new ArrayList<PerformaceStatisInfo>();
		try {
			StringBuffer buffSql = new StringBuffer("select t.p_usernamer, t.p_dapart, sum(t.p_pointall) total from perform_info t where 1=1 ");
			buffSql.append("group by t.p_usernamer,t.p_dapart order by sum(t.p_pointall) desc");
			List list = iperformdao.getRsBySql(buffSql.toString());
			if((null != list)&&(list.size()>0)){
				//获取前五条记录
				if(list.size()>5){
					for(int i = 0; i<5; i++){
	            		PerformaceStatisInfo performInfo = new PerformaceStatisInfo();
	            		Object[] objects = (Object[])list.get(i);
	            		if(null != objects && objects.length >0){
	            			//封装对象
	            			performInfo.setUserNamer(String.valueOf(objects[0]));
	            			performInfo.setPointAll(Integer.valueOf(String.valueOf(objects[2])));
	            			listTempl.add(performInfo);
	            		}
	            	}
				}
				else {
					for(int i = 0; i<list.size(); i++){//排名前五
	            		PerformaceStatisInfo performInfo = new PerformaceStatisInfo();
	            		Object[] objects = (Object[])list.get(i);
	            		if(null != objects && objects.length >0){
	            			//封装对象
	            			performInfo.setUserNamer(String.valueOf(objects[0]));
	            			performInfo.setPointAll(Integer.valueOf(String.valueOf(objects[2])));
	            			listTempl.add(performInfo);
	            		}
	            	}
				}
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listTempl;
	}

	public List<PerformaceStatisInfo> queryNamePerInfoManager(String username,String type) {
		List<PerformaceStatisInfo> listTempl = new ArrayList<PerformaceStatisInfo>();
		try {
//			String hql=" from PerformaceStatisInfo where userNamer='"+username+"' and ex_3 = '1' and upType = '" + type +"'";
			String hql_2 = " from PerformaceStatisInfo where userNamer='"+username+"' order by saveDate desc";
			listTempl = iperformdao.getRsByHql(hql_2.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTempl;
	}

	public int updatePerDateManager(String pid,String startDate,String endDate,String jftx) {
		int i = -1;
		try{
			StringBuffer buffer = new StringBuffer("update PerformaceStatisInfo p");
			if((null!=startDate) && (!"".equals(startDate))){
				buffer.append(" set p.startDate=to_date('" + startDate +"','yyyy-MM-dd hh24:mi:ss'),");
			}
			if((null!=endDate) && (!"".equals(endDate))){
				buffer.append(" p.endDate=to_date('" + endDate +"','yyyy-MM-dd hh24:mi:ss'),");
			}
			if((null!=jftx) && (!"".equals(jftx))){
				buffer.append(" p.pointType='" + jftx +"'");
			}
			if((null!=pid)&&(!"".equals(pid))){
				buffer.append(" where p.pid='" + pid +"'");
			}
			i = iperformdao.updatePerInfo(buffer.toString());
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return i;
	}

	public int updateTypeManager(String pid, String ex_3) {
		int i = -1;
		try{
			StringBuffer buffer = new StringBuffer("update PerformaceStatisInfo p");
			if((null!=ex_3)&&(!"".equals(ex_3))){
				buffer.append(" set p.ex_3='" + ex_3 +"'");
			}
			if((null!=pid)&&(!"".equals(pid))){
				buffer.append(" where p.pid='" + pid +"'");
			}
			i = iperformdao.updatePerInfo(buffer.toString());
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return i;
	}

	public int updateContectManager(String pid, String flag, int jf, String contect) {
		int i = -1;
		try{
			StringBuffer buffer = new StringBuffer("update PerformaceStatisInfo p");
			if((null!=flag)&&(!"".equals(flag))){
				if(jf>0){
					buffer.append(" set p.pointAll = p.pointAll+" + jf );
				}
				if((null!=contect)&&(!"".equals(contect))){
					buffer.append(", p.contStat_1='" + contect +"'");
				}
				if((null!=pid)&&(!"".equals(pid))){
					buffer.append(" where p.pid='" + pid +"'");
				}
				i = iperformdao.updatePerInfo(buffer.toString());
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return i;
	}

	public List<PerformaceStatisInfo> querMontherAnyCharAllManger(String sql) {
		List<PerformaceStatisInfo> listTempl = new ArrayList<PerformaceStatisInfo>();
		try {
			
			String sqlString = "select to_char(t.p_date,'mm') pdate, sum(t.p_pointall) total from perform_info t " + 
								"group by to_char(t.p_date,'mm') order by pdate desc";
			
			List list = iperformdao.getRsBySql(sqlString.toString());
			if((null != list)&&(list.size()>0)){
            	for(int i = 0; i<list.size(); i++){//获取前五条记录
            		PerformaceStatisInfo performInfo = new PerformaceStatisInfo();
            		Object[] objects = (Object[])list.get(i);
            		if(null != objects && objects.length >0){
            			//封装对象
            			String trs = String.valueOf(objects[0]).substring(0, 1);
            			if(trs.equals("0")){
            				performInfo.setDapart(String.valueOf(objects[0]).replaceAll("0", ""));
            			}
            			else{
            				performInfo.setDapart(String.valueOf(objects[0]));
            			}
            			performInfo.setPointAll(Integer.valueOf(String.valueOf(objects[1])));
            			listTempl.add(performInfo);
            		}
            	}
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listTempl;
	}

}
