package com.spring.delivery.member.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.delivery.member.service.MembersService;
import com.spring.delivery.member.service.MembersVO;

@Service("membersService")
public class MembersServiceImpl implements MembersService {
	@Autowired
	private MembersDAO membersDAO;
	
	@Override
	public MembersVO selectOneMember(int id) {
		return membersDAO.selectOneMember(id);
	}

	@Override
	public List<MembersVO> selectAllMember() {
		return membersDAO.selectAllMember();
	}

	@Override
	public int insertMember(MembersVO vo) {
		return membersDAO.insertMember(vo);
	}
	//로그인 아이디패스워드 확인
	@Override
	public MembersVO checkIdPassword(String id, String password) {
		return membersDAO.checkIdPassword(id, password);
	}
	//아이디 찾기
	@Override
	public MembersVO userIdSearch(MembersVO vo) {
		return membersDAO.userIdSearch(vo);
	}
	//패스워드 찾기
	@Override
	public MembersVO userPwSearch(MembersVO vo) {
		return membersDAO.userPwSearch(vo);
	}
	
	//회원가입 아이디 중복확인
	@Override
	public String idChk(String id) {
		return membersDAO.idChk(id);
	}

	//회원정보 수정
	@Override
	public void userInfoChange(MembersVO vo) {
		membersDAO.userInfoChange(vo);
	}
	//회원삭제 
	@Override
	public void userInfoDel(MembersVO vo) {
		membersDAO.userInfoDel(vo);
	}
	@Override
	public void s_mypage_modifyM(MembersVO loginMember) {
		membersDAO.s_mypage_modifyM(loginMember);
		
	}

}
