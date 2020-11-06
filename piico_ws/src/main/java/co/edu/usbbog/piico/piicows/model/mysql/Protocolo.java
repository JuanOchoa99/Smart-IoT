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
	private String protocolo;

	//bi-directional many-to-many association to Nodo
	@ManyToMany(mappedBy="protocolos")
	private List<Nodo> nodos;

	//bi-directional many-to-many association to Puertadeenlace
	@ManyToMany(mappedBy="protocolos")
	private List<Puertadeenlace> puertadeenlaces;

	public Protocolo() {
	}
	public Protocolo(int id ) {
		super();
		this.id = id;
	}
	public Protocolo(int id, String protocolo, List<Nodo> nodos, List<Puertadeenlace> puertadeenlaces) {
		super();
		this.id = id;
		this.protocolo = protocolo;
		this.nodos = nodos;
		this.puertadeenlaces = puertadeenlaces;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProtocolo() {
		return this.protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public List<Nodo> getNodos() {
		return this.nodos;
	}

	public void setNodos(List<Nodo> nodos) {
		this.nodos = nodos;
	}

	public List<Puertadeenlace> getPuertadeenlaces() {
		return this.puertadeenlaces;
	}

	public void setPuertadeenlaces(List<Puertadeenlace> puertadeenlaces) {
		this.puertadeenlaces = puertadeenlaces;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nodos == null) ? 0 : nodos.hashCode());
		result = prime * result + ((protocolo == null) ? 0 : protocolo.hashCode());
		result = prime * result + ((puertadeenlaces == null) ? 0 : puertadeenlaces.hashCode());
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
		if (id != other.id)
			return false;
		if (nodos == null) {
			if (other.nodos != null)
				return false;
		} else if (!nodos.equals(other.nodos))
			return false;
		if (protocolo == null) {
			if (other.protocolo != null)
				return false;
		} else if (!protocolo.equals(other.protocolo))
			return false;
		if (puertadeenlaces == null) {
			if (other.puertadeenlaces != null)
				return false;
		} else if (!puertadeenlaces.equals(other.puertadeenlaces))
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
		json.put("protocolo", this.getProtocolo());
		//relaciones
		JSONArray puertasDeEnlace = new JSONArray();
		for (Puertadeenlace puertaDeEnlace : this.getPuertadeenlaces()) {
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
		this.setProtocolo(json.getString("protocolo"));
		return this;
	}
}