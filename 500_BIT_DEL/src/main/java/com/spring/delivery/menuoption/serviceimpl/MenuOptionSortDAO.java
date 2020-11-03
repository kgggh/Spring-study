package com.spring.delivery.menuoption.serviceimpl;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.delivery.menu.service.MenuVO;
import com.spring.delivery.menuoption.service.MenuOptionSortVO;
import com.spring.delivery.menuoption.service.MenuOptionVO;

@Repository("MenuOptionSortDAO")
public class MenuOptionSortDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public MenuOptionSortDAO() {
		System.out.println(">> MenuOptionSortDAO() 객체생성");
	}
	
	
	public List<MenuOptionSortVO> selectOptionSort(MenuVO vo) {
		return mybatis.selectList("MenuOptionSortDAO.selectOptionSort", vo);
	}
	public int selectOptionSortCount(MenuVO vo) {
		return mybatis.selectOne("MenuOptionSortDAO.selectOptionSortCount", vo);
	}
	public int insertOptionSort(MenuOptionSortVO vo) {
		return mybatis.insert("MenuOptionSortDAO.insertOptionSort", vo);
	}
	
	public int disableOpSort(int op_s_id) {
		return mybatis.update("MenuOptionSortDAO.disableOpSort", op_s_id);
	}
	public MenuOptionSortVO selectFirstOpSortID(MenuVO vo) {
		return mybatis.selectOne("MenuOptionSortDAO.selectFirstOpSortID", vo);
	}
}
