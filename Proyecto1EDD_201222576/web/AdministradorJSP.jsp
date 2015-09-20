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
        <h1>Bienvenido Administrador: <jsp:getProperty name="datos" property="correoAdmin" />! </h1>
        <form  method="POST" action="ServletVerAdmins">
            <input type="submit" value="Ver Administradores" name="VerAdmins" />
        </form><br>
<h2><pre><a href="CrearAdminJSP.jsp">Crear Administrador</a>     <a href="CrearEstacionClaveJSP.jsp">Crear Estacion Clave</a>     <a href="CrearChoferJSP.jsp">Crear Chofer</a>     <a href="CrearEstacionGeneralJSP.jsp">Crear Estacion General</a>     <a href="CrearBusJSP.jsp">Crear Bus</a>     <a href="CrearRutaJSP.jsp">Crear Ruta</a></pre></h2>
        <br>
        <h2><pre><a href="ServeletVerEsClave">Ver Estaciones Clave</a>     <a href="ServeletVerEsGeneral">Ver Estaciones Generales</a>     <a href="ServeletVerChofer">Ver Choferes</a>     <a href="ServeletVerBuses">Ver Buses</a>     <a href="ServeletVerRutas">Ver Rutas</a></pre></h2>
        <br>
        <a href="LoginAdminsJSP.jsp">Regresar</a>
        
    </body>
</html>
