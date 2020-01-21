<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <script src="assets/js/registrati.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Marlena</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,700">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Kaushan+Script">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/Elegant-Registration-Form.css">
    <link rel="stylesheet" href="assets/css/Login-Form-Clean.css">
    <link rel="stylesheet" href="assets/css/Profile-Picture-With-Badge-1.css">
    <link rel="stylesheet" href="assets/css/Profile-Picture-With-Badge.css">
    <link rel="stylesheet" href="assets/css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="assets/css/Social-Icon--hover-effect-1.css">
    <link rel="stylesheet" href="assets/css/Social-Icon--hover-effect.css">
</head>

<body>
    <%
        String email=(String)session.getAttribute("email");
        if(email!=null){
            response.sendRedirect("blogmain.jsp");
        }
    %>
    <div class="register-photo" style="background-image: url(assets/img/maneskin2.jpg);padding: 110px 0px;">
        <div class="form-container">
            <form method="post" action="Registrati" style="background-color: rgb(237,228,182);padding: 50px 50px;">
                <h2 class="text-center"><strong>Create</strong> an account.</h2>
                <div class="form-group">
                    <input class="form-control" type="email" name="email" placeholder="Email" required>
                </div>
                <div class="form-group"><input class="form-control" type="text" name="username" placeholder="Username" required>
                </div>
                <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Password" required>
                </div>
                <div class="form-group"><input class="form-control" type="password" name="password-repeat" placeholder="Password (repeat)" required>
                </div>
                <div class="form-group">
                    <div class="form-check"><label class="form-check-label"><input class="form-check-input" type="checkbox" required>Accetta termini e condizioni</label></div>
                </div>
                <div class="form-group"><button class="btn btn-primary btn-block" type="submit" style="background-color: rgb(37,28,19);" name="registratibutton" value="ok">Sign Up</button></div><a class="already" href="accedi.jsp">Hai già un account? Accedi da qui</a>
                ${message}

                <div class="row" style="margin-top: 55px;">
                    <div class="col">
                        <div class="container text-center d-flex float-none justify-content-sm-center align-items-sm-center">
                            <a class="social-link" href="#" style="margin: 0px 5px;">
                                <i class="fa fa-facebook social-link-icon" style="color: rgb(37,28,19);"></i>
                                <div class="social-link-effect"></div></a>
                            <a class="social-link" href="#" style="margin: 0px 5px;">
                                <i class="fa fa-google social-link-icon" style="color: rgb(37,28,19);"></i>
                                <div class="social-link-effect"></div>
                            </a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <jsp:include page="navbar.jsp"/>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
    <script src="assets/js/agency.js"></script>
</body>

</html>