/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

/**
 *
 * @author marce
 */
public class Libro {
    
    private String nombre;
    private String autor;
    private String editorial;
    private int paginas;
    private int precio;

    public Libro() {
        this.nombre = "";
        this.autor = "";
        this.editorial = "";
        this.paginas = 0;
        this.precio = 0;
    }
    
    public Libro(String nombre, String autor, String editorial, int paginas, int precio){
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.paginas = paginas;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    
}
