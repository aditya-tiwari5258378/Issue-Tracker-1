package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionDAO {
	public int create(Question question) throws SQLException
	{
		Connection con = ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("INSERT INTO question VALUES(?,?,?,?)");
		st.setString(1, question.getUserId());
		st.setString(2, question.getA1());
		st.setString(3, question.getA2());
		st.setString(4, question.getA3());
		int no=st.executeUpdate();
		System.out.println(no+" row(s) affected");
		return no;
	}
	
	public Question read(String userId, String a1, String a2, String a3) throws SQLException
	{
		Connection con=ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("SELECT * FROM question WHERE userId=? AND a1=? AND a2=? AND a3=?");
		st.setString(1, userId);
		st.setString(2, a1);
		st.setString(3, a2);
		st.setString(4, a3);
		ResultSet rs = st.executeQuery();
		Question question=null;
		if(rs.next())
			question=new Question(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		con.close();
		return question;
	}
}
