package com.limeira.dscatalog.services.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.limeira.dscatalog.dto.UserInsertDTO;
import com.limeira.dscatalog.entities.User;
import com.limeira.dscatalog.repositories.UserRepository;
import com.limeira.dscatalog.resources.exceptions.FieldMessage;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {

	@Autowired
	private UserRepository repository;
	
	@Override
	public void initialize(UserInsertValid constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(UserInsertDTO userIsertDTO, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		// Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à Lista
		User user = repository.findByEmail(userIsertDTO.getEmail());
		if (user != null) {
			list.add(new FieldMessage("email", "Email já existe"));
		}

		for (FieldMessage fm : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(fm.getMessage()).addPropertyNode(fm.getFieldName())
					.addConstraintViolation();
		}

		return list.isEmpty();
	}

}
