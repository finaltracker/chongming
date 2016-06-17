package com.login;

import java.math.BigDecimal;

/**
 * AbstractUser entity provides the base persistence definition of the User
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUser implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private String username;
	private String password;

	// Constructors

	/** default constructor */
	public AbstractUser() {
	}

	/** full constructor */
	public AbstractUser(String username, String password) {
		this.username = username;
		this.password = password;
	}

	// Property accessors

	public AbstractUser(BigDecimal id) {
		this.id = id;
	}

	public AbstractUser(BigDecimal id, String username, String password) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public BigDecimal getId() {

		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}