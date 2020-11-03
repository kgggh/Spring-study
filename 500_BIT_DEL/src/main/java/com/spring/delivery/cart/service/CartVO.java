package com.spring.delivery.cart.service;

import java.util.List;

public class CartVO {
	private int b_id;
	private int scb_num;
	private int s_id;
	private int menu_id;
	private int b_price;
	private int b_amount;
	private int m_id;
	private int op_id;
	private int op_price;
	private String menu_name;
	private String op_name;

	public CartVO() {}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public int getScb_num() {
		return scb_num;
	}

	public void setScb_num(int scb_num) {
		this.scb_num = scb_num;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public int getB_price() {
		return b_price;
	}

	public void setB_price(int b_price) {
		this.b_price = b_price;
	}

	public int getB_amount() {
		return b_amount;
	}

	public void setB_amount(int b_amount) {
		this.b_amount = b_amount;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public int getOp_id() {
		return op_id;
	}

	public void setOp_id(int op_id) {
		this.op_id = op_id;
	}

	
	public int getOp_price() {
		return op_price;
	}

	public void setOp_price(int op_price) {
		this.op_price = op_price;
	}

	
	
	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getOp_name() {
		return op_name;
	}

	public void setOp_name(String op_name) {
		this.op_name = op_name;
	}

	@Override
	public String toString() {
		return "CartVO [b_id=" + b_id + ", scb_num=" + scb_num + ", s_id=" + s_id + ", menu_id=" + menu_id
				+ ", b_price=" + b_price + ", b_amount=" + b_amount + ", m_id=" + m_id + ", op_id=" + op_id
				+ ", op_price=" + op_price + ", menu_name=" + menu_name + ", op_name=" + op_name + "]";
	}

	
}
