<%-- 
    Document   : login
    Created on : Jun 23, 2021, 12:57:47 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Login Form</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="css/login.css">
  <!-----------------------------------Roboto Font--------------------------------->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@600&display=swap" rel="stylesheet">
  <!-------------------------------------------------------------------------------->
  <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Open+Sans" />

  <!-------------------------------------------------------------------------------->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
</head>
<body>
  <div class="container">
    <div class="row px-3 ">
      <div class="col-lg-10 col-xl-9 card flex-row mx-auto px-0">
        <div class="img-left d-none d-md-flex">
          <img src="img/img.jpg" alt="sky view">
        </div>

        <div class="card-body ml-2">
          <h4 class="title text-center mt-4">
            Login to QPS
          </h4>
            <p class="text-danger ml-4">${messlogin}</p>
            <form class="form-box px-3 pl-5" action="LoginServlet" method="POST">
            <div class="form-input">
              <span><i class="fa fa-envelope-o"></i></span>
              <input type="text"  placeholder="User Name" name="username" id="inputEmail" tabindex="10" required>
            </div>
            <div class="form-input">
              <span><i class="fa fa-key"></i></span>
              <input type="password"  placeholder="Password" name="password" id="inputPassword" required>
            </div>

            <div class="mb-3">
              <div class="custom-control custom-checkbox">
                <input type="checkbox" class="custom-control-input" id="cb1" name="">
                <label class="custom-control-label" for="cb1">Remember me</label>
              </div>
            </div>

            <div class="mb-3">
              <button type="submit" class="btn btn-block text-uppercase">
                Login
              </button>
            </div>

            <div class="text-right">
              <a href="#" class="forget-link">
                Forget Password?
              </a>
            </div>

            <div class="text-center mb-3">
              or login with
            </div>

            <div class="row login-google mb-3">              
              <div class="col-8 ">
                <a class="btn btn-outline-dark" href="#" role="button" style="text-transform:none">
                  <img  alt="Google sign-in" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/512px-Google_%22G%22_Logo.svg.png" />
                   <p>Login with google</p> 
                </a>
              </div>
             
            </div>

            <hr class="my-4">

            <div class="text-center mb-2">
              Don't have an account?             
              <a href="registerPage">Register here</a>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</body>
</html>