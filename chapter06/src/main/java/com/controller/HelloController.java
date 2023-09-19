package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello.do", method=RequestMethod.GET)
	public ModelAndView hello() { // 사용자 콜백 메소드 - 내가 호출하는 게 아니라 스프링이 알아서 호출하는 메소드 (단, 스프링이 만든게 아니라 내가 만든 메소드(hello())를 호출)
									// 기존 매핑과 다른점 : 기존에는 init()메소드 등 기존에 만든 메소드를 오버라이딩 한 거지 내가 만든게 아니다
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "Hello Spring MVC!!"); // 이제 request에다 데이터 싣는게 아니라 ModelAndView에다 데이터를 실음
		mav.setViewName("hello"); // 파일명 지정 (폴더명과 확장자는 dispatcherServlet-serlvet.xml에서 지정함)
								  // jsp의 파일 -> /view/hello.jsp (굳이 찢어놓은 이유? 폴더명과 확장자는 변하지 않기때문에 xml로 따로 빼준 것)
		return mav;
		
	}
}
