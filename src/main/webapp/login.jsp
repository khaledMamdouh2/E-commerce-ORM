<%-- 
    Document   : registration_page
    Created on : Feb 28, 2018, 10:20:04 AM
    Author     : Passant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <link rel="icon" href="styles/imgs/pettopialogo.png" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
        <link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
        <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
        <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
        <link rel="stylesheet" type="text/css" href="styles/main_styles.css">
        <link rel="stylesheet" type="text/css" href="styles/login_style.css">
        <link rel="stylesheet" type="text/css" href="styles/responsive.css">
    </head>
    <body>
        <div class="super_container">

            <!-- Header -->
            <c:if test="${sessionScope.userLoggedIn == 'true'}">
                <jsp:include page="loggedheader.jsp" />
            </c:if>
            <c:if test="${sessionScope.userLoggedIn == 'false'}">
                <jsp:include page="notloggedheader.jsp" />
            </c:if>
            <c:if test="${sessionScope.userLoggedIn == null }">
                <jsp:include page="notloggedheader.jsp" />
            </c:if>
            
            <!-- Slider -->

            <div class="main_slider">
                <div class="container fill_height">
                    <div class="row align-items-center fill_height">
                        <div class="col-lg-12 ">
                            <center>
                                <div class="login">
                                    <div class="login-top">
                                        <form action="LoginServlet" method="POST">
                                            <table class="loginTable">
                                                <tr class="tableRow">
                                                    <td class="tableCell"><h5>Email:</h5></td><td></td>
                                                    <td class="inputs"><input placeholder="example@ex.example" type="email" name="email" required="true" size="40" class="inputFields form-control" /></td>
                                                </tr>
                                                <tr class="tableRow">
                                                    <td class="tableCell"><h5>Password:</h5></td>
                                                    <td></td>
                                                    <td class="inputs"><input type="password" name="password" required="true" size="40" class="inputFields form-control" /></td>
                                                </tr>
                                            </table>
                                            <div style="color: #FF0000;">${errorMessage1}</div>
                                            <button class="loginBtn">Login</button>
                                        </form>
                                    </div>
                                    <div class="login-bottom">
                                        <hr style="height: 4px; background-color: #fe4c50; width: 56%; margin-bottom: 25px; border-radius: 5px;"/>
                                        <h4>Have not an account yet?<br/>
                                            <a href="registration.jsp" style="color: #e83e8c; margin-top: 10px; color: #fe4c50; font-weight: bolder; font-size: large;">Sign Up</a>
                                        </h4>
                                    </div>
                                </div>
                            </center>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Banner -->


            <!-- Footer -->
            <jsp:include page="footer.html" />
        </div>
        <script>
            function render(){}
        </script>
    </body>
</html>
