<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Question</title>
</head>
<body>
<a href="QuestionsList.jsp">Go back</a>
		<h3>Edit Question records</h3>
		<h3>Edit Question</h3>
		<form action="">
			<input type="hidden" name="id" value="<%=request.getParameter("id")%>">
			Enter New Question : <input type="text" name="question"><br><br>
			<input type="submit" name="updateQuestion" value="update question">
		</form>
		<%
			if(request.getParameter("updateQuestion")!=null){
				QuestionsOperations qo=new QuestionsOperations();
				qo.updateQuestion(request.getParameter("id"),request.getParameter("question"));
				out.print("<h3 align='center' style='color:blue'>Question updated successfully</h3>");
			} 
		%> 
		<hr>
		<h3>Edit option 1</h3>
		<form action="">
			<input type="hidden" name="id" value="<%=request.getParameter("id")%>">
			Enter new option 1 : <input type="text" name="option1"><br><br>
			<input type="submit" name="updateOption1" value="update option 1">
		</form>
		<%
			if(request.getParameter("updateOption1")!=null){
				QuestionsOperations qo=new QuestionsOperations();
				qo.updateoption1(request.getParameter("id"),request.getParameter("option1"));
				out.print("<h3 align='center'>Option 1 updated successfully</h3>");
			}  
		%> 
		
		
		<hr>
		<h3>Edit option 2</h3>
		<form action="">
			<input type="hidden" name="id" value="<%=request.getParameter("id")%>">
			Enter new option 2 : <input type="text" name="option2"><br><br>
			<input type="submit" name="updateOption2" value="update option 2">
		</form>
		<%
			if(request.getParameter("updateOption2")!=null){
				QuestionsOperations qo=new QuestionsOperations();
				qo.updateoption2(request.getParameter("id"),request.getParameter("option2"));
				out.print("<h3 align='center'>Option 2 updated successfully</h3>");
			}  
		%>
		
		<hr>
		<h3>Edit option 3</h3>
		<form action="">
			<input type="hidden" name="id" value="<%=request.getParameter("id")%>">
			Enter new option 3 : <input type="text" name="option3"><br><br>
			<input type="submit" name="updateOption3" value="update option 3">
		</form>
		<%
			if(request.getParameter("updateOption3")!=null){
				QuestionsOperations qo=new QuestionsOperations();
				qo.updateoption3(request.getParameter("id"),request.getParameter("option3"));
				out.print("<h3 align='center'>Option 3 updated successfully</h3>");
			}  
		%> 
		
		<hr>
		<h3>Edit option 4</h3>
		<form action="">
			<input type="hidden" name="id" value="<%=request.getParameter("id")%>">
			Enter new option 4 : <input type="text" name="option4"><br><br>
			<input type="submit" name="updateOption4" value="update option 4">
		</form>
		<%
			if(request.getParameter("updateOption4")!=null){
				QuestionsOperations qo=new QuestionsOperations();
				qo.updateoption4(request.getParameter("id"),request.getParameter("option4"));
				out.print("<h3 align='center'>Option 4 updated successfully</h3>");
			}  
		%> 
		
		<hr>
		<h3>Edit Correct Option</h3>
		<form action="">
			<input type="hidden" name="id" value="<%=request.getParameter("id")%>">
			Enter the new correct option : <select name="correct">
			<option>A</option>
			<option>B</option>
			<option>C</option>
			<option>D</option>
			</select><br><br>
			<input type="submit" name="updateOption" value="update option correct">
		</form>
		<%
			if(request.getParameter("updateOption")!=null){
				QuestionsOperations qo=new QuestionsOperations();
				qo.updateanswer(request.getParameter("id"),request.getParameter("correct"));
				out.print("<h3 align='center'>Option Answer Updated Successfully</h3>");
			}  
		%> 
		
</body>
</html>