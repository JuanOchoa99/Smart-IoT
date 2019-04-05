/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.vista;

import co.edu.usbbog.datan.niote.controlador.logica.GestionRed;
import java.util.Scanner;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class Terminal {
    //Atributos
    Scanner sn = new Scanner(System.in);
    
    //relacion
    private Principal principal;

    public Terminal(Principal principal) {
        this.principal = principal;
        menuInicial();
    }
    
    public void menuInicial(){
        if(principal.getValidacionesSistema().estaConfiguradoElSistema()){
            System.out.println("***Bienvenido a Net IoT Emulator***");
            System.out.println("0. para salir");
            System.out.println("1. para iniciar red");
            int opc = sn.nextInt();
            switch(opc){
                case 0:
                    System.out.println("Vuelva Pronto");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("ingrese ID unico de la red");
                    String id=sn.next();
                    System.out.println("ingrese nombre de la red");
                    String nombre=sn.next();
                    System.out.println("ingrese la descripcion de la red");
                    String descripcion=sn.next();                    
                    this.principal.iniciarRed(id, nombre, descripcion);
                    menuPrincipal();
                    break;
            }
            
        }else{
            System.out.println("***Net IoT Emulator necesita el Broker de Mosquitto-MQTT y los puerto 9998 y 9999 para funcionar");
            System.out.println("Verifique que Mosquitto-MQTT y TCP/IP esten instalados y configurados");
            System.out.println("Verifique que Mosquitto-MQTT esta corriendo en el puerto 1883");
            System.out.println("Verifique que los puertos 9998 y 9999 estan disponible y agregados al firewall");
            System.exit(0);
        }   
    }
    
    
    private void menuPrincipal() {
        int opc = -1;
        do{
            System.out.println("Net IoT Emulator");
            System.out.println("Red: "+this.principal.getGestionRed().getRed().getId()
            +" - "+ this.principal.getGestionRed().getRed().getNombre()
            +" - "+ this.principal.getGestionRed().getRed().getDescripcion());
            System.out.println("0. para salir");
            System.out.println("1. para reiniciar red");
            System.out.println("2. para configurar la red");
            
            opc=1;
        }while(opc!=1);
        menuInicial();
        
    }

    public void inicio() {


        this.principal.getGestionRed().agregarPuertasDeEnlace("1001", "nueva gateway", true, "dos", "1000", "MW");

        this.principal.getGestionRed().agregarNodo("n-1", "nodo prueba", true, "blouetooth", "1001");

        this.principal.getGestionRed().agregarActuador("a-1", "actuador prueba", true, "tipo1", "n-1", "1001");

        this.principal.getGestionRed().agregarSensor("s-1", "sensor prueba", true, "tipo 1", "n-1", "1001");

        int menu = 1;
        int opcion;
        int idPuertaDeEnlace = 0, idNodo = 0, idSensor = 0, idActuador = 0;
        String idGateway;
        while (menu == 1) {
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

                    this.principal.getGestionRed().verPuertasDeEnlace();
                    break;

                case 2:

                    this.principal.getGestionRed().verNodos();
                    break;

                case 3:

                    this.principal.getGestionRed().verSensor();
                    break;
                case 4:

                    this.principal.getGestionRed().verActuador();
                    break;
                case 5:

                    System.out.println("Digite descripcion");
                    String descripcion = sn.next();

                    System.out.println("Digite estado (true/false)");
                    boolean estado = sn.nextBoolean();

                    System.out.println("Digiste direccion logica");
                    String direccionLogica = sn.next();

                    System.out.println("Digite Puerto de Servicio");
                    String puertoDeServicio = sn.next();

                    System.out.println("Digite protocolo de comunicacion externo");
                    String protocoloDeComunicacionExterno = sn.next();

                    this.principal.getGestionRed().agregarPuertasDeEnlace("" + idPuertaDeEnlace, "" + descripcion, estado, "" + direccionLogica, "" + puertoDeServicio, "" + protocoloDeComunicacionExterno);
                    idPuertaDeEnlace++;

                    break;

                case 6:

                    System.out.println("Digite descripcion");
                    String descripcionNodo = sn.next();

                    System.out.println("Digite estado (true/false)");
                    boolean estadoNodo = sn.nextBoolean();

                    System.out.println("Digiste direccion logica");
                    String protocoloComunicacion = sn.next();

                    System.out.println("Digiste id del gateway");
                    idGateway = sn.next();

                    this.principal.getGestionRed().agregarNodo("" + idNodo, "" + descripcionNodo, estadoNodo, "" + protocoloComunicacion, "" + idGateway);
                    idNodo++;
                    break;
                case 7:

                    System.out.println("Digite descripcion");
                    String descripcionSensor = sn.next();

                    System.out.println("Digite estado (true/false)");
                    boolean estadoSensor = sn.nextBoolean();

                    System.out.println("Digiste tipo");
                    String tipoSensor = sn.next();

                    System.out.println("Digiste id del gateway");
                    idGateway = sn.next();

                    System.out.println("Digiste id del nodo");
                    String idNodoSensor = sn.next();

                    this.principal.getGestionRed().agregarSensor("" + idSensor, "" + descripcionSensor, estadoSensor, "" + tipoSensor, "" + idGateway, "" + idNodoSensor);
                    idSensor++;
                    break;

                case 8:

                    System.out.println("Digite descripcion");
                    String descripcionActuador = sn.next();

                    System.out.println("Digite estado (true/false)");
                    boolean estadoActuador = sn.nextBoolean();

                    System.out.println("Digiste tipo");
                    String tipoActuador = sn.next();

                    System.out.println("Digiste id del gateway");
                    idGateway = sn.next();

                    System.out.println("Digiste id del nodo");
                    String idNodoActuador = sn.next();

                    this.principal.getGestionRed().agregarActuador("" + idActuador, "" + descripcionActuador, estadoActuador, "" + tipoActuador, "" + idGateway, "" + idNodoActuador);
                    idActuador++;
                    break;

                default:
                    menu = 0;
                    break;

            }
        }

    }

}
