package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class notificationDAO {

	List<Category> notificationList = new ArrayList<Category>();
	public int addnotification(Category category) throws SQLException
	{
		Connection con = ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("INSERT INTO notification VALUES(?,?)");
		st.setString(1, category.getId());
		st.setString(2,category.getName());
		int n=st.executeUpdate();
		System.out.println(n+" row(s) affected");
		return n;
	}
	public List<Category> read() throws SQLException {
		Connection con = ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("SELECT * FROM notification");
		ResultSet rs = st.executeQuery();
		 String msg="";
		  while(rs.next())
			{
			  Category noti=null;
			 noti=new Category(rs.getString(1),rs.getString(2));
			 notificationList.add(noti);
			
		}
		return notificationList;
	}
	public void delete(String name) throws SQLException
	{
		Connection con=ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("Delete FROM notification where msg=?");
		st.setString(1,name);
		int n = st.executeUpdate();	
	}
}
