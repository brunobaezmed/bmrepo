package com.S1.Sone.models;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import interfaces.UsersInterface;



@Entity
@Table(name="USERSACCESS")
public class Users implements UsersInterface{
	


	private long id;
	private String numberphone;
	private String name;
	private String lastname;
	private String password;
	private String email;
	@OneToOne(targetEntity=Userstime.class,cascade=CascadeType.ALL)
	@JoinColumn(name="id_join",referencedColumnName="id")
	private Userstime utime;

	public Users(){
		
	}
	
	public Users(long id) {
	
		this.id=id;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="Name",nullable=false,length=50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="Lastname",nullable=false,length=50)//error
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Column(name="email",nullable=false,length=100)
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}

	@Column(name="Numberphone",nullable=false,length=15)
	public String getNumberphone() {
		return numberphone;
	}
	public void setNumberphone(String numberphone) {
		this.numberphone = numberphone;
	}
	
	
	@Column(name="Password",nullable=false,length=255)	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public Userstime getutime(){
		return utime;
	}

	public void setutime(Userstime utime) {
		this.utime=utime;
	}

	

	
}
