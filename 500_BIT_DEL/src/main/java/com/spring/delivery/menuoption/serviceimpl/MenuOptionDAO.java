package com.spring.delivery.menuoption.serviceimpl;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.delivery.menu.service.MenuVO;
import com.spring.delivery.menuoption.service.MenuOptionSortVO;
import com.spring.delivery.menuoption.service.MenuOptionVO;

@Repository("MenuOptionDAO")
public class MenuOptionDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public MenuOptionDAO() {
		System.out.println(">> MenuOptionDAO() 객체생성");
	}
	
	
	public List<MenuOptionVO> selectAllOption(MenuVO vo) {
		return mybatis.selectList("MenuOptionDAO.selectAllOption", vo);
	}
	public List<MenuOptionVO> selectFirstOption(MenuOptionVO vo) {
		return mybatis.selectList("MenuOptionDAO.selectFirstOption", vo);
	}
	
	public List<MenuOptionVO> selectSortOption(MenuOptionSortVO optionSort) {
		return mybatis.selectList("MenuOptionDAO.selectSortOption", optionSort);
	}
	public int updateOption(MenuOptionVO vo) {
		return mybatis.update("MenuOptionDAO.updateOption", vo);
	}

	public int insertOption(MenuOptionVO vo) {
		return mybatis.insert("MenuOptionDAO.insertOption", vo);
	}
	public int disableOption(MenuOptionVO vo) {
		return mybatis.update("MenuOptionDAO.disableOption", vo);
	}	
	
	public MenuOptionVO selectOneOption(int op_id) {
		return mybatis.selectOne("MenuOptionDAO.selectOneOption", op_id);
	}
	
	public int selectOptionCount(MenuVO vo) {
		return mybatis.selectOne("MenuOptionDAO.selectOptionCount", vo);
	}
}
