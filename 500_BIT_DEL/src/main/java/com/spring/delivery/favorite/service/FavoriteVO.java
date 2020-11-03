package com.spring.delivery.favorite.service;

public class FavoriteVO {
	private int f_id;
	private int s_id;
	private int m_id;

	public FavoriteVO() {
		super();
	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
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

	@Override
	public String toString() {
		return "FavoriteVO [f_id=" + f_id + ", s_id=" + s_id + ", m_id=" + m_id + "]";
	}

	
	
	
}
