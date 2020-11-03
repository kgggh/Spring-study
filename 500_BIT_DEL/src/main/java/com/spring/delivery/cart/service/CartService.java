package com.spring.delivery.cart.service;

import java.util.List;

public interface CartService {
	public List<CartVO> selectAllCart(int m_id);
	public List<CartVO> selectCartlist(CartVO scb_num);
	public List<CartVO> selectScbCart(int m_id);
	public List<CartVO> selectMenuCart(int m_id);
	public int selectScbCartCount(int m_id);
	public int maxScbNum(int m_id);
	public void insertCart(CartVO cart);
	public void deleteCart(int scb_num);
	public void updateCart(CartVO cart);
}
