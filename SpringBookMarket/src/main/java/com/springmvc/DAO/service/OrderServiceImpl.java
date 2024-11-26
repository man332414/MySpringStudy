package com.springmvc.DAO.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.DAO.repository.BookRepository;
import com.springmvc.DAO.repository.CartRepository;
import com.springmvc.DAO.repository.OrderRepository;
import com.springmvc.DTO.Book;
import com.springmvc.DTO.Order;

@Service
public class OrderServiceImpl implements OrderService 
{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired 
	private CartService cartService;

	public void confirmOrder(String bookId, long quantity) 
	{
		Book bookById = bookRepository.getBookById(bookId);
		if(bookById.getUnitsInStock() < quantity)
		{
			throw new IllegalArgumentException("품절입니다. 사용가능한 재고수 : " + bookById.getUnitsInStock());
		}
		bookById.setUnitsInStock(bookById.getUnitsInStock() - quantity);
	}

	public Long saveOrder(Order order) 
	{
//		System.out.println("service saveOrder 입장");
		Long orderId = orderRepository.saveOrder(order);
		cartService.delete(order.getCart().getCartId());
		
		return orderId;
	}

	
}
