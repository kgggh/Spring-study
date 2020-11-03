package com.spring.delivery.orders.service;

import java.util.ArrayList;

public class OrderVOList {
	ArrayList<OrdersVO> orderList;
	
	public OrderVOList() {
		orderList = new ArrayList<>();
	}

	public ArrayList<OrdersVO> getCartList() {
		return orderList;
	}

	public void setOrderList(ArrayList<OrdersVO> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "OrderVOList [orderList=" + orderList + "]";
	}

    
	
	

	
	
}
