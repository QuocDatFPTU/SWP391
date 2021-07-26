<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home Page</title>
    <!--=============================================================-->

    <!--==================Bootstrap css===========================-->
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous"
    />

    <!--=============================================================-->

    <!--==================Fontawesome===========================-->
    <script
      src="https://kit.fontawesome.com/64bb7a6643.js"
      crossorigin="anonymous"
    ></script>
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <!--=============================================================-->

    <!--======================Jost-font==============================-->
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap"
      rel="stylesheet"
    />
    <!--=============================================================-->

    <!--==========================Roboto-font===============================-->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
      rel="stylesheet"
    />

    <!--=============================================================-->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto+Mono&display=swap"
      rel="stylesheet"
    />
    <!---===================MyCss================================-->
    <link rel="stylesheet" href="css/hompage.css" />
    <!--=============================================================-->

    <!--===================Swiper=====================================-->
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css" />
    <link
      rel="stylesheet"
      href="https://unpkg.com/swiper/swiper-bundle.min.css"
    />
    <script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <!--=============================================================-->
    <script
      src="https://kit.fontawesome.com/64bb7a6643.js"
      crossorigin="anonymous"
    ></script>
  </head>

  <body>
    <!--Navbar-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <a class="navbar-brand" href="#">
        <img src="img/q (1).svg" alt="Q logo " width="40px;" height="50px;"
      /></a>
      <button
        class="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="homepage"
              >Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Course List</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">About</a>
          </li>
          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              id="navbarDropdown"
              role="button"
              data-toggle="dropdown"
              aria-haspopup="true"
              aria-expanded="false"
            >
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
          <input
            class="form-control mr-sm-2"
            type="search"
            placeholder="Search"
            aria-label="Search"
          />
          <button type="submit" class="btn btn-secondary">Search</button>
          <a href="loginPage" type="submit" class="btn btn-secondary mx-3">Login</a>
          <a href="registerPage" type="submit" class="btn btn-secondary mx-2">Register</a>
        </form>
      </div>
    </nav>
    <!--end nav bar-->
    <a href="practiceList">
        <input type="button" value="PracticeList" />
    </a>
    <!--Slide show-->
    <div
      id="carouselExampleIndicators"
      class="carousel slide"
      data-ride="carousel"
    >
      <ol class="carousel-indicators">
        <li
          data-target="#carouselExampleIndicators"
          data-slide-to="0"
          class="active"
        ></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
      </ol>

      <div class="container-fluid slide-show">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img
              class="d-block w-100"
              src="img/e-learning.svg"
              alt="First slide"
              height="400px"
            />
          </div>
          <div class="carousel-item">
            <img
              class="d-block w-100"
              src="img/E BOOKS.svg"
              alt="Second slide"
              height="400px"
            />
          </div>
          <div class="carousel-item">
            <img
              class="d-block w-100"
              src="img/educational resources.svg"
              alt="Third slide"
              height="400px"
            />
          </div>
        </div>
      </div>

      <a
        class="carousel-control-prev"
        href="#carouselExampleIndicators"
        role="button"
        data-slide="prev"
      >
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a
        class="carousel-control-next"
        href="#carouselExampleIndicators"
        role="button"
        data-slide="next"
      >
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>

    <!-- Slider main container -->
    <div class="swiper-container">
      <h2>Recommend for you</h2>
      <p id="re">
        Choose from 130,000 online video courses with new additions published
        every month
      </p>
      <!-- Additional required wrapper -->
      <div class="swiper-wrapper">
        <!-- Slides -->
        <div class="swiper-slide">
          <div>
            <div class="card bg-light mb-3">
              <div class="card-header">
                Complete guide to ASP.NET Core MVC (.NET 5)
              </div>
              <img
                class="card-img-top"
                src="img/asp-mvc.jpg"
                alt="Course Image"
              />
              <div class="card-body">
                <a href="#" class="btn btn-primary">Add to Cart</a>
                <button
                  type="button"
                  class="btn btn-primary"
                  data-container="body"
                  data-toggle="popover"
                  data-placement="right"
                  data-content="hi babeeee."
                >
                  View Details
                </button>
              </div>
            </div>
          </div>
        </div>
        <!--Model box for view details-->

        <!-- Modal -->

        <div class="swiper-slide">
          <div>
            <div class="card bg-light mb-3">
              <div class="card-header">Course Name</div>
              <img class="card-img-top" src="..." alt="Course Image" />
              <div class="card-body">
                <p class="card-text">Course Description</p>
                <a href="#" class="btn btn-primary">Payment</a>
              </div>
            </div>
          </div>
        </div>
        <div class="swiper-slide">
          <div>
            <div class="card bg-light mb-3">
              <div class="card-header">Course Name</div>
              <img class="card-img-top" src="..." alt="Course Image" />
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

    <!--Course List-->
    <div class="container course-list">
      <h2>Course List</h2>
      <div class="row"> 
          <c:forEach var="course" items="${sessionScope.listCourse}">      
        <div class="col-md-3" >            
          <div class="card bg-light mb-3">
            <div class="card-header">${course.courseName}</div>
            <img
              class="card-img-top"
              src="${course.thumbnailLink}"
              alt="Course Image"
            />
            <div class="card-body">
              <p class="card-text"></p>
              <a href="subjectListDetail?CourseID=${course.courseID}" class="btn btn-primary">View Subject List</a>
            </div>
          </div>
        </div>  
         </c:forEach>
      </div>
    </div>
    <!--Wish List-->
    <div class="container wish-list">
      <h2>Wish List</h2>
      <p>
        Your wish list course here.<i
          class="fas fa-heart"
          style="color: black"
        ></i>
      </p>
      <div class="row">
        <div class="col-md-4">
          <div class="card bg-light mb-3" style="width: 18rem">
            <div class="card-header">Course Name</div>
            <img
              class="card-img-top"
              src="img/asp-mvc.jpg"
              alt="Course Image"
            />
            <div class="card-body">
              <p class="card-text">Course Description</p>
              <a href="#" class="btn btn-primary">Payment</a>
            </div>
          </div>
          <!--end of card-->
        </div>
        <!--card no1-->
        <div class="col-md-4">
          <div class="card bg-light mb-3" style="width: 18rem">
            <div class="card-header">Course Name</div>
            <img
              class="card-img-top"
              src="img/asp-mvc.jpg"
              alt="Course Image"
            />
            <div class="card-body">
              <p class="card-text">Course Description</p>
              <a href="#" class="btn btn-primary">Payment</a>
            </div>
          </div>
          <!--end of card-->
        </div>
        <!--card no2-->

        <div class="col-md-4">
          <div class="card bg-light mb-3" style="width: 18rem">
            <div class="card-header">Course Name</div>
            <img
              class="card-img-top"
              src="img/asp-mvc.jpg"
              alt="Course Image"
            />
            <div class="card-body">
              <p class="card-text">Course Description</p>
              <a href="#" class="btn btn-primary">Payment</a>
            </div>
          </div>
          <!--end of card-->
        </div>
        <!--card no3-->
      </div>
    </div>

    <script>
      const swiper = new Swiper(".swiper-container", {
        // Optional parameters
        slidesPerView: 3,
        centeredSlides: true,
        spaceBetween: 30,

        // If we need pagination
        pagination: {
          el: ".swiper-pagination",
          // type: 'fraction',
        },

        // Navigation arrows
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },

        // And if we need scrollbar
        scrollbar: {
          el: ".swiper-scrollbar",
        },
      });
    </script>
    <script>
      $(function () {
        $('[data-toggle="popover"]').popover();
      });
    </script>
    <!---============================jquery=====================================-->
    <script
      src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
      integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
      crossorigin="anonymous"
    ></script>
    <!---============================popper=====================================-->
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
      integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
      crossorigin="anonymous"
    ></script>
    <!---============================min.js=====================================-->
    <script
      src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
      integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
      crossorigin="anonymous"
    ></script>
  </body>

  <footer>
    <div class="footer-wraper container mt-5">
      <div class="row">
        <div class="col-md-4 first-col">
          <img src="img/q (1).svg" alt="logo" height="50px" width="50px" />
          <span id="logo-name">QRS</span>
          <p id="footer-description">
            Lorem ipsum, dolor sit amet consectetur adipisicing elit. Hic quia
            similique, voluptates ab quam iste quasi suscipit ea ut error,
            maxime dignissimos delectus magnam porro dolor ullam nisi iusto
            quos.
          </p>
        </div>
        <div class="col-md-4 second-col">
          <h5><i class="fas fa-map m-2"></i>Site Map</h5>
          <ul>
            <li>
              <i class="fas fa-chevron-right" style="color: aliceblue"></i
              ><a href="">Home</a>
            </li>
            <li>
              <i class="fas fa-chevron-right" style="color: aliceblue"></i
              ><a href="">Course</a>
            </li>
            <li>
              <i class="fas fa-chevron-right" style="color: aliceblue"></i
              ><a href="">Blog</a>
            </li>
          </ul>
        </div>
        <div class="col-md-4 third-col">
          <h5><i class="fas fa-address-book m-2"></i>Contact info</h5>
          <ul>
            <li>
              <div class="icon-location">
                <i class="fas fa-home"></i>
              </div>
              <div class="location-footer">
                <p>
                  Lô E2a-7, ???ng D1, Khu Công Ngh? Cao, Long Th?nh M?, Qu?n 9,
                  Thành ph? H? Chí Minh
                </p>
              </div>
            </li>

            <li>
              <div class="icon-phone">
                <i class="fas fa-home"></i>
              </div>
              <div class="phone-footer">
                <p>(+84)2873005588</p>
              </div>
            </li>

            <li>
              <div class="icon-mail">
                <i class="fas fa-home"></i>
              </div>
              <div class="mail-footer">
                <p>FPT@edu.vn.com</p>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </footer>
</html>
