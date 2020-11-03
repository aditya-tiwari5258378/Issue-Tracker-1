package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class raiseIssueDAO {

	List<raiseIssue> requestList = new ArrayList<raiseIssue>();
	List<raiseIssue> categoryList = new ArrayList<raiseIssue>();
	List<raiseIssue> finalList = new ArrayList<raiseIssue>();
	public int getRaiseIssue(raiseIssue help) throws SQLException
	{
		Connection con = ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("INSERT INTO raise_issue VALUES(?,?,?,?,?)");
		st.setString(1, help.getUserId());
		st.setString(2, help.getCategoryId());
		st.setString(3, help.getCategory());
		st.setString(4, help.getDetails());
		st.setString(5, help.getStatus());
		
		
		int no=st.executeUpdate();
		System.out.println(no+" row(s) affected");
		return no;
	}
	
	public void addIssue(raiseIssue help) 
	{
		
	    requestList.add(help);
	}
	
	public List<raiseIssue> viewIssue() throws SQLException
	{
		Connection con=ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("SELECT * FROM raise_issue  where status='active'");
		ResultSet rs = st.executeQuery();
		
	   while(rs.next())
		{
			raiseIssue help=null;
			help=new raiseIssue(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
		    requestList.add(help);
		}
		con.close();
		
	    return requestList;
	}
	
	public List<raiseIssue> viewHistoryIssue() throws SQLException
	{
		Connection con=ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("SELECT * FROM raise_issue");
		ResultSet rs = st.executeQuery();
		
	   while(rs.next())
		{
			raiseIssue help=null;
			help=new raiseIssue(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
		    categoryList.add(help);
		}
		con.close();
		
	    return categoryList;
	}
	
	public List<raiseIssue> displayList(String userId) throws SQLException
	{

		Connection con=ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("SELECT * FROM raise_issue where userId = ?");
		st.setString(1, userId);
		ResultSet rs = st.executeQuery();
		
	   while(rs.next())
		{
			raiseIssue r=null;
			r=new raiseIssue(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		    finalList.add(r);
		}
		con.close();
		return finalList;
	}
	
	public raiseIssue view(String categoryId) throws SQLException
	{
		raiseIssue r=null;
		Connection con=ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("SELECT * FROM raise_issue where issueId = ?");
		st.setString(1, categoryId);
		ResultSet rs = st.executeQuery();
		
	   while(rs.next())
		{
			
			r=new raiseIssue(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}
		con.close();	
		return r;
	}
	public int update(String category,String CategoryId) throws SQLException {
		Connection con = ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("UPDATE raise_issue SET category=? WHERE issueId=?");
		st.setString(1,category);
		st.setString(2,CategoryId);
		int no=st.executeUpdate();
		System.out.println(no+" row(s) affected");
		return no;
	}
		
//	public raiseIssue read(String categoryId) throws SQLException
//	{
//		Connection con=ConnectionFactory.getConn();
//		PreparedStatement st = con.prepareStatement("SELECT * FROM raise_issue WHERE categoryId=?");
//		st.setString(1, categoryId);
//		ResultSet rs = st.executeQuery();
//		raiseIssue issue=null;
//		if(rs.next())
//			issue=new raiseIssue(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
//		con.close();
//		return issue;
//	}
//	
	public String map() {
		return "null";
	}
	
}
