package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionsOperations {
	public void insert(Questions q) throws SQLException, ClassNotFoundException {
		DBMain db=new DBMain();
		Connection connect=db.getConnection();
		String s="insert into questions(question,option1,option2,option3,option4,answer) values(?,?,?,?,?,?)";
		PreparedStatement ps=connect.prepareStatement(s);
		ps.setString(1, q.question);
		ps.setString(2, q.option1);
		ps.setString(3, q.option2);
		ps.setString(4, q.option3);
		ps.setString(5, q.option4);
		ps.setString(6, q.answer);
		ps.executeUpdate();
	}
	
	public void updateQuestion(String id,String question) throws SQLException, ClassNotFoundException {
		DBMain db=new DBMain();
		Connection connect=db.getConnection();
		String s="update questions set question=? where id=?";
		PreparedStatement ps=connect.prepareStatement(s);
		ps.setString(1, question);
		ps.setInt(2, Integer.parseInt(id) );
		ps.executeUpdate();
	}
	
	public void updateoption1(String id,String option) throws SQLException, ClassNotFoundException {
		DBMain db=new DBMain();
		Connection connect=db.getConnection();
		String s="update questions set option1=? where id=?";
		PreparedStatement ps=connect.prepareStatement(s);
		ps.setString(1, option);
		ps.setInt(2, Integer.parseInt(id) );
		ps.executeUpdate();
	}
	
	public void updateoption4(String id,String option) throws SQLException, ClassNotFoundException {
		DBMain db=new DBMain();
		Connection connect=db.getConnection();
		String s="update questions set option4=? where id=?";
		PreparedStatement ps=connect.prepareStatement(s);
		ps.setString(1, option);
		ps.setInt(2, Integer.parseInt(id) );
		ps.executeUpdate();
	}
	
	public void updateoption2(String id,String option) throws SQLException, ClassNotFoundException {
		DBMain db=new DBMain();
		Connection connect=db.getConnection();
		String s="update questions set option2=? where id=?";
		PreparedStatement ps=connect.prepareStatement(s);
		ps.setString(1, option);
		ps.setInt(2, Integer.parseInt(id) );
		ps.executeUpdate();
	}
	
	public void updateoption3(String id,String option) throws SQLException, ClassNotFoundException {
		DBMain db=new DBMain();
		Connection connect=db.getConnection();
		String s="update questions set option3=? where id=?";
		PreparedStatement ps=connect.prepareStatement(s);
		ps.setString(1, option);
		ps.setInt(2, Integer.parseInt(id) );
		ps.executeUpdate();
	}
	
	public void updateanswer(String id,String option) throws SQLException, ClassNotFoundException {
		DBMain db=new DBMain();
		Connection connect=db.getConnection();
		String s="update questions set answer=? where id=?";
		PreparedStatement ps=connect.prepareStatement(s);
		ps.setString(1, option);
		ps.setInt(2, Integer.parseInt(id) );
		ps.executeUpdate();
	}
	
	public void deleteQues(String id) throws SQLException, ClassNotFoundException {
		DBMain db=new DBMain();
		Connection connect=db.getConnection();
		String s="delete from questions where id=?";
		PreparedStatement ps=connect.prepareStatement(s);
		ps.setInt(1, Integer.parseInt(id) );
		ps.executeUpdate();
	}
	
	public List<Questions> getQuestions() throws SQLException, ClassNotFoundException {
		DBMain db=new DBMain();
		Connection connect=db.getConnection();
		String s="select * from questions";
		PreparedStatement ps=connect.prepareStatement(s);
		ResultSet rs=ps.executeQuery();
		List<Questions> list=new ArrayList<>();
		while(rs.next()) {
			Questions q=new Questions();
			q.id=rs.getInt("id");
			q.question=rs.getString("question");
			q.option1=rs.getString("option1");
			q.option2=rs.getString("option2");
			q.option3=rs.getString("option3");
			q.option4=rs.getString("option4");
			q.answer=rs.getString("answer");
			list.add(q);
		};
		
		return list;
	}
	
}
