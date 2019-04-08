/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.persistencia;

import co.edu.usbbog.datan.niote.modelo.Red;

/**
 *
 * @author sevin
 */
public class ArchivoDeConfiguracionDeRed {

    private String ruta;
    private String nombreArchivo;

    public ArchivoDeConfiguracionDeRed() {
    }

    public ArchivoDeConfiguracionDeRed(String ruta, String nombreArchivo) {
        this.ruta = ruta;
        this.nombreArchivo = nombreArchivo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public Red cargarRed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
