<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.bean.*" %>
	<!DOCTYPE html>
	<html>
	<head>
	<title>Your's Choice/Transfer</title>	
	</head>
	<body>
	<% Banker obs = (Banker)request.getAttribute("banker"); %>
	<% Banker obt = (Banker)request.getAttribute("bankert"); %>
		<%@ include file = "header.jsp" %>
	
		<h2 class="text-center">Transfer Money</h2><br><br><br>
				<center>
				<form action="BankingController" method="post" name="transferForm" autocomplete="off">
					<input type="hidden" name="source" value="transfer">
							
				<span>Source Account Id</span>
					<input type="text" name="sacc" id="source-account" value="<%=obs.getCssnid() %>" >
					<br>
				<span>Target Account Id</span>
					<input type="text" name="tacc" id="target-account" value="<%=obt.getCssnid() %>" >
					<br>
				<span>Source Account Balance</span]>
					<input type="text" name="sbal" value="<%=obs.getBalance() %>" >
					<br>
				<span>Target Account Balance</span>
					<input type="text" name="tbal" value="<%=obt.getBalance() %>" >
					<br>
				<span>Transfer Amount</span>
					<input type="number" name="amt" id="tranfer-amt" required="required">
					<br>
					<button type="submit" class="btn btn-transfer">Confirm Transfer</button>
				
				</form>
				</center>
			
		<%@ include file = "footer.jsp" %>
	</body>
	</html>