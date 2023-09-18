package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

//@Component
@Service // 오로지 일을 하는 집합체임을 명시하는 어노테이션
public class UserInsertService implements UserService {
	@Autowired // 어노테이션(@Component)으로 생성된 빈들 중에서 이 타입(UserDTO)을 찾아서 자동으로 연결해라
	private UserDTO userDTO;
	@Autowired
	private UserDAO userDAO;
	
	//UserDAO userDAO = new UserDAOImpl(); (x)	
	
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
		
		System.out.println(name + "님의 데이터를 저장하였습니다.");
		}
}
