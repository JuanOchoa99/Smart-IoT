package co.edu.usbbog.piico.piicows.modelo.mysql;

import java.io.Serializable;
import javax.persistence.*;
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

	@Column(name="direccion_logica", nullable=false, length=60)
	private String direccionLogica;

	@Column(nullable=false)
	private byte estado;

	@Column(name="prot_comun_ext", nullable=false, length=45)
	private String protComunExt;

	@Column(name="puerto_de_servicio", nullable=false, length=10)
	private String puertoDeServicio;

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
	@JoinColumn(name="usuario_username", nullable=false)
	private Usuario usuario;

	public PuertaDeEnlace() {
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

	public String getProtComunExt() {
		return this.protComunExt;
	}

	public void setProtComunExt(String protComunExt) {
		this.protComunExt = protComunExt;
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}