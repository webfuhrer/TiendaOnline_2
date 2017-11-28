/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetetienda;

import java.util.ArrayList;

/**
 *
 * @author luis
 */
public class CrearHTML {
 public static String pintarTablaProductos(ArrayList<Producto> lista)
 {
     String tabla="";
     tabla+="<table>";
     tabla+="<tr><th>Nombre</th><th>Imagen</th><th>Precio</th><th>Stock</th><th>Comprar</th></tr>";
     for(Producto p: lista)
     {
         String imagen=pintarImagen(p.getUrl());
         String enlace_comprar=generarEnlace(p.getNombre());
         String formulario_comprar=generarFormulario(p.getId());
         tabla+="<tr><td>"+p.getNombre()+"</td><td>"+imagen+"</td><td>"+p.getPrecio()+"</td><td>"+p.getStock()+"</td><td>"+formulario_comprar+"</td></tr>";
     }
     tabla+="</table>";
     return tabla;
 }

    private static String pintarImagen(String url) {
       String img="<img src='"+url+"' width=50px>"; 
       return img;
    }

    private static String generarEnlace(String nombre) {
      String aux="<a href='ServletAgenda?accion=comprar&producto="+nombre+"'>Comprar</a>";
      return aux;
    }

    private static String generarFormulario(int id) {
        String aux="<form action='ServletAgenda' method='POST'>";
        aux+="<input type='hidden' name='accion' value='comprar'>";
        aux+="<input type='hidden' name='producto' value='"+id+"'>";
        aux+="<input type='submit' value='Comprar'>";
        aux+="</form>";
        return aux;
    }
    
}
