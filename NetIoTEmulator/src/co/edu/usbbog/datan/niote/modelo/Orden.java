/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que contiene las variables que integran una Orden
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva.
 */
public class Orden implements Serializable{
    /**
     * Variable que contiene la acción que se va a realizar
     */
    private String accion;
    /**
     * Variable que contiene la fecha en la que se crea la orden
     */
    private Date fecha;
    /**
     * Variable que confirma si se agregó o no la orden
     */
    private boolean confimacion;
    /**
     * Método constructor para inicializar las variables
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
     * Método para obtener la acción de la orden
     * @return devuelve a variable acción
     */
    public String getAccion() {
        return accion;
    }
    /**
     * Método para insertar la acción a la orden
     * @param accion 
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }
    /**
     * Método para obtener la fecha de la orden
     * @return devuelve la variable fecha
     */
    public Date getFecha() {
        return fecha;
    }
    /**
     * Método para insertar fecha de la orden
     * @param fecha 
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    /**
     * Método para obtener la confirmación de la orden 
     * @return devuelve la variable confirmación
     */
    public boolean isConfimacion() {
        return confimacion;
    }
    /**
     * Método para insertar confirmación a la orden 
     * @param confimacion 
     */
    public void setConfimacion(boolean confimacion) {
        this.confimacion = confimacion;
    }
    /**
     * Método para contener todas las variables en un String
     * @return devuelve una cadena de caracteres con las variables
     */
    @Override
    public String toString() {
        return "Orden{" + "accion=" + accion + ", fecha=" + fecha.toString() + ", confimacion=" + confimacion + '}';
    }
    
    
    
}
