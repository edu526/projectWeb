<%-- 
    Document   : Mensaje
    Created on : 21-nov-2016, 22:36:07
    Author     : Miriam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mensaje: <%=(String)session.getAttribute("msg")%></h1>
    </body>
</html>
