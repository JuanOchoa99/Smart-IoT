package co.edu.usbbog.piico.piicows.model.mongo;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.json.JSONObject;


public class Gateway {
	
	private ObjectId id;
	
	private String gateway_id ;
	private String date;
	private String topico;
	private GPS gps;
	private List<Station> stations;
	
	
	public Gateway() {
		super();
	}

	public Gateway(String gateway_id, String date, GPS gps, List<Station> stations) {
		super();
		this.gateway_id = gateway_id;
		this.date = date;
		this.gps = gps;
		this.stations = stations;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getGateway_id() {
		return gateway_id;
	}

	public void setGateway_id(String gateway_id) {
		this.gateway_id = gateway_id;
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

	public List<Station> getNodos() {
		return stations;
	}

	public void setNodos(List<Station> stations) {
		this.stations = stations;
	}

	public String getTopico() {
		return topico;
	}

	public void setTopico(String topico) {
		this.topico = topico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((gateway_id == null) ? 0 : gateway_id.hashCode());
		result = prime * result + ((gps == null) ? 0 : gps.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((stations == null) ? 0 : stations.hashCode());
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
		Gateway other = (Gateway) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (gateway_id == null) {
			if (other.gateway_id != null)
				return false;
		} else if (!gateway_id.equals(other.gateway_id))
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
		if (stations == null) {
			if (other.stations != null)
				return false;
		} else if (!stations.equals(other.stations))
			return false;
		return true;
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("gateway_id", this.getGateway_id());
		json.put("date", this.getDate());
		JSONObject jsonGPS = this.getGps().toJson();
		json.put("gps", jsonGPS);
		JSONArray jsonNodos = new JSONArray(this.getNodos());
		json.put("nodes", jsonNodos);
		return json;
	}
	
	public Gateway fromJson(JSONObject json) {
		this.setGateway_id(json.getString("Gateway_id"));
		this.setDate(json.getString("date"));
		JSONObject jsonGPS = json.getJSONObject("gps");
		this.setGps(new GPS().fromJson(jsonGPS));
		JSONArray jsonNodos = json.getJSONArray("nodes");
		List<Station> stations = new ArrayList<Station>();
		for(int i = 0; i< jsonNodos.length(); i++) {
			Station n = new Station().fromJson(jsonNodos.getJSONObject(i));
			stations.add(n);
		}
		this.setNodos(stations);
		return this;
	}

	@Override
	public String toString() {
		return "Gateway"+toJson().toString();
	}
	
}
