<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
	<%@ include file = "header.jsp" %>
		<h1>View Customer</h1>
		<br>
		<br>
		<form action="BankingController" method="post" name="searchCustForm">
			<input type="hidden" name="source" value="searchCust"> Enter
			SSN Id : <input type="text" name="vssnid"><br>
			<br>
			<center>OR</center>
			<br><br>
			Enter Customer Id : <input type="text" name="vcid"><br>
			<br> <br>
			<br>
			<button type="submit" value="View">View</button>
		</form>
	</center>
	<br>
	<%@ include file = "footer.jsp" %>
</body>
</html>