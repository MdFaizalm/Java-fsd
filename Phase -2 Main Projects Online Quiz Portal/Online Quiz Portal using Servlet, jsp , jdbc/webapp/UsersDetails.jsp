<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
		<a href="adminPage.jsp">Go back</a>
		<h1>User Details</h1>
		<% 
			UserMain qo=new UserMain();
			List<User> list=qo.getUserList();%>
			<table border="1">
			<tr><th>User Name</th><th>User Email</th><th>User Password</th><th>Edit User</th><th>Delete User</th></tr>
			<% for(User user:list){%>			
			<tr><td><%=user.name %></td><td><%=user.email %></td><td><%=user.password %></td><td>
			<form action="EditUser.jsp"><input type="hidden" name="email" value="<%=user.email %>">
			<input type="submit" value="Edit" name="editUser"></form></td><td>
			<form action=""><input type="hidden" name="email" value="<%=user.email %>">
			<input type="submit" value="Delete" name="deleteUser"></form></td></tr>		
			<%}%>
			</table>
			<% 
				if(request.getParameter("deleteUser")!=null){
					UserMain usermain=new UserMain();
					usermain.deleteUser(request.getParameter("email"));
					response.sendRedirect("UsersDetails.jsp"); 
				}
			%>
</body>
</html>