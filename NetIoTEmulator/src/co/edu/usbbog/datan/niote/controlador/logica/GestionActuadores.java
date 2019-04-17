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
       String salida = "";
        for (Actuador actuador : actuadores) {
            salida += salida + actuador.toString() + "\n";
        }
        return salida;
    }

    public String verActuadorPorID(String id) {
        String salida = "";
        if (existeActuadorPorID(id)) {
            for (Actuador actuador : actuadores) {
                if (actuador.getId().equals(id)) {
                    salida = actuador.toString() + "\n";
                }
            }
        } else {
            salida = "No existe el actuador";
        }
        return salida;
    }

    public String crearActuador(String id, String descripcion, boolean estado, String tipo) {
        Actuador actuador = new Actuador(id, descripcion, estado, tipo);
        if (existeActuadorPorID(id)) {
            return "El actuador ya existe";
        } else {
            actuadores.add(actuador);
            return "El actuador con ID: " + id + " se agrego";
        }
    }

    public boolean existeActuadorPorID(String id) {
        for (Actuador actuador : actuadores) {
            if (actuador.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public Actuador buscarActuadorPorID(String id) {
        for (Actuador actuador : actuadores) {
            if (actuador.getId().equals(id)) {
                return actuador;
            }
        }
        return null;
    }

    public String modificarActuadorPorID(String id, String descripcion, String tipo) {

        if (buscarActuadorPorID(id) == null) {
            return "El actuador no existe";
        } else {
            Actuador modificarActuador = buscarActuadorPorID(id);
            modificarActuador.setDescripcion(descripcion);
            modificarActuador.setTipo(tipo);
            return "El actuador con ID " + id + " se ha modificado";
        }
    }

    public String eliminarActuadorPorID(String id) {
        if (existeActuadorPorID(id)) {
            Actuador actuador = buscarActuadorPorID(id);
            actuadores.remove(actuador);
            return "El actuador se elimino";
        } else {
            return "El actuador con ID: " + id + " no se elimino";
        }
    }
}
