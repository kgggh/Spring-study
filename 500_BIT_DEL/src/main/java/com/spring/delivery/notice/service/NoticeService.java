package com.spring.delivery.notice.service;

import java.util.List;
import java.util.Map;

public interface NoticeService {
//CRUD 기능 구현 메소드 정의
	void insertNotice(NoticeVO vo);
	void updateNotice(NoticeVO vo);
	void deleteNotice(NoticeVO vo);
	void updateNoticeHit(int n_id);
	NoticeVO getNotice(NoticeVO vo);
	List<NoticeVO> getNoticeList();
	List<NoticeVO> getNoticeList(NoticeVO vo);
	public int getNoticeCount();
	public List<NoticeVO> getNoticePageList(Map<String, Integer> map);
	public List<NoticeVO> getNoticeList_T(NoticeVO notice) ;
	public int getNoticeCount_T(NoticeVO notice);
}