package co.edu.usbbog.piico.piicows.modelo.mysql;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=45)
	private String id;

	@Column(nullable=false, length=60)
	private String apellidos;

	@Column(nullable=false, length=45)
	private String correo;

	@Column(nullable=false, length=60)
	private String nombres;

	@Column(nullable=false, length=45)
	private String pass;

	@Column(nullable=false, length=45)
	private String username;

	//bi-directional many-to-one association to PuertaDeEnlace
	@OneToMany(mappedBy="usuario")
	private List<PuertaDeEnlace> puertaDeEnlaces;

	//bi-directional many-to-many association to Rol
	@ManyToMany
	@JoinTable(
		name="rol_has_usuario"
		, joinColumns={
			@JoinColumn(name="usuario_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="rol_nombre", nullable=false)
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

	public List<PuertaDeEnlace> getPuertaDeEnlaces() {
		return this.puertaDeEnlaces;
	}

	public void setPuertaDeEnlaces(List<PuertaDeEnlace> puertaDeEnlaces) {
		this.puertaDeEnlaces = puertaDeEnlaces;
	}

	public PuertaDeEnlace addPuertaDeEnlace(PuertaDeEnlace puertaDeEnlace) {
		getPuertaDeEnlaces().add(puertaDeEnlace);
		puertaDeEnlace.setUsuario(this);

		return puertaDeEnlace;
	}

	public PuertaDeEnlace removePuertaDeEnlace(PuertaDeEnlace puertaDeEnlace) {
		getPuertaDeEnlaces().remove(puertaDeEnlace);
		puertaDeEnlace.setUsuario(null);

		return puertaDeEnlace;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

}