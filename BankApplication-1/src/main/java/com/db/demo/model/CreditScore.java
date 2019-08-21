package com.db.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditScore {
	
	@Id
	private String email;
	private String name;
	private int creditScore;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	@Override
	public String toString() {
		return "CreditScore [email=" + email + ", name=" + name + ", creditScore=" + creditScore + ", getEmail()="
				+ getEmail() + ", getName()=" + getName() + ", getCreditScore()=" + getCreditScore() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
