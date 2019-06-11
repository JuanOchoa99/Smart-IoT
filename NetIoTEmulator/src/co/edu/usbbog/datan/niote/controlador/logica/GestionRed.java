/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.logica;

import co.edu.usbbog.datan.niote.controlador.persistencia.ArchivoDeConfiguracionDeRed;
import co.edu.usbbog.datan.niote.modelo.PuertaDeEnlace;
import co.edu.usbbog.datan.niote.modelo.Red;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class GestionRed implements Serializable {

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

    public boolean agregarPuertaDeEnlaceALaRed(String idPuertaDeEnlace) {
        PuertaDeEnlace puertaDeEnlace = getGestionPuertaDeEnlace().buscarPuertaDeEnlacePorID(idPuertaDeEnlace);
        List<PuertaDeEnlace> puertasDeEnlace = getRed().getPuertasDeEnlace();
        
        if(puertaDeEnlace!=null){
           for (PuertaDeEnlace puertaDeEnlaces : puertasDeEnlace) {
                if (puertaDeEnlaces.getId().equals(idPuertaDeEnlace)) {
                    return false;
                }else{
                    getGestionPuertaDeEnlace().eliminarPuertaDeEnlacePorID(idPuertaDeEnlace);            
                    getRed().getPuertasDeEnlace().add(puertaDeEnlace);
                    return true;
                }
            }           
        }else{
            return false;
        }      
        return false;
    }

    public String verPuertasDeEnlaceDeLaRed() {
        List<PuertaDeEnlace> puertasDeEnlace = getRed().getPuertasDeEnlace();

        String salida = "";
        for (PuertaDeEnlace puertaDeEnlace : puertasDeEnlace) {
            salida += salida + puertaDeEnlace.toString() + "\n";
        }
        return salida;
    }

    public String buscarPuertaDeEnlaceDeLaRedPorID(String id) {
        
        List<PuertaDeEnlace> puertasDeEnlace = getRed().getPuertasDeEnlace();
        
        String salida = "";
       
            for (PuertaDeEnlace puertaDeEnlace : puertasDeEnlace) {
                if (puertaDeEnlace.getId().equals(id)) {
                    salida = puertaDeEnlace.toString() + "\n";
                    break;
                }
            }
        return null;
    }

    public boolean removerPuertaDeEnlaceDeLaRed(String idPuertaDeEnlace) {
    PuertaDeEnlace puertaDeEnlace = getGestionPuertaDeEnlace().buscarPuertaDeEnlacePorID(idPuertaDeEnlace);
    
        if(puertaDeEnlace!=null){
            getGestionPuertaDeEnlace().crearPuertaDeEnlace(puertaDeEnlace.getId(),puertaDeEnlace.getDescripcion(), false, puertaDeEnlace.getDireccionLogica(), puertaDeEnlace.getPuertoDeServicio(), puertaDeEnlace.getProtocoloComunicacionExterno());
            getRed().getPuertasDeEnlace().remove(puertaDeEnlace);
            return true;
        }else{
            return false;
        }
    }

    public boolean agregarNodoALaRed(String idNodo, String idsPuertasDeEnlace) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String validarPuertasDeEnlace(String idsPuertasDeEnlace) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean verNodosDeLaRed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object buscarNodoDeLaRedPorID(String idNodo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean removerNodoDeLaRed(String idNodo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean guardarRed(String ruta, String nombreArchivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean agregarSensorALaRed(String idSensor, String idNodo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean verSensoresDeLaRed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object buscarSensorDeLaRedPorID(String idSensor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean removerSensorDeLaRed(String idSensor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean verActuadorDeLaRed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object buscarActuadorDeLaRedPorID(String idActuador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean removerActuadorDeLaRed(String idActuador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean agregarActuadorALaRed(String idActuador, String idNodo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
