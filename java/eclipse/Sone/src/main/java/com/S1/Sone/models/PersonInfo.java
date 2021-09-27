package com.S1.Sone.models;

import java.io.Serializable;

public class PersonInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String fullname;
	private String email;
	private String addedBirth;
	private String numberphone;
	
	
	public String getNumberphone() {
		return numberphone;
	}
	public void setNumberphone(String numberphone) {
		this.numberphone = numberphone;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddedBirth() {
		return addedBirth;
	}
	public void setAddedBirth(String addedBirth) {
		this.addedBirth = addedBirth;
	}
	
	
	
	
	
	
}