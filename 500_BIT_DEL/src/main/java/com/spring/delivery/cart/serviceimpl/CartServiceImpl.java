package com.spring.delivery.cart.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.delivery.cart.service.CartService;
import com.spring.delivery.cart.service.CartVO;
import com.spring.delivery.menu.service.MenuService;
//import com.spring.delivery.menu.service.MenuVO;
import com.spring.delivery.menu.service.MenuVO;

@Service("cartService")
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDAO cartDAO;

	@Override
	public List<CartVO> selectAllCart(int m_id) {
		return cartDAO.selectAllCart(m_id);
	}

	@Override
	public List<CartVO> selectScbCart(int m_id) {
		return cartDAO.selectScbCart(m_id);
	}

	@Override
	public List<CartVO> selectCartlist(CartVO scb_num) {
		return cartDAO.selectCartlist(scb_num);
	}

	@Override
	public List<CartVO> selectMenuCart(int m_id) {
		return cartDAO.selectMenuCart(m_id);
	}

	@Override
	public int selectScbCartCount(int m_id) {
		return cartDAO.selectScbCartCount(m_id);
	}

	@Override
	public int maxScbNum(int m_id) {
		return cartDAO.maxScbNum(m_id);
	}

	@Override
	public void insertCart(CartVO cart) {
		cartDAO.insertCart(cart);
	}

	@Override
	public void deleteCart(int scb_num) {
		cartDAO.deleteCart(scb_num);
		
	}

	@Override
	public void updateCart(CartVO cart) {
		cartDAO.updateCart(cart);
		
	}
	


}
