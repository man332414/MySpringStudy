package com.springmvc.exception;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CartException extends RuntimeException implements Serializable 
{
	private String cartId;
	
	public CartException(String cartId)
	{
		this.cartId = cartId;
	}
	
	public String getCartId()
	{
		return cartId;
	}
}
