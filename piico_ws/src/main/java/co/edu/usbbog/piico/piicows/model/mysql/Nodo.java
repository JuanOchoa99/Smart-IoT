/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sebastian Villanueva
 */
@Entity
@Table(name = "nodo")
@NamedQueries({
    @NamedQuery(name = "Nodo.findAll", query = "SELECT n FROM Nodo n")
    , @NamedQuery(name = "Nodo.findById", query = "SELECT n FROM Nodo n WHERE n.id = :id")
    , @NamedQuery(name = "Nodo.findByDescripcion", query = "SELECT n FROM Nodo n WHERE n.descripcion = :descripcion")
    , @NamedQuery(name = "Nodo.findByEstado", query = "SELECT n FROM Nodo n WHERE n.estado = :estado")
    , @NamedQuery(name = "Nodo.findByProtocoloComunicacion", query = "SELECT n FROM Nodo n WHERE n.protocoloComunicacion = :protocoloComunicacion")})
public class Nodo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "estado")
    private short estado;
    @Basic(optional = false)
    @Column(name = "protocolo_comunicacion")
    private String protocoloComunicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nodo")
    private List<Actuador> actuadorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nodo")
    private List<Sensor> sensorCollection;
    @JoinColumn(name = "puerta_de_enlace", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PuertaDeEnlace puertaDeEnlace;

    public Nodo() {
    }

    public Nodo(String id) {
        this.id = id;
    }

    public Nodo(String id, String descripcion, short estado, String protocoloComunicacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.protocoloComunicacion = protocoloComunicacion;
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

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public String getProtocoloComunicacion() {
        return protocoloComunicacion;
    }

    public void setProtocoloComunicacion(String protocoloComunicacion) {
        this.protocoloComunicacion = protocoloComunicacion;
    }

    public List<Actuador> getActuadorCollection() {
        return actuadorCollection;
    }

    public void setActuadorCollection(List<Actuador> actuadorCollection) {
        this.actuadorCollection = actuadorCollection;
    }

    public List<Sensor> getSensorCollection() {
        return sensorCollection;
    }

    public void setSensorCollection(List<Sensor> sensorCollection) {
        this.sensorCollection = sensorCollection;
    }

    public PuertaDeEnlace getPuertaDeEnlace() {
        return puertaDeEnlace;
    }

    public void setPuertaDeEnlace(PuertaDeEnlace puertaDeEnlace) {
        this.puertaDeEnlace = puertaDeEnlace;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nodo)) {
            return false;
        }
        Nodo other = (Nodo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Nodo[ id=" + id + " ]";
    }
    
}
