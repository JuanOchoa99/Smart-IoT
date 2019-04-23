/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.persistencia;

import co.edu.usbbog.datan.niote.controlador.logica.GestionActuadores;
import co.edu.usbbog.datan.niote.controlador.logica.GestionNodos;
import co.edu.usbbog.datan.niote.controlador.logica.GestionPuertasDeEnlace;
import co.edu.usbbog.datan.niote.controlador.logica.GestionSensores;
import co.edu.usbbog.datan.niote.modelo.Red;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class ArchivoDeConfiguracionDeRed {

    private String ruta;
    private String nombreArchivo;

    public ArchivoDeConfiguracionDeRed() {
    }

    public ArchivoDeConfiguracionDeRed(String ruta, String nombreArchivo) {
        this.ruta = ruta;
        this.nombreArchivo = nombreArchivo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public Red cargarRed() {
        System.out.println("Falta constrir...");
        return null;
    }

    public GestionNodos cargarNodos() {
        System.out.println("Falta constrir...");
        return null;
    }

    public GestionPuertasDeEnlace cargarPuertasDeEnlace() {
        System.out.println("Falta constrir...");
        return null;
    }

    public GestionActuadores cargarActuadores() {
        System.out.println("Falta constrir...");
        return null;
    }

    public GestionSensores cargarSensores() {
        System.out.println("Falta constrir...");
        return null;
    }
    /**
    public static final String NOMBRE = "persona.txt"; // archivo Persona.txt

    private FileInputStream flujoEntrada; //imput al 
    private ObjectInputStream lector;
    private FileOutputStream flujoSalida;
    private ObjectOutputStream escritor;

    private File archivo;

    public ArchivoPersona() {
        creaArchivo();
    }

    private void creaArchivo() {
        archivo = new File(NOMBRE);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException ex) {
                //JOptionPane.showMessageDialog(null, "No se pudo crear el archivo");
            }
        }
    }

    private void eliminarTodoElContenido() {
        BufferedWriter bw = null;
        try {
            archivo = new File(NOMBRE);
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("");
        } catch (IOException ex) {
            //Logger.getLogger(ArchivoPersona.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                //Logger.getLogger(ArchivoPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void crearPersona(Persona p) {
        try {
            archivo = new File(NOMBRE);
            flujoSalida = new FileOutputStream(archivo, true); // Para agregar y no sobreescribir
            escritor = new ObjectOutputStream(flujoSalida); // sele envia el flijo de salida
            escritor.writeObject(p);
            escritor.close();
            flujoSalida.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(ArchivoPersona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(ArchivoPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Persona> buscarTodo() {
        ArrayList<Persona> listaPersona = new ArrayList<Persona>();
        try {            
            archivo = new File(NOMBRE);
            flujoEntrada = new FileInputStream(archivo);
            //Forma uno
            Object aux = null;
            do {                
              lector = new ObjectInputStream(flujoEntrada);
              aux = lector.readObject();
              if(aux!=null){
                   listaPersona.add((Persona) aux);
              }else{
                  lector.close();
                  flujoEntrada.close();
              }
            } while (aux!=null);
            //Forma dos
            /*while (true) {
                
                listaPersona.add((Persona) lector.readObject());
            }
            
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(ArchivoPersona.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (ClassNotFoundException ex) {
            //Logger.getLogger(ArchivoPersona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EOFException ex) {
            //Logger.getLogger(ArchivoPersona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(ArchivoPersona.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return listaPersona;       
        } 
		//Forma dos
            /* try {
                lector.close();
                flujoEntrada.close();           
            } catch (IOException ex) {
                //Logger.getLogger(ArchivoPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (NullPointerException ex) {
                //Logger.getLogger(ArchivoPersona.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
    }
    
    public Persona buscarPorDocumento(long documento){
        Persona p=null;
        ArrayList<Persona> listaPersonas = buscarTodo();
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getDocumento()==documento){
                p=listaPersonas.get(i);
                break;
            }
            
        }
        return p;
    }
    
    public void eliminarPersona(long documento) {
        Persona e = buscarPorDocumento(documento);
        if (e != null) {
            ArrayList<Persona> listaPersonas = buscarTodo();
            System.out.println(listaPersonas.size());
            listaPersonas.remove(e);
            eliminarTodoElContenido();
            System.out.println(listaPersonas.size());
            for (int i = 0; i < listaPersonas.size(); i++) {
                crearPersona(listaPersonas.get(i));
            }
        } else {
            System.out.println("No existe la persona");
        }
    }
    public void modificarPersona(long documento,Persona mn) {
        Persona mv = buscarPorDocumento(documento);
        if (mv != null) {
            ArrayList<Persona> listaPersonas = buscarTodo();
            for (int i = 0; i < listaPersonas.size(); i++) {
                if(listaPersonas.get(i).equals(mv)){
                    listaPersonas.get(i).setNombre(mn.getNombre());
                    listaPersonas.get(i).setApellido(mn.getApellido());
                }
            }
            eliminarTodoElContenido();
            for (int i = 0; i < listaPersonas.size(); i++) {
                crearPersona(listaPersonas.get(i));
            }
        } else {
            System.out.println("No existe la persona");
        }
    }*/


}
