/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.modelo;

import java.util.Date;

/**
 *
 * @author 305
 */
public class Mensaje {
    private String id;
    private Date fecha;
    private String tipo;
    private String mensaje;

    public Mensaje(String id, Date fecha, String tipo, String mensaje) {
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.mensaje = mensaje;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "id=" + id + ", fecha=" + fecha.toString() + ", tipo=" + tipo + ", mensaje=" + mensaje + '}';
    }
    
    
    
}
