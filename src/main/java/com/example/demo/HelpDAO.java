package com.example.demo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HelpDAO {

	List<Help> requestList = new ArrayList<Help>();	
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
	
	public void addHelp(Help help) 
	{
		
	    requestList.add(help);
	}
	
	public void delete(String requestId) throws SQLException
	{
		Connection con=ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("Delete FROM ticket_master where requestId=?");
		st.setString(1,requestId);
		int n = st.executeUpdate();	
	}
	
	public List<Help> viewHelp()throws SQLException
	{
		Connection con=ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("SELECT * FROM ticket_master");
		ResultSet rs = st.executeQuery();
		
	   while(rs.next())
		{
			Help help=null;
			help=new Help(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		    requestList.add(help);
		}
		con.close();
		
	    return requestList;
	}
}
