package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class catnotificationDAO {
	List<catnotification> catnotificationList = new ArrayList<catnotification>();
	public int addnotification(String categoryId) throws SQLException
	{
		Connection con = ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("INSERT INTO catnotification VALUES(?)");
		st.setString(1, categoryId);
		int n=st.executeUpdate();
		System.out.println(n+" row(s) affected");
		return n;
	}
	public List<catnotification> read() throws SQLException {
		Connection con = ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("SELECT * FROM catnotification");
		ResultSet rs = st.executeQuery();
		 String msg="";
		  while(rs.next())
			{
			  catnotification catn=null;
			 catn=new catnotification(rs.getString(1));
			 catnotificationList.add(catn);
			
		}
		return catnotificationList;
	}
	public void delete(String name) throws SQLException
	{
		Connection con=ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("Delete FROM catnotification where issueId=?");
		st.setString(1, name);
		int n = st.executeUpdate();	
	}
	
}
