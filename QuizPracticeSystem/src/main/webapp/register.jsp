<%-- 
    Document   : register
    Created on : Jul 7, 2021, 7:45:35 PM
    Author     : ntdun
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/registerStyling.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
   
    <title>Register Page</title>
</head>
<body>
    <div class="container-md">        
        <h2 class="title">Register Page</h2>
        <form action="RegisterServlet" method="POST">
           <p class="text-danger">${mess}</p>
            <div class="input-group">
                <label for="username">User Name:</label>
                <input type="text" name="username" id="username">
            </div>
            <div class="input-group">
                <label for="password">Password:</label>
                <input type="password" name="password" id="password">
            </div>
            <div class="input-group">
                <label for="re_password">Re-Password:</label>
                <input type="password" name="repassword" id="re_password">
            </div>
            <div class="input-group">
                <label for="firstname">First Name:</label>
                <input type="text" name="firstname" id="firstname">
            </div>
            <div class="input-group">
                <label for="lastname">Last Name:</label>
                <input type="text" name="lastname" id="lastname">
            </div>

            <div class="input-group">
                <label for="email">Email:</label>
                <input type="email" name="email" id="email">
            </div>
            <div class="input-group">
                <label for="phone">Phone No:</label>
                <input type="tel" name="phonenumber" id="phone">
            </div>


              <!-- Default checked radio -->
              <div class="form-check">
                <input
                  class="form-check-input"
                  type="radio"
                  name="gender"
                  id="male"
                  checked
                />
                <label class="form-check-label" for="male"> Male </label>
              </div>

              
            <div class="form-check">
                <input
                  class="form-check-input"
                  type="radio"
                  name="gender"
                  id="female"
                />
                <label class="form-check-label" for="female"> Female </label>
              </div>
              <button type="submit" class="btn btn-primary">Register</button>            
        </form>
    </div>
</body>
</html>