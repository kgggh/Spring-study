package com.spring.delivery.notice.service;


import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class NoticeVO {
	private int n_id;
	private int r_num;
	private String n_title;
	private String n_content;
	private Date n_date;
	private int n_hit;
	private String n_division;
	private int n_rank;
	private String n_photo;
	private int begin;
	private int end;
	
	//검색조건용 필드 추가
	private String searchCondition;
	private String searchKeyword;
	
	//파일업로드
	private MultipartFile uploadFile;
		
	
	public NoticeVO() {}

	public int getN_id() {
		return n_id;
	}


	public void setN_id(int n_id) {
		this.n_id = n_id;
	}

	public int getR_num() {
		return r_num;
	}
	
	public void setR_num(int r_num) {
		this.r_num = r_num;
	}

	public String getN_title() {
		return n_title;
	}


	public void setN_title(String n_title) {
		this.n_title = n_title;
	}


	public String getN_content() {
		return n_content;
	}


	public void setN_content(String n_content) {
		this.n_content = n_content;
	}


	public Date getN_date() {
		return n_date;
	}


	public void setN_date(Date n_date) {
		this.n_date = n_date;
	}


	public int getN_hit() {
		return n_hit;
	}


	public void setN_hit(int n_hit) {
		this.n_hit = n_hit;
	}


	public String getN_division() {
		return n_division;
	}


	public void setN_division(String n_division) {
		this.n_division = n_division;
	}


	public int getN_rank() {
		return n_rank;
	}


	public void setN_rank(int n_rank) {
		this.n_rank = n_rank;
	}

	public String getN_photo() {
		return n_photo;
	}
	
	
	public void setN_photo(String n_photo) {
		this.n_photo = n_photo;
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
		return "NoticeVO [n_id=" + n_id + ", r_num=" + r_num + ", n_title=" + n_title + ", n_content=" + n_content
				+ ", n_date=" + n_date + ", n_hit=" + n_hit + ", n_division=" + n_division + ", n_rank=" + n_rank
				+ ", n_photo=" + n_photo + ", begin=" + begin + ", end=" + end + ", searchCondition=" + searchCondition
				+ ", searchKeyword=" + searchKeyword + ", uploadFile=" + uploadFile + "]";
	}

	//=====================
	@JsonIgnore // JSON 데이타 변경하지 않도록 제외 처리
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	@JsonIgnore // JSON 데이타 변경하지 않도록 제외 처리
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	//===== 파일 업로드 관련 ================
	@JsonIgnore // JSON 데이타 변경하지 않도록 제외 처리
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
		
	
	
}
