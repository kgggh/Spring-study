package com.spring.delivery.menuoption.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.delivery.menu.service.MenuService;
//import com.spring.delivery.menu.service.MenuVO;
import com.spring.delivery.menu.service.MenuVO;
import com.spring.delivery.menuoption.service.MenuOptionService;
import com.spring.delivery.menuoption.service.MenuOptionSortService;
import com.spring.delivery.menuoption.service.MenuOptionSortVO;
import com.spring.delivery.menuoption.service.MenuOptionVO;

@Service("menuOptionSortService")
public class MenuOptionSortServiceImpl implements MenuOptionSortService {
	@Autowired
	private MenuOptionSortDAO menuOptionSortDAO;
	
	public MenuOptionSortServiceImpl() {
		System.out.println(">> MenuServiceImpl() 객체생성");
	}
	
	@Override
	public List<MenuOptionSortVO> selectOptionSort(MenuVO vo) {
		// TODO Auto-generated method stub
		return menuOptionSortDAO.selectOptionSort(vo);
	}

	@Override
	public int insertOptionSort(MenuOptionSortVO vo) {
		return menuOptionSortDAO.insertOptionSort(vo);
	}

	@Override
	public int selectOptionSortCount(MenuVO vo) {
		return menuOptionSortDAO.selectOptionSortCount(vo);
	}

	@Override
	public int disableOpSort(int op_s_id) {
		return menuOptionSortDAO.disableOpSort(op_s_id);
	}
	@Override
	public MenuOptionSortVO selectFirstOpSortID(MenuVO vo) {
		return menuOptionSortDAO.selectFirstOpSortID(vo);
	}

}
