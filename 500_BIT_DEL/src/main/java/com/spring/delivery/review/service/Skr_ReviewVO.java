package com.spring.delivery.review.service;

public class Skr_ReviewVO {
	private int r_id;
	private int s_id;
	private String id;
	private String r_write_date;
	private int r_avg;
	private String menu_name;
	private String r_photo;
	private String r_content;
	private String skr_content;
	
	
	public Skr_ReviewVO() {
		super();
	}


	public Skr_ReviewVO(int r_id, int s_id, String id, String r_write_date, int r_avg, String menu_name, String r_photo,
			String r_content, String skr_content) {
		super();
		this.r_id = r_id;
		this.s_id = s_id;
		this.id = id;
		this.r_write_date = r_write_date;
		this.r_avg = r_avg;
		this.menu_name = menu_name;
		this.r_photo = r_photo;
		this.r_content = r_content;
		this.skr_content = skr_content;
	}


	public int getR_id() {
		return r_id;
	}


	public void setR_id(int r_id) {
		this.r_id = r_id;
	}


	public int getS_id() {
		return s_id;
	}


	public void setS_id(int s_id) {
		this.s_id = s_id;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getR_write_date() {
		return r_write_date;
	}


	public void setR_write_date(String r_write_date) {
		this.r_write_date = r_write_date;
	}


	public int getR_avg() {
		return r_avg;
	}


	public void setR_avg(int r_avg) {
		this.r_avg = r_avg;
	}


	public String getMenu_name() {
		return menu_name;
	}


	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}


	public String getR_photo() {
		return r_photo;
	}


	public void setR_photo(String r_photo) {
		this.r_photo = r_photo;
	}


	public String getR_content() {
		return r_content;
	}


	public void setR_content(String r_content) {
		this.r_content = r_content;
	}


	public String getSkr_content() {
		return skr_content;
	}


	public void setSkr_content(String skr_content) {
		this.skr_content = skr_content;
	}


	@Override
	public String toString() {
		return "Skr_ReviewVO [r_id=" + r_id + ", s_id=" + s_id + ", id=" + id + ", r_write_date=" + r_write_date
				+ ", r_avg=" + r_avg + ", menu_name=" + menu_name + ", r_photo=" + r_photo + ", r_content=" + r_content
				+ ", skr_content=" + skr_content + "]";
	}



	
		
	
}
