package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.mapper.HelpRowMapper;
import com.example.demo.mapper.UserRowMapper;

@Configuration
public class UserDAO 
{
	@Autowired
	JdbcTemplate template;
	public int create(User user) throws SQLException
	{		
		String sql = "INSERT INTO user_master VALUES(?,?,?,?,?,?,?,?,?)";
		int no = template.update(sql, user.getUserId(),user.getPassword(),user.getFirstName(),user.getLastName(),user.getDob(),user.getGender(),user.getContactNumber(), user.getEmail(),user.getCategory());
		return no;
	}
	public User read(String userId, String password) throws SQLException		//uid, pwd, if i get a record, then it is success
	{
		Connection con=ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("SELECT * FROM user_master WHERE userId=? AND password=?");
		st.setString(1, userId);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		User user=null;
		if(rs.next())
			user=new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
		con.close();
		return user;
	}
	
	public String find(String userId) throws SQLException		//uid, pwd, if i get a record, then it is success
	{
		Connection con=ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("SELECT * FROM user_master WHERE userId=?");
		st.setString(1, userId);
		ResultSet rs = st.executeQuery();
		if(rs.next())
			return "found";
		con.close();
		return "notfound";
	}

	public User fetch(String contactNumber,String email) throws SQLException		//uid, pwd, if i get a record, then it is success
	{
		User user=null;
		String sql = "SELECT * FROM user_master WHERE contactNumber=? AND email=?";
		UserRowMapper rowmapper = new UserRowMapper();
	    user = template.queryForObject(sql, rowmapper,contactNumber,email);
		return user;
	}
	
	public int update(String password, String userId) throws SQLException		
	{
		String sql = "UPDATE user_master SET password=? WHERE userId=?";
		int update = template.update(sql,password,userId);
		return update;
	}
}
