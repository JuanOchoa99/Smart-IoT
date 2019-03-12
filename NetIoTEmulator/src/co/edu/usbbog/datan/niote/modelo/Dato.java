/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.modelo;

import java.util.Date;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class Dato {
    private String valor;
    private Date fecha; 

    public Dato(String valor, Date fecha) {
        this.valor = valor;
        this.fecha = fecha;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Dato{" + "valor=" + valor + ", fecha=" + fecha.toString() + '}';
    }
    
    
}
