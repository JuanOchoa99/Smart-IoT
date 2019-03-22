/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.vista;

import co.edu.usbbog.datan.niote.controlador.hilos.NodoHilo;
import co.edu.usbbog.datan.niote.controlador.logica.GestionRed;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class Principal {
    
     public static void main(String[] args) {
         /**
          *  Thread hilo = new NodoHilo("Nodo 1");
        Thread hilo2 = new NodoHilo("Nodo 2");
        gr.agregarPuertasDeEnlace("1001", "nueva gateway", true, "dos", "1000", "MW");
         gr.verPuertasDeEnlace();
        hilo.start();
        hilo2.start();
          */
       
        
         GestionRed gr = new GestionRed("1", "dsds", "hola");
         gr.agregarPuertasDeEnlace("1001", "nueva gateway", true, "dos", "1000", "MW");
         gr.verPuertasDeEnlace();
         
         gr.agregarNodo("n-1","nodo prueba", true, "blouetooth","1001");
         gr.verNodos();
         gr.agregarActuador("a-1", "actuador prueba", true, "tipo1", "n-1", "1001");
         gr.verActuador();
         
         
    }
}
