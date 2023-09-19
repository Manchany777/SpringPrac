package user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

//@Component
@Service
public class UserInsertService implements UserService {
	@Autowired
	private UserDTO userDTO;
	@Autowired // UserDAO를 상속받은 UserDAOMybatis를 찾아서 자동 연결
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("아이디 입력 : ");
		String id = scan.next();
		System.out.print("비밀번호 입력 : ");
		String pwd = scan.next();
		System.out.println();
		
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		System.out.println(userDTO);
		
		// DB 
		userDAO.write(userDTO);
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		
		System.out.println(name + "님의 데이터를 저장하였습니다.");
		System.out.println();
		}
}
