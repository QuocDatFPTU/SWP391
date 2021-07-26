<%-- 
    Document   : subjectlesson
    Created on : Jul 26, 2021, 9:35:34 AM
    Author     : ntdun
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />

</head>

<body>
    <div>
        <div class="container-fluid" style="padding:3rem">
            <h1>Subject Lesson</h1>
            <div>
                <p>Subject name: ${subjectname}</p>
            </div>
            
            <div>
                <div class="d-flex bd-highlight mb-3">
                    <div class="p-2 ">
                        <select name="subject" id="subject">
                            <option value="" selected="selected">All lessons group</option>
                        </select>
                    </div>
                    <div class="p-2 ">
                        <select name="subject" id="subject">
                            <option value="" selected="selected">All statuses</option>
                        </select>
                    </div>
                    <div class="p-2 ">
                        <input type="text" placeholder="Search.." name="search">
                        <button type="submit"><i class="fa fa-search"></i></button>
                    </div>
                    <div class="ml-auto p-2 "><a class="p-2" href="" style="text-decoration: underline;">Add link</a>
                    </div>
                </div>
                <div>
                    <table class="table table-bordered">
                        <thead class="bg-light text-dark">
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Lesson</th>
                                <th scope="col">Order</th>
                                <th scope="col">Type</th>
                                <th scope="col">Status</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="lesson" items="${sessionScope.listLesson}">
                            <tr>
                                <th scope="row">${lession.lessonID}</th>
                                <td>${lession.lessonID}</td>
                                <td>${lession.lessonID}</td>
                                <td>${lession.lessonID}</td>
                                <td>${lession.lessonID}</td>
                                <td>
                                    <a href="" style="text-decoration: underline; padding-right: 5px;">Edit</a>
                                    <a href="" style="text-decoration: underline;">Inactive</a>
                                </td>
                            </tr>
                            </c:forEach>
                              <tr>
                            <tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>

</html>