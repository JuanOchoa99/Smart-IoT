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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class GestionRed {

    private Red red;
    private ArchivoDeConfiguracionDeRed archivoDeConfiguracionDeRed;

    //relaciones
    private GestionNodo gestionNodo;
    private GestionActuadores gestionActuadores;
    private GestionSensores gestionSensores;
    private GestionPuertaDeEnlace gestionPuertaDeEnlace;

    public GestionRed(String id, String nombre, String descripcion) {
        this.archivoDeConfiguracionDeRed = new ArchivoDeConfiguracionDeRed();
        this.red = new Red(id, nombre, descripcion);

    }

    public GestionRed(String ruta, String nombreArchivo) {
        this.archivoDeConfiguracionDeRed = new ArchivoDeConfiguracionDeRed(ruta, nombreArchivo);
        this.red = this.archivoDeConfiguracionDeRed.cargarRed();
    }

    public Red getRed() {
        return red;
    }

    public void setRed(Red red) {
        this.red = red;
    }

    public GestionNodo getGestionNodo() {
        return gestionNodo;
    }

    public GestionActuadores getGestionActuadores() {
        return gestionActuadores;
    }

    public GestionSensores getGestionSensores() {
        return gestionSensores;
    }

    public GestionPuertaDeEnlace getGestionPuertaDeEnlace() {
        return gestionPuertaDeEnlace;
    }

    public void agregarPuertasDeEnlace(String id, String descripcion, boolean estado, String direccionLogica, String puertoDeServicio, String protocoloComunicacionExterno) {
        PuertaDeEnlace puertaDeEnlace = new PuertaDeEnlace(id, descripcion, estado, direccionLogica, puertoDeServicio, protocoloComunicacionExterno);
        List<PuertaDeEnlace> puertasDeEnlaceDeLaRed = red.getPuertasDeEnlace();
        puertasDeEnlaceDeLaRed.add(puertaDeEnlace);
        red.setPuertasDeEnlace(puertasDeEnlaceDeLaRed);
    }

    public void verPuertasDeEnlace() {

        List<PuertaDeEnlace> puertasDeEnlaceDeLaRed = red.getPuertasDeEnlace();

        for (PuertaDeEnlace i : puertasDeEnlaceDeLaRed) {

            System.out.println(i.toString());

        }
    }

    public void verNodos() {

        List<PuertaDeEnlace> puertasDeEnlaceDeLaRed = red.getPuertasDeEnlace();

        for (PuertaDeEnlace i : puertasDeEnlaceDeLaRed) {
            List<Nodo> nodos = i.getNodos();
            for (Nodo nodo : nodos) {
                System.out.println(nodo.toString());
            }

        }
    }

    public void verActuador() {

        List<PuertaDeEnlace> puertasDeEnlaceDeLaRed = red.getPuertasDeEnlace();

        for (PuertaDeEnlace puertaDeEnlace : puertasDeEnlaceDeLaRed) {
            List<Nodo> nodos = puertaDeEnlace.getNodos();
            for (Nodo nodo : nodos) {
                List<Actuador> actuadores = nodo.getActuadores();
                for (Actuador actuadore : actuadores) {
                    System.out.println(actuadore.toString());
                }

            }

        }
    }

    public void agregarNodo(String id, String descripcion, boolean estado, String protocoloComunicacion, String gatewayId) {

        List<PuertaDeEnlace> puertasDeEnlaceDeLaRed = red.getPuertasDeEnlace();

        for (PuertaDeEnlace i : puertasDeEnlaceDeLaRed) {
            if (i.getId().equals(gatewayId)) {
                red.getPuertasDeEnlace().remove(i);
                List<Nodo> nodos = new ArrayList<Nodo>();
                Nodo nodo = new Nodo(id, descripcion, estado, protocoloComunicacion);
                nodos.add(nodo);
                i.setNodos(nodos);
                red.getPuertasDeEnlace().add(i);

            }

        }

    }

    public void agregarActuador(String id, String descripcion, boolean estado, String tipo, String nodoId, String gatewayId) {

        List<PuertaDeEnlace> puertasDeEnlaceDeLaRed = red.getPuertasDeEnlace();

        for (PuertaDeEnlace puertaDeEnlace : puertasDeEnlaceDeLaRed) {
            if (puertaDeEnlace.getId().equals(gatewayId)) {
                List<Nodo> nodos = puertaDeEnlace.getNodos();
                for (Nodo nodo : nodos) {
                    if (nodo.getId().equals(nodoId)) {
                        puertaDeEnlace.getNodos().remove(nodo);
                        List<Actuador> actuadores = new ArrayList<>();
                        Actuador actuador = new Actuador(id, descripcion, estado, tipo);
                        actuadores.add(actuador);
                        nodo.setActuadores(actuadores);
                        puertaDeEnlace.getNodos().add(nodo);
                    }

                }
            }

        }
    }

    public void agregarSensor(String id, String descripcion, boolean estado, String tipo, String nodoId, String gatewayId) {

        List<PuertaDeEnlace> puertasDeEnlaceDeLaRed = red.getPuertasDeEnlace();

        for (PuertaDeEnlace puertaDeEnlace : puertasDeEnlaceDeLaRed) {
            if (puertaDeEnlace.getId().equals(gatewayId)) {
                List<Nodo> nodos = puertaDeEnlace.getNodos();
                for (Nodo nodo : nodos) {
                    if (nodo.getId().equals(nodoId)) {
                        puertaDeEnlace.getNodos().remove(nodo);
                        List<Sensor> sensores = new ArrayList<>();
                        Sensor sensor = new Sensor(id, descripcion, estado, tipo);
                        sensores.add(sensor);
                        nodo.setSensores(sensores);
                        puertaDeEnlace.getNodos().add(nodo);
                    }

                }
            }

        }
    }

    public void verSensor() {

        List<PuertaDeEnlace> puertasDeEnlaceDeLaRed = red.getPuertasDeEnlace();

        for (PuertaDeEnlace puertaDeEnlace : puertasDeEnlaceDeLaRed) {
            List<Nodo> nodos = puertaDeEnlace.getNodos();
            for (Nodo nodo : nodos) {
                List<Sensor> sensores = nodo.getSensores();
                for (Sensor sensore : sensores) {
                    System.out.println(sensore.toString());
                }

            }

        }
    }

}
