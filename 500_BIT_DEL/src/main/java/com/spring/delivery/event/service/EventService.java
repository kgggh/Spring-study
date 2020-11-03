package com.spring.delivery.event.service;

import java.util.List;

public interface EventService {
	//CRUD 기능 구현 메소드 정의
	void eventIns(EventVO vo);
	void eventMod(EventVO vo);
	void eventDel(EventVO vo);
	EventVO eventView(EventVO vo);
	List<EventVO> eventList(EventVO vo);
	void hitupdate(int e_id);
	
}






