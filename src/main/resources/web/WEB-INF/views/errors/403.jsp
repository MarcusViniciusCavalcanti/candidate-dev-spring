<%--
  Created by IntelliJ IDEA.
  User: vinicius
  Date: 06/10/18
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Acesso Inválido</title>
</head>
<body>
    <h1>Você não pode acessar esta página!</h1>

<p>

    ${requestScope.exception}
</p>

<p>
    ${requestScope.userPrincipal.name}
</p>

    <%
        // this string is only availble if the page is marked as an error page (above)
        String request_uri = (String)request.getAttribute("javax.servlet.error.request_uri");

// handle j_security_checks by forwarding to the index page.
// people will still be confused because they might think they have logged in a second time.

        if ( request_uri.indexOf("j_security_check") > 0 ){
            request.getRequestDispatcher("/").forward(request, response);
        }

// keep the response short, so the browser can override it if it likes.
    %>
</body>
</html>
