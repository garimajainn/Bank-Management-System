<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Customer</title>
</head>
<body>
<% Banker obj = (Banker)request.getAttribute("banker"); %>
	<center>
	<%@ include file = "header.jsp" %>
		<h1>Update Customer</h1><br><br>
		<form action="BankingController" method="post" name="updateCustForm" autocomplete="off">
		<input type="hidden" name="source" value="updateCust">
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
					<td>Old Name</td>
					<td><%=obj.getCustName() %></td>
				</tr>
				<tr>
					<td>New Name</td>
					<td><input type="text" name="custname" required="required" /></td>
				</tr>
				<tr>
					<td>Old Address</td>
					<td><%=obj.getCustAddress() %></td>
				</tr>
				<tr>
					<td>New Address</td>
					<td><input type="text" name="address" required="required"/></td>
				</tr>
				<tr>
					<td>Old Age</td>
					<td><%=obj.getCustAge() %></td>
				</tr>
				<tr>
					<td>New Age</td>
					<td><input type="number" name="age" required="required"/></td>
				</tr>
				
				<tr>
					<td></td><td><br><br><button type="submit" value="Update" />Update</td>
				</tr>
			</table>
		</form>
	</center>
	<br>
	<%@ include file = "footer.jsp" %>
</body>
</html>