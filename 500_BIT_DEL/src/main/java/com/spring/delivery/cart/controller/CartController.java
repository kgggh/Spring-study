package com.spring.delivery.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.delivery.cart.service.CartService;
import com.spring.delivery.cart.service.CartVO;
import com.spring.delivery.cart.service.CartVOList;
import com.spring.delivery.menu.service.MenuService;
import com.spring.delivery.menu.service.MenuSortService;
import com.spring.delivery.menu.service.MenuSortVO;
import com.spring.delivery.menu.service.MenuVO;
import com.spring.delivery.menu.service.MenuVOList;
import com.spring.delivery.menuoption.service.MenuOptionService;
import com.spring.delivery.menuoption.service.MenuOptionVO;

@Controller
@SessionAttributes("cart") // board 라는 이름의 Model이 있으면 session에 저장
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private MenuOptionService menuOptionService;
	
	
	public CartController() {
		/* System.out.println("--->> MenuController() 객체생성"); */
	}

	//카 목록
	@RequestMapping("/getCartList.do") 
	public String getCartList(Model model,  HttpSession session) {
		
		int m_id = (int) session.getAttribute("m_id");
		
		
		//동일장바구니번호 추출
		List<CartVO> cartList = cartService.selectAllCart(m_id);
		List<CartVO> cartMenuList = cartService.selectMenuCart(m_id);
		int scbcount = cartService.selectScbCartCount(m_id);
		
		model.addAttribute("cartList", cartList);
		model.addAttribute("cartMenuList", cartMenuList);
		model.addAttribute("cartMenuListSize", cartMenuList.size());


		return "cartList.jsp"; 
	  
	 }
	 
	@RequestMapping("/getGoCartOrder.do") 
	public String updateCart(Model model,  HttpSession session, CartVOList cartList) {
		
		int m_id = (int) session.getAttribute("m_id");
		System.out.println("cartList : " + cartList);
		
		System.out.println("m_id : " + m_id);
		
		List<CartVO> cartList1 =  cartService.selectAllCart(m_id);
	
		int scbnum = 0;
		int b_amount = cartList.getCartList().get(0).getB_amount();
		int b_price = cartList.getCartList().get(0).getB_price();
		
		//장바구니에 값이 없을 때
		if(cartList1.isEmpty()) {
			System.out.println("null 일 때");
			scbnum = 1;
		}else {
			System.out.println("null 아닐 때");
			scbnum = cartService.maxScbNum(m_id) + 1;
		}
		
		
		System.out.println("scbnum : " + scbnum);
		
		for(CartVO cart : cartList.getCartList()) {
			cart.setScb_num(scbnum);
			cart.setM_id(m_id);
			cart.setB_amount(b_amount);
			cart.setB_price(b_price);
			System.out.println("cart : " + cart);
			cartService.insertCart(cart);
		}
		
		
		return "getCartList.do"; 
	  
	 }
	
	@RequestMapping("/deleteCart.do") 
	public String deleteCart(Model model,  HttpSession session, int scb_num) {
		
		cartService.deleteCart(scb_num);
		int m_id = (int) session.getAttribute("m_id");
		return "getCartList.do"; 
	  
	 }
}
