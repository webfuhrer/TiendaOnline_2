<%-- 
    Document   : mostrarproductos
    Created on : 27-nov-2017, 12:23:27
    Author     : luis
--%>

<%@page import="paquetetienda.CrearHTML"%>
<%@page import="java.util.ArrayList"%>
<%@page import="paquetetienda.AccesoBD"%>
<%@page import="paquetetienda.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            ArrayList<Producto> lista_productos=(ArrayList<Producto>)request.getAttribute("lista_productos");
            String html_tabla=CrearHTML.pintarTablaProductos(lista_productos);
            %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Productos de la tienda:</h1>
        <%=html_tabla%>
    </body>
</html>
