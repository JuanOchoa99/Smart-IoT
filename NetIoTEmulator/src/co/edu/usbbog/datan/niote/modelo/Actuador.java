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
public class Actuador implements Serializable{
    /**
     * variable irrepetible con la que se identificara el actuador
     */
    private String id;
    /**
     * Descripcion del Actuador
     */
    private String descripcion;
    /**
     * Estado del Actuador
     */
    private boolean estado;
    /**
     * Tipo de actuador
     */
    private String tipo;
    /**
     * Lista de acciones que ya se realizaron
     */
    private List<Orden> accionesRealizadas;
    /**
     * Lista de acciones por realizar 
     */
    private List<Orden> accionesEnCola;
    
    /**
     * Metodo constructor para dar valor a las variables del Actuador
     * @param id 
     * @param descripcion
     * @param estado
     * @param tipo 
     */
    public Actuador(String id, String descripcion, boolean estado, String tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipo = tipo;
        this.accionesRealizadas = new ArrayList<Orden>();
        this.accionesEnCola = new ArrayList<Orden>();
    }
    /**
     * Metodo para obtener el Id del actuador
     * @return devuelve el id
     */
    public String getId() {
        return id;
    }
    /**
     * Metodo para almacenar un id a un actuador
     * @param id a almacenar
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Metodo para obtener la descripcion del actuador
     * @return 
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Metodo para alamcenar la descripcion del actuador
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Metodo para obtener el Estador del actuador
     * @return devuelve la variable estado
     */
    public boolean isEstado() {
        return estado;
    }
    /**
     * Metodo para almacenar en la variable estado
     * @param estado 
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    /**
     * Metodo para obtener el tipo de actuaor
     * @return devuelve la variable tipo
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * Metodo para almacenar en la variable tipo de actuador
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    /**
     * Metodo para obtener la lista de acciones realizadas
     * @return devuelve la variable accionesRealizadas
     */
    public List<Orden> getAccionesRealizadas() {
        return accionesRealizadas;
    }
    /**
     * Metodo para agregar valores a la lista de acciones realizadas
     * @param accionesRealizadas 
     */
    public void setAccionesRealizadas(List<Orden> accionesRealizadas) {
        this.accionesRealizadas = accionesRealizadas;
    }
    /**
     * Metodo para obtener la lista de acciones en cola
     * @return devuelve accionesEnCOla
     */
    public List<Orden> getAccionesEnCola() {
        return accionesEnCola;
    }
    /**
     * Metodo para agregar valores a la lista de acciones en cola
     * @param accionesEnCola 
     */
    public void setAccionesEnCola(List<Orden> accionesEnCola) {
        this.accionesEnCola = accionesEnCola;
    }
    /**
     * Metodo para contener los valores del actuador en un String
     * @return devuelve el String con las variables del actuador
     */
    @Override
    public String toString() {
        return "Actuador{" + "id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", tipo=" + tipo + '}';
    }
    
    
    
}
