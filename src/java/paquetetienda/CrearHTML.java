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
     tabla+="<tr><th>Nombre</th><th>Imagen</th><th>Precio</th></tr>";
     for(Producto p: lista)
     {
         String imagen=pintarImagen(p.getUrl());
         tabla+="<tr><td>"+p.getNombre()+"</td><td>"+imagen+"</td><td>"+p.getPrecio()+"</td></tr>";
     }
     tabla+="</table>";
     return tabla;
 }

    private static String pintarImagen(String url) {
       String img="<img src='"+url+"' width=50px>"; 
       return img;
    }
}
