package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the STOREUSER database table.
 * 
 */
@Entity
@Table(name="STOREUSER", schema= "TESTDB")
@NamedQuery(name="Storeuser.findAll", query="SELECT s FROM Storeuser s")
public class Storeuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long userid;

	private String pwd;

	private String username;

	public Storeuser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}