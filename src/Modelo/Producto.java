/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BucketHeaD
 */
public class Producto {
    
    private String nombre,marca,proveedor;
    private int precio;
    private Connection cn;
    private Statement st;
    private ResultSet rs;
    
    public Producto(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productos?zeroDateTimeBehavior=convertToNull", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Producto(String nombre, String marca, String proveedor, int precio) {
        this.nombre = nombre;
        this.marca = marca;
        this.proveedor = proveedor;
        this.precio = precio;
    }
    
    public boolean agregarNuevo(String a,String b,String c,int d) throws SQLException{
      
            String sql = "insert into productos values ('"+a+"','"+b+"','"+c+"',"+d+")";
            st=cn.createStatement();
            int gg = st.executeUpdate(sql);
            if(gg==0){
                return false;
            }
            else{
                return true;
            }
        
    }
    
    public boolean agregarInventario(String a,String b,String c,String d,String e) throws SQLException{
        String sql = "insert into table inventario values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"')";
        st = cn.createStatement();
        int gg = st.executeUpdate(sql);
        if(gg==0){
            return false;
        }
        else{
            return true;
        }
    }
    
     public boolean modificar(String a, String b,String c) throws SQLException{
        String sql = "update table productos set "+a+"='"+b+"' where ID ='"+c+"'";
        st = cn.createStatement();
        int gg = st.executeUpdate(sql);
       if(gg==0){
           return false;
       }
       else{
           return true;
       }
        
    }
    public boolean modificar(String a, int b,String c) throws SQLException{
        String sql = "update table productos set "+a+"="+b+" where ID ='"+c+"'";
        st = cn.createStatement();
        int gg = st.executeUpdate(sql);
       if(gg==0){
           return false;
       }
       else{
           return true;
       }
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
}
