package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SumController {
	
	//@RequestMapping(value="/input.do", method=RequestMethod.GET)
	@GetMapping(value="/input.do")	// get방식을 request없이 쓸 수 있다. 제이쿼리에서 $.ajax() 대신 $.get()을 쓰는 것과 마찬가지
	public String input() {
		return "/sum/input"; // String은 자동으로 .jsp파일로 인식해주기 때문에 "/sum/input.jsp" 라고 하면 안 됨
							 // servlet-context.xml에서 WEB-INF를 접두어로 지정해줬기때문에 여기서 쓸 필요x
	}
	
	@RequestMapping(value="/result.do", method=RequestMethod.GET)
	public ModelAndView result() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/sum/result");
		return mav;
	}
}
