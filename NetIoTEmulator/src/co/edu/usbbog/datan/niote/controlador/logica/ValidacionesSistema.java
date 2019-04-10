/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.logica;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class ValidacionesSistema {

    public ValidacionesSistema() {
    }

    /**
     *
     * @return
     */
    public boolean estaConfiguradoElSistema() {
        if (configuracionMQTT());
        if (configuracionTCPIP());
        System.out.println("Falta constrir...");
        return true;
    }

    /**
     *
     * @return
     */
    private boolean configuracionMQTT() {
        System.out.println("Falta constrir...");
        return true;
    }

    /**
     *
     * @return
     */
    private boolean configuracionTCPIP() {
        System.out.println("Falta constrir...");
        return true;
    }

}
