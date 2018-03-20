<!DOCTYPE html>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:if test="${sessionScope.adminLoggedin == 'false'}">
    <c:redirect url = "denyPage.jsp" />
</c:if>
<c:if test="${sessionScope.adminLoggedin == null }">
    <c:redirect url = "denyPage.jsp" />
</c:if>
<c:if test="${sessionScope.adminLoggedin == 'true'}">
    <html >
        <head>
            <meta charset="UTF-8">
            <title>Featured Tabs</title>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
            <script type="text/javascript" src="../js/UserReviewScript.js"></script>
            <link rel="stylesheet" href="css/style.css">
            <link rel="stylesheet" href="css/previewStyle.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
            <script type="text/javascript" src="../js/UserReviewScript.js"></script>
            <link rel="stylesheet" href="css/previewStyle.css">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


            <link rel='stylesheet prefetch'
                  href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
            <link rel='stylesheet prefetch'
                  href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>
            <link rel='stylesheet prefetch'
                  href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,200,300,700'>
            <link rel="stylesheet" type="text/css" href="..\styles\bootstrap4\bootstrap.min.css">
            <link href="..\plugins\font-awesome-4.7.0\css\font-awesome.min.css" rel="stylesheet" type="text/css">
            <link rel="stylesheet" type="text/css" href="..\plugins\OwlCarousel2-2.2.1\owl.carousel.css">
            <link rel="stylesheet" type="text/css" href="..\plugins\OwlCarousel2-2.2.1\owl.theme.default.css">
            <link rel="stylesheet" type="text/css" href="..\plugins\OwlCarousel2-2.2.1\animate.css">
            <link rel="stylesheet" href="..\styles\adminHome.css">
            <link rel="stylesheet" href="..\styles\addProduct.css">
            <link rel="stylesheet" type="text/css" href="..\styles\main_styles.css">
            <link rel="stylesheet" type="text/css" href="..\styles\login_style.css">
            <link rel="stylesheet" type="text/css" href="..\styles\responsive.css">

            <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


        </head>

        <body>
            <div style="float: right;margin-right:150px;margin-top: 2%;">
                <img src="..\styles\imgs\pettopialogo.png" style="width: 40px; height: 35px; margin-bottom: 10px;" />
                <a style="font-size: 18;color: #000;font-style: italic;font-family: sans-serif" href="../AdminLogout">Logout</a>
            </div><br/>

            <div class="container">      

                <section id="fancyTabWidget" class="tabs t-tabs">

                    <ul class="nav nav-tabs fancyTabs" role="tablist">

                        <li class="tab fancyTab active">
                            <div class="arrow-down"><div class="arrow-down-inner"></div></div>
                            <a id="tab0" href="#tabBody0" role="tab" aria-controls="tabBody0" aria-selected="true" data-toggle="tab" tabindex="0"><span class="fa fa-desktop littleIcon"></span><span class="hidden-xs">Add product</span></a>
                            <div class="whiteBlock"></div>
                        </li>

                        <li class="tab fancyTab">
                            <div class="arrow-down"><div class="arrow-down-inner"></div></div>
                            <a id="tab1" href="#tabBody1" role="tab" aria-controls="tabBody1" aria-selected="true" data-toggle="tab" tabindex="0"><span class="fa fa-firefox littleIcon"></span><span class="hidden-xs">Edit Product</span></a>
                            <div class="whiteBlock"></div>
                        </li>

                        <li class="tab fancyTab">
                            <div class="arrow-down"><div class="arrow-down-inner"></div></div>
                            <a id="tab2" href="#tabBody2" role="tab" aria-controls="tabBody2" aria-selected="true" data-toggle="tab" tabindex="0"><span class="fa fa-envira littleIcon"></span><span class="hidden-xs">Remove Product</span></a>
                            <div class="whiteBlock"></div>
                        </li>

                        <li class="tab fancyTab">
                            <div class="arrow-down"><div class="arrow-down-inner"></div></div>
                            <a id="tab3" href="#tabBody3" role="tab" aria-controls="tabBody3" aria-selected="true" data-toggle="tab" tabindex="0"><span class="fa fa-mortar-board littleIcon"></span><span class="hidden-xs">Review Users</span></a>
                            <div class="whiteBlock"></div>
                        </li> 

                        <li class="tab fancyTab">
                            <div class="arrow-down"><div class="arrow-down-inner"></div></div>
                            <a id="tab4" href="#tabBody4" role="tab" aria-controls="tabBody4" aria-selected="true" data-toggle="tab" tabindex="0"><span class="fa fa-stack-overflow littleIcon"></span><span class="hidden-xs">Add Admin</span></a>
                            <div class="whiteBlock"></div>
                        </li>


                    </ul>

                    <div id="myTabContent" class="tab-content fancyTabContent"
                         aria-live="polite">

                        <div class="tab-pane  fade active in" id="tabBody0" role="tabpanel"
                             aria-labelledby="tab0" aria-hidden="false" tabindex="0">
                            <div>
                                <div class="row">

                                    <div class="col-md-12">

                                        <form action="../AdminAddProduct" method="post"
                                              enctype="multipart/form-data">
                                                <h5>Product Name:</h5><input type="text" name="productname" required="true" class="reginputFields form-control"/><br/>
                                                <h5>Product Price:</h5><input type="number" min="0" name="productprice" required="true" class="reginputFields form-control" /><br/> 
                                                <h5>Product Description:</h5><input type="text" name="productdesc" required="true" class="reginputFields form-control" /><br/>
                                                <h5>product category:</label></h5>
                                                <input type="text" name="productcategory" required="true" class="reginputFields form-control" /><br/>
                                                <h5>Select picture for your product :</h5><br/>
                                                <input type="file" name="fileName" accept="image/*" required="true" class="reginputFields form-control" />
                                            <!-- <input type="submit" id="submitadd"> -->
                                                <button class="loginBtn" type="submit" id="submitadd">ADD</button>
                                        </form>
                                    </div>

                                </div>
                            </div>
                        </div>

                        <div class="tab-pane  fade" id="tabBody1" role="tabpanel"
                             aria-labelledby="tab1" aria-hidden="true" tabindex="0">
                            <div class="row">

                                <div class="col-md-12">

                                    <form id="target">
                                        <h5>Enter Product id:</h5>
                                        <input type="number" min="1" name="productid1" id="productid1" required="true" class="reginputFields form-control" /><br/>
                                        <input type="button" id="submiteedit" name="search" value="search" class="loginBtn" />
                                    </form>

                                    <div id="result"></div>

                                    <script>


                                        $(document).ready(function () {

                                            $("#submiteedit").click(function ()
                                            {
                                                var jsonData = {"id": $("#productid1").val()};
                                                $.ajax({url: '../AdminEditProduct', type: 'POST', data: jsonData, success: function (data)
                                                    {
                                                        //disable first form 
                                                        $("#target :input").prop("disabled", true);
                                                        // coming back from servlet
                                                        $("#result").html("<form id='secondform'><h5>Product id : </h5><input class='reginputFields form-control' id='productid' value='" + data.id + "' disabled='true'/><h5>Product name : </h5><input class='reginputFields form-control' id='productname' value='" + data.name + "' required='true'/><h5>Product price : </h5><input class='reginputFields form-control' id='price' value='" + data.price + "'type='number' required='true'/><h5>Product description : </h5><input class='reginputFields form-control' id='desc' value='" + data.description + "' required='true'/><h5>Product category : </h5><input class='reginputFields form-control' id='category' value='" + data.category + "' required='true'/><h5>solded or not : </h5><input class='reginputFields form-control' id='quantity' value='" + data.quantity + "' required='true'/><input class='loginBtn' type='button' id='editbutton' value='edit' onclick='change()'></form>")
                                                    }, error: function (data)
                                                    {
                                                        $("#result").html("<h4> no data found  </h4>")
                                                    }
                                                });
                                            });


                                        });

                                        // edit button to submit changes 
                                        function change() {

                                            var jsonData2 = {"id": $("#productid").val(), "name": $("#productname").val(), "price": $("#price").val(), "desc": $("#desc").val(), "category": $("#category").val(), "quantity": $("#quantity").val()};
                                            $.ajax({url: '../AdminSubmitEdit', type: 'POST', data: jsonData2, success: function (data)
                                                {

                                                    //enable first form 
                                                    $("#target :input").prop("disabled", false);
                                                    $("#productid1").value = 0;
                                                    //hide second form
                                                    $("#result").html("<h4> data edited</h4>");
                                                }
                                            });

                                        }
                                        ;








                                    </script>

                                </div>
                            </div>
                        </div>
                        <div class="tab-pane  fade" id="tabBody2" role="tabpanel"
                             aria-labelledby="tab2" aria-hidden="true" tabindex="0">
                            <div class="row">
                                <div class="col-md-12">
                                    <form>
                                        <h5>Enter Product id : </h5>
                                        <input type="text" name="productid" class="reginputFields form-control" /><br/> 
                                        <!-- <input type="submit" id="submiteedit" name="remove" /> -->
                                        <button class="loginBtn" type="submit" id="submiteedit">REMOVE</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane  fade" id="tabBody3" role="tabpanel" aria-labelledby="tab3" aria-hidden="true" tabindex="0">
                            <div class="row">
                                <div class="col-md-12">

                                    <body onload="setInterval(function () {
                                                refresh();
                                            }, 2000)">

                                        <!-- start of preview user data  -->
                                    <body onload="setInterval(function () {
                                                refresh();
                                            }, 2000)">

                                        <div class="container">

                                            <div class="data">
                                                <center>
                                                <input placeholder="User Email" id="uEmail" type="text" class="reginputFields form-control" style="width: 50%;"/>
                                                <button onclick="sendEmail()" class="ButtonSend loginBtn">Review</button><br>
                                                <br>  
                                                </center>
                                            </div>  
                                            <div class="card">
                                                <img src="user_profile.jpg" alt="John" style="width:30%; height:30%">
                                                <div id="userData">
                                                    <h1>First name</h1>
                                                    <p>Last Name</p>
                                                    <p>Birth Date</p>
                                                    <p>job</p>
                                                    <p>email</p>
                                                    <p>credit lemit</p>
                                                    <p>credit number</p>
                                                </div>
                                                <div style="margin: 24px 0;">




                                                </div>
                                                <p><button class="btnedit"></a>  <i class="fa fa-facebook"></i></a>  <a href="#"><i class="fa fa-dribbble"></i></a>  <a href="#"><a href="#"><i class="fa fa-twitter"></i><a href="#"><i class="fa fa-linkedin"></i></a>  </button></p>
                                                                </div>

                                                                </div>
                                                                <!-- end of preview user data  -->







                                                                </div>
                                                                </div>
                                                                </div>
                                                                <div class="tab-pane  fade" id="tabBody4" role="tabpanel" aria-labelledby="tab4" aria-hidden="true" tabindex="0">
                                                                    <div class="row">
                                                                        <div class="col-md-12">





                                                                            <div class="login">
                                                                              
                                                                                <div class="login-top">
                                                                                    <body>

                                                                                        <form action="../AddAdminServlet" method="POST">
                                                                                            <input placeholder=" new Admin email" type="email" required="" name="adminEmail" class="reginputFields form-control" /><br><br>
                                                                                            <input placeholder="new Admin password" required="" type="password" name="adminPassword" class="reginputFields form-control" />

                                                                                            <div class="forgot">

                                                                                                <!-- <input type="submit" id="submitadd" class="loginBtn" /> -->
                                                                                                <button  type="submit" id="submitadd" class="loginBtn">ADD NEW ADMIN</button>

                                                                                            </div>
                                                                                        </form>
                                                                                </div>

                                                                            </div>
                                                                        </div>

                                                                    </div>

                                                                    </section>
                                                                </div>
                                                                <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
                                                                <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>

                                                                <script src="..\js\index.js"></script>
                                                                <script
                                                                src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
                                                                <script
                                                                src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>
                                                                <script src="..\js\index.js"></script>


                                                                </body>

                                                                </html>
                                                            </c:if>
