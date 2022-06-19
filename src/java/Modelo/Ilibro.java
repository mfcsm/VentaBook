/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.util.List;

/**
 *
 * @author carlo
 */
public interface Ilibro {

    boolean create(Libro libro); //Insert
    boolean delete(int id); //Delete
    boolean update(int id, int stock);//Update
    Libro readById(int id); //Select
    List<Libro> readByAll(); //Select
    List<CarroCompras> readByAllCarro();
    String libroToJson(Libro lib);
    String libroToJson(List<Libro> lib);



}