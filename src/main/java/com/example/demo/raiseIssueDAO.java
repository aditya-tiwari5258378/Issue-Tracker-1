package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class raiseIssueDAO {

	public int getRaiseIssue(raiseIssue help) throws SQLException
	{
		Connection con = ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("INSERT INTO raise_issue VALUES(?,?,?,?)");
		st.setString(1, help.getUserId());
		st.setString(2, help.getCategoryId());
		st.setString(3, help.getCategory());
		st.setString(4, help.getDetails());
		
		
		int no=st.executeUpdate();
		System.out.println(no+" row(s) affected");
		return no;
	}
		
	
}
