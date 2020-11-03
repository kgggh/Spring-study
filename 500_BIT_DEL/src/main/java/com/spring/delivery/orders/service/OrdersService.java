package com.spring.delivery.orders.service;

import java.util.List;
import java.util.Map;

public interface OrdersService {
	public List<SalseVO> salse_Management(int s_id);
	public Integer getOrderCount(int s_id);
	public Integer OrderCount(int m_id);
	public List<OrdersVO> OrderReview(Map<String, Integer> map);
	public void insertOrder(OrdersVO order);
	public Integer maxScoNum(int m_id);
}
