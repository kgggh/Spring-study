package com.spring.delivery.coupon.service;

import java.sql.Date;

public class CouponVO {
	private int c_id;
	private String c_name;
	private int c_classification;
	private int c_salesprice;
	private Date c_period;
	private Date c_endperiod;
	
	
	public CouponVO() {}


	public int getC_id() {
		return c_id;
	}


	public void setC_id(int c_id) {
		this.c_id = c_id;
	}


	public String getC_name() {
		return c_name;
	}


	public void setC_name(String c_name) {
		this.c_name = c_name;
	}


	public int getC_classification() {
		return c_classification;
	}


	public void setC_classification(int c_classification) {
		this.c_classification = c_classification;
	}


	public int getC_salesprice() {
		return c_salesprice;
	}


	public void setC_salesprice(int c_salesprice) {
		this.c_salesprice = c_salesprice;
	}


	public Date getC_period() {
		return c_period;
	}


	public void setC_period(Date c_period) {
		this.c_period = c_period;
	}


	public Date getC_endperiod() {
		return c_endperiod;
	}


	public void setC_endperiod(Date c_endperiod) {
		this.c_endperiod = c_endperiod;
	}


	@Override
	public String toString() {
		return "CouponVO [c_id=" + c_id + ", c_name=" + c_name + ", c_classification=" + c_classification
				+ ", c_salesprice=" + c_salesprice + ", c_period=" + c_period + ", c_endperiod=" + c_endperiod + "]";
	}
		
	
	


}
