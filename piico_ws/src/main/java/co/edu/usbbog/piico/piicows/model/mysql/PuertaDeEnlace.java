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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "puerta_de_enlace")
@NamedQueries({
    @NamedQuery(name = "PuertaDeEnlace.findAll", query = "SELECT p FROM PuertaDeEnlace p")
    , @NamedQuery(name = "PuertaDeEnlace.findById", query = "SELECT p FROM PuertaDeEnlace p WHERE p.puertaDeEnlacePK.id = :id")
    , @NamedQuery(name = "PuertaDeEnlace.findByDescripcion", query = "SELECT p FROM PuertaDeEnlace p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "PuertaDeEnlace.findByEstado", query = "SELECT p FROM PuertaDeEnlace p WHERE p.estado = :estado")
    , @NamedQuery(name = "PuertaDeEnlace.findByDireccionLogica", query = "SELECT p FROM PuertaDeEnlace p WHERE p.direccionLogica = :direccionLogica")
    , @NamedQuery(name = "PuertaDeEnlace.findByPuertoDeServicio", query = "SELECT p FROM PuertaDeEnlace p WHERE p.puertoDeServicio = :puertoDeServicio")
    , @NamedQuery(name = "PuertaDeEnlace.findByProtComunExt", query = "SELECT p FROM PuertaDeEnlace p WHERE p.protComunExt = :protComunExt")
    , @NamedQuery(name = "PuertaDeEnlace.findByUsuarioId", query = "SELECT p FROM PuertaDeEnlace p WHERE p.puertaDeEnlacePK.usuarioId = :usuarioId")})
public class PuertaDeEnlace implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PuertaDeEnlacePK puertaDeEnlacePK;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "estado")
    private short estado;
    @Basic(optional = false)
    @Column(name = "direccion_logica")
    private String direccionLogica;
    @Basic(optional = false)
    @Column(name = "puerto_de_servicio")
    private String puertoDeServicio;
    @Basic(optional = false)
    @Column(name = "prot_comun_ext")
    private String protComunExt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puertaDeEnlace")
    private List<Auth> authCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puertaDeEnlace")
    private List<Log> logCollection;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puertaDeEnlace")
    private List<Nodo> nodoCollection;

    public PuertaDeEnlace() {
    }

    public PuertaDeEnlace(PuertaDeEnlacePK puertaDeEnlacePK) {
        this.puertaDeEnlacePK = puertaDeEnlacePK;
    }

    public PuertaDeEnlace(PuertaDeEnlacePK puertaDeEnlacePK, String descripcion, short estado, String direccionLogica, String puertoDeServicio, String protComunExt) {
        this.puertaDeEnlacePK = puertaDeEnlacePK;
        this.descripcion = descripcion;
        this.estado = estado;
        this.direccionLogica = direccionLogica;
        this.puertoDeServicio = puertoDeServicio;
        this.protComunExt = protComunExt;
    }

    public PuertaDeEnlace(String id, String usuarioId) {
        this.puertaDeEnlacePK = new PuertaDeEnlacePK(id, usuarioId);
    }

    public PuertaDeEnlacePK getPuertaDeEnlacePK() {
        return puertaDeEnlacePK;
    }

    public void setPuertaDeEnlacePK(PuertaDeEnlacePK puertaDeEnlacePK) {
        this.puertaDeEnlacePK = puertaDeEnlacePK;
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

    public String getProtComunExt() {
        return protComunExt;
    }

    public void setProtComunExt(String protComunExt) {
        this.protComunExt = protComunExt;
    }

    public List<Auth> getAuthCollection() {
        return authCollection;
    }

    public void setAuthCollection(List<Auth> authCollection) {
        this.authCollection = authCollection;
    }

    public List<Log> getLogCollection() {
        return logCollection;
    }

    public void setLogCollection(List<Log> logCollection) {
        this.logCollection = logCollection;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<Nodo> getNodoCollection() {
        return nodoCollection;
    }

    public void setNodoCollection(List<Nodo> nodoCollection) {
        this.nodoCollection = nodoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (puertaDeEnlacePK != null ? puertaDeEnlacePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuertaDeEnlace)) {
            return false;
        }
        PuertaDeEnlace other = (PuertaDeEnlace) object;
        if ((this.puertaDeEnlacePK == null && other.puertaDeEnlacePK != null) || (this.puertaDeEnlacePK != null && !this.puertaDeEnlacePK.equals(other.puertaDeEnlacePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.PuertaDeEnlace[ puertaDeEnlacePK=" + puertaDeEnlacePK + " ]";
    }
    
}
