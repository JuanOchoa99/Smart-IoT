package co.edu.usbbog.piico.piicows.modelo.mysql;

import java.io.Serializable;
import javax.persistence.*;
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

	//bi-directional many-to-one association to Sensor
	@OneToMany(mappedBy="nodoBean")
	private List<Sensor> sensors;

	public Nodo() {
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

}