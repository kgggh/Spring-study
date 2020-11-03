package com.spring.delivery.orders.serviceimpl;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.delivery.orders.service.OrdersService;
import com.spring.delivery.orders.service.OrdersVO;
import com.spring.delivery.orders.service.SalseVO;



@Service("ordersService")
public class OrdersServiceImpl implements OrdersService{
	@Autowired
	private OrdersDAO ordersDAO;

	@Override
	public List<SalseVO> salse_Management(int s_id) {
		
		return ordersDAO.salse_Management(s_id);
	}

	@Override 
	public Integer getOrderCount(int s_id) {
		return ordersDAO.getOrderCount(s_id);
	}
	 
	@Override
	public Integer OrderCount(int m_id) {
		return ordersDAO.OrderCount(m_id);
	}

	@Override
	public List<OrdersVO> OrderReview(Map<String, Integer> map) {
		return ordersDAO.OrderReview(map);
	}

	@Override
	public void insertOrder(OrdersVO order) {
		ordersDAO.insertOrder(order);
	}

	@Override
	public Integer maxScoNum(int m_id) {
		return ordersDAO.maxScoNum(m_id);
	}

	

	


}
