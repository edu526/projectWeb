<%-- 
    Document   : Portada
    Created on : 21-nov-2016, 15:35:31
    Author     : Miriam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="x" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INICIO</title>
        <style>@import"Alquiler.css";</style>
    </head>
    <body>
        <div id="doc">
        <table>
            <tr>  <div   id="enc" >
                 <h2> Bienvenido - Empresa de Transporte "Arca de Noe" </h2></div>
            </tr>
                     
                    
            
        
            <tr><div id="tabSpace"><input type="button" onclick=" location.href='Alquiler.jsp' " value="NUEVO ALQUILER" name="boton" /> 
            </div></tr>
            <tr><div id="tabSpace"><input type="button" onclick=" location.href='Alquiler.jsp' " value="BUSCAR ALQUILER" name="boton" />
            </div></tr>
                <tr><div id="tabSpace"><input type="button" onclick=" location.href='Alquiler.jsp' " value="ACTUALIZAR ALQUILER" name="boton" /> 
                </div></tr>
                
                <tr id="tabSpace2" > 
                    
                    
                    <td id="tabDer">
                        <input type="button" onclick=" location.href='Empleado.jsp' " value="MANTENIMIENTO EMPLEADO" name="boton" /> 
                    </td>
                    <td id="tabDer">
                        <input type="button" onclick=" location.href='Ruta.jsp' " value="MANTENIMIENTO RUTA" name="boton" /> 
                    </td>
                    <td id="tabDer">
                        <input type="button" onclick=" location.href='Vehiculo.jsp' " value="MANTENIMIENTO VEHICULO" name="boton" /> 
                    </td>
                
                </tr>

</table>                         
                
          
        </div>
    </body>
</html>
