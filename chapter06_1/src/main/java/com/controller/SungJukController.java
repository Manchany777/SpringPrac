package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SungJukDTO;

@Controller
@RequestMapping(value="sungJuk") // 중복처리되는 매핑 코드를 전역으로 처리 (슬래시 안써넣어도 자기가 알아서 구분자로 슬래시를 넣어줌)
public class SungJukController {
	
	//@GetMapping("/sungJuk/input.do")
	//@PostMapping(value="/sungJuk/input.do")  -- (x)
	//@RequestMapping(value="/sungJuk/input.do", method=RequestMethod.GET) 
	@RequestMapping(value="input.do", method={RequestMethod.GET, RequestMethod.POST})
	public String input() {
		return "/sungJuk/input";
	}
	
	//@PostMapping("/sungJuk/result.do")
	@RequestMapping(value="result.do", method=RequestMethod.POST)
	public String result(@ModelAttribute SungJukDTO sungJukDTO, ModelMap modelMap) {
		int kor = sungJukDTO.getKor();
	    int eng = sungJukDTO.getEng();
	    int math = sungJukDTO.getMath();
	    int tot = kor + eng + math;
	    double avg = (double) tot / 3.;
	    String avgFormat = String.format("%.3f", avg);
	    
	    
	    // model이면 model.addAttribute
		modelMap.put("name", sungJukDTO.getName());
		modelMap.put("kor", kor);
		modelMap.put("eng", eng);
		modelMap.put("math", math);
	    modelMap.put("tot", tot);
		modelMap.put("avg", avgFormat);
		return "/sungJuk/result";
	}
}
