/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author marce
 */
import java.util.List;
import java.sql.*;
import java.util.LinkedList;
import com.google.gson.*;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class LibroDAO implements Ilibro {
    
    private Connection con=BaseDeDatos.getConnection();

    @Override
    public boolean create(Libro libro) {
        try {
            String sql="insert into libro values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, libro.getId());
            ps.setString(2, libro.getImagen());
            ps.setInt(3, libro.getStock());
            ps.setString(4, libro.getNombre());
            ps.setString(5, libro.getAutor());
            ps.setString(6, libro.getEditorial());
            ps.setInt(7, libro.getPrecio());
            ps.setString(8, libro.getCat().getNombre());
            return ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        try {
            String sql="delete libro where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            return ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } 
    }

    @Override
    public boolean update(int id, int stock) {
        try {
            String sql="update libro set stock=? where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2,id);
            return ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }  
    }
    
    @Override
    public Libro readById(int id) {
        Libro p=null;
        
        try {
            
            String sql="select * from libro where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p=new Libro();
                p.setId(id);
                p.setImagen(rs.getString("imagen"));
                p.setNombre(rs.getString("nombre"));
                p.setAutor(rs.getString("autor"));
                p.setStock(rs.getInt("stock"));
                p.setEditorial(rs.getString("editorial"));
                p.setPrecio(rs.getInt("precio"));
                
                
                rs.close();
                return p;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
        return p;
    }

    @Override
    public ArrayList<Libro> readByAll() {
        
       Libro p=null;
       ArrayList<Libro> libro=new ArrayList<Libro>();
       
       try {

            CarroCompras c=null;
            Categoria ca=null;
            String sql="select * from libros";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ca=new Categoria();
                p=new Libro();
                c=new CarroCompras();
                p.setId(rs.getInt("id_libro"));
                p.setImagen(rs.getString("imagen"));
                p.setNombre(rs.getString("nombre"));
                p.setAutor(rs.getString("autor"));
                p.setStock(rs.getInt("stock"));
                p.setEditorial(rs.getString("editorial"));
                p.setPrecio(rs.getInt("precio"));
                c.setId(rs.getInt("carro_id_carro"));
                ca.setId(rs.getInt("categoria_id_categoria"));
                              
                libro.add(p);
            }
            rs.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
       
       return libro;
    }
    
    @Override
    public ArrayList<CarroCompras> readByAllCarro() {
        
        ArrayList<CarroCompras> carro=new ArrayList<CarroCompras>();
        CarroCompras p=null;
            
       try {
            
            String sql="select * from carro";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p=new CarroCompras();
                p.setId(rs.getInt("id_carro"));
                p.setFecha(rs.getString("fecha"));
                p.setTotalPagar(rs.getInt("total"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setLibros(readByAll());
                carro.add(p);
            }
            rs.close();
            
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
       
       return carro;
    }

    @Override
    public String libroToJson(Libro lib) {
        Gson g = new Gson();
        return g.toJson(lib);
    }

    @Override
    public String libroToJson(List<Libro> lib) {
        Gson g = new Gson();
        return g.toJson(lib);
    }
    
    
    
       
   }