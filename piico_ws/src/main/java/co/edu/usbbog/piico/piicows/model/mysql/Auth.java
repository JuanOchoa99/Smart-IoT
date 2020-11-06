package co.edu.usbbog.piico.piicows.model.mysql;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the auth database table.
 * 
 */
@Entity
@NamedQuery(name="Auth.findAll", query="SELECT a FROM Auth a")
public class Auth implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String pass;

	private String topic;

	private String user;

	//bi-directional many-to-one association to Puertadeenlace
	@ManyToOne
	@JoinColumn(name="puertaDeEnlace")
	private Puertadeenlace puertadeenlace;

	public Auth() {
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

}