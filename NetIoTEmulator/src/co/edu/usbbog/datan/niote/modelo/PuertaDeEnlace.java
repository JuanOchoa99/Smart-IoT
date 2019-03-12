/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.modelo;

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

    public PuertaDeEnlace(String id, String descripcion, boolean estado, String direccionLogica, String puertoDeServicio, String protocoloComunicacionExterno) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.direccionLogica = direccionLogica;
        this.puertoDeServicio = puertoDeServicio;
        this.protocoloComunicacionExterno = protocoloComunicacionExterno;
    }
    
    
    
    
}
