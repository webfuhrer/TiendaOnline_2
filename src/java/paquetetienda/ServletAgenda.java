package paquetetienda;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luis
 */
@WebServlet(urlPatterns = {"/ServletAgenda"})
public class ServletAgenda extends HttpServlet {

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
        String accion=request.getParameter("accion");
        if(accion.equals("grabar"))
        {
            String nombre=request.getParameter("nombre_producto");
            String precio=request.getParameter("precio_producto");
            String imagen=request.getParameter("url_producto");
            Producto p=new Producto(nombre, imagen, Float.parseFloat(precio), 10);
            AccesoBD.insertarProducto(p);
        }
        if(accion.equals("listar"))
        {
           ArrayList<Producto> lista_productos=AccesoBD.recuperarProductos();
           request.setAttribute("lista_productos", lista_productos);
           request.getRequestDispatcher("mostrarproductos.jsp").forward(request, response);
        }
        if (accion.equals("comprar"))
        {
            String producto=request.getParameter("producto");
            AccesoBD.actualizarStock(producto);
             ArrayList<Producto> lista_productos=AccesoBD.recuperarProductos();
           request.setAttribute("lista_productos", lista_productos);
           request.getRequestDispatcher("mostrarproductos.jsp").forward(request, response);
            
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

}
