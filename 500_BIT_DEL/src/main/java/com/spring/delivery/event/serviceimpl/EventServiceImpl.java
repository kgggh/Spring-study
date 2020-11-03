package com.spring.delivery.event.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.delivery.event.service.EventService;
import com.spring.delivery.event.service.EventVO;



// @Service : @Component 상속확장 어노테이션
//     비즈니스 로직처리 서비스 영역에 사용
@Service("eventService")
public class EventServiceImpl implements EventService {
	@Autowired //타입이 일치하는 객체(인스턴스) 주입
	//private BoardDAO boardDAO;
	//private BoardDAOSpring boardDAO;
	private EventDAOMybatis eventDAO;
	
	public EventServiceImpl() {
		System.out.println(">> EventServiceImpl() 객체생성");
	}
	@Override
	public void eventIns(EventVO vo) {
		eventDAO.eventIns(vo);
	}
	@Override
	public void eventMod(EventVO vo) {
		eventDAO.eventMod(vo);
	}
	@Override
	public void eventDel(EventVO vo) {
		eventDAO.eventDel(vo);
	}
	@Override
	public EventVO eventView(EventVO vo) {
		return eventDAO.eventView(vo);
	}
	@Override
	public List<EventVO> eventList(EventVO vo) {
		return eventDAO.eventList(vo);
	}
	@Override
	public void hitupdate(int e_id) {
		eventDAO.hitupdate(e_id);
		
	}
	

	

}
