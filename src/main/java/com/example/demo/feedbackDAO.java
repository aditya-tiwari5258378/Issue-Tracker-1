package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class feedbackDAO {

	public int addfeedback(String userId,String requestId ) throws SQLException
	{
		Connection con = ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("INSERT INTO feedback VALUES(?,?)");
		st.setString(1,userId);
		st.setString(2, requestId);
		int no=st.executeUpdate();
		System.out.println(no+" row(s) affected");
		return no;
	}
	
	public feedback viewfeedback(String id)throws SQLException
	{
		Connection con=ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("SELECT * FROM feedback where userId=?");
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		feedback fb=null;
	   while(rs.next())
		{
		   
		   fb=new feedback(rs.getString(1), rs.getString(2));
		}
		con.close();
		
	    return fb;
	}
}
