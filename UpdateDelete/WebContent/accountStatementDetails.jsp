<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Your's Choice/Account Statement Details</title>

    <link rel="stylesheet" type="text/css" href="CSS/style.css">
    
</head>
<body>
<%@ include file = "header.jsp" %>
    <div class="container-fluid main-container">
        <div class="container container-account-statement-details">
            <h2 class="text-center">Account Statement Details</h2><br><br><br>
            <div class="row">
                <div class="col-md-6">
                    <span>Account ID: <span style="color: red;">*</span></span>
                </div>
                <div class="col-md-6">
                    <select name="account-statement-details" id="account-statement-details">
                        <option value="111011058">111011058</option>
                        <option value="111012059">111012059</option>
                        <option value="111021547">111021547</option>
                    </select>
                </div>
            </div><br>
            <div class="row">
                <div class="col-md-6">
                    <span>State Date: <span style="color: red;">*</span></span>
                </div>
                <div class="col-md-6">
                    <input type="date" name="startDate" id="startDate">
                </div>
            </div><br>
            <div class="row">
                <div class="col-md-6">
                    <span>End Date: <span style="color: red;">*</span></span>
                </div>
                <div class="col-md-6">
                    <input type="date" name="endDate" id="endDate">
                </div>
            </div><br>
            <div class="row">
                <div class="col-md-12">
                    <span style="color: red; position: relative; left: 40%;">(*)Fields are mandatory</span>
                </div>
            </div><br>
            <div>
                <button type="button" class="btn btn-acc-statement-details">Submit</button>
            </div>
        </div>
        <table class="account-statement-table" border="1">
            <thead>
                <tr>
                    <th>Transaction ID</th>
                    <th>Description</th>
                    <th>Date (YYYY-MM-DD)</th>
                    <th>Amount</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>000003164</td>
                    <td>Withdraw</td>
                    <td>2016-06-24</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>000003159</td>
                    <td>Withdraw</td>
                    <td>2016-06-24</td>
                    <td>9</td>
                </tr>
                <tr>
                    <td>000003157</td>
                    <td>Withdraw</td>
                    <td>2016-06-24</td>
                    <td>10</td>
                </tr>
                <tr>
                    <td>000003158</td>
                    <td>Withdraw</td>
                    <td>2016-06-24</td>
                    <td>1000</td>
                </tr>
            </tbody>
        </table><br><br><br>
        <div class="download-button"><center>
            <button type="button" class="btn btn-pdf-file">Download As PDF File</button>
            <button type="button" class="btn btn-excel-file">Download As Excel File</button>
            </center>
        </div>
    </div>
    <br><br>
    
    <%@ include file = "footer.jsp" %>
</body>
</html>