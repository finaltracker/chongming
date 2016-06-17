package com.login;

import java.math.BigDecimal;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User extends AbstractUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(BigDecimal id) {
		super(id);
	}

	/** full constructor */
	public User(BigDecimal id, String username, String password) {
		super(id, username, password);
	}

}
