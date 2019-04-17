/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.logica;

import co.edu.usbbog.datan.niote.modelo.Nodo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class GestionNodos {

    private List<Nodo> nodos;
    

    public GestionNodos(List<Nodo> nodos) {
        this.nodos = nodos;
    }

    public GestionNodos() {
        this.nodos = new ArrayList<>();
    }

    public List<Nodo> getNodos() {
        return nodos;
    }

    public void setNodos(List<Nodo> nodos) {
        this.nodos = nodos;
    }

      
   
    
    /*
    public void agregarNodo(String id, String descripcion, boolean estado, String protocoloComunicacion, String gatewayId) {

        List<PuertaDeEnlace> puertasDeEnlaceDeLaRed = red.getPuertasDeEnlace();

        for (PuertaDeEnlace i : puertasDeEnlaceDeLaRed) {
            if (i.getId().equals(gatewayId)) {
                red.getPuertasDeEnlace().remove(i);
                List<Nodo> nodos = new ArrayList<Nodo>();
                Nodo nodo = new Nodo(id, descripcion, estado, protocoloComunicacion);
                nodos.add(nodo);
                i.setNodos(nodos);
                red.getPuertasDeEnlace().add(i);

            }

        }

    }
    private Nodo nodo;
    
        public GestionNodo(String id, String descripcion, boolean estado, String protocoloComunicacion){

            this.nodo= new Nodo(id,  descripcion, estado, protocoloComunicacion);
            this.nodo.setActuadores(new ArrayList<Actuador>());
            this.nodo.setSensores(new ArrayList<Sensor>());
            this.nodo.setSalidas(new ArrayList<PuertaDeEnlace>());
    
    }
    
        
    //Metodo para agregar Actuadores al Nodo
    public void agregarActuador(String id, String descripcion, boolean estado, String tipo){
    
        Actuador actuador = new Actuador(id,descripcion,estado,tipo);
        List<Actuador> actuadoresDelNodo = nodo.getActuadores();
        actuadoresDelNodo.add(actuador);
        nodo.setActuadores(actuadoresDelNodo);
            
    }
    
    //Metodo´para ver actuadores del nodo
    public void verActuador(){
        
        List<Actuador>  actuadoresDelNodo = nodo.getActuadores();
        
        for(Actuador i:actuadoresDelNodo){
            System.out.println(i);
        }
        
    }
    
    //Metodo para agregar Sensores al Nodo
    
    public void agregarSensor(String id, String descripcion, boolean estado, String tipo){
        
        Sensor sensor = new Sensor( id, descripcion, estado, tipo);
        List<Sensor> sensoresDelNodo = nodo.getSensores();
        sensoresDelNodo.add(sensor);
        nodo.setSensores(sensoresDelNodo);
        
    }
    
    //Metodo para ver Sensores del Nodo
    public void verSensor(){
        
        List<Sensor> sensoresDelNodo = nodo.getSensores();
        
        for(Sensor i:sensoresDelNodo){
            System.out.println(i);
        }
    }
    
    //Metodo para agregar Puertas de enlace al nodo
        public void agregarPuertasDeEnlace(String id, String descripcion, boolean estado, String direccionLogica, String puertoDeServicio, String protocoloComunicacionExterno){
        PuertaDeEnlace puertaDeEnlace = new PuertaDeEnlace(id, descripcion, estado, direccionLogica, puertoDeServicio, protocoloComunicacionExterno);
        List<PuertaDeEnlace> puertasDeEnlaceDeLaRed = nodo.getSalidas();
        puertasDeEnlaceDeLaRed.add(puertaDeEnlace);
        nodo.setSalidas(puertasDeEnlaceDeLaRed);
    }
        
    //Metodo para ver Puertas de enlace del nodo
        
    public void verPuertasDeEnlace(String id){
        
        List<PuertaDeEnlace> puertasDeEnlaceDeLaRed = nodo.getSalidas();
        
        
        for(PuertaDeEnlace i:puertasDeEnlaceDeLaRed){
         
            
            System.out.println(i);
        }
    }

     */
    public String verNodos() {
        
        String salida = "";
            for (Nodo nodo : nodos) {
                salida += salida + nodo.toString() + "\n";
            }
        return salida;
    }

    public String verNodoPorID(String id) {
           
        String salida="";
        
        if (existeNodoPorID(id)) {
            for (Nodo nodo : nodos) {
              if(nodo.getId().equals(id)){
               salida = nodo.toString() + "\n";   
              }
            }
       } else {
            
            salida = "El nodo con ID " + id + " no existe";
        }
        
        return salida;
    }

    public String crearNodo(String id, String descripcion, boolean estado, String protocoloComunicacion) {

        if (existeNodoPorID(id)) {

            return "El nodo ya existe";
        } else {
            Nodo nodo = new Nodo(id, descripcion, estado, protocoloComunicacion);
            nodos.add(nodo);

            return "El nodo con ID " + id + " se agrego";
        }

    }

    public boolean existeNodoPorID(String id) {
                    
            for (Nodo nodo : nodos) {
              if(nodo.getId().equals(id)){
               return true;   
              }
            }
        
        return false;
    }

    public Nodo buscarNodoPorID(String id) {
        
            for (Nodo nodo : nodos) {
              if(nodo.getId().equals(id)){
               return nodo;   
              }
            }
        return null;
    }

    public String modificarNodoPorID(String id, String descripcion, String protocoloComunicacion) {
        if(existeNodoPorID(id)){            
            Nodo nodo = buscarNodoPorID(id);
            
            nodo.setDescripcion(descripcion);
            nodo.setProtocoloComunicacion(protocoloComunicacion);
            return "El nodo se modifico";
        }else{
            return "El nodo con ID " + id + " no existe";   
        }
    }

    public String eliminarNodoPorID(String id) {
    
        if(existeNodoPorID(id)){
            
            Nodo nodo = buscarNodoPorID(id);
            nodos.remove(nodo);
            return "El nodo se elimino";
        }else{
            return "El nodo con ID " + id + " no existe";   
        }
        
    }
}
