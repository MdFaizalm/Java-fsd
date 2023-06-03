<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-light bg-light"
		style="box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);">
		<div class="container-fluid">
			<div class="navbar-header"></div>
			<ul class="nav navbar-nav">
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="#">
						<span class="glyphicon glyphicon-user"></span>
						<%=session.getAttribute("name")%>
					</a>
				</li>
				<li>
					<a href="#" style="display: inline-flex">
						<span class="glyphicon glyphicon-log-out" style="top: 6px !important; right: 5px;"></span>
						<form action="">
							<input type="submit" name="logout" value="log out">
						</form> 
					</a>
				</li>
			</ul>
		</div>
	</nav>
	<h1 style="text-align: center">Welcome!!</h1>
		<h3  style="text-align: center">Please Click here <a href="StartQuiz.jsp">quiz link</a> to attempt the Quiz. </h3>

		<%
			if(request.getParameter("logout")!=null){
				session.invalidate();
				response.sendRedirect("login.jsp");
			}
		%>
</body>
</html>
