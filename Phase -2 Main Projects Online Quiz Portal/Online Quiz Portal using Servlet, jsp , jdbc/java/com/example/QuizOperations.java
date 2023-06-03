package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class QuizOperations {
	public List<Quiz> getQuiz() throws SQLException, ClassNotFoundException {
		DBMain db=new DBMain();
		Connection connect=db.getConnection();
		String s="select * from quiz";
		PreparedStatement ps=connect.prepareStatement(s);
		ResultSet rs=ps.executeQuery();
		List<Quiz> list=new ArrayList<>();
		while(rs.next()) {
			Quiz q=new Quiz();
			q.id=rs.getInt("id");
			q.title=rs.getString("title");
			q.category=rs.getString("category");
			list.add(q);
		};
		
		return list;
	}
	
	public void insert(String title,String category) throws SQLException, ClassNotFoundException {
		DBMain db=new DBMain();
		Connection connect=db.getConnection();
		String s="insert into quiz(title,category) values(?,?)";
		PreparedStatement ps=connect.prepareStatement(s);
		ps.setString(1, title);
		ps.setString(2, category);
		ps.executeUpdate();	
	}
	
}
