<%@ page import="java.util.ArrayList" %>
<%@ page import="dbmanagers.Premio" %>
<%@ page import="dbmanagers.PremioDAO" %>
<%@ page import="dbmanagers.PremioOttenutoDAO" %>
<%@ page import="dbmanagers.Utente" %>
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
    <%
        String email=(String)session.getAttribute("email");
        if(email==null){
            response.sendRedirect("accedi.jsp");
        }
    %>

</head>

<body style="background-image: url(assets/img/maneskin2.jpg);">

<jsp:include page="navbar.jsp"/>

    <div class="container" style="margin: 0px;margin-left: 0px;margin-right: 0px;padding: 25px;padding-top: 120px;">
        <div class="row" style="margin-left: 15px;margin-right: 15px;background-color: #ede4b6;">
            <div class="col">
                <h1>Premi</h1>
            </div>
        </div>
        <%
            ArrayList<Premio> premi = new PremioDAO().getPremi();
            PremioOttenutoDAO podao = new PremioOttenutoDAO();
            Utente u = null;
            int numPremi = premi.size();
            for(Premio p:premi)
            {
                if (u == null && session.getAttribute("utente") instanceof Utente)
                 {
                     u = (Utente)session.getAttribute("utente");
                 }
                String button = "Ottieni";
                if(podao.isOttenuto(u.getUsername(),p.getId()))
                {
                    button = "Gia' ottenuto";
                }

                out.print(
                        "<form method=\"post\" action=\"Premi\">" +
                                "   <div class=\"row\" id=\"premio\" style=\"margin-left: 15px;margin-right: 15px;background-color: #ede4b6;\">\n" +
                                "            <div class=\"col\">\n" +
                                "                <div class=\"row\">\n" +
                                "                    <div class=\"col text-center d-sm-flex justify-content-sm-start\"><img></div>\n" +
                                "                </div>\n" +
                                "                <div class=\"row\">\n" +
                                "                    <div class=\"col d-sm-flex justify-content-sm-start\">\n" +
                                "                        <h6 id=\"nomeEprezzo\">Nome: "+ p.getNome() + " Costo: " + p.getCosto() + "</h6>\n" +
                                "                    </div>\n" +
                                "                </div>\n" +
                                "            </div>\n" +
                                "            <div class=\"col text-right\" style=\"padding-top: 20px;\"><button disable=\"false\" name=\"ottieniPremio\" value=\""+p.getId()+"\" class=\"btn btn-primary ottieniPremio\" type=\"submit\">"+ button +"</button></div>\n" +
                                "        </div></form>"
                );
            }
        %>

<%--        <div class="row" id="premio" style="margin-left: 15px;margin-right: 15px;background-color: #ede4b6;">--%>
<%--            <div class="col">--%>
<%--                <div class="row">--%>
<%--                    <div class="col text-center d-sm-flex justify-content-sm-start"><img></div>--%>
<%--                </div>--%>
<%--                <div class="row">--%>
<%--                    <div class="col d-sm-flex justify-content-sm-start">--%>
<%--                        <h6 id="nomeEprezzo">Nome Premio - Prezzo Premio</h6>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col text-right" style="padding-top: 20px;"><button class="btn btn-primary" type="button">Prendi</button></div>--%>
<%--        </div>--%>

    </div>
<script src="assets/js/premi.js"></script>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
    <script src="assets/js/agency.js"></script>
</body>

</html>