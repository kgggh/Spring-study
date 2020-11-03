package com.spring.delivery.cart.service;

import java.util.ArrayList;

public class CartVOList {
	ArrayList<CartVO> cartList;
	
	public CartVOList() {
		cartList = new ArrayList<>();
	}

	public ArrayList<CartVO> getCartList() {
		return cartList;
	}

	public void setCartList(ArrayList<CartVO> cartList) {
		this.cartList = cartList;
	}

	@Override
	public String toString() {
		return "CartVOList [cartList=" + cartList + "]";
	}

    
	
	

	
	
}
