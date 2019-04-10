/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.logica;

import co.edu.usbbog.datan.niote.modelo.PuertaDeEnlace;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class GestionPuertasDeEnlace {

    private List<PuertaDeEnlace> puertasDeEnlace;

    public GestionPuertasDeEnlace(List<PuertaDeEnlace> puertasDeEnlace) {
        this.puertasDeEnlace = puertasDeEnlace;
    }

    public GestionPuertasDeEnlace() {
        this.puertasDeEnlace = new ArrayList<>();
    }

    public List<PuertaDeEnlace> getPuertasDeEnlace() {
        return puertasDeEnlace;
    }

    public void setPuertasDeEnlace(List<PuertaDeEnlace> puertasDeEnlace) {
        this.puertasDeEnlace = puertasDeEnlace;
    }

    public String verPuertasDeEnlace() {
        String salida = "";
        for (PuertaDeEnlace puertaDeEnlace : puertasDeEnlace) {
            salida += salida + puertaDeEnlace.toString() + "\n";
        }
        return salida;
    }

    public String verPuertaDeEnlacePorID(String id) {
        String salida = "";
        if (existePuertaDeEnlacePorID(id)) {
            for (PuertaDeEnlace puertaDeEnlace : puertasDeEnlace) {
                if (puertaDeEnlace.getId().equals(id)) {
                    salida = puertaDeEnlace.toString() + "\n";
                }
            }
        } else {
            salida = "no existe la puerta de enlace";
        }
        return salida;
    }

    public String crearPuertaDeEnlace(String id, String descripcion, boolean estado, String direccionLogica, String puertoDeServicio, String protocoloComunicacionExterno) {
        PuertaDeEnlace puertaDeEnlace = new PuertaDeEnlace(id, descripcion, estado, direccionLogica, puertoDeServicio, protocoloComunicacionExterno);
        if (existePuertaDeEnlacePorID(id)) {
            return "la puerta de enlace ya existe";
        } else {
            puertasDeEnlace.add(puertaDeEnlace);
            return "la puerta de enlace con ID: " + id + " se agrego";
        }
    }

    public String eliminarPuertaDeEnlacePorID(String id) {
        if (existePuertaDeEnlacePorID(id)) {
            PuertaDeEnlace puertaDeEnlace = buscarPuertaDeEnlacePorID(id);
            puertasDeEnlace.remove(puertaDeEnlace);
            return "la puerta de enlace se elimino";
        } else {
            return "la puerta de enlace con ID: " + id + " no se elimino";
        }
    }

    public boolean existePuertaDeEnlacePorID(String id) {
        return true;
    }

    public PuertaDeEnlace buscarPuertaDeEnlacePorID(String id) {
        return null;
    }

    public String modificarPuertaDeEnlacePorID(String id, String descripcion, String direccionLogica, String puertoDeServicio, String protocoloComunicacionExterno) {
        return "Falta constrir...";
    }

}
