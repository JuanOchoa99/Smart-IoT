/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.persistencia;

import co.edu.usbbog.datan.niote.controlador.logica.GestionActuadores;
import co.edu.usbbog.datan.niote.controlador.logica.GestionNodos;
import co.edu.usbbog.datan.niote.controlador.logica.GestionPuertasDeEnlace;
import co.edu.usbbog.datan.niote.controlador.logica.GestionRed;
import co.edu.usbbog.datan.niote.controlador.logica.GestionSensores;
import co.edu.usbbog.datan.niote.modelo.Red;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class ArchivoDeConfiguracionDeRed implements Serializable {

    private String ruta;
    private String nombreArchivo;
    private File carpeta;
    private FileInputStream flujoEntrada; //imput al 
    private ObjectInputStream lector;
    private FileOutputStream flujoSalida;
    private ObjectOutputStream escritor;
    private GestionRed gestionRed;
    private File archivo;

    public ArchivoDeConfiguracionDeRed() {
    }

    public ArchivoDeConfiguracionDeRed(String ruta, String nombreArchivo, GestionRed gestionRed) {
        this.ruta = darRuta(ruta);
        this.nombreArchivo = darNombreArchivo(nombreArchivo);
        this.gestionRed = gestionRed;
        crearArchivo();
        guardarRed();
    }

    public ArchivoDeConfiguracionDeRed(String ruta, String nombreArchivo) {
        this.ruta = darRuta(ruta);
        this.nombreArchivo = darNombreArchivo(nombreArchivo);
        this.gestionRed = cargarGestionRed();
    }

    private void crearArchivo() {
        archivo = new File(this.ruta + this.nombreArchivo);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException ex) {
                System.err.print("no se guardo la red");
                //JOptionPane.showMessageDialog(null, "No se pudo crear el archivo");
            }
        }
    }

    private void crearCarpeta(String ruta) {
        carpeta = new File(ruta);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
    }

    private String darNombreArchivo(String nombreArchivo) {
        String[] arch = nombreArchivo.split("\\.");
        if (arch.length <= 0) {
            return nombreArchivo + ".niote";
        } else {
            String ext = arch[arch.length - 1];
            if (ext.equals("niote")) {
                return nombreArchivo;
            } else {
                return nombreArchivo + ".niote";
            }
        }
    }

    private String darRuta(String ruta) {
        System.out.println("Falta");
        System.out.println(ruta);
        File direc = new File(ruta);
        String[] rut = ruta.split("\\\\");
        for (int i = 0; i < rut.length; i++) {
            System.out.println(rut[i]);
        }
        if (direc.exists()) {
        } else {
            crearCarpeta(ruta);
        }
        if (rut.length <= 0) {

            return ruta + "\\";
        } else {
            String ext = rut[rut.length - 1];
            if (ext.equals("\\")) {
                return ruta;
            } else {
                return ruta + "\\";
            }
        }
    }

    public Red cargarRed() {
        return this.gestionRed.getRed();
    }

    public GestionNodos cargarNodos() {
        return this.gestionRed.getGestionNodo();
    }

    public GestionPuertasDeEnlace cargarPuertasDeEnlace() {
        return this.gestionRed.getGestionPuertaDeEnlace();
    }

    public GestionActuadores cargarActuadores() {
        return this.gestionRed.getGestionActuadores();
    }

    public GestionSensores cargarSensores() {
        return this.gestionRed.getGestionSensores();
    }

    public void guardarRed() {
        try {
            archivo = new File(this.ruta + this.nombreArchivo);
            flujoSalida = new FileOutputStream(archivo, false); // Para agregar y no sobreescribir
            escritor = new ObjectOutputStream(flujoSalida); // sele envia el flijo de salida
            escritor.writeObject(gestionRed);
            escritor.close();
            flujoSalida.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(ArchivoPersona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(ArchivoPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private GestionRed cargarGestionRed() {
        GestionRed gr = null;
        try {
            archivo = new File(this.ruta + this.nombreArchivo);
            flujoEntrada = new FileInputStream(archivo);
            Object aux = null;
            lector = new ObjectInputStream(flujoEntrada);
            aux = lector.readObject();
            if (aux != null) {
                gr = (GestionRed) aux;
            }
            lector.close();
            flujoEntrada.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(ArchivoDeConfiguracionDeRed.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            //Logger.getLogger(ArchivoDeConfiguracionDeRed.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(ArchivoDeConfiguracionDeRed.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } finally {
            return gr;
        }
    }

}
