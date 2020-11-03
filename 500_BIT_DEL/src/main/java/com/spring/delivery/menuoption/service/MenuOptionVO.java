package com.spring.delivery.menuoption.service;

public class MenuOptionVO {
	private int op_id;
	private String op_name;
	private int op_price;
	private int menu_id;
	private int op_s_id;
	private int op_disable;

	public MenuOptionVO() {}

	public int getOp_id() {
		return op_id;
	}

	public void setOp_id(int op_id) {
		this.op_id = op_id;
	}

	public String getOp_name() {
		return op_name;
	}

	public void setOp_name(String op_name) {
		this.op_name = op_name;
	}

	public int getOp_price() {
		return op_price;
	}

	public void setOp_price(int op_price) {
		this.op_price = op_price;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	
	public int getOp_s_id() {
		return op_s_id;
	}

	public void setOp_s_id(int op_s_id) {
		this.op_s_id = op_s_id;
	}

	public int getOp_disable() {
		return op_disable;
	}

	public void setOp_disable(int op_disable) {
		this.op_disable = op_disable;
	}

	@Override
	public String toString() {
		return "MenuOptionVO [op_id=" + op_id + ", op_name=" + op_name + ", op_price=" + op_price + ", menu_id="
				+ menu_id + ", op_s_id=" + op_s_id + ", op_disable=" + op_disable + "]";
	}



	

	
}
