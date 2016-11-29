<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="x" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="styls/plantilla-list-part01.jsp" %>
    </head>
    <body>
        <!-- MENU -->
        <%@ include file="styls/plantilla-part02.jsp" %>
        <!-- FIN MENU -->
        <!-- TITULO PÁGINA -->
        <div class="row tile_count">

        </div>
        <!-- FIN TITULO PÁGINA -->        
        <!-- CUERPO DE LA PÁGINA -->
        <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Buscar Empleado </h2>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">

                        <table id="datatable-buttons" class="table table-striped table-bordered">
                            <thead>
                                <tr>
                                    <th>Cod</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Email</th>
                                    <th>       </th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (int i = 0; i < 5; i++) {
                                %>
                                
                                <x:form action="/ActualizarEmpAction">
                                <tr>
                                    <td><x:text property="cod" value='<%= "Hola" %>' readonly="true"/></td>
                                    <td><%= "Hola" %></td>
                                    <td><%= "Hola" %></td>
                                    <td><%= "Hola" %></td>
                         
                                    <td><x:submit value="Modificar o Ver"/></td>
                                </tr>
                                </x:form>
                                <% }%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <!-- FIN CUERPO DE LA PÁGINA form-->

        <%@ include file="styls/plantilla-list-part03.jsp" %>
    </body>
</html>