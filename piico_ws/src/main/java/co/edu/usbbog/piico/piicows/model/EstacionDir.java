package co.edu.usbbog.piico.piicows.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.json.JSONObject;

import net.bytebuddy.asm.Advice.This;

public class EstacionDir {

	private String node_id;
	private LocalDateTime date;
	private String price;
	
	
	public EstacionDir() {
	}

	public String getNode_id() {
		return node_id;
	}

	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
		EstacionDir other = (EstacionDir) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
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
		return "Estacion [node_id=" + node_id + "]";
	}
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("node_id", this.getNode_id());
		json.put("date", this.getDate());
		json.put("price", this.getPrice());
		return json;
	}
	
	public EstacionDir fromJson(JSONObject json) {		
		this.setNode_id(json.getString("estacion"));
		System.out.println(json.get("date").toString());
		this.setDate(LocalDateTime.parse(json.getString("date")));
		this.setPrice(json.getString("price"));
		return this;
	}
}
