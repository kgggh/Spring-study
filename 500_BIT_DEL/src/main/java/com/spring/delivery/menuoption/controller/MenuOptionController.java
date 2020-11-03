package com.spring.delivery.menuoption.controller;

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
import com.spring.delivery.menuoption.service.MenuOptionService;
import com.spring.delivery.menuoption.service.MenuOptionSortService;
import com.spring.delivery.menuoption.service.MenuOptionSortVO;
import com.spring.delivery.menuoption.service.MenuOptionVO;
import com.spring.delivery.menuoption.service.MenuOptionVOList;

@Controller
@SessionAttributes("menu") // menuoption 라는 이름의 Model이 있으면 session에 저장
public class MenuOptionController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private MenuOptionService menuOptionService;
	
	@Autowired
	private MenuOptionSortService menuOptionSortService;

	public MenuOptionController() {
		/* System.out.println("--->> MenuOptionController() 객체생성"); */
	}


	@RequestMapping("/getMenuOptionList.do")
	public String getMenuOptionList(Model model, MenuVO vo) {
		/* System.out.println(">>> 옵션 목록 - String getMenuOptionList()"); */
		
		MenuVO menu = menuService.selectOnemenu(vo);
		model.addAttribute("menu", menu);

		//메뉴의 옵션 리스트 가져오기
		List<MenuOptionVO> menuOptionList = menuOptionService.selectAllOption(vo);
		model.addAttribute("menuOptionList", menuOptionList);
		/* System.out.println("menuOptionList : " + menuOptionList); */
		//메뉴의 옵션 구분 가져오기
		List<MenuOptionSortVO> OptionSortList = menuOptionSortService.selectOptionSort(vo);
		model.addAttribute("OptionSortList", OptionSortList);
		
		int opSortCount = menuOptionSortService.selectOptionSortCount(vo);
		model.addAttribute("opSortCount", opSortCount);
		model.addAttribute("menu_id", menu.getMenu_id());
		
		int opCount = menuOptionService.selectOptionCount(vo);
		model.addAttribute("opCount", opCount);
		
		/* System.out.println("OptionSortList : " + OptionSortList); */
		return "menuOptionList.jsp";
	}

	//옵션페이지이동
	@RequestMapping("/optionAdd.do") 
	public String addOption(Model model, HttpSession session, MenuVO vo) {
		
		System.out.println("vo : "  + vo);
		//첫번째 옵션 구분에 해당하는 옵션리스트 가져오기
		MenuOptionSortVO opsort = menuOptionSortService.selectFirstOpSortID(vo);
		
		
		
		if(opsort != null) {
			int op_s_id = opsort.getOp_s_id();
			System.out.println("op_s_id : " + op_s_id);
			MenuOptionVO option = new MenuOptionVO();
			option.setOp_s_id(op_s_id);
			option.setMenu_id(vo.getMenu_id());
			List<MenuOptionVO> menuOptionList = menuOptionService.selectFirstOption(option);
			model.addAttribute("menuOptionList", menuOptionList);
			model.addAttribute("op_s_id", op_s_id);
			List<MenuOptionSortVO> OptionSortList = menuOptionSortService.selectOptionSort(vo);
			model.addAttribute("OptionSortList", OptionSortList);
			model.addAttribute("menu_id", vo.getMenu_id());
			session.setAttribute("menu_name", vo.getMenu_name());
			if(vo.getS_id() != 0) {
				session.setAttribute("s_id", vo.getS_id());
			}
		}else {
			
			model.addAttribute("menu_id", vo.getMenu_id());
			if(vo.getS_id() != 0) {
				session.setAttribute("s_id", vo.getS_id());
			}
			session.setAttribute("menu_name", vo.getMenu_name());
		}
		
		/* System.out.println("OptionSortList : " + OptionSortList); */

		return "menuOptionInsert.jsp";
	  
	}
	@RequestMapping("/addOptionSort.do") //옵션 구분 추가
	public String addOptionSort(Model model, MenuOptionSortVO vo) {
		/* System.out.println("vo : " + vo); */
		//옵션리스트 가져오기
		menuOptionSortService.insertOptionSort(vo);
		
		
		return "optionAdd.do?menu_id="+vo.getMenu_id();
	  
	}
	@RequestMapping("/optionSortList.do") //옵션 별로 리스트 가져오기
	public String optionSortList(Model model, MenuOptionSortVO optionSort) {
		
		//옵션리스트 가져오기
		MenuVO vo = new MenuVO();
		vo.setMenu_id(optionSort.getMenu_id());
		List<MenuOptionSortVO> OptionSortList = menuOptionSortService.selectOptionSort(vo);
		model.addAttribute("OptionSortList", OptionSortList);
		/* System.out.println("OptionSortList : " + OptionSortList); */
		model.addAttribute("menu_id", optionSort.getMenu_id());
		model.addAttribute("op_s_id", optionSort.getOp_s_id());

		//메뉴의 모든 옵션 리스트 가져오기
		List<MenuOptionVO> allOptionList = menuOptionService.selectAllOption(vo);
		/*
		 * System.out.println("allOptionList : " + allOptionList);
		 */
		for(MenuOptionVO option : allOptionList) {
			if(option.getOp_s_id() == optionSort.getOp_s_id()) {
				List<MenuOptionVO> menuOptionList = menuOptionService.selectSortOption(optionSort);
				model.addAttribute("menuOptionList", menuOptionList);
				break;
			}else {
				model.addAttribute("menuOptionList", null);
			}
		}
		
		
		
		return "menuOptionInsert.jsp";
	}
	
	@RequestMapping("/getUpdateOption.do") 
	public String sortMenuList(Model model, MenuOptionVOList menuOptionVOList) {
		/*
		 * System.out.println(">>> 옵션 업데이트 - String getUpdateOption()");
		 */
		System.out.println("menuOptionVOList : " + menuOptionVOList);
		int op_s_id = menuOptionVOList.getList().get(0).getOp_s_id();
		int menu_id = menuOptionVOList.getList().get(0).getMenu_id();
	
		for(MenuOptionVO vo : menuOptionVOList.getList()) {
			if(vo.getOp_id() == 0 ) {  //insert
				/* System.out.println("insertVO : " + vo); */
				vo.setOp_s_id(op_s_id);
				vo.setMenu_id(menu_id);
				menuOptionService.insertOption(vo);
			}else {
				/* System.out.println("updateVO : " + vo); */
				menuOptionService.updateOption(vo);
			}
		}
		return "optionSortList.do?menu_id="+menu_id+"&op_s_id="+op_s_id;
	  
	}
	
	@RequestMapping("/disableOption.do")   //옵션 삭제
	public String deleteOption(Model model, MenuOptionVO option) {
		/* System.out.println(">>> 옵션 삭제- String deleteOption()"); */

		menuOptionService.disableOption(option);

		return "optionAdd.do?menu_id="+option.getMenu_id();
	}
	@RequestMapping("/disableOpSort.do")   //옵션 삭제
	public String disableOpSort(Model model, MenuOptionSortVO optionSort) {
		/* System.out.println(">>> 옵션 삭제- String deleteOption()"); */
		
		int op_s_id = optionSort.getOp_s_id();
		menuOptionSortService.disableOpSort(op_s_id);

		return "optionAdd.do?menu_id="+optionSort.getMenu_id();
	}
}
