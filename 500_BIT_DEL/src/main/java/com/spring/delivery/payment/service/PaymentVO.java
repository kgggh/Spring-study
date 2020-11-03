package com.spring.delivery.payment.service;

public class PaymentVO {
	private int p_id;
	private String payment_method;
	private String card_company;
	private String card_num;
	private int o_id;
	
	public PaymentVO() {}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public String getCard_company() {
		return card_company;
	}

	public void setCard_company(String card_company) {
		this.card_company = card_company;
	}

	public String getCard_num() {
		return card_num;
	}

	public void setCard_num(String card_num) {
		this.card_num = card_num;
	}

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	@Override
	public String toString() {
		return "PaymentVO [p_id=" + p_id + ", payment_method=" + payment_method + ", card_company=" + card_company
				+ ", card_num=" + card_num + ", o_id=" + o_id + "]";
	}

	
	
}
