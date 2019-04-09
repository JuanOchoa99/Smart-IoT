/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.logica;

import co.edu.usbbog.datan.niote.modelo.Actuador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class GestionActuadores {

    private List<Actuador> actuadores;

    public GestionActuadores(List<Actuador> actuadores) {
        this.actuadores = actuadores;
    }

    public GestionActuadores() {
        this.actuadores = new ArrayList<>();
    }

    public List<Actuador> getActuadores() {
        return actuadores;
    }

    public void setActuadores(List<Actuador> actuadores) {
        this.actuadores = actuadores;
    }
    /*
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
    */
    
    public String verActuadores() {
        return "Falta constrir...";
    }

    public String verActuadorPorID(String id) {
        return "Falta constrir...";
    }

    public String crearActuador(String id, String descripcion, boolean estado, String tipo) {
        return "Falta constrir...";
    }

    public boolean existeActuadorPorID(String id) {
        return true;
    }

    public Actuador buscarActuadorPorID(String id) {
        return null;
    }

    public String modificarActuadorPorID(String id, String descripcion, String tipo) {

        return "Falta constrir...";
    }

    public String eliminarActuadorPorID(String id) {
        return "Falta constrir...";
    }
}
