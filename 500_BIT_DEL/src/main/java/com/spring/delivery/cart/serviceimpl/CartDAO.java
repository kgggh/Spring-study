package com.spring.delivery.cart.serviceimpl;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.delivery.cart.service.CartVO;
import com.spring.delivery.menu.service.MenuVO;

@Repository("CartDAO")
public class CartDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public CartDAO() {
		
	}
	
	public List<CartVO> selectAllCart(int m_id) {
		return mybatis.selectList("CartDAO.selectAllCart", m_id);
	}
	
	
	public List<CartVO> selectCartlist(CartVO scb_num) {
		return mybatis.selectList("CartDAO.selectCartlist", scb_num);
	}
	public List<CartVO> selectScbCart(int m_id) {
		return mybatis.selectList("CartDAO.selectScbCart", m_id);
	}
	
	public List<CartVO> selectMenuCart(int m_id) {
		return mybatis.selectList("CartDAO.selectMenuCart", m_id);
	}
	
	public int selectScbCartCount(int m_id) {
		return mybatis.selectOne("CartDAO.selectScbCartCount", m_id);
	}
	
	public int maxScbNum(int m_id) {
		return mybatis.selectOne("CartDAO.maxScbNum", m_id);
	}
	
	public void insertCart(CartVO cart) {
		mybatis.insert("CartDAO.insertCart", cart);
	}
	
	public void deleteCart(int scb_num) {
		mybatis.delete("CartDAO.deleteCart", scb_num);
	}
	
	public void updateCart(CartVO cart) {
		mybatis.update("CartDAO.updateCart", cart);
	}
	
}
