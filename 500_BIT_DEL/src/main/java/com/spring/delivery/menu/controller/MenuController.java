package com.spring.delivery.menu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.delivery.menu.service.MenuService;
import com.spring.delivery.menu.service.MenuSortService;
import com.spring.delivery.menu.service.MenuSortVO;
import com.spring.delivery.menu.service.MenuVO;
import com.spring.delivery.menu.service.MenuVOList;

@Controller
@SessionAttributes("menu") // board 라는 이름의 Model이 있으면 session에 저장
public class MenuController {

	@Autowired
	private MenuService menuService;

	@Autowired
	private MenuSortService menuSortService;

	public MenuController() {
		/* System.out.println("--->> MenuController() 객체생성"); */
	}


	//메뉴 목록
	@RequestMapping("/getMenuList.do") 
	public String getMenuList(Model model,  HttpSession session, MenuVO vo) {
		/* System.out.println(">>> 메뉴 전체 목록 - String getMenuList()"); */
		
		if(vo.getS_id() != 0) {
			int s_id = vo.getS_id();
			session.setAttribute("s_id", s_id);
		}
		//점포에 해당하는 메뉴 목록 불러오기 
		List<MenuVO> menuList = menuService.selectAllMenu(vo);
		model.addAttribute("menuList", menuList);
		  
		//해당점포의 메뉴 구분 목록 불러오기
		List<MenuSortVO> menuSortList = menuSortService.selectAllMenuSort(vo); 
		model.addAttribute("menuSortList", menuSortList);
		/* System.out.println("menuSortList : " + menuSortList); */
		  
		List<MenuVO> menuBestList = menuService.selectBestMenu(vo);
		/* session.setAttribute("menuBestList", menuBestList); */
		  
		model.addAttribute("menuBestList", menuBestList); 
		model.addAttribute("vo", vo); 
		return "menulist.jsp"; 
	  
	 }
	 
	 //메뉴관리
	 @RequestMapping("/setMenuList.do") 
	 public String setMenuList(Model model,  HttpSession session, MenuVO vo) {
		System.out.println("vo : " + vo);
			/* System.out.println(">>> 메뉴 전체 목록 - String getMenuList()"); */
		int m_sort_id = menuSortService.selectFirstSortID(vo);
		model.addAttribute("m_sort_id", m_sort_id);	
		//점포에 해당하는 메뉴 목록 불러오기 
		vo.setM_sort_id(m_sort_id);
		List<MenuVO> menuList = menuService.selectFirstMenu(vo);
		model.addAttribute("menuList", menuList);
		
		//해당점포의 메뉴 구분 목록 불러오기
		List<MenuSortVO> menuSortList = menuSortService.selectAllMenuSort(vo); 
		model.addAttribute("menuSortList", menuSortList);
		model.addAttribute("s_id", vo.getS_id());
		 System.out.println("menuSortList : " + menuSortList); 
			  

		return "menuInsert.jsp";
	  
	 }
	 
	 
	@RequestMapping("/getUpdateMenu.do") 
	public String sortMenuList(Model model, MenuVOList menuVOList) {
		/*
		 * System.out.println(">>> 메뉴 업데이트 - String sortMenuList()");
		 * System.out.println("menuVOList : " + menuVOList);
		 */
		int m_sort_id = menuVOList.getList().get(0).getM_sort_id();
		int s_id = menuVOList.getList().get(0).getS_id();
	
		for(MenuVO vo : menuVOList.getList()) {
			if(vo.getMenu_id() == 0 && vo.getMenu_name() != null) {  //insert
				/* System.out.println("insertVO : " + vo); */
				vo.setM_sort_id(m_sort_id);
				vo.setS_id(s_id);
				menuService.insertMenu(vo);
			}else {
				/* System.out.println("updateVO : " + vo); */
				menuService.updateMenu(vo);
			}
		}
		return "menuSortList.do?s_id="+s_id+"&m_sort_id="+m_sort_id;
	  
	}
	
	//메뉴 구분별로 메뉴 리스트 불러오기
	@RequestMapping("/menuSortList.do") 
	public String sortMenuList(Model model, MenuVO vo) {
		/*
		 * System.out.println(">>> 메뉴 구분 별 목록 - String getMenuList()");
		 * System.out.println("vo : " + vo);
		 */
		List<MenuSortVO> menuSortList = menuSortService.selectAllMenuSort(vo); 
		model.addAttribute("menuSortList", menuSortList);
		/*
		 * System.out.println("menuSortList : " + menuSortList);
		 */
		//점포에 해당하는 모든 메뉴 목록 불러오기 
		List<MenuVO> allmenuList = menuService.selectAllMenu(vo);
		/* System.out.println("allmenuList : " + allmenuList); */
		model.addAttribute("s_id", vo.getS_id());
		model.addAttribute("m_sort_id", vo.getM_sort_id());
		for(MenuVO menu : allmenuList) {
			if(menu.getM_sort_id() == vo.getM_sort_id()) {
				List<MenuVO> menuList = menuService.selectSortmenu(vo);
				model.addAttribute("menuList", menuList);
				break;
			}else {
				model.addAttribute("menuList", null);
			}
		}
		return "menuInsert.jsp";	  
	}
	
	@RequestMapping("/addSort.do")   //메뉴 구분 추가하기
	public String addSort(Model model, MenuSortVO sort) {
		/*
		 * System.out.println(">>> 메뉴 구분 추가- String getMenuList()");
		 * System.out.println("sort : " + sort);
		 */
		MenuVO vo = new MenuVO();
		vo.setS_id(sort.getS_id());
		menuSortService.insertMenuSort(sort);

		return "setMenuList.do?s_id="+sort.getS_id();
	}
	
	@RequestMapping("/disableMenu.do")   //메뉴 삭제
	public String disableMenu(Model model, MenuVO menu) {
		/*
		 * System.out.println(">>> 메뉴 구분 추가- String deleteMenu()");
		 * System.out.println("menu_id" + menu.getMenu_id());
		 */
		
		int menu_id = menu.getMenu_id();
		
		menuService.disableMenu(menu_id);

		return "setMenuList.do?s_id="+menu.getS_id();
	}
	
	@RequestMapping("/disableMenuSort.do")   //메뉴 삭제
	public String disableMenuSort(Model model, MenuSortVO menusort) {
			/*
		 * System.out.println(">>> 메뉴 구분 추가- String deleteMenu()");
		 * System.out.println("menu_id" + menu.getMenu_id());
		 */
		
		int m_sort_id = menusort.getM_sort_id();
		
		menuSortService.disableMenuSort(m_sort_id);
		
		return "setMenuList.do?s_id="+menusort.getS_id();
	}		
}
