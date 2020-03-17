package com.springangular.application.SpringAngular.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer Id;
	
	@NotBlank(message="Name is mandatory")
	private String name;
	
	@NotBlank(message="password is mandatory")
	private String password;
	
	@NotBlank(message="email is mandatory")
	private String email;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	
	public User()
	{
		
	}

	public User(Integer id, String name, String password, String email) {
		super();
		Id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}
	
	
	

}
