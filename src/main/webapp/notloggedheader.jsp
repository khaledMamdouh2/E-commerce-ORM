<%-- 
    Document   : notloggedheader
    Created on : Mar 9, 2018, 7:31:34 AM
    Author     : Passant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Pettopia</title>
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    </head>

    <body onload="setInterval('render()', 1000)">

        

            <!-- Header -->

            <header class="header trans_300">

                <!-- Top Navigation -->


                <!-- Main Navigation -->

                <div class="main_nav_container" >
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 text-right">
                                <div class="logo_container">
                                    <img src="styles/imgs/pettopialogo.png" style="width: 40px; height: 35px; margin-bottom: 10px;" />
                                    <a href="index.jsp">PeT<span>topia</span></a>
                                </div>
                                <nav class="navbar">
                                    <ul class="navbar_menu">
                                        <li><a href="index.jsp">home</a></li>
                                        <li><a href="login.jsp"><i class="fa" aria-hidden="true"></i>Sign In</a></li>
                                        <li><a href="registration.jsp"><i class="fa" aria-hidden="true"></i>Register</a></li>
                                        <li><a href="CartServlet"><i class="fa" aria-hidden="true"></i>checkout</a></li>
                                        <li><a href="products"><i class="fa" aria-hidden="true"></i>shop</a></li>
                                        <li><a href="contact.jsp">contact us</a></li>
                                    </ul>
                                    <ul class="navbar_user">
                                        <li><a href="search.jsp"><i class="fa fa-search" aria-hidden="true"></i></a></li>
                                        <li class="checkout">
                                            <a href="CartServlet">
                                                <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                <span id="checkout_items" class="checkout_items">${sessionScope.cartProductsNo}</span>
                                            </a>
                                        </li>
                                    </ul>
                                    <div class="hamburger_container">
                                        <i class="fa fa-bars" aria-hidden="true"></i>
                                    </div>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>

            </header>

            <div class="fs_menu_overlay"></div>
            <!-- Hamburger Menu -->

            <div class="hamburger_menu">
                <div class="hamburger_close"><i class="fa fa-times" aria-hidden="true"></i></div>
                <div class="hamburger_menu_content text-right">
                    <ul class="menu_top_nav">


                        <li class="menu_item"><a href="index.jsp">home</a></li>
                        <li class="menu_item"><a href="login.jsp">sign in</a></li>
                        <li class="menu_item"><a href="registration.jsp">register</a></li>
                        <li class="menu_item"><a href="products">shop</a></li>
                        <li class="menu_item"><a href="">checkout</a></li>
                        <li class="menu_item"><a href="contact.jsp">contact</a></li>
                    </ul>
                </div>
            </div>
            <script src="js/jquery-3.2.1.min.js"></script>
            <script src="styles/bootstrap4/popper.js"></script>
            <script src="styles/bootstrap4/bootstrap.min.js"></script>
            <script src="plugins/Isotope/isotope.pkgd.min.js"></script>
            <script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
            <script src="plugins/easing/easing.js"></script>
            <script src="js/custom.js"></script>
            <script>
                function render() {
                    document.getElementById("checkout_items").innerHTML = ""+${sessionScope.cartProductsNo};
                }
            </script>
    </body>
</html>

