<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>FedChoice Bank</title>
        <link rel="stylesheet" type="text/css" href="CSS/style.css">

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://fonts.googleapis.com/css2?family=Barlow&family=Open+Sans:wght@600&family=Roboto&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    </head>
    <body>
        <div class="container-fluid header-container">
            <div class="container nav-container">
                <h3><strong><span style="color: #ffd300;">FedChoice</span><span style="color: #fff;"> Bank</span></strong></h3>
                <nav class="navbar">
                    <ul class="nav navbar-nav">
                        <li><a href="#">Home</a></li>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Customer Management<span class="caret"></span></a>
                          <ul class="dropdown-menu">
                            <li><a href="#">Create Customer</a></li>
                            <li><a href="#">Search Customer</a></li>
                            <li><a href="#">Update Customer</a></li>
                            <li><a href="#">Delete Customer</a></li>
                          </ul>
                        </li>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Account Management<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                              <li><a href="#">Create Account</a></li>
                              <li><a href="#">Search Account</a></li>
                              <li><a href="#">Delete Account </a></li>
                             </ul>
                          </li>
                          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Status Details<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                              <li><a href="#">Customer Status</a></li>
                              <li><a href="#">Accounts Status</a></li>
                              <li><a href="#"></a></li>
                            </ul>
                          </li>
                          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Account Operations<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                              <li><a href="#">Deposit</a></li>
                              <li><a href="#">Withdraw</a></li>
                              <li><a href="#">Transfer/a></li>
                            </ul>
                          </li>
                        <li><a href="#">Logout</a></li>
                    </ul>
                </nav>
            </div>
        </div>

        <div class="container-fluid main-container">
         <h2 class="text-center"><strong>Create Customer Screen</strong></h2>
            <form action="/" method="">
                <strong>Customer SSN Id</strong><span class="asteric"> * </span>
                <input type="name" id="custSsnId"/><br>
                <strong>Customer Name</strong><span class="asteric"> * </span>
                <input type="text" name="custName" id="custName" /><br>
                <strong>Age</strong><span class="asteric"> * </span>
                <input type="number" name="age" id="age" /><br>
                <strong>Address</strong><span class="asteric"> * </span>
                <input type="text" name="address" id="address" /><br>
                <strong>State</strong><span class="asteric"> * </span>
                <select id="select-state">
                    <option value="select">Select</option>
                    <option value="state1">State 1</option>
                    <option value="state2">State 2</option>
                    <option value="state3">State 3</option>
                </select><br>
                <strong>City</strong><span class="asteric"> * </span>
                <select id="select-city">
                    <option value="city">City</option>
                    <option value="city1">City 1</option>
                    <option value="city2">City 2</option>
                    <option value="city3">City 3</option>
                </select><br><br>
                <strong><span style="color: red;">(*)Fields are compulsory</span></strong><br><br>

                <button type="button" name="submit" class="btn">Submit</button>
                <button type="button" name="reset" class="btn">Reset</button><br><br><br>
            </form>
            
            <footer>
                <div class="footer-section">
                    <nav class="navbar navbar-footer">
                        <ul class="nav navbar-nav">
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">Services</a></li>
                            <li><a href="#">Contact Us</a></li>
                        </ul>
                    </nav>
                </div>
            </footer>
        </div>
    </body>
</html>
