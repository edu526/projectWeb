<%-- 
    Document   : Alquiler
    Created on : 21-nov-2016, 15:14:16
    Author     : Miriam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALQUILER</title>
        <style>@import"Alquiler.css";</style>
    </head>
    <body>
         <div id="doc">
 <div id="izq">
                <table id="tabIzq">
                    <tr>
                        <td colspan="2">COMERCIAL ARCO IRIS</td>                        
                    </tr>
                    <tr>
                        <td>DNI</td>
                        <td><input type="text"/></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text"/></td>
                    </tr>
                    <tr>
                        <td>Direccion</td>
                        <td><input type="text"/></td>
                    </tr>                    
                </table>  
            </div>
            <div id="der">
                <table id="tabDer">
                    <tr>
                        <td colspan="2">NOTA DE PEDIDO</td>                        
                    </tr>
                    <tr>
                        <td>Numero</td>
                        <td><input type="text"/></td>
                    </tr>
                    <tr>
                        <td>Fecha</td>
                        <td><input type="text"/></td>
                    </tr>
                    <tr>
                        <td>Hora</td>
                        <td><input type="text"/></td>
                    </tr>                    
                </table>            
            </div>           
        </div>
        <div id="det">
            <table id="tabDet">
                <tr>
                    <td>Codigo</td>
                    <td>Nombre</td>
                    <td>Precio</td>
                    <td>Cantidad</td>
                    <td>Importe</td>
                    <td></td>
                </tr>
                <tr>
                    <td><input type="text" size="10"/></td>
                    <td><input type="text" size="45"/></td>
                    <td><input type="text" size="10"/></td>
                    <td><input type="text" size="5"/></td>
                    <td><input type="text" size="10"/></td>
                    <td><input type="submit" value="Quitar"/></td>                    
                </tr>
            </table>
        </div>
        <div id="pie">
            <table id="tabPie">
                <tr>
                    <td><input type="submit" value="Nuevo Pedido"/></td>
                    <td><input type="submit" value="Consultar Producto"/></td>
                    <td><input type="submit" value="Grabar Pedido"/></td>
                    <td>Total=====></td>
                    <td><input type="text" size="10"/></td>
                </tr>
            </table>
        </div>
    </body>
</html>
