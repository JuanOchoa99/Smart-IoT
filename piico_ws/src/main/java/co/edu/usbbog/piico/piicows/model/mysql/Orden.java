package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;

import org.json.JSONArray;
import org.json.JSONObject;

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
	public Orden(String id) {
		this.id = id;
	}

	public Orden(String id, String accion, String tipo) {
		super();
		this.id = id;
		this.accion = accion;
		this.tipo = tipo;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accion == null) ? 0 : accion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ordenActuadors == null) ? 0 : ordenActuadors.hashCode());
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
		Orden other = (Orden) obj;
		if (accion == null) {
			if (other.accion != null)
				return false;
		} else if (!accion.equals(other.accion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ordenActuadors == null) {
			if (other.ordenActuadors != null)
				return false;
		} else if (!ordenActuadors.equals(other.ordenActuadors))
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
		return "Orden: " + toJson().toString();
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("id", this.getId());
		json.put("accion", this.getAccion());
		json.put("tipo", this.getTipo());
		JSONArray ordenActuadors = new JSONArray();
		for (OrdenActuador ordenActuador : this.getOrdenActuadors()) {
			ordenActuadors.put(ordenActuador.toJson().getString("id"));
		}
		json.put("Ordenactuadors", ordenActuadors);
		return json;
	}
	
	public Orden fromJson(JSONObject json) {		
		this.setId(json.getString("id"));
		this.setAccion(json.getString("accion"));
		this.setTipo(json.getString("tipo"));
		return this;
	}
}