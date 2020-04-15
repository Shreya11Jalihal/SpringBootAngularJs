package com.springangular.application.SpringAngular.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue
	private long Id;

	private String name;

	private String password;

	private String email;

	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}

}
