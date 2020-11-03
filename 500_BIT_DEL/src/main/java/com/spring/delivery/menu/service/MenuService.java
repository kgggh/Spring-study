package com.spring.delivery.menu.service;

import java.util.List;

public interface MenuService {
	 /* public MenuVO selectOneMenu(String id); */
	 public List<MenuVO> selectAllMenu(MenuVO vo);
	 public List<MenuVO> selectBestMenu(MenuVO vo);
	 public int menuCount(MenuVO vo);
	 public List<MenuVO> selectMenuPaging(MenuVO vo);
	 public MenuVO selectOnemenu(MenuVO vo);
	 public List<MenuVO> selectSortmenu(MenuVO vo);
	 public int updateMenu(MenuVO vo);
	 public int insertMenu(MenuVO vo);
	 public List<MenuVO> selectFirstMenu(MenuVO vo);
	 public int disableMenu(int menu_id);
	 public int selectS_id(MenuVO vo);

}
