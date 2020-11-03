package com.spring.delivery.orders.service;

public class SalseVO {
	
	private String dt;
	private int dayTotal;
	
	
	public SalseVO() {
		super();
	}


	public SalseVO(String dt, int dayTotal) {
		super();
		this.dt = dt;
		this.dayTotal = dayTotal;
	}


	public String getDt() {
		return dt;
	}


	public void setDt(String dt) {
		this.dt = dt;
	}


	public int getDayTotal() {
		return dayTotal;
	}


	public void setDayTotal(int dayTotal) {
		this.dayTotal = dayTotal;
	}


	@Override
	public String toString() {
		return "SalseVO [dt=" + dt + ", dayTotal=" + dayTotal + "]";
	}
	
	
	
	
}
