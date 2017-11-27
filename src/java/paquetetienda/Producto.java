/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetetienda;

/**
 *
 * @author luis
 */
public class Producto {
    private String nombre, url;
    private float precio;

    public Producto(String nombre, String url, float precio) {
        this.nombre = nombre;
        this.url = url;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrl() {
        return url;
    }

    public float getPrecio() {
        return precio;
    }
    
}
