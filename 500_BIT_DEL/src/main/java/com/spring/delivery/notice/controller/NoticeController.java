package com.spring.delivery.notice.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.delivery.notice.service.NoticeService;
import com.spring.delivery.notice.service.NoticeVO;
import com.spring.delivery.paging.service.PagingVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("notice")
public class NoticeController {
	@Autowired
	private NoticeService NoticeService;

	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String
	 * index(Model model) {
	 * 
	 * return "index.jsp"; }
	 */
	
	public NoticeController() {
		/* System.out.println("--->> MenuController() 객체생성"); */
	}
	
	//공지사항 리스트페이지
	@RequestMapping(value = "/getNoticeList.do")
	public String notice(Model model, NoticeVO vo, HttpSession session, String cPage ) {
		
		//페이징 객체 생성
		PagingVO p= new PagingVO();
		
		
		
		//1. 전체 공지사항 수 구하기

		p.setTotalRecord(NoticeService.getNoticeCount());
		p.setNoticeTotalPage();
		System.out.println("> 전체 게시글 수 : " + p.getTotalRecord());
		System.out.println("> 전체 페이지 수 : " + p.getTotalPage());
		
		System.out.println("cPage : " + cPage);
		//2. 현재 페이지 구하기
		if(cPage != null) {
			p.setNowPage(Integer.parseInt(cPage));
		}
		
		//3. 현재 페이지에 표시할 리뷰 시작번호(begin), 끝번호(end) 구하기
		p.setEnd(p.getNowPage() * p.getNoticenumPerPage()); // 현재페이지번호 * 페이지당 글 수 
		p.setBegin(p.getEnd() - p.getNoticenumPerPage() + 1);
		
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
		int beginPage = (nowPage - 1) / p.getNoticepagePerBlock() * p.getNoticepagePerBlock() + 1;
		p.setBeginPage(beginPage);
		p.setEndPage(p.getBeginPage() + p.getNoticepagePerBlock() - 1);
		System.out.println(">> 시작페이지(beginPage) : " + p.getBeginPage());
		System.out.println(">> 끝페이지(endPage) : " + p.getEndPage());
		
		//4-1. 끝페이지(endPage)가 전체 페이지 수(totalPage)보다 크면
		//끝페이지를 전체 페이지수로 변경처리
		if(p.getEndPage() > p.getTotalPage()) {
			p.setEndPage(p.getTotalPage());
		}
		
		//=================================================
		//현재 페이지 기준으로 DB데이터(게시글) 가져오기
		//시작글번호, 끝 글번호로 Map 데이터 만들기(전달할 파라미터 값)
		Map<String, Integer> map = new HashMap<>();
		map.put("begin", p.getBegin());
		map.put("end", p.getEnd());
		model.addAttribute("noticeList", map);	
		List<NoticeVO> noticeList = NoticeService.getNoticePageList(map);
		
		System.out.println(">> 공지사항 리스트 페이지");
		System.out.println("noticeList>>" + noticeList);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pvo", p);

		return "getNoticeList.jsp";
		}
	
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		System.out.println(">>> @ModelAttribute - Map searchConditionMap()");
		// key: 제목, value: N_TITLE
		// key: 내용, value: N_CONTENT
		
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "N_TITLE");
		conditionMap.put("내용", "N_CONTENT");
		return conditionMap;
	}
	
	
	
	// 메소드에 선언된 @ModelAttribute 는 리턴된 데이터를 View에 전달
	// @ModelAttribute 선언된 메소드는 @RequestMapping 메소드보다 먼저 실행됨
	// 뷰에 전달될 때 설정된 명칭(예: conditionMap)으로 전달
	@RequestMapping(value = "/getSearchNoticeList.do")
	public String searchConditionMap(String searchCondition, String searchKeyword, String cPage, Model model) {
		System.out.println(">>> @ModelAttribute - Map searchConditionMap()");
		// key: 제목, value: N_TITLE
		// key: 내용, value: N_CONTENT
		
		System.out.println("searchCondition: " + searchCondition);
		System.out.println("searchKeyword: " + searchKeyword);
		Map<String, String> conditionMap = new HashMap<String, String>();
		if(searchCondition.equals("N_TITLE")) {
			System.out.println("ddddd");
		}
		conditionMap.put("searchCondition", searchCondition);
		conditionMap.put("searchKeyword", searchKeyword);
		
		
		
		//페이징 객체 생성
		PagingVO p= new PagingVO();
		
		
		//1. 전체 공지사항 수 구하기
	    System.out.println(conditionMap);
	   NoticeVO N = new NoticeVO();
	   N.setSearchCondition(searchCondition);
	   N.setSearchKeyword(searchKeyword);
	   int c = NoticeService.getNoticeCount_T(N);
	   System.out.println("c: " + c);
		p.setTotalRecord(c);
		p.setNoticeTotalPage();
		System.out.println("> 전체 게시글 수 : " + p.getTotalRecord());
		System.out.println("> 전체 페이지 수 : " + p.getTotalPage());
		
		System.out.println("cPage : " + cPage);
		//2. 현재 페이지 구하기
		if(cPage != null) {
			p.setNowPage(Integer.parseInt(cPage));
		} else {
			p.setNowPage(1);
		}
		
		//3. 현재 페이지에 표시할 리뷰 시작번호(begin), 끝번호(end) 구하기
		p.setEnd(p.getNowPage() * p.getNoticenumPerPage()); // 현재페이지번호 * 페이지당 글 수 
		p.setBegin(p.getEnd() - p.getNoticenumPerPage() + 1);
		
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
		int beginPage = (nowPage - 1) / p.getNoticepagePerBlock() * p.getNoticepagePerBlock() + 1;
		p.setBeginPage(beginPage);
		p.setEndPage(p.getBeginPage() + p.getNoticepagePerBlock() - 1);
		System.out.println(">> 시작페이지(beginPage) : " + p.getBeginPage());
		System.out.println(">> 끝페이지(endPage) : " + p.getEndPage());
		
		//4-1. 끝페이지(endPage)가 전체 페이지 수(totalPage)보다 크면
		//끝페이지를 전체 페이지수로 변경처리
		if(p.getEndPage() > p.getTotalPage()) {
			p.setEndPage(p.getTotalPage());
		}
		
		//=================================================
		//현재 페이지 기준으로 DB데이터(게시글) 가져오기
		//시작글번호, 끝 글번호로 Map 데이터 만들기(전달할 파라미터 값)
		
		N.setBegin(p.getBegin());
		N.setEnd(p.getEnd());
//		N.setSearchKeyword(searchKeyword);
//		N.setSearchCondition(searchCondition);

		System.out.println("1111111111");
		List<NoticeVO> noticeList = NoticeService.getNoticeList_T(N);
		
		System.out.println(">> 공지사항 리스트 페이지");
		System.out.println("noticeList>>" + noticeList);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pvo", p);
		model.addAttribute("searchKeyword", searchKeyword);
		model.addAttribute("searchCondition", searchCondition);
		
		
		return "getNoticeList.jsp";
	}
	
//	@RequestMapping("/dataTransform.do")
//	@ResponseBody //response 객체의 몸체(body)에 데이타 전달
//	public List<NoticeVO> dataTransform(NoticeVO vo) {
//		vo.setSearchCondition("N_TITLE");
//		vo.setSearchKeyword("N_CONTENT");
//		
//		List<NoticeVO> noticeList = NoticeService.getNoticeList(vo);
//		System.out.println("noticeList : " + noticeList);
//		
//		return noticeList;
//	}
	
	
	
	//공지사항 상세페이지
	@RequestMapping(value = "/getNotice.do")
	public String getNotice(Model model, NoticeVO vo, HttpSession session, int n_id) {
		System.out.println(">> 공지사항 상세페이지");
		NoticeVO notice = NoticeService.getNotice(vo);
		NoticeService.updateNoticeHit(n_id);
		model.addAttribute("notice", notice);
		return "getNotice.jsp";
	}
	
	//공지사항 작성폼
	@RequestMapping(value = "/insertNoticeForm.do")
	public String insertNoticeForm(Model model, NoticeVO vo, HttpSession session) {
		return "insertNotice.jsp";
	}
	
	//공지사항 작성후
	@RequestMapping(value = "/insertNotice.do")
	public String insertNotice(Model model, NoticeVO vo, HttpSession session) {
		NoticeService.insertNotice(vo);
		return "redirect:getNoticeList.do";
	}
	
	//공지사항 삭제폼
	@RequestMapping(value = "/deleteNoticeForm.do")
	public String deleteNoticeForm(Model model, NoticeVO vo, HttpSession session) {
		NoticeService.deleteNotice(vo);
		return "deleteNotice.jsp";
		
	}
	//공지사항 삭제후
	@RequestMapping(value = "/deleteNotice.do")
	public String deleteNotice(Model model, NoticeVO vo, HttpSession session) {
		NoticeService.deleteNotice(vo);
		return "redirect:getNoticeList.do";
		
	}
	
	//공지사항 수정폼
	@RequestMapping(value = "/updateNoticeForm.do")
	public String updateNoticeForm(Model model, NoticeVO vo, HttpSession session) {
		return "updateNotice.jsp";
	}
	//공지사항 수정후
	@RequestMapping(value = "/updateNotice.do")
	public String updateNotice(Model model, NoticeVO vo, HttpSession session) {
		NoticeService.updateNotice(vo);
		return "redirect:getNoticeList.do";
		
	}
	
}
