<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.bean.*,java.util.*" %>
<!DOCTYPE html>
<html>
	<style>
table, th, td {
  border: 0.8px solid black;
}
th, td {
	text-align: center;
  padding: 11px;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Account Status</title>
</head>
<body>
	<% ArrayList<Banker> blist = (ArrayList<Banker>)request.getAttribute("list"); %>
	<center>
	<%@ include file = "header.jsp" %>
	<h2>Account Status</h2>
	<table style="width:80%">
	<tr>
	<th>Customer ID</th>
	<th>Customer SSN ID</th>
	<th>Account Id</th>
	<th>Account Type</th>
	<th>Message</th>
	<th>Account Status</th>
	<th>Last Updated</th>
	<th>Operations</th>
	<th>View Profile</th>
	</tr>
	<% for(Banker ban:blist){ %>
	<tr>
	<td><%= ban.getCid() %></td>
	<td><%= ban.getCssnid() %></td>
	<td><%= ban.getAccid() %></td>
	<td><%= ban.getAcctype() %></td>
	<td><%= ban.getMessage() %></td>	
	<td><%= ban.getAccstatus() %></td>	
	<td><%= ban.getLastupd() %></td>
	<td><a href="BankingController?source=astatus">Refresh</a></td>
	<td><a href="viewCust.jsp">View Details</a></td>
	</tr>
	<% } %>
	
	</table>
	</center>
	<br>
	<%@ include file = "footer.jsp" %>
</body>
</html>