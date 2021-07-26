<%-- 
    Document   : userProfile
    Created on : Jul 27, 2021, 2:42:09 AM
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

<body>


<div class="container emp-profile">
            <form method="post">
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-img">
                            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS52y5aInsxSm31CvHOFHWujqUx_wWTS9iM6s7BAm21oEN_RiGoog" alt=""/>
                            
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="profile-head">
                                    <h5>
                                        Kshiti Ghelani
                                    </h5>
                                    <h6>
                                        User
                                    </h6>
                                   
                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item mt-4">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">User Profile</a>
                                </li>
                                
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-2">                      
                        <a href="editUserProfile.jsp"  class="profile-edit-btn">Edit Profile</a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-work">
                            <p>OPTION</p>
                            <a href="index">Back To Home</a><br/>
                                 
                           
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="tab-content profile-tab" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>User Name</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${sessionScope.singleUser.username}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label> Name</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p style="display:inline;">${sessionScope.singleUser.firstName}</p> 
                                                <span class="lastName">${sessionScope.singleUser.lastName}</span> 
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Email</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${sessionScope.singleUser.email}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Phone</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${sessionScope.singleUser.phone}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Gender</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${sessionScope.singleUser.gender}</p>
                                            </div>
                                      </div>
                            </div>                          
                        </div>
                    </div>
                </div>
            </form>           
        </div>
    </body>
    </html>