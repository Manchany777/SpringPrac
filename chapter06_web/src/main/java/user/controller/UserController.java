package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import user.service.UserService;


@Controller
@RequestMapping(value="user") // 중복처리되는 매핑 코드를 전역으로 처리 (슬래시 안써넣어도 자기가 알아서 구분자로 슬래시를 넣어줌)
public class UserController {
	@Autowired // UserService와 의존관계 형성
	private UserService userService;

	//@GetMapping(value="/user/writeForm")
	@RequestMapping(value="writeForm", method={RequestMethod.GET, RequestMethod.POST}) // 요청시 부르는 것
	public String writeForm() {
		return "/user/writeForm"; // jsp 찾아가자
	}
	
	@PostMapping(value="/user/write")
	@ResponseBody // exist를 jsp가 아닌 실제 문자열이 넘어가게 함
	public String write(@RequestParam String id) { // = request.getParameter("id");
		
		//DB연결을 여기서 하는게 아니라 일을 하는 집합체인 UserServiceImpl에서 한다.
		//return "exist" or "non_exist"; -> 이런식으로 리턴하는 값을 UserServiceImpl에서 하도록 해야한다는 말
		return userService.write(id);
	}
}