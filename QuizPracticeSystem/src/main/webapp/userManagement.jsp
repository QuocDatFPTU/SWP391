<%-- 
    Document   : subjectManagement
    Created on : Jul 26, 2021, 9:22:51 PM
    Author     : ntdun
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Admin Page</title>
        <link
            rel="stylesheet"
            href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css"
            />
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            crossorigin="anonymous"
            />
        <script src="https://kit.fontawesome.com/64bb7a6643.js" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="css/admin.css" />
    </head>
    <body>
        <div class="sidebar">
            <div class="sidebar-brand">
                <h2><span class="las la-accusoft"></span>Admin Page</h2>
            </div>

            <div class="sidebar-menu">
                <ul>
                    <li>
                        <a href="adminUser" class="active"
                           ><i class="fas fa-user-circle"></i><span>User</span></a
                        >
                    </li>
                    <li>
                        <a href="adminCourseSer"
                           ><i class="fas fa-book-open"></i><span>Course</span></a
                        >
                    </li>
                    <li>
                        <a href="#"
                           ><i class="fas fa-graduation-cap"></i><span>Expert</span></a
                        >
                    </li>
                    <li>
                        <a href="adminSubject" 
                           ><i class="fas fa-laptop"></i>
                            <span>Subject</span></a
                        >
                    </li>
                </ul>
            </div>
        </div>
        <div class="main-content">
            <header>
                <h2>
                    <label for="">
                        <span class="las la-bars"></span>
                    </label>
                    Dashboard
                </h2>
                
                <div class="user-wrapper">
                    <img
                        src="https://static2.yan.vn/YanNews/2167221/202102/facebook-cap-nhat-avatar-doi-voi-tai-khoan-khong-su-dung-anh-dai-dien-e4abd14d.jpg"
                        width="40px"
                        height="40px"
                        alt="Error"
                        />
                    <div>
                        <h4>Hi Dung</h4>
                        <small></small>
                    </div>
                    <a href="logout"class="btn btn-primary">Logout</a>
                </div>
            </header>

            <main>
                <div class="cards">
                    <div class="card-single">
                        <div>
                            <h1>${sessionScope.listSize}</h1>
                            <span>Total Customers</span>
                        </div>
                        <div>
                            <span class="las la-users"></span>
                        </div>
                    </div>  
                </div>

                <div class="container-fluid">
                    <h2 class="mt-3">User Management</h2>
                    <table class="table table-striped table-bordered mt-4">
                        <thead>
                            <tr>
                                <th scope="col">id</th>
                                <th scope="col">full name</th>
                                <th scope="col">gender</th>
                                <th scope="col">email</th>
                                <th scope="col">Phone</th>
                                <th scope="col">role</th>
                                <th scope="col">status</th>
                                <th scope="col">Delete</th>
                                <th scope="col">Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="isActive" value="sessionScope.user"/>

                            <c:set var="listRole" value="${sessionScope.LIST_ROLE}"/>
                            <c:forEach var="userlist" items="${sessionScope.listUser}">   
                                <tr>
                                    <td>${userlist.user.userID}</td>
                                    <td>${userlist.user.username}</td>
                                    <td>${userlist.user.gender}</td>
                                    <td>${userlist.user.email}</td>
                                    <td>${userlist.user.phone}</td>               
                                    <td>${userlist.roles}</td>               
                                    <c:if test="${userlist.user.isActive eq true}">
                                        <td>is Active</td>
                                    </c:if>
                                    <c:if test="${userlist.user.isActive eq false}">
                                        <td>inActive</td>
                                    </c:if>
                                    <td>
                                        <a href="deleteUser?txtuserID=${userlist.user.userID}" type="submit" class="btn btn-primary">Delete</a>
                                    </td>              
                                    <td>
                                        <button
                                            type="button"
                                            class="btn btn-primary"
                                            data-toggle="modal"
                                            data-target="#exampleModal"
                                            >
                                            Update
                                        </button>
                                    </td>              
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </main>
        </div>

        <!-- Modal -->
        <div
            class="modal fade"
            id="exampleModal"
            tabindex="-1"
            role="dialog"
            aria-labelledby="exampleModalLabel"
            aria-hidden="true"
            >
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Update</h5>
                        <button
                            type="button"
                            class="close"
                            data-dismiss="modal"
                            aria-label="Close"
                            >
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="#">
                            <div class="form-group">
                                <label for="exampleInputEmail1">User Name</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="exampleInputEmail1"
                                    aria-describedby="emailHelp"
                                    placeholder="Enter User Name"
                                    />               
                            </div>

                            <div class="form-group">
                                <label for="exampleInputPassword1">First Name</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="exampleInputPassword1"
                                    placeholder="Password"
                                    />
                            </div>

                            <div class="form-group">
                                <label for="exampleInputEmail1">Email</label>
                                <input
                                    type="email"
                                    class="form-control"
                                    id="exampleInputEmail1"
                                    aria-describedby="emailHelp"
                                    placeholder="Enter email"
                                    />               
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Phone</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="exampleInputEmail1"
                                    aria-describedby="emailHelp"
                                    placeholder="Enter email"
                                    />               
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Status</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="exampleInputEmail1"
                                    aria-describedby="emailHelp"
                                    placeholder="Enter email"
                                    />               
                            </div>
                                    <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button
                            type="button"
                            class="btn btn-secondary"
                            data-dismiss="modal"
                            >
                            Close
                        </button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>

        <!--Script for modal active-->
        <script>
            $("#myModal").on("shown.bs.modal", function () {
                $("#myInput").trigger("focus");
            });
        </script>

        <script
            src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"
        ></script>
    </body>


</html>

