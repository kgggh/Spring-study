package com.spring.delivery.store.service;

public class TipVO {
	private int tip_id;
	private String dong;
	private int tip_price;
	private int s_id;

	
	public TipVO() {}


	public int getTip_id() {
		return tip_id;
	}


	public void setTip_id(int tip_id) {
		this.tip_id = tip_id;
	}


	public String getDong() {
		return dong;
	}


	public void setDong(String dong) {
		this.dong = dong;
	}


	public int getTip_price() {
		return tip_price;
	}


	public void setTip_price(int tip_price) {
		this.tip_price = tip_price;
	}


	public int getS_id() {
		return s_id;
	}


	public void setS_id(int s_id) {
		this.s_id = s_id;
	}


	@Override
	public String toString() {
		return "TipVO [tip_id=" + tip_id + ", dong=" + dong + ", tip_price=" + tip_price + ", s_id=" + s_id + "]";
	}


	
}
