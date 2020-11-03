package com.spring.delivery.coupon.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.delivery.coupon.service.CouponBoxVO;
import com.spring.delivery.coupon.service.CouponService;
import com.spring.delivery.coupon.service.CouponVO;



@Controller
@SessionAttributes("coupon")
public class CouponController {
	@Autowired
	private CouponService CouponService;
	
	//유저 쿠폰 리스트(고객용)
	@RequestMapping(value = "/myCoupon.do")
	public String myCoupon(Model model, CouponBoxVO vo, HttpSession session) {
		System.out.println(">>>>My쿠폰함 (고객용)");
		List<CouponBoxVO> couponBox = CouponService.myCoupon(vo);
		System.out.println("couponbox >>>>>>" + couponBox);
		model.addAttribute("couponbox", couponBox);
		return "myCoupon.jsp";
			
	}
	//쿠폰 등록 리스트(관리자)
	@RequestMapping(value = "/couponList.do")
	public String couponList(Model model, CouponVO vo, HttpSession session) {
		System.out.println(">> 쿠폰등록 관리함(관리자)");
		List<CouponVO> coupon = CouponService.couponList();
		System.out.println("coupon>>" + coupon);
		model.addAttribute("coupon", coupon);
		return "couponList.jsp";
	}
	//쿠폰 상세페이지(관리자용)
		@RequestMapping(value = "/couponView.do")
		public String couponView(Model model, CouponVO vo, HttpSession session,@RequestParam("c_id")int c_id) {
			System.out.println(">> 쿠폰 상세페이지(관리자용)");
			CouponVO coupon = CouponService.couponView(vo);
			model.addAttribute("coupon", coupon);
			return "couponView.jsp";
		}
	//My 쿠폰 상세페이지
	@RequestMapping(value = "/myCouponView.do")
	public String myCouponView(Model model, CouponVO vo, HttpSession session,@RequestParam("c_id")int c_id) {
		System.out.println(">> 쿠폰 상세페이지(고객용)");
		CouponVO coupon = CouponService.couponView(vo);
		model.addAttribute("coupon", coupon);
		return "myCouponView.jsp";
	}
	
	//쿠폰 등록
	@RequestMapping(value = "/couponIns.do")
	public String couponIns(Model model, CouponVO vo, HttpSession session) {
		System.out.println(">> 쿠폰 등록완료~!");
		CouponService.couponIns(vo);
		return "redirect:couponList.do";
	}
	//쿠폰 등록폼으로 이동 ㅎ
	@RequestMapping(value = "/couponInsForm.do")
	public String couponInsForm(Model model, CouponVO vo, HttpSession session) {
		System.out.println(">> 쿠폰 등록폼으로 이동 ㅎㅎ");
		return "couponIns.jsp";
	}
	
	//쿠폰 삭제폼
	@RequestMapping(value = "/couponDelForm.do")
	public String couponDelForm(Model model, CouponVO vo,HttpSession session) {
		return "couponDel.jsp";
		
	}
	//쿠폰 삭제후
	@RequestMapping(value = "/couponDel.do")
	public String couponDel(Model model, CouponVO vo, HttpSession session,@RequestParam("c_id")int c_id) {
		System.out.println(">> 쿠폰 삭제완료~!");
		CouponService.couponDel(vo);
		return "redirect:couponList.do";
		
	}
	
	//회원 쿠폰 발급
	@RequestMapping(value = "/couponIssuance.do")
	public String couponIssuance(Model model, CouponBoxVO vo, HttpSession session) {
		System.out.println(">> 쿠폰 등록폼으로 이동 ㅎㅎ");
		CouponService.couponIssuance(vo);
		return "event.do";
	}
	
}
