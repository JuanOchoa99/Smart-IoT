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
@Table(name = "sensor")
@NamedQueries({
    @NamedQuery(name = "Sensor.findAll", query = "SELECT s FROM Sensor s")
    , @NamedQuery(name = "Sensor.findById", query = "SELECT s FROM Sensor s WHERE s.id = :id")
    , @NamedQuery(name = "Sensor.findByDescripcion", query = "SELECT s FROM Sensor s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "Sensor.findByEstado", query = "SELECT s FROM Sensor s WHERE s.estado = :estado")
    , @NamedQuery(name = "Sensor.findByTipo", query = "SELECT s FROM Sensor s WHERE s.tipo = :tipo")
    , @NamedQuery(name = "Sensor.findByMagnitud", query = "SELECT s FROM Sensor s WHERE s.magnitud = :magnitud")
    , @NamedQuery(name = "Sensor.findByFrecuencia", query = "SELECT s FROM Sensor s WHERE s.frecuencia = :frecuencia")})
public class Sensor implements Serializable {

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
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "magnitud")
    private String magnitud;
    @Basic(optional = false)
    @Column(name = "frecuencia")
    private int frecuencia;
    @OneToMany(mappedBy = "sensor")
    private List<Actuador> actuadorCollection;
    @JoinColumn(name = "nodo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Nodo nodo;

    public Sensor() {
    }

    public Sensor(String id) {
        this.id = id;
    }

    public Sensor(String id, String descripcion, short estado, String tipo, String magnitud, int frecuencia) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipo = tipo;
        this.magnitud = magnitud;
        this.frecuencia = frecuencia;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(String magnitud) {
        this.magnitud = magnitud;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    @XmlTransient
    public List<Actuador> getActuadorCollection() {
        return actuadorCollection;
    }

    public void setActuadorCollection(List<Actuador> actuadorCollection) {
        this.actuadorCollection = actuadorCollection;
    }

    public Nodo getNodo() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
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
        if (!(object instanceof Sensor)) {
            return false;
        }
        Sensor other = (Sensor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Sensor[ id=" + id + " ]";
    }
    
}
