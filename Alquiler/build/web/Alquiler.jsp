<%@page import="negocio.LineaObj"%>
<%@page import="negocio.AlquilerObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="x" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="styls/plantilla-part01.jsp" %>
    </head>
    <body>
        <% AlquilerObj alq = (AlquilerObj) session.getAttribute("alqObj");%>
        <%@ include file="styls/plantilla-part02.jsp" %>
        <!-- CUERPO DE LA PÁGINA -->
        <div class="">
            <div class="page-title">
                <div class="title_left">
                    <h3>Alquiler!!</h3>
                </div>

            </div>
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">

                        <div class="x_content">
                            <span class="section">Datos Alquiler</span>

                            <div class="form-horizontal form-label-left" >

                                <div class="item form-group">
                                    <label class="control-label col-md-1 col-sm-3 col-xs-6" >Número</label>
                                    <div class="col-md-2 col-sm-2 col-xs-2">
                                        <input id="name" class="form-control col-md-7 col-xs-12" value='<%= alq.getNumAlq() + ""%>' type="text" readonly="">
                                    </div>
                                    <label class="control-label col-md-1 col-sm-3 col-xs-3" >Fecha</label>
                                    </label>
                                    <div class="col-md-2 col-sm-2 col-xs-2">
                                        <input id="name" class="form-control col-md-7 col-xs-6" value='<%= alq.getFecAlq()%>' type="text" readonly="">
                                    </div>
                                    <label class="control-label col-md-1 col-sm-3 col-xs-6" >Hora</label>
                                    </label>
                                    <div class="col-md-2 col-sm-2 col-xs-4">
                                        <input id="name" class="form-control col-md-7 col-xs-6" value='<%= alq.getHora()%>' type="text" readonly="">
                                    </div>
                                </div>

                                <span class="section">Datos Empleado</span>

                                <div class="item form-group">
                                    <label class="control-label col-md-1 col-sm-3 col-xs-12" >Código</label>
                                    <div class="col-md-2 col-sm-2 col-xs-4">
                                        <input id="name" class="form-control col-md-7 col-xs-12" value='<%= alq.getCodEmp().getCodEmp()%>' type="text" readonly="">
                                    </div>
                                    <label class="control-label col-md-1 col-sm-3 col-xs-12" >Nombre</label>
                                    <div class="col-md-4 col-sm-4 col-xs-8">
                                        <input id="name" class="form-control col-md-7 col-xs-12" value='<%= alq.getCodEmp().getNomEmp()%>' type="text" readonly="">
                                    </div>
                                </div>

                                <span class="section">Datos Vehículo</span>

                                <div class="item form-group">
                                    <label class="control-label col-md-1 col-sm-3 col-xs-12" >Código <span class="required">*</span>
                                    </label>
                                    <div class="col-md-2 col-sm-2 col-xs-4">
                                        <input id="name" class="form-control col-md-7 col-xs-12" value='<%= alq.getCodVeh().getCodVeh()%>' type="text" readonly="">
                                    </div>
                                    <label class="control-label col-md-1 col-sm-3 col-xs-12" for="name">Modelo</label>
                                    <div class="col-md-3 col-sm-3 col-xs-6">
                                        <input id="name" class="form-control col-md-7 col-xs-12" value='<%= alq.getCodVeh().getModelVeh()%>' type="text" readonly="">
                                    </div>
                                    <label class="control-label col-md-2 col-sm-3 col-xs-12">Costo x día</label>
                                    <div class="col-md-2 col-sm-2 col-xs-4">
                                        <input id="name" class="form-control col-md-7 col-xs-12" value='<%= alq.getCodVeh().getPrecVeh() + ""%>' type="text" readonly="">

                                    </div>
                                </div>
                                <x:form action="/ListarVehiculoAction">
                                    <x:submit styleClass="btn btn-warning" property="lisVeh" value="Listar Vehículos"/>
                                </x:form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="title_left">
            </div>
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">

                        <div class="x_content">
                            <div class="form-horizontal form-label-left" >
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>Codigo</th>
                                            <th>Nombre</th>
                                            <th>Precio</th>
                                            <th>Día</th>
                                            <th></th>
                                        </tr>    
                                    </thead>
                                    <tbody class="table">
                                        <%
                                            for (int i = 0; i < alq.getCesta().size(); i++) {
                                                LineaObj li = (LineaObj) alq.getCesta().get(i);
                                        %>
                                        <x:form action="/QuitarRutaAction">
                                        <tr> 
                                            <td><span class="label label-primary"><%= li.getCodRut().getCodRut()%></span></td>
                                            <td><%= li.getCodRut().getParadAut()%></td>
                                            <td><%= li.getCodRut().getPrecRut()%></td>
                                            <td><x:text property="dia" value="<%= li.getDia()%>" readonly="true"/></td>
                                            <td><x:submit styleClass="btn btn-danger" value="Quitar"/></td>                           
                                        </tr>
                                        </x:form>
                                        <% }%>
                                    </tbody>

                                </table>
                                <x:form action="/ListarRutaAction">
                                    <x:submit styleClass="btn btn-warning" property="lisRut" value="Listar Rutas" />
                                </x:form>
                                <table class="table" style="width: 30%; margin-left: 67%;">
                                    <tbody>
                                        <tr> 
                                            <td style="background-color: rgba(255, 235, 59, 0.39)">Rutas (S/.):</td>
                                            <td style="text-align: center"><%= alq.getImporteRutas()%></td>                                
                                        </tr>   
                                        <tr> 
                                            <td style="background-color: rgba(255, 235, 59, 0.39)">Vehículo/d (S/.):</td>
                                            <td style="text-align: center"><%= alq.getImporteVehículo()%></td>                                
                                        </tr>     
                                        <tr> 
                                            <td style="background-color: rgba(255, 235, 59, 0.39)">Descuento (S/.):</td>
                                            <td style="text-align: center"><%= alq.getDesct()%></td>                                
                                        </tr>        
                                        <tr> 
                                            <td style="background-color: rgba(255, 235, 59, 0.39)">Importe Total (S/.):</td>
                                            <td style="background-color: red; color: white; text-align: center"><samp><%= alq.getTotal()%></samp></td>                                
                                        </tr>     
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                            <x:form action="/GrabarAlquilerAction">
                                <x:submit styleClass="btn btn-danger  btn-lg" property="gra" value="Grabar"/>
                            </x:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- FIN CUERPO DE LA PÁGINA-->

        <%@ include file="styls/plantilla-part03.jsp" %>
    </body>
</html>