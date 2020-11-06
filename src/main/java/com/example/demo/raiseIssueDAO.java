package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.mapper.raiseIssueRowMapper;
@Configuration
public class raiseIssueDAO {

	List<raiseIssue> requestList = new ArrayList<raiseIssue>();
	List<raiseIssue> categoryList = new ArrayList<raiseIssue>();
	List<raiseIssue> finalList = new ArrayList<raiseIssue>();
	
	@Autowired
	JdbcTemplate template;

	public int getRaiseIssue(raiseIssue raiseissue) throws SQLException
	{
		String sql = "INSERT INTO raise_issue VALUES(?,?,?,?,?,?)";
		java.util.Date utilDate = raiseissue.getDateOfIssue();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		int update = template.update(sql,raiseissue.getUserId(),raiseissue.getCategoryId(),raiseissue.getCategory(),raiseissue.getDetails(),raiseissue.getStatus(),sqlDate);
		return update;
	}
		
	public void addIssue(raiseIssue help) 
	{
		
	    requestList.add(help);
	}
	
	public List<raiseIssue> viewIssue() throws SQLException
	{   
	    String sql = "SELECT * FROM raise_issue  where status='active' or status='in-progress'";
	    raiseIssueRowMapper rowmapper = new raiseIssueRowMapper();
	    requestList = template.query(sql, rowmapper);
	    return requestList;
	    
	}
	
	
	public List<raiseIssue> viewHistoryIssue() throws SQLException
	{
	    String sql = "SELECT * FROM raise_issue";
	    raiseIssueRowMapper rowmapper = new raiseIssueRowMapper();
	    categoryList = template.query(sql, rowmapper);
	    return categoryList;  
	}
	
	public List<raiseIssue> displayList(String userId) throws SQLException
	{
        String sql = "SELECT * FROM raise_issue where userId = ?";
	    raiseIssueRowMapper rowmapper = new raiseIssueRowMapper();
	    finalList = template.query(sql, rowmapper,userId);
	    
		return finalList;
	}
	
	public raiseIssue view(String categoryId) throws SQLException
	{
		raiseIssue r=null;
		String sql = "SELECT * FROM raise_issue where issueId = ?";
	    raiseIssueRowMapper rowmapper = new raiseIssueRowMapper();
	    r = template.queryForObject(sql, rowmapper,categoryId);
	    return r;
}
	
	public void reopen(String categoryId) throws SQLException
	{
		String sql = "UPDATE raise_issue SET status='active' where issueId = ?";
		int update = template.update(sql,categoryId);
	
	}
	
	public void close(String categoryId) throws SQLException
	{
	    String sql = "UPDATE raise_issue SET status='completed' where issueId = ?";
		int update = template.update(sql,categoryId);
	}
	
		public List<raiseIssue> filter(LocalDate start,LocalDate end,String category) throws SQLException {
		
			List<raiseIssue> DetailsList = new ArrayList<raiseIssue>();
			 String sql = "select * from raise_issue where category = ? and dateOfIssue between ? and ?";
			    raiseIssueRowMapper rowmapper = new raiseIssueRowMapper();
			    DetailsList = template.query(sql, rowmapper,category,java.sql.Date.valueOf(start),java.sql.Date.valueOf(end));
			return DetailsList;
		}
	public int update(String category,String CategoryId) throws SQLException {
		//Connection con = ConnectionFactory.getConn();
		String sql="UPDATE raise_issue SET category=? WHERE issueId=?";
//		st.setString(1,category);
//		st.setString(2,CategoryId);
//		int no=st.executeUpdate();
		int update = template.update(sql,category,CategoryId);
		//System.out.println(no+" row(s) affected");
		return update;
	}

	List<String> listCategory = new ArrayList<String>();
   	public List<String> viewStatus() throws SQLException
	{
	listCategory.add("Active");
	listCategory.add("In-Progress");
	listCategory.add("Completed");
	
	return listCategory;
	
	}
	
	public void updateStatusByUserId(String categoryId, String newstatus) throws SQLException
	{
		
		String sql = "UPDATE raise_issue SET status=? where issueId = ?";
		int update = template.update(sql,newstatus,categoryId);
	}
	


//	public raiseIssue read(String categoryId) throws SQLException
//	{
//		Connection con=ConnectionFactory.getConn();
//		PreparedStatement st = con.prepareStatement("SELECT * FROM raise_issue WHERE categoryId=?");
//		st.setString(1, categoryId);
//		ResultSet rs = st.executeQuery();
//		raiseIssue issue=null;
//		if(rs.next())
//			issue=new raiseIssue(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
//		con.close();
//		return issue;
//	}
//	
//	public String map() {
//		return "null";
//	}
//	
	
}
