package com.limeira.dscatalog.dto;

import java.io.Serializable;

import com.limeira.dscatalog.services.validation.UserInsertValid;

//Annotation for validation email exists
@UserInsertValid 
public class UserInsertDTO extends UserDTO {

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
