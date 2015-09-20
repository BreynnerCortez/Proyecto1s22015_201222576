<%-- 
    Document   : CrearChofer
    Created on : 19/09/2015, 09:02:23 PM
    Author     : Breynner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Bienvenido a MuniGT!</title>
        <style type="text/css">
        body{
    background-image:url('https://upload.wikimedia.org/wikipedia/commons/d/d2/Bandera_Municipalidad_de_Guatemala.jpg');
        }
         </style>
    </head>
    <body>
        <h1>Bienvenido a Creacion de Choferes.</h1>
        <form action="ServeletCrearChofer" method="POST">
            <div style="text-align: left;">
                    Clave:
            <input type="number" name="clave"  value="" /> <br> <br>
                    Contraseña:
            <input type="text" name="contra"   value="" /> <br><br>
                    Nombre:
            <input type="text" name="nombre"   value="" /> <br><br>
                    Apellido:
            <input type="text" name="apellido"   value="" /> <br><br>
            <input type="submit" value="Registrar" name="Registro"  />
            </div><br>
            <a href="AdministradorJSP.jsp">Regresar</a>
        </form>
        <div style="text-align: right;">
            <img src="chofer.jpg" width="630" height="1430" alt="estaciones"/></div>
    </body>
</html>
