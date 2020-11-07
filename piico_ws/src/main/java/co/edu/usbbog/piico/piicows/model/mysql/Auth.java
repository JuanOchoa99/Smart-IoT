package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;
import org.json.JSONObject;

/**
 * The persistent class for the auth database table.
 * 
 */
@Entity
@Table(name = "auth")
@NamedQuery(name = "Auth.findAll", query = "SELECT a FROM Auth a")
public class Auth implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false, length = 512)
	private String pass;

	@Column(nullable = false, length = 45)
	private String topic;

	@Column(nullable = false, length = 80)
	private String user;

	// bi-directional many-to-one association to Puertadeenlace
	@ManyToOne
	@JoinColumn(name = "puertaDeEnlace", nullable = false)
	private Puertadeenlace puertadeenlace;

	public Auth() {
	}

	public Auth(int id) {
		this.id = id;
	}

	public Auth(int id, String pass, String topic, String user) {
		this.id = id;
		this.pass = pass;
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

	public Puertadeenlace getPuertadeenlace() {
		return this.puertadeenlace;
	}

	public void setPuertadeenlace(Puertadeenlace puertadeenlace) {
		this.puertadeenlace = puertadeenlace;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((puertadeenlace == null) ? 0 : puertadeenlace.hashCode());
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
		if (puertadeenlace == null) {
			if (other.puertadeenlace != null)
				return false;
		} else if (!puertadeenlace.equals(other.puertadeenlace))
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
		Puertadeenlace puertaDeEnlace = this.getPuertadeenlace();
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