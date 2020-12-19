package com.spring.delivery.event.service;

import java.util.List;

public interface EventService {
	//CRUD 기능 구현 메소드 정의
	public void eventIns(EventVO vo);
	public void eventMod(EventVO vo);
	public void eventDel(EventVO vo);
	public EventVO eventView(EventVO vo);
	public List<EventVO> eventList(EventVO vo);
	public void hitupdate(int e_id);
	
}






