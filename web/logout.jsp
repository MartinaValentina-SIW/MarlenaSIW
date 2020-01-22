<%--
  Created by IntelliJ IDEA.
  User: demig
  Date: 21/01/2020
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%
    session.invalidate();
    response.sendRedirect("index.jsp");
%>
