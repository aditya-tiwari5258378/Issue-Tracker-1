package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.Category;
import com.example.demo.Help;

public class CategoryRowMapper implements RowMapper<Category> 
{

	@Override
	public Category mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Category category=new Category(rs.getString(1), rs.getString(2));
		return category;
	}

}
