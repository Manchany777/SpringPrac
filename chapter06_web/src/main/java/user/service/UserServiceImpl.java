package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service // @Component보단 이렇게 서비스하는 클래스라는 걸 명시적으로 지정하는 게 낫다
public class UserServiceImpl implements UserService {
	@Autowired // UserDAO와 의존관계 형성
	private UserDAO userDAO;
	
	@Override
	public String isExistId(String id) {
		// DB
		UserDTO userDTO = userDAO.isExistId(id);
		// DTO는 true, false값을 주고받을 수 없으므로 이런식으로 로직을 짠다.
		if(userDTO == null)
			return "non_exist";
		else
			return "exist";
	}
	
	@Override
	public void write(UserDTO userDTO) {
		// DB
		userDAO.write(userDTO);

	}
}