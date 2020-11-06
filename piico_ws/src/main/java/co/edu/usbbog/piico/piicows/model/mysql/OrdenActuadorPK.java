package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;

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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrdenactuadorPK)) {
			return false;
		}
		OrdenactuadorPK castOther = (OrdenactuadorPK)other;
		return 
			this.id.equals(castOther.id)
			&& this.actuadorId.equals(castOther.actuadorId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id.hashCode();
		hash = hash * prime + this.actuadorId.hashCode();
		
		return hash;
	}
}