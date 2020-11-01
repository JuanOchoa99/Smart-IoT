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
@Table(name = "actuador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actuador.findAll", query = "SELECT a FROM Actuador a")
    , @NamedQuery(name = "Actuador.findById", query = "SELECT a FROM Actuador a WHERE a.id = :id")
    , @NamedQuery(name = "Actuador.findByDescripcion", query = "SELECT a FROM Actuador a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Actuador.findByEstado", query = "SELECT a FROM Actuador a WHERE a.estado = :estado")
    , @NamedQuery(name = "Actuador.findByTipo", query = "SELECT a FROM Actuador a WHERE a.tipo = :tipo")})
public class Actuador implements Serializable {

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
    @JoinColumn(name = "nodo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Nodo nodo;
    @JoinColumn(name = "sensor", referencedColumnName = "id")
    @ManyToOne
    private Sensor sensor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actuador")
    private List<OrdenActuador> ordenActuadorCollection;

    public Actuador() {
    }

    public Actuador(String id) {
        this.id = id;
    }

    public Actuador(String id, String descripcion, short estado, String tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipo = tipo;
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

    public Nodo getNodo() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public List<OrdenActuador> getOrdenActuadorCollection() {
        return ordenActuadorCollection;
    }

    public void setOrdenActuadorCollection(List<OrdenActuador> ordenActuadorCollection) {
        this.ordenActuadorCollection = ordenActuadorCollection;
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
        if (!(object instanceof Actuador)) {
            return false;
        }
        Actuador other = (Actuador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Actuador[ id=" + id + " ]";
    }
    
}
