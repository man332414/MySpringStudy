package com.springmvc.validator;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springmvc.DTO.Book;

public class BookValidator implements Validator 
{
	@Autowired
	private javax.validation.Validator beanValidator;
	
	private Set<Validator> springValidators;
	
	//기본 생성자
	public BookValidator() 
	{
		springValidators = new HashSet<Validator>();
	}

	//springValidator setter
	public void setSpringValidators(Set<Validator> springValidators) {
		this.springValidators = springValidators;
	}

	@Override
	public boolean supports(Class<?> clazz) 
	{
		return Book.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) 
	{
		Set<ConstraintViolation<Object>> violations = beanValidator.validate(target);
		//foreach문 
		for(ConstraintViolation<Object> violation : violations)
		{
			String propertyPath = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			errors.rejectValue(propertyPath, "", message);
		}
		for(Validator validator : springValidators)
		{
			validator.validate(target, errors);
		}
	}

}
