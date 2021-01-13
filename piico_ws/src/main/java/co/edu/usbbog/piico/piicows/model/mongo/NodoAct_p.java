package co.edu.usbbog.piico.piicows.model.mongo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import co.edu.usbbog.piico.piicows.model.TablaBuscaValor;
import net.bytebuddy.asm.Advice.This;

public class NodoAct_p {
	
	private String Node_id;
	private LocalDate date;
	private String request;
	private List<ActuadorAct_p> actuadores;
	
	public NodoAct_p() {
	}
	public String getNode_id() {
		return Node_id;
	}
	public void setNode_id(String node_id) {
		Node_id = node_id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public List<ActuadorAct_p> getActuadores() {
		return actuadores;
	}
	public void setActuadores(List<ActuadorAct_p> actuadores) {
		this.actuadores = actuadores;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Node_id == null) ? 0 : Node_id.hashCode());
		result = prime * result + ((actuadores == null) ? 0 : actuadores.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((request == null) ? 0 : request.hashCode());
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
		NodoAct_p other = (NodoAct_p) obj;
		if (Node_id == null) {
			if (other.Node_id != null)
				return false;
		} else if (!Node_id.equals(other.Node_id))
			return false;
		if (actuadores == null) {
			if (other.actuadores != null)
				return false;
		} else if (!actuadores.equals(other.actuadores))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (request == null) {
			if (other.request != null)
				return false;
		} else if (!request.equals(other.request))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Nodo_ACT: " + toJson().toString();
	}
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("node_id", this.getNode_id());
		json.put("date", this.getDate());
		json.put("request", this.getRequest());
		json.put("actuators", this.getActuadores());
		return json;
	}
	
	public NodoAct_p fromJson(JSONObject json) {		
		this.setNode_id(json.getString("node_id"));
		this.setDate(LocalDate.parse(json.getString("date")));
		this.setRequest(json.getString("request"));
		JSONArray jsonActuadores = json.getJSONArray("actuators");
		List<ActuadorAct_p> actuadores = new ArrayList<ActuadorAct_p>();
		for(int i = 0; i< jsonActuadores.length(); i++) {
			ActuadorAct_p n = new ActuadorAct_p().fromJson(jsonActuadores.getJSONObject(i));
			actuadores.add(n);
		}
		this.setActuadores(actuadores);
		return this;
	}
}
