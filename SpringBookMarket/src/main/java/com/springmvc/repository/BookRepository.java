package com.springmvc.repository;

import java.util.List;
import com.springmvc.DTO.Book;

public interface BookRepository 
{
	List<Book> getAllBookList();
}
