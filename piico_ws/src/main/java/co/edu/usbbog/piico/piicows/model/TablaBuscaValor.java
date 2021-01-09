package co.edu.usbbog.piico.piicows.model;

import java.time.LocalDate;

import org.json.JSONObject;

public class TablaBuscaValor {
	
	private String node_id;
	private Double price;	
	
	public TablaBuscaValor() {
	}
	public String getNode_id() {
		return node_id;
	}
	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((node_id == null) ? 0 : node_id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		TablaBuscaValor other = (TablaBuscaValor) obj;
		if (node_id == null) {
			if (other.node_id != null)
				return false;
		} else if (!node_id.equals(other.node_id))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TablaBuscaValor: " + toJson().toString();
	}
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("node_id", this.getNode_id());
		json.put("price", this.getPrice());
		return json;
	}
	
	public TablaBuscaValor fromJson(JSONObject json) {		
		this.setNode_id(json.getString("node_id"));
		this.setPrice(json.getDouble("price"));
		return this;
	}
	
}
