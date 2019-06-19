/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.logica;

import co.edu.usbbog.datan.niote.controlador.persistencia.ArchivoDeConfiguracionDeRed;
import co.edu.usbbog.datan.niote.modelo.Actuador;
import co.edu.usbbog.datan.niote.modelo.Nodo;
import co.edu.usbbog.datan.niote.modelo.PuertaDeEnlace;
import co.edu.usbbog.datan.niote.modelo.Red;
import co.edu.usbbog.datan.niote.modelo.Sensor;
import java.io.Serializable;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva.
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

    public String verRed() {
        String salida = "Las puertas de enlace de la red " + getRed().getNombre() + "son:\n";
        pe:
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            salida += puertaDeEnlace.toString() + "\\>\n";
            if (!puertaDeEnlace.getNodos().isEmpty()) {
                salida += "Nodos:\n";
            }
            n:
            for (Nodo nodo : puertaDeEnlace.getNodos()) {
                salida += "\t" + nodo.toString() + ":\n";
                if (!nodo.getActuadores().isEmpty()) {
                    salida += "\tActuadores:\n";
                }
                a:
                for (Actuador actuador : nodo.getActuadores()) {
                    salida += "\t\t" + actuador.toString() + ":\n";
                }
                if (!nodo.getActuadores().isEmpty()) {
                    salida += "\tSensores:\n";
                }
                s:
                for (Sensor sensor : nodo.getSensores()) {
                    salida += "\t\t" + sensor.toString() + ":\n";
                }
            }
        }
        return salida;
    }

    public boolean agregarPuertaDeEnlaceALaRed(String idPuertaDeEnlace) {
        PuertaDeEnlace puertaDeEnlace = getGestionPuertaDeEnlace().buscarPuertaDeEnlacePorID(idPuertaDeEnlace);
        if (puertaDeEnlace != null) {
            getGestionPuertaDeEnlace().eliminarPuertaDeEnlacePorID(idPuertaDeEnlace);
            PuertaDeEnlace puertaDeEnlaceEnLaRed = buscarPuertaDeEnlaceDeLaRedPorID(puertaDeEnlace.getId());
            if (puertaDeEnlaceEnLaRed != null) {
                return true;
            } else {
                getRed().getPuertasDeEnlace().add(puertaDeEnlace);
                return true;
            }
        } else {
            return false;
        }
    }

    public String verPuertasDeEnlaceDeLaRed() {
        String salida = "la red " + getRed().getNombre() + "tiene:\n";
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            salida += puertaDeEnlace.toString() + "\n";
        }
        return salida;
    }

    public PuertaDeEnlace buscarPuertaDeEnlaceDeLaRedPorID(String idPuertaDeEnlace) {
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            if (puertaDeEnlace.getId().equals(idPuertaDeEnlace)) {
                return puertaDeEnlace;
            }
        }
        return null;
    }

    public boolean removerPuertaDeEnlaceDeLaRed(String idPuertaDeEnlace) {
        PuertaDeEnlace puertaDeEnlace = buscarPuertaDeEnlaceDeLaRedPorID(idPuertaDeEnlace);
        if (puertaDeEnlace != null) {
            for (Nodo nodo : puertaDeEnlace.getNodos()) {
                removerNodoDeLaRed(nodo.getId());
            }            
            if (getRed().getPuertasDeEnlace().remove(puertaDeEnlace)) {
                getGestionPuertaDeEnlace().crearPuertaDeEnlace(puertaDeEnlace.getId(), puertaDeEnlace.getDescripcion(), false, puertaDeEnlace.getDireccionLogica(), puertaDeEnlace.getPuertoDeServicio(), puertaDeEnlace.getProtocoloComunicacionExterno());
                return true;
            }else{
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean agregarNodoALaRed(String idNodo, String idPuertaDeEnlace) {
        Nodo nodo = getGestionNodo().buscarNodoPorID(idNodo);
        if (nodo != null) {
            getGestionNodo().eliminarNodoPorID(idNodo);
            Nodo nodoEnRed = buscarNodoDeLaRedPorID(nodo.getId());
            if (nodoEnRed != null) {
                return true;
            } else {
                for (int i = 0; i < getRed().getPuertasDeEnlace().size(); i++) {
                    if (getRed().getPuertasDeEnlace().get(i).getId().equals(idPuertaDeEnlace)) {
                        getRed().getPuertasDeEnlace().get(i).getNodos().add(nodo);
                        return true;
                    }
                }
                return false;
            }
        } else {
            return false;
        }
    }

    public String verNodosDeLaRed() {
        String salida = "";
        pe:
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            salida += "en: " + puertaDeEnlace.getId() + " estan:\n";
            n:
            for (Nodo nodo : puertaDeEnlace.getNodos()) {
                salida += "\t" + nodo.toString() + "\n";
            }
        }
        return salida;
    }

    public Nodo buscarNodoDeLaRedPorID(String idNodo) {
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            for (Nodo nodo : puertaDeEnlace.getNodos()) {
                if (nodo.getId().equals(idNodo)) {
                    return nodo;
                }
            }
        }
        return null;
    }

    public boolean removerNodoDeLaRed(String idNodo) {
        Nodo nodo = buscarNodoDeLaRedPorID(idNodo);
        if (nodo != null) {
            for (Actuador actuador : nodo.getActuadores()) {
                removerActuadorDeLaRed(actuador.getId());
            }
            for (Sensor sensor : nodo.getSensores()) {
                removerSensorDeLaRed(sensor.getId());
            }
            pe:
            for (int i = 0; i < getRed().getPuertasDeEnlace().size(); i++) {
                if (getRed().getPuertasDeEnlace().get(i).getNodos().remove(nodo)) {
                    getGestionNodo().crearNodo(nodo.getId(), nodo.getDescripcion(), false, nodo.getProtocoloComunicacion());
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public boolean agregarSensorALaRed(String idSensor, String idNodo) {
        Sensor sensor = getGestionSensores().buscarSensorPorID(idSensor);
        if (sensor != null) {
            getGestionSensores().eliminarSensorPorID(idSensor);
            Sensor sensorEnLaRed = buscarSensorDeLaRedPorID(sensor.getId());
            if (sensorEnLaRed != null) {
                return true;
            } else {
                for (int i = 0; i < getRed().getPuertasDeEnlace().size(); i++) {
                    for (int j = 0; j < getRed().getPuertasDeEnlace().get(i).getNodos().size(); j++) {
                        if (getRed().getPuertasDeEnlace().get(i).getNodos().get(j).getId().equals(idNodo)) {
                            getRed().getPuertasDeEnlace().get(i).getNodos().get(j).getSensores().add(sensor);
                            return true;
                        }
                    }
                }
                return false;
            }
        } else {
            return false;
        }
    }

    public String verSensoresDeLaRed() {
        String salida = "";
        pe:
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            salida += "en: " + puertaDeEnlace.getId() + " estan:\n";
            n:
            for (Nodo nodo : puertaDeEnlace.getNodos()) {
                salida += "\ten: " + nodo.getId() + " estan:\n";
                s:
                for (Sensor sensor : nodo.getSensores()) {
                    salida += "\t\t" + sensor.toString() + "\n";
                }
            }
        }
        return salida;
    }

    public Sensor buscarSensorDeLaRedPorID(String idSensor) {
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            for (Nodo nodo : puertaDeEnlace.getNodos()) {
                for (Sensor sensor : nodo.getSensores()) {
                    if (sensor.getId().equals(idSensor)) {
                        return sensor;
                    }
                }
            }
        }
        return null;
    }

    public boolean removerSensorDeLaRed(String idSensor) {
        Sensor sensor = buscarSensorDeLaRedPorID(idSensor);
        if (sensor != null) {            
            pe:
            for (int i = 0; i < getRed().getPuertasDeEnlace().size(); i++) {
                n:
                for (int j = 0; j < getRed().getPuertasDeEnlace().get(i).getNodos().size(); j++) {
                    if (getRed().getPuertasDeEnlace().get(i).getNodos().get(j).getSensores().remove(sensor)) {
                        getGestionSensores().crearSensor(sensor.getId(), sensor.getDescripcion(), false, sensor.getTipo());
                        return true;
                    }
                }
            }
            return false;
        } else {
            return false;
        }
    }

    /**
     * Metodo para agregar actuador en la red
     *
     * @param idActuador
     * @param idNodo
     * @return
     */
    public boolean agregarActuadorALaRed(String idActuador, String idNodo) {
        Actuador actuador = getGestionActuadores().buscarActuadorPorID(idActuador);
        if (actuador != null) {
            getGestionActuadores().eliminarActuadorPorID(idActuador);
            Actuador actuadorEnLaRed = buscarActuadorDeLaRedPorID(actuador.getId());
            if (actuadorEnLaRed != null) {
                return true;
            } else {
                for (int i = 0; i < getRed().getPuertasDeEnlace().size(); i++) {
                    for (int j = 0; j < getRed().getPuertasDeEnlace().get(i).getNodos().size(); j++) {
                        if (getRed().getPuertasDeEnlace().get(i).getNodos().get(j).getId().equals(idNodo)) {
                            getRed().getPuertasDeEnlace().get(i).getNodos().get(j).getActuadores().add(actuador);
                            return true;
                        }
                    }
                }
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Metodo para ver los Actuadores en la red
     *
     * @return
     */
    public String verActuadorDeLaRed() {
        String salida = "";
        pe:
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            salida += "en: " + puertaDeEnlace.getId() + " estan:\n";
            n:
            for (Nodo nodo : puertaDeEnlace.getNodos()) {
                salida += "\ten: " + nodo.getId() + " estan:\n";
                a:
                for (Actuador actuador : nodo.getActuadores()) {
                    salida += "\t\t" + actuador.toString() + "\n";
                }
            }
        }
        return salida;
    }

    /**
     * Metodo para buscar actuador en la red
     *
     * @param idActuador
     * @return
     */
    public Actuador buscarActuadorDeLaRedPorID(String idActuador) {
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            for (Nodo nodo : puertaDeEnlace.getNodos()) {
                for (Actuador actuador : nodo.getActuadores()) {
                    if (actuador.getId().equals(idActuador)) {
                        return actuador;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Metodo para Remover Actuador de la red
     *
     * @param idActuador
     * @return
     */
    public boolean removerActuadorDeLaRed(String idActuador) {
        Actuador actuador = buscarActuadorDeLaRedPorID(idActuador);
        if (actuador != null) {            
            pe:
            for (int i = 0; i < getRed().getPuertasDeEnlace().size(); i++) {
                n:
                for (int j = 0; j < getRed().getPuertasDeEnlace().get(i).getNodos().size(); j++) {
                    if (getRed().getPuertasDeEnlace().get(i).getNodos().get(j).getActuadores().remove(actuador)) {
                        getGestionActuadores().crearActuador(actuador.getId(), actuador.getDescripcion(), false, actuador.getTipo());
                        return true;
                    }
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public boolean guardarRed(String ruta, String nombreArchivo) {
        archivoDeConfiguracionDeRed = new ArchivoDeConfiguracionDeRed(ruta, nombreArchivo, this);
        if (archivoDeConfiguracionDeRed != null) {
            return true;
        } else {
            return false;
        }

    }
}
