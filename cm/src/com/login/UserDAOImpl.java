package com.login; 
import java.util.List;  
import org.springframework.orm.hibernate3.support.HibernateDaoSupport; 

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO 
{ 
  private static String hql = "from User u where u.username=?"; 
  public boolean isValidUser(String username, String password) 
  { 
    // ��֤�û�  
   // List userList = this.getHibernateTemplate().find(hql, username); 
    //if (userList.size() > 0) 
    { 
      return true; 
    } // return false; 
 } 
}