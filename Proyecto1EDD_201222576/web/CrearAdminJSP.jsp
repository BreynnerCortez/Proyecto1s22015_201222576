<%-- 
    Document   : CrearAdminJSP
    Created on : 16/09/2015, 06:34:33 PM
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
        <h1>Bienvenido a Creacion de Administradores.</h1>
        <form action="ServeletCrearAdmin" method="POST">
            <div style="text-align: left;">
                    Usuario:
            <input type="text" name="correo"  value="" /> <br> <br>
                    Contraseña:
                    <input type="text" name="contrase"   value="" /> <br><br>
            <input type="submit" value="Registrar" name="Registro"  />
             </div><br>
            <a href="AdministradorJSP.jsp">Regresar</a>
        </form>
    </body>
</html>
