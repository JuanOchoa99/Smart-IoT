package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;

import org.json.JSONObject;


/**
 * The persistent class for the auth database table.
 * 
 */
@Entity
@Table(name="auth")
@NamedQuery(name="Auth.findAll", query="SELECT a FROM Auth a")
public class Auth implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=512)
	private String pass;

	@Column(length=45)
	private String puerto;

	@Column(length=45)
	private String qos;

	@Column(nullable=false, length=45)
	private String topic;

	@Column(nullable=false, length=80)
	private String user;

	//bi-directional many-to-one association to PuertaDeEnlace
	@ManyToOne
	@JoinColumn(name="puerta_de_enlace", nullable=false)
	private PuertaDeEnlace puertaDeEnlaceBean;

	public Auth() {
	}
	
	public Auth(int id) {
		this.id = id;
	}
	
	public Auth(int id, String pass, String puerto, String qos, String topic, String user) {
		super();
		this.id = id;
		this.pass = pass;
		this.puerto = puerto;
		this.qos = qos;
		this.topic = topic;
		this.user = user;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPuerto() {
		return this.puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	public String getQos() {
		return this.qos;
	}

	public void setQos(String qos) {
		this.qos = qos;
	}

	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public PuertaDeEnlace getPuertaDeEnlaceBean() {
		return this.puertaDeEnlaceBean;
	}

	public void setPuertaDeEnlaceBean(PuertaDeEnlace puertaDeEnlaceBean) {
		this.puertaDeEnlaceBean = puertaDeEnlaceBean;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((puertaDeEnlaceBean == null) ? 0 : puertaDeEnlaceBean.hashCode());
		result = prime * result + ((puerto == null) ? 0 : puerto.hashCode());
		result = prime * result + ((qos == null) ? 0 : qos.hashCode());
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Auth other = (Auth) obj;
		if (id != other.id)
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (puertaDeEnlaceBean == null) {
			if (other.puertaDeEnlaceBean != null)
				return false;
		} else if (!puertaDeEnlaceBean.equals(other.puertaDeEnlaceBean))
			return false;
		if (puerto == null) {
			if (other.puerto != null)
				return false;
		} else if (!puerto.equals(other.puerto))
			return false;
		if (qos == null) {
			if (other.qos != null)
				return false;
		} else if (!qos.equals(other.qos))
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Puerta de enlace: " + toJson().toString();
	}
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("id", this.getId());
		json.put("pass", this.getPass());
		json.put("topic", this.getTopic());
		json.put("user", this.getUser());
		// relaciones
		PuertaDeEnlace puertaDeEnlace = this.getPuertaDeEnlaceBean();
		json.put("puertaDeEnlace", puertaDeEnlace.toJson().get("id"));
		return json;
	}

	public Auth fromJson(JSONObject json) {
		this.setId(json.getInt("id"));
		this.setPass(json.getString("pass"));
		this.setTopic(json.getString("topic"));
		this.setUser(json.getString("user"));
		return this;
	}
}