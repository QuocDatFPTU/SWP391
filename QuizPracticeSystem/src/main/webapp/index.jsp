<%-- 
    Document   : index
    Created on : Jul 11, 2021, 9:37:40 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <!--=============================================================-->


     <!--==================Bootstrap css===========================-->    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!--=============================================================-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" 
        crossorigin="anonymous">
    </script>
        <!--==================Fontawesome===========================-->    
    <script src="https://kit.fontawesome.com/64bb7a6643.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <!--=============================================================-->


    <!--======================Jost-font==============================-->
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
    <!--=============================================================-->
    <!---MyCss-->
    <link rel="stylesheet" href="css/hompage.css">
     <!--=============================================================-->


     <!--===================Swiper=====================================-->
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css" />
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
    <script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
     <!--=============================================================-->
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark" >     
        <a class="navbar-brand" href="#"> <img src="img/q (1).svg" alt="Q logo " width="40px;" height="50px;" ></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Phone</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        More
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
            </ul>
            <!--Search box-->
            <form class="form-inline my-2 my-lg-0">              
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button type="button" class="btn btn-secondary">Search</button>
            </form>
        </div>
    </nav>
    <!--Slide show-->
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>

        <div class="container-fluid slide-show">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="d-block w-100"
                        src="img/e-learning.svg"
                        alt="First slide"
                        height="400px">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100"
                        src="img/E BOOKS.svg"
                        alt="Second slide"
                        height="400px">
                        
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100"
                        src="img/educational resources.svg"
                        alt="Third slide"
                        height="400px">
                </div>
            </div>
        </div>

        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>

    </div>

    
      <!-- Slider main container -->    
    <div class="swiper-container">
        <h2>Recommend for you</h2>
        <p id="re">Choose from 130,000 online video courses with new additions published every month</p>
    <!-- Additional required wrapper -->
        <div class="swiper-wrapper">
      <!-- Slides -->
            <div class="swiper-slide">
                <div >
                    <div class="card bg-light mb-3" >
                        <div class="card-header">Complete guide to ASP.NET Core MVC (.NET 5)</div>
                        <img class="card-img-top" src="img/asp-mvc.jpg" alt="Course Image">
                        <div class="card-body">                          
                            <a href="#" class="btn btn-primary">Add to Cart</a>
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                               View Details
                              </button>
                              <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                <div class="modal-body">
                                    ...
                                </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary">Save changes</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--Model box for view details-->
           
            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                    <div class="modal-body">
                        ...
                    </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
                
            <div class="swiper-slide">
                <div >
                    <div class="card bg-light mb-3">
                        <div class="card-header">Course Name</div>
                        <img class="card-img-top" src="..." alt="Course Image">
                        <div class="card-body">
    
                            <p class="card-text">Course Description</p>
                            <a href="#" class="btn btn-primary">Payment</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="swiper-slide">
                <div >
                    <div class="card bg-light mb-3">
                        <div class="card-header">Course Name</div>
                        <img class="card-img-top" src="..." alt="Course Image">
                        <div class="card-body">
    
                            <p class="card-text">Course Description</p>
                            <a href="#" class="btn btn-primary">Payment</a>
                        </div>
                    </div>
                </div>
            </div>          
        </div>
        <!-- If we need navigation buttons -->
         <div class="swiper-button-prev"></div>
         <div class="swiper-button-next"></div>
    </div>


    <!--Wish List-->
    <div class="container-fluid wish-list" >
        <h2>Wish List</h2>
        <div class="row">
            <div class="col-md-4">
                <div class="card bg-light mb-3" style="width: 18rem;">
                    <div class="card-header">Course Name</div>
                        <img class="card-img-top" src="..." alt="Course Image">
                    <div class="card-body">
                        <p class="card-text">Course Description</p>
                        <a href="#" class="btn btn-primary">Payment</a>
                    </div>
                </div><!--end of card-->
            </div><!--card no1-->
            <div class="col-md-4">
                <div class="card bg-light mb-3" style="width: 18rem;">
                    <div class="card-header">Course Name</div>
                        <img class="card-img-top" src="..." alt="Course Image">
                    <div class="card-body">
                        <p class="card-text">Course Description</p>
                        <a href="#" class="btn btn-primary">Payment</a>
                    </div>
                </div><!--end of card-->
            </div><!--card no2-->

            <div class="col-md-4">
                <div class="card bg-light mb-3" style="width: 18rem;">
                    <div class="card-header">Course Name</div>
                        <img class="card-img-top" src="..." alt="Course Image">
                    <div class="card-body">
                        <p class="card-text">Course Description</p>
                        <a href="#" class="btn btn-primary">Payment</a>
                    </div>
                </div><!--end of card-->
            </div><!--card no3-->
        </div>
    </div>
    

    <script>
        const swiper = new Swiper('.swiper-container', {
  // Optional parameters
            slidesPerView: 3,
            centeredSlides: true,
            spaceBetween: 30,
            

            // If we need pagination
            pagination: {
                el: '.swiper-pagination',
                type: 'fraction',
            },

            // Navigation arrows
            navigation: {
                nextEl: '.swiper-button-next',
                prevEl: '.swiper-button-prev',
            },

            // And if we need scrollbar
            scrollbar: {
                el: '.swiper-scrollbar',
            },
    });
    </script>
</body>

</html>
