package co.edu.usbbog.piico.piicows.modelo.mysql;

import java.io.Serializable;
import javax.persistence.*;
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
	@OneToMany(mappedBy="actuador")
	private List<OrdenActuador> ordenActuadors;

	public Actuador() {
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
		ordenActuador.setActuador(this);

		return ordenActuador;
	}

	public OrdenActuador removeOrdenActuador(OrdenActuador ordenActuador) {
		getOrdenActuadors().remove(ordenActuador);
		ordenActuador.setActuador(null);

		return ordenActuador;
	}

}