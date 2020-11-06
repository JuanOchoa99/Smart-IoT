package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * The primary key class for the ordenactuador database table.
 * 
 */
@Embeddable
public class OrdenactuadorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=45)
	private String id;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=45)
	private String actuadorId;

	public OrdenactuadorPK() {
	}
	
	public OrdenactuadorPK(String id) {
		super();
		this.id = id;
	}
	public OrdenactuadorPK(String id, String actuador_id) {
		super();
		this.actuadorId =actuador_id;
		this.id = id;
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getActuadorId() {
		return this.actuadorId;
	}
	public void setActuadorId(String actuadorId) {
		this.actuadorId = actuadorId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdenactuadorPK other = (OrdenactuadorPK) obj;
		if (actuadorId == null) {
			if (other.actuadorId != null)
				return false;
		} else if (!actuadorId.equals(other.actuadorId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actuadorId == null) ? 0 : actuadorId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("id", this.getId());
		json.put("actuador_id", this.getActuadorId());
		return json;
	}
	public OrdenactuadorPK fromJson(JSONObject json) {		
		this.setId(json.getString("id"));
		this.setActuadorId(json.getString("apellidos"));
		return this;
	}
}