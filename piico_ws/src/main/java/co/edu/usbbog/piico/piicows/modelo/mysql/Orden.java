package co.edu.usbbog.piico.piicows.modelo.mysql;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the orden database table.
 * 
 */
@Entity
@Table(name="orden")
@NamedQuery(name="Orden.findAll", query="SELECT o FROM Orden o")
public class Orden implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=45)
	private String id;

	@Lob
	@Column(nullable=false)
	private String accion;

	@Column(nullable=false, length=45)
	private String tipo;

	//bi-directional many-to-one association to OrdenActuador
	@OneToMany(mappedBy="orden")
	private List<OrdenActuador> ordenActuadors;

	public Orden() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<OrdenActuador> getOrdenActuadors() {
		return this.ordenActuadors;
	}

	public void setOrdenActuadors(List<OrdenActuador> ordenActuadors) {
		this.ordenActuadors = ordenActuadors;
	}

	public OrdenActuador addOrdenActuador(OrdenActuador ordenActuador) {
		getOrdenActuadors().add(ordenActuador);
		ordenActuador.setOrden(this);

		return ordenActuador;
	}

	public OrdenActuador removeOrdenActuador(OrdenActuador ordenActuador) {
		getOrdenActuadors().remove(ordenActuador);
		ordenActuador.setOrden(null);

		return ordenActuador;
	}

}