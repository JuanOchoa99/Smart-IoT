package co.edu.usbbog.piico.piicows.modelo.mysql;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


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
	private OrdenActuadorPK id;

	@Column(nullable=false)
	private byte confirmacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date fecha;

	//bi-directional many-to-one association to Actuador
	@ManyToOne
	@JoinColumn(name="actuador_id", nullable=false, insertable=false, updatable=false)
	private Actuador actuador;

	//bi-directional many-to-one association to Orden
	@ManyToOne
	@JoinColumn(name="orden_id", nullable=false, insertable=false, updatable=false)
	private Orden orden;

	public OrdenActuador() {
	}

	public OrdenActuadorPK getId() {
		return this.id;
	}

	public void setId(OrdenActuadorPK id) {
		this.id = id;
	}

	public byte getConfirmacion() {
		return this.confirmacion;
	}

	public void setConfirmacion(byte confirmacion) {
		this.confirmacion = confirmacion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
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

}