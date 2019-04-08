/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.vista;

import java.util.Scanner;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class Terminal {

    //Atributos
    /**
     *
     */
    Scanner sn = new Scanner(System.in);

    //relaciones
    /**
     *
     */
    private Principal principal;

    /**
     *
     * @param principal
     */
    public Terminal(Principal principal) {
        this.principal = principal;
        menuInicial();
    }

    /**
     *
     */
    public void menuInicial() {
        if (principal.getValidacionesSistema().estaConfiguradoElSistema()) {
            System.out.println("***Bienvenido a Net IoT Emulator***");
            System.out.println("------------------------------------------------");
            System.out.println("------------------Menu Inicial------------------");
            System.out.println("------------------------------------------------");
            System.out.println("0. para salir");
            System.out.println("1. para crear red");
            System.out.println("2. cargar una configuracion previa de red e iniciar");
            int opc = sn.nextInt();
            switch (opc) {
                case 0:
                    System.out.println("Vuelva Pronto");
                    System.exit(0);
                    break;
                case 1:
                    if (crearRed()) {
                        menuPrincipal();
                    } else {
                        menuInicial();
                    }
                    break;
                case 2:
                    if (cargarRed()) {
                        menuPrincipal();
                    } else {
                        menuInicial();
                    }
                    break;
                default:
                    System.out.println("opcion no valida");
                    menuInicial();
                    break;
            }
        } else {
            System.out.println("***Net IoT Emulator necesita el Broker de Mosquitto-MQTT y los puerto 9998 y 9999 para funcionar");
            System.out.println("Verifique que Mosquitto-MQTT y TCP/IP esten instalados y configurados");
            System.out.println("Verifique que Mosquitto-MQTT esta corriendo en el puerto 1883 y agregado al firewall");
            System.out.println("Verifique que los puertos 9998 y 9999 estan disponible y agregados al firewall");
            System.exit(0);
        }
    }

    /**
     *
     * @return
     */
    private boolean crearRed() {
        System.out.println("ingrese ID unico de la red");
        String id = sn.next();
        System.out.println("ingrese nombre de la red");
        String nombre = sn.next();
        System.out.println("ingrese la descripcion de la red");
        String descripcion = sn.next();
        if (this.principal.crearRed(id, nombre, descripcion)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return
     */
    private boolean cargarRed() {
        System.out.println("ingrese la ruta absoluta donde se encuentra el archivo de configuracion");
        String ruta = sn.next();
        System.out.println("ingrese nombre del archivo de configuracion (.niote)");
        String nombreArchivo = sn.next();
        if (this.principal.cargarRed(ruta, nombreArchivo)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     */
    private void menuPrincipal() {
        int opc = -1;
        do {
            System.out.println("Net IoT Emulator");
            System.out.println("Red: " + this.principal.getGestionRed().getRed().getId()
                    + " - " + this.principal.getGestionRed().getRed().getNombre()
                    + " - " + this.principal.getGestionRed().getRed().getDescripcion());
            System.out.println("------------------------------------------------");
            System.out.println("-----------------Menu Principal-----------------");
            System.out.println("------------------------------------------------");
            System.out.println("0. para salir");
            System.out.println("1. para borrar y reiniciar la red");
            System.out.println("2. para configurar la red");
            System.out.println("3. para controlar la red");
            opc = sn.nextInt();
            switch (opc) {
                case 0:
                    System.out.println("Vuelva Pronto (no se guardo la configuracion de la red)");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Cerrando la red...");
                    System.out.println("no se guardo la configuracion de la red");
                    break;
                case 2:
                    menuConfiguracion();
                    break;
                case 3:
                    menuControl();
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (opc != 1);
        menuInicial();
    }

    /**
     *
     */
    private void menuConfiguracion() {
        int opc = -1;
        do {
            System.out.println("Net IoT Emulator");
            System.out.println("Red: " + this.principal.getGestionRed().getRed().getId()
                    + " - " + this.principal.getGestionRed().getRed().getNombre()
                    + " - " + this.principal.getGestionRed().getRed().getDescripcion());
            System.out.println("------------------------------------------------");
            System.out.println("--------------Configuracion de Red--------------");
            System.out.println("------------------------------------------------");
            System.out.println("0. para volver al menu anterior");
            System.out.println("1. para configurar Puertas de Enlace");
            System.out.println("2. para configurar Nodos");
            System.out.println("3. para configurar Sensores");
            System.out.println("4. para configurar Actuadores");
            System.out.println("5. para construir la red");
            System.out.println("6. para guardar la red");
            opc = sn.nextInt();
            switch (opc) {
                case 0:
                    System.out.println("Cerrando Configuracion de Red...");
                    break;
                case 1:
                    menuConfiguracionPuertasDeEnlace();
                    break;
                case 2:
                    menuConfiguracionNodos();
                    break;
                case 3:
                    menuConfiguracionSensores();
                    break;
                case 4:
                    menuConfiguracionActuadores();
                    break;
                case 5:
                    menuConstruirRed();
                    break;
                case 6:
                    guardarRed();
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (opc != 0);
    }

    /**
     *
     */
    private void menuConfiguracionPuertasDeEnlace() {
        int opc = -1;
        do {
            System.out.println("Net IoT Emulator");
            System.out.println("Red: " + this.principal.getGestionRed().getRed().getId()
                    + " - " + this.principal.getGestionRed().getRed().getNombre()
                    + " - " + this.principal.getGestionRed().getRed().getDescripcion());
            System.out.println("------------------------------------------------");
            System.out.println("---------Configuracion Puerta de Enlace---------");
            System.out.println("------------------------------------------------");
            System.out.println("0. para volver al menu anterior");
            System.out.println("1. para ver todas las Puertas de Enlace");
            System.out.println("2. para ver Puerta de Enlace por ID");
            System.out.println("3. para crear Puerta de Enlace");
            System.out.println("4. para modificar Puerta de Enlace por ID");
            System.out.println("5. para eliminar Puerta de Enlace por ID");
            opc = sn.nextInt();

            switch (opc) {
                case 0:
                    System.out.println("Cerrando Configuracion Puerta de Enlace...");
                    break;
                case 1:
                    verPuertasDeEnlace();
                    break;
                case 2:
                    verPuertaDeEnlacePorID();
                    break;
                case 3:
                    crearPuertaDeEnlace();
                    break;
                case 4:
                    modificarPuertaDeEnlacePorID();
                    break;
                case 5:
                    eliminarPuertaDeEnlacePorID();
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (opc != 0);
    }

    /**
     *
     */
    private void verPuertasDeEnlace() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void verPuertaDeEnlacePorID() {
        System.out.println("Digite ID de la Puerta de enlace");
        String id = sn.next();
        System.out.println("Falta constrir...");
        //
    }

    /**
     *
     */
    private void crearPuertaDeEnlace() {
        String id;
        String descripcion;
        boolean estado;
        String direccionLogica;
        String puertoDeServicio;
        String protocoloComunicacionExterno;
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void modificarPuertaDeEnlacePorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void eliminarPuertaDeEnlacePorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void menuConfiguracionNodos() {
        int opc = -1;
        do {
            System.out.println("Net IoT Emulator");
            System.out.println("Red: " + this.principal.getGestionRed().getRed().getId()
                    + " - " + this.principal.getGestionRed().getRed().getNombre()
                    + " - " + this.principal.getGestionRed().getRed().getDescripcion());
            System.out.println("------------------------------------------------");
            System.out.println("--------------Configuracion  Nodos--------------");
            System.out.println("------------------------------------------------");
            System.out.println("0. para volver al menu anterior");
            System.out.println("1. para ver todos los Nodos");
            System.out.println("2. para ver Nodo por ID");
            System.out.println("3. para crear Nodo");
            System.out.println("4. para modificar Nodo por ID");
            System.out.println("5. para eliminar Nodo por ID");
            opc = sn.nextInt();
            switch (opc) {
                case 0:
                    System.out.println("Cerrando Configuracion Nodos...");
                    break;
                case 1:
                    verNodos();
                    break;
                case 2:
                    verNodoPorID();
                    break;
                case 3:
                    crearNodo();
                    break;
                case 4:
                    modificarNodoPorID();
                    break;
                case 5:
                    eliminarNodoPorID();
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (opc != 0);
    }

    /**
     *
     */
    private void verNodos() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void verNodoPorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void crearNodo() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void modificarNodoPorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void eliminarNodoPorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void menuConfiguracionSensores() {
        int opc = -1;
        do {
            System.out.println("Net IoT Emulator");
            System.out.println("Red: " + this.principal.getGestionRed().getRed().getId()
                    + " - " + this.principal.getGestionRed().getRed().getNombre()
                    + " - " + this.principal.getGestionRed().getRed().getDescripcion());
            System.out.println("------------------------------------------------");
            System.out.println("-------------Configuracion Sensores-------------");
            System.out.println("------------------------------------------------");
            System.out.println("0. para volver al menu anterior");
            System.out.println("1. para ver todos los Sensores");
            System.out.println("2. para ver Sensor por ID");
            System.out.println("3. para crear Sensor");
            System.out.println("4. para modificar Sensor por ID");
            System.out.println("5. para eliminar Sensor por ID");
            opc = sn.nextInt();
            switch (opc) {
                case 0:
                    System.out.println("Cerrando Configuracion Sensores...");
                    break;
                case 1:
                    verSensores();
                    break;
                case 2:
                    verSensorPorID();
                    break;
                case 3:
                    crearSensor();
                    break;
                case 4:
                    modificarSensorPorID();
                    break;
                case 5:
                    eliminarSensorPorID();
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (opc != 0);
    }

    /**
     *
     */
    private void verSensores() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void verSensorPorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void crearSensor() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void modificarSensorPorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void eliminarSensorPorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void menuConfiguracionActuadores() {
        int opc = -1;
        do {
            System.out.println("Net IoT Emulator");
            System.out.println("Red: " + this.principal.getGestionRed().getRed().getId()
                    + " - " + this.principal.getGestionRed().getRed().getNombre()
                    + " - " + this.principal.getGestionRed().getRed().getDescripcion());
            System.out.println("------------------------------------------------");
            System.out.println("------------Configuracion Actuadores------------");
            System.out.println("------------------------------------------------");
            System.out.println("0. para volver al menu anterior");
            System.out.println("1. para ver todos los Actuadores");
            System.out.println("2. para ver Actuador por ID");
            System.out.println("3. para crear Actuador");
            System.out.println("4. para modificar Actuador por ID");
            System.out.println("5. para eliminar Actuador por ID");
            opc = sn.nextInt();
            switch (opc) {
                case 0:
                    System.out.println("Cerrando Configuracion Actuadores...");
                    break;
                case 1:
                    verActuadores();
                    break;
                case 2:
                    verActuadorPorID();
                    break;
                case 3:
                    crearActuador();
                    break;
                case 4:
                    modificarActuadorPorID();
                    break;
                case 5:
                    eliminarActuadorPorID();
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (opc != 0);
    }

    /**
     *
     */
    private void verActuadores() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void verActuadorPorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void crearActuador() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void modificarActuadorPorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void eliminarActuadorPorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void menuConstruirRed() {
        int opc = -1;
        do {
            System.out.println("Net IoT Emulator");
            System.out.println("Red: " + this.principal.getGestionRed().getRed().getId()
                    + " - " + this.principal.getGestionRed().getRed().getNombre()
                    + " - " + this.principal.getGestionRed().getRed().getDescripcion());
            System.out.println("------------------------------------------------");
            System.out.println("------------------Contruir Red------------------");
            System.out.println("------------------------------------------------");
            System.out.println("0. para volver al menu anterior");
            System.out.println("1. para ver red");
            System.out.println("2. para agregar Puerta de Enlace a la Red");
            System.out.println("3. para remover Puerta de Enlace de la Red");
            System.out.println("4. para agregar Nodo a la Red");
            System.out.println("5. para remover Nodo de la Red");
            System.out.println("6. para agregar Sensor a la Red");
            System.out.println("7. para remover Sensor de la Red");
            System.out.println("8. para agregar Actuador a la Red");
            System.out.println("9. para remover Actuador de la Red");
            opc = sn.nextInt();
            switch (opc) {
                case 0:
                    System.out.println("Cerrando Contruir Red...");
                    break;
                case 1:
                    verConstruccionDeRed();
                    break;
                case 2:
                    agregarPuertaDeEnlaceALaRed();
                    break;
                case 3:
                    removerPuertaDeEnlaceDeLaRed();
                    break;
                case 4:
                    agregarNodoALaRed();
                    break;
                case 5:
                    removerNodoDeLaRed();
                    break;
                case 6:
                    agregarSensorALaRed();
                    break;
                case 7:
                    removerSensorDeLaRed();
                    break;
                case 8:
                    agregarActuadorALaRed();
                    break;
                case 9:
                    removerActuadorDeLaRed();
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (opc != 0);
    }

    /**
     *
     */
    private void verConstruccionDeRed() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void agregarPuertaDeEnlaceALaRed() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void removerPuertaDeEnlaceDeLaRed() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void agregarNodoALaRed() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void removerNodoDeLaRed() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void agregarSensorALaRed() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void removerSensorDeLaRed() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void agregarActuadorALaRed() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void removerActuadorDeLaRed() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void guardarRed() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void menuControl() {
        int opc = -1;
        do {
            System.out.println("Net IoT Emulator");
            System.out.println("Red: " + this.principal.getGestionRed().getRed().getId()
                    + " - " + this.principal.getGestionRed().getRed().getNombre()
                    + " - " + this.principal.getGestionRed().getRed().getDescripcion());
            System.out.println("------------------------------------------------");
            System.out.println("-----------------Control de Red-----------------");
            System.out.println("------------------------------------------------");
            System.out.println("0. para volver al menu anterior");
            System.out.println("1. para ver el estado de la red");
            System.out.println("2. para ver la red en ejecucion");
            System.out.println("3. para iniciar la red");
            System.out.println("4. para detener la red");
            System.out.println("5. para controlar Puertas de Enlace");
            System.out.println("6. para controlar Nodos");
            System.out.println("7. para controlar Sensores");
            System.out.println("8. para controlar Actuadores");
            opc = sn.nextInt();
            switch (opc) {
                case 0:
                    System.out.println("Cerrando Control de Red...");
                    break;
                case 1:
                    verEstadoDeLaRed();
                    break;
                case 2:
                    verEjecucionDeLaRed();
                    break;
                case 3:
                    iniciarRed();
                    break;
                case 4:
                    detenerRed();
                    break;
                case 5:
                    menuControlPuertasDeEnlace();
                    break;
                case 6:
                    menuControlNodos();
                    break;
                case 7:
                    menuControlSensores();
                    break;
                case 8:
                    menuControlActuadores();
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (opc != 0);
    }

    /**
     *
     */
    private void verEstadoDeLaRed() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void verEjecucionDeLaRed() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void iniciarRed() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void detenerRed() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void menuControlPuertasDeEnlace() {
        int opc = -1;
        do {
            System.out.println("Net IoT Emulator");
            System.out.println("Red: " + this.principal.getGestionRed().getRed().getId()
                    + " - " + this.principal.getGestionRed().getRed().getNombre()
                    + " - " + this.principal.getGestionRed().getRed().getDescripcion());
            System.out.println("------------------------------------------------");
            System.out.println("----------Control de Puertas de Enlace----------");
            System.out.println("------------------------------------------------");
            System.out.println("0. para volver al menu anterior");
            System.out.println("1. para ver Puertas de Enlace de la Red");
            System.out.println("2. para ver Puerta de Enlace por ID");
            System.out.println("3. para iniciar Puerta de Enlace por ID");
            System.out.println("4. para detener Puerta de Enlace por ID");
            opc = sn.nextInt();
            switch (opc) {
                case 0:
                    System.out.println("Cerrando Control de Puertas de Enlace...");
                    break;
                case 1:
                    verPuertasDeEnlaceDeLaRed();
                    break;
                case 2:
                    verPuertaDeEnlaceDeLaRedPorID();
                    break;
                case 3:
                    iniciarPuertaDeEnlaceDeLaRedPorID();
                    break;
                case 4:
                    detenerPuertaDeEnlaceDeLaRedPorID();
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (opc != 0);
    }

    /**
     *
     */
    private void verPuertasDeEnlaceDeLaRed() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void verPuertaDeEnlaceDeLaRedPorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void iniciarPuertaDeEnlaceDeLaRedPorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void detenerPuertaDeEnlaceDeLaRedPorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void menuControlNodos() {
        int opc = -1;
        do {
            System.out.println("Net IoT Emulator");
            System.out.println("Red: " + this.principal.getGestionRed().getRed().getId()
                    + " - " + this.principal.getGestionRed().getRed().getNombre()
                    + " - " + this.principal.getGestionRed().getRed().getDescripcion());
            System.out.println("------------------------------------------------");
            System.out.println("----------------Control de Nodos----------------");
            System.out.println("------------------------------------------------");
            System.out.println("0. para volver al menu anterior");
            System.out.println("1. para ver Nodos de la Red");
            System.out.println("2. para ver Nodo por ID");
            System.out.println("3. para iniciar Nodo por ID");
            System.out.println("4. para detener Nodo por ID");
            opc = sn.nextInt();
            switch (opc) {
                case 0:
                    System.out.println("Cerrando Control de Nodos...");
                    break;
                case 1:
                    verNodosDeLaRed();
                    break;
                case 2:
                    verNodoDeLaRedPorID();
                    break;
                case 3:
                    iniciarNodoDeLaRedPorID();
                    break;
                case 4:
                    detenerNodoDeLaRedPorID();
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (opc != 0);
    }

    /**
     *
     */
    private void verNodosDeLaRed() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void verNodoDeLaRedPorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void iniciarNodoDeLaRedPorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void detenerNodoDeLaRedPorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void menuControlSensores() {
        int opc = -1;
        do {
            System.out.println("Net IoT Emulator");
            System.out.println("Red: " + this.principal.getGestionRed().getRed().getId()
                    + " - " + this.principal.getGestionRed().getRed().getNombre()
                    + " - " + this.principal.getGestionRed().getRed().getDescripcion());
            System.out.println("------------------------------------------------");
            System.out.println("--------------Control de  Sensores--------------");
            System.out.println("------------------------------------------------");
            System.out.println("0. para volver al menu anterior");
            System.out.println("1. para ver Sensores de la Red");
            System.out.println("2. para ver Sensor por ID");
            System.out.println("3. para iniciar Sensor por ID");
            System.out.println("4. para detener Sensor por ID");
            opc = sn.nextInt();
            switch (opc) {
                case 0:
                    System.out.println("Cerrando Control de  Sensores...");
                    break;
                case 1:
                    verSensoresDeLaRed();
                    break;
                case 2:
                    verSensorDeLaRedPorID();
                    break;
                case 3:
                    iniciarSensorDeLaRedPorID();
                    break;
                case 4:
                    detenerSensorDeLaRedPorID();
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (opc != 0);
    }

    /**
     *
     */
    private void verSensoresDeLaRed() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void verSensorDeLaRedPorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void iniciarSensorDeLaRedPorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void detenerSensorDeLaRedPorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void menuControlActuadores() {
        int opc = -1;
        do {
            System.out.println("Net IoT Emulator");
            System.out.println("Red: " + this.principal.getGestionRed().getRed().getId()
                    + " - " + this.principal.getGestionRed().getRed().getNombre()
                    + " - " + this.principal.getGestionRed().getRed().getDescripcion());
            System.out.println("------------------------------------------------");
            System.out.println("--------------Control de Actuadores-------------");
            System.out.println("------------------------------------------------");
            System.out.println("0. para volver al menu anterior");
            System.out.println("1. para ver Actuadores de la Red");
            System.out.println("2. para ver Actuador por ID");
            System.out.println("3. para iniciar Actuador por ID");
            System.out.println("4. para detener Actuador por ID");
            opc = sn.nextInt();
            switch (opc) {
                case 0:
                    System.out.println("Cerrando Control de Actuadores...");
                    break;
                case 1:
                    verActuadoresDeLaRed();
                    break;
                case 2:
                    verActuadorDeLaRedPorID();
                    break;
                case 3:
                    iniciarActuadorDeLaRedPorID();
                    break;
                case 4:
                    detenerActuadorDeLaRedPorID();
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (opc != 0);
    }

    /**
     *
     */
    private void verActuadoresDeLaRed() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void verActuadorDeLaRedPorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void iniciarActuadorDeLaRedPorID() {
        //
        System.out.println("Falta constrir...");
    }

    /**
     *
     */
    private void detenerActuadorDeLaRedPorID() {
        //
        System.out.println("Falta constrir...");
    }

    //reorganizar
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
