package com.spring.delivery.menuoption.service;

import java.util.List;

import com.spring.delivery.menu.service.MenuVO;

public interface MenuOptionService {
	 /* public MenuVO selectOneMenu(String id); */
	 public List<MenuOptionVO> selectAllOption(MenuVO vo);
	 public List<MenuOptionVO> selectFirstOption(MenuOptionVO vo);
	 public List<MenuOptionVO> selectSortOption(MenuOptionSortVO optionSort);
	 public int updateOption(MenuOptionVO vo); 
	 public int insertOption(MenuOptionVO vo); 
	 public int disableOption(MenuOptionVO vo);
	 public MenuOptionVO selectOneOption(int op_id);
	 public int selectOptionCount(MenuVO vo);
}
