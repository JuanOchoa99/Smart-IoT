package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;


/**
 * The persistent class for the puertadeenlace database table.
 * 
 */
@Entity
@Table(name="puertadeenlace")
@NamedQuery(name="Puertadeenlace.findAll", query="SELECT p FROM Puertadeenlace p")
public class Puertadeenlace implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=45)
	private String id;

	@Column(nullable=false, length=80)
	private String descripcion;

	@Column(nullable=false, length=60)
	private String direccionLogica;

	@Column(nullable=false)
	private int estado;

	@Column(nullable=false, length=10)
	private String puertoDeServicio;

	//bi-directional many-to-one association to Auth
	@OneToMany(mappedBy="puertadeenlace")
	private List<Auth> auths;

	//bi-directional many-to-one association to Log
	@OneToMany(mappedBy="puertadeenlace")
	private List<Log> logs;

	//bi-directional many-to-one association to Nodo
	@OneToMany(mappedBy="puertadeenlace")
	private List<Nodo> nodos;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuarioId", nullable=false)
	private Usuario usuario;

	//bi-directional many-to-many association to Protocolo
	@ManyToMany
	@JoinTable(
		name="puertadeenlaceprotocolo"
		, joinColumns={
			@JoinColumn(name="puertaDeEnlaceId", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="Protocoloid", nullable=false)
			}
		)
	private List<Protocolo> protocolos;

	public Puertadeenlace() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccionLogica() {
		return this.direccionLogica;
	}

	public void setDireccionLogica(String direccionLogica) {
		this.direccionLogica = direccionLogica;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int i) {
		this.estado = i;
	}

	public String getPuertoDeServicio() {
		return this.puertoDeServicio;
	}

	public void setPuertoDeServicio(String puertoDeServicio) {
		this.puertoDeServicio = puertoDeServicio;
	}

	public List<Auth> getAuths() {
		return this.auths;
	}

	public void setAuths(List<Auth> auths) {
		this.auths = auths;
	}

	public Auth addAuth(Auth auth) {
		getAuths().add(auth);
		auth.setPuertadeenlace(this);

		return auth;
	}

	public Auth removeAuth(Auth auth) {
		getAuths().remove(auth);
		auth.setPuertadeenlace(null);

		return auth;
	}

	public List<Log> getLogs() {
		return this.logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public Log addLog(Log log) {
		getLogs().add(log);
		log.setPuertadeenlace(this);

		return log;
	}

	public Log removeLog(Log log) {
		getLogs().remove(log);
		log.setPuertadeenlace(null);

		return log;
	}

	public List<Nodo> getNodos() {
		return this.nodos;
	}

	public void setNodos(List<Nodo> nodos) {
		this.nodos = nodos;
	}

	public Nodo addNodo(Nodo nodo) {
		getNodos().add(nodo);
		nodo.setPuertadeenlace(this);

		return nodo;
	}

	public Nodo removeNodo(Nodo nodo) {
		getNodos().remove(nodo);
		nodo.setPuertadeenlace(null);

		return nodo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Protocolo> getProtocolos() {
		return this.protocolos;
	}

	public void setProtocolos(List<Protocolo> protocolos) {
		this.protocolos = protocolos;
	}
	
	

	public Puertadeenlace(String id) {
		this.id = id;
	}
	

	public Puertadeenlace(String id, String descripcion, String direccionLogica, byte estado, String puertoDeServicio) {
		this.id = id;
		this.descripcion = descripcion;
		this.direccionLogica = direccionLogica;
		this.estado = estado;
		this.puertoDeServicio = puertoDeServicio;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auths == null) ? 0 : auths.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((direccionLogica == null) ? 0 : direccionLogica.hashCode());
		result = prime * result + estado;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((logs == null) ? 0 : logs.hashCode());
		result = prime * result + ((nodos == null) ? 0 : nodos.hashCode());
		result = prime * result + ((protocolos == null) ? 0 : protocolos.hashCode());
		result = prime * result + ((puertoDeServicio == null) ? 0 : puertoDeServicio.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Puertadeenlace other = (Puertadeenlace) obj;
		if (auths == null) {
			if (other.auths != null)
				return false;
		} else if (!auths.equals(other.auths))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (direccionLogica == null) {
			if (other.direccionLogica != null)
				return false;
		} else if (!direccionLogica.equals(other.direccionLogica))
			return false;
		if (estado != other.estado)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (logs == null) {
			if (other.logs != null)
				return false;
		} else if (!logs.equals(other.logs))
			return false;
		if (nodos == null) {
			if (other.nodos != null)
				return false;
		} else if (!nodos.equals(other.nodos))
			return false;
		if (protocolos == null) {
			if (other.protocolos != null)
				return false;
		} else if (!protocolos.equals(other.protocolos))
			return false;
		if (puertoDeServicio == null) {
			if (other.puertoDeServicio != null)
				return false;
		} else if (!puertoDeServicio.equals(other.puertoDeServicio))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "Puerta de enlace: " + toJson().toString();
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("id", this.getId());
		json.put("descripcion", this.getDescripcion());
		json.put("direccionLogica", this.getDireccionLogica());
		json.put("estado",this.getEstado());
		json.put("puertoDeServicio", this.getPuertoDeServicio());
		//relaciones
		JSONArray logs = new JSONArray();
		for (Log log : this.getLogs()) {
			logs.put(log.toJson().getString("id"));
		}
		JSONArray auths = new JSONArray();
		for (Auth auth : this.getAuths()) {
			auths.put(auth.toJson().getString("id"));
		}
		JSONArray nodos = new JSONArray();
		for (Nodo nodo : this.getNodos()) {
			nodos.put(nodo.toJson().getString("id"));
		}
		return json;
	}
	
	public Puertadeenlace fromJson(JSONObject json) {		
		this.setId(json.getString("id"));
		this.setDescripcion(json.getString("descripcion"));
		this.setDireccionLogica(json.getString("direccionLogica"));
		this.setEstado(json.getInt("estado"));
		this.setPuertoDeServicio(json.getString("puertoDeServicio"));
		
		return this;
	}

}