package com.mongodb.model;

import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class User {

	@Id
	private String id;
	
	@Size(min=2, max=20, message="le champs doit etre entre 2 et 30 caractère")
	private String username;
	
	private String password;
	
	public String getID() {
		return this.id;
	}
	
	public void setID(String Id) {
		this.id = Id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User() {}
	
	
}
