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

    /**
     * Lista para almacenar cada sensor que se cree
     */
    private List<Sensor> sensores;

    /**
     * Constructor para las lista de sensores
     *
     * @param sensores variable que contiene la lista
     */
    public GestionSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    }

    /**
     * Constructor de la clase
     */
    public GestionSensores() {
        this.sensores = new ArrayList<>();
    }

    /**
     * Obtener elementos de la lista
     *
     * @return elementos
     */
    public List<Sensor> getSensores() {
        return sensores;
    }

    /**
     * Poner nuevos valores en la lista
     *
     * @param sensores variable que contiene la lista
     */
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
    /**
     * Metodo para ver todos los sensores creados
     *
     * @return Todos los sensores que existen
     */
    public String verSensores() {

        String salida = "";
        for (Sensor sensore : sensores) {
            salida += salida + sensore.toString();
        }
        return salida;
    }

    /**
     * Ver sensor co un id especifico
     *
     * @param id campo unico con el que se identifica el sensor
     * @return sensor que coincide con el id
     */
    public String verSensorPorID(String id) {
        String salida = "";

        if (existeSensorPorID(id)) {
            for (Sensor sensore : sensores) {
                if (sensore.getId().equals(id)) {
                    salida += salida + sensore.toString();
                }
            }
        } else {

            salida = "El nodo no existe";
        }

        return salida;
    }

    /**
     * Metodo para crear un nuevo sensor
     *
     * @param id campo unico para identificar el sensor
     * @param descripcion descripcion del sensor
     * @param estado activo o inactivo
     * @param tipo tipo de sensor
     * @return se creo o ya existe
     */
    public String crearSensor(String id, String descripcion, boolean estado, String tipo) {
        String salida = "";
        if (existeSensorPorID(id)) {
            salida = "El sensor ya existe";
        } else {
            Sensor sensor = new Sensor(id, descripcion, estado, tipo);
            sensores.add(sensor);
            salida = "El sensor con id " + id + " se agrego";
        }
        return salida;
    }

    /**
     * Metodo para verificar si existe un sensor con id especifico
     *
     * @param id campo unico con el que se identifica el sensor
     * @return true = existe, false = no existe
     */
    public boolean existeSensorPorID(String id) {

        if (sensores.stream().anyMatch((sensore) -> (sensore.getId().equals(id)))) {
            return true;
        }
        return false;
    }

    /**
     * Metodo para buscar un sensor con id especifico
     *
     * @param id campo unico con el que se identifica el sensor
     * @return sensor que coincide con el id
     */
    public Sensor buscarSensorPorID(String id) {

        for (Sensor sensore : sensores) {
            if (sensore.getId().equals(id)) {
                return sensore;
            }
        }
        return null;
    }

    /**
     * Metodo para modificar las especificaciones de un senor
     *
     * @param id campo unico con que el que se identifica el sensor
     * @param descripcion descripcion del sensor
     * @param tipo tipo de sensor
     * @return se modifico o no existe
     */
    public String modificarSensorPorID(String id, String descripcion, String tipo) {

        if (existeSensorPorID(id)) {
            Sensor sensor = buscarSensorPorID(id);
            sensor.setDescripcion(descripcion);
            sensor.setTipo(tipo);
            return "El sensor se modifico";
        } else {
            return "El sensor con ID " + id + " no existe";
        }
    }

    /**
     * Metodo para eliminar un sensor de la lista
     *
     * @param id campo unico con el que se identifica el sensor
     * @return se elimino o no existe
     */
    public String eliminarSensorPorID(String id) {

        if (existeSensorPorID(id)) {

            Sensor sensor = buscarSensorPorID(id);
            sensores.remove(sensor);
            return "El sensor se elimino";
        } else {
            return "El sensor con ID " + id + " no existe";
        }

    }
}
