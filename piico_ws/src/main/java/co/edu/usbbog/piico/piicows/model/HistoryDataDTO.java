package co.edu.usbbog.piico.piicows.model;

import java.time.LocalDate;

import org.json.JSONArray;
import org.json.JSONObject;

import co.edu.usbbog.piico.piicows.model.mysql.Actuador;
import co.edu.usbbog.piico.piicows.model.mysql.Nodo;
import co.edu.usbbog.piico.piicows.model.mysql.Protocolo;

public class HistoryDataDTO {
	
	private LocalDate date;
	private Double price;
	public HistoryDataDTO(LocalDate date, Double price) {
		this.date = date;
		this.price = price;
	}
	public HistoryDataDTO() {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
		HistoryDataDTO other = (HistoryDataDTO) obj;
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
		return true;
	}
	@Override
	public String toString() {
		return "HistoryDataDTO: " + toJson().toString();
	}
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("date", this.getDate());
		json.put("price", this.getPrice());
		return json;
	}
	
	public HistoryDataDTO fromJson(JSONObject json) {		
		this.setDate(LocalDate.parse(json.getString("date")));
		this.setPrice(json.getDouble("price"));
		return this;
	}
}
