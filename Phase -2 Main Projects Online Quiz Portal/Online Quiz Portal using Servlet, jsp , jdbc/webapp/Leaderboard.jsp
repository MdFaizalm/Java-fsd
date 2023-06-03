<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.example.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leader Board</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<%
QuestionsOperations qo = new QuestionsOperations();
List<Questions> list = qo.getQuestions();
int totalQuestions = list.size();
int correctAnswers = 0;

for (Questions question : list) {
    String selectedOption = request.getParameter(String.valueOf(question.id));
    String correctOption = question.answer;

    if (selectedOption != null && selectedOption.equals(correctOption)) {
        correctAnswers++;
    }
}
double percentage = (correctAnswers / (double) totalQuestions) * 100;
%>
<div class="jumbotron">
    <h1 class="text-center">Quiz Result</h1>
 </div>   
 	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<table class="table table-bordered table-striped table-hover">
		         <thead>
		         	<th>Id</th>
		         	<th>User</th>
		        	<th>Score</th>
		         </thead>
		         <tr>
						<td> 1 </td>
						<td> <%= session.getAttribute("name") %> </td>
					    <td><%= correctAnswers %></td>	
				</tr>  
			</table>
		</div>
		<div class="col-md-2"></div> 
	</div>	 
</body>
</html>