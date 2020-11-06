package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;
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

}