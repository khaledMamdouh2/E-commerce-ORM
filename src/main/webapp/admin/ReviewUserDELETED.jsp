<%-- 
    Document   : ReviewUser
    Created on : Mar 2, 2018, 5:27:44 PM
    Author     : Hesham Kadry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>

<head>
    <title>User Review</title>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="UserReviewScript.js"></script>
</head>

<body onload="setInterval('refresh()' ,1000)">

<div class="container">
    
        <div class="data">

            <input placeholder="User Email" id="uEmail" type="text"/><br><br>
            <button onclick="sendEmail()">Review</button><br>
           

            <br>
           <table border="1" width="40%">
            <col width="50%">
            <col width="50%">
            <tr>
                <th style="text-align: center;">first Name</th>
                <th style="text-align: center;">last name</th>
            </tr>
            <tbody id="tableRows">
                <tr>

                </tr>
            </tbody>

            </table> 
        </div>  
    <div class="Users">

        
    </div>
</div>
        
</body>

</html>
