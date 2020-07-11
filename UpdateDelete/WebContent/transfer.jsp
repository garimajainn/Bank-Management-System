<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer Money</title>
</head>
<body>
<%@ include file = "header.jsp" %>
<br>
<center>

<h2>TRANSFER MONEY</h2>
<form action="BankingController" method="post" name="transferMoney">
<input type="hidden" name ="source" value="transfer1">
<table >
<tr>
<th>SSN Id: </th>
<td><input type="number" name="id"></td>
</tr>
<tr>
<th>Source Account Type: </th>
<td><select name="source-account"><option></option><option>Savings</option><option>Current</option></select></td>
</tr>
<tr>
<th>Target Account Type: </th>
<td><select name="target-account"><option></option><option>Savings</option><option>Current</option></select></td>
</tr>
<tr>
<th>Transfer Amount</th>
<td><input type="number" name="tranfer-amt"></td>
</tr>
</table>
<input type="submit" value="Tranfer">
</form>

</center>
<br>
<%@ include file = "footer.jsp" %>
</body>
</html>