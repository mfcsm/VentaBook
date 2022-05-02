/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ventabook;

/**
 *
 * @author Marcelo Cubillos
 */
public class VentaBook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    private String libro;

    public VentaBook() {
        this.libro = "";  
    }
    
    public VentaBook(String libro) {
        this.libro = libro;  
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }
    
    
}
