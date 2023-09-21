package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		// String타입으로 구성된 DTO는 true, false값을 주고받을 수 없으므로 이런식으로 로직을 짠다.
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

	@Override
	public List<UserDTO> getUserList(String pg) {
		// 1페이지당 3개씩
		int endNum = Integer.parseInt(pg)*3;
		int startNum = endNum-2;
		
		// myBatis는 하나씩밖에 못실어가기때문에 map을 ㅗ보내야함
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		// DB
		// userDAO.getUserList(startNum, endNum); (x)
		List<UserDTO> list = userDAO.getUserList(map);
		// DB에서 받아온걸 list로 담아오도록 설정
		System.out.println(list); // 콘솔창에 list값 제대로 출력되는지 확인
		
		return null;
	}
}