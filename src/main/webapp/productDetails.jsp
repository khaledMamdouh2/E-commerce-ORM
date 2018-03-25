<%-- 
    Document   : single
    Created on : Mar 6, 2018, 5:09:18 PM
    Author     : khaled
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Single Product</title>
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
        <link rel="stylesheet" href="plugins/themify-icons/themify-icons.css">
        <link rel="stylesheet" type="text/css" href="plugins/jquery-ui-1.12.1.custom/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="styles/single_styles.css">
        <link rel="stylesheet" type="text/css" href="styles/single_responsive.css">
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
            
            <div class="container single_product_container">
                <div class="row">
                    <div class="col">


                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-7">
                        <div class="single_product_pics">
                            <div class="row">

                                <div class="col-lg-12 image_col order-lg-2 order-1">
                                    <div class="single_product_image">
                                        <div class="single_product_image_background" >
                                            <img style="display: block; min-height:100%; width: 100%; max-width: 100%;" src="productImage?id=${requestScope.product.productid}">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-5">
                        <div class="product_details">
                            <div class="product_details_title">
                                <h2>${requestScope.product.productname}</h2>
                                <p>${requestScope.product.productdescription}</p>
                            </div>
                            <div class="free_delivery d-flex flex-row align-items-center justify-content-center">
                                <span class="ti-truck"></span><span>free delivery</span>
                            </div>
                            <br><br>
                            <div class="product_price">$${requestScope.product.productprice}</div>


                            <div class="quantity d-flex flex-column flex-sm-row align-items-sm-center">
                                <form action="CartServlet" method="POST">
                                    <input type="hidden" name="productID" value="${requestScope.product.productid}"/>
                                    <button class="newsletter_submit_btn trans_300" style="color:#FFF; width:150%;">add to cart</button>
                                </form>
                            </div>
                        </div>
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
        <script src="plugins/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
        <script src="js/single_custom.js"></script>
        <script src="js/custom.js"></script>
        <script>
            function render(){}
        </script>
    </body>

</html>

