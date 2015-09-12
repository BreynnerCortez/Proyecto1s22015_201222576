<%-- 
    Document   : Inicio
    Created on : 11/09/2015, 05:57:06 PM
    Author     : Breynner
--%>

<%@page import="jdk.nashorn.internal.runtime.Debug.id(Object)"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MuniGuate</title>
        <style type="text/css" >
        body{
            
            background-image:url('https://upload.wikimedia.org/wikipedia/commons/d/d2/Bandera_Municipalidad_de_Guatemala.jpg');
        }
        </style>
    </head>
    <body>
        <div style="text-align: center;">
        <h1> Bienvenido a la MUNICIPALIDAD DE GUATEMALA. </h1> </div>
       <form action="Inicio.jsp" method="POST">
           <div style="text-align: right;">
               <input type="text" name="usuario" height="50" style="visibility:hidden" value="" />
            <input type="Password" name="contrase" height="50" style="visibility:hidden" value="" />
            <input type="submit" value="Ingresar" name="Ingreso" style="visibility:hidden" />
            <input type="submit" value="Iniciar Sesion" name="Inicio" />
            </div>
       </form>
        "Ingresar".style.visibility='visible'; 
        
               <%-- start web service invocation --%><hr/>
    <%
       
        String usuario;
        String contrase;
        
    try {
	//document.getElementsByName("p2").style.visibility="hidden";
        esfera.VolumenEsfera_Service service = new esfera.VolumenEsfera_Service();
	esfera.VolumenEsfera port = service.getVolumenEsferaPort();
	 // TODO initialize WS operation arguments here
	//double radio = Double.valueOf(request.getParameter("cajaUno"));
        
        usuario= request.getParameter("usuario");
        //double radiod = Double.valueOf(request.getParameter("cajaDos"));
        
        contrase= request.getParameter("contrase");
	// TODO process result here
       // Double result= port.volumen(radio,radiod);
	//out.println("Result = "+result);
         
        if(usuario.compareTo("admin")==0 && contrase.compareToIgnoreCase("admin")==0){
            
            response.sendRedirect("Logeado.jsp?usuario="+usuario+"&contrase="+contrase); 
        }else{
            out.println("Disculpe usuario: "+usuario+" sus datos son incorrectos, intente de nuevo");
        }
    } catch (Exception ex) {
	
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
