package com.limeira.dscatalog.dto;

import java.io.Serializable;

import com.limeira.dscatalog.services.validation.UserInsertValid;

@UserInsertValid // Annotation for validation email exists
public class UserInsertDTO extends UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String password;

	public UserInsertDTO() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
