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
        <!-- TITULO PÁGINA -->
        <div class="row tile_count">

        </div>
        <!-- FIN TITULO PÁGINA -->
        <!-- CUERPO DE LA PÁGINA -->
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">


                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">

                            <x:form action="/GrabarEmpAction" styleClass="form-horizontal form-label-left">

                                <span class="section">Datos Empleado</span>

                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="codEmp">Codigo <span class="required">*</span>
                                    </label>
                                    <div class="col-md-2 col-sm-2 col-xs-4">
                                        <x:text property="codEmp" styleClass="form-control col-md-7 col-xs-12" />
                                    </div>
                                </div>
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Nombre <span class="required">*</span>
                                    </label>
                                    <div class="col-md-4 col-sm-4 col-xs-8">
                                        <x:text property="nomEmp" styleClass="form-control col-md-7 col-xs-12"/>
                                    </div>
                                </div>

                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="occupation">Apellido <span class="required">*</span>
                                    </label>
                                    <div class="col-md-4 col-sm-4 col-xs-8">
                                        <x:text property="apeEmp" styleClass="form-control col-md-7 col-xs-12"/>
                                    </div>
                                </div>
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="direccion">Direccion <span class="required">*</span>
                                    </label>
                                    <div class="col-md-4 col-sm-4 col-xs-8">
                                        <x:text property="dirEmp" styleClass="form-control col-md-7 col-xs-12"/>
                                    </div>
                                </div>

                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="dni">DNI <span class="required">*</span>
                                    </label>
                                    <div class="col-md-4 col-sm-4 col-xs-8">
                                        <x:text property="dniEmp" styleClass="form-control col-md-7 col-xs-12"/>
                                    </div>
                                </div>
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="licencia">Lic. Conducir <span class="required">*</span>
                                    </label>
                                    <div class="col-md-4 col-sm-4 col-xs-8">
                                        <x:text property="licCon" styleClass="form-control col-md-7 col-xs-12"/>
                                    </div>
                                </div>                                
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="telephone">Telefono <span class="required">*</span>
                                    </label>
                                    <div class="col-md-4 col-sm-4 col-xs-8">
                                        <x:text property="telEmp" styleClass="form-control col-md-7 col-xs-12"/>
                                    </div>
                                </div>                             
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="telephone">Seguro <span class="required">*</span>
                                    </label>
                                    <div class="col-md-4 col-sm-4 col-xs-8">
                                        <x:text property="seguroEmp" styleClass="form-control col-md-7 col-xs-12"/>
                                    </div>
                                </div>  
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">Email 
                                    </label>
                                    <div class="col-md-4 col-sm-4 col-xs-8">
                                        <x:text property="emailEmp" styleClass="form-control col-md-7 col-xs-12"/>
                                    </div>
                                </div>                                

                                <div class="ln_solid"></div>
                                <div class="form-group">
                                    <div class="col-md-6 col-md-offset-3">
                                        <x:submit styleClass="btn btn-primary" value="Grabar"/>
                                        <x:submit styleClass="btn btn-success" value="Cancelar" property="Cancelar"/>
                                    </div>                                    
                                </div>
                            </x:form>
                        </div>
                    </div>
                </div>
            </div>
        <!-- FIN CUERPO DE LA PÁGINA-->

        <%@ include file="styls/plantilla-part03.jsp" %>
    </body>
</html>
