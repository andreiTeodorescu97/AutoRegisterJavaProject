package com.auto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="log")
public class Log {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="message")
	private String message;
	
	@Column(name="id_user")
	private int id_user;
	
	@Column(name="dateMod")
	private String dateMod;
	
	public Log() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	
	

	public String getDateMod() {
		return dateMod;
	}

	public void setDateMod(String dateMod) {
		this.dateMod = dateMod;
	}

	@Override
	public String toString() {
		return "Log [type=" + type + ", message=" + message + ", id_user=" + id_user + "]";
	}
	
	
}
