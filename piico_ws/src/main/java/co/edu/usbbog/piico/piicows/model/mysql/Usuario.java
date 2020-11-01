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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.json.JSONObject;

/**
 *
 * @author Sebastian Villanueva
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id")
    , @NamedQuery(name = "Usuario.findByNombres", query = "SELECT u FROM Usuario u WHERE u.nombres = :nombres")
    , @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos")
    , @NamedQuery(name = "Usuario.findByPass", query = "SELECT u FROM Usuario u WHERE u.pass = :pass")
    , @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuario.findByUsuariocol", query = "SELECT u FROM Usuario u WHERE u.usuariocol = :usuariocol")
    , @NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username = :username")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", unique=true, nullable=false, length=45)
    private String id;
    @Basic(optional = false)
    @Column(name = "nombres", nullable=false, length=60)
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos",nullable=false, length=60)
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "pass", nullable=false, length=45)
    private String pass;
    @Basic(optional = false)
    @Column(name = "correo",nullable=false, length=45)
    private String correo;
    @Basic(optional = false)
    @Column(name = "username",nullable=false, length=45)
    private String username;
    @ManyToMany(mappedBy = "usuarioCollection")
    private List<Rol> rolCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<PuertaDeEnlace> puertaDeEnlaceCollection;

    public Usuario() {
    }

    public Usuario(String id) {
        this.id = id;
    }

    public Usuario(String id, String nombres, String apellidos, String pass, String correo, String username) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.pass = pass;
        this.correo = correo;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlTransient
    public Collection<Rol> getRolCollection() {
        return rolCollection;
    }

    public void setRolCollection(List<Rol> rolCollection) {
        this.rolCollection = rolCollection;
    }

    @XmlTransient
    public Collection<PuertaDeEnlace> getPuertaDeEnlaceCollection() {
        return puertaDeEnlaceCollection;
    }

    public void setPuertaDeEnlaceCollection(List<PuertaDeEnlace> puertaDeEnlaceCollection) {
        this.puertaDeEnlaceCollection = puertaDeEnlaceCollection;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    public JSONObject toJson() {
		JSONObject usuarioJson = new JSONObject();
		usuarioJson.put("id", this.getId());
		usuarioJson.put("username", this.getUsername());
		usuarioJson.put("nombres", this.getNombres());
		usuarioJson.put("apellidos", this.getApellidos());
		usuarioJson.put("correo", this.getCorreo());
		usuarioJson.put("password", this.getPass());
		return usuarioJson;
	}
    @Override
    public String toString() {
        return "modelos.Usuario[ id=" + id + " ]";
    }
    
}
