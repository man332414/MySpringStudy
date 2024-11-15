package com.springmvc.DAO.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springmvc.DTO.Book;

public interface BookService 
{
	List<Book> getAllBookList();

	List<Book> getBookListByCategory(String category);

	Set<Book> getBookListByFilter(Map<String, List<String>> Filter);

	Book getBookById(String bookId);
}
