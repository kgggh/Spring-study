package com.spring.delivery.member.service;

public class ReviewVO {
	private int r_id;
	private int o_id;
	private int s_id;
	private int m_id;
	private String r_content;
	private int r_avg;
	private String r_photo;
	private String skr_content;

	public ReviewVO() { }
	
	public ReviewVO(int r_id, int o_id, int s_id, int m_id, String r_content, int r_avg, String r_photo,
			String skr_content) {
		super();
		this.r_id = r_id;
		this.o_id = o_id;
		this.s_id = s_id;
		this.m_id = m_id;
		this.r_content = r_content;
		this.r_avg = r_avg;
		this.r_photo = r_photo;
		this.skr_content = skr_content;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
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

	@Override
	public String toString() {
		return "ReviewVO [r_id=" + r_id + ", o_id=" + o_id + ", s_id=" + s_id + ", m_id=" + m_id + ", r_content="
				+ r_content + ", r_avg=" + r_avg + ", r_photo=" + r_photo + ", skr_content=" + skr_content + "]";
	}
}
