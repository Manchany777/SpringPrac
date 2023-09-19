package com.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SumDTO;


@Controller
public class SumController {
	
	//@RequestMapping(value="/input.do", method=RequestMethod.GET)
	@GetMapping(value="/input.do")	// get방식을 request없이 쓸 수 있다. 제이쿼리에서 $.ajax() 대신 $.get()을 쓰는 것과 마찬가지
	public String input() {
		return "/sum/input"; // String은 자동으로 .jsp파일로 인식해주기 때문에 "/sum/input.jsp" 라고 하면 안 됨
							 // servlet-context.xml에서 WEB-INF를 접두어로 지정해줬기때문에 여기서 쓸 필요x
	}
	
	//1.String 쓰는 방식
	/*
	@GetMapping(value="/result.do")	// get방식을 request없이 쓸 수 있다. 제이쿼리에서 $.ajax() 대신 $.get()을 쓰는 것과 마찬가지
	public String result() {
		return "/sum/result"; // String은 자동으로 .jsp파일로 인식해주기 때문에 "/sum/input.jsp" 라고 하면 안 됨
							 // servlet-context.xml에서 WEB-INF를 접두어로 지정해줬기때문에 여기서 쓸 필요x
	}*/
	
	//2.@RequestMapping 쓰는 방식 - HTTP 요청의 파라미터는 모두 문자열로 전송되며, Spring MVC는 이러한 파라미터 값을 문자열로 수신한다.
	/*
	@RequestMapping(value="/result.do")
	public ModelAndView result(@RequestParam int x, @RequestParam int y) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("x", x);
		mav.addObject("y", y);
		mav.setViewName("/sum/result");
		return mav;
	}*/
	
	//  입력 유효성 검사 : 사용자가 해당 입력창에 값을 입력하지 않거나, 엉뚱한 값을 넣을 수도 있다. 이럴 경우에 쓰는 예외처리 기술
	// required = false : 해당 매개변수가 필수가 아니라 선택적임을 나타냄. 즉, 클라이언트 요청에서 해당 매개변수가 누락되어도 컨트롤러 메서드가 정상적으로 호출됨
	// defaultValue : 아무값도 입력 안할시 디폴트로 0을 입력 시킴 - 게시판 페이징 할 때 많이 사용
	/*
	@RequestMapping(value="/result.do")
	public ModelAndView result(@RequestParam(required = false, defaultValue = "0") String x, 
							   @RequestParam(required = false, defaultValue = "0") String y) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("x", x);
		mav.addObject("y", y);
		mav.setViewName("/sum/result");
		return mav;
	}*/
	
	// 3. Map 방식(가장 많이 씀) : 파라미터가 2~3개 어정쩡하게 들어올때 일일이 다 쓰기 번거로워진다??
	/*
	@RequestMapping(value="/result.do")
	public ModelAndView result(@RequestParam Map<String, String> map) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("x", map.get("x"));
		mav.addObject("y", map.get("y"));
		mav.setViewName("/sum/result");
		return mav;
	}*/
	
	// 4. ModelMap 방식 - ModelAndView가 식상해서 쓰기 싫을 때
	// 콜백메소드이기 때문에 new할 필요가 없다. 스프링이 알아서 가져다 줌
	/*
	@RequestMapping(value="/result.do")              // session = request.getSession(); 할 필요x
	public String result(@RequestParam Map<String, String> map, ModelMap modelMap, HttpSession session) {
		modelMap.put("x", map.get("x"));
		modelMap.put("y", map.get("y"));
		return "/sum/result";
	}*/
	
	// 5. Map 대신 DTO로 받는 방식
	// Map과는 달리 객체라서 param이 아닌 Attribute로 받아야함
	@RequestMapping(value="/result.do")              // session = request.getSession(); 할 필요x
	public String result(@ModelAttribute SumDTO sumDTO, ModelMap modelMap) {
		modelMap.put("x", sumDTO.getX());
		modelMap.put("y", sumDTO.getY());
		return "/sum/result";
	}
	// 혹은 Model로 해도 된다
	/*
	public String result(@ModelAttribute SumDTO sumDTO, Model model) {
		model.addAttribute("x", sumDTO.getX());
		model.addAttribute("y", sumDTO.getY());
		return "/sum/result";
	}*/
}
