<%-- 
    Document   : Vehiculo
    Created on : 21-nov-2016, 21:55:23
    Author     : Miriam
--%>

<%@page import="persistencia.Vehiculo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="x" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VEHICULO</title>
        <style>@import"Alquiler.css"</style>
    </head>
    <body>
      <body>
                <div id="doc">
        <table>
            <tr>  <div   id="enc" >
                 <h2> MANTENIMIENTO VEHICULO </h2></div>
            </tr>
       </table> 
                                <x:form action="/GrabarVehAction">
             
                <div id="med"> 
                   <table id="tabDet">
                    
                       <tr><td > Codigo: </td>
                      <td>
                          <x:text property="codVeh" size="10"/>
                      </td>
                </tr>
                
                <tr> <td>Matricula: </td>
                    <td>
                <x:text property="matricuVeh" size="30" />
                </td>
                
                
                <td colspan="6">Modelo:</td>
                    <td>
                <x:text property="modelVeh" size="30"/>
                 </td></tr>
                
                
                <tr><td>Motor:</td>
                    <td>
                <x:text property="motorVeh" size="30"/>
                    </td>
                
                
                <td colspan="6">Serie:</td>
                    <td>
                <x:text property="serieVeh" size="30"/>
                    </td></tr>
                
                
                <tr><td>Año:</td>
                    <td>
                <x:text property="anioVeh" size="30"/>
                </td>
                
                <td colspan="6">Estado:</td>
                    <td>
                <x:text property="estadVeh" size="20"/>
                </td></tr>
                
                <tr><td>Tipo:</td>
                    <td>
                <x:text property="tipoVeh" size="30"/>
                </td>
                <td colspan="6">Precio:</td>
                    <td>
                <x:text property="precVeh" size="30"/>
                </td></tr>
                <tr>
                    <td>
                    <x:submit value="Grabar"/>
                    </td></tr>
                   </table></div>
                
                
                    
                </div>
                
                         </x:form>
     
     
     <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR> <BR>

                <x:form action="/BuscarVehAction">
        
      
      <div id="med">
                <table id="tabIzq">
                    <tr>
                        <td colspan="2">BUSCAR VEHICULO</td>                        
                    </tr>
                    
                       <tr><td > Codigo: </td>
                      <td>
                          <x:text property="codVeh" size="10"/>
                      </td>
                </tr>
                <tr>
                    <td>
                    <x:submit value="Buscar"/>
                    </td></tr>
                </table>  
            </div>
                </x:form>

               
     <%Vehiculo v=(Vehiculo)session.getAttribute("v");%>
            <x:form action="/ActualizarVehAction">
            <div id="med">
                <table id="tabDer">
                    
                    <tr>
                        <td colspan="2">ACTUALIZAR DATOS </td>  
                       
                    </tr>
                    
                    <tr><td > Codigo: </td>
                      <td>
                          <x:text property="codVeh" value='<%=v.getCodveh() %>' size="10"/><br>
                      </td>
                </tr>
                
                <tr> <td> Matricula: </td>
                    <td>
                        <x:text property="matricuVeh" value='<%=v.getMatricuveh() %>' size="10"/><br>
                </td>
                
                
                <td colspan="6">Modelo:</td>
                    <td>
                        <x:text property="modelVeh" value='<%=v.getModelveh() %>' size="10"/><br>
                 </td></tr>
                
                
                <tr><td>Motor:</td>
                    <td>
                        <x:text property="motorVeh" value='<%=v.getMotorveh() %>' size="10"/><br>
                    </td>
                
                
                <td colspan="6">Serie:</td>
                    <td>
                        <x:text property="serieVeh" value='<%=v.getSerieveh() %>' size="10"/><br>
                    </td></tr>
                
                
                <tr><td>Anio</td>
                    <td>
                        <x:text property="anioVeh" value='<%=v.getAnioveh() %>' size="10"/><br>
                </td>
                
                <td colspan="6">Estado:</td>
                    <td>
                        <x:text property="estadVeh" value='<%=v.getEstadveh() %>' size="10"/><br>
                </td></tr>
                
                <tr><td>Tipo: </td>
                    <td>
                        <x:text property="tipoVeh" value='<%=v.getTipoveh() %>' size="10"/><br>
                </td>
                <td colspan="6">Precio: </td>
                    <td>
                        <x:text property="precVeh" value='<%=v.getPrecveh() %>' size="10"/><br>

                                <tr>
                    <td>
                    <x:submit value="Actualizar"/>
                    </td></tr>
                               
                </table>            
            </div> 
                    
                         </x:form>      
        
    </body>
</html>