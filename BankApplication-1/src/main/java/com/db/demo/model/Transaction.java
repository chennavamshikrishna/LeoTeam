package com.db.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Transaction {
	
	@Id
	@GeneratedValue
	private int transid;
	private int acc1no;
	private int acc2no;
	private int ttype;
	private Date tdate;
	private int amount;
	public int getTransid() {
		return transid;
	}
	public void setTransid(int transid) {
		this.transid = transid;
	}
	public int getAcc1no() {
		return acc1no;
	}
	public void setAcc1no(int acc1no) {
		this.acc1no = acc1no;
	}
	public int getAcc2no() {
		return acc2no;
	}
	public void setAcc2no(int acc2no) {
		this.acc2no = acc2no;
	}
	public int getTtype() {
		return ttype;
	}
	public void setTtype(int ttype) {
		this.ttype = ttype;
	}
	public Date getTdate() {
		return tdate;
	}
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Transaction [transid=" + transid + ", acc1no=" + acc1no + ", acc2no=" + acc2no + ", ttype=" + ttype
				+ ", tdate=" + tdate + ", amount=" + amount + "]";
	}
	

}
