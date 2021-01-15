package co.edu.usbbog.piico.piicows.model.mqtt;

import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import co.edu.usbbog.piico.piicows.model.TablaBuscaValor;
import co.edu.usbbog.piico.piicows.model.mysql.Actuador;
import co.edu.usbbog.piico.piicows.model.mysql.Protocolo;
import co.edu.usbbog.piico.piicows.model.mysql.Sensor;

public class Con_p {
	private String node_id;
	private String descripcionNode;
	private LocalDateTime date;
	private byte estado;
	private int frecuenciaCaptura;
	private int frecuenciaEnvio;
	private List<Protocolo> protocolos;
	private List<Sensor> sensors;
	private List<Actuador> actuadores;
	
	public Con_p() {
	}

	public String getNode_id() {
		return node_id;
	}

	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}

	public String getDescripcionNode() {
		return descripcionNode;
	}

	public void setDescripcionNode(String descripcionNode) {
		this.descripcionNode = descripcionNode;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public byte getEstado() {
		return estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public int getFrecuenciaCaptura() {
		return frecuenciaCaptura;
	}

	public void setFrecuenciaCaptura(int frecuenciaCaptura) {
		this.frecuenciaCaptura = frecuenciaCaptura;
	}

	public int getFrecuenciaEnvio() {
		return frecuenciaEnvio;
	}

	public void setFrecuenciaEnvio(int frecuenciaEnvio) {
		this.frecuenciaEnvio = frecuenciaEnvio;
	}

	public List<Protocolo> getProtocolos() {
		return protocolos;
	}

	public void setProtocolos(List<Protocolo> protocolos) {
		this.protocolos = protocolos;
	}

	public List<Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

	public List<Actuador> getActuadores() {
		return actuadores;
	}

	public void setActuadores(List<Actuador> actuadores) {
		this.actuadores = actuadores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actuadores == null) ? 0 : actuadores.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((descripcionNode == null) ? 0 : descripcionNode.hashCode());
		result = prime * result + estado;
		result = prime * result + frecuenciaCaptura;
		result = prime * result + frecuenciaEnvio;
		result = prime * result + ((node_id == null) ? 0 : node_id.hashCode());
		result = prime * result + ((protocolos == null) ? 0 : protocolos.hashCode());
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
		Con_p other = (Con_p) obj;
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
		if (descripcionNode == null) {
			if (other.descripcionNode != null)
				return false;
		} else if (!descripcionNode.equals(other.descripcionNode))
			return false;
		if (estado != other.estado)
			return false;
		if (frecuenciaCaptura != other.frecuenciaCaptura)
			return false;
		if (frecuenciaEnvio != other.frecuenciaEnvio)
			return false;
		if (node_id == null) {
			if (other.node_id != null)
				return false;
		} else if (!node_id.equals(other.node_id))
			return false;
		if (protocolos == null) {
			if (other.protocolos != null)
				return false;
		} else if (!protocolos.equals(other.protocolos))
			return false;
		if (sensors == null) {
			if (other.sensors != null)
				return false;
		} else if (!sensors.equals(other.sensors))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Con_p";
	}
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("node_id", this.getNode_id());
		json.put("descripcion", this.getDescripcionNode());
		json.put("fecha", this.getDate());
		json.put("estado",this.getEstado());
		json.put("sampling_frequency", this.getFrecuenciaCaptura());
		json.put("send_frequency", this.getFrecuenciaEnvio());
		JSONArray protocols = new JSONArray();
		JSONArray protocolos = new JSONArray();
		for (Protocolo protocolo : this.getProtocolos()) {
			protocolos.put(protocolo.toJson().getString("id"));
		}
		json.put("interfaces", protocolos);
		JSONArray sensors = new JSONArray();
		for (Sensor sensor : this.getSensors()) {
			sensors.put(sensor.toJson().getString("id"));
		}
		JSONArray Actuadores = new JSONArray();
		for (Actuador actuador : this.getActuadores()) {
			Actuadores.put(actuador.toJson().getString("id"));
		}
		json.put("actuators", Actuadores);
		return json;
	}
	
	public Con_p fromJson(JSONObject json) {		
		this.setNode_id(json.getString("node_id"));
		
		return this;
	}
	
}
