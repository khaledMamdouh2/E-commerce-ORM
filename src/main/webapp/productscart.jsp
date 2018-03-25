<%-- 
    Document   : productscart
    Created on : Mar 9, 2018, 10:12:42 AM
    Author     : Passant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Cart Products</title>
        <link rel="icon" href="styles/imgs/pettopialogo.png" />
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="Colo Shop Template">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
        <link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
        <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
        <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
        <link rel="stylesheet" type="text/css" href="styles/main_styles.css">
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

            <!-- New Arrivals -->

            <div class="new_arrivals">

                <div class="container">

                    <br><br><br><br><br><br><br><br><br>
                    <c:forEach items="${requestScope.cartListedProducts}" var="item">
                        <div class="product-item men">
                            <div class="product discount product_filter">
                               
                                    <img style="display: block; height:77%; width: 100%; max-width: 100%;" src="productImage?id=${item.productid}" alt="">
                                

                                <div class="product_info">
                                    <h6 class="product_name"><a href="productDetails?id=${item.productid}">${item.productname}</a></h6>
                                    <div class="product_price">$ ${item.productprice}</div>
                                </div>
                            </div>
                            <form action="PayingServlet" method="GET">
                                <input type="hidden" name="deletedProductID" value="${item.productid}"/>
                                <button class="red_button add_to_cart_button" style="color:#FFF;">REMOVE</button>
                            </form>
                        </div>

                    </c:forEach>

                    <!-- Product 1 -->




                    <!-- Slider Navigation -->

                    <div class="product_slider_nav_left product_slider_nav d-flex align-items-center justify-content-center flex-column">
                        <i class="fa fa-chevron-left" aria-hidden="true"></i>
                    </div>
                    <div class="product_slider_nav_right product_slider_nav d-flex align-items-center justify-content-center flex-column">
                        <i class="fa fa-chevron-right" aria-hidden="true"></i>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<!-- Newsletter -->

    <div class="container">
        <div class="row" style="margin: 2%;">
            <div class="col-lg-12">
                <form action="PayingServlet" method="POST">
                    <center>
                        <div style="color: #FF0000;">${sessionScope.errorMessage4}</div>
                        <button class="newsletter_submit_btn trans_300" id="buyBtn" value="BUY" style="width: 20%; font-weight: bolder;margin-top: 20px;">BUY</button>
                    </center>
                </form>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <jsp:include page="footer.html" />
    </div>

    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="styles/bootstrap4/popper.js"></script>
    <script src="styles/bootstrap4/bootstrap.min.js"></script>  
    <script src="plugins/Isotope/isotope.pkgd.min.js"></script>
    <script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
    <script src="plugins/easing/easing.js"></script>
    <script src="js/custom.js"></script>
    <script>
        function render(){}
    </script>
</body>

</html>
