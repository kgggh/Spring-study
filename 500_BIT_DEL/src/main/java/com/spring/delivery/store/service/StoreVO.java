package com.spring.delivery.store.service;

public class StoreVO {
	private int s_id;
	private int s_classification;
	private String s_name;
	private int s_ad;
	private String s_closed;
	private String s_add;
	private int s_open_t;
	private int s_close_t;
	private int s_min_price;
	private int s_pack;
	private int m_id;
	private String s_photo;
	private String dong;
	private int tip_price;
	private int begin;
	private int end;
	
	
	
	public StoreVO() {
		super();
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public int getS_classification() {
		return s_classification;
	}

	public void setS_classification(int s_classification) {
		this.s_classification = s_classification;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getS_ad() {
		return s_ad;
	}

	public void setS_ad(int s_ad) {
		this.s_ad = s_ad;
	}

	public String getS_closed() {
		return s_closed;
	}

	public void setS_closed(String s_closed) {
		this.s_closed = s_closed;
	}

	public String getS_add() {
		return s_add;
	}

	public void setS_add(String s_add) {
		this.s_add = s_add;
	}

	public int getS_open_t() {
		return s_open_t;
	}

	public void setS_open_t(int s_open_t) {
		this.s_open_t = s_open_t;
	}

	public int getS_close_t() {
		return s_close_t;
	}

	public void setS_close_t(int s_close_t) {
		this.s_close_t = s_close_t;
	}

	public int getS_min_price() {
		return s_min_price;
	}

	public void setS_min_price(int s_min_price) {
		this.s_min_price = s_min_price;
	}

	public int getS_pack() {
		return s_pack;
	}

	public void setS_pack(int s_pack) {
		this.s_pack = s_pack;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	
	
	public String getS_photo() {
		return s_photo;
	}

	public void setS_photo(String s_photo) {
		this.s_photo = s_photo;
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

	
	
	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "StoreVO [s_id=" + s_id + ", s_classification=" + s_classification + ", s_name=" + s_name + ", s_ad="
				+ s_ad + ", s_closed=" + s_closed + ", s_add=" + s_add + ", s_open_t=" + s_open_t + ", s_close_t="
				+ s_close_t + ", s_min_price=" + s_min_price + ", s_pack=" + s_pack + ", m_id=" + m_id + ", s_photo="
				+ s_photo + ", dong=" + dong + ", tip_price=" + tip_price + "]";
	}


}
