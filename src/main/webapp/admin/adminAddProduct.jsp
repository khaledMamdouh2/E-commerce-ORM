<%-- 
    Document   : adminAddProduct
    Created on : Mar 3, 2018, 1:27:56 AM
    Author     : Ahmed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="..\styles\adminPages_style.css">
    </head>
    <body>
        <form action="AdminAddProduct" method="get">
            <label >product name : </label><input type="text" name="productname" ><br>
            <label>product price :</label><input type="text" name="productprice"><br>
            <label>product desc :</label><input type="text" name="productdesc"><br>
            <input type="submit" id="submit">
        </form>
    </body>
</html>
