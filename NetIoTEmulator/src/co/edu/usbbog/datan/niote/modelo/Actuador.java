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
public class Actuador implements Serializable{
    private String id;
    private String descripcion;
    private boolean estado;
    private String tipo;
    private List<Orden> accionesRealizadas;
    private List<Orden> accionesEnCola;

    public Actuador(String id, String descripcion, boolean estado, String tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipo = tipo;
        this.accionesRealizadas = new ArrayList<Orden>();
        this.accionesEnCola = new ArrayList<Orden>();
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Orden> getAccionesRealizadas() {
        return accionesRealizadas;
    }

    public void setAccionesRealizadas(List<Orden> accionesRealizadas) {
        this.accionesRealizadas = accionesRealizadas;
    }

    public List<Orden> getAccionesEnCola() {
        return accionesEnCola;
    }

    public void setAccionesEnCola(List<Orden> accionesEnCola) {
        this.accionesEnCola = accionesEnCola;
    }

    @Override
    public String toString() {
        return "Actuador{" + "id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", tipo=" + tipo + '}';
    }
    
    
    
}
