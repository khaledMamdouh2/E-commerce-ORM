<%-- 
    Document   : home
    Created on : Mar 2, 2018, 7:50:35 AM
    Author     : ahmedelgawesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

  <c:if test="${sessionScope.adminLoggedin == 'false'}">
                <c:redirect url = "denyPage.jsp" />
            </c:if>
 <c:if test="${sessionScope.adminLoggedin == null }">
                <c:redirect url = "denyPage.jsp" />
            </c:if>
 <c:if test="${sessionScope.adminLoggedin == 'true'}">

     
     
     
     
     <html>
    <head>
        <link rel="stylesheet" href="..\styles\adminPages_style.css">
        <script type="text/javascript" src="..\js\adminPages.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body id="main">
        <!-- tabs -->


        <div class="tab">
            <button class="tablinks" onclick="openCity(event, 'productsPanel')">Products Panel</button>
            <button class="tablinks" onclick="openCity(event, 'usersPanel')">Users Panel</button>
            <button class="tablinks" onclick="openCity(event, 'adminPanel')">Admins Panel</button>
        </div>

        <div id="productsPanel" class="tabcontent" hidden="">
            <jsp:include page="productManage.jsp"/>
        </div>

        <div id="usersPanel" class="tabcontent" hidden="">
            <jsp:include page="TEST.jsp"/>
        </div>

        <div id="adminPanel" class="tabcontent" hidden="">
            <jsp:include page="TEST.jsp"/>
        </div>

        <!-- ********************** end of tabs *************************  -->

    </body>

</body>
  </c:if>
</html>
