package com.springmvc.DAO.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springmvc.DTO.Book;

public interface BookRepository 
{
	List<Book> getAllBookList();

	List<Book> getBookListByCategory(String category);

	Set<Book> getBookListByFilter(Map<String, List<String>> filter);
}