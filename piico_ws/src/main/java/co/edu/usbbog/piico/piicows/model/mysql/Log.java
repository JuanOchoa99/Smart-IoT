/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sebastian Villanueva
 */
@Entity
@Table(name = "log")
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l")
    , @NamedQuery(name = "Log.findById", query = "SELECT l FROM Log l WHERE l.id = :id")
    , @NamedQuery(name = "Log.findByFecha", query = "SELECT l FROM Log l WHERE l.fecha = :fecha")
    , @NamedQuery(name = "Log.findByTipo", query = "SELECT l FROM Log l WHERE l.tipo = :tipo")
    , @NamedQuery(name = "Log.findByEstado", query = "SELECT l FROM Log l WHERE l.estado = :estado")})
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Lob
    @Column(name = "mensaje")
    private String mensaje;
    @Basic(optional = false)
    @Column(name = "estado")
    private short estado;
    @JoinColumn(name = "puerta_de_enlace", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PuertaDeEnlace puertaDeEnlace;

    public Log() {
    }

    public Log(String id) {
        this.id = id;
    }

    public Log(String id, Date fecha, String tipo, String mensaje, short estado) {
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.mensaje = mensaje;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
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
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Log[ id=" + id + " ]";
    }
    
}
