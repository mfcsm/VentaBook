package API_REST;


import Modelo.Ilibro;
import Modelo.LibroDAO;
import Modelo.CarroCompras;
import Modelo.Categoria;
import Modelo.Libro;
import Modelo.Main;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * REST Web Service
 *
 * @author Alumno
 */
@Path("api")
public class GenericResource {

    @Context
    private UriInfo context;
    Categoria cat = new Categoria(1,"Fantasia");
    
    LibroDAO lib1 = new LibroDAO();

    
    
    Libro lib = new Libro(1,"Harry Potter 1", "Harry.jpg","Salamandra",20,19990,cat, "JKR");
    Libro lib2 = new Libro(2,"Harry Potter 2", "Harry2.jpg","Salamandra",30,39990,cat, "JKR");
    
    ArrayList<CarroCompras> carrito = new ArrayList<CarroCompras>();
    
    ArrayList<CarroCompras> list = null;
    
    
    
    
   
    
    
    ArrayList<Libro> lista = new ArrayList<Libro>();
    
    
    String resp;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
       
       
        
    }
    
    public static JSONArray peticionHttpGet(String urlParaVisitar) throws Exception {
        // Esto es lo que vamos a devolver
        JSONArray resultado = new JSONArray();
        // Crear un objeto de tipo URL
        URL url = new URL(urlParaVisitar);

        // Abrir la conexión e indicar que será de tipo GET
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        // Búferes para leer
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
        while ((linea = rd.readLine()) != null) {
            
        }
        // Cerrar el BufferedReader
        rd.close();
        
        resultado.add(conexion.getInputStream());
        
        
        
        
        // Regresar resultado, pero como cadena, no como StringBuilder
        return resultado;
    }
    /**
     * Retrieves representation of an instance of API_REST.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("listar")
    @Produces("application/json")
    public ArrayList<Libro> getLibrosJson() {
        //TODO return proper representation object
        
        lista = (ArrayList<Libro>) lib1.readByAll();
        
        
        return lista;

    }
    
    @GET
    @Path("listarCarro")
    @Produces("application/json")
    public ArrayList<CarroCompras> getCarroJson() {
        //TODO return proper representation object
        
        carrito = lib1.readByAllCarro();
        
        
        return carrito;

    }
    
    @POST
    @Path("guardar")
    @Produces("application/json")
    @Consumes("application/json")
    public ArrayList<Libro> guardar(Libro lib){
        
        lista.add(lib);

        return lista;
        
    }
    
    @POST
    @Path("buscar/{id}")
    @Produces("application/json")
    public Libro buscar(@PathParam("id") String id){
        
        Libro lib = new Libro();
        
        for(Libro l: lista){
            if(l.getId() == Integer.parseInt(id)){
                lib.setId(l.getId());
                lib.setNombre(l.getNombre());
                lib.setImagen(l.getImagen());
                lib.setPrecio(l.getPrecio());
                lib.setStock(l.getStock());
                lib.setEditorial(l.getEditorial());
                lib.setCat(l.getCat());
            }
        }
        
        return lib;
        
    }
    

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Path("actualizar/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    
    public ArrayList putJsonActualizar(Libro lib) {
        
        for(Libro l: lista){
            
            if(l.getId() == lib.getId()){
               
               l.setNombre(lib.getNombre());
               l.setPrecio(lib.getPrecio());
               l.setStock(lib.getStock());
               l.setEditorial(lib.getEditorial());
               l.setImagen(lib.getImagen());

            }
            
        }
        
        return lista;

    }
    
    @DELETE
    @Path("borrar/{id}")
    @Produces("application/json")
    
    public ArrayList deleteLibro(@PathParam("id") String id) {
        
        for(Libro l: lista){
            
            if(l.getId() == Integer.parseInt(id)){
               
               lista.remove(l);
               
            }
            
        }
        
        return lista;

    }
    
    @GET
    @Path("Api")
    @Produces("application/json")
    public JSONArray getJson() {

        String url = "http://127.0.0.1:8000/api/listarLibro?format=json";
        String respuesta = "";
        JSONArray array = new JSONArray();
        try {
            array = peticionHttpGet(url);
            System.out.println("Datos Recibidos con exito:\n");
        } catch (Exception e) {
            // Manejar excepción
            e.printStackTrace();
        }
        
        
        
        list = (ArrayList<CarroCompras>) lib1.readByAllCarro();
        
        
        
        System.out.println("resultado:"+ list);
        //String str1 = respuesta.replace("[", "");
        //String str2 = str1.replace("]", "");
        

        
        //ArrayList<String> str = new ArrayList<String>(Arrays.asList(str2));
        
        
       //String strFinal = str.get(0);
       
       //ArrayList<String> str10 = new ArrayList<String>(Arrays.asList(strFinal));
       
       //ArrayList r = new ArrayList();
       
       //r = str10;
        
        //System.out.println("Res"+r.get(0));
        
        
        
        
        
        //Libro lib = new Libro();
        
        
        
        
        // Regresar resultado, pero como cadena, no como StringBuilder
        return array;
        
        
        
        

    }
    
    @POST
    @Path("CarroCompras")
    @Produces("application/json")
    @Consumes("application/json")
    public ArrayList<CarroCompras> listarCarro(Libro lib){
        
        lista.add(lib);
        int totalPagar = 0;
        int cantidad = lista.size();
        
        for(Libro l : lista){
            
            totalPagar = totalPagar + l.getPrecio();
            
        }
        
        CarroCompras car = new CarroCompras(1,"24/05/2022",lista,totalPagar,cantidad);
        
        carrito.add(car);
        
        return carrito;
    }
}