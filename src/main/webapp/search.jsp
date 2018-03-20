<%-- 
    Document   : search
    Created on : Mar 10, 2018, 5:18:58 PM
    Author     : Passant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
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

            <div class="main_slider">
                <div class="container fill_height">
                    <div class="row align-items-center fill_height">
                        <div class="col-lg-12 ">
                            <center>
                                <form action="SearchServlet" method="POST" />
                                    <input type="text" size="50" name="neededItem" placeholder="search by price or category" style="height: 46px;padding:6px;" />
                                    <button class="loginBtn">Search</button>
                                </form>
                            </center>
                        </div>
                        <div class="new_arrivals">

                            <div class="container">

                                <c:forEach items="${requestScope.neededProducts}" var="item">

                                    <div class="product-item men">
                                        <div class="product discount product_filter">
                                            
                                    <img style="display: block; height:77%; width: 100%; max-width: 100%;" src="productImage?id=${item.id}" alt="">
                                            

                                            <div class="product_info">
                                                <h6 class="product_name"><a href="productDetails?id=${item.id}">${item.name}</a></h6>
                                                <div class="product_price">$ ${item.price}</div>
                                            </div>
                                        </div>
                                        <form action="CartServlet" method="POST">
                                            <input type="hidden" name="productID" value="${item.id}"/>
                                            <button class="red_button add_to_cart_button" style="color:#FFF;">add to cart</button>
                                        </form>
                                    </div>

                                </c:forEach>

                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <!-- Footer -->
            <jsp:include page="footer.html" />

        </div>
    </body>
</html>
