<%-- 
    Document   : AdministradorJSP
    Created on : 13/09/2015, 12:12:14 PM
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
        <h1>Bienvenido Estacion!</h1></div>
        <form action="EstacionJSP.jsp" method="POST">
            <div style="text-align: right;">
                   <%="Usuario"%>
              <input type="text" name="usuario"  value="" />
                   <%="Contraseña"%>
            <input type="Password" name="contrase"   value="" />
            <input type="submit" value="Ingresar" name="Ingreso"  />
            </div>
        </form>
            <HR>
            <div style="text-align: right;">
            <img src="estaciones.jpg" width="630" height="1430" alt="estaciones"/></div>

    <%-- start web service invocation --%><hr/>
    <%
    try {
	esfera.Prueba_Service service = new esfera.Prueba_Service();
	esfera.Prueba port = service.getPruebaPort();
	// TODO process result here
	java.lang.String result = port.imp();
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
