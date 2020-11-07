package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;


/**
 * The persistent class for the nodo database table.
 * 
 */
@Entity
@Table(name="nodo")
@NamedQuery(name="Nodo.findAll", query="SELECT n FROM Nodo n")
public class Nodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=45)
	private String id;

	@Column(nullable=false, length=80)
	private String descripcion;

	@Column(nullable=false)
	private byte estado;

	@Column(name="protocolo_comunicacion", nullable=false, length=45)
	private String protocoloComunicacion;

	//bi-directional many-to-one association to Actuador
	@OneToMany(mappedBy="nodoBean")
	private List<Actuador> actuadors;

	//bi-directional many-to-one association to PuertaDeEnlace
	@ManyToOne
	@JoinColumn(name="puerta_de_enlace", nullable=false)
	private PuertaDeEnlace puertaDeEnlaceBean;

	//bi-directional many-to-many association to Protocolo
	@ManyToMany
	@JoinTable(
		name="nodo_protocolo"
		, joinColumns={
			@JoinColumn(name="nodo", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="protocolo", nullable=false)
			}
		)
	private List<Protocolo> protocolos;

	//bi-directional many-to-one association to Sensor
	@OneToMany(mappedBy="nodoBean")
	private List<Sensor> sensors;

	public Nodo() {
	}
	public Nodo(String id) {
		this.id = id;
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

	public String getProtocoloComunicacion() {
		return this.protocoloComunicacion;
	}

	public void setProtocoloComunicacion(String protocoloComunicacion) {
		this.protocoloComunicacion = protocoloComunicacion;
	}

	public List<Actuador> getActuadors() {
		return this.actuadors;
	}

	public void setActuadors(List<Actuador> actuadors) {
		this.actuadors = actuadors;
	}

	public Actuador addActuador(Actuador actuador) {
		getActuadors().add(actuador);
		actuador.setNodoBean(this);

		return actuador;
	}

	public Actuador removeActuador(Actuador actuador) {
		getActuadors().remove(actuador);
		actuador.setNodoBean(null);

		return actuador;
	}

	public PuertaDeEnlace getPuertaDeEnlaceBean() {
		return this.puertaDeEnlaceBean;
	}

	public void setPuertaDeEnlaceBean(PuertaDeEnlace puertaDeEnlaceBean) {
		this.puertaDeEnlaceBean = puertaDeEnlaceBean;
	}

	public List<Protocolo> getProtocolos() {
		return this.protocolos;
	}

	public void setProtocolos(List<Protocolo> protocolos) {
		this.protocolos = protocolos;
	}

	public List<Sensor> getSensors() {
		return this.sensors;
	}

	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

	public Sensor addSensor(Sensor sensor) {
		getSensors().add(sensor);
		sensor.setNodoBean(this);

		return sensor;
	}

	public Sensor removeSensor(Sensor sensor) {
		getSensors().remove(sensor);
		sensor.setNodoBean(null);

		return sensor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actuadors == null) ? 0 : actuadors.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + estado;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((protocoloComunicacion == null) ? 0 : protocoloComunicacion.hashCode());
		result = prime * result + ((protocolos == null) ? 0 : protocolos.hashCode());
		result = prime * result + ((puertaDeEnlaceBean == null) ? 0 : puertaDeEnlaceBean.hashCode());
		result = prime * result + ((sensors == null) ? 0 : sensors.hashCode());
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
		Nodo other = (Nodo) obj;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (protocoloComunicacion == null) {
			if (other.protocoloComunicacion != null)
				return false;
		} else if (!protocoloComunicacion.equals(other.protocoloComunicacion))
			return false;
		if (protocolos == null) {
			if (other.protocolos != null)
				return false;
		} else if (!protocolos.equals(other.protocolos))
			return false;
		if (puertaDeEnlaceBean == null) {
			if (other.puertaDeEnlaceBean != null)
				return false;
		} else if (!puertaDeEnlaceBean.equals(other.puertaDeEnlaceBean))
			return false;
		if (sensors == null) {
			if (other.sensors != null)
				return false;
		} else if (!sensors.equals(other.sensors))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nodo: " + toJson().toString();
	}
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("id", this.getId());
		json.put("descripcion", this.getDescripcion());
		json.put("estado", this.getEstado());
		JSONArray Actuadores = new JSONArray();
		for (Actuador actuador : this.getActuadors()) {
			Actuadores.put(actuador.toJson().getString("id"));
		}
		json.put("actuadores", Actuadores);
		JSONObject jsonPuertaEnlace = this.getPuertaDeEnlaceBean().toJson();
		json.put("puerta_de_enlace", jsonPuertaEnlace);
		JSONArray protocolos = new JSONArray();
		for (Protocolo protocolo : this.getProtocolos()) {
			protocolos.put(protocolo.toJson().getString("id"));
		}
		json.put("protocolos", protocolos);
		return json;
	}
	
	public Nodo fromJson(JSONObject json) {		
		this.setId(json.getString("id"));
		this.setDescripcion(json.getString("descripcion"));
		this.setEstado((byte)json.getInt("estado"));
		return this;
	}
}