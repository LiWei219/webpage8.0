package com.struts2.userinfo;
import java.sql.*;
import com.opensymphony.xwork2.ActionSupport;
import dao.Dao;

public class Userinfo extends ActionSupport{

	private Dao dao=new Dao();
	private String userName;
	private String userPsw;
	private String rePsw;
	private String newPsw;
		
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPsw() {
		return userPsw;
	}

	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}

	public String getRePsw() {
		return rePsw;
	}

	public void setRePsw(String rePsw) {
		this.rePsw = rePsw;
	}

	public String getNewPsw() {
		return newPsw;
	}

	public void setNewPsw(String newPsw) {
		this.newPsw = newPsw;
	}
	
	

	@Override
	public String toString() {
		return "Userinfo [userName=" + userName + ", userPsw=" + userPsw + ", rePsw=" + rePsw + ", newPsw=" + newPsw
				+ "]";
	}

	public String confirm() {

		 String sql = "select * from userinfo where username='" + getUserName()+"' and password ='"+getUserPsw()+"'";
		 ResultSet rS = dao.executeQuery(sql);
		 try 
		 {
		        if (rS.next())
		       {
		             return "success";
		       }
		       return "error";
		 } catch (SQLException e) 
		 {
		 // TODO Auto-generated catch block
		      e.printStackTrace();
		      return "error";
		 }
     }

	 public String regist() {
		 
		String psw1;
		String psw2;
		String un;
		psw1 = getUserPsw();
		psw2 = getRePsw();		
		un = getUserName();
		System.out.println("psw1:"+psw1+";psw2:"+psw2);
		if(!un.equals(" "))
		{
			if(psw1.equals(psw2))
			{
				 String sql = "insert into userinfo values('"+getUserName()+"','"+getUserPsw()+"')";
				 System.out.println("insert into userinfo values('"+getUserName()+"','"+getUserPsw()+"')");
				 int i = dao.executeUpdate(sql);
				 if (i > -1) {
				    return "success";
				 }
		    		 return "error";
			}
			else
				return "error";	
		}
		else
			return "error";
     }

	 public String changepsw() {
		 
			String psw1;
			String psw2;
			String psw3;
			psw1 = getUserPsw();
			psw2 = getNewPsw();
			psw3 = getRePsw();	
			
			System.out.println("oldpsw:"+psw1+";newpsw:"+psw2+";repsw:"+psw3);
			
			 String sql = "select * from userinfo where username='" + getUserName()+"' and password ='"+getUserPsw()+"'";
			 ResultSet rS = dao.executeQuery(sql);
			 try 
			 {
			        if (rS.next())
			       {
			        	if(psw2.equals(psw3))
						{
							 sql = "update userinfo set password='"+getNewPsw()+"' where username='"+getUserName()+"'";
							 System.out.println("update userinfo set password='"+getNewPsw()+"' where username='"+getUserName()+"'");
							 int i = dao.executeUpdate(sql);
							 System.out.println("i:"+i);
							 if (i > -1) {
							    return "success";
							 }
					    	 return "error";
						}
			             return "error";
			       }
			       return "error";
			 } catch (SQLException e) 
			 {
			 // TODO Auto-generated catch block
			      e.printStackTrace();
			      return "error";
			 }
											 
	     }
	

	
	
}
