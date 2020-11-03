package com.spring.delivery.event.service;

import java.sql.Date;

public class EventVO {
	private int e_id;
	private String e_title;
	private String e_content;
	private Date e_date;
	private int e_hit;
	private int c_id;
	
	public EventVO() {}
		
	public int getE_id() {
		return e_id;
	}
	
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	
	public String getE_title() {
		return e_title;
	}
	
	public void setE_title(String e_title) {
		this.e_title = e_title;
	}
	
	public String getE_content() {
		return e_content;
	}
	
	public void setE_content(String e_content) {
		this.e_content = e_content;
	}
	
	public Date getE_date() {
		return e_date;
	}
	
	public void setE_date(Date e_date) {
		this.e_date = e_date;
	}
	
	public int getE_hit() {
		return e_hit;
	}
	
	public void setE_hit(int e_hit) {
		this.e_hit = e_hit;
	}
	
	public int getC_id() {
		return c_id;
	}
	
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	
	@Override
	public String toString() {
		return "EventVO [e_id=" + e_id + ", e_title=" + e_title + ", e_content=" + e_content + ", e_date=" + e_date
				+ ", e_hit=" + e_hit + ", c_id=" + c_id + "]";
	}
	


}
