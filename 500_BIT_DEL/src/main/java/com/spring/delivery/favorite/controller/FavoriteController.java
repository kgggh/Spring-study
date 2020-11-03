package com.spring.delivery.favorite.controller;

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
@SessionAttributes("svo")
public class FavoriteController {
	@Autowired
	private FavoriteService favoriteService;

	
	@RequestMapping("/delFavorite.do")
	public String delFavorite(int s_id, Model model, HttpSession session){
		
		int m_id = (int) session.getAttribute("m_id");
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("s_id", s_id);
		map.put("m_id", m_id);
		
		favoriteService.deleteFavorite(map);
		

		return "storeList.do";
	}

	@RequestMapping("/setFavorite.do")
	public String setFavorite(int s_id, Model model, HttpSession session){
		
		int m_id = (int) session.getAttribute("m_id");
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("s_id", s_id);
		map.put("m_id", m_id);
		
		favoriteService.insertFavorite(map);
		

		return "storeList.do";
	}

}
