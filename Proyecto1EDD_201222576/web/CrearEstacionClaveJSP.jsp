<%-- 
    Document   : CrearEstacionClaveJSP
    Created on : 18/09/2015, 06:33:16 PM
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
        <h1>Bienvenido a Creacion de Estaciones Clave.</h1>
        <form action="ServeletCrearEsClave" method="POST">
            <div style="text-align: left;">
                    ID numerico:
            <input type="text" name="id"  value="" /> <br> <br>
                    Nombre:
            <input type="text" name="nombre"   value="" /> <br><br>
                    Contraseña:
            <input type="text" name="contrase"   value="" /> <br><br>
            <input type="submit" value="Registrar" name="Registro"  />
            </div><br>
            <a href="AdministradorJSP.jsp">Regresar</a>
        </form>
        <div style="text-align: right;">
            <img src="estaciones.jpg" width="630" height="1430" alt="estaciones"/></div>
    </body>
</html>
