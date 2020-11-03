package com.spring.delivery.menu.serviceimpl;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.delivery.menu.service.MenuSortVO;
import com.spring.delivery.menu.service.MenuVO;

@Repository("MenuSortDAO")
public class MenuSortDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public MenuSortDAO() {
		System.out.println(">> MenuSortDAO() 객체생성");
	}
	

	
	public List<MenuSortVO> selectAllMenuSort(MenuVO vo) {

		return mybatis.selectList("MenuSortDAO.selectAllmenuSort", vo); 
	}
	
	public int insertMenuSort(MenuSortVO sort) {
		return mybatis.insert("MenuSortDAO.insertMenuSort", sort);

	}
	
	public int disableMenuSort(int m_sort_id) {
		return mybatis.update("MenuSortDAO.disableMenuSort", m_sort_id);

	}
	
	public int selectFirstSortID(MenuVO vo) {
		return mybatis.selectOne("MenuSortDAO.selectFirstSortID", vo);
	}
}
