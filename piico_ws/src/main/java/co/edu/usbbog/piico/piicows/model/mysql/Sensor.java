package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;


/**
 * The persistent class for the sensor database table.
 * 
 */
@Entity
@Table(name="sensor")
@NamedQuery(name="Sensor.findAll", query="SELECT s FROM Sensor s")
public class Sensor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=45)
	private String id;

	@Column(nullable=false, length=80)
	private String descripcion;

	@Column(nullable=false)
	private int estado;

	@Column(nullable=false)
	private int frecuencia;

	@Column(nullable=false, length=50)
	private String magnitud;

	@Column(nullable=false, length=80)
	private String tipo;

	//bi-directional many-to-one association to Actuador
	@OneToMany(mappedBy="sensorBean")
	private List<Actuador> actuadors;

	//bi-directional many-to-one association to Nodo
	@ManyToOne
	@JoinColumn(name="nodo", nullable=false)
	private Nodo nodoBean;

	public Sensor() {
	}
	
	public Sensor(String id) {
		super();
		this.id = id;
	}
	
	
	public Sensor(String id, String descripcion, byte estado, int frecuencia, String magnitud, String tipo,
			List<Actuador> actuadors, Nodo nodoBean) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.estado = estado;
		this.frecuencia = frecuencia;
		this.magnitud = magnitud;
		this.tipo = tipo;
		this.actuadors = actuadors;
		this.nodoBean = nodoBean;
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

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getFrecuencia() {
		return this.frecuencia;
	}

	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}

	public String getMagnitud() {
		return this.magnitud;
	}

	public void setMagnitud(String magnitud) {
		this.magnitud = magnitud;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Actuador> getActuadors() {
		return this.actuadors;
	}

	public void setActuadors(List<Actuador> actuadors) {
		this.actuadors = actuadors;
	}

	public Actuador addActuador(Actuador actuador) {
		getActuadors().add(actuador);
		actuador.setSensorBean(this);

		return actuador;
	}

	public Actuador removeActuador(Actuador actuador) {
		getActuadors().remove(actuador);
		actuador.setSensorBean(null);

		return actuador;
	}

	public Nodo getNodoBean() {
		return this.nodoBean;
	}

	public void setNodoBean(Nodo nodoBean) {
		this.nodoBean = nodoBean;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actuadors == null) ? 0 : actuadors.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + estado;
		result = prime * result + frecuencia;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((magnitud == null) ? 0 : magnitud.hashCode());
		result = prime * result + ((nodoBean == null) ? 0 : nodoBean.hashCode());
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
		Sensor other = (Sensor) obj;
		if (actuadors == null) {
			if (other.actuadors != null)
				return false;
		} else if (!actuadors.equals(other.actuadors))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (estado != other.estado)
			return false;
		if (frecuencia != other.frecuencia)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (magnitud == null) {
			if (other.magnitud != null)
				return false;
		} else if (!magnitud.equals(other.magnitud))
			return false;
		if (nodoBean == null) {
			if (other.nodoBean != null)
				return false;
		} else if (!nodoBean.equals(other.nodoBean))
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
		return "Sensor: " + toJson().toString();
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("id", this.getId());
		json.put("descripcion", this.getDescripcion());
		json.put("estado", this.getEstado());
		json.put("frecuencia", this.getFrecuencia());
		json.put("magnitud", this.getMagnitud());
		json.put("tipo", this.getTipo());
		//relaciones
		JSONArray Actuadores = new JSONArray();
		for (Actuador actuador : this.getActuadors()) {
			Actuadores.put(actuador.toJson().getString("id"));
		}
		json.put("actuadores", Actuadores);
		JSONObject jsonNodo = this.getNodoBean().toJson();
		json.put("nodo", jsonNodo);
		return json;
	}
	
	public Sensor fromJson(JSONObject json) {		
		this.setId(json.getString("id"));
		this.setDescripcion(json.getString("descripcion"));
		this.setEstado(json.getInt("estado"));
		this.setFrecuencia(json.getInt("frecuencia"));
		this.setMagnitud(json.getString("magnitud"));
		this.setTipo(json.getString("tipo"));
		return this;
	}
}