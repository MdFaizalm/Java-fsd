<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>
		<h1 align='center'>Welcome Back Admin!</h1>
		<form action="" >
		EmailId :<input type="email" name="email" required><br><br>
		Password :<input type="password" name="password" required><br><br>
		<input type="submit" value="login" name="admin" >
		</form>
	<%
	System.out.println("Entering admin login---");
	System.out.println(request.getParameter("email"));
	System.out.println(request.getParameter("password"));
	System.out.println(request.getParameter("admin"));
		if(request.getParameter("admin")!=null){
			if(request.getParameter("email").equals("admin@gmail.com") && request.getParameter("password").equals("admin")){
				response.sendRedirect("adminPage.jsp");
			}
			else{
				out.print("<h3 align='left'>Wrong credentials! Please try again..</h3>");
			}
		}
	%>
</body>
</html>