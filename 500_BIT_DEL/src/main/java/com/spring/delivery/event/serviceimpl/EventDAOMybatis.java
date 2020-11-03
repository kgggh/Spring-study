package com.spring.delivery.event.serviceimpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.delivery.event.service.EventVO;


@Repository("EventDAOMybatis")
public class EventDAOMybatis {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	//이벤트 등록
	public void eventIns(EventVO vo) {
		System.out.println("===> MyBatis로 insertBoard() 실행");
		mybatis.insert("EventDAO.eventIns", vo);
	}
	
	//이벤트 수정
	public void eventMod(EventVO vo) {
		System.out.println("===>  MyBatis로 updateBoard() 실행");
		mybatis.update("EventDAO.eventMod", vo);
	}
	
	//이벤트 삭제
	public void eventDel(EventVO vo) {
		System.out.println("===> MyBatis로 deleteBoard() 실행");
		mybatis.delete("EventDAO.eventDel", vo);
	}
	
	// 이벤트 상세 조회(상세조회)
	public EventVO eventView(EventVO vo) {
		System.out.println("===> MyBatis로 getBoard() 실행");
		return mybatis.selectOne("EventDAO.eventView", vo);
	}
	
	// 이벤트 리스트
	public List<EventVO> eventList(EventVO vo) {
		System.out.println("===> MyBatis로 getEventList(vo) 실행");
		
		return mybatis.selectList("EventDAO.eventList", vo);
	}	
	
	// 조회수
	public void hitupdate(int e_id) {
		System.out.println(">>>>MyBatis로 hit 실행");
		mybatis.update("EventDAO.hitupdate", e_id);
	}

}








