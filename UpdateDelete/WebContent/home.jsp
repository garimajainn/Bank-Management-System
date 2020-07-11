<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your's Choice/Home page</title>
</head>
<body>

<% if(session.getAttribute("uname") == null)
	{
		response.sendRedirect("login.jsp");
	}%>
	
	
	
	<center>
	<%@ include file = "header.jsp" %>
	<%
	String name = (String)request.getAttribute("uname");
	if(name != null)
	{
		out.println("<font color=green><h2>Welcome : "+name+"</h2></font>");
	}
	%>
	
	
	 </h2>
	</center>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<%@ include file = "footer.jsp" %>
</body>
</html>