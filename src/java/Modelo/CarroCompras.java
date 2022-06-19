/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author marce
 */
public class CarroCompras {
    private int id;
    private String fecha;
    private ArrayList libros;
    private float totalPagar;
    private int cantidad;

    public CarroCompras() {
    }

    public CarroCompras(int id, String fecha, ArrayList libros, float totalPagar, int cantidad) {
        this.id = id;
        this.fecha = fecha;
        this.libros = libros;
        this.totalPagar = totalPagar;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList getLibros() {
        return libros;
    }

    public void setLibros(ArrayList libros) {
        this.libros = libros;
    }

    public float getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(float totalPagar) {
        this.totalPagar = totalPagar;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
    
    
    
}
