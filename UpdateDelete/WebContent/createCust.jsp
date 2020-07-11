<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Customer</title>

<script type="text/javascript">
	function populate(s1,s2){
	var s1 = document.getElementById(s1);
	var s2 = document.getElementById(s2);
	s2.innerHTML = "";
	if(s1.value == "Andhra Pradesh"){
		var optionArray = ["|","Amaravati|Amaravati","Vishakapatnam|Vishakapatnam","Vijayawada|Vijayawada"];
	} else if(s1.value == "Maharashtra"){
		var optionArray = ["|","Mumbai|Mumbai","Pune|Pune","Nagpur|Nagpur"];
	} else if(s1.value == "Tamil Nadu"){
		var optionArray = ["|","Chennai|Chennai","Madurai|Madurai","Coimbatore|Coimbatore"];
    }
    else if(s1.value == "West Bengal"){
		var optionArray = ["|","Kolkata|Kolkata","Durgapur|Durgapur","Asansol|Asansol"];
	}
    else if(s1.value == "Bihar"){
		var optionArray = ["|","Patna|Patna","Gaya|Gaya","Muzaffarpur|Muzaffarpur","Bihar Sharif|Bihar Sharif"];
	} else if(s1.value == "Chattisgarh"){
		var optionArray = ["|","Raipur|Raipur","Bilaspur|Bilaspur","Bhillai|Bhillai","Korba|Korba"];
	} else if(s1.value == "Gujarat"){
		var optionArray = ["|","Ahmedabad|Ahmedabad","Surat|Surat","Vadodara|Vadodara","Rajkot|Rajkot"];
    }
    else if(s1.value == "Kerala"){
		var optionArray = ["|","Thiruvananthapuram|Thiruvananthapuram","Kozhikode|Kozhikode","Kollam|Kollam","Kochi|Kochi"];
	}
	for(var option in optionArray){
		var pair = optionArray[option].split("|");
		var newOption = document.createElement("option");
		newOption.value = pair[0];
		newOption.innerHTML = pair[1];
		s2.options.add(newOption);
	}
}
</script>

			
</head>
<body>

<% if(session.getAttribute("uname") == null)
	{
		response.sendRedirect("login.jsp");
	}%>
	
	<%@ include file = "header.jsp" %>
	
	<center>
		<h1>Create Customer</h1>
		
		<form action="BankingController" method="post" name="createCustForm" autocomplete="off" >
		<input type="hidden" name="source" value="createCust">
		
			<table style="width: 50%" align="centre">
				<tr>
					<td>Customer SSN Id</td>
					<td><input type="text" name="ssnid" required="required"/></td>
				</tr>
				<tr>
					<td>Customer Name</td>
					<td><input type="text" name="custname" required="required" /></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="number" name="age" required="required"/></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" required="required"/></td>
				</tr>
				<tr>
					<td>State</td>
					<td><select name="state" id="stateSel" required="required" onchange="populate(this.id,'citySel')">
							<option value="" >Select state</option>
							<option value="Andhra Pradesh" >Andhra Pradesh</option>
							<option value="Bihar" >Bihar</option>
							<option value="Chattisgarh" >Chattisgarh</option>
							<option value="Gujarat" >Gujarat</option>
							<option value="Maharashtra" >Maharashtra</option>
							<option value="Kerala" >Kerala</option>
							<option value="Tamil Nadu" >Tamil Nadu</option>
							<option value="West Bengal" >West Bengal</option>							
					</select> <br> <br></td>
				</tr>
				<tr>
					<td>City</td>
					<td><select name="city" required="required" id="citySel" >
					<option value="" >Select city</option>
					</select> <br> <br></td>
				</tr>

				<tr>
					<td><button type="submit" value="Submit" />Submit</td>
					<td><button type="reset" value="Reset" />Reset</td>
				</tr>
			</table>
			
		</form>
		</center>
		
		<%
			//Scriplet to display Reg. successful message
			//After succcessful display customer id
			
			Integer customerId = (Integer)request.getAttribute("customerId");
			
			if(customerId != null)
			{
				out.println("<font color=green><h2> Customer creation initiated successfully .... </h2></font>");
				out.println("<font color=green><h2>Customer Id : <u>"+customerId+"</u></h2></font>");
			}	
			
			/*else
			{
				out.println("<br><font color=red><h2>Customer Registration Failed !!! </h2></font><br>");
			}*/
		%>		
		
	
	
	<%@ include file = "footer.jsp" %>
</body>
</html>