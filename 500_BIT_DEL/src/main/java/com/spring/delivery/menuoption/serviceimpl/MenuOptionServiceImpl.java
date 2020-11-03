package com.spring.delivery.menuoption.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.delivery.menu.service.MenuService;
//import com.spring.delivery.menu.service.MenuVO;
import com.spring.delivery.menu.service.MenuVO;
import com.spring.delivery.menuoption.service.MenuOptionService;
import com.spring.delivery.menuoption.service.MenuOptionSortVO;
import com.spring.delivery.menuoption.service.MenuOptionVO;

@Service("menuOptionService")
public class MenuOptionServiceImpl implements MenuOptionService {
	@Autowired
	private MenuOptionDAO menuOptionDAO;
	
	public MenuOptionServiceImpl() {
		System.out.println(">> MenuServiceImpl() 객체생성");
	}
	
	@Override
	public List<MenuOptionVO> selectAllOption(MenuVO vo) {

		return menuOptionDAO.selectAllOption(vo);
	}

	@Override
	public List<MenuOptionVO> selectFirstOption(MenuOptionVO vo) {
		return menuOptionDAO.selectFirstOption(vo);
	}

	@Override
	public List<MenuOptionVO> selectSortOption(MenuOptionSortVO optionSort) {
		return menuOptionDAO.selectSortOption(optionSort);
	}

	@Override
	public int updateOption(MenuOptionVO vo) {
		return menuOptionDAO.updateOption(vo);
	}

	@Override
	public int insertOption(MenuOptionVO vo) {
		return menuOptionDAO.insertOption(vo);
	}



	@Override
	public int disableOption(MenuOptionVO vo) {
		return menuOptionDAO.disableOption(vo);
	}

	@Override
	public MenuOptionVO selectOneOption(int op_id) {
		return menuOptionDAO.selectOneOption(op_id);
	}

	@Override
	public int selectOptionCount(MenuVO vo) {
		return menuOptionDAO.selectOptionCount(vo);
	}


}
