package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the PLACEORDER database table.
 * 
 */
@Entity
@Table(name="Placeorder", schema= "TESTDB")
@NamedQuery(name="Placeorder.findAll", query="SELECT p FROM Placeorder p")
public class Placeorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long orderid;

	private BigDecimal prodid;

	private BigDecimal userid;

	public Placeorder() {
	}

	public long getOrderid() {
		return this.orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public BigDecimal getProdid() {
		return this.prodid;
	}

	public void setProdid(BigDecimal prodid) {
		this.prodid = prodid;
	}

	public BigDecimal getUserid() {
		return this.userid;
	}

	public void setUserid(BigDecimal userid) {
		this.userid = userid;
	}

}