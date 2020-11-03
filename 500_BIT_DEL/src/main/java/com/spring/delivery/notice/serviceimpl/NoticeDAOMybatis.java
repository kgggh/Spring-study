package com.spring.delivery.notice.serviceimpl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.delivery.notice.service.NoticeVO;
@Repository("NoticeDAOMybatis")
public class NoticeDAOMybatis {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public NoticeDAOMybatis() {
		System.out.println(">> NoticeDAOMybatis 객체생성");
	}
	
	//공지사항 등록
	public void insertNotice(NoticeVO vo) {
		System.out.println("===> MyBatis로 insertNotice() 실행");
		mybatis.insert("NoticeDAO.insertNotice", vo);
	}
	
	//공지사항 수정
	public void updateNotice(NoticeVO vo) {
		System.out.println("===>  MyBatis로 updateNotice() 실행");
		mybatis.update("NoticeDAO.updateNotice", vo);
	}
	
	//공지사항 삭제
	public void deleteNotice(NoticeVO vo) {
		System.out.println("===> MyBatis로 deleteNotice() 실행");
		mybatis.delete("NoticeDAO.deleteNotice", vo);
	}
	
	//공지사항 하나 조회(상세조회)
	public NoticeVO getNotice(NoticeVO vo) {
		System.out.println("===> MyBatis로 getNotice() 실행");
		return mybatis.selectOne("NoticeDAO.getNotice", vo);
	}
	
	//공지사항 조회수 증가
	public void updateNoticeHit (int n_id) { 
		System.out.println("===> MyBatis로 updateNoticeHit() 실행");
		mybatis.update("updateNoticeHit", n_id); 
	}

	public List<NoticeVO> getNoticeList() {
		System.out.println("===> MyBatis로 getNoticeList() 실행");
		
		return null;
	}
	
	public List<NoticeVO> getNoticeList(NoticeVO vo) {
		System.out.println("===> MyBatis로 getNoticeList(vo) 실행");
		System.out.println("3333");
		return mybatis.selectList("NoticeDAO.getNoticeList");
	}	
	
	public List<NoticeVO> getNoticeList_T(NoticeVO notice) {
		System.out.println("===> MyBatis로 getNoticeList_T() 실행");
		if (notice.getSearchCondition().equalsIgnoreCase("n_title")) {
			return mybatis.selectList("NoticeDAO.getNoticeList_T", notice);
		} else {
			return mybatis.selectList("NoticeDAO.getNoticeList_TC", notice);
		}
		
	}	
	
	public int getNoticeCount() {
		return mybatis.selectOne("NoticeDAO.getNoticeCount");
	}	
	public int getNoticeCount_T(NoticeVO nvo) {
		System.out.println("nvo: " + nvo.getSearchCondition());
		System.out.println("nvo: " + nvo.getSearchKeyword());
		int c = 0;
		if (nvo.getSearchCondition().equalsIgnoreCase("n_title")) {
			c = mybatis.selectOne("NoticeDAO.getNoticeCount_T",nvo);
		} else {
			c = mybatis.selectOne("NoticeDAO.getNoticeCount_TC",nvo);
		}
		System.out.println("C: " + c);
		return c;
	}	
	
	public List<NoticeVO> getNoticePageList(Map<String, Integer> map) {
		return mybatis.selectList("NoticeDAO.getNoticePageList", map);
	}	
}








