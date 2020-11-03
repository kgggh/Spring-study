package com.spring.delivery.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.delivery.member.service.MembersService;
import com.spring.delivery.member.service.MembersVO;


@Controller
@SessionAttributes("loginMember")
public class MembersController {
	@Autowired
	private MembersService membersSerivce;
	
	//회원가입
	@RequestMapping(value = "/signup.do", method = RequestMethod.POST)
	public String signup(MembersVO vo, Model model) {
		membersSerivce.insertMember(vo);
		System.out.println("화원가입 완료");
		String msg = "회원가입 완료. 로그인페이지로 이동합니다.";
		model.addAttribute("msg", msg);
		return "login.jsp";
	}
	@RequestMapping(value = "/signup.do", method = RequestMethod.GET)
	public String signupView() {
		return "signup.jsp";
	}
	
	//회원가입 아이디중복확인
	@RequestMapping(value = "/idChk.do", method = RequestMethod.GET)
	public String idChk(String id, Model model) {
		System.out.println("id = " + id);
		String id1 = membersSerivce.idChk(id);
		if (id1 != null) {
			String msg = "중복된 아이디 입니다.";
			model.addAttribute("msg", msg);
			System.out.println("msg = "+ msg);
			return "signup.jsp";
		} else {
			String msg = "회원가입 가능한 아이디 입니다.";
			model.addAttribute("msg", msg);
			model.addAttribute("id", id);
			System.out.println("msg = "+ msg);
			return "signup.jsp";
		}
		
	}
	

	@RequestMapping("/logout.do")
	public String logout(Model model, HttpSession session) {

		session.setAttribute("m_id", 0);
		
		
		
		return "login.jsp";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(MembersVO vo, Model model, HttpSession session) {
		System.out.println("login.do");
		MembersVO loginMember = membersSerivce.checkIdPassword(vo.getId(),vo.getPassword());
		System.out.println("loginMember : " + loginMember);
		String msg = "잘못 입력하였거나 입력하지 않아 로그인 실패 하였습니다.";
		if (loginMember != null) {
			session.setAttribute("m_id", loginMember.getM_id());
			model.addAttribute("loginMember", loginMember);
			msg = "로그인 되었습니다.";
			model.addAttribute("msg", msg);
			if(loginMember.getC_s() == 0) {
				return "/s_mypage.do";
			}else {
				return "storeList.do?s_classification=0";
			}
		}else{
			model.addAttribute("msg", msg);
			return "login.jsp";
		}
		
	}
	
	   //아이디 찾기
	   @RequestMapping(value = "userIdSearch.do", method = RequestMethod.POST)
	   public String userIdSearch(MembersVO vo, Model model) {
	      System.out.println("vo = " + vo);
	      MembersVO userIdSearch = membersSerivce.userIdSearch(vo);
	      if (userIdSearch != null) {
	         model.addAttribute("userIdSearch", userIdSearch);
	         return "userIdSearchModal.jsp";
	      } else {
	         String msg = "성함, 연락처가 잘 못 입력 되었습니다.";
	         model.addAttribute("msg", msg);
	         return "userIdpwSearch.jsp";
	      }
	   }
	   @RequestMapping(value = "/userIdSearch.do", method = RequestMethod.GET)
	   public String userIdSearchView() {
	      return "userIdSearchModal.jsp";
	   }
	   //패스워드 찾기
	   @RequestMapping(value = "userPwSearch.do", method = RequestMethod.POST)
	   public String userPwSearch(MembersVO vo, Model model) {
	      System.out.println("vo = " + vo);
	      MembersVO userPwSearch = membersSerivce.userPwSearch(vo);
	      if (userPwSearch != null) {
	         model.addAttribute("userPwSearch", userPwSearch);
	         return "userPwSearchModal.jsp";
	      } else {
	         String msg1 = "아이디, 연락처가 잘 못 입력 되었습니다.";
	         model.addAttribute("msg1", msg1);
	         return "userIdpwSearch.jsp";
	      }
	   }
	   @RequestMapping(value = "/userPwSearch.do", method = RequestMethod.GET)
	   public String userPwSearchView() {
	      return "userPwSearchModal.jsp";
	   }
	   //회원정보수정
	   @RequestMapping(value = "/userInfoChange.do", method = RequestMethod.POST)
	   public String userInfoChange(MembersVO vo, Model model) {
	      membersSerivce.userInfoChange(vo);
	      String msg = "회원정보 수정 완료.";
	      model.addAttribute("msg", msg);
	      return "userInfoChangeForm.jsp";
	   }
	   //회원정보수정폼
	   @RequestMapping(value = "/userInfoChangeForm.do")
	   public String userInfoChangeForm(MembersVO vo, Model model) {
	      return "userInfoChange.jsp";
	   }
	   //회원삭제
	   @RequestMapping(value = "/userInfoDel.do")
	   public String userInfoDel(MembersVO vo, Model model,HttpSession session) {
	      membersSerivce.userInfoDel(vo);
	      String msgD = "회원탈퇴 완료. 메인페이지로 이동합니다.";
	      model.addAttribute("msgD", msgD);
	      return "index.jsp";
	   }
		
	
	@RequestMapping("/s_mypage_modifyM.do")
	public String  selectOneMember(MembersVO loginMember, Model model){
		
		membersSerivce.s_mypage_modifyM(loginMember);
		loginMember = membersSerivce.selectOneMember(loginMember.getM_id());
		model.addAttribute("loginMember", loginMember);
		return "/s_mypage.do?m_id="+loginMember.getM_id();
	}	
}