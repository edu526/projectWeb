<%@page import="java.util.List"%>
<%@page import="persistencia.Ruta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="x" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="styls/plantilla-list-part01.jsp" %>
    </head>
    <body>
        <% List<Ruta> rut = (List) session.getAttribute("rutList");%>
        <!-- MENU -->
        <%@ include file="styls/plantilla-part02.jsp" %>
        <!-- FIN MENU -->

        <!-- CUERPO DE LA PÁGINA -->

        <table class="table">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Parada</th>
                    <th>Precio</th>
                    <th>Día</th>
                    <th>       </th>
                </tr>
            </thead>
            <tbody>
                <% for (Ruta ru : rut) {
                %>

                <x:form action="/AgregarRutaAction">
                    <tr>
                        <td><x:text property="cod" value='<%= ru.getCodrut()%>' readonly="true"/></td>
                        <td><%= ru.getParadaut()%></td>
                        <td><%= ru.getPrecrut()%></td>
                        <td>
                            <x:select  property="dias">
                                <x:options property="dialist" />
                            </x:select>
                        </td>
                        <td><x:submit styleClass="btn btn-success" value="Agregar"/></td>
                    </tr>
                </x:form>
                <% }%>
            </tbody>
        </table>
        <!-- FIN CUERPO DE LA PÁGINA form-->

        <%@ include file="styls/plantilla-list-part03.jsp" %>
    </body>
</html>