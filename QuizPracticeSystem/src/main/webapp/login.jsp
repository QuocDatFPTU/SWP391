<%-- 
    Document   : login
    Created on : Jun 23, 2021, 12:57:47 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

    <title>Login Page</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/sign-in/">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- Bootstrap core CSS -->
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>

<body style="background-color: #f5f5f5"  class="text-center" data-new-gr-c-s-check-loaded="14.1016.0" data-gr-ext-installed="">
<form action="login" method="POST">
    <img class="mb-4" src="https://lh3.googleusercontent.com/proxy/wIs8-k2bUkZpQxeZIoYXpuEChdqH9XUhCVdTu9XQ5ClPMntFj-fd5dDFAjSRTEaQx06ovHZgd-LH1rY8jsRttj49vva0p0Ob85_5AJ0T7kT_JpRuzdWkb0swYw" alt="" width="150" height="150">
    <h1 class="h3 mb-3 font-weight-normal">Login</h1>
    <div  style="display: inline-block;" borde>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" name="username" id="inputEmail" class="form-control" placeholder="abc@xyz.com" required="" autofocus="">
        <div >
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" name="password" id="inputPassword" class="form-control"S placeholder="Password" required="">
        </div>
        <div class="checkbox mb-0">
            <label>
                <input type="checkbox" name="remember-me" value="remember-me"> Remember me
            </label>
        </div>

        <div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </div>
        <div class="col-md-12" >
            <p class="mt-4 mb-1 text-muted">Or with</p>
            <a class="btn btn-lg btn-block " href="#"><img src="https://img.icons8.com/color/16/000000/google-logo.png">
                Google
            </a>
        </div>
    </div>
    <p class="mt-5 mb-3 text-muted">
        Doens't have an account yet? <a href="registerPage">Sign up now</a>
    </p>
    <p class="mt-5 mb-3 text-muted">©Tam</p>
</form>


</body>
</html>