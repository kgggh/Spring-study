package com.spring.delivery.menuoption.service;

import java.util.ArrayList;

public class MenuOptionVOList {
	ArrayList<MenuOptionVO> list;
	
	public MenuOptionVOList() {
	        list = new ArrayList<>();
	}

	public ArrayList<MenuOptionVO> getList() {
		return list;
	}

	public void setList(ArrayList<MenuOptionVO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "MenuOptionVOList [list=" + list + "]";
	}

	 
	
	

	
	
}
