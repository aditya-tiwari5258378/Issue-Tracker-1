package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.Help;

public class HelpRowMapper implements RowMapper<Help> {

	@Override
	public Help mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		// TODO Auto-generated method stub
		Help help=new Help(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
		return help;
	}

}
