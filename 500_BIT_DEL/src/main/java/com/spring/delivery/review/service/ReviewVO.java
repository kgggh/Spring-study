package com.spring.delivery.review.service;

public class ReviewVO {
	private int r_id;
	private int sco_num;
	private int s_id;
	private int m_id;
	private String r_content;
	private int r_avg;
	private String r_photo;
	private String skr_content;
	private String r_write_date;
	private int s_classification;
	private String id;
	private String menu_name;
	private String s_name;	
	
	public ReviewVO() {
		super();
	}


	public int getR_id() {
		return r_id;
	}


	public void setR_id(int r_id) {
		this.r_id = r_id;
	}


	public int getSco_num() {
		return sco_num;
	}


	public void setSco_num(int sco_num) {
		this.sco_num = sco_num;
	}


	public int getS_id() {
		return s_id;
	}


	public void setS_id(int s_id) {
		this.s_id = s_id;
	}


	public int getM_id() {
		return m_id;
	}


	public void setM_id(int m_id) {
		this.m_id = m_id;
	}


	public String getR_content() {
		return r_content;
	}


	public void setR_content(String r_content) {
		this.r_content = r_content;
	}


	public int getR_avg() {
		return r_avg;
	}


	public void setR_avg(int r_avg) {
		this.r_avg = r_avg;
	}


	public String getR_photo() {
		return r_photo;
	}


	public void setR_photo(String r_photo) {
		this.r_photo = r_photo;
	}


	public String getSkr_content() {
		return skr_content;
	}


	public void setSkr_content(String skr_content) {
		this.skr_content = skr_content;
	}


	public String getR_write_date() {
		return r_write_date;
	}


	public void setR_write_date(String r_write_date) {
		this.r_write_date = r_write_date;
	}


	public int getS_classification() {
		return s_classification;
	}


	public void setS_classification(int s_classification) {
		this.s_classification = s_classification;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "ReviewVO [r_id=" + r_id + ", sco_num=" + sco_num + ", s_id=" + s_id + ", m_id=" + m_id + ", r_content="
				+ r_content + ", r_avg=" + r_avg + ", r_photo=" + r_photo + ", skr_content=" + skr_content
				+ ", r_write_date=" + r_write_date + ", s_classification=" + s_classification + ", id=" + id
				+ ", menu_name=" + menu_name + ", s_name=" + s_name + "]";
	}
	
	
}
