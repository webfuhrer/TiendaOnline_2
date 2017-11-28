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
    private int stock;
    private int id;

    public Producto(String nombre, String url, float precio, int stock, int id) {
        this.nombre = nombre;
        this.url = url;
        this.precio = precio;
        this.stock = stock;
        this.id = id;
    }

    public Producto(String nombre, String url, float precio, int stock) {
        this.nombre = nombre;
        this.url = url;
        this.precio = precio;
        this.stock = stock;
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

    public int getStock() {
        return stock;
    }

    public int getId() {
        return id;
    }
  
    
}
