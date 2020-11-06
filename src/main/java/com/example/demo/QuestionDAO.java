package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.mapper.QuestionRowMapper;
import com.example.demo.mapper.raiseIssueRowMapper;

@Configuration
public class QuestionDAO 
{
	@Autowired
	JdbcTemplate template;
	public int create(Question question) throws SQLException
	{
	    String sql = "INSERT INTO question VALUES(?,?,?,?)";
		int update = template.update(sql,question.getUserId(),question.getA1(),question.getA2(),question.getA3());
		return update;
	}
	
	public Question read(String userId, String a1, String a2, String a3) throws SQLException
	{
		Question question = null;
		String sql = "SELECT * FROM question WHERE userId=? AND a1=? AND a2=? AND a3=?";
	    QuestionRowMapper rowmapper = new QuestionRowMapper();
	    question = template.queryForObject(sql, rowmapper,userId,a1,a2,a3);
	   
		return question;
	}
}
