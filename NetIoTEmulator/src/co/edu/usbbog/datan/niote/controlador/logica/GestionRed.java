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
import java.util.ArrayList;
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

    public String verRed() {
        String salida = "";
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
        getGestionPuertaDeEnlace().eliminarPuertaDeEnlacePorID(puertaDeEnlace.getId());
        if (puertaDeEnlace != null) {
            List<PuertaDeEnlace> puertasDeEnlace = getRed().getPuertasDeEnlace();
            for (PuertaDeEnlace pde : puertasDeEnlace) {
                if (pde.getId().equals(puertaDeEnlace.getId())) {
                    return true;
                }
            }
            getRed().getPuertasDeEnlace().add(puertaDeEnlace);
            return true;
        } else {
            return false;
        }
    }

    public String verPuertasDeEnlaceDeLaRed() {
        List<PuertaDeEnlace> puertasDeEnlace = getRed().getPuertasDeEnlace();

        String salida = "";
        for (PuertaDeEnlace puertaDeEnlace : puertasDeEnlace) {
            salida += salida + puertaDeEnlace.toString() + "\n";
        }
        return salida;
    }

    public PuertaDeEnlace buscarPuertaDeEnlaceDeLaRedPorID(String id) {

        List<PuertaDeEnlace> puertasDeEnlace = getRed().getPuertasDeEnlace();

        String salida = "";

        for (PuertaDeEnlace puertaDeEnlace : puertasDeEnlace) {
            if (puertaDeEnlace.getId().equals(id)) {
                return puertaDeEnlace;
            }
        }
        return null;
    }

    public boolean removerPuertaDeEnlaceDeLaRed(String idPuertaDeEnlace) {
        PuertaDeEnlace puertaDeEnlace = buscarPuertaDeEnlaceDeLaRedPorID(idPuertaDeEnlace);

        if (puertaDeEnlace != null) {
            getGestionPuertaDeEnlace().crearPuertaDeEnlace(puertaDeEnlace.getId(), puertaDeEnlace.getDescripcion(), false, puertaDeEnlace.getDireccionLogica(), puertaDeEnlace.getPuertoDeServicio(), puertaDeEnlace.getProtocoloComunicacionExterno());
            getRed().getPuertasDeEnlace().remove(puertaDeEnlace);
            return true;
        } else {
            return false;
        }
    }

    public boolean agregarNodoALaRed(String idNodo, String idPuertasDeEnlace) {
        Nodo nodo = getGestionNodo().buscarNodoPorID(idNodo);
        if (nodo != null) {
            getGestionNodo().eliminarNodoPorID(idNodo);
            List<Nodo> todosLosNodosDeLaRed = new ArrayList<>();
            for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
                todosLosNodosDeLaRed.addAll(puertaDeEnlace.getNodos());
            }
            for (Nodo n : todosLosNodosDeLaRed) {
                if (n.getId().equals(idNodo)) {
                    System.out.println("El nodo ya existe en otra Puerta de Enlace");
                    return true;
                }
            }
            for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
                if (puertaDeEnlace.getId().equals(idPuertasDeEnlace)) {
                    puertaDeEnlace.getNodos().add(nodo);
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }

    }

    public String validarPuertasDeEnlace(String idPuertasDeEnlace) {
        System.out.println(idPuertasDeEnlace);
        String salida = "";

        if (!buscarPuertaDeEnlaceDeLaRedPorID(idPuertasDeEnlace).equals("")) {
            salida = idPuertasDeEnlace;
        }

        System.out.println(salida);
        return salida;
    }

    public String verNodosDeLaRed() {
        List<Nodo> todosLosNodosDeLaRed = new ArrayList<>();
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            todosLosNodosDeLaRed.addAll(puertaDeEnlace.getNodos());
        }

        String salida = "";
        for (Nodo nodo : todosLosNodosDeLaRed) {
            salida += salida + nodo.toString() + "\n";
        }
        return salida;
    }

    public Nodo buscarNodoDeLaRedPorID(String idNodo) {

        List<Nodo> todosLosNodosDeLaRed = new ArrayList<>();
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            todosLosNodosDeLaRed.addAll(puertaDeEnlace.getNodos());
        }

        for (Nodo nodo : todosLosNodosDeLaRed) {
            if (nodo.getId().equals(idNodo)) {
                return nodo;
            }
        }
        return null;
    }

    public boolean removerNodoDeLaRed(String idNodo) {
        return false;
    }

    public boolean guardarRed(String ruta, String nombreArchivo) {
        archivoDeConfiguracionDeRed = new ArchivoDeConfiguracionDeRed(ruta, nombreArchivo, this);
        if (archivoDeConfiguracionDeRed != null) {
            return true;
        } else {
            return false;
        }

    }

    public boolean agregarSensorALaRed(String idSensor, String idNodo) {
        Sensor sensor = getGestionSensores().buscarSensorPorID(idSensor);
        if (sensor != null) {
            getGestionSensores().eliminarSensorPorID(idSensor);
            List<Sensor> todosLosSensoresDeLaRed = new ArrayList<>();
            List<Nodo> todosLosNodosDeLaRed = new ArrayList<>();
            for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
                todosLosNodosDeLaRed.addAll(puertaDeEnlace.getNodos());
            }
            for (Nodo n : todosLosNodosDeLaRed) {
                todosLosSensoresDeLaRed.addAll(n.getSensores());
            }
            for (Sensor s : todosLosSensoresDeLaRed) {
                if (s.getId().equals(idSensor)) {
                    System.out.println("El Sensor ya existe en otro Nodo");
                    return true;
                }
            }
            for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
                for (Nodo n : puertaDeEnlace.getNodos()) {
                    if (n.getId().equals(idNodo)) {
                        n.getSensores().add(sensor);
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public String verSensoresDeLaRed() {

        List<Nodo> todosLosNodosDeLaRed = new ArrayList<>();
        List<Sensor> todosLosSensoresDeLaRed = new ArrayList<>();
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            todosLosNodosDeLaRed.addAll(puertaDeEnlace.getNodos());
        }
        for (Nodo nodo : todosLosNodosDeLaRed) {
            todosLosSensoresDeLaRed.addAll(nodo.getSensores());
        }
        String salida = "";
        for (Sensor sensor : todosLosSensoresDeLaRed) {
            salida += salida + sensor.toString() + "\n";
        }
        return salida;
    }

    public Sensor buscarSensorDeLaRedPorID(String idSensor) {
        List<Sensor> todosLosSensoresDeLaRed = new ArrayList<>();
        List<Nodo> todosLosNodosDeLaRed = new ArrayList<>();
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            todosLosNodosDeLaRed.addAll(puertaDeEnlace.getNodos());
        }
        for (Nodo n : todosLosNodosDeLaRed) {
            todosLosSensoresDeLaRed.addAll(n.getSensores());
        }
        for (Sensor s : todosLosSensoresDeLaRed) {
            if (s.getId().equals(idSensor)) {
                return s;
            }
        }
        return null;
    }

    public boolean removerSensorDeLaRed(String idSensor) {

        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            for (Nodo n : puertaDeEnlace.getNodos()) {
                for (Sensor s : n.getSensores()) {
                    if (s.getId().equals(idSensor)) {
                        n.getSensores().remove(s);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Metodo para ver el Actuador en la red
     *
     * @return
     */
    public String verActuadorDeLaRed() {
        List<Nodo> todosLosNodosDeLaRed = new ArrayList<>();
        List<Actuador> todosLosActuadoresDeLaRed = new ArrayList<>();
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            todosLosNodosDeLaRed.addAll(puertaDeEnlace.getNodos());
        }
        for (Nodo nodo : todosLosNodosDeLaRed) {
            todosLosActuadoresDeLaRed.addAll(nodo.getActuadores());
        }
        String salida = "";
        for (Actuador actuador : todosLosActuadoresDeLaRed) {
            salida += salida + actuador.toString() + "\n";
        }
        return salida;
    }

    /**
     * Metodo para buscar actuador en la red
     *
     * @param idActuador
     * @return
     */
    public Object buscarActuadorDeLaRedPorID(String idActuador) {

        List<Actuador> todosLosActuadoresDeLaRed = new ArrayList<>();
        List<Nodo> todosLosNodosDeLaRed = new ArrayList<>();
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            todosLosNodosDeLaRed.addAll(puertaDeEnlace.getNodos());
        }
        for (Nodo n : todosLosNodosDeLaRed) {
            todosLosActuadoresDeLaRed.addAll(n.getActuadores());
        }
        for (Actuador a : todosLosActuadoresDeLaRed) {
            if (a.getId().equals(idActuador)) {
                return a;
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

        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            for (Nodo n : puertaDeEnlace.getNodos()) {
                for (Actuador a : n.getActuadores()) {
                    if (a.getId().equals(idActuador)) {
                        n.getActuadores().remove(a);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
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
            getGestionSensores().eliminarSensorPorID(idActuador);
            List<Actuador> todosLosActuadoresDeLaRed = new ArrayList<>();
            List<Nodo> todosLosNodosDeLaRed = new ArrayList<>();
            for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
                todosLosNodosDeLaRed.addAll(puertaDeEnlace.getNodos());
            }
            for (Nodo n : todosLosNodosDeLaRed) {
                todosLosActuadoresDeLaRed.addAll(n.getActuadores());
            }
            for (Actuador a : todosLosActuadoresDeLaRed) {
                if (a.getId().equals(idActuador)) {
                    System.out.println("El Actuador ya existe en otro Nodo");
                    return true;
                }
            }
            for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
                for (Nodo n : puertaDeEnlace.getNodos()) {
                    if (n.getId().equals(idNodo)) {
                        n.getActuadores().add(actuador);
                        return true;
                    }
                }
            }

        }
        return false;
    }

}
