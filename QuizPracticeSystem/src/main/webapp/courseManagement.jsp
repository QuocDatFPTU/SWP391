<%-- 
    Document   : courseManagement
    Created on : Jul 26, 2021, 9:21:29 PM
    Author     : ntdun
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
  <link rel="stylesheet" href="css/admin_course.css">
    <title>Document</title>

</head>
    <body>
        <div class="sidebar">
          <div class="sidebar-brand">
            <h2><span class="las la-accusoft"></span>Admin Page</h2>
          </div>
    
          <div class="sidebar-menu">
            <ul>
              <li>
                <a href="getAllUser" 
                  ><i class="fas fa-user-circle"></i> <span>User</span></a
                >
              </li>
              <li>
                <a href="adminCourseSer" class="active"
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
            <div class="search-wrapper">
              <span class="class las la-search"></span>
              <input type="search" placeholder="Search here" />
            </div>
            <div class="user-wrapper">
              <img
                src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEAoTadQ4n5Oe-rLqJz9j_UCkUhtcLoZlacA&usqp=CAU"
                width="40px"
                height="40px"
                alt="Error"
              />
              <div>
                <h4>Eminem</h4>
                <small>Slim Shady</small>
              </div>
            </div>
          </header>
        
        <main>
            <div class="container-fluid">
                <div class="row justify-content-between subject-section">
                    <h2 class="mt-3">Course Management</h2>
                    <button type="button" class="btn btn-primary btn-sm float-right">Add course</button>
                </div>
               
                <table class="table table-bordered">
                    <thead>
                      <tr>
         
                        <th>Id</th>
                        <th>Name</th>                                                                             
                        <th>Delete</th>
                        <th>Update</th>            
                                   
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="courselist" items="${sessionScope.listCourse}">
                      <tr>               
                        
                          <td>${courselist.courseID}</td>
                        <td>${courselist.courseName}</td>
                        <td><button type="button" class="btn btn-primary">Delete</button></td>
                        <td><a href="subjectDetails.html" class="btn btn-primary">Update</a></td>                                           
                      </tr>
        </c:forEach>
                      
                    </tbody>
                  </table>
                </div>
                </main>
            </div>       
    </body>
</html>