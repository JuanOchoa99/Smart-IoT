package co.edu.usbbog.piico.piicows.modelo.mysql;

import java.io.Serializable;
import javax.persistence.*;
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
	private byte estado;

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

}