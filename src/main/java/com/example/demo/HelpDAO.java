package com.example.demo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelpDAO {

	
	public int getHelp(Help help) throws SQLException
	{
		Connection con = ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("INSERT INTO ticket_master VALUES(?,?,?,?,?)");
		st.setString(1, help.getUserId());
		st.setString(2, help.getRequestId());
		st.setString(3, help.getIssue());
		st.setString(4, help.getDescription());
		st.setString(5, help.getDateOfTicket());
		
		int no=st.executeUpdate();
		System.out.println(no+" row(s) affected");
		return no;
	}
}
