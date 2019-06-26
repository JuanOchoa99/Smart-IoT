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
public class Red implements Serializable{
    /**
     * Variable unica para identificar la red
     */
    private String id;
    /**
     * Variable que contiene el nombre de la Red
     */
    private String nombre;
    /**
     * Variable que contiene la descripcion de la Red 
     */
    private String descripcion;
    /**
     * Lista de las puertas de enlace de la red 
     */
    private List<PuertaDeEnlace> puertasDeEnlace;
    /**
     * Metodo constructor para inicializar las variables
     * @param id
     * @param nombre
     * @param descripcion 
     */
    public Red(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puertasDeEnlace = new ArrayList<PuertaDeEnlace>();
    }
    /**
     * Metodo para obtener el id de la Red
     * @return devuelve la variable id
     */
    public String getId() {
        return id;
    }
    /**
     * Metodo para insertar id a la Red
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Metodo para obtener el nombre de la Red 
     * @return devuelve la variable nombre 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo para insertar nombre a la Red
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo para obtener la descripcion de la Red
     * @return devuelve la variable descripcion 
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Metodo para insertar descripcion a la Red
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Metodo para obtener las Puertas de enlace de la red 
     * @return devuelve la lista puertasDeEnlace
     */
    public List<PuertaDeEnlace> getPuertasDeEnlace() {
        return puertasDeEnlace;
    }
    /**
     * Metodo para insertar puertas de enlace a la Red
     * @param puertasDeEnlace 
     */
    public void setPuertasDeEnlace(List<PuertaDeEnlace> puertasDeEnlace) {
        this.puertasDeEnlace = puertasDeEnlace;
    }
    /**
     * Metodo para contener las variables en un String
     * @return devuelve cadena de caracteres con las variables
     */
    @Override
    public String toString() {
        return "Red{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    
    
    
    
}
