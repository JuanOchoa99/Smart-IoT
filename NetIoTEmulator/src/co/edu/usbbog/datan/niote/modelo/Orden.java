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
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class Orden implements Serializable{
    private String accion;
    private Date fecha;
    private boolean confimacion;

    public Orden(String accion, Date fecha, boolean confimacion) {
        this.accion = accion;
        this.fecha = fecha;
        this.confimacion = confimacion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isConfimacion() {
        return confimacion;
    }

    public void setConfimacion(boolean confimacion) {
        this.confimacion = confimacion;
    }

    @Override
    public String toString() {
        return "Orden{" + "accion=" + accion + ", fecha=" + fecha.toString() + ", confimacion=" + confimacion + '}';
    }
    
    
    
}
