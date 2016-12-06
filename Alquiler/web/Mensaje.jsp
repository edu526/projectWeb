<%-- 
    Document   : index
    Created on : 28/11/2016, 02:15:42 PM
    Author     : edd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="x" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="styls/plantilla-part01.jsp" %>
    </head>
    <body>
        <%@ include file="styls/plantilla-part02.jsp" %>
        
        <!-- CUERPO DE LA PÁGINA -->
        <input type="text" size="50" value="<%= (String)session.getAttribute("msg") %>" />        
        <!-- FIN CUERPO DE LA PÁGINA form-->
        
        <%@ include file="styls/plantilla-part03.jsp" %>
    </body>
</html>
