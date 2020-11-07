package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;

import org.json.JSONObject;

/**
 * The primary key class for the orden_actuador database table.
 * 
 */
@Embeddable
public class OrdenActuadorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=45)
	private String id;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=45)
	private String actuador;

	public OrdenActuadorPK() {
	}
	public OrdenActuadorPK(String id) {
		super();
		this.id = id;
	}
	public OrdenActuadorPK(String id, String actuador) {
		super();
		this.id = id;
		this.actuador = actuador;
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getActuador() {
		return this.actuador;
	}
	public void setActuador(String actuador) {
		this.actuador = actuador;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrdenActuadorPK)) {
			return false;
		}
		OrdenActuadorPK castOther = (OrdenActuadorPK)other;
		return 
			this.id.equals(castOther.id)
			&& this.actuador.equals(castOther.actuador);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id.hashCode();
		hash = hash * prime + this.actuador.hashCode();
		
		return hash;
	}
	@Override
	public String toString() {
		return "OrdenActuadorPK: "+toJson().toString();
	}
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("id", this.getId());
		json.put("actuador_id", this.getActuador());
		return json;
	}
	public OrdenActuadorPK fromJson(JSONObject json) {		
		this.setId(json.getString("id"));
		this.setActuador(json.getString("apellidos"));
		return this;
	}
}