package com.spring.delivery.review.controller;

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

import com.spring.delivery.favorite.service.FavoriteVO;
import com.spring.delivery.member.service.MembersVO;
import com.spring.delivery.orders.service.OrdersService;
import com.spring.delivery.orders.service.OrdersVO;
import com.spring.delivery.paging.service.PagingVO;
import com.spring.delivery.review.service.ReviewService;
import com.spring.delivery.review.service.ReviewVO;
import com.spring.delivery.review.service.Skr_ReviewVO;
import com.spring.delivery.store.service.StoreService;
import com.spring.delivery.store.service.StoreVO;


@Controller
@SessionAttributes("svo")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private StoreService storeService;
	@RequestMapping("/getReview.do")
	public String getReview(int m_id, Model model){
		
		model.addAttribute("m_id", m_id);
		
		return "review.jsp";
	}
	
	
	//사장님 리뷰관리 메인 페이지
	@RequestMapping("/skr_review_null.do")
	public String getReviewnull(String s_id, String s_classification, Model model){
			
		int sid = Integer.parseInt(s_id);
		System.out.println("sid:"+ sid);
		List<ReviewVO> rvolist = reviewService.getAvg(sid);//점주번호에 해당하는 리뷰 가져오기
		System.out.println("rvolist :" + rvolist.toString());
		int s_avg_sum = 0;
		
		for(ReviewVO rvo : rvolist) {
			s_avg_sum = s_avg_sum + rvo.getR_avg();//리뷰 하나씩 꺼내서 평점 합치기
		}
		float s_avg = (float) 0.0;
		s_avg = (float) s_avg_sum / rvolist.size();//평점 합친거에 대해 리뷰 사이즈 만큼 나눠서 평점 구하기
		
		model.addAttribute("s_avg", s_avg);// 평점 모델에 저장
		//--------------------------------------------------------------------------------------------
		//같은 업종 리뷰 및 평점 구하기
		model.addAttribute("s_classification", s_classification);//업종 모델 저장
		List<ReviewVO> C_rvolist = reviewService.getC_Avg(s_classification);//같은업종에 해당하는 리뷰 가져오기
		System.out.println("C_rvolist :" + C_rvolist.toString());
		
		int c_avg_sum = 0;
		
		for(ReviewVO rvo : C_rvolist) {
			c_avg_sum = c_avg_sum + rvo.getR_avg();//리뷰 하나씩 꺼내서 평점 합치기
		}
		float c_avg = (float) 0.0;
		c_avg = (float) c_avg_sum / C_rvolist.size();//평점 합친거에 대해 리뷰 사이즈 만큼 나눠서 평점 구하기
		
		model.addAttribute("c_avg", c_avg);// 평점 모델에 저장
		
		//리뷰 가져오기(사장님 답글 없는)
		List<Skr_ReviewVO> srvo= reviewService.getSReview(sid);
		System.out.println("srvo : "+ srvo.toString());
		
		model.addAttribute("srvo", srvo);// 리뷰 모델에 저장
		
		return "Skr_Review_Null.jsp";
	}
	
	//사장님 리뷰관리 메인 페이지
	@RequestMapping("/skr_review_notnull.do")
	public String getReviewnotnull(String s_id, String s_classification, Model model){
			
		int sid = Integer.parseInt(s_id);
		System.out.println("sid:"+ sid);
		List<ReviewVO> rvolist = reviewService.getAvg(sid);//점주번호에 해당하는 리뷰 가져오기
		System.out.println("rvolist :" + rvolist.toString());
		int s_avg_sum = 0;
		
		for(ReviewVO rvo : rvolist) {
			s_avg_sum = s_avg_sum + rvo.getR_avg();//리뷰 하나씩 꺼내서 평점 합치기
		}
		float s_avg = (float) 0.0;
		s_avg = (float) s_avg_sum / rvolist.size();//평점 합친거에 대해 리뷰 사이즈 만큼 나눠서 평점 구하기
		
		model.addAttribute("s_avg", s_avg);// 평점 모델에 저장
		//--------------------------------------------------------------------------------------------
		//같은 업종 리뷰 및 평점 구하기
		model.addAttribute("s_classification", s_classification);//업종 모델 저장
		List<ReviewVO> C_rvolist = reviewService.getC_Avg(s_classification);//같은업종에 해당하는 리뷰 가져오기
		System.out.println("C_rvolist :" + C_rvolist.toString());
		
		int c_avg_sum = 0;
		
		for(ReviewVO rvo : C_rvolist) {
			c_avg_sum = c_avg_sum + rvo.getR_avg();//리뷰 하나씩 꺼내서 평점 합치기
		}
		float c_avg = (float) 0.0;
		c_avg = (float) c_avg_sum / C_rvolist.size();//평점 합친거에 대해 리뷰 사이즈 만큼 나눠서 평점 구하기
		
		model.addAttribute("c_avg", c_avg);// 평점 모델에 저장
		
		//리뷰 가져오기(사장님 답글 있는)
		List<Skr_ReviewVO> srvo= reviewService.getSReviewN(sid);
		System.out.println("srvo : "+ srvo.toString());
		
		model.addAttribute("srvo", srvo);// 리뷰 모델에 저장
		
		return "Skr_Review_NotNull.jsp";
	}
	@RequestMapping("/skr_content.do")
	public String getReview(String s_id, String s_classification, Skr_ReviewVO srvo, Model model){
		System.out.println("srvo : " + srvo.getR_id() + "srvo : " + srvo.getSkr_content());
		reviewService.skr_content(srvo);
		
		
		return "skr_review_null.do";
	}
	@RequestMapping("/skr_content_m.do")
	public String getReview_m(String s_id, String s_classification, Skr_ReviewVO srvo, Model model){
		System.out.println("srvo : " + srvo.getR_id() + "srvo : " + srvo.getSkr_content());
		reviewService.skr_content(srvo);
		
		
		return "skr_review_notnull.do";
	}
	
	
	@RequestMapping("/ReviewList.do")
	public String  getStoreList(int s_id, String cPage, Model model, HttpSession session){
		//페이징 객체 생성
		PagingVO p= new PagingVO();
		
		//1. 전체 점포 수 구하기
		p.setTotalRecord(reviewService.storeAllReviewCount(s_id));
		p.setReviewTotalPage();
		System.out.println("> 전체 게시글 수 : " + p.getTotalRecord());
		System.out.println("> 전체 페이지 수 : " + p.getTotalPage());
		
		System.out.println("cPage : " + cPage);
		//2. 현재 페이지 구하기
		if(cPage != null) {
			p.setNowPage(Integer.parseInt(cPage));
		}
		
		//3. 현재 페이지에 표시할 리뷰 시작번호(begin), 끝번호(end) 구하기
		p.setEnd(p.getNowPage() * p.getReviewnumPerPage()); // 현재페이지번호 * 페이지당 글 수 
		p.setBegin(p.getEnd() - p.getReviewnumPerPage() + 1);
		
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
		int beginPage = (nowPage - 1) / p.getNoticepagePerBlock() * p.getPagePerBlock() + 1;
		p.setBeginPage(beginPage);
		p.setEndPage(p.getBeginPage() + p.getNoticepagePerBlock()  - 1);
		System.out.println(">> 시작페이지(beginPage) : " + p.getBeginPage());
		System.out.println(">> 끝페이지(endPage) : " + p.getEndPage());
		
		//4-1. 끝페이지(endPage)가 전체 페이지 수(totalPage)보다 크면
		//끝페이지를 전체 페이지수로 변경처리
		if(p.getEndPage() > p.getTotalPage()) {
			p.setEndPage(p.getTotalPage());
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", p.getBegin());
		map.put("end", p.getEnd());
		map.put("s_id", s_id);
		
		
		List<ReviewVO> reviewList = reviewService.storeAllReview(map);
		
		int nullcheck = 0;
		
		if(reviewList.size() == 0) {
			nullcheck = 1;
			model.addAttribute("nullcheck", nullcheck);
		}else {
			model.addAttribute("reviewListsize", reviewList.size());
			System.out.println("reviewList.size( : " + reviewList.size());
			System.out.println("reviewList : " + reviewList);
			model.addAttribute("reviewList", reviewList);
			model.addAttribute("pvo", p);		
			model.addAttribute("nullcheck", nullcheck);

		}
		
		StoreVO svo = storeService.getStoreInfo(s_id);
		model.addAttribute("svo", svo);
		int reviewTot = reviewService.reviewTot(s_id);
		model.addAttribute("reviewTot", reviewTot);
		int skrReviewTot = reviewService.skrReviewTot(s_id);
		model.addAttribute("skrReviewTot", skrReviewTot);
		int USAvg = reviewService.USAvg(s_id);
		model.addAttribute("USAvg", USAvg);
		
		return "review.jsp";
	}
	
	@RequestMapping("/reviewAdministrate.do")
	public String  goReviewAdministrate(String cPage, Model model, HttpSession session){
		//페이징 객체 생성
		PagingVO p= new PagingVO();
		
		int m_id = (int) session.getAttribute("m_id");
		
		
		//1. 회원 주문내역
		p.setTotalRecord(ordersService.OrderCount(m_id));
		p.setReviewAdminTotalPage();
		System.out.println("> 전체 게시글 수 : " + p.getTotalRecord());
		System.out.println("> 전체 페이지 수 : " + p.getTotalPage());
		
		System.out.println("cPage : " + cPage);
		//2. 현재 페이지 구하기
		if(cPage != null) {
			p.setNowPage(Integer.parseInt(cPage));
		}
		
		//3. 현재 페이지에 표시할 리뷰 시작번호(begin), 끝번호(end) 구하기
		p.setEnd(p.getNowPage() * p.getReviewnumPerPage()); // 현재페이지번호 * 페이지당 글 수 
		p.setBegin(p.getEnd() - p.getReviewnumPerPage() + 1);
		
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
		int beginPage = (nowPage - 1) / p.getNoticepagePerBlock() * p.getPagePerBlock() + 1;
		p.setBeginPage(beginPage);
		p.setEndPage(p.getBeginPage() + p.getNoticepagePerBlock()  - 1);
		System.out.println(">> 시작페이지(beginPage) : " + p.getBeginPage());
		System.out.println(">> 끝페이지(endPage) : " + p.getEndPage());
		
		//4-1. 끝페이지(endPage)가 전체 페이지 수(totalPage)보다 크면
		//끝페이지를 전체 페이지수로 변경처리
		if(p.getEndPage() > p.getTotalPage()) {
			p.setEndPage(p.getTotalPage());
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", p.getBegin());
		map.put("end", p.getEnd());
		map.put("m_id", m_id);
		System.out.println("dddd");
		
		List<ReviewVO> reviewList = reviewService.ReviewAdmin(map);
		List<OrdersVO> writeList = ordersService.OrderReview(map);
		
		int nullcheck = 0;

		if(ordersService.OrderCount(m_id) == 0) {
			nullcheck = 1;
			model.addAttribute("nullcheck", nullcheck);
		}else {
			model.addAttribute("reviewListsize", reviewList.size());
			System.out.println("reviewList.size( : " + reviewList.size());
			System.out.println("reviewList : " + reviewList);
			System.out.println("writeList : " + writeList);
			model.addAttribute("reviewList", reviewList);
			model.addAttribute("writeList", writeList);
			model.addAttribute("pvo", p);		
			model.addAttribute("nullcheck", nullcheck);

		}
		
		return "reviewAdministrate.jsp";
	}
	@RequestMapping("/reviewWrite.do")
	public String reviewWrite(int s_id, int sco_num, String menu_name, Model model){
		
		System.out.println("s_id : " + s_id);
		
		model.addAttribute("s_id", s_id);		
		model.addAttribute("menu_name", menu_name);		
		model.addAttribute("sco_num", sco_num);		
		
		return "reviewWrite.jsp";
	}
	
	@RequestMapping("/reviewUpdate.do")
	public String reviewUpdate(ReviewVO review, Model model, HttpSession session){
		
		System.out.println("review : " + review);
		
		int m_id = (int) session.getAttribute("m_id");
		StoreVO store = storeService.getStoreInfo(review.getS_id());
		
		int s_classification = store.getS_classification();
		
		review.setS_classification(s_classification);
		review.setM_id(m_id);
		System.out.println("review : " + review);
		
		reviewService.insertReview(review);
		
		return "reviewAdministrate.do";
	}
	@RequestMapping("/reviewDelete.do")
	public String reviewDelete(int r_id, Model model){
		System.out.println("r_id : " + r_id);
		
		model.addAttribute("r_id", r_id);
		System.out.println("r_id : " + r_id);
		
		reviewService.reviewDelete(r_id);
		
		return "reviewAdministrate.do";
	}	
}
