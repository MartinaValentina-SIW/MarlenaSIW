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
    <script>
        window.fbAsyncInit = function() {
            FB.init({
                appId      : '483790008950410',
                cookie     : true,
                xfbml      : true,
                version    : 'v5.0'
            });

            FB.getLoginStatus(function(response) {
                statusChangeCallback(response);
            });

        };

        function onSignIn(googleUser) {
            var profile = googleUser.getBasicProfile();
            var email = profile.getEmail();

            $('#emailForm').val(email);
            $('#passForm').val("no");

            $('#accedibutton').val("google");
            $('#accedibutton').click();

            var auth2 = gapi.auth2.getAuthInstance();
            auth2.signOut();
        }

        function statusChangeCallback(response) {

            if(response.status === 'connected')
            {
                FB.api('/me?fields=name,email', function(fields)
                {
                    if(fields && !fields.error) {
                        var email = fields.email;
                        $('#emailForm').val(email);
                        $('#passForm').val('no');

                        $('#accedibutton').val('facebook');
                        $('#accedibutton').click();
                    }
                });
            }
        }

        (function(d, s, id){
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) {return;}
            js = d.createElement(s); js.id = id;
            js.src = "https://connect.facebook.net/en_US/sdk.js";
            fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));

        function checkLoginState() {
            FB.getLoginStatus(function(response) {
                statusChangeCallback(response);
            });
        }

    </script>
    <%
        String email=(String)session.getAttribute("email");
        if(email!=null){
            response.sendRedirect("blogmain.jsp");
        }
    %>
    <div class="login-clean" style="background-image: url(assets/img/maneskin2.jpg);padding: 200px 0px;">
        <form method="post" action="Accedi" style="background-color: rgb(237,228,182);">
            <div class="form-group"><input id= "emailForm" class="form-control" type="email" name="email" placeholder="Email"></div>
            <div class="form-group"><input id="passForm" class="form-control" type="password" name="password" placeholder="Password">${message}</div>
            <div class="form-group"><button class="btn btn-primary btn-block" id="accedibutton" name="accedibutton" type="submit" style="background-color: rgb(254,209,54);" value="login">Log In</button></div><a class="forgot" href="#">Forgot your email or password?</a>
            <div class="row" style="margin-top: 55px;">
                <div class="col">
                    <div class="container text-center d-flex float-none justify-content-sm-center align-items-sm-center">
                        <fb:login-button
                                scope="public_profile,email"
                                onlogin="checkLoginState();">
                        </fb:login-button>
                        <div class="row">
                            <div class="col">
                                <div class="g-signin2" data-onsuccess="onSignIn"></div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </form>
    </div>
    <jsp:include page="navbar.jsp"/>


    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
    <script src="assets/js/agency.js"></script>
</body>

</html>