package co.edu.usbbog.piico.piicows.model.mongo;

import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class GPS {
	@Id
	private ObjectId id;
	
	private Float lon;
	private Float lat;
	public GPS() {
		super();
	}
	public GPS(Float lon, Float lat) {
		super();
		this.lon = lon;
		this.lat = lat;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public Float getLon() {
		return lon;
	}
	public void setLon(Float lon) {
		this.lon = lon;
	}
	public Float getLat() {
		return lat;
	}
	public void setLat(Float lat) {
		this.lat = lat;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lat == null) ? 0 : lat.hashCode());
		result = prime * result + ((lon == null) ? 0 : lon.hashCode());
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
		GPS other = (GPS) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lat == null) {
			if (other.lat != null)
				return false;
		} else if (!lat.equals(other.lat))
			return false;
		if (lon == null) {
			if (other.lon != null)
				return false;
		} else if (!lon.equals(other.lon))
			return false;
		return true;
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("_id", this.getId());
		json.put("lon", this.getLon());
		json.put("lat", this.getLat());
		return json;
	}

	@Override
	public String toString() {
		return toJson().toString();
	}
}
