package user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="user") // 중복처리되는 매핑 코드를 전역으로 처리 (슬래시 안써넣어도 자기가 알아서 구분자로 슬래시를 넣어줌)
public class UserController {

	//@GetMapping(value="/user/writeForm")
	@RequestMapping(value="writeForm", method={RequestMethod.GET, RequestMethod.POST}) // 요청시 부르는 것
	public String writeForm() {
		return "/user/writeForm"; // jsp 찾아가자
	}
}