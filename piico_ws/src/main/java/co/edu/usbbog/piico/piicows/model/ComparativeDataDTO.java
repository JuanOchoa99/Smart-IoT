package co.edu.usbbog.piico.piicows.model;

import java.time.LocalDate;

import org.json.JSONArray;
import org.json.JSONObject;

import co.edu.usbbog.piico.piicows.model.mysql.Actuador;
import co.edu.usbbog.piico.piicows.model.mysql.Nodo;
import co.edu.usbbog.piico.piicows.model.mysql.Protocolo;

public class ComparativeDataDTO {
	
	private LocalDate date;
	private Double price;
	private String estacion;
	
	public ComparativeDataDTO(LocalDate date, Double price, String estacion) {
		this.date = date;
		this.price = price;
		this.estacion = estacion;
	}
	public ComparativeDataDTO() {
	}


	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getEstacion() {
		return estacion;
	}
	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((estacion == null) ? 0 : estacion.hashCode());
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
		ComparativeDataDTO other = (ComparativeDataDTO) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (estacion == null) {
			if (other.estacion != null)
				return false;
		} else if (!estacion.equals(other.estacion))
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
		json.put("price", this.getPrice());
		json.put("estacion", this.getEstacion());
		return json;
	}
	
	public ComparativeDataDTO fromJson(JSONObject json) {		
		this.setDate(LocalDate.parse(json.getString("date")));
		this.setPrice(json.getDouble("price"));
		this.setEstacion(json.getString("estacion"));
		return this;
	}
}
