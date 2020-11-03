package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResolutionDAO
{
	
	public int getResolved(Resolution resolution) throws SQLException
	{
		Connection con = ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("INSERT INTO ticket_resolution VALUES(?,?)");
		st.setString(1,resolution.getRequestId());
		st.setString(2, resolution.getResolution());
		
		int no=st.executeUpdate();
		System.out.println(no+" row(s) affected");
		
		
		return no;
	}

}