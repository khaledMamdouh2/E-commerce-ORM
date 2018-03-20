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
        <title>Registration Page</title>
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
                                <div class="register">
                                    <div class="register-top">
                                        <form action="SignUpServlet" method="POST">
                                            <table class="registerTable">
                                                <tr class="tableRow" >
                                                    <td class="tableCell"><h5>First Name:</h5></td>
                                                    <td class="inputs"><input type="text" name="firstName" class="reginputFields form-control" required="true" size="34" tabindex="1" /></td>
                                                    <td class="tableCell regtableCell"><h5>Birth-date:</h5></td>
                                                    <td class="inputs"><center><input type="date" name="birthdate" class="reginputFields form-control" required="true" tabindex="6" /></center></td>           
                                                </tr>
                                                <tr class="tableRow">
                                                    <td class="tableCell"><h5>Last Name:</h5></td>
                                                    <td class="inputs"><input type="text" name="lastName" class="reginputFields form-control" required="true" size="34" tabindex="2"/></td>
                                                    <td class="tableCell regtableCell"><h5>Credit-Limit:</h5></td>
                                                    <td class="inputs"><center><input type="number" name="creditLimit" class="reginputFields form-control" required="true" tabindex="7" /></center></td>
                                                </tr>
                                                <tr class="tableRow">
                                                    <td class="tableCell"><h5>Email:</h5></td>
                                                    <td class="inputs"><input type="email" name="email" class="reginputFields form-control" required="true" size="34" tabindex="3" /></td>
                                                    <td class="tableCell regtableCell"><h5>Credit Number:</h5></td>
                                                    <td class="inputs"><input type="text" name="creditNo1" size="2" maxlength="4" class="reginputFields form-control" required="true" tabindex="8"
                                                               style="width:22%; float: left;"/> <span style="float: left; margin-top: 2%;">&nbsp;-&nbsp;</span>
                                                        <input type="text" name="creditNo2" maxlength="4" class="reginputFields form-control" size="2" required="true" tabindex="9" 
                                                               style="width:22%; float: left;"/> <span style="float: left; margin-top: 2%;">&nbsp;-&nbsp;</span>
                                                        <input type="text" name="creditNo3" size="2" maxlength="4" class="reginputFields form-control" required="true" tabindex="10"
                                                               style="width:22%; float: left;"/> <span style="float: left; margin-top: 2%;">&nbsp;-&nbsp;</span>
                                                        <input type="text" name="creditNo4" size="2" maxlength="4" class="reginputFields form-control" required="true" tabindex="11" 
                                                               style="width:22%; float: left;"/>
                                                    </td>
                                                </tr>
                                                <tr class="tableRow">
                                                    <td class="tableCell"><h5>Password:</h5></td>
                                                    <td class="inputs"><input type="password" name="password" class="reginputFields form-control" required="true" size="34" tabindex="4" /></td>
                                                    <td class="tableCell regtableCell"><h5>Address:</h5></td>
                                                    <td class="inputs"><input type="text" name="address" class="reginputFields form-control" required="true" size="34" tabindex="12" /></td>
                                                </tr>
                                                <tr class="tableRow">
                                                    <td class="tableCell"><h5>Re-password:</h5></td>
                                                    <td class="inputs"><input type="password" name="rePassword" size="34" class="reginputFields form-control" required="true" tabindex="5"/></td>
                                                    <td class="tableCell regtableCell"><h5>Job:</h5></td>
                                                    <td class="inputs"><input type="text" name="job" class="reginputFields form-control" required="true" size="34" tabindex="13"/></td>
                                                </tr>
                                            </table>
                                            <div style="color: #FF0000;">${errorMessage2}</div>
                                            <button class="loginBtn">Sign Up</button>
                                        </form>
                                    </div>
                                    <div class="register-bottom">
                                        <hr style="height: 4px; background-color: #fe4c50; width: 56%; margin-bottom: 25px; border-radius: 5px;"/>
                                        <h4>Already has an account?<br/>
                                            <a href="login.jsp" style="margin-top: 10px; color: #fe4c50; font-weight: bolder; font-size: large;">Login</a>
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
