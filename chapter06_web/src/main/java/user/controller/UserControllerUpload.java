package user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="user")
public class UserControllerUpload {
	
	@GetMapping(value="uploadForm")
	public String uploadForm() {
		return "/user/uploadForm";
	}
}