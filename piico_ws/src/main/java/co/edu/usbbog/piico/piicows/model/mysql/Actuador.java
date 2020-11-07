package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;
<<<<<<< HEAD

import org.json.JSONArray;
import org.json.JSONObject;

import co.edu.usbbog.piico.piicows.model.mongo.GPS;

import java.util.List;


=======
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

>>>>>>> master
/**
 * The persistent class for the actuador database table.
 * 
 */
@Entity
<<<<<<< HEAD
@Table(name="actuador")
@NamedQuery(name="Actuador.findAll", query="SELECT a FROM Actuador a")
=======
@Table(name = "actuador")
@NamedQuery(name = "Actuador.findAll", query = "SELECT a FROM Actuador a")
>>>>>>> master
public class Actuador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
<<<<<<< HEAD
	@Column(unique=true, nullable=false, length=45)
	private String id;

	@Column(nullable=false, length=45)
	private String descripcion;

	@Column(nullable=false)
	private int estado;

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

	//bi-directional many-to-one association to Ordenactuador
	@OneToMany(mappedBy="actuador")
=======
	@Column(unique = true, nullable = false, length = 45)
	private String id;

	@Column(nullable = false, length = 45)
	private String descripcion;

	@Column(nullable = false)
	private int estado;

	@Column(nullable = false, length = 80)
	private String tipo;

	// bi-directional many-to-one association to Nodo
	@ManyToOne
	@JoinColumn(name = "nodo", nullable = false)
	private Nodo nodoBean;

	// bi-directional many-to-one association to Sensor
	@ManyToOne
	@JoinColumn(name = "sensor")
	private Sensor sensorBean;

	// bi-directional many-to-one association to Ordenactuador
	@OneToMany(mappedBy = "actuador")
>>>>>>> master
	private List<Ordenactuador> ordenactuadors;

	public Actuador() {
	}
<<<<<<< HEAD
	
=======

>>>>>>> master
	public Actuador(String id) {
		super();
		this.id = id;
	}
<<<<<<< HEAD
	
	public Actuador(String id, String descripcion, int estado, String tipo, Nodo nodoBean, Sensor sensorBean,
			List<Ordenactuador> ordenactuadors) {
=======

	public Actuador(String id, String descripcion, int estado, String tipo) {
>>>>>>> master
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.estado = estado;
		this.tipo = tipo;
<<<<<<< HEAD
		this.nodoBean = nodoBean;
		this.sensorBean = sensorBean;
		this.ordenactuadors = ordenactuadors;
	}


=======
	}

>>>>>>> master
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

	public List<Ordenactuador> getOrdenactuadors() {
		return this.ordenactuadors;
	}

	public void setOrdenactuadors(List<Ordenactuador> ordenactuadors) {
		this.ordenactuadors = ordenactuadors;
	}

	public Ordenactuador addOrdenactuador(Ordenactuador ordenactuador) {
		getOrdenactuadors().add(ordenactuador);
		ordenactuador.setActuador(this);

		return ordenactuador;
	}

	public Ordenactuador removeOrdenactuador(Ordenactuador ordenactuador) {
		getOrdenactuadors().remove(ordenactuador);
		ordenactuador.setActuador(null);

		return ordenactuador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + estado;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nodoBean == null) ? 0 : nodoBean.hashCode());
		result = prime * result + ((ordenactuadors == null) ? 0 : ordenactuadors.hashCode());
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
		if (ordenactuadors == null) {
			if (other.ordenactuadors != null)
				return false;
		} else if (!ordenactuadors.equals(other.ordenactuadors))
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
<<<<<<< HEAD
	
=======

>>>>>>> master
	@Override
	public String toString() {
		return "Actuador: " + toJson().toString();
	}
<<<<<<< HEAD
	
=======

>>>>>>> master
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("id", this.getId());
		json.put("descripcion", this.getDescripcion());
		json.put("estado", this.getEstado());
		json.put("tipo", this.getTipo());
		JSONObject jsonSensor = this.getSensorBean().toJson();
		json.put("sensor", jsonSensor);
		JSONObject jsonNodo = this.getNodoBean().toJson();
		json.put("nodo", jsonNodo);
<<<<<<< HEAD
		//Relaciones
=======
		// Relaciones
>>>>>>> master
		JSONArray ordenActuadors = new JSONArray();
		for (Ordenactuador ordenActuador : this.getOrdenactuadors()) {
			ordenActuadors.put(ordenActuador.toJson().getString("id"));
		}
		json.put("Ordenactuadors", ordenActuadors);
		return json;
	}
<<<<<<< HEAD
	
	public Actuador fromJson(JSONObject json) {		
		this.setId(json.getString("id"));
		this.setDescripcion(json.getString("descripcion"));
		this.setEstado(json.getInt("estado"));
		this.setTipo(json.getString("tipo") );
		JSONObject jsonSensor = json.getJSONObject("sensor");
		this.setSensorBean(new Sensor().fromJson(jsonSensor));
		JSONObject jsonNodo = json.getJSONObject("nodo");
		this.setNodoBean(new Nodo().fromJson(jsonNodo));
=======

	public Actuador fromJson(JSONObject json) {
		this.setId(json.getString("id"));
		this.setDescripcion(json.getString("descripcion"));
		this.setEstado(json.getInt("estado"));
		this.setTipo(json.getString("tipo"));
>>>>>>> master
		return this;
	}
}