package com.spring.delivery.menu.service;

import java.util.ArrayList;

public class MenuVOList {
	ArrayList<MenuVO> list;
	
	public MenuVOList() {
	        list = new ArrayList<>();
	}

	public ArrayList<MenuVO> getList() {
		return list;
	}

	public void setList(ArrayList<MenuVO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "MenuVOList [list=" + list + "]";
	}        
	
	

	
	
}
