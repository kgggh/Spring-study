package com.spring.delivery.menu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.delivery.menu.service.MenuSortService;
import com.spring.delivery.menu.service.MenuSortVO;
import com.spring.delivery.menu.service.MenuVO;
//import com.spring.delivery.menu.service.MenuVO;


@Service("menuSortService")
public class MenuSortServiceImpl implements MenuSortService {
	@Autowired
	private MenuSortDAO menuSortDAO;
	
	public MenuSortServiceImpl() {
		System.out.println(">> MenuSortServiceImpl() 객체생성");
	}

	@Override
	public List<MenuSortVO> selectAllMenuSort(MenuVO vo) {
		return menuSortDAO.selectAllMenuSort(vo);
	}


	@Override
	public int insertMenuSort(MenuSortVO sort) {
		return menuSortDAO.insertMenuSort(sort);
	}

	@Override
	public int disableMenuSort(int m_sort_id) {
		return menuSortDAO.disableMenuSort(m_sort_id);
	}
	
	@Override
	public int selectFirstSortID(MenuVO vo) {
		return menuSortDAO.selectFirstSortID(vo);
	}

}
