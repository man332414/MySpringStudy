package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.springmvc.DAO.service.BookService;
import com.springmvc.DAO.service.CartService;
import com.springmvc.DTO.Book;
import com.springmvc.DTO.Cart;
import com.springmvc.DTO.CartItem;
import com.springmvc.exception.BookIdException;

@Controller
@RequestMapping(value = "/cart")
public class CartController 
{
	@Autowired
	private CartService cartService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public String requestCartId(HttpServletRequest req)
	{
		System.out.println("controller.request CartId 입장");
		String sessionId = req.getSession(true).getId();
		return "redirect:/cart/" + sessionId; 
	}
	
	@PostMapping
	public @ResponseBody Cart create(@RequestBody Cart cart)
	{
		System.out.println("controller.create 입장");
		return cartService.create(cart);
	}
	
	@GetMapping("/{cartId}")
	public String requestCartList(@PathVariable(value="cartId") String cartId, Model model)
	{
		System.out.println("Controller.requestCartList 입장");
		Cart cart = cartService.read(cartId);
		model.addAttribute("cart", cart);
		return "cart";
	}
	
	@PutMapping("/{cartId}")
	public @ResponseBody Cart read(@PathVariable(value="cartId") String cartId)
	{
		return cartService.read(cartId);
	}
	
	@PutMapping("/add/{bookId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void addCartByNewItem(@PathVariable String bookId, HttpServletRequest request)
	{
		System.out.println("addCart 입장");
		String sessionId = request.getSession(true).getId();
		Cart cart = cartService.read(sessionId);
		if(cart == null)
		{
			System.out.println("cart가 있나요?");
			cart = cartService.create(new Cart(sessionId));
		}
		
		Book book = bookService.getBookById(bookId);
		
		if(book == null)
		{
			System.out.println("book이 있나요?");
			throw new IllegalArgumentException(new BookIdException(bookId));
		}
		
		cart.addCartItem(new CartItem(book));
		cartService.update(sessionId, cart);
	}
	
	@PutMapping("/remove/{bookId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public String removeCartByItem(@PathVariable String bookId, HttpServletRequest request)
	{
		//장바구니 아이디 가져오기
		String sessionId = request.getSession(true).getId();
		System.out.println("지우러 왔는데 여기 " + sessionId + "맞나요?");
		Cart cart = cartService.read(sessionId);
		if(cart == null)
		{
			cart = cartService.create(new Cart(sessionId));
		}
		Book book = bookService.getBookById(bookId);
		if(book == null)
		{
			throw new IllegalArgumentException(new BookIdException(bookId));
		}
		cart.removeCartItem(new CartItem(book));
		cartService.update(sessionId, cart);
		
		return "redirect:/cart/" + sessionId; 
	}
	
	@DeleteMapping("/{cartId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void deleteCartList(@PathVariable(value="cartId") String cartId)
	{
		cartService.delete(cartId);
	}
}
