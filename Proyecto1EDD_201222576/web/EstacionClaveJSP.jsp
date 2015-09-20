<%-- 
    Document   : EstacionClaveJSP
    Created on : 19/09/2015, 10:21:34 PM
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
        <h1>Bienvenido Estacion: <jsp:getProperty name="datos" property="nombreEsClave" />! </h1>
        <form  method="POST" action="ServeletVerEsClave">
            <input type="submit" value="Ver Mi estacion" name="VerAdmins" />
        </form><br>
        <a href="LoginEstacionJSP.jsp">Regresar</a>
         <HR>
            <div style="text-align: right;">
            <img src="estaciones.jpg" width="630" height="1430" alt="estaciones"/></div>
    </body>
</html>
