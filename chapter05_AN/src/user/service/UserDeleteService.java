package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Component
public class UserDeleteService implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("삭제할 아이디 입력 : ");
		String id = scan.next();
		
		// DB
		// UserDAO userDAO = new UserDAOImpl(); => 이걸 bean단에서 만든거다. 혼동하지 말자
		UserDTO userDTO = userDAO.getUser(id);
		if(userDTO == null) {
			System.out.println("찾고자 하는 이름이 없습니다.");
			return;
		}
		
		userDAO.delete(id);
		
		System.out.println(id + "님의 데이터를 삭제 하였습니다");

	}

}
