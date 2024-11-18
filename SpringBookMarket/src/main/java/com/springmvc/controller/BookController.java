package com.springmvc.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.DAO.service.BookService;
import com.springmvc.DTO.Book;

@Controller
@RequestMapping("/books")
public class BookController 
{
	@Autowired
	private BookService bookService;
//	 autowired 하려면 BookService 객체도 component scan이 되어야 한다.
	
	@GetMapping
	public String requestBookList(Model model)
	{
		System.out.println("BooksController");
		List<Book> list = bookService.getAllBookList();
		model.addAttribute("bookList", list);
		return "books";
	}
	
	@GetMapping("/all")
	public ModelAndView requestAllbooks(Model model)
	{
		System.out.println("Books/all. Controller");
		ModelAndView mav = new ModelAndView();
		System.out.println("model and view object created");
		List<Book> list = bookService.getAllBookList();
		mav.addObject("bookList", list);
		mav.setViewName("books");
		return mav;
	}
	
	@GetMapping("/{category}")
	public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model)
	{
		System.out.println("Controller.requestBooksByCategroy() 함수에 들어왔고 내가 받은 파라미터는? : "+bookCategory);
		List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
		System.out.println("모델을 다녀왔고 booksByCategory의 첫번째 인덱스의 이름은? : " + booksByCategory.get(0).getBookId());
		model.addAttribute("bookList", booksByCategory);
		return "books";
	}
	
	@GetMapping("/filter/{bookFilter}")
	public String requestBooksByFilter(
			@MatrixVariable(pathVar = "bookFilter") 
			Map<String, List<String>> bookFilter, Model model)
	{
		System.out.println("controller.requestBooksByfilter() 함수 입장 : " + bookFilter);
		Set<Book> booksByfilter = bookService.getBookListByFilter(bookFilter);
		model.addAttribute("bookList", booksByfilter);
		return "books";
	}
	
	@GetMapping("/book")
	public String requestBookById(@RequestParam("id") String bookId, Model model)
	{
		System.out.println("Controller.requestBookById 입장 : " + bookId);
		Book bookById = bookService.getBookById(bookId);
		model.addAttribute("book", bookById);
		return "book";
	}
	
	@GetMapping("/add")
	public String requestAddBookForm(@ModelAttribute("NewBook") Book book)
	{
		System.out.println("Controller.requestAddBookForm 입장 : " + book.getBookId());
		return "addBook";
	}
	
	@PostMapping("/add")
	public String submitAddBookForm(@ModelAttribute("NewBook") Book book)
	{
		System.out.println("Controller.submitAddBookForm 입장 : " + book.getBookId());
		bookService.setNewBook(book);
		return "redirect:/books";
	}
	
	@ModelAttribute
	public void addAttribute(Model model)
	{
		model.addAttribute("addTitle", "신규 도서 등록");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.setAllowedFields("bookId", "name", "unitPrice", "author", "description", "publisher", "category", "unitsInStock", "totalPages", "releaseDate", "contion");
	}
}
