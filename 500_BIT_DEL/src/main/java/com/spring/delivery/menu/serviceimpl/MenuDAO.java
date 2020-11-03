package com.spring.delivery.menu.serviceimpl;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.delivery.menu.service.MenuVO;

@Repository("MenuDAO")
public class MenuDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public MenuDAO() {
		System.out.println(">> MenuDAO() 객체생성");
	}
	

	public List<MenuVO> selectAllMenu(MenuVO vo) {
		return mybatis.selectList("MenuDAO.selectAllmenu", vo);
	}
	
	public int selectS_id(MenuVO vo) {
		return mybatis.selectOne("MenuDAO.selectS_id", vo);
	}
	public List<MenuVO> selectBestMenu(MenuVO vo) {
		return mybatis.selectList("MenuDAO.selectBestmenu", vo);
	}
	
	public int menuCount(MenuVO vo) {
		return mybatis.selectOne("MenuDAO.menuCount", vo);
	}
	
	public List<MenuVO> selectMenuPaging(MenuVO vo) {
		return mybatis.selectList("MenuDAO.selectMenuPaging", vo);
	}
	
	public List<MenuVO> selectFirstMenu(MenuVO vo) {
		return mybatis.selectList("MenuDAO.selectFirstMenu", vo);
	}
	
	public MenuVO selectOnemenu(MenuVO vo) {
		return mybatis.selectOne("MenuDAO.selectOnemenu", vo);
	}
	
	public List<MenuVO> selectSortmenu(MenuVO vo) {
		return mybatis.selectList("MenuDAO.selectSortmenu", vo);
	}
	
	public int updateMenu(MenuVO vo) {
		return mybatis.update("MenuDAO.updateMenu", vo);
	}

	public int insertMenu(MenuVO vo) {
		return mybatis.insert("MenuDAO.insertMenu", vo);

	}
	public int disableMenu(int menu_id) {
		return mybatis.update("MenuDAO.disableMenu", menu_id);

	}

	

}
