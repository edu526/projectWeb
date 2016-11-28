<%-- 
    Document   : Ruta
    Created on : 21-nov-2016, 21:55:30
    Author     : Miriam
--%>

<%@page import="persistencia.Ruta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="x" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RUTA</title>
        <style>@import"Alquiler.css";</style>
    </head>
    <body>
                <div id="doc">
        <table>
            <tr>  <div   id="enc" >
                 <h2> MANTENIMIENTO RUTA </h2></div>    
            </tr>
        </table>
            <x:form action="/GrabarRutAction">
             
                <div id="med"> 
                   <table id="tabDet">
                    
                       <tr><td > Codigo: </td>
                      <td>
                          <x:text property="codRut" size="10"/>
                      </td>
                </tr>
                
                <tr> <td> Origen: </td>
                    <td>
                <x:text property="origRut" size="30" />
                </td>
                
                
                <td colspan="6">Destino:</td>
                    <td>
                <x:text property="destRut" size="30"/>
                 </td></tr>
                
                
                <tr><td>Paradero Aut.:</td>
                    <td>
                <x:text property="paradAut" size="30"/>
                    </td>
                
                
                <td colspan="6">Precio: </td>
                    <td>
                <x:text property="precRut" size="30"/>
                    </td></tr>
                
                
                
                <tr>
                    <td>
                    <x:submit value="Grabar"/>
                    </td></tr>
                   </table></div>
                
                
                    
                </div>
                
                         </x:form>
     
     
     <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR> <BR>

                <x:form action="/BuscarRutAction">
        
      
      <div id="med">
                <table id="tabIzq">
                    <tr>
                        <td colspan="2">BUSCAR EMPLEADO</td>                        
                    </tr>
                    
                       <tr><td > Codigo: </td>
                      <td>
                          <x:text property="codRut" size="10"/>
                      </td>
                </tr>
                <tr>
                    <td>
                    <x:submit value="Buscar"/>
                    </td></tr>
                </table>  
            </div>
                    

        </x:form>

     <%Ruta r=(Ruta)session.getAttribute("r");%>
            <x:form action="/ActualizarRutAction">
            <div id="med">
                <table id="tabDer">
                    
                    <tr>
                        <td colspan="2">ACTUALIZAR DATOS </td>  
                       
                    </tr>
                    
                    <tr><td > Codigo: </td>
                      <td>
                          <x:text property="codRut" value='<%=r.getCodrut() %>' /><br>
                      </td>
                </tr>
                
                <tr> <td> Origen: </td>
                    <td>
                        <x:text property="origRut" value='<%=r.getOrigrut() %>' size="10"/><br>
                </td>
                
                
                <td colspan="6">Destino:</td>
                    <td>
                        <x:text property="destRut" value='<%=r.getDestrut() %>' size="10"/><br>
                 </td></tr>
                
                
                <tr><td>Paradero Aut.:</td>
                    <td>
                        <x:text property="paradAit" value='<%=r.getParadaut() %>' size="10"/><br>
                    </td>
                
                
                <td colspan="6">Precio</td>
                    <td>
                        <x:text property="precRut" value='<%=r.getPrecrut() %>' size="10"/><br>
                    </td></tr>
                
                
                                
               
                    <x:submit value="Actualizar"/>
                    </td></tr>
                               
                </table>            
            </div> 
                    
                         </x:form> 
    </body>
</html>
