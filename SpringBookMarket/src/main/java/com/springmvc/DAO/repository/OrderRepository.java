package com.springmvc.DAO.repository;

import com.springmvc.DTO.Order;

public interface OrderRepository 
{
	Long saveOrder(Order order);
}
