<%@ page import="dbmanagers.Utente" %>
<%@ page import="dbmanagers.UtenteDAO" %>
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
    <link rel="stylesheet" href="assets/css/Profile-Picture-With-Badge.css">
    <link rel="stylesheet" href="assets/css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="assets/css/Social-Icon--hover-effect.css">
</head>

<body>
    <div class="login-clean" style="background-image: url(assets/img/maneskin2.jpg);">
        <form method="post" style="background-color: rgb(237,228,182);">
            <h2 class="sr-only">Login Form</h2>
            <div class="illustration">
        <div class="profile-header-container">   
    		<div class="profile-header-img">
                <img src="assets/img/photo.jpg" />
                <div class="rank-label-container">
                    <span class="label label-default rank-label">
                        <%
                            String email = "0";
                            if(session.getAttribute("email") instanceof String)
                            {
                                email = (String)session.getAttribute("email");
                            }
                            int mipiace = new UtenteDAO().getUtente(email).getTotMiPiace();
                            out.print(mipiace);
                        %>
                            mi piace</span>
                </div>
            </div>
        </div> 

                <div class="form-row">
                    <div class="col"><button class="btn btn-primary" type="button" style="margin: 0px;background-color: rgb(254,209,54);" disabled>Cambia Immagine</button></div>
                    <div class="col"><button class="btn btn-primary" type="button" style="margin: 0px;background-color: rgb(254,209,54);">Premi</button></div>
                </div>
            </div>
            <div class="form-group"><input class="form-control" type="email" name="email" placeholder="Email" value="<% out.print(session.getAttribute("email")); %>"></div>
            <div class="form-group"><input class="form-control" type="email" name="username" placeholder="Username" value="
                    <%
                        if(session.getAttribute("utente") instanceof Utente)
                            out.print(((Utente) session.getAttribute("utente")).getUsername());
                    %>
                "></div>
           <a class="forgot" href="#">Vuoi cambiare password?</a></form>
    </div>
    <jsp:include page="navbar.jsp"/>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
    <script src="assets/js/agency.js"></script>
</body>

</html>