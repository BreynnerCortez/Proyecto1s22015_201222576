package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Bean.BeanAdmin;
import estructuras.WSEstacionClave;
import estructuras.WSEstacionClaveService;
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
@WebServlet(urlPatterns = {"/ServeletCrearEsClave"})
public class ServeletCrearEsClave extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/192.168.1.130_8080/PruebaWeb/WSEstacionClave.wsdl")
    private WSEstacionClaveService service;
   


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         BeanAdmin datos=new BeanAdmin();
        datos.setIdEsClave(request.getParameter("id"));
        datos.setNombreEsClave(request.getParameter("nombre"));
        datos.setContraEsClave(request.getParameter("contrase"));
        request.setAttribute("datos", datos);
        
        String datosadm=request.getParameter("id")+","+request.getParameter("nombre")+","+request.getParameter("contrase");
        String d= imprimiresclave();
        String a=buscaresclave(datosadm);
        if(buscaresclave(datosadm)!=null){
            String id=buscaresclave(datosadm).split(",")[0];
              if(id.compareTo(request.getParameter("id"))==0){
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
            out.println("<h2>Usuario existente, intente con nuevos registros!</h2>");
            out.println(" <a href=\"CrearEstacionClaveJSP.jsp\">Regresar</a>");
            out.println("</body>");
            out.println("</html>");
        }
              }
        }
        else{
            ingresaresclave(datosadm+",0");
             request.getRequestDispatcher("CrearEstacionClaveJSP.jsp").forward(request, response);
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

    private String imprimiresclave() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        estructuras.WSEstacionClave port = service.getWSEstacionClavePort();
        return port.imprimiresclave();
    }

    private boolean ingresaresclave(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        estructuras.WSEstacionClave port = service.getWSEstacionClavePort();
        return port.ingresaresclave(arg0);
    }

   

}
