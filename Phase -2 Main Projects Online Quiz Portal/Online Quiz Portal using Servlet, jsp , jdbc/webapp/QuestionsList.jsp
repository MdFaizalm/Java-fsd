<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question List</title>
</head>
<body>
	<a href="adminPage.jsp">Go back</a>
	<h1>Quiz Details</h1>
	<% 
	QuestionsOperations qo=new QuestionsOperations();
	List<Questions> list=qo.getQuestions();%>
	<table border="1">
	<tr><th>No.</th><th>Question</th><th>Option A</th><th>Option B</th><th>Option C</th><th>Option D</th><th>Correct option</th><th>Edit</th><th>Delete</th></tr>
	<% for(Questions a:list){%>
	<tr><td><%=a.id %></td><td><%=a.question %></td><td><%=a.option1 %></td><td><%=a.option2 %></td><td><%=a.option3 %></td><td><%=a.option4 %></td><td><%=a.answer %></td><td>
	<form action="EditQuestion.jsp"><input type="hidden" name="id" value="<%=a.id %>">
	<input type="submit" value="Edit" name="editQues"></form></td><td>
	<form action=""><input type="hidden" name="id" value="<%=a.id %>">
	<input type="submit" value="Delete" name="deleteQuestion"></form></td></tr>							
	<%}%>
	</table>		
		<% 
			if(request.getParameter("deleteQuestion")!=null){
			QuestionsOperations qq=new QuestionsOperations();
			qq.deleteQues(request.getParameter("id"));
			response.sendRedirect("QuestionsList.jsp");
			}
		%>
</body>
</html>