package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;


/**
 * The persistent class for the puerta_de_enlace database table.
 * 
 */
@Entity
@Table(name="puerta_de_enlace")
@NamedQuery(name="PuertaDeEnlace.findAll", query="SELECT p FROM PuertaDeEnlace p")
public class PuertaDeEnlace implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=45)
	private String id;

	@Column(nullable=false, length=80)
	private String descripcion;

	@Column(name="direccion_logica", nullable=false, length=45)
	private String direccionLogica;

	@Column(nullable=false)
	private byte estado;

	@Column(length=100)
	private String password;

	@Column(name="puerto_de_servicio", nullable=false, length=10)
	private String puertoDeServicio;

	@Column(length=45)
	private String ssid;

	//bi-directional many-to-one association to Auth
	@OneToMany(mappedBy="puertaDeEnlaceBean")
	private List<Auth> auths;

	//bi-directional many-to-one association to Log
	@OneToMany(mappedBy="puertaDeEnlaceBean")
	private List<Log> logs;

	//bi-directional many-to-one association to Nodo
	@OneToMany(mappedBy="puertaDeEnlaceBean")
	private List<Nodo> nodos;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario", nullable=false)
	private Usuario usuarioBean;

	//bi-directional many-to-many association to Protocolo
	@ManyToMany
	@JoinTable(
		name="puerta_de_enlace_protocolo"
		, joinColumns={
			@JoinColumn(name="puerta_de_enlace", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="protocolo", nullable=false)
			}
		)
	private List<Protocolo> protocolos;

	public PuertaDeEnlace() {
	}
	public PuertaDeEnlace(String id) {
		this.id = id;
	}
	

	public PuertaDeEnlace(String id, String descripcion, String direccionLogica, byte estado, String password,
			String puertoDeServicio, String ssid) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.direccionLogica = direccionLogica;
		this.estado = estado;
		this.password = password;
		this.puertoDeServicio = puertoDeServicio;
		this.ssid = ssid;
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

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPuertoDeServicio() {
		return this.puertoDeServicio;
	}

	public void setPuertoDeServicio(String puertoDeServicio) {
		this.puertoDeServicio = puertoDeServicio;
	}

	public String getSsid() {
		return this.ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public List<Auth> getAuths() {
		return this.auths;
	}

	public void setAuths(List<Auth> auths) {
		this.auths = auths;
	}

	public Auth addAuth(Auth auth) {
		getAuths().add(auth);
		auth.setPuertaDeEnlaceBean(this);

		return auth;
	}

	public Auth removeAuth(Auth auth) {
		getAuths().remove(auth);
		auth.setPuertaDeEnlaceBean(null);

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
		log.setPuertaDeEnlaceBean(this);

		return log;
	}

	public Log removeLog(Log log) {
		getLogs().remove(log);
		log.setPuertaDeEnlaceBean(null);

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
		nodo.setPuertaDeEnlaceBean(this);

		return nodo;
	}

	public Nodo removeNodo(Nodo nodo) {
		getNodos().remove(nodo);
		nodo.setPuertaDeEnlaceBean(null);

		return nodo;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public List<Protocolo> getProtocolos() {
		return this.protocolos;
	}

	public void setProtocolos(List<Protocolo> protocolos) {
		this.protocolos = protocolos;
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
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((protocolos == null) ? 0 : protocolos.hashCode());
		result = prime * result + ((puertoDeServicio == null) ? 0 : puertoDeServicio.hashCode());
		result = prime * result + ((ssid == null) ? 0 : ssid.hashCode());
		result = prime * result + ((usuarioBean == null) ? 0 : usuarioBean.hashCode());
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
		PuertaDeEnlace other = (PuertaDeEnlace) obj;
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
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
		if (ssid == null) {
			if (other.ssid != null)
				return false;
		} else if (!ssid.equals(other.ssid))
			return false;
		if (usuarioBean == null) {
			if (other.usuarioBean != null)
				return false;
		} else if (!usuarioBean.equals(other.usuarioBean))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return toJson().toString();
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("id", this.getId());
		json.put("descripcion", this.getDescripcion());
		json.put("direccionLogica", this.getDireccionLogica());
		json.put("estado",this.getEstado());
		json.put("puertoDeServicio", this.getPuertoDeServicio());
		json.put("ssid",this.getSsid());
		json.put("password",this.getPassword());
		//relaciones
		
		return json;
	}
	
	public PuertaDeEnlace fromJson(JSONObject json) {		
		this.setId(json.getString("id"));
		this.setDescripcion(json.getString("descripcion"));
		this.setDireccionLogica(json.getString("direccionLogica"));
		this.setEstado((byte)json.getInt("estado"));
		this.setPuertoDeServicio(json.getString("puertoDeServicio"));
		this.setSsid(json.getString("ssid"));
		this.setPassword(json.getString("password"));
		return this;
	}
}