package com.spring.delivery.member.service;

public class MembersVO {
	private int m_id;
	private String id;
	private String name;
	private String password;
	private int c_s;
	private String address;
	private int gender;
	private int birthday;
	private String m_phone;
		
	public MembersVO() { }
	
	public MembersVO(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getC_s() {
		return c_s;
	}

	public void setC_s(int c_s) {
		this.c_s = c_s;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	
	
}
