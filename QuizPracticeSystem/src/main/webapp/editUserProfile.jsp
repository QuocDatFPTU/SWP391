<%-- 
    Document   : editUserProfile
    Created on : Jul 27, 2021, 1:01:36 AM
    Author     : ntdun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="css/userProfile.css">
        <script src="https://kit.fontawesome.com/64bb7a6643.js" crossorigin="anonymous"></script>
        <title>User Profile</title>
</head>



<!------ Include the above in your HEAD tag ---------->
<body>
        <div class="container emp-profile">
                    <form method="post">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="profile-img">
                                    <img src="img/img.jpg" alt=""/>                                  
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="profile-head">
                                            <h5>
                                               USER'S PROFILE
                                            </h5>
                                                                         
                                    <ul class="nav nav-tabs mt-5" id="myTab" role="tablist">
                                        <li class="nav-item">
                                            <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Update Information</a>
                                        </li>                                
                                    </ul>
                                </div>
                            </div>
                            
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="profile-work">
                                    <p>OPTION</p>
                                    <a href="#">Back to Home</a><br/>
                                    <a href="#" class="">Update Password</a><br/>                                                              
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="tab-content profile-tab" id="myTabContent">
                                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                        <form action="editUser">                  
                                                <div class="row mt-3">
                                                    <div class="col-md-6">
                                                        <label>User Id</label>
                                                    </div>
                                                    <div class="col-md-6">
                                                        
                                                        <input name="" type="text" class="form-control"  readonly>
                                                    </div>
                                                </div>
                                                <div class="row mt-3">
                                                    <div class="col-md-6">
                                                        <label>Name</label>
                                                    </div>
                                                    <div class="col-md-6">                                                 
                                                        <input type="text" class="form-control"  placeholder="User Name">
                                                    </div>
                                                </div>
                                                <div class="row mt-3">
                                                    <div class="col-md-6">
                                                        <label>Email</label>
                                                    </div>
                                                    <div class="col-md-6">
                                                        
                                                        <input type="text" class="form-control"  placeholder="Email">
                                                    </div>
                                                </div>
                                                <div class="row mt-3">
                                                    <div class="col-md-6">
                                                        <label>Phone</label>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <input type="text" class="form-control"  placeholder="Phone Number">
                                                    </div>
                                                </div>
                                                <div class="row mt-3">
                                                    <div class="col-md-6">
                                                        <label>Gender</label>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <input type="text" class="form-control"  placeholder="Gender">
                                                    </div>
                                                </div>
                                                
                                                <div class="row mt-5">
                                                    <div class="col-md-4">
                                                        <input type="submit" class="profile-edit-btn " name="btnAddMore" value="Edit Profile"/>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>                                   
                                </div>
                            </div>
                        </div>
                    </form>           
                </div>
            </body>
</html>