package com.spring.delivery.menuoption.service;

import java.util.List;

import com.spring.delivery.menu.service.MenuVO;

public interface MenuOptionSortService {
	 /* public MenuVO selectOneMenu(String id); */
	 public List<MenuOptionSortVO> selectOptionSort(MenuVO vo);
	 public int insertOptionSort(MenuOptionSortVO vo);
	 public int selectOptionSortCount(MenuVO vo);
	 public int disableOpSort(int op_s_id);
	 public MenuOptionSortVO selectFirstOpSortID(MenuVO vo);
}
