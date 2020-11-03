package com.spring.delivery.menu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.delivery.menu.service.MenuService;
//import com.spring.delivery.menu.service.MenuVO;
import com.spring.delivery.menu.service.MenuVO;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDAO menuDAO;
	
	public MenuServiceImpl() {
		System.out.println(">> MenuServiceImpl() 객체생성");
	}
	
	@Override
	public List<MenuVO> selectAllMenu(MenuVO vo) {
		// TODO Auto-generated method stub
		return menuDAO.selectAllMenu(vo);
	}

	@Override
	public List<MenuVO> selectBestMenu(MenuVO vo) {
		// TODO Auto-generated method stub
		return menuDAO.selectBestMenu(vo);
	}

	@Override
	public int menuCount(MenuVO vo) {
		return menuDAO.menuCount(vo);
	}

	@Override
	public List<MenuVO> selectMenuPaging(MenuVO vo) {
		return menuDAO.selectMenuPaging(vo);
	}

	@Override
	public MenuVO selectOnemenu(MenuVO vo) {
		return menuDAO.selectOnemenu(vo);
	}

	@Override
	public List<MenuVO> selectSortmenu(MenuVO vo) {
		return menuDAO.selectSortmenu(vo);
	}

	@Override
	public int updateMenu(MenuVO vo) {
		return menuDAO.updateMenu(vo);	
	}

	@Override
	public int insertMenu(MenuVO vo) {
		return menuDAO.insertMenu(vo);
	}

	@Override
	public List<MenuVO> selectFirstMenu(MenuVO vo) {
		return menuDAO.selectFirstMenu(vo);
	}

	@Override
	public int disableMenu(int menu_id) {
		return menuDAO.disableMenu(menu_id);
	}

	@Override
	public int selectS_id(MenuVO vo) {
		return menuDAO.selectS_id(vo);
	}



}
