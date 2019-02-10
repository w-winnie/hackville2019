<!DOCTYPE html>
<html lang="">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="css/style.css">
    <title>Registration</title>
</head>

<body>
    <div class="containment">
        <div class="cont d-flex justify-content-center">
            <h1>Registration</h1>
        </div>

        <div class="container login-width jumbotron d-flex justify-content-center">
            <div id="activeForm">
                <!--<button type="button" id="btnPrev" onclick="previous()">Prev</button>-->
                <div id="formHTML">
                </div>
                <br>
                <button type="button" id="btnNext" class="btn btn-success" onclick="next()">Next</button>
            </div>
        </div>


        <script src="register.js" charset="utf-8"></script>

        <div class="footer">
        </div>
    </div>

</body>

</html>
