package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String apellidos;

	private String correo;

	private String nombres;

	private String pass;

	private String username;

	//bi-directional many-to-one association to Puertadeenlace
	@OneToMany(mappedBy="usuario")
	private List<Puertadeenlace> puertadeenlaces;

	//bi-directional many-to-many association to Rol
	@ManyToMany
	@JoinTable(
		name="rol_has_usuario"
		, joinColumns={
			@JoinColumn(name="usuarioId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="rolNombre")
			}
		)
	private List<Rol> rols;

	public Usuario() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Puertadeenlace> getPuertadeenlaces() {
		return this.puertadeenlaces;
	}

	public void setPuertadeenlaces(List<Puertadeenlace> puertadeenlaces) {
		this.puertadeenlaces = puertadeenlaces;
	}

	public Puertadeenlace addPuertadeenlace(Puertadeenlace puertadeenlace) {
		getPuertadeenlaces().add(puertadeenlace);
		puertadeenlace.setUsuario(this);

		return puertadeenlace;
	}

	public Puertadeenlace removePuertadeenlace(Puertadeenlace puertadeenlace) {
		getPuertadeenlaces().remove(puertadeenlace);
		puertadeenlace.setUsuario(null);

		return puertadeenlace;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

}