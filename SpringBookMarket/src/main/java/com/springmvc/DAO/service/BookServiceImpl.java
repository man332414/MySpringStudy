package com.springmvc.DAO.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.DAO.repository.BookRepository;
import com.springmvc.DTO.Book;

@Service
public class BookServiceImpl implements BookService 
{
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBookList() 
	{
		System.out.println("BookServiceImpl.getAllBookList() 함수 통과");
		return bookRepository.getAllBookList();
	}

	@Override
	public List<Book> getBookListByCategory(String category) 
	{
		System.out.println("BookService.getBookListByCategory()에 들어왔고 내가 받은 파라미터는 : " + category);
		List<Book> booksByCategory = bookRepository.getBookListByCategory(category);
		return booksByCategory;
	}

	@Override
	public Set<Book> getBookListByFilter(Map<String, List<String>> Filter) 
	{
		System.out.println("Service.getBookListByFilter() 함수 입장 : " + Filter);
		Set<Book> booksByFilter = bookRepository.getBookListByFilter(Filter);
		
		return booksByFilter;
	}

	@Override
	public Book getBookById(String bookId) 
	{
		System.out.println("Service.getBookById 입장 : " + bookId);
		Book bookById = bookRepository.getBookById(bookId);
		return bookById;
	}
	
}
