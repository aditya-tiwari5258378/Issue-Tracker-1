package com.example.demo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.mapper.HelpRowMapper;
import com.example.demo.mapper.raiseIssueRowMapper;

@Configuration
public class HelpDAO 
{
	@Autowired
	JdbcTemplate template;
	List<Help> requestList = new ArrayList<Help>();
	List<Help> finalAdminList = new ArrayList<>();
	List<Help> finalList = new ArrayList<>();
	public int getHelp(Help help) throws SQLException
	{
	    String sql = "INSERT INTO ticket_master VALUES(?,?,?,?,?)";
		int update = template.update(sql,help.getUserId(),help.getRequestId(),help.getIssue(),help.getDescription(),help.getDateOfTicket());
		return update;
	}
	
	public void addHelp(Help help) 
	{
		
	    requestList.add(help);
	}
	
	public void delete(String requestId) throws SQLException
	{	
		String sql = "Delete FROM ticket_master where requestId=?";
		int update = template.update(sql,requestId);
	}
	
	public List<Help> viewHelp()throws SQLException
	{
        String sql = "SELECT * FROM ticket_master";
	    HelpRowMapper rowmapper = new HelpRowMapper();
	    requestList = template.query(sql, rowmapper);
	    
	    return requestList;
	}
	

	
	
}
