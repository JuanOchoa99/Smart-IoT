package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.json.JSONObject;

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

	@Column(nullable=false)
	private LocalDateTime fecha;

	@Lob
	@Column(nullable=false)
	private String mensaje;

	@Column(nullable=false, length=45)
	private String tipo;

	//bi-directional many-to-one association to PuertaDeEnlace
	@ManyToOne
	@JoinColumn(name="puerta_de_enlace", nullable=false)
	private PuertaDeEnlace puertaDeEnlaceBean;

	public Log() {
	}
	public Log(String id) {
		this.id = id;
	}

	public Log(String id, byte estado, LocalDateTime fecha, String mensaje, String tipo) {
		super();
		this.id = id;
		this.estado = estado;
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.tipo = tipo;
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

	public LocalDateTime getFecha() {
		return this.fecha;
	}

	public void setFecha(LocalDateTime fecha) {
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

	public PuertaDeEnlace getPuertaDeEnlaceBean() {
		return this.puertaDeEnlaceBean;
	}

	public void setPuertaDeEnlaceBean(PuertaDeEnlace puertaDeEnlaceBean) {
		this.puertaDeEnlaceBean = puertaDeEnlaceBean;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + estado;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mensaje == null) ? 0 : mensaje.hashCode());
		result = prime * result + ((puertaDeEnlaceBean == null) ? 0 : puertaDeEnlaceBean.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Log other = (Log) obj;
		if (estado != other.estado)
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mensaje == null) {
			if (other.mensaje != null)
				return false;
		} else if (!mensaje.equals(other.mensaje))
			return false;
		if (puertaDeEnlaceBean == null) {
			if (other.puertaDeEnlaceBean != null)
				return false;
		} else if (!puertaDeEnlaceBean.equals(other.puertaDeEnlaceBean))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
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
		json.put("estado", this.getEstado());
		json.put("fecha", this.getFecha());
		json.put("mensaje", this.getMensaje());
		json.put("tipo", this.getTipo());
		// relaciones
		PuertaDeEnlace puertaDeEnlace = this.getPuertaDeEnlaceBean();
		json.put("puertaDeEnlace", puertaDeEnlace.toJson().get("id"));
		return json;
	}

	public Log fromJson(JSONObject json) {
		this.setId(json.getString("id"));
		this.setEstado((byte) json.getInt("estado"));
		this.setFecha(LocalDateTime.parse(json.getString("fecha")));
		this.setMensaje(json.getString("mensaje"));
		this.setTipo(json.getString("Tipo"));
		return this;
	}
}