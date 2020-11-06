package co.edu.usbbog.piico.piicows.model.mysql;

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

	//bi-directional many-to-one association to Ordenactuador
	@OneToMany(mappedBy="orden")
	private List<Ordenactuador> ordenactuadors;

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

	public List<Ordenactuador> getOrdenactuadors() {
		return this.ordenactuadors;
	}

	public void setOrdenactuadors(List<Ordenactuador> ordenactuadors) {
		this.ordenactuadors = ordenactuadors;
	}

	public Ordenactuador addOrdenactuador(Ordenactuador ordenactuador) {
		getOrdenactuadors().add(ordenactuador);
		ordenactuador.setOrden(this);

		return ordenactuador;
	}

	public Ordenactuador removeOrdenactuador(Ordenactuador ordenactuador) {
		getOrdenactuadors().remove(ordenactuador);
		ordenactuador.setOrden(null);

		return ordenactuador;
	}

}