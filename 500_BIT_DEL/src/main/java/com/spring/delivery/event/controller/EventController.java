package com.spring.delivery.event.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.delivery.coupon.service.CouponService;
import com.spring.delivery.coupon.service.CouponVO;
import com.spring.delivery.event.service.EventService;
import com.spring.delivery.event.service.EventVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("event")
public class EventController {
	@Autowired
	private EventService EventService;
	@Autowired
	private CouponService CouponService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		
		return "index.jsp";
	}
	
	//이벤트 리스트페이지
	@RequestMapping(value = "/event.do")
	public String event(Model model, EventVO vo, HttpSession session) {
		System.out.println(">> 이벤트 리스트 페이지");
		List<EventVO> eventList = EventService.eventList(vo);
		System.out.println("eventList>>" + eventList);
		model.addAttribute("event", eventList);
		return "event.jsp";
	}
	
	//이벤트 상세페이지
	@RequestMapping(value = "/eventView.do")
	public String eventView(Model model, EventVO vo, HttpSession session,@RequestParam("e_id")int e_id) {
		EventService.hitupdate(e_id);
		System.out.println(">> 이벤트 상세페이지");
		EventVO event = EventService.eventView(vo);
		
		model.addAttribute("event", event);
		
		return "eventView.jsp";
	}
	
	//이벤트 작성폼
	@RequestMapping(value = "/eventInsForm.do")
	public String eventInsForm(Model model, EventVO vo, HttpSession session) {
		
		List<CouponVO> coupon = CouponService.couponList();
		
		model.addAttribute("coupon", coupon);
		
		return "eventIns.jsp";
	}
	
	//이벤트 작성후.
	@RequestMapping(value = "/eventIns.do")
	public String eventIns(Model model, EventVO vo, HttpSession session) {
		EventService.eventIns(vo);
		return "redirect:event.do";
	}
	
	//이벤트 삭제폼
	@RequestMapping(value = "/eventDelForm.do")
	public String eventDelForm(Model model, EventVO vo, HttpSession session) {
		return "eventDel.jsp";
		
	}
	//이벤트 삭제후
	@RequestMapping(value = "/eventDel.do")
	public String eventDel(Model model, EventVO vo, HttpSession session) {
		EventService.eventDel(vo);
		return "redirect:event.do";
		
	}
	
	//이벤트 수정폼
	@RequestMapping(value = "/eventModForm.do")
	public String eventModForm(Model model, EventVO vo, HttpSession session) {
		List<CouponVO> coupon = CouponService.couponList();
		
		model.addAttribute("coupon", coupon);
		return "eventMod.jsp";
	}
	//이벤트 수정후
	@RequestMapping(value = "/eventMod.do")
	public String eventMod(Model model, EventVO vo, HttpSession session) {

		EventService.eventMod(vo);
		return "redirect:event.do";
		
	}
	
}
