package com.asiantech.spring.etity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
public class Account {

	private int id;
	@NotNull
	@Size(min = 2, max = 8, message = "Username must be between 2 and 8 characters long.")
	private String name;
	@NotNull
	@Size(min = 2, max = 8, message = "Username must be between 2 and 8 characters long.")
	private String firstname;
	@NotNull
	@Size(min = 2, max = 8, message = "Username must be between 2 and 8 characters long.")
	private String lastname;
	

    public Account(){}
	public Account(int id, String name, String firstname, String lastname) {
		super();
		this.id = id;
		this.name = name;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	

}
