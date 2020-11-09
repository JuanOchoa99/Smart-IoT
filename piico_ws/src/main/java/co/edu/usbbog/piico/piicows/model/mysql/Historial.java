package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.json.JSONObject;

import java.util.Date;


/**
 * The persistent class for the historial database table.
 * 
 */
@Entity
@Table(name="historial")
@NamedQuery(name="Historial.findAll", query="SELECT h FROM Historial h")
public class Historial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String descripcion;

	@Column(nullable=false, length=45)
	private String evento;

	@Column(nullable=false)
	private LocalDateTime fecha;

	@Column(nullable=false, length=45)
	private String tipo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario", nullable=false)
	private Usuario usuarioBean;

	public Historial() {
	}
	public Historial(int id) {
		this.id = id;
	}
	
	public Historial(int id, String descripcion, String evento, LocalDateTime fecha, String tipo) {
		this.id = id;
		this.descripcion = descripcion;
		this.evento = evento;
		this.fecha = fecha;
		this.tipo = tipo;
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEvento() {
		return this.evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public LocalDateTime getFecha() {
		return this.fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((evento == null) ? 0 : evento.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Historial other = (Historial) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
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
		return "Historial: "+ toJson().toString();
	}
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("id", this.getId());
		json.put("evento",this.getEvento());
		json.put("descripcion",this.getDescripcion());
		json.put("tipo",this.getTipo());
		json.put("fecha",this.getFecha());
		JSONObject jsonUsuario = this.getUsuarioBean().toJson();
		json.put("usuario", jsonUsuario);
		return json;
	}

	public Historial fromJson(JSONObject json) {
		this.setId(json.getInt("id"));
		this.setEvento(json.getString("evento"));
		this.setDescripcion(json.getString("descripcion"));
		this.setTipo(json.getString("tipo"));
		this.setFecha(LocalDateTime.parse(json.getString("fecha")));
		return this;
	}
}