<%-- 
    Document   : quizPage
    Created on : Jul 26, 2021, 7:48:39 PM
    Author     : Polaris
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
 <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Quiz Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" />
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
        <link rel="stylesheet" href="QuizPage.css" />
        <script type="text/javascript" src="Timer.js"></script>
    </head>
    <body>
        <c:set var = "questionList" value="${sessionScope.questionList}"></c:set>
        <c:set var = "recentQuestion"  value="${sessionScope.recentQuestion}"></c:set>
        <c:set var ="question" value="${questionList[recentQuestion]}"></c:set>

        <c:set var ="questionStatusList" value="${sessionScope.questionStatus}"></c:set>
        <c:set var ="questionStatusMarked" value="${questionStatusList[recentQuestion].marked}"></c:set>

            <div style="border: solid blue; padding: 1rem;">
                <div class="container">
                    <hr>
                    <div class="d-flex flex-row-reverse">
                        <div class="p-2">
                            <div class="timer" style="font-size: 30px">1200</div>
                        </div>
                        <div class="p-2">
                            <div style="font-size: 30px">${recentQuestion}/${fn:length(questionList)}</div>
                    </div>
                </div>
            </div>
            <hr>
            <div class="question mb-2 bg-dark text-white">
                <div class="title">
                    <p>${recentQuestion} )</p>
                </div>
                <div class="questionID">
                    <p>${question.questionID}</p>
                </div>
            </div>
            <div class="questionDetail">
                <div>
                    <div class="info">
                        <p>${question.content}

                        </p>
                    </div>
                    <form id="answerForm" action="loadQuestion">
                        <!--varStatus de lay thuoc tinh count-->
                        <c:forEach var ="answer" items="${question.Option}" varStatus="answerStatus">
                            <input type="checkbox" id="Ans${answerStatus.count}" name="Ans" value="${answer.optionID}" />
                            <label for="Ans${answerStatus.count}"> ${answer.content}</label><br />
                        </c:forEach>
                    </form>
                </div>
                <div style="margin-top: 10rem;">
                    <div>
                        <!-- Button trigger modal -->
                        <div class="d-block text-right">
                            <button type="button" class="btn btn-outline-secondary" style="width: 10rem;" data-toggle="modal" data-target="#staticBackdrop">
                                <i class="fab fa-font-awesome"></i>
                                ${question.explanation}
                            </button>
                            <button type="button" class="btn btn-outline-success" style="width: 10rem;">
                                Mark for review
                            </button>
                        </div>

                        <!-- Modal -->
                        <div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1"
                             aria-labelledby="staticBackdropLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="staticBackdropLabel">
                                            Peek at answer
                                        </h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        ok
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                            Close
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="container-fluid d-flex bg-success text-white" style="margin-top: 10px; padding: 1rem;">
                        <button type="button" class="btn p-2 btn-outline-light" style="width: 10rem;" data-toggle="modal"
                                data-target="#reviewProgress">Review Progress</button>
                        <button type="button" class="btn p-2 btn-outline-light" style="width: 10rem; margin-left: 1rem;" data-toggle="modal"
                                data-target="#ExitExam">Exit</button>
                        <button form="answerForm" type="submit" class="btn btn-outline-light ml-auto p-2" style="width: 10rem;">Next</button>
                    </div>
                    <!-- Modal -->
                    <div class="modal fade" id="reviewProgress" data-backdrop="static" data-keyboard="false" tabindex="-1"
                         aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">
                                        Review Progress
                                    </h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div style="padding: 1rem; font-size: smaller;">
                                        <p>Review before scoring exam</p>
                                        <div>
                                            <div class="d-flex">
                                                <div class="mr-auto p-2">
                                                    <button type="button" class="btn btn-outline-secondary" style="width: 8rem;">
                                                        Unanswered
                                                    </button>
                                                    <button type="button" class="btn btn-outline-secondary" style="width: 8rem;">
                                                        Marked
                                                    </button>
                                                    <button type="button" class="btn btn-outline-secondary" style="width: 8rem;">
                                                        Answered
                                                    </button>
                                                    <button type="button" class="btn btn-outline-secondary" style="width: 8rem;">
                                                        All Questions
                                                    </button>
                                                </div>
                                                <div class="p-2">
                                                    <button type="submit" class="btn btn-outline-secondary" style="width: 9rem;"   data-dismiss="modal"
                                                            data-toggle="modal" data-target="#ScoreExam">
                                                        Score Exam now
                                                    </button>

                                                </div>
                                            </div>
                                            <hr>
                                            <div class="d-flex flex-wrap" style="margin-top: 1rem;">

                                                <button type="button" class="btn btn-outline-secondary answer">
                                                    1
                                                </button>
                                                <button type="button" class="btn btn-outline-secondary answer">
                                                    2
                                                </button>
                                                <button type="button" class="btn btn-outline-secondary answer">
                                                    3
                                                </button>
                                                <button type="button" class="btn btn-outline-secondary answer">
                                                    4
                                                </button>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                        Close
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal Score -->
        <div class="modal fade" id="ScoreExam" data-backdrop="static" data-keyboard="false" tabindex="-1"
             aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">
                            Score Exam?
                        </h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div>
                            <p>
                                17 of 20 Questions Answered
                            </p>
                            <div>
                                Click [Score Exam] to submit. You will not be able to change anything 
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal" data-toggle="modal"
                                data-target="#reviewProgress">
                            Back
                        </button>
                        <button type="button" class="btn btn-success" data-dismiss="modal">
                            Score Exam
                        </button>

                    </div>
                </div>
            </div>
        </div>
        <!-- Modal Exit-->
        <div class="modal fade" id="ExitExam" data-backdrop="static" data-keyboard="false" tabindex="-1"
             aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">
                            Exit now
                        </h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Click [Exit] to leave the test. Are you sure to exit ?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">
                            Close
                        </button>
                        <button type="button" class="btn btn-danger">Exit</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
