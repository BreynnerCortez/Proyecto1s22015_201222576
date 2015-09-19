/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.BeanAdmin;
import esfera.Buscar;
import esfera.Prueba;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
@WebServlet(name = "ServeletCrearAdmin", urlPatterns = {"/ServeletCrearAdmin"})
public class ServletCrearAdmin extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/192.168.1.130_8080/PruebaWeb/WSAdmin.wsdl")
    private Prueba service;

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
        BeanAdmin datos=new BeanAdmin();
        datos.setCorreo(request.getParameter("correo"));
        datos.setContrase(request.getParameter("contrase"));
        request.setAttribute("datos", datos);
        
        String datosadm=request.getParameter("correo")+","+request.getParameter("contrase");
        String d= imprimir();
        String a=buscar(datosadm);
        if(request.getParameter("correo").compareTo("admin")==0 && request.getParameter("contrase").compareTo("admin")==0){
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
            out.println(" <a href=\"CrearAdminJSP.jsp\">Regresar</a>");
            out.println("</body>");
            out.println("</html>");
        }
        
        }else if(buscar(datosadm)!=null && buscar(datosadm).compareTo(request.getParameter("correo"))==0){
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
            out.println(" <a href=\"CrearAdminJSP.jsp\">Regresar</a>");
            out.println("</body>");
            out.println("</html>");
        }
        }
        else{
            ingresar(datosadm);
             request.getRequestDispatcher("CrearAdminJSP.jsp").forward(request, response);
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

    private boolean ingresar(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        esfera.WSAdmin port = service.getWSAdminPort();
        return port.ingresar(arg0);
    }

    private String buscar(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        esfera.WSAdmin port = service.getWSAdminPort();
        return port.buscar(arg0);
    }

    private String imprimir() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        esfera.WSAdmin port = service.getWSAdminPort();
        return port.imprimir();
    }

 


  
}
