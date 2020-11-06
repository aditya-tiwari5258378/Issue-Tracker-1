package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.Help;
import com.example.demo.Question;

public class QuestionRowMapper implements RowMapper<Question> {

	@Override
	public Question mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		// TODO Auto-generated method stub
		Question question=new Question(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		return question;
	}

}
