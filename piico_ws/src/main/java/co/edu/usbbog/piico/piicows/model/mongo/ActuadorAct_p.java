package co.edu.usbbog.piico.piicows.model.mongo;

import java.time.LocalDateTime;

import org.json.JSONObject;

public class ActuadorAct_p {

	private String actuadorId;
	private String order;
	
	public ActuadorAct_p() {
	}
	public String getActuadorId() {
		return actuadorId;
	}
	public void setActuadorId(String actuadorId) {
		this.actuadorId = actuadorId;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actuadorId == null) ? 0 : actuadorId.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
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
		ActuadorAct_p other = (ActuadorAct_p) obj;
		if (actuadorId == null) {
			if (other.actuadorId != null)
				return false;
		} else if (!actuadorId.equals(other.actuadorId))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Nodo_ACT: " + toJson().toString();
	}
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("actuator_id", this.getActuadorId());
		json.put("order", this.getOrder());
		return json;
	}
	
	public ActuadorAct_p fromJson(JSONObject json) {		
		this.setActuadorId(json.getString("actuator_id"));
		this.setOrder(json.getString("order"));
		return this;
	}
	
}
