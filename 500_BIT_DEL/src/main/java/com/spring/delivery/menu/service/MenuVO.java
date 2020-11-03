package com.spring.delivery.menu.service;

import java.util.List;

public class MenuVO {
	private int menu_id;
	private String menu_name;
	private int menu_price;
	private int s_id;
	private int menu_rank;
	private String menu_photo;
	private int menu_best;
	private String menu_reference;
	private int m_sort_id;
	private int menu_disable;
	private int begin;
	private int end;
	private List<MenuVO> menuVOList;
	
	
	public MenuVO() {}
	
	
	public List<MenuVO> getMenuVOList() {
		return menuVOList;
	}


	public void setMenuVOList(List<MenuVO> menuVOList) {
		this.menuVOList = menuVOList;
	}


	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public int getMenu_price() {
		return menu_price;
	}

	public void setMenu_price(int menu_price) {
		this.menu_price = menu_price;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public int getMenu_rank() {
		return menu_rank;
	}

	public void setMenu_rank(int menu_rank) {
		this.menu_rank = menu_rank;
	}

	public String getMenu_photo() {
		return menu_photo;
	}

	public void setMenu_photo(String menu_photo) {
		this.menu_photo = menu_photo;
	}

	public int getMenu_best() {
		return menu_best;
	}

	public void setMenu_best(int menu_best) {
		this.menu_best = menu_best;
	}

	public String getMenu_reference() {
		return menu_reference;
	}

	public void setMenu_reference(String menu_reference) {
		this.menu_reference = menu_reference;
	}

	public int getM_sort_id() {
		return m_sort_id;
	}

	public void setM_sort_id(int m_sort_id) {
		this.m_sort_id = m_sort_id;
	}

	
	public int getMenu_disable() {
		return menu_disable;
	}


	public void setMenu_disable(int menu_disable) {
		this.menu_disable = menu_disable;
	}


	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}


	@Override
	public String toString() {
		return "MenuVO [menu_id=" + menu_id + ", menu_name=" + menu_name + ", menu_price=" + menu_price + ", s_id="
				+ s_id + ", menu_rank=" + menu_rank + ", menu_photo=" + menu_photo + ", menu_best=" + menu_best
				+ ", menu_reference=" + menu_reference + ", m_sort_id=" + m_sort_id + ", menu_disable=" + menu_disable
				+ ", begin=" + begin + ", end=" + end + ", menuVOList=" + menuVOList + "]";
	}

	

	
	
}
