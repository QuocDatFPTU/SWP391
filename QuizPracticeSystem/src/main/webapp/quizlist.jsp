<%-- 
    Document   : quizlist
    Created on : Jul 21, 2021, 5:07:34 PM
    Author     : HP
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>

<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <!--Goolefont-->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
        <!--My css-->
        <link rel="stylesheet" href="css/quizlist.css">
        <title>Quiz list</title>
    </head>
    <body>
        

        <h2>Practice list</h2>
        <div class="container">
            <div class="controller">
                <div class="subject-select">
                    <form class="form-inline"> 
                        <label for="quiz-category" id="label-category">Choose:</label>                  
                        <select class="custom-select my-1 mr-sm-2" id="quiz-category">
                            <option selected>All subjects</option>
                            <option value="1">One</option>
                            <option value="2">Two</option>
                            <option value="3">Three</option>
                        </select>
                    </form>
                </div>
                <div class="interact-quiz">             
                    <button type="button" class="btn btn-primary "  data-toggle="modal" data-target="#exampleModal">New Practice</button>
                    <button class="btn btn-primary">Simulation Exam</button>              
                </div>
            </div>
            <div class="content">
                <table border="1" >
                    <thead>
                        <tr>
                            <th>Practice Name</th>
                            <th>Date taken</th>
                            <th >Number of question</th>
                            <th>Accuracy</th>
                            <th> Details</th>
                        </tr>                    
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <div class="subjectname">
                                    Subject Name 
                                </div>
                                <div class="quizname">
                                    Quiz name
                                </div>                          
                            </td>
                            <td ><p>10/09/2021</p></td>
                            <td >
                                <div class="content1">
                                    <p>xx correct</p>
                                    <p>yy questions</p>
                                </div>
                            </td>
                            <td ><p> 50% correct</p></td>
                            <td > 
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                                    View details
                                </button>
                            </td>                       
                        </tr>

                        <!--Subarea-->
                        <tr>
                            <td colspan="5" class="subarea">
                                <p>Test type</p> <p>Duration - hh:mm:ss</p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="subjectname">
                                    Subject Name 
                                </div>
                                <div class="quizname">
                                    Quiz name
                                </div>                          
                            </td>
                            <td ><p>10/09/2021</p></td>
                            <td >
                                <div class="content1">
                                    <p>xx correct</p>
                                    <p>yy questions</p>
                                </div>
                            </td>
                            <td ><p> 50% correct</p></td>
                            <td > 
                                <button type="button" class="btn btn-primary"  data-toggle="modal" data-target="#exampleModal">
                                    View details
                                </button>
                            </td>       
                        </tr>

                        <!--Subarea-->
                        <tr>
                            <td colspan="5" class="subarea">
                                <p>Test type</p> <p>Duration - hh:mm:ss</p>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <div class="subjectname">
                                    Subject Name 
                                </div>
                                <div class="quizname">
                                    Quiz name
                                </div>                          
                            </td>
                            <td ><p>10/09/2021</p></td>
                            <td >
                                <div class="content1">
                                    <p>xx correct</p>
                                    <p>yy questions</p>
                                </div>
                            </td>
                            <td ><p> 50% correct</p></td>
                            <td > 
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                                    View details
                                </button>
                            </td>            
                        </tr>

                        <!--Subarea-->
                        <tr>
                            <td colspan="5" class="subarea">
                                <p>Test type</p> <p>Duration - hh:mm:ss</p>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <div class="subjectname">
                                    Subject Name 
                                </div>
                                <div class="quizname">
                                    Quiz name
                                </div>                          
                            </td>
                            <td ><p>10/09/2021</p></td>
                            <td >
                                <div class="content1">
                                    <p>xx correct</p>
                                    <p>yy questions</p>
                                </div>
                            </td>
                            <td ><p> 50% correct</p></td>
                            <td > 
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                                    View details
                                </button>
                            </td>                    
                        </tr>

                        <!--Subarea-->
                        <tr>
                            <td colspan="5" class="subarea">
                                <p>Test type</p> <p>Duration - hh:mm:ss</p>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <div class="subjectname">
                                    Subject Name 
                                </div>
                                <div class="quizname">
                                    Quiz name
                                </div>                          
                            </td>
                            <td ><p>10/09/2021</p></td>
                            <td >
                                <div class="content1">
                                    <p>xx correct</p>
                                    <p>yy questions</p>
                                </div>
                            </td>
                            <td ><p> 50% correct</p></td>
                            <td > 
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                                    View details
                                </button>
                            </td>                    
                        </tr>
                        <!--Subarea-->
                        <tr>
                            <td colspan="5" class="subarea">
                                <p>Test type</p> <p>Duration - hh:mm:ss</p>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <nav aria-label="..." class="mt-2">
                <ul class="pagination">
                    <li class="page-item disabled">
                        <span class="page-link">Previous</span>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item active">
                        <span class="page-link">
                            2
                            <span class="sr-only">(current)</span>
                        </span>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                    </li>
                </ul>
            </nav>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="#">
                            <h2>Practice Details</h2>
                            
                            <div class="form-group">

                                <select class="custom-select my-1 mr-sm-2" id="subject-name-preference">
                                    <option selected>Subject Name</option>
                                    <option value="1">One</option>
                                    <option value="2">Two</option>
                                    <option value="3">Three</option>
                                </select>
                            </div>

                            
                                <div class="form-group">
                                    <label for="number-questions">Number of practicing questions</label>
                                    <input type="text" class="form-control" id="number-questions">   
                                </div>
                                <div class="form-group">
                                    <label class="my-1 mr-2" for="question-by-topic-dimension">Question group(choose one or all topic/dimension)</label>
                                    <select class="custom-select my-1 mr-sm-2" id="question-by-topic-dimension">
                                        <option selected>Choose...</option>
                                        <option value="1">One</option>
                                        <option value="2">Two</option>
                                        <option value="3">Three</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label class="my-1 mr-2" for="question-by-all-dimension">Question are selected by topic(s) or a specific dimension?</label>
                                    <select class="custom-select my-1 mr-sm-2" id="question-by-all-dimension">
                                        <option selected>Choose...</option>
                                        <option value="1">One</option>
                                        <option value="2">Two</option>
                                        <option value="3">Three</option>
                                    </select>
                                </div>
                            
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script>
            $('#myModal').on('shown.bs.modal', function () {
                $('#myInput').trigger('focus')
            })
        </script>
    </body>
</html>
