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
public class Sensor implements Serializable{
    /**
     * variable irrepetible con la que se identificara el sensor
     */   
    private String id;
    /**
     * Descripcion del sensor
     */
    private String descripcion;
    /**
     * Estado del Sensor
     */
    private boolean estado;
    /**
     * Tipo de Sensor
     */
    private String tipo;
    /**
     * Lista de datos generados por el sensor
     */
    private List<Dato> datosGenerados;
    
    /**
     * Metodo contructor para inicializar las variables 
     * @param id
     * @param descripcion
     * @param estado
     * @param tipo 
     */
    public Sensor(String id, String descripcion, boolean estado, String tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipo = tipo;
        this.datosGenerados = new ArrayList<Dato>();
    }
    /**
     * Metodo para obtener el id del sensor
     * @return devuelve la variable id
     */
    public String getId() {
        return id;
    }
    /**
     * Metodo para insertar id al sensor
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Metodo para obtener la descripcion del sensor 
     * @return devuelve la variable descripcion 
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Metodo para insertar descripcion al sensor
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Metodo para obtener el estado del sensor
     * @return devuelve la variable estado
     */
    public boolean isEstado() {
        return estado;
    }
    /**
     * Metodo para insertar estado al sensor 
     * @param estado 
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    /**
     * Metodo para obtener el tipo de sensor
     * @return devuelve la variable tipo
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * Metodo para insertar el tipo de sensor
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    /**
     * Metodo para obtener los datos generados por el sensor
     * @return devuelve la lista datosGenerados
     */
    public List<Dato> getDatosGenerados() {
        return datosGenerados;
    }
    /**
     * Metodo para insertar los datos generados por el sensor
     * @param datosGenerados 
     */
    public void setDatosGenerados(List<Dato> datosGenerados) {
        this.datosGenerados = datosGenerados;
    }
    /**
     * Metodo para conetener en un String las variables 
     * @return devuelve cadena de caracteres con las variables 
     */
    @Override
    public String toString() {
        return "Sensor{" + "id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", tipo=" + tipo + '}';
    }
    
}
