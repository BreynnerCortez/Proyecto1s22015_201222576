<%-- 
    Document   : ChoferJSP
    Created on : 13/09/2015, 05:38:35 PM
    Author     : Breynner
--%>

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
        <h1>Bienvenido Chofer!</h1></div>
         <form action="ChoferJSP.jsp" method="POST">
             <div style="text-align: right;">
                 <%="Usuario"%>
            <input type="text" name="usuario"  value="" />
                 <%="Contraseña"%>
            <input type="Password" name="contrase"   value="" />
            <input type="submit" value="Ingresar" name="Ingreso"  />
             </div>
        </form>
    </body>
</html>
