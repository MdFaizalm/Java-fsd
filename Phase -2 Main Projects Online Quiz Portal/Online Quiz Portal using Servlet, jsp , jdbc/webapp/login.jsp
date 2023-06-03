<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Quiz Portal</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="jumbotron">
		<h1 class="text-center">Welcome to Quiz portal</h1>
	</div>
		<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
		<form action="">
			<label class="control-label">Enter email Id</label>
			<input type="email" name="email" required class="form-control" ><br>
			<label class="control-label">Enter password </label>
			<input type="password" name="password" required class="form-control" ><br>
			<input type="submit" name="signin" value="signin" required class="btn btn-success"><br><br>
		</form>

		Do not have an Account ? <a href="User.jsp">Sign up</a>
		</div>
		<div class="col-md-4"></div>
	</div>
		<%
			UserMain usermain=new UserMain();   	
			if(request.getParameter("signin")!=null){
				String name=usermain.validate(request.getParameter("email"),request.getParameter("password"));
				if(!name.equals("Error")){
					session.setAttribute("name",name);
					response.sendRedirect("dashboard.jsp");
				}
				else{
					response.sendRedirect("fail.jsp");
				}
			}
		%>
</body>
</html>