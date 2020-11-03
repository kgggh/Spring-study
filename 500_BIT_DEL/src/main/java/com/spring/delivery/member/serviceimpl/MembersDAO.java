package com.spring.delivery.member.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.delivery.member.service.MembersVO;

@Repository
public class MembersDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public MembersVO selectOneMember(int m_id) {
		return mybatis.selectOne("member.selectOneMember", m_id);
	}
	
	public List<MembersVO> selectAllMember() {
		return mybatis.selectList("member.selectAllMember");
	}

	//회원가입
	public int insertMember(MembersVO vo) {
		return mybatis.insert("member.insertMember", vo);
	}
	//회원가입 아이디중복확인
	public String idChk(String id) {
		return mybatis.selectOne("member.idChk", id);
		
	}

	// 로그인 아이디, 패스워드 확인
	public MembersVO checkIdPassword(String id, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);
		return mybatis.selectOne("member.checkIdPassword", map);
	}
	//아이디 찾기
	public MembersVO userIdSearch(MembersVO vo) {
		
		return mybatis.selectOne("member.userIdSearch", vo);
	}
	//패스워드 찾기
	public MembersVO userPwSearch(MembersVO vo) {
		return mybatis.selectOne("member.userPwSearch", vo);
	}
	//회원정보 수정
	public void userInfoChange(MembersVO vo) {
		mybatis.selectOne("member.userInfoChange", vo);
	}
	//회원 탈퇴
	public void userInfoDel(MembersVO vo) {
		mybatis.delete("member.userInfoDel", vo);
	}
	
	public void s_mypage_modifyM(MembersVO loginMember) {
		mybatis.update("member.s_mypage_modifyM", loginMember);
	}
}
