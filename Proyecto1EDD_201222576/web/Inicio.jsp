<%-- 
    Document   : Inicio
    Created on : 11/09/2015, 05:57:06 PM
    Author     : Breynner
--%>


<%@page import="java.awt.Window"%>
<%@page import="com.sun.xml.rpc.processor.modeler.j2ee.xml.resAuthType"%>
<%@page  contentType="text/html" pageEncoding="UTF-8"%>
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
        <h1> Bienvenido a la MUNICIPALIDAD DE GUATEMALA. </h1> </div>
       <form action="LoginAdminsJSP.jsp" method="POST">
           <div style="text-align: right;">
               <input type="submit" value="Iniciar sesion ADMINISTRADOR" name="InicioAd"/></div>
       </form>
        <br>  
        <form action="LoginEstacionJSP.jsp" method="POST">
           <div style="text-align: right;">
               <input type="submit" value="Iniciar sesion ESTACION" name="InicioEs"/></div>
       </form>
        <br> 
        <form action="LoginChoferJSP.jsp" method="POST">
           <div style="text-align: right;">
               <input type="submit" value="Iniciar sesion CHOFER" name="InicioCh"/></div>
       </form>
        <div style="text-align: center;">
        <br> 
        <H3><B><%= "Preguntas Frecuentes de nuestroestro sistema:<br> "
                + "Estimados usuarios, valoramos mucho sus comentarios. <br>"
                + "Cuando recibimos este tipo de mensajes sabemos que muchas<br>"
                + "personas se están dando cuenta de la lógica del sistema y<br> "
                + "comienzan a apreciar los beneficios que éste le da a la<br> "
                + "sociedad, además ayuda al equipo para seguir adelante tratando<br> "
                + "de cambiar la forma de movilizarnos y la manera de pensar en<br> "
                + "la ciudad. Sin dudas nos servirá para recordar lo importante<br> "
                + "que es luchar hasta tener un servicio ejemplar, que vale la<br>  "
                + "pena el esfuerzo que ellos hacen de día y de noche.<br> "  %></B></H3></div>
        <HR width="80%"> 
        <div style="text-align: right;">
            <img src="inicio.jpg" width="468" height="628" alt="inicio"/>
        </div>
        <div style="text-align: left;">
            <img src="iniciodos.jpg" width="411" height="477" alt="iniciodos"/>
        </div>
        
        
        
        
  
    </body>
</html>
