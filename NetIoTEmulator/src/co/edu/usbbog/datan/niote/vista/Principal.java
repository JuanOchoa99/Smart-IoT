/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.vista;

import co.edu.usbbog.datan.niote.controlador.hilos.NodoHilo;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class Principal {
    
     public static void main(String[] args) {
         
        Thread hilo = new NodoHilo("Nodo 1");
        Thread hilo2 = new NodoHilo("Nodo 2");
        
        hilo.start();
        hilo2.start();
        
    }
}
