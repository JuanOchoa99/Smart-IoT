/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.logica;

import co.edu.usbbog.datan.niote.modelo.PuertaDeEnlace;
import co.edu.usbbog.datan.niote.modelo.Red;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class GestionRed {
    private Red red;

    public GestionRed(String id, String nombre, String descripcion) {
        this.red = new Red(id, nombre, descripcion);
        this.red.setPuertasDeEnlace(new ArrayList<PuertaDeEnlace>());
    }
    
    public void agregarPuertasDeEnlace(String id, String descripcion, boolean estado, String direccionLogica, String puertoDeServicio, String protocoloComunicacionExterno){
        PuertaDeEnlace puertaDeEnlace = new PuertaDeEnlace(id, descripcion, estado, direccionLogica, puertoDeServicio, protocoloComunicacionExterno);
        List<PuertaDeEnlace> puertasDeEnlaceDeLaRed = red.getPuertasDeEnlace();
        puertasDeEnlaceDeLaRed.add(puertaDeEnlace);
        red.setPuertasDeEnlace(puertasDeEnlaceDeLaRed);
    }
    
   // public ArrayList<PuertaDeEnlace> verPuertasDeEnlace(){
        
    //}

    
    
}
