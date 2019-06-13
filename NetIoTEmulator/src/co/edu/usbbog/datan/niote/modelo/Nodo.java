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
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class Nodo implements Serializable {
    private String id;
    private String descripcion;
    private boolean estado;
    private String protocoloComunicacion;
    private List<Actuador> actuadores;
    private List<Sensor> sensores;
    private List<PuertaDeEnlace> salidas;

    public Nodo(String id, String descripcion, boolean estado, String protocoloComunicacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.protocoloComunicacion = protocoloComunicacion;
        this.actuadores = new ArrayList<Actuador>();
        this.sensores = new ArrayList<Sensor>();
        this.salidas = new ArrayList<PuertaDeEnlace>();
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

    public String getProtocoloComunicacion() {
        return protocoloComunicacion;
    }

    public void setProtocoloComunicacion(String protocoloComunicacion) {
        this.protocoloComunicacion = protocoloComunicacion;
    }

    public List<Actuador> getActuadores() {
        return actuadores;
    }

    public void setActuadores(List<Actuador> actuadores) {
        this.actuadores = actuadores;
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public void setSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    } 
    
    @Override
    public String toString() {
        return "Nodo{" + "id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", protocoloComunicacion=" + protocoloComunicacion + '}';
    }

    public List<PuertaDeEnlace> getSalidas() {
        return salidas;
    }

    public void setSalidas(List<PuertaDeEnlace> salidas) {
        this.salidas = salidas;
    }
    
}
