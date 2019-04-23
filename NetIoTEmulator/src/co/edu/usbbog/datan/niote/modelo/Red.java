/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.modelo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class Red implements Serializable{
    private String id;
    private String nombre;
    private String descripcion;
    private List<PuertaDeEnlace> puertasDeEnlace;

    public Red(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<PuertaDeEnlace> getPuertasDeEnlace() {
        return puertasDeEnlace;
    }

    public void setPuertasDeEnlace(List<PuertaDeEnlace> puertasDeEnlace) {
        this.puertasDeEnlace = puertasDeEnlace;
    }

    @Override
    public String toString() {
        return "Red{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    
    
    
    
}
