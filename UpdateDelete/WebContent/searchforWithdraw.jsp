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
		<h1>Search Account</h1>
		<br>
		<br>
		<form action="BankingController" method="post" name="searchAccForm">
			<input type="hidden" name="source" value="searchWithdraw"> 
			Enter SSN Id : <input type="text" name="vssnid"><br>
			<br>
			<center>OR</center>
			<br><br>
			Enter Customer Id : <input type="text" name="vcid"><br>
			<br>
			<center>OR</center>
			<br><br>
			Enter Account Id : <input type="text" name="accid"><br>
			<br> <br>
			<button type="submit" value="View">Proceed</button>
		</form>
	</center>
	<br>
	<%@ include file = "footer.jsp" %>
</body>
</html>