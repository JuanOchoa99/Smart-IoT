package co.edu.usbbog.piico.piicows.model;

import java.time.LocalDate;

import org.json.JSONArray;
import org.json.JSONObject;

import co.edu.usbbog.piico.piicows.model.mysql.Actuador;
import co.edu.usbbog.piico.piicows.model.mysql.Nodo;
import co.edu.usbbog.piico.piicows.model.mysql.Protocolo;

public class MapDataDTO {
	
	private LocalDate date;
	private Double lan;
	private Double lon;
	private String estacion;
	
	public MapDataDTO(LocalDate date, Double lan, Double lon, String estacion) {
		this.date = date;
		this.lan = lan;
		this.lon = lon;
		this.estacion = estacion;
	}
	public MapDataDTO() {
	}


	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getEstacion() {
		return estacion;
	}
	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}
	public Double getLan() {
		return lan;
	}
	public void setLan(Double lan) {
		this.lan = lan;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((estacion == null) ? 0 : estacion.hashCode());
		result = prime * result + ((lan == null) ? 0 : lan.hashCode());
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
		MapDataDTO other = (MapDataDTO) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (estacion == null) {
			if (other.estacion != null)
				return false;
		} else if (!estacion.equals(other.estacion))
			return false;
		if (lan == null) {
			if (other.lan != null)
				return false;
		} else if (!lan.equals(other.lan))
			return false;
		if (lon == null) {
			if (other.lon != null)
				return false;
		} else if (!lon.equals(other.lon))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ComparativeDataDTO: " + toJson().toString();
	}
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("date", this.getDate());
		json.put("lan", this.getLan());
		json.put("lon", this.getLon());
		json.put("estacion", this.getEstacion());
		return json;
	}
	
	public MapDataDTO fromJson(JSONObject json) {		
		this.setDate(LocalDate.parse(json.getString("date")));
		this.setLan(json.getDouble("lan"));
		this.setLon(json.getDouble("lon"));
		this.setEstacion(json.getString("estacion"));
		return this;
	}
}
