<%-- 
    Document   : productManage
    Created on : Mar 6, 2018, 9:16:21 AM
    Author     : Ahmed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>product management</title>
        
        
        <link rel="stylesheet" href="..\styles\adminPages_style.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script>
          function addbutton()
          {
            
              document.getElementById("myHtml").src = 'adminAddProduct.jsp';
          }
          
          function editbutton()
          {
              document.getElementById("myHtml").src = 'test.html';
          }
          
          function removebutton()
          {
              document.getElementById("myHtml").src = 'test.html';
          }
        </script>
        
    </head>
    <body>
       
        <div>
            <button type='button' onclick="addbutton()">add product</button>
            <button type='button' onclick="editbutton()">edit product</button>
            <button type='button' onclick="removebutton()">remove product</button>
       </div>
       
        <iframe id="myHtml" src="" frameBorder="0" width="500" height="500"></iframe>
        </body>
</html>
