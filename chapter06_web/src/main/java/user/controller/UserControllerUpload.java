package user.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import user.bean.UserImageDTO;

@Controller
@RequestMapping(value="user")
public class UserControllerUpload {
	
	@GetMapping(value="uploadForm")
	public String uploadForm() {
		return "/user/uploadForm";
	}
	
	//-------------------------name="img" 1기 일때-------------------------
	@PostMapping(value="upload")
	@ResponseBody
	public String upload(@ModelAttribute UserImageDTO userImageDTO, @RequestParam MultipartFile img, HttpSession session) {
		
		// 가상폴더
		String filePath_lier = "D:/bitcamp/Spring/workspace/chapter06_web/src/main/webapp/WEB-INF/storage"; // 혹은 filePathLier
		
		// 실제폴더
		String filePath = session.getServletContext().getRealPath("/WEB-INF/storage"); // 실제 폴더 경로 찍기 위함
		System.out.println("실제폴더 = " + filePath);
		// 실제폴더 = D:\bitcamp\Spring\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\chapter06_web\WEB-INF\storage
		
		String fileName = img.getOriginalFilename(); // 실제 파일 이름 찍기 위함
		
		// 파일 객체 생성 (실제 경로로 할지 가상 경로로 할지 선택)
		File file = new File(filePath, fileName); // 실제 폴더 경로와 실제 파일 이름을 뭉쳐서 파일을 생성하도록 함 (java.io로 import)
		//File file = new File(filePath_lier, fileName); // 가상 폴더로 올라가도록 함
		
		// 파일 이름
		try {
			img.transferTo(file); // Multpart에 올라와 있는 파일을 실제 폴더로 이동하도록 함
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		} 
		
		// DB
		userImageDTO.setImage1(fileName);
		
		
		return "<img src='/chapter06_web/storage/" + fileName+ "' width='300' height='300'>";
	}
}