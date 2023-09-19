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
public class UserUpdateService implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("수정할 아이디 입력 : ");
		String id = scan.next();
		
		// DB
		// UserDAO userDAO = new UserDAOImpl(); => 이걸 bean단에서 만든거다. 혼동하지 말자
		UserDTO userDTO = userDAO.getUser(id);
		if(userDTO == null) {
			System.out.println("찾고자 하는 이름이 없습니다.");
			return;
		}
		
		System.out.println(userDTO);
		
		System.out.print("수정 할 이름 입력 : ");
		String name = scan.next();
		System.out.print("수정 할 비밀번호 입력 : ");
		String pwd = scan.next();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("id", id);
		map.put("pwd", pwd);
		
		userDAO.update(map);
		
		System.out.println(id + "님의 데이터를 수정 하였습니다");
		System.out.println();
	}
}

/* 
   수정 할 아이디를 입력 : angel
   찾고자 하는 아이디가 없습니다.
  
   수정 할 아이디를 입력 : hong
   홍길동    hong    111
  
   수정 할 이름 입력 : 홍당무
   수정 할 비밀번호 입력 : 333
  
   hong님의 데이터를 수정하였습니다.
 */