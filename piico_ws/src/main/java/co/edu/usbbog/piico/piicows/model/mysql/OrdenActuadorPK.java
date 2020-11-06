package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the orden_actuador database table.
 * 
 */
@Embeddable
public class OrdenActuadorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="orden_id", insertable=false, updatable=false, unique=true, nullable=false, length=45)
	private String ordenId;

	@Column(name="actuador_id", insertable=false, updatable=false, unique=true, nullable=false, length=45)
	private String actuadorId;

	public OrdenActuadorPK() {
	}
	public String getOrdenId() {
		return this.ordenId;
	}
	public void setOrdenId(String ordenId) {
		this.ordenId = ordenId;
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
		if (!(other instanceof OrdenActuadorPK)) {
			return false;
		}
		OrdenActuadorPK castOther = (OrdenActuadorPK)other;
		return 
			this.ordenId.equals(castOther.ordenId)
			&& this.actuadorId.equals(castOther.actuadorId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ordenId.hashCode();
		hash = hash * prime + this.actuadorId.hashCode();
		
		return hash;
	}
}