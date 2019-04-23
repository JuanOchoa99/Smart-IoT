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

    /**
     * Lista para almacenar cada nodo que se cree
     */
    private List<Nodo> nodos;

    /**
     * Constructor para la lista de nodos
     *
     * @param nodos variable que contiene la lista
     */
    public GestionNodos(List<Nodo> nodos) {
        this.nodos = nodos;
    }

    /**
     * Constructor de la clase
     */
    public GestionNodos() {
        this.nodos = new ArrayList<>();
    }

    /**
     * Obtener los valores de la lista
     *
     * @return valores de la lista
     */
    public List<Nodo> getNodos() {
        return nodos;
    }

    /**
     * Poner nuevos valores en la lista
     *
     * @param nodos variable que contiene la lista
     */
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
    /**
     * Metodo para ver todos los nodos existentes
     *
     * @return Todos los nodos
     */
    public String verNodos() {

        String salida = "";
        for (Nodo nodo : nodos) {
            salida += salida + nodo.toString() + "\n";
        }
        return salida;
    }

    /**
     * Metodo para ver un nodo especifico segun su id
     *
     * @param id campo unico con el que se identifica cada nodo
     * @return Especificaciones del nodo segun el id
     */
    public String verNodoPorID(String id) {

        String salida = "";

        if (existeNodoPorID(id)) {
            for (Nodo nodo : nodos) {
                if (nodo.getId().equals(id)) {
                    salida = nodo.toString() + "\n";
                }
            }
        } else {

            salida = "El nodo con ID " + id + " no existe";
        }

        return salida;
    }

    /**
     * Metodo para crear un nuevo nodo
     *
     * @param id campo unico de cada nodo
     * @param descripcion descripcion del nodo
     * @param estado activo o inactivo
     * @param protocoloComunicacion protocolo a traves del que se va a comunicar
     * @return retorna si el nodo se agrego o ya existe
     */
    public String crearNodo(String id, String descripcion, boolean estado, String protocoloComunicacion) {

        if (existeNodoPorID(id)) {

            return "El nodo ya existe";
        } else {
            Nodo nodo = new Nodo(id, descripcion, estado, protocoloComunicacion);
            nodos.add(nodo);

            return "El nodo con ID " + id + " se agrego";
        }

    }

    /**
     * Metodo para verificar si existe el id
     *
     * @param id campo unico con el que se identifica cada nodo
     * @return true = si existe, false = no existe
     */
    public boolean existeNodoPorID(String id) {
        if (nodos.stream().anyMatch((nodo) -> (nodo.getId().equals(id)))) {
            return true;
        }
        return false;
    }

    /**
     * Metodo para buscar un nodo
     *
     * @param id campo unico con el que se identifica cada nodo
     * @return El nodo que se busco
     */
    public Nodo buscarNodoPorID(String id) {

        for (Nodo nodo : nodos) {
            if (nodo.getId().equals(id)) {
                return nodo;
            }
        }
        return null;
    }

    /**
     * Metodo para modificar las especificaciones de un nodo
     *
     * @param id campo unico de cada nodo
     * @param descripcion descripcion del nodo
     * @param protocoloComunicacion protocolo a traves del que se va a comunicar
     * @return Se modifico o no se modifico
     */
    public String modificarNodoPorID(String id, String descripcion, String protocoloComunicacion) {
        if (existeNodoPorID(id)) {
            Nodo nodo = buscarNodoPorID(id);

            nodo.setDescripcion(descripcion);
            nodo.setProtocoloComunicacion(protocoloComunicacion);
            return "El nodo se modifico";
        } else {
            return "El nodo con ID " + id + " no existe";
        }
    }

    /**
     * Metodo para eliminar un nodo
     *
     * @param id campo unico con el que se identifica cada nodo
     * @return se elimino o no se elimino
     */
    public String eliminarNodoPorID(String id) {

        if (existeNodoPorID(id)) {

            Nodo nodo = buscarNodoPorID(id);
            nodos.remove(nodo);
            return "El nodo se elimino";
        } else {
            return "El nodo con ID " + id + " no existe";
        }

    }
}
