<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
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

<body style="background-image: url(assets/img/maneskin2.jpg);">
<%
    String email=(String)session.getAttribute("email");
    if(email==null){
        response.sendRedirect("accedi.jsp");
    }
%>
<jsp:include page="navbar.jsp"/>
    <div class="container" style="margin: 0px;margin-left: 0px;margin-right: 0px;padding: 25px;padding-top: 120px;">
        <div class="row" style="margin-left: 15px;margin-right: 15px;background-color: #ede4b6;">
            <div class="col">
                <h1>Acquista</h1>
            </div>
        </div>
        <div class="row" id="premio" style="margin-left: 15px;margin-right: 15px;background-color: #ede4b6;">
            <div class="col">
                <div class="row">
                    <div class="col text-center d-sm-flex justify-content-sm-start"><img></div>
                </div>
                <div class="row">
                    <div class="col d-sm-flex justify-content-sm-start">
                        <h6 id="nomeEprezzo">Nome Sito - Prezzo</h6>
                    </div>
                </div>
            </div>
            <div class="col text-right" style="padding-top: 20px;"><button class="btn btn-primary" type="button">Acquista sul sito</button></div>
        </div>
        <div class="row" style="margin-left: 15px;margin-right: 15px;background-color: #ede4b6;"></div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
    <script src="assets/js/agency.js"></script>
</body>

</html>