package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;

import org.json.JSONArray;
import org.json.JSONObject;

import co.edu.usbbog.piico.piicows.model.mongo.GPS;

import java.time.LocalDateTime;


/**
 * The persistent class for the ordenactuador database table.
 * 
 */
@Entity
@Table(name="ordenactuador")
@NamedQuery(name="Ordenactuador.findAll", query="SELECT o FROM Ordenactuador o")
public class Ordenactuador implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrdenactuadorPK id;

	@Column(nullable=false)
	private int confirmacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private  LocalDateTime fecha;

	//bi-directional many-to-one association to Actuador
	@ManyToOne
	@JoinColumn(name="actuadorId", nullable=false, insertable=false, updatable=false)
	private Actuador actuador;

	//bi-directional many-to-one association to Orden
	@ManyToOne
	@JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
	private Orden orden;

	public Ordenactuador() {
	}
	
	public Ordenactuador(OrdenactuadorPK id) {
		super();
		this.id = id;
	}

	public Ordenactuador(OrdenactuadorPK id, int confirmacion, LocalDateTime fecha, Actuador actuador, Orden orden) {
		super();
		this.id = id;
		this.confirmacion = confirmacion;
		this.fecha = fecha;
		this.actuador = actuador;
		this.orden = orden;
	}


	public OrdenactuadorPK getId() {
		return this.id;
	}

	public void setId(OrdenactuadorPK id) {
		this.id = id;
	}

	public int getConfirmacion() {
		return this.confirmacion;
	}

	public void setConfirmacion(int confirmacion) {
		this.confirmacion = confirmacion;
	}

	public LocalDateTime getFecha() {
		return this.fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Actuador getActuador() {
		return this.actuador;
	}

	public void setActuador(Actuador actuador) {
		this.actuador = actuador;
	}

	public Orden getOrden() {
		return this.orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actuador == null) ? 0 : actuador.hashCode());
		result = prime * result + confirmacion;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orden == null) ? 0 : orden.hashCode());
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
		Ordenactuador other = (Ordenactuador) obj;
		if (actuador == null) {
			if (other.actuador != null)
				return false;
		} else if (!actuador.equals(other.actuador))
			return false;
		if (confirmacion != other.confirmacion)
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
		if (orden == null) {
			if (other.orden != null)
				return false;
		} else if (!orden.equals(other.orden))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Ordenactuador: " + toJson().toString();
	}
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("id", this.getId());
		json.put("confirmacion", this.getConfirmacion());
		json.put("fecha", this.getFecha());
		JSONObject jsonActuador = this.getActuador().toJson();
		json.put("actuador", jsonActuador);
		JSONObject jsonOrden = this.getOrden().toJson();
		json.put("orden", jsonOrden);
		return json;
	}
	public Ordenactuador fromJson(JSONObject json) {		
		JSONObject jsonOrdenactuadorPK = json.getJSONObject("id");
		this.setId(new OrdenactuadorPK().fromJson(jsonOrdenactuadorPK));
		this.setConfirmacion(json.getInt("confirmacion"));
		JSONObject jsonFecha = json.getJSONObject("fecha");
		//this.setId(new LocalDateTime());
		return this;
	}
}