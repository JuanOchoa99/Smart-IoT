package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;


/**
 * The persistent class for the protocolo database table.
 * 
 */
@Entity
@Table(name="protocolo")
@NamedQuery(name="Protocolo.findAll", query="SELECT p FROM Protocolo p")
public class Protocolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String estandar;

	@Column(nullable=false, length=45)
	private String nombre;

	@Column(nullable=false, length=45)
	private String tipo;

	//bi-directional many-to-many association to Nodo
	@ManyToMany(mappedBy="protocolos")
	private List<Nodo> nodos;

	//bi-directional many-to-many association to PuertaDeEnlace
	@ManyToMany(mappedBy="protocolos")
	private List<PuertaDeEnlace> puertaDeEnlaces;

	public Protocolo() {
	}
	public Protocolo(int id) {
		this.id = id;
	}
	
	public Protocolo(int id, String estandar, String nombre, String tipo) {
		super();
		this.id = id;
		this.estandar = estandar;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstandar() {
		return this.estandar;
	}

	public void setEstandar(String estandar) {
		this.estandar = estandar;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Nodo> getNodos() {
		return this.nodos;
	}

	public void setNodos(List<Nodo> nodos) {
		this.nodos = nodos;
	}

	public List<PuertaDeEnlace> getPuertaDeEnlaces() {
		return this.puertaDeEnlaces;
	}

	public void setPuertaDeEnlaces(List<PuertaDeEnlace> puertaDeEnlaces) {
		this.puertaDeEnlaces = puertaDeEnlaces;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estandar == null) ? 0 : estandar.hashCode());
		result = prime * result + id;
		result = prime * result + ((nodos == null) ? 0 : nodos.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((puertaDeEnlaces == null) ? 0 : puertaDeEnlaces.hashCode());
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
		Protocolo other = (Protocolo) obj;
		if (estandar == null) {
			if (other.estandar != null)
				return false;
		} else if (!estandar.equals(other.estandar))
			return false;
		if (id != other.id)
			return false;
		if (nodos == null) {
			if (other.nodos != null)
				return false;
		} else if (!nodos.equals(other.nodos))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (puertaDeEnlaces == null) {
			if (other.puertaDeEnlaces != null)
				return false;
		} else if (!puertaDeEnlaces.equals(other.puertaDeEnlaces))
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
		return "Protocolo: " + toJson().toString();
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("id", this.getId());
		json.put("nombre", this.getNombre());
		json.put("tipo", this.getTipo());
		json.put("estandar", this.getEstandar());
		//relaciones
		JSONArray puertasDeEnlace = new JSONArray();
		for (PuertaDeEnlace puertaDeEnlace : this.getPuertaDeEnlaces()) {
			puertasDeEnlace.put(puertaDeEnlace.toJson().getString("id"));
		}
		json.put("puertaDeEnlaces", puertasDeEnlace);
		JSONArray Nodos = new JSONArray();
		for (Nodo nodo : this.getNodos()) {
			Nodos.put(nodo.toJson().getString("id"));
		}
		json.put("puertaDeEnlaces", puertasDeEnlace);
		return json;
	}
	
	public Protocolo fromJson(JSONObject json) {		
		this.setId(json.getInt("id"));
		this.setNombre(json.getString("protocolo"));
		return this;
	}
}