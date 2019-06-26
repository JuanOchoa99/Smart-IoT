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
public class Orden implements Serializable{
    /**
     * Variable que contiene la accion que se va a realizar
     */
    private String accion;
    /**
     * Variable que contiene la fecha en la que se crea la orden
     */
    private Date fecha;
    /**
     * Variable que confirma si se agrego o no la orden
     */
    private boolean confimacion;
    /**
     * Metodo constructor para inicilizar las variables
     * @param accion
     * @param fecha
     * @param confimacion 
     */
    public Orden(String accion, Date fecha, boolean confimacion) {
        this.accion = accion;
        this.fecha = fecha;
        this.confimacion = confimacion;
    }
    /**
     * Metodo para obtener la accion de la orden
     * @return devuelve a variable accion
     */
    public String getAccion() {
        return accion;
    }
    /**
     * Metodo para insertar la accion a la orden
     * @param accion 
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }
    /**
     * Metodo para obtener la fecha de la orden
     * @return devuelve la variable fecha
     */
    public Date getFecha() {
        return fecha;
    }
    /**
     * Metodo para insertar fecha de la orden
     * @param fecha 
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    /**
     * Metodo para obtener la confirmacion de la orden 
     * @return devuelve la variable confirmacion
     */
    public boolean isConfimacion() {
        return confimacion;
    }
    /**
     * Metodo para insertar confirmacion a la orden 
     * @param confimacion 
     */
    public void setConfimacion(boolean confimacion) {
        this.confimacion = confimacion;
    }
    /**
     * Metodo para contener todas las variables en un String
     * @return devuelve una cadena de caracteres con las variables
     */
    @Override
    public String toString() {
        return "Orden{" + "accion=" + accion + ", fecha=" + fecha.toString() + ", confimacion=" + confimacion + '}';
    }
    
    
    
}
