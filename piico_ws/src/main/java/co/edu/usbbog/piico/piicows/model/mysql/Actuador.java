package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;

import org.json.JSONArray;
import org.json.JSONObject;

import co.edu.usbbog.piico.piicows.model.mysql.Actuador;
import co.edu.usbbog.piico.piicows.model.mysql.OrdenActuador;
import java.util.List;


/**
 * The persistent class for the actuador database table.
 * 
 */
@Entity
@Table(name="actuador")
@NamedQuery(name="Actuador.findAll", query="SELECT a FROM Actuador a")
public class Actuador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=45)
	private String id;

	@Column(nullable=false, length=45)
	private String descripcion;

	@Column(nullable=false)
	private byte estado;

	@Column(nullable=false, length=80)
	private String tipo;

	//bi-directional many-to-one association to Nodo
	@ManyToOne
	@JoinColumn(name="nodo", nullable=false)
	private Nodo nodoBean;

	//bi-directional many-to-one association to Sensor
	@ManyToOne
	@JoinColumn(name="sensor")
	private Sensor sensorBean;

	//bi-directional many-to-one association to OrdenActuador
	@OneToMany(mappedBy="actuadorBean")
	private List<OrdenActuador> ordenActuadors;

	public Actuador() {
	}
	public Actuador(String id) {
		this.id = id;
	}
	public Actuador(String id, String descripcion, byte estado, String tipo) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.estado = estado;
		this.tipo = tipo;
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

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Nodo getNodoBean() {
		return this.nodoBean;
	}

	public void setNodoBean(Nodo nodoBean) {
		this.nodoBean = nodoBean;
	}

	public Sensor getSensorBean() {
		return this.sensorBean;
	}

	public void setSensorBean(Sensor sensorBean) {
		this.sensorBean = sensorBean;
	}

	public List<OrdenActuador> getOrdenActuadors() {
		return this.ordenActuadors;
	}

	public void setOrdenActuadors(List<OrdenActuador> ordenActuadors) {
		this.ordenActuadors = ordenActuadors;
	}

	public OrdenActuador addOrdenActuador(OrdenActuador ordenActuador) {
		getOrdenActuadors().add(ordenActuador);
		ordenActuador.setActuadorBean(this);

		return ordenActuador;
	}

	public OrdenActuador removeOrdenActuador(OrdenActuador ordenActuador) {
		getOrdenActuadors().remove(ordenActuador);
		ordenActuador.setActuadorBean(null);

		return ordenActuador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + estado;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nodoBean == null) ? 0 : nodoBean.hashCode());
		result = prime * result + ((ordenActuadors == null) ? 0 : ordenActuadors.hashCode());
		result = prime * result + ((sensorBean == null) ? 0 : sensorBean.hashCode());
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
		Actuador other = (Actuador) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (estado != other.estado)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nodoBean == null) {
			if (other.nodoBean != null)
				return false;
		} else if (!nodoBean.equals(other.nodoBean))
			return false;
		if (ordenActuadors == null) {
			if (other.ordenActuadors != null)
				return false;
		} else if (!ordenActuadors.equals(other.ordenActuadors))
			return false;
		if (sensorBean == null) {
			if (other.sensorBean != null)
				return false;
		} else if (!sensorBean.equals(other.sensorBean))
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
		return "Actuador: " + toJson().toString();
	}
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("id", this.getId());
		json.put("descripcion", this.getDescripcion());
		json.put("estado", this.getEstado());
		json.put("tipo", this.getTipo());
		return json;
	}

	public Actuador fromJson(JSONObject json) {
		this.setId(json.getString("actuator_id"));
		this.setDescripcion(json.getString("descripcion"));
		this.setEstado((byte)json.getInt("estado"));
		this.setTipo(json.getString("tipo"));
		return this;
	}
}