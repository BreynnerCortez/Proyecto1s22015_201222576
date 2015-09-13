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
        <%
        String TempUsu= request.getParameter("usuario");
        String TempCont= request.getParameter("contrase");
        %>
        
        <h1><%="Bienvenido "+TempUsu+"\n Su contraseña es: "+TempCont %></h1>
        
    </body>
</html>
