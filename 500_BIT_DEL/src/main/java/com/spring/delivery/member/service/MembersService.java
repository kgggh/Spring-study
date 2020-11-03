package com.spring.delivery.member.service;

import java.util.List;

public interface MembersService {
	public MembersVO selectOneMember(int id);
	public List<MembersVO> selectAllMember();
	public int insertMember(MembersVO vo);
	public MembersVO checkIdPassword(String id, String password);
	public void s_mypage_modifyM(MembersVO loginMember);
	public String idChk(String id);
	public MembersVO userIdSearch(MembersVO vo);
	public MembersVO userPwSearch(MembersVO vo);
	public void userInfoChange(MembersVO vo);
	public void userInfoDel(MembersVO vo);
	
}
