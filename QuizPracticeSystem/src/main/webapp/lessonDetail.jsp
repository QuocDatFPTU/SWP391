<%-- 
    Document   : LessonDetail
    Created on : Jul 26, 2021, 9:31:50 AM
    Author     : ntdun
--%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Lesson Detail</title>
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
    <link rel="stylesheet" href="LessionDetail.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />

<body>
    <div class="container-fluid">
        <div>
            <div class="container-fluid">
                <h1>Lesson Detail</h1>
                <div class="d-flex">
                    <div class="p-2" style="width: 75%;">
                        <label for="fname">Name</label><br>
                        <input type="text" id="fname" name="fname"><br>
                    </div>
                    <div class="ml-auto p-2" style="width:20%;">
                        <label>Type</label><br>
                        <select name="subject" id="subject">
                            <option value="" selected="selected">All statuses</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="container-fluid">
                <div class="d-flex">
                    <div class=" p-2" style="width: 75%;">
                        <label>Topic</label><br>
                        <select name="subject" id="subject">
                            <option value="" selected="selected">All statuses</option>
                        </select>
                    </div>
                    <div class="ml-auto p-2" style="width:20%;">
                        <label for="fname">Order</label><br>
                        <input type="text" id="fname" name="fname"><br>
                    </div>
                </div>
            </div>
            <div class="container-fluid">
                <div class="d-flex">
                    <div class="p-2" style="width:100%;">
                        <label for="fname">Video link</label><br>
                        <input type="text" id="fname" name="fname"><br>
                    </div>
                </div>
            </div>
            
        </div>
        <div class="container-fluid">
            <div>
                <p>HTML Content</p>
                <textarea name="" id="" cols="30" rows="10" style="width: 100%"></textarea>
            </div>
            <div class="d-flex">
                <div class="p-2">
                    <button type="button" class="btn btn-outline-dark" style="width: 10rem;">Dark</button>
                </div>
                
                <div class="p-2" >
                    <button type="button" class="btn btn-outline-dark"style="width: 10rem; margin-left: 50px">Dark</button>
              </div>
        </div>
       
    </div>

</body>

</html>