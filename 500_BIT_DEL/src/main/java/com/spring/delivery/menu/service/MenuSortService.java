package com.spring.delivery.menu.service;

import java.util.List;

public interface MenuSortService {
	 /* public MenuVO selectOneMenu(String id); */
	public List<MenuSortVO> selectAllMenuSort(MenuVO vo);
	public int insertMenuSort(MenuSortVO sort);
	public int disableMenuSort(int m_sort_id);
	public int selectFirstSortID(MenuVO vo);
/*	 * selectAllMember();
	 * 
	 * public int insertMember(MemberVO vo); public int updateMember(MemberVO vo);
	 * public int deleteMember(String id); public MemberVO checkIdPassword(String
	 * id, String password);
	 */
}
