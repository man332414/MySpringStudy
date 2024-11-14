package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.DTO.Book;
import com.springmvc.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService 
{
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBookList() 
	{
		System.out.println("BookServiceImpl.getAllBookList() 함수 입장");
		return bookRepository.getAllBookList();
	}
	
}
