package com.S1.Sone.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import interfaces.Utime;

@Entity
@Table(name="Userstime")
public class Userstime implements Utime,Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false,length=23)
	private String birth;
	@Column(updatable=false,length=55)
	private String added;
	
	public Userstime() {
		
		}
	public Userstime(long id) {
		this.id=id;
		}
	
	public String getAdded() {
		return this.added;
		}
	public void setAdded(String added) {
		this.added=added;
		}
	
	
	public long getId() {
		
		return this.id;
		}
	public void setId(long id) {
		this.id=id;
	}
	public String getBirth() {
		
		return birth;
		}
	
	public void setBirth(String birth) {
		this.birth=birth;		
		}
	
	
		
}

	