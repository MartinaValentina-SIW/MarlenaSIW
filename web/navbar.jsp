<%--
  Created by IntelliJ IDEA.
  User: demig
  Date: 21/01/2020
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String emailUser = (String)session.getAttribute("email");
%>
<body>

<nav class="navbar navbar-dark navbar-expand-lg fixed-top" id="mainNav" style="color: rgb(7,3,2);background-color: rgb(37,28,19);">
    <div class="container"><a class="navbar-brand" href="index.jsp" style="font-family: 'Roboto Slab', serif;color: rgb(251,240,231);">Marlena</a><button data-toggle="collapse" data-target="#navbarResponsive" class="navbar-toggler navbar-toggler-right" type="button" data-toogle="collapse"
                                                                                                                                                          aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="nav navbar-nav ml-auto text-uppercase">

                <%
                    if(emailUser == null)
                        out.print("<li class=\"nav-item\" role=\"presentation\"><a class=\"nav-link js-scroll-trigger\" href=\"accedi.jsp\">ACCEDI</a></li>\n" +
                                "                    <li class=\"nav-item\" role=\"presentation\"><a class=\"nav-link js-scroll-trigger\" href=\"registrati.jsp\">ISCRIVITI</a></li>\n");
                    else
                        out.print("<li class=\"nav-item\" role=\"presentation\"><a class=\"nav-link js-scroll-trigger\" href=\"yourprofile.jsp\">PROFILO</a></li>\n" +
                                "<li class=\"nav-item\" role=\"presentation\"><a class=\"nav-link js-scroll-trigger\" href=\"acquista.jsp\">ACQUISTA</a></li>" +
                                "<li class=\"nav-item\" role=\"presentation\"><a class=\"nav-link js-scroll-trigger\" href=\"logout.jsp\">LOGOUT</a></li>" +
                                "<li class=\"nav-item\" role=\"presentation\"><a class=\"nav-link js-scroll-trigger\" href=\"premi.jsp\">PREMI</a></li>");
                %>

                <li class="nav-item" role="presentation"><a class="nav-link js-scroll-trigger" href="#contact">GRUPPO</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link js-scroll-trigger" href="#contact">COME FUNZIONA</a></li>
            </ul>
        </div>
    </div>
</nav>
</body>