<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Banker obj = (Banker)request.getAttribute("banker"); %>
	<center>
	<%@ include file = "header.jsp" %>
		<h1>Delete Customer</h1><br><br>
		<form action="BankingController" method="post" name="deleteCustForm" autocomplete="off">
		<input type="hidden" name="source" value="deleteCust">
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
					<td>Name</td>
					<td><input type="text" name="custname" value="<%=obj.getCustName() %>" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" value="<%=obj.getCustAddress() %>"readonly="readonly"/></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="number" name="age" value="<%=obj.getCustAge() %>"readonly="readonly"/></td>
				</tr>
				
				<tr>
					<td><br><br><button type="cancel" value="Cancel" />Cancel</td><td><br><br><button type="submit" value="Delete" />Confirm Delete</td>
				</tr>
			</table>
		</form>
		
	</center>
	<br>
	<%@ include file = "footer.jsp" %>
</body>
</html>