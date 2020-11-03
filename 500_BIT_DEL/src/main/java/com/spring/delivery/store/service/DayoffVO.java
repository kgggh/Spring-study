package com.spring.delivery.store.service;

public class DayoffVO {
	private int day_id;
	private int mon;
	private int tue;
	private int wed;
	private int thu;
	private int fri;
	private int sat;
	private int sun;
	private int holiday;
	private int s_id;

	public DayoffVO() {}

	public int getDay_id() {
		return day_id;
	}

	public void setDay_id(int day_id) {
		this.day_id = day_id;
	}

	public int getMon() {
		return mon;
	}

	public void setMon(int mon) {
		this.mon = mon;
	}

	public int getTue() {
		return tue;
	}

	public void setTue(int tue) {
		this.tue = tue;
	}

	public int getWed() {
		return wed;
	}

	public void setWed(int wed) {
		this.wed = wed;
	}

	public int getThu() {
		return thu;
	}

	public void setThu(int thu) {
		this.thu = thu;
	}

	public int getFri() {
		return fri;
	}

	public void setFri(int fri) {
		this.fri = fri;
	}

	public int getSat() {
		return sat;
	}

	public void setSat(int sat) {
		this.sat = sat;
	}

	public int getSun() {
		return sun;
	}

	public void setSun(int sun) {
		this.sun = sun;
	}

	public int getHoliday() {
		return holiday;
	}

	public void setHoliday(int holiday) {
		this.holiday = holiday;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	@Override
	public String toString() {
		return "DayoffVO [day_id=" + day_id + ", mon=" + mon + ", tue=" + tue + ", wed=" + wed + ", thu=" + thu
				+ ", fri=" + fri + ", sat=" + sat + ", sun=" + sun + ", holiday=" + holiday + ", s_id=" + s_id + "]";
	}

	
	
	
}
