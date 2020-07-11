<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your's Choice/Deposit</title>
</head>
<body>
<% Banker obj = (Banker)request.getAttribute("banker"); %>
	<center>
	<%@ include file = "header.jsp" %>
	
		<h2 class="text-center">Deposit Money</h2><br><br><br>
		<form action="BankingController" method="post" name="depositForm" autocomplete="off">
		<input type="hidden" name="source" value="deposit">
		<center>
			<table style="width: 50%">
				<tr>
					<td>Customer SSN Id</td>
					<td><input type="text" name="ssnid" value="<%=obj.getCssnid()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Customer Id</td>
					<td><input type="text" name="cid" value="<%=obj.getCid() %>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Account Id</td>
					<td><input type="text" name="accid" value="<%=obj.getAccid()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Account Type</td>
					<td><input type="text" name="acctype" value="<%=obj.getAcctype()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Account Balance</td>
					<td><input type="text" name="balance" value="<%=obj.getBalance()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Deposit Amount</td>
					<td><input type="text" name="amt" required="required"></td>
				</tr>								
				<tr>
					<td><br><br><button type="cancel" value="Cancel" />Back</td><td><br><br><button type="submit" value="Submit" />Deposit </td>
				</tr>
			</table>
			</center>
		</form>
	</center>
	<br>
	<%@ include file = "footer.jsp" %>
</body>
</html>