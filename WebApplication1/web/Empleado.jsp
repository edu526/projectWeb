

<%@page import="persistencia.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="x"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EMPLEADO</title>
        <style>@import"Alquiler.css";</style>
    </head>
 <body>
                <div id="doc">
        <table>
            <tr>  <div   id="enc" >
                 <h2> MANTENIMIENTO EMPLEADO </h2></div>    
            </tr>
        </table>
            <x:form action="/GrabarEmpAction">
             
                <div id="med"> 
                   <table id="tabDet">
                    
                       <tr><td > Codigo: </td>
                      <td>
                          <x:text property="codEmp" size="10"/>
                      </td>
                </tr>
                
                <tr> <td> Nombre: </td>
                    <td>
                <x:text property="nomEmp" size="30" />
                </td>
                
                
                <td colspan="6">Apellido:</td>
                    <td>
                <x:text property="apeEmp" size="30"/>
                 </td></tr>
                
                
                <tr><td>Direccion:</td>
                    <td>
                <x:text property="dirEmp" size="30"/>
                    </td>
                
                
                <td colspan="6">DNI:</td>
                    <td>
                <x:text property="dniEmp" size="30"/>
                    </td></tr>
                
                
                <tr><td>Lic. Conducir:</td>
                    <td>
                <x:text property="licCon" size="30"/>
                </td>
                
                <td colspan="6">Telefono:</td>
                    <td>
                <x:text property="telEmp" size="20"/>
                </td></tr>
                
                <tr><td>Seguro:</td>
                    <td>
                <x:text property="seguroEmp" size="30"/>
                </td>
                <td colspan="6">Email:</td>
                    <td>
                <x:text property="emailEmp" size="30"/>
                </td></tr>
                <tr>
                    <td>
                    <x:submit value="Grabar"/>
                    </td></tr>
                   </table></div>
                
                
                    
                </div>
                
                         </x:form>
     
     
     <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR> <BR>

                <x:form action="/BuscarEmpAction">
        
      
      <div id="med">
                <table id="tabIzq">
                    <tr>
                        <td colspan="2">BUSCAR EMPLEADO</td>                        
                    </tr>
                    
                       <tr><td > Codigo: </td>
                      <td>
                          <x:text property="codEmp" size="10"/>
                      </td>
                </tr>
                <tr>
                    <td>
                    <x:submit value="Buscar"/>
                    </td></tr>
                </table>  
            </div>
                    

        </x:form>

      <%Empleado e=(Empleado)session.getAttribute("e");%>
            <x:form action="/ActualizarEmpAction">
            <div id="med">
                <table id="tabDer">
                    
                    <tr>
                        <td colspan="2">ACTUALIZAR DATOS </td>  
                       
                    </tr>
                    
                    <tr><td > Codigo: </td>
                      <td>
                          <x:text property="codEmp" value='<%=e.getCodemp()%>'/>
                      </td>
                </tr>
                
                <tr> <td> Nombre: </td>
                    <td>
                        <x:text property="nomEmp" value='<%=e.getNomemp()%>' size="10"/><br>
                </td>
                
                
                <td colspan="6">Apellido:</td>
                    <td>
                        <x:text property="apeEmp" value='<%=e.getApeemp()%>' size="10"/><br>
                 </td></tr>
                
                
                <tr><td>Direccion:</td>
                    <td>
                        <x:text property="dirEmp" value='<%=e.getDiremp()%>' size="10"/><br>
                    </td>
                
                
                <td colspan="6">DNI:</td>
                    <td>
                        <x:text property="dniEmp" value='<%=e.getDniemp()%>' size="10"/><br>
                    </td></tr>
                
                
                <tr><td>Lic. Conducir:</td>
                    <td>
                        <x:text property="licCon" value='<%=e.getLiccon()%>' size="10"/><br>
                </td>
                
                <td colspan="6">Telefono:</td>
                    <td>
                        <x:text property="telEmp" value='<%=e.getTelemp()%>' size="10"/><br>
                </td></tr>
                
                <tr><td>Seguro:</td>
                    <td>
                        <x:text property="seguroEmp" value='<%=e.getSeguroemp()%>' size="10"/><br>
                </td>
                <td colspan="6">Email:</td>
                    <td>
                        <x:text property="emailEmp" value='<%=e.getEmailemp()%>' size="10"/><br>

                                <tr>
                    <td>
                    <x:submit value="Actualizar"/>
                    </td></tr>
                               
                </table>            
            </div> 
                    
                         </x:form> 
    
        
    </body>
</html>
