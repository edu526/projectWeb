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

                <div class="title_right">
                    <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">

                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">

                        <div class="x_content">
                            <span class="section">Datos Alquiler</span>

                            <div class="form-horizontal form-label-left" >


                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" >Número</label>
                                    <div class="col-md-2 col-sm-2 col-xs-4">
                                        <input id="name" class="form-control col-md-7 col-xs-12" value='<%= alq.getNumAlq() + ""%>' type="text">
                                    </div>
                                </div>
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" >Fecha</label>
                                    </label>
                                    <div class="col-md-2 col-sm-2 col-xs-4">
                                        <input id="name" class="form-control col-md-7 col-xs-12" value='<%= alq.getFecAlq()%>' type="text">
                                    </div>
                                </div>
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" >Hora</label>
                                    </label>
                                    <div class="col-md-2 col-sm-2 col-xs-4">
                                        <input id="name" class="form-control col-md-7 col-xs-12" value='<%= alq.getHora()%>' type="text">
                                    </div>
                                </div>

                                <span class="section">Datos Empleado</span>

                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" >Código</label>
                                    <div class="col-md-2 col-sm-2 col-xs-4">
                                        <input id="name" class="form-control col-md-7 col-xs-12" value='<%= alq.getCodEmp().getCodEmp()%>' type="text">
                                    </div>
                                </div>
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" >Nombre</label>
                                    <div class="col-md-4 col-sm-4 col-xs-8">
                                        <input id="name" class="form-control col-md-7 col-xs-12" value='<%= alq.getCodEmp().getNomEmp()%>' type="text">
                                    </div>
                                </div>

                                <span class="section">Datos Vehículo</span>

                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" >Código <span class="required">*</span>
                                    </label>
                                    <div class="col-md-2 col-sm-2 col-xs-4">
                                        <input id="name" class="form-control col-md-7 col-xs-12" value='<%= alq.getCodVeh().getCodVeh()%>' type="text">
                                    </div>
                                </div>
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Modelo</label>
                                    <div class="col-md-4 col-sm-4 col-xs-8">
                                        <input id="name" class="form-control col-md-7 col-xs-12" value='<%= alq.getCodVeh().getModelVeh()%>' type="text">
                                    </div>
                                </div>
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Costo</label>
                                    <div class="col-md-2 col-sm-2 col-xs-4">
                                        <input id="name" class="form-control col-md-7 col-xs-12" value='<%= alq.getCodVeh().getPrecVeh() + ""%>' type="text">

                                    </div>

                                </div>

                                <span class="section">Datos Ruta</span>

                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" >Código <span class="required">*</span>
                                    </label>
                                    <div class="col-md-2 col-sm-2 col-xs-4">
                                        <input id="name" class="form-control col-md-7 col-xs-12" value='<%= alq.getLinObj().getCodRut().getCodRut()%>' type="text">
                                    </div>
                                </div>
                                <div class="item form-group">
                                    <label for="password2" class="control-label col-md-3 col-sm-3 col-xs-12">Paradero</label>
                                    <div class="col-md-4 col-sm-4 col-xs-8">
                                        <input id="name" class="form-control col-md-7 col-xs-12" value='<%= alq.getLinObj().getCodRut().getParadAut()%>' type="text">
                                    </div>
                                </div>
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" >Costo</label>
                                    <div class="col-md-2 col-sm-2 col-xs-4">
                                        <input id="name" class="form-control col-md-7 col-xs-12" value='<%= alq.getLinObj().getCodRut().getPrecRut() + ""%>' type="text">
                                    </div>
                                </div>
                                <div class="ln_solid"></div>
                                <div class="form-group">
                                    <div class="col-md-6 col-md-offset-3">
                                        <x:form action="/ListarVehiculoAction">
                                            <x:submit property="lisVeh" value="Buscar Vehículo"/>
                                        </x:form>
                                        <x:form action="/ListarRutaAction">
                                            <x:submit property="lisRut" value="Buscar Ruta" />
                                        </x:form>
                                        <x:form action="/GrabarAlquilerAction">
                                            <x:submit property="gra" value="Grabar"/>
                                        </x:form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>


        <!-- FIN CUERPO DE LA PÁGINA-->

        <%@ include file="styls/plantilla-part03.jsp" %>
    </body>
</html>