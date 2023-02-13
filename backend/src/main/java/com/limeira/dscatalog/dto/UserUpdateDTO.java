package com.limeira.dscatalog.dto;

import java.io.Serializable;

import com.limeira.dscatalog.services.validation.UserUpdateValid;

//Annotation for validation email exists
@UserUpdateValid 
public class UserUpdateDTO extends UserDTO {

	private static final long serialVersionUID = 1L;
	
	
	public UserUpdateDTO() {
		super();
	}

}
