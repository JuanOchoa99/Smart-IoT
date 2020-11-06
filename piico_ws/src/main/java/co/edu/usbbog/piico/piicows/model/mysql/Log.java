package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the log database table.
 * 
 */
@Entity
@Table(name="log")
@NamedQuery(name="Log.findAll", query="SELECT l FROM Log l")
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=45)
	private String id;

	@Column(nullable=false)
	private byte estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date fecha;

	@Lob
	@Column(nullable=false)
	private String mensaje;

	@Column(nullable=false, length=45)
	private String tipo;

	//bi-directional many-to-one association to Puertadeenlace
	@ManyToOne
	@JoinColumn(name="puertaDeEnlaceId", nullable=false)
	private Puertadeenlace puertadeenlace;

	public Log() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Puertadeenlace getPuertadeenlace() {
		return this.puertadeenlace;
	}

	public void setPuertadeenlace(Puertadeenlace puertadeenlace) {
		this.puertadeenlace = puertadeenlace;
	}

}