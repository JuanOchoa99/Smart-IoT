package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.json.JSONObject;
import java.time.LocalDateTime;


/**
 * The persistent class for the orden_actuador database table.
 * 
 */
@Entity
@Table(name="orden_actuador")
@NamedQuery(name="OrdenActuador.findAll", query="SELECT o FROM OrdenActuador o")
public class OrdenActuador implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrdenactuadorPK id;

	@Column(nullable=false)
	private byte confirmacion;

	@Column(nullable=false)
	private LocalDateTime fecha;

	//bi-directional many-to-one association to Actuador
	@ManyToOne
	@JoinColumn(name="actuador", nullable=false, insertable=false, updatable=false)
	private Actuador actuadorBean;

	//bi-directional many-to-one association to Orden
	@ManyToOne
	@JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
	private Orden orden;

	public OrdenActuador() {
	}
	public OrdenActuador(OrdenactuadorPK id) {
		this.id = id;
	}

	public OrdenActuador(OrdenactuadorPK id, byte confirmacion, LocalDateTime fecha) {
		super();
		this.id = id;
		this.confirmacion = confirmacion;
		this.fecha = fecha;
	}
	public OrdenactuadorPK getId() {
		return this.id;
	}

	public void setId(OrdenactuadorPK id) {
		this.id = id;
	}

	public byte getConfirmacion() {
		return this.confirmacion;
	}

	public void setConfirmacion(byte confirmacion) {
		this.confirmacion = confirmacion;
	}

	public LocalDateTime getFecha() {
		return this.fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Actuador getActuadorBean() {
		return this.actuadorBean;
	}

	public void setActuadorBean(Actuador actuadorBean) {
		this.actuadorBean = actuadorBean;
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
		result = prime * result + ((actuadorBean == null) ? 0 : actuadorBean.hashCode());
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
		OrdenActuador other = (OrdenActuador) obj;
		if (actuadorBean == null) {
			if (other.actuadorBean != null)
				return false;
		} else if (!actuadorBean.equals(other.actuadorBean))
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
		JSONObject jsonActuador = this.getActuadorBean().toJson();
		json.put("actuador", jsonActuador);
		JSONObject jsonOrden = this.getOrden().toJson();
		json.put("orden", jsonOrden);
		return json;
	}
	public OrdenActuador fromJson(JSONObject json) {		
		JSONObject jsonOrdenactuadorPK = json.getJSONObject("id");
		this.setId(new OrdenactuadorPK().fromJson(jsonOrdenactuadorPK));
		this.setConfirmacion((byte)json.getInt("confirmacion"));
		this.setFecha(LocalDateTime.parse(json.getString("fecha")));
		return this;
	}
}