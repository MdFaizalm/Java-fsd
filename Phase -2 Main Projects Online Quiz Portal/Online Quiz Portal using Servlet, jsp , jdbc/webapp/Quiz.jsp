<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.example.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz</title>
</head>
<body>	
		<a href="adminPage.jsp">Go back</a>
		<h1>Quiz Details</h1>
		<% 
			QuizOperations qo=new QuizOperations();
			List<Quiz> list=qo.getQuiz();%>
			<table border="1" width="50">
					<tr><th>No.</th><th>Quiz Title</th><th>Category</th></tr>
			<% for(Quiz a:list){%>			
				<tr><td><%=a.id %></td><td><%=a.title %></td><td><%=a.category %></td></tr>		
			<%}%>
			</table>
</body>
</html>