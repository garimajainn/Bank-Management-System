<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw</title>
</head>
<body>
<% Banker obj = (Banker)request.getAttribute("banker"); %>
	<center>
	<%@ include file = "header.jsp" %>
		<h1>Withdraw Amount</h1><br><br>
		<form action="BankingController" method="post" name="withdrawForm" autocomplete="off">
		<input type="hidden" name="source" value="withdraw">
			<table style="width: 50%">
				<tr>
					<td>Customer SSN Id</td>
					<td><input type="text" name="ssnid" value="<%=obj.getCssnid()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Customer ID</td>
					<td><input type="text" name="cid" value="<%=obj.getCid() %>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Account ID</td>
					<td><input type="text" name="accid" value="<%=obj.getAccid()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Account Type</td>
					<td><input type="text" name="acctype" value="<%=obj.getAcctype() %>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Account Balance</td>
					<td><input type="text" name="balance" value="<%=obj.getBalance() %>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Withdrawal Amount</td>
					<td><input type="text" name="amt" required="required"></td>
				</tr>	
				<tr>
					<td></td><td><br><br><button type="submit" value="Submit" />Withdraw</td>
				</tr>
			</table>
		</form>
	</center>
	<br>
	<%@ include file = "footer.jsp" %>

</body>
</html>