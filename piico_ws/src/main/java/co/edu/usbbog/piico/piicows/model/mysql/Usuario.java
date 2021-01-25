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

	@Column(nullable=false, length=100)
	private String correo;

	@Column(nullable=false, length=60)
	private String nombres;

	@Column(nullable=false, length=220)
	private String pass;

	@Column(nullable=false, length=45)
	private String username;

	//bi-directional many-to-one association to Historial
	@OneToMany(mappedBy="usuarioBean")
	private List<Historial> historials;

	//bi-directional many-to-one association to PuertaDeEnlace
	@OneToMany(mappedBy="usuarioBean")
	private List<PuertaDeEnlace> puertaDeEnlaces;

	//bi-directional many-to-many association to Rol
	@ManyToMany(mappedBy="usuarios")
	private List<Rol> roles;

	public Usuario() {
		
	}
	public Usuario(String id ) {
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

	public List<Historial> getHistorials() {
		return this.historials;
	}

	public void setHistorials(List<Historial> historials) {
		this.historials = historials;
	}

	public Historial addHistorial(Historial historial) {
		getHistorials().add(historial);
		historial.setUsuarioBean(this);

		return historial;
	}

	public Historial removeHistorial(Historial historial) {
		getHistorials().remove(historial);
		historial.setUsuarioBean(null);

		return historial;
	}

	public List<PuertaDeEnlace> getPuertaDeEnlaces() {
		return this.puertaDeEnlaces;
	}

	public void setPuertaDeEnlaces(List<PuertaDeEnlace> puertaDeEnlaces) {
		this.puertaDeEnlaces = puertaDeEnlaces;
	}

	public PuertaDeEnlace addPuertaDeEnlace(PuertaDeEnlace puertaDeEnlace) {
		getPuertaDeEnlaces().add(puertaDeEnlace);
		puertaDeEnlace.setUsuarioBean(this);

		return puertaDeEnlace;
	}

	public PuertaDeEnlace removePuertaDeEnlace(PuertaDeEnlace puertaDeEnlace) {
		getPuertaDeEnlaces().remove(puertaDeEnlace);
		puertaDeEnlace.setUsuarioBean(null);

		return puertaDeEnlace;
	}

	public List<Rol> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((historials == null) ? 0 : historials.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombres == null) ? 0 : nombres.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((puertaDeEnlaces == null) ? 0 : puertaDeEnlaces.hashCode());
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
		if (historials == null) {
			if (other.historials != null)
				return false;
		} else if (!historials.equals(other.historials))
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
		if (puertaDeEnlaces == null) {
			if (other.puertaDeEnlaces != null)
				return false;
		} else if (!puertaDeEnlaces.equals(other.puertaDeEnlaces))
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
		return  toJson().toString();
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
		for (PuertaDeEnlace puertaDeEnlace : this.getPuertaDeEnlaces()) {
			puertasDeEnlace.put(puertaDeEnlace.toJson().getString("id"));
		}
		json.put("puertaDeEnlaces", puertasDeEnlace);
		JSONArray roles = new JSONArray();
		for (Rol rol : this.getRoles()) {
			roles.put(rol.toJson().getString("nombre"));
		}
		json.put("roles", roles);
		JSONArray historiales = new JSONArray();
		for (Historial historial : this.getHistorials()) {
			historiales.put(historial.toJson().getString("nombre"));
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