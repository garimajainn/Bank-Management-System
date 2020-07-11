<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <link rel="stylesheet" type="text/css" href="style.css">

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
                <h3><strong><span style="color: #ffd300;">Your's Choice</span><span style="color: #fff;"> Bank</span></strong></h3>
                <nav class="navbar">
                    <ul class="nav navbar-nav">
                        <li><a href="home.jsp">Home</a></li>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Customer Management <span class="caret"></span></a>
                          <ul class="dropdown-menu">
                            <li><a href="createCust.jsp">Create Customer</a></li>
                            <li><a href="searchCustupd.jsp">Update Customer</a></li>
                            <li><a href="searchCustdel.jsp">Delete Customer</a></li>
                           </ul>
                        </li>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Account Management <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                             <li><a href="createAcc.jsp">Create Account</a></li>
                              <li><a href="searchAccdel.jsp">Delete Account </a></li>
                              
                             
                            </ul>
                          </li>
                          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Search <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                             <li><a href="searchCust.jsp">Customer Search</a></li>
                              <li><a href="searchAcc.jsp">Accounts Search</a></li>
                            </ul>
                          </li>
                          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Status Details <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                             <li><a href="BankingController?source=cstatus">Customer Status</a></li>
                              <li><a href="BankingController?source=astatus">Accounts Status</a></li>
                            </ul>
                          </li>
                          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Account Operations <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                              <li><a href="searchforDeposit.jsp">Deposit</a></li>
                              <li><a href="searchforWithdraw.jsp">Withdraw</a></li>
                              <li><a href="transfer.jsp">Transfer</a></li>
                              <li><a href="accStatement.jsp">Account Statement</a></li>
                            </ul>
                          </li>
                        <li><a href="BankingController?source=logout">Logout</a></li>
                        
                    </ul>
                </nav>
            </div>
        </div>

       
    </body>
</html>