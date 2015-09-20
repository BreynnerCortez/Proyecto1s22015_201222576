/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.BeanAdmin;
import estructuras.WSEstacionClaveService;
import estructuras.WSEstacionGeneralService;
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
@WebServlet(name = "ServletVerificarEstacion", urlPatterns = {"/ServletVerificarEstacion"})
public class ServletVerificarEstacion extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/192.168.1.130_8080/PruebaWeb/WSEstacionGeneral.wsdl")
    private WSEstacionGeneralService service_1;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/192.168.1.130_8080/PruebaWeb/WSEstacionClave.wsdl")
    private WSEstacionClaveService service;

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
      String tipo=request.getParameter("Estaciones");
      if(tipo==null){
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
            out.println("<h2>Porfavor selecciones un tipo de Estacion para ingresar.</h2>");
            out.println(" <a href=\"LoginEstacionJSP.jsp\">Regresar</a>");
            out.println("</body>");
            out.println("</html>");
        }
      }



//VERIFICACION ESTACION CLAVE
      else if(tipo.compareTo("1")==0){
          BeanAdmin datos=new BeanAdmin();
        datos.setNombreEsClave(request.getParameter("id"));
        datos.setContraEsClave(request.getParameter("contrase"));
        
         String datosadm=request.getParameter("id")+","+request.getParameter("contrase");
        if(buscaresclave(datosadm)!=null){
           String co=buscaresclave(datosadm).split(",")[0];
           String con=buscaresclave(datosadm).split(",")[1];
           String nombre=buscaresclave(datosadm).split(",")[2];
          if(co.compareTo(request.getParameter("id"))==0 && con.compareTo(request.getParameter("contrase"))==0){
              datos.setNombreEsGeneral(nombre);
              request.setAttribute("datos", datos);
              request.getRequestDispatcher("EstacionClaveJSP.jsp").forward(request, response);
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
            out.println("<h2>Contraseña INCORRECTA, intente nuevamente!</h2>");
            out.println(" <a href=\"LoginEstacionJSP.jsp\">Regresar</a>");
            out.println("</body>");
            out.println("</html>");
        }
            
        }
          
            
        }
        else{
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
            out.println("<h2>Datos INCORRECTOS, intente nuevamente!</h2>");
            out.println(" <a href=\"LoginAdminsJSP.jsp\">Regresar</a>");
            out.println("</body>");
            out.println("</html>");
        }
            
        } 
      }



    //VERIFICACION ESTACION GENERAL
      else if(tipo.compareTo("2")==0){
          BeanAdmin datos=new BeanAdmin();
        datos.setIdEsGeneral(request.getParameter("id"));
        datos.setContraEsGeneral(request.getParameter("contrase"));
        
         String datosadm=request.getParameter("id")+","+request.getParameter("contrase");
        if(buscaresgeneral(datosadm)!=null){
           String co=buscaresgeneral(datosadm).split(",")[0];
           String con=buscaresgeneral(datosadm).split(",")[1];
           String nombre=buscaresgeneral(datosadm).split(",")[2];
          if(co.compareTo(request.getParameter("id"))==0 && con.compareTo(request.getParameter("contrase"))==0){
              datos.setNombreEsGeneral(nombre);
              request.setAttribute("datos", datos);
              request.getRequestDispatcher("EstacionGeneralJSP.jsp").forward(request, response);
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
            out.println("<h2>Contraseña INCORRECTA, intente nuevamente!</h2>");
            out.println(" <a href=\"LoginEstacionJSP.jsp\">Regresar</a>");
            out.println("</body>");
            out.println("</html>");
        }
            
        }
          
            
        }
        else{
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
            out.println("<h2>Datos INCORRECTOS, intente nuevamente!</h2>");
            out.println(" <a href=\"LoginAdminsJSP.jsp\">Regresar</a>");
            out.println("</body>");
            out.println("</html>");
        }
            
        } 
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

    private String buscaresclave(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        estructuras.WSEstacionClave port = service.getWSEstacionClavePort();
        return port.buscaresclave(arg0);
    }

    private String buscaresgeneral(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        estructuras.WSEstacionGeneral port = service_1.getWSEstacionGeneralPort();
        return port.buscaresgeneral(arg0);
    }

}
