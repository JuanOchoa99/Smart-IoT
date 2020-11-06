package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;
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
	private byte estado;

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

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
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

}