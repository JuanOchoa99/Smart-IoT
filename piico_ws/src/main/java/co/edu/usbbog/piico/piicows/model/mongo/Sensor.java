package co.edu.usbbog.piico.piicows.model.mongo;

import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Sensor {
	@Id
	private ObjectId id;

	private String type;
	private String sensor_id;
	private String value;
	private String magnitude;

	public Sensor() {
		super();
	}

	public Sensor(String type, String sensor_id, String value, String magnitude) {
		super();
		this.type = type;
		this.sensor_id = sensor_id;
		this.value = value;
		this.magnitude = magnitude;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSensor_id() {
		return sensor_id;
	}

	public void setSensor_id(String sensor_id) {
		this.sensor_id = sensor_id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMagnitude() {
		return magnitude;
	}

	public void setMagnitude(String magnitude) {
		this.magnitude = magnitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((magnitude == null) ? 0 : magnitude.hashCode());
		result = prime * result + ((sensor_id == null) ? 0 : sensor_id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Sensor other = (Sensor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (magnitude == null) {
			if (other.magnitude != null)
				return false;
		} else if (!magnitude.equals(other.magnitude))
			return false;
		if (sensor_id == null) {
			if (other.sensor_id != null)
				return false;
		} else if (!sensor_id.equals(other.sensor_id))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("_id", this.getId());
		json.put("type", this.getType());
		json.put("sensor_id", this.getSensor_id());
		json.put("value", this.getValue());
		json.put("magnitude", this.getMagnitude());
		return json;
	}

	@Override
	public String toString() {
		return toJson().toString();
	}

}
