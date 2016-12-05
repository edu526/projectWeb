<%@page import="persistencia.Vehiculo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="x" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="styls/plantilla-list-part01.jsp" %>
    </head>
    <body>
        <% List<Vehiculo> veh = (List) session.getAttribute("vehList");%>
        <!-- MENU -->
        <%@ include file="styls/plantilla-part02.jsp" %>
        <!-- FIN MENU -->
        <!-- TITULO PÁGINA -->
        <div class="row tile_count">

        </div>
        <!-- FIN TITULO PÁGINA -->        
        <!-- CUERPO DE LA PÁGINA -->
        

                        <table>
                            <thead>
                                <tr>
                                    <th>Cod</th>
                                    <th>NºFlota</th>
                                    <th>Dueño</th>
                                    <th>Modelo</th>
                                    <th>Precio</th>
                                    <th>       </th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (Vehiculo v: veh) {
                                %>
                                
                                <x:form action="/AgregarVehiculoAction">
                                <tr>
                                    <td><x:text property="cod" value='<%= v.getCodveh()%>' readonly="true"/></td>
                                    <td><%= v.getNflota()%></td>
                                    <td><%= v.getCodemp().getNomemp()+" "+ v.getCodemp().getApeemp()%></td>
                                    <td><%= v.getModelveh()%></td>
                                    <td><%= v.getPrecveh()+"" %></td>
                                                                       
                                    <td><x:submit value="Agregar"/></td>
                                </tr>
                                </x:form>
                                <% }%>
                            </tbody>
                        </table >
        <!-- FIN CUERPO DE LA PÁGINA form-->

        <%@ include file="styls/plantilla-list-part03.jsp" %>
    </body>
</html>