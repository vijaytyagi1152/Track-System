package com.example.track;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

	public int insert(User u){
		int i=0;
		try{
			PreparedStatement ps=Dao.getCon().prepareStatement("insert into driver values(?,?,?,?,?,?,?)");
		    ps.setString(1,u.getName());
		    ps.setString(2,u.getUname());
		    ps.setString(3,u.getPass());
		    ps.setString(4,u.getLat());
		    ps.setString(5,u.getLon());
		    ps.setString(6,u.getV_number());
		    ps.setString(7,u.getDates());
		    i=ps.executeUpdate();
		    
		    }catch (Exception e) {
			System.out.println(e);
		    }
	        return i;    
	   }
	
	public int updateLocation(String uname,String lat,String lon){
		int i=0;
		try{
			PreparedStatement ps=Dao.getCon().prepareStatement("update driver set lat=? , lon=? where uname = ?");
		    ps.setString(1,lat);
		    ps.setString(2,lon);
		    ps.setString(3,uname);
		    
		    i=ps.executeUpdate();
		    
		    }catch (Exception e) {
			System.out.println(e);
		    }
	        return i; 	
	}
	
	public List<User> getAllUser(){
		List<User> list=new ArrayList<User>();
		try{
			PreparedStatement ps=Dao.getCon().prepareStatement("select * from driver");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				User u=new User();
				u.setName(rs.getString(1));
				u.setUname(rs.getString(2));
				u.setPass(rs.getString(3));
				u.setLat(rs.getString(4));
				u.setLon(rs.getString(5));
				u.setV_number(rs.getString(6));
				u.setDates(rs.getString(7));
				list.add(u);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public User login(String uname,String pass){
		User u=null;
		try {
			PreparedStatement ps=Dao.getCon().prepareStatement("select * from driver where uname=? and pass=?");
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				u=new User();
				u.setName(rs.getString(1));
				u.setUname(uname);
				u.setPass(pass);
				u.setDates(rs.getString(7));
				u.setV_number(rs.getString(6));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return u;
		
	}
	
	public int changePass(String uname,String newpass){
		int i=0;
		try{
			PreparedStatement ps=Dao.getCon().prepareStatement("update driver set pass=? where uname = ?");
		    ps.setString(1,newpass);
		    ps.setString(2,uname);
		    
		    
		    i=ps.executeUpdate();
		    
		    }catch (Exception e) {
			System.out.println(e);
		    }
	        return i; 	
	}
	public User getUser(String uname){
		User u=null;
		try{
			PreparedStatement ps=Dao.getCon().prepareStatement("select * from driver where uname=?");
		    ps.setString(1,uname);
		    ResultSet rs=ps.executeQuery();
		    if(rs.next()){
		    	 u=new User();
		    	u.setLat(rs.getString(4));
		    	u.setLon(rs.getString(5));
		    }
		    }catch (Exception e) {
			System.out.println(e);
		    }
	        return u; 	
	}
	
	
}
