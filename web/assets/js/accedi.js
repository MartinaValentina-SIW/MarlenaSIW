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
    console.log("WE");
    var profile = googleUser.getBasicProfile();
    var email = profile.getEmail();

    $('#emailForm').val(email);
    $('#passForm').val("no");

    $('#accedibutton').val("google");
    $('#accedibutton').click();

    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut();
    //
    // document.location.href="/Accedi";
}

function statusChangeCallback(response) {

    if(response.status === 'connected')
    {

        FB.api('/me?fields=name,email', function(fields)
        {
            if(fields && !fields.error) {


                var email = fields.email;
                alert(fields.email);
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
    alert('non va');
    FB.getLoginStatus(function(response) {
        statusChangeCallback(response);
    });
}