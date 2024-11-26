package com.springmvc.DAO.service;

import com.springmvc.DTO.Order;

public interface OrderService 
{
	void confirmOrder(String bookId, long quantity);
	Long saveOrder(Order order);
}
