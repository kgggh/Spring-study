package com.spring.delivery.orders.service;

public class OrdersVO {
	
	private int o_id;
	private int sco_num;
	private String o_date;
	private int menu_id;
	private int s_id;
	private int o_price;
	private int b_amount;
	private int pay_means;
	private int m_id;
	private String reqeust;
	private int add_id;
	private int pay_met;
	private String card_company;
	private int card_num;
	private int op_id;
	private String menu_name;
	private String s_name;
	
	
	public OrdersVO() {
		super();
	}




	public int getO_id() {
		return o_id;
	}


	public void setO_id(int o_id) {
		this.o_id = o_id;
	}


	public int getSco_num() {
		return sco_num;
	}


	public void setSco_num(int sco_num) {
		this.sco_num = sco_num;
	}


	public String getO_date() {
		return o_date;
	}


	public void setO_date(String o_date) {
		this.o_date = o_date;
	}


	public int getMenu_id() {
		return menu_id;
	}


	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}


	public int getS_id() {
		return s_id;
	}


	public void setS_id(int s_id) {
		this.s_id = s_id;
	}


	public int getO_price() {
		return o_price;
	}


	public void setO_price(int o_price) {
		this.o_price = o_price;
	}


	public int getB_amount() {
		return b_amount;
	}


	public void setB_amount(int b_amount) {
		this.b_amount = b_amount;
	}


	public int getPay_means() {
		return pay_means;
	}


	public void setPay_means(int pay_means) {
		this.pay_means = pay_means;
	}


	public int getM_id() {
		return m_id;
	}


	public void setM_id(int m_id) {
		this.m_id = m_id;
	}


	public String getReqeust() {
		return reqeust;
	}


	public void setReqeust(String reqeust) {
		this.reqeust = reqeust;
	}


	public int getAdd_id() {
		return add_id;
	}


	public void setAdd_id(int add_id) {
		this.add_id = add_id;
	}


	public int getPay_met() {
		return pay_met;
	}


	public void setPay_met(int pay_met) {
		this.pay_met = pay_met;
	}


	public String getCard_company() {
		return card_company;
	}


	public void setCard_company(String card_company) {
		this.card_company = card_company;
	}


	public int getCard_num() {
		return card_num;
	}


	public void setCard_num(int card_num) {
		this.card_num = card_num;
	}


	public int getOp_id() {
		return op_id;
	}


	public void setOp_id(int op_id) {
		this.op_id = op_id;
	}

	

	public String getMenu_name() {
		return menu_name;
	}


	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}


	public String getS_name() {
		return s_name;
	}


	public void setS_name(String s_name) {
		this.s_name = s_name;
	}


	@Override
	public String toString() {
		return "OrdersVO [o_id=" + o_id + ", sco_num=" + sco_num + ", o_date=" + o_date + ", menu_id=" + menu_id
				+ ", s_id=" + s_id + ", o_price=" + o_price + ", b_amount=" + b_amount + ", pay_means=" + pay_means
				+ ", m_id=" + m_id + ", reqeust=" + reqeust + ", add_id=" + add_id + ", pay_met=" + pay_met
				+ ", card_company=" + card_company + ", card_num=" + card_num + ", op_id=" + op_id + ", menu_name="
				+ menu_name + ", s_name=" + s_name + "]";
	}



	
}
