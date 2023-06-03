<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.example.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Question</title>
</head>
<body>
	<a href="adminPage.jsp">Go back</a>
		<h1>Add New Question</h1><br>
		<form action="">
			Enter Question : <input type="text" maxlength="200" name="question" required><br><br>
			Enter option A : <input type="text" maxlength="200" name="option1" required><br><br>
			Enter option B : <input type="text" maxlength="200" name="option2" required><br><br>
			Enter option C : <input type="text" maxlength="200" name="option3" required><br><br>
			Enter option D : <input type="text" maxlength="200" name="option4" required><br><br>
			Enter answer option : <select name="answer">
			<option>A</option>
			<option>B</option>
			<option>C</option>
			<option>D</option>
			</select><br><br>
			<input type="submit" value="Add Question" name="addnew">
		</form>
		<%
			if(request.getParameter("addnew")!=null){
				QuestionsOperations qo=new QuestionsOperations();
				Questions q=new Questions();
				q.question=request.getParameter("question");
				q.option1=request.getParameter("option1");
				q.option2=request.getParameter("option2");
				q.option3=request.getParameter("option3");
				q.option4=request.getParameter("option4");
				q.answer=request.getParameter("answer");
				qo.insert(q);
				out.print("<h3 align='left'>Question added Successfully</h3>");
				
			}
		%>
</body>
</html>