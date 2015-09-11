<%-- 
    Document   : Inicio
    Created on : 11/09/2015, 05:57:06 PM
    Author     : Breynner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido a la MUNICIPALIDAD DE GUATEMALA.</title>
    </head>
    <body>
        <h1> Volumen de una Esfera</h1>
       <form action="Inicio.jsp" method="POST">
            <input type="text" name="cajaRadio" value="" />
            <input type="submit" value="Calcular" />
       </form>
           <%-- start web service invocation --%><hr/>
    <%
    try {
	esfera.VolumenEsfera_Service service = new esfera.VolumenEsfera_Service();
	esfera.VolumenEsfera port = service.getVolumenEsferaPort();
	 // TODO initialize WS operation arguments here
	double radio = Double.valueOf(request.getParameter("cajaRadio"));
        java.lang.Double result = port.volumen(radio);
        if(radio<=0){
            out.println("El radio no puede ser:"+radio);
        }
	// TODO process result here
        else
	out.println("El volumen de la esfera es = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
