<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>	
	<h1>Welcome Admin!</h1>
	<form action="">
	<input type="submit" value="logout" name="signout"><br><br>
	</form>
	<%
		if(request.getParameter("signout")!=null){
			response.sendRedirect("admin.jsp");
		}
	%>
		<table border="10" cellspacing="30">
		<tr><th>User </th><th>Quiz </th><th>Question </th></tr>
		<tr><td><a href="AddUser.jsp">Add New user</a></td><td><a href="CreateQuiz.jsp">Create New Quiz</a></td><td><a href="AddQuestion.jsp">Add New Question</a></td></tr>
		<tr><td><a href="UsersDetails.jsp">User Details</a></td><td><a href="Quiz.jsp">Quiz Details</a></td><td><a href="QuestionsList.jsp">Question Details</a></td></tr>
		</table>
</body>
</html> 