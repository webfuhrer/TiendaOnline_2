/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetetienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class AccesoBD {
    public static ArrayList<Producto> recuperarProductos() {
        ArrayList<Producto> lista=new ArrayList<>();
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "");
            Statement stmt=c.createStatement();
            String sql="SELECT * FROM productos ";
            ResultSet resultados=stmt.executeQuery(sql);
            while(resultados.next())
            {
                String nombre=resultados.getString("nombre");
                float precio=resultados.getFloat("precio");
                String url=resultados.getString("url");
                int stock=resultados.getInt("stock");
                int id=resultados.getInt("id");
                Producto p=new Producto(nombre, url, precio, stock, id);
                lista.add(p);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    static void insertarProducto(Producto p) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "");
            Statement stmt=conexion.createStatement();
            String sql_insercion="INSERT INTO productos (nombre,precio, url, stock) VALUES ('"+p.getNombre()+"', '"+p.getPrecio()+"', '"+p.getUrl()+"','"+p.getStock()+"');";
            stmt.executeUpdate(sql_insercion);
            stmt.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void actualizarStock(String producto) {
      try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "");
            Statement stmt=conexion.createStatement();
            String sql_insercion="UPDATE productos SET stock=stock-1 WHERE id='"+producto+"';";
            stmt.executeUpdate(sql_insercion);
            stmt.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
