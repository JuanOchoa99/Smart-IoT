/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.vista;

import co.edu.usbbog.datan.niote.controlador.hilos.NodoHilo;
import co.edu.usbbog.datan.niote.controlador.logica.GestionRed;
import java.util.Scanner;

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
         
         Scanner sn = new Scanner(System.in);
         Scanner datosPE = new Scanner(System.in);
       
         GestionRed gr = new GestionRed("1", "dsds", "hola");
         
         gr.agregarPuertasDeEnlace("1001", "nueva gateway", true, "dos", "1000", "MW");
         
         gr.agregarNodo("n-1","nodo prueba", true, "blouetooth","1001");
         
         gr.agregarActuador("a-1", "actuador prueba", true, "tipo1", "n-1", "1001");
         
         gr.agregarSensor("s-1", "sensor prueba", true, "tipo 1", "n-1", "1001");
        
        
         int menu=1;
         int opcion;
         int idPuertaDeEnlace=0, idNodo=0, idSensor=0, idActuador=0;
         while(menu==1){
         System.out.println("Menu: \n"
                 + "1. Ver gateway \n"
                 + "2. Ver nodos \n"
                 + "3. Ver Sensores \n"
                 + "4. Ver actuadores \n"
                 + "5. Crear gateway \n"
                 + "6. Crear nodo \n"
                 + "7. Crear sensor \n"
                 + "8. Crear Actuador \n");
         
         opcion = sn.nextInt();
             switch (opcion) {

                 case 1:
                     
                     gr.verPuertasDeEnlace();
                     break;
                     
                 case 2:
                     
                     gr.verNodos();
                     break;
                     
                 case 3:
                     
                     gr.verSensor();
                     break;
                 case 4:
                     
                     gr.verActuador();
                     break;
                 case 5:
                     
                      
                      System.out.println("Digite descripcion");
                      String descripcion =  sn.next();
                      
                      System.out.println("Digite estado (true/false)"); 
                      boolean estado = sn.nextBoolean();
                      
                      System.out.println("Digiste direccion logica");
                      String direccionLogica = sn.next();
                      
                      System.out.println("Digite Puerto de Servicio");
                      String puertoDeServicio = sn.next();
                      
                      System.out.println("Digite protocolo de comunicacion externo");
                      String protocoloDeComunicacionExterno = sn.next() ;
                     
                      gr.agregarPuertasDeEnlace(""+idPuertaDeEnlace, ""+descripcion, estado, ""+direccionLogica, ""+puertoDeServicio, ""+protocoloDeComunicacionExterno);
                      idPuertaDeEnlace ++; 
                      
                      break;

                 default:
                     menu=0;
                     break;

             }
         
     }
         
         
    }
}
