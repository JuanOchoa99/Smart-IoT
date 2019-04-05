/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.logica;

/**
 *
 * @author 305
 */
public class ValidacionesSistema {

    public boolean estaConfiguradoElSistema() {
        if(configuracionMQTT());
        if(configuracionTCPIP());
        return true;
    }

    private boolean configuracionMQTT() {
        return true;
    }

    private boolean configuracionTCPIP() {
        return true;
    }
    
    
}
