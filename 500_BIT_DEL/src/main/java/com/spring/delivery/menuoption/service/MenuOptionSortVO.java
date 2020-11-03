package com.spring.delivery.menuoption.service;

public class MenuOptionSortVO {
	private int op_s_id;
	private String op_s_name;
	private int op_s_rank;
	private int menu_id;
	private int op_s_disable;

	public MenuOptionSortVO() {}

	public int getOp_s_id() {
		return op_s_id;
	}

	public void setOp_s_id(int op_s_id) {
		this.op_s_id = op_s_id;
	}

	public String getOp_s_name() {
		return op_s_name;
	}

	public void setOp_s_name(String op_s_name) {
		this.op_s_name = op_s_name;
	}

	public int getOp_s_rank() {
		return op_s_rank;
	}

	public void setOp_s_rank(int op_s_rank) {
		this.op_s_rank = op_s_rank;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	
	public int getOp_s_disable() {
		return op_s_disable;
	}

	public void setOp_s_disable(int op_s_disable) {
		this.op_s_disable = op_s_disable;
	}

	@Override
	public String toString() {
		return "MenuOptionSortVO [op_s_id=" + op_s_id + ", op_s_name=" + op_s_name + ", op_s_rank=" + op_s_rank
				+ ", menu_id=" + menu_id + ", op_s_disable=" + op_s_disable + "]";
	}


	
}
