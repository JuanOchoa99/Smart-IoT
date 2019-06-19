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
    private String id;
    private String descripcion;
    private boolean estado;
    private String tipo;
    private List<Dato> datosGenerados;

    public Sensor(String id, String descripcion, boolean estado, String tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipo = tipo;
        this.datosGenerados = new ArrayList<Dato>();
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

    public List<Dato> getDatosGenerados() {
        return datosGenerados;
    }

    public void setDatosGenerados(List<Dato> datosGenerados) {
        this.datosGenerados = datosGenerados;
    }

    @Override
    public String toString() {
        return "Sensor{" + "id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", tipo=" + tipo + '}';
    }
    
}
