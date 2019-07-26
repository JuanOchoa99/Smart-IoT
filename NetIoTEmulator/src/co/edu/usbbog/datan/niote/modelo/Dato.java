/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que define las variables que integran un Dato
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva.
 */
public class Dato implements Serializable{
    /**
     * Contenido del dato
     */
    private String valor;
    /**
     * Fecha en la que se crea
     */
    private Date fecha; 
    /**
     * Método Constructor para inicializar las variables
     * @param valor
     * @param fecha 
     */
    public Dato(String valor, Date fecha) {
        this.valor = valor;
        this.fecha = fecha;
    }
    /**
     * Método para obtener el valor del dato
     * @return devuelve la variable valor
     */
    public String getValor() {
        return valor;
    }
    /**
     * Método para insertar en la variable valor
     * @param valor 
     */
    public void setValor(String valor) {
        this.valor = valor;
    }
    /**
     * Método para obtener la fecha de un dato
     * @return devuelve la variable fecha
     */
    public Date getFecha() {
        return fecha;
    }
    /**
     * Método para insertar en la variable fecha
     * @param fecha 
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    /**
     * Método para contener las variables del dato en un String
     * @return devuelve el dato en una cadena de caracteres
     */
    @Override
    public String toString() {
        return "Dato{" + "valor=" + valor + ", fecha=" + fecha.toString() + '}';
    }
    
    
}
