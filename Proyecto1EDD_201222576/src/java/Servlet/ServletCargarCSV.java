/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import estructuras.WSBusesService;
import estructuras.WSChoferService;
import estructuras.WSRutaService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Breynner
 */
@WebServlet(name = "ServletCargarCSV", urlPatterns = {"/ServletCargarCSV"})
public class ServletCargarCSV extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/192.168.1.130_8080/PruebaWeb/WSChofer.wsdl")
    private WSChoferService service_2;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/192.168.1.130_8080/PruebaWeb/WSBuses.wsdl")
    private WSBusesService service_1;
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
        String path=request.getParameter("archivo");
        String cadena;
        FileReader f = new FileReader(path);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            String [] datos=cadena.split(",");
            //para bus
            if(buscarbus(datos[0])==null){
                ingresarbus(datos[0]);
            }
            if(buscarchofer(datos[2]+",arg")==null){
                ingresarchofer(datos[2]+",chofer,Chofer,ApeChofer");
            }
           if(apuntarnodochofer(buscarchofer(datos[2]+",arg"))){
               if(agregardianodochofer(buscarchofer(datos[2]+",arg"), datos[5])){
                   if(agregarbusadiachofer(datos[2]+",arg", datos[5], datos[0])){
                       agregarhoraAbusydiachofer(datos[2]+",arg", datos[5], datos[0], datos[3]);
                       agregarhoraAbusydiachofer(datos[2]+",arg", datos[5], datos[0], datos[4]);
                   }
               }
           }
        }
        b.close();
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

    private boolean ingresarruta(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        estructuras.WSRuta port = service.getWSRutaPort();
        return port.ingresarruta(arg0);
    }

    private String buscarbus(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        estructuras.WSBuses port = service_1.getWSBusesPort();
        return port.buscarbus(arg0);
    }

    private boolean ingresarbus(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        estructuras.WSBuses port = service_1.getWSBusesPort();
        return port.ingresarbus(arg0);
    }

    private String buscarchofer(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        estructuras.WSChofer port = service_2.getWSChoferPort();
        return port.buscarchofer(arg0);
    }

    private boolean ingresarchofer(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        estructuras.WSChofer port = service_2.getWSChoferPort();
        return port.ingresarchofer(arg0);
    }

    private Boolean apuntarnodochofer(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        estructuras.WSChofer port = service_2.getWSChoferPort();
        return port.apuntarnodochofer(arg0);
    }

    private Boolean agregardianodochofer(java.lang.String arg0, java.lang.String arg1) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        estructuras.WSChofer port = service_2.getWSChoferPort();
        return port.agregardianodochofer(arg0, arg1);
    }


    private Boolean agregarhoraAbusydiachofer(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        estructuras.WSChofer port = service_2.getWSChoferPort();
        return port.agregarhoraAbusydiachofer(arg0, arg1, arg2, arg3);
    }

    private Boolean agregarbusadiachofer(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        estructuras.WSChofer port = service_2.getWSChoferPort();
        return port.agregarbusadiachofer(arg0, arg1, arg2);
    }

}
