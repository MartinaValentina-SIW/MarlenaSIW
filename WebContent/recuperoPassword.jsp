<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta name="google-signin-client_id" content="459495240300-htgjk6o0v5ekt5d12ftggpcik649vl9o.apps.googleusercontent.com">
    <meta charset="utf-8">
    <script src="assets/js/jquery.min.js"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>
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
    <link rel="stylesheet" href="assets/css/Profile-Picture-With-Badge.css">
    <link rel="stylesheet" href="assets/css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="assets/css/Social-Icon--hover-effect.css">
</head>

<body>
    <%
        String email=(String)session.getAttribute("email");
        if(email!=null){
            response.sendRedirect("blogmain.jsp");
        }
    %>
    <div class="login-clean" style="background-image: url(assets/img/maneskin2.jpg);padding: 200px 0px;">
        <form method="post" action="ResetPassword" style="background-color: rgb(237,228,182);">
            <p>Riceverai una nuova password sulla mail</p>
            <div class="form-group"><input id= "emailForm" class="form-control" type="email" name="email" placeholder="Email" required></div>
            <button type="submit" name="recPass" value="recPass">Manda Mail</button>
            ${message}
        </form>
    </div>
    <jsp:include page="navbar.jsp"/>


    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
    <script src="assets/js/agency.js"></script>
</body>

</html>