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
	<center>
	<%@ include file = "header.jsp" %>
	<h1>Create Account</h1><br><br>
		<form action="BankingController" method="post" name="createAccForm" autocomplete="off">
		<input type="hidden" name="source" value="createAcc">
			<table style="width: 50%">
				<tr>
					<td>Customer Id</td>
					<td><input type="text" name="cid" required="required"/></td>
				</tr>
				<tr>
					<td> SSN Id </td>
					<td><input type="text" name="ssnid" required="required"/></td>
				</tr>
				
				<tr>
					<td>Account type</td>
					<td><select name="acctype" id="acctype" required="required" onchange="">
							<option value="" >Select Account</option>
							<option value="Savings">Savings</option>
							<option value="Current">Current</option>
						</select> <br> <br></td>
				</tr>
				<tr>
					<td>Deposit Amount</td>
					<td><input type="number" name="amt" required="required"/></td>
				</tr>

				<tr>
					<td><br><br></td><td><button type="submit" value="Submit" />Submit</td>
					
				</tr>
			</table>
		</form>
		
		<%
			//Scriplet to display Reg. successful message
			//After succcessful display customer id
			
			Integer accid = (Integer)request.getAttribute("accid");
			
			if(accid != null)
			{
				out.println("<font color=green><h2>Account creation initiated successfully .... </h2></font>");
				out.println("<font color=green><h2>Account Id : <u>"+accid+"</u></h2></font>");
			}	
			
			/*else
			{
				out.println("<br><font color=red><h2>Account creation Failed !!! </h2></font><br>");
			}*/
		%>		
		
	</center>
	<br>
	<%@ include file = "footer.jsp" %>
</body>
</html>