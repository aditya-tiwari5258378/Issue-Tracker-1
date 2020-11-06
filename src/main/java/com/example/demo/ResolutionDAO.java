package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ResolutionDAO
{
	@Autowired
	JdbcTemplate template;
	
	public int getResolved(Resolution resolution) throws SQLException
	{
		String sql = "INSERT INTO ticket_resolution VALUES(?,?)";
		int no = template.update(sql,resolution.getRequestId(),resolution.getResolution());
		return no;
	}

}