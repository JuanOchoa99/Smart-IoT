package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the actuador database table.
 * 
 */
@Entity
@NamedQuery(name="Actuador.findAll", query="SELECT a FROM Actuador a")
public class Actuador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String descripcion;

	private byte estado;

	private String tipo;

	//bi-directional many-to-one association to Nodo
	@ManyToOne
	@JoinColumn(name="nodo")
	private Nodo nodoBean;

	//bi-directional many-to-one association to Sensor
	@ManyToOne
	@JoinColumn(name="sensor")
	private Sensor sensorBean;

	//bi-directional many-to-one association to Ordenactuador
	@OneToMany(mappedBy="actuador")
	private List<Ordenactuador> ordenactuadors;

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

}