/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.logica;

import co.edu.usbbog.datan.niote.modelo.Actuador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva.
 */
public class GestionActuadores implements Serializable{

    /**
     * Variable para guardar la lista de actuadores
     */
    private List<Actuador> actuadores;

    /**
     *Metodo para modificar la lista de actuadores
     * @param actuadores lista de actuadores que van a modificar
     */
    public GestionActuadores(List<Actuador> actuadores) {
        this.actuadores = actuadores;
    }

    /**
     *Metodo constructor de la clase GestionActuadores
     */
    public GestionActuadores() {
        this.actuadores = new ArrayList<>();
    }

    /**
     *Metodo para obtener la lista de actuadores
     * @return toda la lista de actuadores guardados
     */
    public List<Actuador> getActuadores() {
        return actuadores;
    }

    /**
     *Metodo colocar la datos dentro de la variable actuadores
     * @param actuadores lista de actuadores que se tienen
     */
    public void setActuadores(List<Actuador> actuadores) {
        this.actuadores = actuadores;
    }

    /**
     *Metodo para ver todos los actuadores que estan creados
     * @return retorna un string que visualiza los actuadores creados
     */
    public String verActuadores() {
        String salida = "";
        for (Actuador actuador : actuadores) {
            salida += salida + actuador.toString() + "\n";
        }
        return salida;
    }

    /**
     * Meotodo para ver un actuador por su id
     *
     * @param id el id del actuador que se quiere ver
     * @return retornamos un string visualizando el actuador, sino se confirma
     * que no existe el actuador
     */
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

    /**
     * Metdod para la creación de un nuevo Actuador
     *
     * @param id codigo de identificación para el actuador
     * @param descripcion información del actuador
     * @param estado si el actuador esta activo o desactivado
     * @param tipo nos especifica que tipo de actuador es
     * @return retorna un string confirmando que el actuador ya existe y por
     * ende no se puee crear, sino confirma que se creo el Actuador
     */
    public String crearActuador(String id, String descripcion, boolean estado, String tipo) {
        Actuador actuador = new Actuador(id, descripcion, estado, tipo);
        if (existeActuadorPorID(id)) {
            return "El actuador ya existe";
        } else {
            actuadores.add(actuador);
            return "El actuador con ID: " + id + " se agrego";
        }
    }

    /**
     * Metodo para confirmar si un objeto Actuador existe
     *
     * @param id buscamos por el id si el objeto Actuador existe
     * @return retornamos un booleano si existe true, sino false
     */
    public boolean existeActuadorPorID(String id) {
        return actuadores.stream().anyMatch((actuador) -> (actuador.getId().equals(id)));
    }

    /**
     * Metodo para buscar un actuador por su id
     *
     * @param id es el id que se va a buscar en nuestra lista de actuadores
     * @return retorna un objeto Actuador, sino encuentra por el id, confirmamos
     * que no existe ese objeto con ese id
     */
    public Actuador buscarActuadorPorID(String id) {
        for (Actuador actuador : actuadores) {
            if (actuador.getId().equals(id)) {
                return actuador;
            }
        }
        return null;
    }

    /**
     * Metodo para la modificacion de un actuador por su id
     *
     * @param id id del actuador que se va a modificar
     * @param descripcion la nueva descripcion que ca a tener el actuador a
     * modificar
     * @param tipo el nuevo tipo que va a tener el actuador a modificar
     * @return si el actuador no existe, devolvemos un string confirmando que no
     * existe, sino modificamos el actuador y confirmamos que se realizaron los
     * cambios
     */
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

    /**
     * Metodo para la eliminación de ua actuador por su id
     *
     * @param idActuador del actuador que se va a eliminar
     * @return Si se elimino el actuador se confirma por medio de un string,
     * sino se confirma que no se elimino
     */
    public String eliminarActuadorPorID(String idActuador) {
        if (existeActuadorPorID(idActuador)) {
            Actuador actuador = buscarActuadorPorID(idActuador);
            actuadores.remove(actuador);
            return "El actuador se elimino";
        } else {
            return "El actuador con ID: " + idActuador + " no se elimino";
        }
    }
}
