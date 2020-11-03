package com.spring.delivery.coupon.service;


public class CouponBoxVO {
	private int cb_id;
	private int m_id;
	private int c_id;
	private int cb_coupon_use;
	private int o_id;
	
	
	
	public CouponBoxVO() {}
	
	
	public int getCb_id() {
		return cb_id;
	}
	public void setCb_id(int cb_id) {
		this.cb_id = cb_id;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getCb_coupon_use() {
		return cb_coupon_use;
	}
	public void setCb_coupon_use(int cb_coupon_use) {
		this.cb_coupon_use = cb_coupon_use;
	}
	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	@Override
	public String toString() {
		return "CouponBox [cb_id=" + cb_id + ", m_id=" + m_id + ", c_id=" + c_id + ", cb_coupon_use=" + cb_coupon_use
				+ ", o_id=" + o_id + "]";
	}
	
	
	
	
	


}
