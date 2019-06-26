/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva.
 */
public class Mensaje implements Serializable{
    /**
     * variable unica con la que se va a identificar el mensaje
     */
    private String id;
    /**
     * Variable que contiene la fecha en la que se envia el mensaje
     */
    private Date fecha;
    /**
     * -----------------
     */
    private String tipo;
    /**
     * Variable que contiene el mensaje
     */
    private String mensaje;
    
    /**
     * Metodo constructor para inicializar las variables
     * @param id
     * @param fecha
     * @param tipo
     * @param mensaje 
     */
    public Mensaje(String id, Date fecha, String tipo, String mensaje) {
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.mensaje = mensaje;
    }
    /**
     * Metodo para obtener el id del mensaje
     * @return  devuelve el id del mensaje
     */
    public String getId() {
        return id;
    }
    /**
     * Metodo para insertar id del mesnaje
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Metodo para obtener la fecha del mensaje
     * @return devuelve la variable fecha
     */
    public Date getFecha() {
        return fecha;
    }
    /**
     * Metodo para insertar la fecha de un mensaje
     * @param fecha 
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    /**
     * Metodo para obtener el tipo de mensaje
     * @return devuelve la variable tipo
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * Metodo para insertar el tipo de mensaje
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    /**
     * Metodo para obtener el mensaje
     * @return devuelve la variable mensaje
     */
    public String getMensaje() {
        return mensaje;
    }
    /**
     * Metodo para insertar el mensaje
     * @param mensaje 
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    /**
     * Metodo para contener las variables del mensaje en un String
     * @return devuelve una cadena de caracteres con las variables 
     */
    @Override
    public String toString() {
        return "Mensaje{" + "id=" + id + ", fecha=" + fecha.toString() + ", tipo=" + tipo + ", mensaje=" + mensaje + '}';
    }
    
    
    
}
