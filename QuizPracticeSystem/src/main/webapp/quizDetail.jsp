<!doctype html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="css/quizDetails.css">
        <title>Create Quiz</title>
        <style>
            label{
                text-transform: uppercase;
            }
        </style>
    </head>
    <body>
        <c:set var="subjecList" value="${sessionScope.LIST_SUBJECT}"></c:set>
        <c:set var="currentQuiz" value="${sessionScope.QUIZ_DETAIL_ADMIN}"></c:set>
            <div class="container border-1">   
                <h2 class="title mt-5" style="font-weight: bold; color: #0b5ed7">Quiz Details</h2>
                <div class="mainSection">
                    <ul class="nav nav-tabs " id="myTab" role="tablist">
                        <li class="nav-item" role="presentation">
                            <button class="nav-link active" id="overview-tab" data-bs-toggle="tab" data-bs-target="#overview" type="button" role="tab" aria-controls="overview" aria-selected="true">Overview</button>
                        </li>

                        <li class="nav-item" role="presentation">
                        <c:if test="${currentQuiz.isFillFull eq true}">
                            <button class="nav-link" id="setting-tab" data-bs-toggle="tab" data-bs-target="#setting" type="button" role="tab" aria-controls="setting" aria-selected="false">Setting</button>
                        </c:if>
                    </li>
                </ul>
                <div class="tab-content" id="myTabContent" style="margin-top: 10px; border: solid; padding:10px; border-color: grey; border-radius: 5px">
                    <div class="tab-pane fade show active" id="overview" role="tabpanel" aria-labelledby="overview-tab">
                        <form action="createQuiz" method="POST">
                            <div class = "overViewName">
                                <label for="quizName">Name</label><br>
                                <input type="text" name="txtQuizName" value="${param.txtQuizName}">
                            </div>
                            </br>
                            <div class="overViewSubject">
                                <label for="overSubjectId">Subject</label>
                                <select class="form-select" id="overSubjectId" aria-label="Default select example" name="txtSubjectName" >
                                    <c:forEach var="subject" items="${subjecList}">
                                        <option value="${subject.subjectID}">${subject.subjectName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            </br>
                            <div class="firstBlock">
                                <div class="examLevel">
                                    <label for="examLevelID">Exam Level</label>
                                    <select class="form-select" id="examLevelID" aria-label="Default select example" name="txtExamLevel">
                                        <option value="Easy">Easy</option>
                                        <option value="Medium">Medium</option>
                                        <option value="Hard">Hard</option>
                                    </select>
                                </div>
                                </br>
                                <div class="duration">
                                    <label for="durationID">Duration(Minutes)</label>
                                    <input type="number" min="1" name="txtDuration" value="${param.txtDuration}">
                                </div>
                                </br>
                            </div>
                            <div class="secondBlock">
                                <div class="passRate">
                                    <label for="passRateID">Pass Rate(%)</label>
                                    <input type="number" min="10" name="txtPassrate" value="${param.txtPassrate}">
                                </div>
                                </br>
                                <div class="quizType">
                                    <label for="quizTypeID">Quiz Type</label>
                                    <select class="form-select" id="quizTypeID" aria-label="Default select example" name="txtQuizType">
                                        <option value="simulation">Simulation</option>
                                        <option value=" Lesson-Quiz">Lesson-Quiz</option>
                                    </select>
                                </div>
                                </br>
                            </div>
                            <div class="description">
                                <div class="form-floating">                      
                                    <textarea class="form-control" placeholder="Leave a comment here" id="description" style="height: 100px"></textarea>
                                    <label for="description"  name="txtDescription" value="${param.txtDescription}">Description</label>
                                </div>
                            </div>
                            <div class="actionSection" style="margin-top: 10px">

                                <button type="submit" class="btn btn-primary" name="btnAction" value="submit">Submit</button>
                                <button type="submit" class="btn btn-secondary" name="btnAction" value="back">Back</button>
                            </div>
                        </form>
                    </div>



                    <!---Setting-->
                    <c:if test="${currentQuiz.isFillFull eq true}">
                        <div class="tab-pane fade" id="setting" role="tabpanel" aria-labelledby="setting-tab">
                            <form action="createQuizSetting" method="POST">
                                <div class="numberOfQuestion">
                                    <label for="sumbOfQuestion">Number of question:</label>
                                    <input type="number" id="sumbOfQuestion" name="txtNumberOfQuestion" value="${param.txtNumberOfQuestion}">
                                </div>
                                </br>
                                <div class="typeOfQuiz">
                                    <p id="typeOfQuestion">Type of question:</p>
                                    <div class="chooseTypeOfQuiz">
                                        <c:if test="${not empty sessionScope.LIST_CHOICE}">
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="topic" disabled="disable">
                                                <label class="form-check-label" for="inlineRadio1">By Topic</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="group" disabled="disable">
                                                <label class="form-check-label" for="inlineRadio2">By Group</label>
                                            </div>   
                                        </c:if>
                                        <c:if test="${empty sessionScope.LIST_CHOICE}">
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="topic">
                                                <label class="form-check-label" for="inlineRadio1">By Topic</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="group">
                                                <label class="form-check-label" for="inlineRadio2">By Group</label>
                                            </div>   
                                        </c:if>
                                    </div>
                                </div>
                                </br>
                                <div class="questionSection">

                                    <p>Choose number of question</p>
                                    <div class="firstChoose" style="display: flex">
                                        <c:if test="${not empty currentQuiz.listGroupQuestion}">
                                            <select class="form-select" aria-label="Default select example" style="max-width: 500px">
                                                <c:forEach var="item" items="${sessionScope.LIST_CHOICE}">
                                                    <option value="${item}">${item}</option>
                                                    <c:url var="delete" value="deleteGroup">
                                                        <c:param name="nameOfType" value="${item}"></c:param>
                                                    </c:url>
                                                    <a href="${delete}">Delete</a>
                                                    <input type="number" name="txtNumberOfQuestionPerchoice" value="${param.txtNumberOfQuestionPerchoice}">
                                                </c:forEach>
                                            </select>
                                        </c:if>
                                        &nbsp
                                        <button type="button" class="btn btn-primary" name="btnAction" value="add">Add</button>   &nbsp &nbsp

                                    </div>
                                </div>
                                </br>
                                <div class="actionSection">
                                    <button type="button" class="btn btn-primary" name="btnAction" value="submit">Submit</button>
                                    <button type="button" class="btn btn-secondary" name="btnAction" value="back">Back</button>
                                </div>                                       
                            </form>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>


        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
</html>