/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.modelo;

import java.util.List;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class PuertaDeEnlace {
    private String id;
    private String descripcion;
    private boolean estado;
    private String direccionLogica;
    private String puertoDeServicio;
    private String protocoloComunicacionExterno;
    private List<Mensaje> mensajes;    
    private List<Nodo> nodos;
    private List<PuertaDeEnlace> salidas;

    public PuertaDeEnlace(String id, String descripcion, boolean estado, String direccionLogica, String puertoDeServicio, String protocoloComunicacionExterno) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.direccionLogica = direccionLogica;
        this.puertoDeServicio = puertoDeServicio;
        this.protocoloComunicacionExterno = protocoloComunicacionExterno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDireccionLogica() {
        return direccionLogica;
    }

    public void setDireccionLogica(String direccionLogica) {
        this.direccionLogica = direccionLogica;
    }

    public String getPuertoDeServicio() {
        return puertoDeServicio;
    }

    public void setPuertoDeServicio(String puertoDeServicio) {
        this.puertoDeServicio = puertoDeServicio;
    }

    public String getProtocoloComunicacionExterno() {
        return protocoloComunicacionExterno;
    }

    public void setProtocoloComunicacionExterno(String protocoloComunicacionExterno) {
        this.protocoloComunicacionExterno = protocoloComunicacionExterno;
    }

    @Override
    public String toString() {
        return "PuertaDeEnlace{" + "id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", direccionLogica=" + direccionLogica + ", puertoDeServicio=" + puertoDeServicio + ", protocoloComunicacionExterno=" + protocoloComunicacionExterno + '}';
    }

    public List<Nodo> getNodos() {
        return nodos;
    }

    public void setNodos(List<Nodo> nodos) {
        this.nodos = nodos;
    }
}
