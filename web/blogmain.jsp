<%@ page import="dbmanagers.ArticoloDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dbmanagers.Articolo" %>
<%@ page import="dbmanagers.Commento" %>
<%@ page import="dbmanagers.CommentoDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Marlena</title>
    <script src="assets/js/registrati.js"></script>
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

<body style="background-image: url(assets/img/maneskin2.jpg);"><nav class="navbar navbar-dark navbar-expand-lg fixed-top" id="mainNav" style="color: rgb(7,3,2);background-color: rgb(37,28,19);">
    <div class="container"><a class="navbar-brand" href="index.jsp" style="font-family: 'Roboto Slab', serif;color: rgb(251,240,231);">Marlena</a><button data-toggle="collapse" data-target="#navbarResponsive" class="navbar-toggler navbar-toggler-right" type="button" data-toogle="collapse"
            aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="nav navbar-nav ml-auto text-uppercase">
                <li class="nav-item" role="presentation"><a class="nav-link js-scroll-trigger" href="accedi.jsp">ACCEDI</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link js-scroll-trigger" href="registrati.jsp">ISCRIVITI</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link js-scroll-trigger" href="#contact">GRUPPO</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link js-scroll-trigger" href="#contact">COME FUNZIONA</a></li>
            </ul>
        </div>
    </div>
</nav>
    <div class="container" style="margin: 0px;margin-left: 0px;margin-right: 0px;padding: 25px;padding-top: 120px;">
        <div class="row" style="margin-left: 15px;margin-right: 15px;">
            <div class="col" style="padding: 0px;">
                <form method="post" action="Blogmain" style="background-color: #ede4b6;padding: 30px;">
                    <div class="form-group"><strong>Crea un nuovo articolo</strong></div>
                    <div class="form-group text-center"><input class="form-control" type="text" name="titolo" placeholder="Titolo" required></div>
                    <div class="form-group text-center"><input class="form-control" type="text" name="sottotitolo" placeholder="Sottotitolo" required></div>
                    <div class="form-group text-center"><textarea class="form-control" name="testo" placeholder="Testo" rows="8" required></textarea></div>
                    <div class="form-group text-center"><input type="file" class="form-control-file" id="media"></div>
                    <div class="form-group text-center"><button class="btn btn-primary" type="submit" id="nuovoArticolo" name="blogButton" value="nuovoArticolo">Conferma</button></div>
                </form>
            </div>
        </div>
    <%
        ArrayList<Articolo> articoli = new ArticoloDAO().getAllArticoli();
        ArrayList<ArrayList<Commento>> commenti = new CommentoDAO().getCommenti();
        for(Articolo a: articoli)
        {
            ArrayList<Commento> commentiArticolo = null;
            if (commenti != null && commenti.get(a.getId()) != null)
                commentiArticolo = commenti.get(a.getId());
            out.print(
                    "<div class=\"row\" id=\"articolo" + a.getId() + "\" style=\"background-color: rgb(237,228,182);margin: 30px 0px 0px 30px;padding: 20px;margin-right: 15px;margin-left: 15px;\">\n" +
                            "            <div class=\"col -2 col-md-2\" style=\"background-color: rgb(237,228,182);\"><img><em>"+ a.getAutore() +"</em></div>\n" +
                            "            <div class=\"col -12 col-md-10\">\n" +
                            "                <div class=\"card\">\n" +
                            "                    <div class=\"card-body\" style=\"background-color: rgb(237,228,182);\">\n" +
                            "                        <h4 class=\"card-title\">" + a.getTitolo() + "</h4>\n" +
                            "                        <h6 class=\"text-muted card-subtitle mb-2\">" + a.getSottotitolo() + "</h6>\n" +
                            "                        <p class=\"card-text\">"+ a.getTesto() +"</p><img>\n" +
                            "                        <div class=\"row\">\n" +
                            "                            <div class=\"col text-center\"><form method=\"post\" action=\"Blogmain\"><button class=\"btn btn-primary\" type=\"submit\" name=\"blogButton\" value=\"miPiace" + a.getId() + "-" + a.getAutore() + "\">Mi Piace - " + a.getNumMiPiace() + "</button></form></div>\n" +
                            "                        </div>\n" +
                            "                        <div></div>\n" +
                            "                        <div class=\"row\">\n" +
                            "                            <div class=\"col\" style=\"padding: 0px;\">\n" +
                            "                                <p style=\"font-size: 19px;margin-top: 15px;margin-bottom: 0px;\">Commenti</p>\n" +
                            "                            </div>\n" +
                            "                        </div>\n");

                    for(Commento c:commentiArticolo)
                    {
                        out.print("                        <div class=\"row\">\n" +
                                "                            <div class=\"col -2 col-md-2\" style=\"background-color: rgb(237,228,182);\"><img style=\"width: 30px;height: 30px;\"><em style=\"font-size: 13px;\">" + c.getUtente() + "</em></div>\n" +
                                "                            <div class=\"col\">\n" +
                                "                                <p style=\"font-size: 15px; margin-top: 10px;\">" + c.getTesto() + "</p>\n" +
                                "                            </div>\n" +
                                "                        </div>");
                    }

            out.print(

                    "                        <div class=\"row\">\n" +
                            "                            <div class=\"col\">\n" +
                            "                                <p>Nuovo Commento</p>\n" +
                            "                            </div>\n" +
                            "                        </div>\n" +
                            "                        <div class=\"row\">\n" +
                            "                            <div class=\"col text-center d-flex d-sm-flex d-md-flex d-lg-flex d-xl-flex justify-content-center align-items-center justify-content-sm-center align-items-sm-center justify-content-md-center align-items-md-center justify-content-lg-center align-items-lg-center justify-content-xl-center align-items-xl-center -4 col-md-8\"\n" +
                            "                                style=\"padding: 0px;padding-right: 0px;padding-left: 0px;padding-bottom: 0px;padding-top: 0px;\"><form method=\"post\" action=\"Blogmain\"><textarea class=\"flex-fill\" style=\"margin: 0px;margin-right: 0px;padding: 0px;padding-top: 0px;padding-right: 0px;\"></textarea></div>\n" +
                            "                            <div class=\"col text-center\" style=\"padding: 0px;padding-top: 5px;\"><button class=\"btn btn-primary\" type=\"submit\" name=\"blogButton\" value=\"nuovoCommento" + a.getId() + "-" + a.getAutore() + " \">Commenta</button></div></form>\n" +
                            "                        </div>\n" +
                            "                    </div>\n" +
                            "                </div>\n" +
                            "            </div>\n" +
                            "        </div>"
            );
        }
    %>


<%--        <div class="row" id="articolo2" style="background-color: rgb(237,228,182);margin: 30px 0px 0px 30px;padding: 20px;margin-right: 15px;margin-left: 15px;">--%>
<%--            <div class="col -2 col-md-2" style="background-color: rgb(237,228,182);"><img><em>Username</em></div>--%>
<%--            <div class="col -12 col-md-10">--%>
<%--                <div class="card">--%>
<%--                    <div class="card-body" style="background-color: rgb(237,228,182);">--%>
<%--                        <h4 class="card-title">Titolo Articolo</h4>--%>
<%--                        <h6 class="text-muted card-subtitle mb-2">Subtitle</h6>--%>
<%--                        <p class="card-text">Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p><img>--%>
<%--                        <div class="row">--%>
<%--                            <div class="col text-center"><button class="btn btn-primary" type="button">Mi Piace - 0</button></div>--%>
<%--                        </div>--%>
<%--                        <div></div>--%>
<%--                        <div class="row">--%>
<%--                            <div class="col" style="padding: 0px;">--%>
<%--                                <p style="font-size: 19px;margin-top: 15px;margin-bottom: 0px;">Commenti</p>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="row">--%>
<%--                            <div class="col -2 col-md-2" style="background-color: rgb(237,228,182);"><img style="width: 30px;height: 30px;"><em style="font-size: 13px;">Username</em></div>--%>
<%--                            <div class="col">--%>
<%--                                <p style="font-size: 15px;">Paragraph</p>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="row">--%>
<%--                            <div class="col -2 col-md-2" style="background-color: rgb(237,228,182);"><img style="width: 30px;height: 30px;"><em style="font-size: 13px;">Username</em></div>--%>
<%--                            <div class="col">--%>
<%--                                <p style="font-size: 15px;">Paragraph</p>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="row">--%>
<%--                            <div class="col">--%>
<%--                                <p>Nuovo Commento</p>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="row">--%>
<%--                            <div class="col text-center d-flex d-sm-flex d-md-flex d-lg-flex d-xl-flex justify-content-center align-items-center justify-content-sm-center align-items-sm-center justify-content-md-center align-items-md-center justify-content-lg-center align-items-lg-center justify-content-xl-center align-items-xl-center -4 col-md-8"--%>
<%--                                style="padding: 0px;padding-right: 0px;padding-left: 0px;padding-bottom: 0px;padding-top: 0px;"><textarea class="flex-fill" style="margin: 0px;margin-right: 0px;padding: 0px;padding-top: 0px;padding-right: 0px;"></textarea></div>--%>
<%--                            <div class="col text-center" style="padding: 0px;padding-top: 5px;"><button class="btn btn-primary" type="button">Commenta</button></div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>

    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
    <script src="assets/js/agency.js"></script>
</body>

</html>