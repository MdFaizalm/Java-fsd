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
	QuestionsOperations qo=new QuestionsOperations();
	List<Questions> list=qo.getQuestions();%>
	
	 <form action="Leaderboard.jsp" method="post">
	<% int index = 1; %>
	<% for(Questions a:list){%>
		<h3><%= index %>)  <%= a.question %></h3>
		<label>
           <input type="radio" name="<%= a.id %>" value="<%= a.option1 %>">
          <%= a.option1 %>
        </label><br>
        		<label>
           <input type="radio" name="<%= a.id %>" value="<%= a.option2 %>">
          <%= a.option2 %>
        </label><br>
        <label>
           <input type="radio" name="<%= a.id %>" value="<%= a.option3 %>">
          <%= a.option3 %>
        </label><br>
        <label>
           <input type="radio" name="<%= a.id %>" value="<%= a.option4 %>">
          <%= a.option4 %>
        </label>
        <br>
        <% index++; %>
	<%}%><br>
		
	<input type="submit" name="submit" value="Submit" required> <br><br>
	 </form>
	
</body> 

</html>
