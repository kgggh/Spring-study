package com.spring.delivery.store.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.delivery.favorite.service.FavoriteService;
import com.spring.delivery.favorite.service.FavoriteVO;
import com.spring.delivery.member.service.MembersService;
import com.spring.delivery.member.service.MembersVO;
import com.spring.delivery.orders.service.OrdersService;
import com.spring.delivery.paging.service.PagingVO;
import com.spring.delivery.store.service.DayoffService;
import com.spring.delivery.store.service.DayoffVO;
import com.spring.delivery.store.service.StorePagingVO;
import com.spring.delivery.store.service.StoreService;
import com.spring.delivery.store.service.StoreVO;
import com.spring.delivery.store.service.TipService;
import com.spring.delivery.store.service.TipVO;
import com.spring.delivery.store.serviceimpl.TipDAO;

@Controller
public class StoreController {
	@Autowired
	private StoreService storeService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private DayoffService dayoffService;
	@Autowired
	private TipService tipService;
	@Autowired
	private MembersService membersService;
	@Autowired
	private FavoriteService favoriteService;	
	
	@RequestMapping("/s_mypage.do")
	public String  selectOneMember(Model model, HttpSession session){
		int m_id = (int) session.getAttribute("m_id");
		StoreVO svo = storeService.selectOneStore(m_id);
		System.out.println("svo : " + svo);
		session.setAttribute("svo", svo);
		return "skr_main.jsp";
	}
	
	
	@RequestMapping("/Resumption_Yes.do")
	public String  Resumption (String s_id, String m_id, Model model){
		System.out.println(s_id+"영업시작 누를시");
		int sid = Integer.parseInt(s_id);
		storeService.resumption(sid);
		

		return "/s_mypage.do";
	}
		
			
	@RequestMapping("/Closing_Apply.do")
	public String Closing_Apply (String s_id, String m_id, Model model){
		System.out.println("s_id : "+ s_id);
		int sid = Integer.parseInt(s_id);
		int check = storeService.Closing_Apply(sid);

		return "/s_mypage.do";
	}
	
	@RequestMapping("/storeInfo.do")
	public String storeInfo (int s_id, Model model){
		System.out.println("s_id : "+ s_id);
		
		
		int orderCount = ordersService.getOrderCount(s_id);
		model.addAttribute("orderCount", orderCount);
		
		System.out.println("s_id : "+ s_id);
		StoreVO store = new StoreVO();
		store = storeService.getStoreInfo(s_id);
		model.addAttribute("store", store);
		String mon = "";
		String tue = "";
		String wed = "";
		String thu = "";
		String fri = "";
		String sat = "";
		String sun = "";
		String holiday = "";
		DayoffVO dayoff = new DayoffVO();
		dayoff = dayoffService.getDayoff(s_id);
		if(dayoff != null) {
			if(dayoff.getMon() == 0) {
				mon = "월요일";
			}if(dayoff.getTue() == 0){
				tue = "화요일";
			}if(dayoff.getWed() == 0){
				wed = "수요일";
			}if(dayoff.getThu() == 0){
				thu = "목요일";
			}if(dayoff.getFri() == 0){
				fri = "금요일";
			}if(dayoff.getSat() == 0){
				sat = "토요일";
			}if(dayoff.getSun() == 0){
				sun = "일요일";
			}if(dayoff.getHoliday() == 0){
				holiday = "공휴일";
			}
		}
		
		model.addAttribute("mon", mon);
		model.addAttribute("tue", tue);
		model.addAttribute("wed", wed);
		model.addAttribute("thu", thu);
		model.addAttribute("fri", fri);
		model.addAttribute("sat", sat);
		model.addAttribute("sun", sun);
		model.addAttribute("holiday", holiday);
		
		int m_id = store.getM_id();
		MembersVO member = new MembersVO();
		member = membersService.selectOneMember(m_id);
		model.addAttribute("member", member);
		
		List<TipVO> tipList = tipService.getTip(s_id);
		if(!tipList.isEmpty()) {
			
			model.addAttribute("tipList", tipList);
		}
		
		return "storeInfo.jsp";
	}
	
	@RequestMapping("/storeList.do")
	public String  getStoreList(String dong, String cPage, int s_classification,
								Model model, HttpSession session){
		//페이징 객체 생성
		PagingVO p= new PagingVO();
		
		int m_id = (int) session.getAttribute("m_id");
		MembersVO member = membersService.selectOneMember(m_id);
		if(dong == null) {
			dong = member.getAddress();
		}
		
		StoreVO storePut = new StoreVO();
		
		storePut.setDong(dong);
		storePut.setS_classification(s_classification);

		System.out.println("dong : " + dong);
		//1. 전체 점포 수 구하기
		p.setTotalRecord(storeService.StoreCount(storePut));
		p.setStoreTotalPage();
		System.out.println("> 전체 게시글 수 : " + p.getTotalRecord());
		System.out.println("> 전체 페이지 수 : " + p.getTotalPage());
		
		System.out.println("cPage : " + cPage);
		//2. 현재 페이지 구하기
		if(cPage != null) {
			p.setNowPage(Integer.parseInt(cPage));
		}
		
		//3. 현재 페이지에 표시할 리뷰 시작번호(begin), 끝번호(end) 구하기
		p.setEnd(p.getNowPage() * p.getStorenumPerPage()); // 현재페이지번호 * 페이지당 글 수 
		p.setBegin(p.getEnd() - p.getStorenumPerPage() + 1);
		
		System.out.println(">> End : " + p.getEnd());
		System.out.println(">> Begin : " + p.getBegin());
		
		//(선택적)3-1. 끝 글번호가 데이터 건수보다 많아지면 데이터 건수와 동일한 번호로 설정
		if(p.getEnd() > p.getTotalRecord()){
			p.setEnd(p.getTotalRecord());
		}
		
		System.out.println("------------------");
		System.out.println(">> 현재페이지  : " + p.getNowPage());
		System.out.println(">> 시작번호(begin) : " + p.getBegin());
		System.out.println(">> 끝번호(end) : " + p.getEnd());
		
		//----- 블록(block) 계산하기 -----
		//4. 블록의 시작페이지, 끝페이지 구하기(현재 페이지 번호 사용)
		//시작페이지 번호 구하기
		int nowPage = p.getNowPage();
		int beginPage = (nowPage - 1) / p.getPagePerBlock() * p.getPagePerBlock() + 1;
		p.setBeginPage(beginPage);
		p.setEndPage(p.getBeginPage() + p.getPagePerBlock() - 1);
		System.out.println(">> 시작페이지(beginPage) : " + p.getBeginPage());
		System.out.println(">> 끝페이지(endPage) : " + p.getEndPage());
		
		//4-1. 끝페이지(endPage)가 전체 페이지 수(totalPage)보다 크면
		//끝페이지를 전체 페이지수로 변경처리
		if(p.getEndPage() > p.getTotalPage()) {
			p.setEndPage(p.getTotalPage());
		}

		storePut.setBegin(p.getBegin());
		storePut.setEnd(p.getEnd());
		List<StoreVO> storeList = storeService.getStore(storePut);
		
		
		List<FavoriteVO> favoriteList =favoriteService.selectFavorite(m_id);
		int nullcheck = 0;
		
		if(storeList.size() == 0) {
			nullcheck = 1;
			model.addAttribute("nullcheck", nullcheck);
		}else {
			model.addAttribute("storeListsize", storeList.size());
			System.out.println("storeList.size( : " + storeList.size());
			System.out.println("storeList : " + storeList);
			model.addAttribute("storeList", storeList);
			model.addAttribute("favoriteList", favoriteList);
			model.addAttribute("dong", dong);
			model.addAttribute("pvo", p);		
			model.addAttribute("nullcheck", nullcheck);
			model.addAttribute("s_classification", s_classification);
		}
		
		session.setAttribute("dong", dong);

		return "storeList.jsp";
	}
	

}
