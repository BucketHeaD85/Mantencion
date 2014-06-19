/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author BucketHeaD
 */
public class Unidad {
    private String codigo,nombre,marca,fechaE,fechaV;
    private Connection cn;
    private Statement st;
    private ResultSet rs;

    public Unidad(String codigo, String nombre, String marca, String fechaE, String fechaV) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.fechaE = fechaE;
        this.fechaV = fechaV;
    }
    
    public boolean ingresar(String a,String b,String c,String d,String e) throws SQLException{
        String sql="insert into inventario values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"')";
        st = cn.createStatement();
        int gg = st.executeUpdate(sql);
        if(gg == 0){
            return false;
        }
        else{
            return true;
        }
    }
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getFechaE() {
        return fechaE;
    }

    public void setFechaE(String fechaE) {
        this.fechaE = fechaE;
    }

    public String getFechaV() {
        return fechaV;
    }

    public void setFechaV(String fechaV) {
        this.fechaV = fechaV;
    }
    
}
