package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the PLACEORDER database table.
 * 
 */
@Entity
@Table(name="PLACEORDER", schema= "TESTDB")
@NamedQuery(name="Placeorder.findAll", query="SELECT p FROM Placeorder p")
public class Placeorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long userid;

	private BigDecimal orderid;

	private BigDecimal prodid;

	public Placeorder() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public BigDecimal getOrderid() {
		return this.orderid;
	}

	public void setOrderid(BigDecimal orderid) {
		this.orderid = orderid;
	}

	public BigDecimal getProdid() {
		return this.prodid;
	}

	public void setProdid(BigDecimal prodid) {
		this.prodid = prodid;
	}

}