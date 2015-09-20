<%-- 
    Document   : AdministradorJSP
    Created on : 13/09/2015, 12:12:14 PM
    Author     : Breynner
--%>
<%@page import="javax.swing.text.Document"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MuniGuate!</title>
          <style type="text/css" >
        body{
            
            background-image:url('https://upload.wikimedia.org/wikipedia/commons/d/d2/Bandera_Municipalidad_de_Guatemala.jpg');
        }
        </style>
    </head>
    <body>
        <div style="text-align: center;" >
        <h1>Bienvenido Estacion!</h1></div>
        <form action="ServletVerificarEstacion" method="POST">
             <h3><div style="text-align: right;">
               Seleccione tipo de Estacion:
                <select name="Estaciones" size="2">
                    <option value="1">Clave</option>
                    <option value="2">General</option>
                </select>
                   ID Numerico:
            <input type="number" name="id"  value="" />
                   Contraseña:
            <input type="Password" name="contrase"   value="" />
            <input type="submit" value="Ingresar" name="Ingreso" />
            </div></h3>
        </form>
            <HR>
            <a href="Inicio.jsp">Regresar a Pagina Principal</a>
            <div style="text-align: right;">
            <img src="estaciones.jpg" width="630" height="1430" alt="estaciones"/></div>
    </body>
</html>