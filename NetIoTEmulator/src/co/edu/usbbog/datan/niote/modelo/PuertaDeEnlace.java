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
public class PuertaDeEnlace implements Serializable{
    /**
     * Variable unica con la que se identifica la puerta de enlace
     */
    private String id;
    /**
     * VAriable que contiene la descripcion de la puerta de enlace 
     */
    private String descripcion;
    /**
     * Variable que contiene el estado de la puerta de enlace 
     */
    private boolean estado;
    /**
     * -----------
     */
    private String direccionLogica;
    /**
     * -----------
     */
    private String puertoDeServicio;
    /**
     * ---------
     */
    private String protocoloComunicacionExterno;
    /**
     * Lista que contiene los mensaje de la puerta de enlace 
     */
    private List<Mensaje> mensajes;
    /**
     * Lista que contiene los nodos que pertenecen a la puerta de enlace
     */
    private List<Nodo> nodos;

    /**
     * Metodo constructor para inicializar las variables
     * @param id
     * @param descripcion
     * @param estado
     * @param direccionLogica
     * @param puertoDeServicio
     * @param protocoloComunicacionExterno 
     */
    public PuertaDeEnlace(String id, String descripcion, boolean estado, String direccionLogica, String puertoDeServicio, String protocoloComunicacionExterno) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.direccionLogica = direccionLogica;
        this.puertoDeServicio = puertoDeServicio;
        this.protocoloComunicacionExterno = protocoloComunicacionExterno;
        this.mensajes = new ArrayList<Mensaje>();
        this.nodos = new ArrayList<Nodo>();
    }
    
    /**
     * Metodo para obtener el id de la puerta de enlace
     * @return devuelve la variable id
     */
    public String getId() {
        return id;
    }
    /**
     * Metodo para inserta id a la puerta de enlace
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Metodo para obtener la descripcion de la puerta de enlace
     * @return devuelve la variable descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Metodo para inserta descripcion a la puerta de enlace
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Metodo para obtener el estado de la puerta de enlace
     * @return devuelve la variable estado
     */
    public boolean isEstado() {
        return estado;
    }
    /**
     * Metodo para insertar estado a la puerta de enlace
     * @param estado 
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    /**
     * Metodo para obtener la direccion logica de la puerta de enlace 
     * @return devuelve la variable direccionLogica
     */
    public String getDireccionLogica() {
        return direccionLogica;
    }
    /**
     * Metodo para insertar direccion logica a la puerta de enlace
     * @param direccionLogica 
     */
    public void setDireccionLogica(String direccionLogica) {
        this.direccionLogica = direccionLogica;
    }
    /**
     * Metodo para obtener puerto de serviocio de la puerta de enlace
     * @return 
     */
    public String getPuertoDeServicio() {
        return puertoDeServicio;
    }
    /**
     * Metodo para insertar puerto de servicio a la puerta de enlace
     * @param puertoDeServicio 
     */
    public void setPuertoDeServicio(String puertoDeServicio) {
        this.puertoDeServicio = puertoDeServicio;
    }
    /**
     * Metodo para obtener el protocolo de comunicacion de la puerta de enlace
     * @return devuelve la variable protocoloComunicacion
     */
    public String getProtocoloComunicacionExterno() {
        return protocoloComunicacionExterno;
    }
    /**
     * Metodo para insertar protocolo de comunicacion a la puerta de enlace
     * @param protocoloComunicacionExterno 
     */
    public void setProtocoloComunicacionExterno(String protocoloComunicacionExterno) {
        this.protocoloComunicacionExterno = protocoloComunicacionExterno;
    }
    /**
     * Metodo para obtener los nodos de la puerta de enlace
     * @return devuelve la lista nodos
     */
    public List<Nodo> getNodos() {
        return nodos;
    }
    /**
     * Metodo para insertar nodos a la puerta de enlace
     * @param nodos 
     */
    public void setNodos(List<Nodo> nodos) {
        this.nodos = nodos;
    }
    /**
     * Metodo para obtener los mensajes de la puerta de enlace
     * @return devuelve la lista mensajes
     */
    public List<Mensaje> getMensajes() {
        return mensajes;
    }
    /**
     * Metodo para insertar mensajes a la puerta de enlace
     * @param mensajes 
     */
    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
    /**
     * Metodo para contener las variables en un String
     * @return devuelve cadena de caracteres con las variables
     */
    @Override
    public String toString() {
        return "PuertaDeEnlace{" + "id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", direccionLogica=" + direccionLogica + ", puertoDeServicio=" + puertoDeServicio + ", protocoloComunicacionExterno=" + protocoloComunicacionExterno + '}';
    }
}
