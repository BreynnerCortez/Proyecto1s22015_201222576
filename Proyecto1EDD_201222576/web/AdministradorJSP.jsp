<%-- 
    Document   : AdministradorJSP
    Created on : 16/09/2015, 04:29:12 PM
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
        <jsp:useBean id="datos" scope="request" class="Bean.BeanAdmin" />
        <h1>Bienvenido: <jsp:getProperty name="datos" property="correoAdmin" />! </h1>
        <form  method="POST" action="ServletVerAdmins">
            <input type="submit" value="Ver Administradores" name="VerAdmins" />
        </form><br>
<pre><a href="CrearAdminJSP.jsp">Crear Administrador</a>     <a href="CrearEstacionClaveJSP.jsp">Crear Estacion Clave</a></pre>
        <br>
        <a href="ServeletVerEsClave">Ver Estaciones Clave</a>
        <br>
        <a href="LoginAdminsJSP.jsp">Regresar</a>
        
    </body>
</html>
