package com.spring.delivery.menu.service;

public class MenuSortVO {
	private int m_sort_id;
	private String m_s_name;
	private int m_s_rank;
	private int s_id;
	private int m_s_disable;

	public MenuSortVO() {}

	public int getM_sort_id() {
		return m_sort_id;
	}

	public void setM_sort_id(int m_sort_id) {
		this.m_sort_id = m_sort_id;
	}

	public String getM_s_name() {
		return m_s_name;
	}

	public void setM_s_name(String m_s_name) {
		this.m_s_name = m_s_name;
	}

	public int getM_s_rank() {
		return m_s_rank;
	}

	public void setM_s_rank(int m_s_rank) {
		this.m_s_rank = m_s_rank;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	
	

	public int getM_s_disable() {
		return m_s_disable;
	}

	public void setM_s_disable(int m_s_disable) {
		this.m_s_disable = m_s_disable;
	}

	@Override
	public String toString() {
		return "MenuSortVO [m_sort_id=" + m_sort_id + ", m_s_name=" + m_s_name + ", m_s_rank=" + m_s_rank + ", s_id="
				+ s_id + ", m_s_disable=" + m_s_disable + "]";
	}


	

	
}
