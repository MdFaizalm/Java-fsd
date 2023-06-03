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
<a href="UsersDetails.jsp">Go back</a>
		<h1>Edit User Records</h1>
		<h1>Change User Name</h1>
		<form action="">
			<input type="hidden" name="email" value="<%=request.getParameter("email")%>">
			Enter new Name : <input type="text" name="name"><br><br>
			<input type="submit" name="updateName" value="update name">
		</form>
		<%
			if(request.getParameter("updateName")!=null){
				UserMain usermain=new UserMain();
				usermain.updateName(request.getParameter("email"),request.getParameter("name"));
				out.print("<h3>User Name updated successfully</h3>");
			} 
		%> 
		<hr> 
		<h1>Change User Password</h1>
		<form action="">
			<input type="hidden" name="email" value="<%=request.getParameter("email")%>">
			Enter new password : <input type="text" name="password"><br><br>
			<input type="submit" name="updatePassword" value="update password">
		</form>
		<%
			if(request.getParameter("updatePassword")!=null){
				UserMain usermain=new UserMain();
				usermain.updatePass(request.getParameter("email"),request.getParameter("password"));
				out.print("<h3>User Password updated successfully</h3>");
			} 
		%> 	
</body>
</html>