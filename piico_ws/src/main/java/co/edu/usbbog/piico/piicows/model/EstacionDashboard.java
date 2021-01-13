package co.edu.usbbog.piico.piicows.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.json.JSONObject;

import net.bytebuddy.asm.Advice.This;

public class EstacionDashboard {

	private String node_id;
	private LocalDate date;
	private String sensor_id;
	private String price;
	
	
	public EstacionDashboard() {
	}

	public String getNode_id() {
		return node_id;
	}

	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	

	public String getSensor_id() {
		return sensor_id;
	}

	public void setSensor_id(String sensor_id) {
		this.sensor_id = sensor_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((node_id == null) ? 0 : node_id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((sensor_id == null) ? 0 : sensor_id.hashCode());
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
		EstacionDashboard other = (EstacionDashboard) obj;
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
		if (sensor_id == null) {
			if (other.sensor_id != null)
				return false;
		} else if (!sensor_id.equals(other.sensor_id))
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
		json.put("sensor", this.getSensor_id());
		return json;
	}
	
	public EstacionDashboard fromJson(JSONObject json) {		
		this.setNode_id(json.getString("estacion"));
		this.setDate(LocalDate.parse(json.getString("date")));
		this.setPrice(json.getString("price"));
		this.setSensor_id(json.getString("sensor"));
		return this;
	}
}
