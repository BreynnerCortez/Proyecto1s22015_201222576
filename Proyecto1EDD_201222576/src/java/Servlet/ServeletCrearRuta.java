/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import estructuras.WSEstacionClaveService;
import estructuras.WSEstacionGeneralService;
import estructuras.WSRutaService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Breynner
 */
@WebServlet(name = "ServeletCrearRuta", urlPatterns = {"/ServeletCrearRuta"})
public class ServeletCrearRuta extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/192.168.1.130_8080/PruebaWeb/WSEstacionGeneral.wsdl")
    private WSEstacionGeneralService service_2;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/192.168.1.130_8080/PruebaWeb/WSEstacionClave.wsdl")
    private WSEstacionClaveService service_1;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/192.168.1.130_8080/PruebaWeb/WSRuta.wsdl")
    private WSRutaService service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String estaci=request.getParameter("estaciones");
         String estacinue="";
         String[]sep=estaci.split(",");
         for(int i=0;i<sep.length;i++){
             if(buscaresclave(sep[i])!=null || buscaresgeneral(sep[i])!=null){
             if(i==sep.length-1){
                 estacinue=estacinue+sep[i];
             }else{
             estacinue=estacinue+sep[i]+";";
             }
             }else{
                try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Bienvenido a MuniGT!</title>");  
            out.println("<style type=\"text/css\">\n" +
"        body{\n" +
"    background-image:url('https://upload.wikimedia.org/wikipedia/commons/d/d2/Bandera_Municipalidad_de_Guatemala.jpg');\n" +
"        }\n" +
"         </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>La estacion: \""+sep[i]+"\" no existe intente con nuevas estaciones!</h2>");
            out.println(" <a href=\"CrearRutaJSP.jsp\">Regresar</a>");
            out.println("</body>");
            out.println("</html>");
        }       
             }
         }
         
     String datosadm=request.getParameter("nombre")+","+estacinue;
    
        String d= imprimirruta();
        String a=buscarruta(datosadm);
        if(buscarruta(datosadm)!=null){
            String id=buscarruta(datosadm).split(",")[0];
              if(id.compareTo(request.getParameter("nombre"))==0){
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Bienvenido a MuniGT!</title>");  
            out.println("<style type=\"text/css\">\n" +
"        body{\n" +
"    background-image:url('https://upload.wikimedia.org/wikipedia/commons/d/d2/Bandera_Municipalidad_de_Guatemala.jpg');\n" +
"        }\n" +
"         </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Ruta existente, intente con un nuevo nombre!</h2>");
            out.println(" <a href=\"CrearRutaJSP.jsp\">Regresar</a>");
            out.println("</body>");
            out.println("</html>");
        }
              }
        }
        else{
            ingresarruta(datosadm);
             request.getRequestDispatcher("CrearRutaJSP.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String buscarruta(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        estructuras.WSRuta port = service.getWSRutaPort();
        return port.buscarruta(arg0);
    }

    private String imprimirruta() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        estructuras.WSRuta port = service.getWSRutaPort();
        return port.imprimirruta();
    }

    private boolean ingresarruta(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        estructuras.WSRuta port = service.getWSRutaPort();
        return port.ingresarruta(arg0);
    }

    private boolean limpiarruta() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        estructuras.WSRuta port = service.getWSRutaPort();
        return port.limpiarruta();
    }

    private String buscaresclave(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        estructuras.WSEstacionClave port = service_1.getWSEstacionClavePort();
        return port.buscaresclave(arg0);
    }

    private String buscaresgeneral(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        estructuras.WSEstacionGeneral port = service_2.getWSEstacionGeneralPort();
        return port.buscaresgeneral(arg0);
    }

    
}
