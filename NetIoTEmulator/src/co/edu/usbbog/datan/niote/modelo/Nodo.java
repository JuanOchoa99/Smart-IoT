/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva.
 */
public class Nodo implements Serializable {
    /**
     * Variable unica para identificar el nodo
     */
    private String id;
    /**
     * Variable que contiene la descripcion del nodo
     */
    private String descripcion;
    /**
     * Variable que contiene el estado del nodo 
     */
    private boolean estado;
    /**
     * Variable que contiene el protocolo de comunicacion que va a utilizar para la conexion con el gateway 
     */
    private String protocoloComunicacion;
    /**
     * Lista que contiene los actuadores que pertenecen al nodo
     */
    private List<Actuador> actuadores;
        /**
     * Lista que contiene los sensores que pertenecen al nodo
     */
    private List<Sensor> sensores;
    /**
     * Metodo constructor para inicializar las variables
     * @param id
     * @param descripcion
     * @param estado
     * @param protocoloComunicacion 
     */
    public Nodo(String id, String descripcion, boolean estado, String protocoloComunicacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.protocoloComunicacion = protocoloComunicacion;
        this.actuadores = new ArrayList<Actuador>();
        this.sensores = new ArrayList<Sensor>();
    }


    /**
     * Metodo para obtener el id del nodo
     * @return devuelve la variable id
     */
    public String getId() {
        return id;
    }
    /**
     * Metodo para insertar id al nodo
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Metodo para obtener la descripcion del nodo
     * @return devuelve la variable descripcion 
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Metodo para insertar descripcion al nodo
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Metodo para obtener el estadodel nodo
     * @return devuelve la variable estado
     */
    public boolean isEstado() {
        return estado;
    }
    /**
     * Metodo para insertar estado al nodo
     * @param estado 
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    /**
     * Metodo para obtener protocolo de comunicacion del nodo
     * @return devuelve la variable protocoloComunicacion
     */
    public String getProtocoloComunicacion() {
        return protocoloComunicacion;
    }
    /**
     * Metodo para insertar protocolo de comunicacion al nodo 
     * @param protocoloComunicacion 
     */
    public void setProtocoloComunicacion(String protocoloComunicacion) {
        this.protocoloComunicacion = protocoloComunicacion;
    }
    /**
     * Metodo para obtener la lista de actuadores del nodo
     * @return devuelve la lista actuadores
     */
    public List<Actuador> getActuadores() {
        return actuadores;
    }
    /**
     * Metodo para insertar valores a la lista de actuadores
     * @param actuadores 
     */
    public void setActuadores(List<Actuador> actuadores) {
        this.actuadores = actuadores;
    }
    /**
     * Metodo para obtener la lista de sensores del nodo
     * @return devuelve la lista sensores
     */
    public List<Sensor> getSensores() {
        return sensores;
    }
    /**
     * Metodo para insertar valores a la lista de sensores
     * @param sensores 
     */
    public void setSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    } 
    /**
     * Metodo para contener las variables del nodo en un String
     * @return cadena de caracteres que contiene las variables del nodo
     */
    @Override
    public String toString() {
        return "Nodo{" + "id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", protocoloComunicacion=" + protocoloComunicacion + '}';
    }
    
}
