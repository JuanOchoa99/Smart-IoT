/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.logica;

import co.edu.usbbog.datan.niote.modelo.Sensor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class GestionSensores {

    private List<Sensor> sensores;

    public GestionSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    }

    public GestionSensores() {
        this.sensores = new ArrayList<>();
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public void setSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    }
    
    /*
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
    */

}
