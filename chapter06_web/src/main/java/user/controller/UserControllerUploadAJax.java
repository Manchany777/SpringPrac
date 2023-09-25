package user.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import user.bean.UserImageDTO;
import user.service.UserServiceUpload;

@Controller
@RequestMapping(value="user")
public class UserControllerUploadAJax {
	@Autowired
	private UserServiceUpload userServiceUpload;
	
	@GetMapping(value="uploadForm_AJax")
	public String uploadForm_AJax() {
		return "/user/uploadForm_AJax";
	}
	
	//-------------------------한 번에 여러개의 파일을 선택-------------------------
		@PostMapping(value="upload_AJax", produces = "text/html; charset=UTF-8")
		@ResponseBody
		public String upload(@ModelAttribute UserImageDTO userImageDTO, @RequestParam("img[]") List<MultipartFile> list, HttpSession session) {
			
			// 가상폴더
			String filePath_lier = "D:/bitcamp/Spring/workspace/chapter06_web/src/main/webapp/WEB-INF/storage"; // 혹은 filePathLier
			
			// 실제폴더
			String filePath = session.getServletContext().getRealPath("/WEB-INF/storage"); // 실제 폴더 경로 찍기 위함
			System.out.println("실제폴더 = " + filePath);
			// 실제폴더 = D:\bitcamp\Spring\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\chapter06_web\WEB-INF\storage
			
			String fileName; // 파일 이름 변수 선언
			File file; // 파일 객체 생성
			String result = ""; // 결과값 출력
			
			// 파일명만 모와서 DB로 보내기
			List<String> fileNameList = new ArrayList<String>(); // 파일명은 문자로 올테니까
			
			for(MultipartFile img : list ) { // for문 돌려서 list에서 계속 빼서 MultipartFile에 담는다
				fileName = img.getOriginalFilename();
				file = new File(filePath, fileName); // 실제 파일 경로로 올리기
				
				fileNameList.add(fileName);
				
				try {
					img.transferTo(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				result += "<span><img src='/chapter06_web/storage/" + fileName+ "' width='100' height='100'></span>";
			}//for
			
			// DB
			userServiceUpload.upload(userImageDTO, fileNameList); // DTO와 File을 따로 별도로 집어넣기 (같이 넣으면 DTO에 파일 개수마다 생성해야함)
			
			return result;
		}
}
