<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Transfer Money</title>

    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://fonts.googleapis.com/css2?family=Barlow&family=Open+Sans:wght@600&family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script>
    function onclick() {
        location.replace("Index.jsp");
    }</script>
</head>
<body>
    <div class="container-fluid header-container">
        <div class="container nav-container">
            <h3><strong><span class="fed-choice" style="color: #ffd300;">FedChoice</span><span class="bank" style="color: #fff;"> Bank</span></strong></h3>
            <nav class="navbar">
                <ul class="nav navbar-nav">
                    <li><a href="#">Home</a></li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Customer Management <span class="caret"></span></a>
                      <ul class="dropdown-menu">
                        <li><a href="#">Customer Management-1</a></li>
                        <li><a href="#">Customer Management-2</a></li>
                        <li><a href="#">Customer Management-3</a></li>
                      </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Account Manager <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                          <li><a href="#">Account Manager-1</a></li>
                          <li><a href="#">Account Manager-2</a></li>
                          <li><a href="#">Account Manager-3</a></li>
                        </ul>
                      </li>
                      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Status Details <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                          <li><a href="#">Customer Status-1</a></li>
                          <li><a href="#">Customer Status-2</a></li>
                          <li><a href="#">Customer Status-3</a></li>
                        </ul>
                      </li>
                      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Account Operations <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                          <li><a href="#">Account Operations-1</a></li>
                          <li><a href="#">Account Operations-2</a></li>
                          <li><a href="#">Account Operations-3</a></li>
                        </ul>
                      </li>
                    <li><a href="#">Logout</a></li>
                </ul>
            </nav>
        </div>
    </div>

    <div class="container-fluid main-container">
        <div class="container container-transfer-money">
        
            <h2 class="text-center">Transfer Money</h2><br><br><br>
            
            <div class="row">
                <div class="col-md-6">
                    <span>Customer ID</span>
                </div>
                <div class="col-md-6">
                    <input type="number" name="id" id="id" value="100000265">
                </div>
            </div><br>
            <div class="row">
                <div class="col-md-6">
                    <span>Source Account Type</span>
                </div>
                <div class="col-md-6">
                    <select name="source-account" id="source-account">
                        <option value="Saving Account">Saving Account</option>
                        <option value="Current Account">Current Account</option>
                       
                    </select>
                </div>
            </div><br>
            <div class="row">
                <div class="col-md-6">
                    <span>Target Account Type</span>
                </div>
                <div class="col-md-6">
                    <select name="target-account" id="target-account">
                        <option value="Saving Account">Saving Account</option>
                        <option value="Current Account">Current Account</option>
                        
                    </select>
                </div>
            </div><br>
            <div class="row">
                <div class="col-md-6">
                    <span>Transfer Amount</span>
                </div>
                <div class="col-md-6">
                    <input type="number" name="tranfer-amt" id="tranfer-amt">
                </div>
            </div><br>
            <div>
            <button type="button" class="btn btn-transfer" onclick="onclick()">Transfer</button>
              
                <input type="button" value="Create" onclick="location.href='@Url.Action("post", "BankingController")'" />
            
            </div>
            
        </div>
    </div>
    <footer>
      <div class="footer-section">
          <div class="container-fluid footer-details">
              <div class="row">
                  <div class="col-md-5">
                      <h4>About Us</h4>
                      <span align="justify">FedChoice Bank was founded on 14thjune 2016 with the objective of providing the detail services based on Retail Banking Operation. The Retail Internet banking of FedChoice Bank offers a plethora of products and services, to cater it's customer by providing certain animus services with an easy volving offers and ways to do the required job without hurdling the process.</span>
                  </div>
                  <div class="col-md-3 services-links">
                      <h4>Services</h4>
                      <!-- <span align="justify">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</span> -->
                      <ul>
                        <li><a href="#">Retail and Customer Banking</a></li>
                        <li><a href="#">Personal Internet Banking</a></li>
                        <li><a href="#">Corporate Internet Banking</a></li>
                        <li><a href="#">Debit and Credit Cards</a></li>
                      </ul>
                  </div>
                  <div class="col-md-4">
                      <h4>Contact Us</h4>
                      <!-- <span align="justify">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</span> -->
                      <ul class="contact-details">
                        <li>Email: <a href="mailto:customer.service@fedchoice.com">customer.service@fedchoice.com</a></li>
                        <li>Contact No: <a href="tel:022-42406778">022-42406778, 022-54567890</a></li>
                        <address>
                          Corporate Office, Madame Cama Road, Mariman Point, Mumbai, Maharashtra 400021
                        </address>
                      </ul>
                  </div>
              </div>
          </div>
      </div>
      <div class="footer-icon">
          <div class="container">
              <div class="row">
                  <div class="col-md-4">
                      <p>Copyright &copy All rights reserved by <span style="color: #ffd300;">FedChoice Bank</span></p>
                  </div>
                  <div class="col-md-4">
                    
                  </div>
                  <div class="col-md-4">
                    <span style="color: #fff;">Contact Us </span>
                    <span><i class="fa fa-facebook-official" aria-hidden="true"></i></span>
                    <span><i class="fa fa-twitter-square" aria-hidden="true"></i></span>
                    <span><i class="fa fa-google-plus-square" aria-hidden="true"></i></span>
                    <span><i class="fa fa-linkedin-square" aria-hidden="true"></i></span>
                  </div>
              </div>
          </div>
      </div>
    </footer>
</body>
</html>