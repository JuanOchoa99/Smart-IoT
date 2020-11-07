package co.edu.usbbog.piico.piicows.model.mongo;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.json.JSONObject;


public class Nodo {

	private ObjectId id;

	private String node_id;
	private String date;
	private GPS gps;
	private List<Sensor> sensors;

	
	public Nodo() {
		super();
	}

	public Nodo(String node_id, String date, GPS gps, List<Sensor> sensors) {
		super();
		this.node_id = node_id;
		this.date = date;
		this.gps = gps;
		this.sensors = sensors;
	}

	public ObjectId  getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getNode_id() {
		return node_id;
	}

	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public GPS getGps() {
		return gps;
	}

	public void setGps(GPS gps) {
		this.gps = gps;
	}

	public List<Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((gps == null) ? 0 : gps.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((node_id == null) ? 0 : node_id.hashCode());
		result = prime * result + ((sensors == null) ? 0 : sensors.hashCode());
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
		Nodo other = (Nodo) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (gps == null) {
			if (other.gps != null)
				return false;
		} else if (!gps.equals(other.gps))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (node_id == null) {
			if (other.node_id != null)
				return false;
		} else if (!node_id.equals(other.node_id))
			return false;
		if (sensors == null) {
			if (other.sensors != null)
				return false;
		} else if (!sensors.equals(other.sensors))
			return false;
		return true;
	}

	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("node_id", this.getNode_id());
		json.put("date", this.getDate());
		JSONObject jsonGPS = this.getGps().toJson();
		json.put("gps", jsonGPS);
		JSONArray jsonSensores = new JSONArray(this.getSensors());
		json.put("sensors", jsonSensores);
		return json;
	}
	
	public Nodo fromJson(JSONObject json) {
		this.setNode_id(json.getString("node_id"));
		this.setDate(json.getString("date"));
		JSONObject jsonGPS = json.getJSONObject("gps");
		this.setGps(new GPS().fromJson(jsonGPS));
		JSONArray jsonSensores =json.getJSONArray("sensors");
		List<Sensor> sensores = new ArrayList<Sensor>();
		for (int i = 0; i < jsonSensores.length(); i++) {
			Sensor s = new Sensor().fromJson(jsonSensores.getJSONObject(i));
			sensores.add(s);
		}
		this.setSensors(sensores);		
		return this;
	}

	@Override
	public String toString() {
		return "Nodo "+toJson().toString();
	}

}
