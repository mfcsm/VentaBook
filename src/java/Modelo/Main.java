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
public class Main {

    /**
     * @param args the command line arguments
     * 
     * 
     */
    
    public static final ArrayList<Libro> listaLibro = new ArrayList<>();
    
    
    public static void main(String[] args) {
        
        Categoria cat = new Categoria(1,"Fantasia");
        
        Libro lib = new Libro(1,"Harry Potter 1", "Harry.jpg","Salamandra",20,19990,cat, "JKR");
        Libro lib2 = new Libro(2,"Harry Potter 2", "Harry2.jpg","Salamandra",30,39990,cat, "JKR");
        
        listaLibro.add(lib);
        listaLibro.add(lib2);
        
        
        
        // TODO code application logic here
    }
    
}
