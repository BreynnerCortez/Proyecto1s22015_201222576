<%-- 
    Document   : Logeado
    Created on : 11/09/2015, 09:48:39 PM
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
        <div style="text-align: center;" >
        <h1>Bienvenido Administrador!</h1></div>
         <form action="ServletAdmin" method="POST">
             <div style="text-align: right;">
                    <%="Usuario"%>
            <input type="text" name="correo"  value="" />
                    <%="Contraseña"%>
            <input type="Password" name="contrase"   value="" />
            <input type="submit" value="Ingresar" name="Ingreso"  />
             </div>
            <hr>
            <div style="text-align: right;">
                <img src="admin.jpg" width="630" height="349" alt="admin"/>
            </div>
        </form>
    </body>
</html>
