package com.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMain {
		public void insertUser(User user) throws ClassNotFoundException, SQLException {
		DBMain db=new DBMain();
		Connection connect=db.getConnection();
		String s="insert into user values(?,?,?)";
		PreparedStatement ps=connect.prepareStatement(s);
		ps.setString(1, user.name);
		ps.setString(2, user.email);
		ps.setString(3, user.password);
		ps.executeUpdate();
	}
	
	public String validate(String mail,String password) throws SQLException, ClassNotFoundException {
		DBMain db=new DBMain();
		Connection connect=db.getConnection();
		String s="select name from user where email=? and password=?";
		PreparedStatement ps=connect.prepareStatement(s);
		ps.setString(1, mail);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
	    System.out.println("Entered Validate");

		if(rs.next()) {
		    System.out.println("Returning name");
			return rs.getString("name");
		}
	    System.out.println("Returning error");
		return "Error";
	}
	
	public void updateName(String email,String name) throws SQLException, ClassNotFoundException {
		DBMain db=new DBMain();
		Connection connect=db.getConnection();
		String s="update user set name=? where email=?";
		PreparedStatement ps=connect.prepareStatement(s);
		ps.setString(1, name);
		ps.setString(2, email);
		ps.executeUpdate();
	}
	
	
	public void updatePass(String email,String password) throws SQLException, ClassNotFoundException {
		DBMain db=new DBMain();
		Connection connect=db.getConnection();
		String s="update user set password=? where email=?";
		PreparedStatement ps=connect.prepareStatement(s);
		ps.setString(1, password);
		ps.setString(2, email);
		ps.executeUpdate();
	}
	
	public void deleteUser(String email) throws SQLException, ClassNotFoundException {
		DBMain db=new DBMain();
		Connection connect=db.getConnection();
		String s="delete from user where email=?";
		PreparedStatement ps=connect.prepareStatement(s);
		ps.setString(1, email);
		ps.executeUpdate();
	}
	
	public List<User> getUserList() throws SQLException, ClassNotFoundException {
		DBMain db=new DBMain();
		Connection connect=db.getConnection();
		String s="select * from user";
		PreparedStatement ps=connect.prepareStatement(s);
		ResultSet rs=ps.executeQuery();
		List<User> list=new ArrayList<>();
		while(rs.next()) {
			User user=new User();
			user.name=rs.getString("name");
			user.email=rs.getString("email");
			user.password=rs.getString("password");
			list.add(user);
		};
		
		return list;
	}
}