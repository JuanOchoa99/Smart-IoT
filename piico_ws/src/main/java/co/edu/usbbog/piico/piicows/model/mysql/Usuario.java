package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;

import org.json.JSONArray;
import org.json.JSONObject;

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

	//bi-directional many-to-one association to Puertadeenlace
	@OneToMany(mappedBy="usuario")
	private List<Puertadeenlace> puertasdeenlaces;

	//bi-directional many-to-many association to Rol
	@ManyToMany
	@JoinTable(
		name="rolusuario"
		, joinColumns={
			@JoinColumn(name="usuarioId", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="rolNombre", nullable=false)
			}
		)
	private List<Rol> roles;

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

	public List<Puertadeenlace> getPuertasdeenlaces() {
		return this.puertasdeenlaces;
	}

	public void setPuertadeenlaces(List<Puertadeenlace> puertadeenlaces) {
		this.puertasdeenlaces = puertadeenlaces;
	}

	public Puertadeenlace addPuertadeenlace(Puertadeenlace puertadeenlace) {
		getPuertasdeenlaces().add(puertadeenlace);
		puertadeenlace.setUsuario(this);

		return puertadeenlace;
	}

	public Puertadeenlace removePuertadeenlace(Puertadeenlace puertadeenlace) {
		getPuertasdeenlaces().remove(puertadeenlace);
		puertadeenlace.setUsuario(null);

		return puertadeenlace;
	}

	public List<Rol> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	
	
	
	public Usuario() {
	}

	public Usuario(String id) {
		this.id = id;
	}
	

	public Usuario(String id, String apellidos, String correo, String nombres, String pass, String username) {
		super();
		this.id = id;
		this.apellidos = apellidos;
		this.correo = correo;
		this.nombres = nombres;
		this.pass = pass;
		this.username = username;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombres == null) ? 0 : nombres.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((puertasdeenlaces == null) ? 0 : puertasdeenlaces.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombres == null) {
			if (other.nombres != null)
				return false;
		} else if (!nombres.equals(other.nombres))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (puertasdeenlaces == null) {
			if (other.puertasdeenlaces != null)
				return false;
		} else if (!puertasdeenlaces.equals(other.puertasdeenlaces))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Usuario: " + toJson().toString();
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("id", this.getId());
		json.put("apellidos", this.getApellidos());
		json.put("correo", this.getCorreo());
		json.put("nombres", this.getNombres());
		json.put("pass", this.getPass());
		json.put("username", this.getUsername());
		//relaciones
		JSONArray puertasDeEnlace = new JSONArray();
		for (Puertadeenlace puertaDeEnlace : this.getPuertasdeenlaces()) {
			puertasDeEnlace.put(puertaDeEnlace.toJson().getString("id"));
		}
		json.put("puertaDeEnlaces", puertasDeEnlace);
		JSONArray roles = new JSONArray();
		for (Rol rol : this.getRoles()) {
			roles.put(rol.toJson().getString("nombre"));
		}
		json.put("roles", roles);
		return json;
	}
	
	public Usuario fromJson(JSONObject json) {		
		this.setId(json.getString("id"));
		this.setApellidos(json.getString("apellidos"));
		this.setCorreo(json.getString("correo"));
		this.setNombres(json.getString("nombres") );
		this.setPass(json.getString("pass") );
		this.setUsername(json.getString("username") );
		return this;
	}

}