<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<script src="Javascript/validation.js" type="text/javascript">
</script>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 30%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 8px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 14%;
}

button:hover {
  opacity: 0.8;
}

.container {
  padding: 16px;
}

</style>
</head>
<body>
	<center>
		<h3>Login Page</h3>
		<form action="BankingController" method="post" name="loginForm"
			autocomplete="off">
			<input type="hidden" name="source" value="login">
			<div class="container" style="background-color:lightblue">
			 <input type="text" name="username" placeholder="Username" onchange="alphanumeric()" required>
			 <br><br> 
			 <input type="password" name="password"	placeholder="Password" onchange="chkPassword()" required>
			 <br><br>
			 <button type="submit" value="Login">Login</button>
			 </div>
			


		</form>
	</center>

</body>
</html>