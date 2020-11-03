package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class CategoryDAO {

	List<Category> requestList = new ArrayList<Category>();	
	public List<Category> viewCat()throws SQLException
	{
		Connection con=ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("SELECT * FROM category");
		ResultSet rs = st.executeQuery();
		
	   while(rs.next())
		{
			Category category=null;
			category=new Category(rs.getString(1), rs.getString(2));
		    requestList.add(category);
		}
		con.close();
		
	    return requestList;
	}
	public int addCat(Category category) throws SQLException
	{
		Connection con = ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("INSERT INTO category VALUES(?,?)");
		st.setString(1, category.getId());
		st.setString(2, category.getName());
		int no=st.executeUpdate();
		System.out.println(no+" row(s) affected");
		return no;
	}
	
	public void delete(String id) throws SQLException
	{
		Connection con=ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("Delete FROM category where id=?");
		st.setString(1,id);
		int n = st.executeUpdate();	
	}
	
}