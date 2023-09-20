package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.dao.UserDAO;

@Service // @Component보단 이렇게 서비스하는 클래스라는 걸 명시적으로 지정하는 게 낫다
public class UserServiceImpl implements UserService {
	@Autowired // UserDAO와 의존관계 형성
	private UserDAO userDAO;
	
	@Override
	public String write(String id) {
		// DB
		return null;
	}

}