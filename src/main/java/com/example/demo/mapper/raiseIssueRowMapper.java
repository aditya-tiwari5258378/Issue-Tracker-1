package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.raiseIssue;

public class raiseIssueRowMapper implements RowMapper<raiseIssue>
{

	@Override
	public raiseIssue mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		// TODO Auto-generated method stub
		raiseIssue raiseissue=new raiseIssue(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getDate(6));
		return raiseissue;
	}

}
