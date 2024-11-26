package com.springmvc.DAO.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springmvc.DTO.Order;

@Repository
public class OrderRepositoryImpl implements OrderRepository 
{
	private Map<Long, Order> listOfOrders;
	private long nextOrderId;
	
	
	
	public OrderRepositoryImpl() {
		listOfOrders = new HashMap<Long, Order>();
		nextOrderId = 2000;
	}



	@Override
	public Long saveOrder(Order order) 
	{
//		System.out.println("repository saveOrder 입장");
		order.setOrderId(getNextOrderId());
		listOfOrders.put(order.getOrderId(), order);
		return order.getOrderId();
	}



	private synchronized Long getNextOrderId() 
	{
//		System.out.println("getNextOrderId 입장");
		return nextOrderId++;
	}

}
