package com.springmvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.DAO.service.BookService;
import com.springmvc.DTO.Book;

public class BookIdValidator implements ConstraintValidator<BookId, String>
{
	
	@Autowired
	private BookService bookService;

	@Override
	public void initialize(BookId constraintAnnotation) 
	{
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) 
	{
		System.out.println("isValid 함수 입장");
		Book book;
		try 
		{
			book = bookService.getBookById(value);
		}
		catch(Exception e)
		{
			return true;
		}
		System.out.println(book);
		
		if(book != null)
		{
			return false;
		}
		
		return true;
	}
	
}
