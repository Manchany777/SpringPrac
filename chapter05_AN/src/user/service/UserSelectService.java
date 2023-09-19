package user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

//@Component
@Service
public class UserSelectService implements UserService {
	// UserDAO의 정보를 생성자를 통해 얻어올건지, setter를 통해 얻어올 건지 선택 (여기서는 Setter 선택)
	@Autowired
	private UserDAO userDAO;
	@Override
	public void execute() {
		System.out.println();
		List<UserDTO> list = userDAO.getUserList();
		
		// 데이터 타입이 UserDTO인 정보를  List로 담아라
		for(UserDTO userDTO : list) {
			System.out.println(userDTO);
		}
		System.out.println();
	}
}
