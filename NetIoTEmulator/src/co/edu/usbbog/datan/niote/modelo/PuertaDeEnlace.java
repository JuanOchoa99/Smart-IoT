/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva, Gabriel Peña.
 */
public class PuertaDeEnlace {
    private String id;
    private String descripcion;
    private boolean estado;
    private String direccionLogica;
    private String puertoDeServicio;
    private String protocoloComunicacionExterno;
    private List<Mensaje> mensajes;    
    private List<Nodo> nodos;
    private List<PuertaDeEnlace> salidas;
    ServerSocket serversocket;
    Socket client;
    BufferedReader input;
    PrintWriter output;

    public PuertaDeEnlace(String id, String descripcion, boolean estado, String direccionLogica, String puertoDeServicio, String protocoloComunicacionExterno) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.direccionLogica = direccionLogica;
        this.puertoDeServicio = puertoDeServicio;
        this.protocoloComunicacionExterno = protocoloComunicacionExterno;
    }
    public void Conexion() throws IOException {
        serversocket = new ServerSocket(9090);
        System.out.println("Connection Starting on port:" + serversocket.getLocalPort());
        client = serversocket.accept();
        System.out.println("Waiting for connection from client");
        try {
            iniciarSesion();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void iniciarSesion() throws Exception {
        input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String username = input.readLine();
        System.out.println("username" + username);
        String password = input.readLine();
        System.out.println("password" + password);
        output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
        if (username.equals("sevin") && password.equals("sevin")) {
            output.println("Welcome, " + username);

        } else {
            output.println("Login Failed");
        }

        output.flush();
        output.close();
        serversocket.close();
        //Servidor(1000);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDireccionLogica() {
        return direccionLogica;
    }

    public void setDireccionLogica(String direccionLogica) {
        this.direccionLogica = direccionLogica;
    }

    public String getPuertoDeServicio() {
        return puertoDeServicio;
    }

    public void setPuertoDeServicio(String puertoDeServicio) {
        this.puertoDeServicio = puertoDeServicio;
    }

    public String getProtocoloComunicacionExterno() {
        return protocoloComunicacionExterno;
    }

    public void setProtocoloComunicacionExterno(String protocoloComunicacionExterno) {
        this.protocoloComunicacionExterno = protocoloComunicacionExterno;
    }

    @Override
    public String toString() {
        return "PuertaDeEnlace{" + "id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", direccionLogica=" + direccionLogica + ", puertoDeServicio=" + puertoDeServicio + ", protocoloComunicacionExterno=" + protocoloComunicacionExterno + '}';
    }

    public List<Nodo> getNodos() {
        return nodos;
    }

    public void setNodos(List<Nodo> nodos) {
        this.nodos = nodos;
    }
}
