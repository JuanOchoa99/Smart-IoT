/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.logica;

import co.edu.usbbog.datan.niote.controlador.persistencia.ArchivoDeConfiguracionDeRed;
import co.edu.usbbog.datan.niote.modelo.PuertaDeEnlace;
import co.edu.usbbog.datan.niote.modelo.Red;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class GestionRed {

    private Red red;
    private ArchivoDeConfiguracionDeRed archivoDeConfiguracionDeRed;

    //relaciones
    private GestionPuertasDeEnlace gestionPuertasDeEnlace;
    private GestionNodos gestionNodos;
    private GestionActuadores gestionActuadores;
    private GestionSensores gestionSensores;
    

    public GestionRed(String id, String nombre, String descripcion) {               
        this.red = new Red(id, nombre, descripcion);
        this.archivoDeConfiguracionDeRed = new ArchivoDeConfiguracionDeRed();
        this.gestionPuertasDeEnlace = new GestionPuertasDeEnlace();
        this.gestionNodos = new GestionNodos();
        this.gestionActuadores = new GestionActuadores();
        this.gestionSensores = new GestionSensores();        
    }

    public GestionRed(String ruta, String nombreArchivo) {
        this.archivoDeConfiguracionDeRed = new ArchivoDeConfiguracionDeRed(ruta, nombreArchivo);
        this.gestionPuertasDeEnlace = this.archivoDeConfiguracionDeRed.cargarPuertasDeEnlace();
        this.gestionNodos = this.archivoDeConfiguracionDeRed.cargarNodos();
        this.gestionActuadores = this.archivoDeConfiguracionDeRed.cargarActuadores();
        this.gestionSensores = this.archivoDeConfiguracionDeRed.cargarSensores();        
        this.red = this.archivoDeConfiguracionDeRed.cargarRed();
    }

    public Red getRed() {
        return red;
    }

    public void setRed(Red red) {
        this.red = red;
    }

    public GestionNodos getGestionNodo() {
        return gestionNodos;
    }

    public GestionActuadores getGestionActuadores() {
        return gestionActuadores;
    }

    public GestionSensores getGestionSensores() {
        return gestionSensores;
    }

    public GestionPuertasDeEnlace getGestionPuertaDeEnlace() {
        return gestionPuertasDeEnlace;
    }

    public boolean verRed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean agregarPuertaDeEnlaceALaRed(PuertaDeEnlace buscarPuertaDeEnlacePorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean verPuertasDeEnlaceDeLaRed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public PuertaDeEnlace buscarPuertaDeEnlaceDeLaRedPorID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean removerPuertaDeEnlaceDeLaRed(PuertaDeEnlace buscarPuertaDeEnlaceDeLaRedPorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
