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

import com.example.demo.mapper.CategoryRowMapper;
import com.example.demo.mapper.raiseIssueRowMapper;
@Configuration
public class CategoryDAO 
{
   @Autowired
   JdbcTemplate template;
	List<Category> requestList = new ArrayList<Category>();	
	public List<Category> viewCat()throws SQLException
	{
		 String sql = "SELECT * FROM category";
		    CategoryRowMapper rowmapper = new CategoryRowMapper();
		    requestList = template.query(sql, rowmapper);
		    return requestList;
	}
	public int addCat(Category category) throws SQLException
	{
			String sql = "INSERT INTO category VALUES(?,?)";
	
		int update = template.update(sql,category.getId(),category.getName());
		return update;
		
	}
	
	public void delete(String id) throws SQLException
	{
		
		String sql = "Delete FROM category where id=?";
		
		int update = template.update(sql,id);
		
		
	}
	
}