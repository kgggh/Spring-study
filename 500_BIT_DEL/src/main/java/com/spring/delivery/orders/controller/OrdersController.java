package com.spring.delivery.orders.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.delivery.cart.service.CartService;
import com.spring.delivery.cart.service.CartVO;
import com.spring.delivery.cart.service.CartVOList;
import com.spring.delivery.menu.service.MenuService;
import com.spring.delivery.menuoption.service.MenuOptionService;
import com.spring.delivery.orders.service.OrdersService;
import com.spring.delivery.orders.service.OrdersVO;
import com.spring.delivery.orders.service.SalseVO;
import com.spring.delivery.store.service.TipService;
import com.spring.delivery.store.service.TipVO;

@Controller
public class OrdersController {
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private CartService cartService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private MenuOptionService menuOptionService;
	@Autowired
	private TipService tipService;
	@RequestMapping("/salse_Management.do")
	public String  salse_Management(String s_id, Model model){
		System.out.println(s_id);
		int sid = Integer.parseInt(s_id);
		
		List<SalseVO> salseList = ordersService.salse_Management(sid);
		model.addAttribute("salseList", salseList);
		return "/salse_Management.jsp";
	}
	
	//메뉴 목록
	@RequestMapping("/getOrderList.do") 
	public String getCartList(Model model,  HttpSession session, CartVOList cartVOList, int o_price) {
		
		int m_id = (int) session.getAttribute("m_id");
		System.out.println("cartVOList : " + cartVOList);
		String dong = (String) session.getAttribute("dong");
		int s_id = cartVOList.getCartList().get(0).getS_id();
		TipVO tip = new TipVO();
		tip.setDong(dong);
		tip.setS_id(s_id);
		
		TipVO tipPrice = tipService.getDongTip(tip);
		System.out.println("o_price : " + o_price);
		
		//변경된 cart 데이터로 다시 저장하고
		for(CartVO cart : cartVOList.getCartList()) {
			cart.setM_id(m_id);
			cartService.updateCart(cart);
		}
		
		//동일장바구니번호 추출
		List<CartVO> cartList = cartService.selectAllCart(m_id);
		List<CartVO> cartMenuList = cartService.selectMenuCart(m_id);
		int scbcount = cartService.selectScbCartCount(m_id);
		
		model.addAttribute("cartList", cartList);
		model.addAttribute("tipPrice", tipPrice);
		model.addAttribute("o_price", o_price);
		model.addAttribute("cartMenuList", cartMenuList);
		model.addAttribute("cartMenuListSize", cartMenuList.size());
		

		return "orderList.jsp"; 
	  
	 }
		/*
		 * //메뉴 목록
		 * 
		 * @RequestMapping("/orderInsert.do")
		 * 
		 * @ResponseBody public String orderInsert(Model model, HttpSession
		 * session,@RequestBody List<CartVO> cartList, int o_price) {
		 * 
		 * int m_id = (int) session.getAttribute("m_id");
		 * System.out.println("cartVOList : " + cartList); int s_id =
		 * cartList.get(0).getS_id();
		 * 
		 * int count = ordersService.OrderCount(m_id); int sconum = 0; //주문내역에 값이 없을 때
		 * if(count == 0) { System.out.println("null 일 때"); sconum = 1; }else {
		 * System.out.println("null 아닐 때"); sconum = ordersService.maxScoNum(m_id) + 1;
		 * }
		 * 
		 * //변경된 cart 데이터로 다시 저장하고 for(CartVO cart : cartList) { cart.setM_id(m_id);
		 * OrdersVO order = new OrdersVO(); order.setM_id(m_id);
		 * order.setSco_num(sconum); order.setMenu_id(cart.getMenu_id());
		 * order.setO_price(o_price); order.setOp_id(cart.getOp_id());
		 * order.setS_id(s_id);
		 * 
		 * ordersService.insertOrder(order); }
		 * 
		 * 
		 * return "order.jsp";
		 * 
		 * }
		 */
}
