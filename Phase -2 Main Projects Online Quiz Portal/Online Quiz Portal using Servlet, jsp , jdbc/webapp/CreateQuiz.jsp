<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Quiz</title>
</head>
<body>
	<a href="adminPage.jsp">Go back</a>
		<h1>Create Quiz</h1>
		<form action="">
			Quiz title : <input type="text" name="title"><br><br>
			Category : <select name="category"><option>Mathematics</option><option>Science</option></select><br><br>
			<input type="submit" value="CreateQuiz" name="CreateQuiz">		
		</form>
	
	<% 
		if(request.getParameter("CreateQuiz")!=null){
			QuizOperations qo=new QuizOperations();
			qo.insert(request.getParameter("title"),request.getParameter("category"));
			out.print("<h3 align='left'> Quiz Added Successfully</h3>");
		}
	%>
</body>
</html>