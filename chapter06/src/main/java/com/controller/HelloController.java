package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello.do", method=RequestMethod.GET)
	public ModelAndView hello() { // 사용자 콜백 메소드 - 내가 호출하는 게 아니라 스프링이 알아서 호출하는 메소드 (단, 스프링이 만든게 아니라 내가 만든 메소드(hello())를 호출)
									// 기존 매핑과 다른점 : 기존에는 init()메소드 등 기존에 만든 메소드를 오버라이딩 한 거지 내가 만든게 아니다
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "Hello Spring MVC!!"); // 이제 request에다 데이터 싣는게 아니라 ModelAndView에다 데이터를 실음
		//mav.setViewName("hello"); // 파일명 지정 (폴더명과 확장자는 dispatcherServlet-serlvet.xml에서 지정함)
								  // jsp의 파일 -> /view/hello.jsp (굳이 찢어놓은 이유? 폴더명과 확장자는 변하지 않기때문에 xml로 따로 빼준 것)
		mav.setViewName("/view/hello");
		return mav;
	}
	
	// URL에서 바로 JSP가 실행되지 않게 하기 위해서 /WEB-INF에 JSP 파일을 작성한다.
	// http://localhost:8080/chapter06/WEB-INF/view/hello2.jsp을 실행 할 수 없다.
	@RequestMapping(value="/hello2.do", method=RequestMethod.GET)
	public ModelAndView hello2() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result2", "Have a nice day!!");
		
		mav.setViewName("/WEB-INF/view2/hello2"); // 이렇게 해놓으면 절대로 외부에서 접근이 안됨
	
		return mav;
	}
	
	/* 스프링에서 리턴타입이 String 이면 단순 문자열이 아니라, JSP 파일명으로 인식한다. 
	   so, welcome.jsp 파일을 찾게 된다.
	   만약에 단순 문자열로 처리 하고 싶으면 @ResponseBody를 써야 한다.
	*/
	@RequestMapping(value="/hello3.do", method=RequestMethod.GET, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String hello3() {
		//return "welcome";
		return "안녕하세요"; // 한글이 깨지지 않게 하기 위해서 Mapping에 produces = "text/html; charset=UTF-8"를 추가해야 한다.
	}
}