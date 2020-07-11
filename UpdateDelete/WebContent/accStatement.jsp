<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Your's Choice/Account Statement</title>
</head>
<body>
   <%@ include file = "header.jsp" %>

    <div class="container-fluid main-container">
        <div class="container container-account-statement">
            <h2 class="text-center">Account Statement</h2><br><br><br>
            <div class="row">
                <div class="col-md-6">
                    <span>Account ID</span>
                </div>
                <div class="col-md-6">
                    <input type="number" name="accId" id="accId" value="111011060">
                </div>
            </div><br>
            <div class="row">
                <div class="col-md-12">
                    <input type="radio" name="lastTransaction" id="lastTransaction"> Last Number of Transactions
                </div>
            </div><br>
            <div class="row">
                <div class="col-md-12">
                    <input type="radio" name="startEndDate" id="startEndDate"> Start-End Dates
                </div>
            </div><br>
            <div class="row">
                <div class="col-md-6">
                    <span>Number Of Transactions</span>
                </div>
                <div class="col-md-6">
                    <select name="account-statement" id="account-statement">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                </div>
            </div><br>
            <div>
                <button type="button" class="btn btn-acc-statement"><a href="accStatementDetails.jsp">Submit</button>
            </div>
        </div>
    </div>
 
   <%@ include file = "footer.jsp" %>
</body>
</html>