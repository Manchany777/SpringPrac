package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
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
		
		// myBatis는 하나씩밖에 못실어가기때문에 map을 보내야함
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		// DB
		// userDAO.getUserList(startNum, endNum); (x) - 이렇게 안 됨
		List<UserDTO> list = userDAO.getUserList(map);
		// DB에서 받아온걸 list로 담아오도록 설정
		System.out.println(list); // 콘솔창에 list값 제대로 출력되는지 확인
		
		// List객체 -> JSON 변환
		/*
		JSONObject json = new JSONObject(); // json객체 생성
		
		JSONArray array = new JSONArray();  // json객체안에 json배열 생성
		for(UserDTO userDTO : list) { 		// DTO에서 꺼내서 JSON객체에 주입하기 위해 temp Json객체 생성
			JSONObject temp = new JSONObject();
			temp.put("name", userDTO.getName()); // 각 행의 DTO를 temp JSON객체에 주입
			temp.put("id", userDTO.getId());
			temp.put("pwd", userDTO.getPwd());
			
			array.put(temp); // temp JSOn객체로 담아온 DTO정보를 json배열객체에 담기
		} //for
		
		json.put("list", array); // list란 이름으로 array값이 JSON객체로 들어감
		
		System.out.println();
		System.out.println(json); // list값이 json으로 변경되었는지 확인
		// {"list":[{"name":"최병권","id":"choi","pwd":"1111"},{~~},{~~},...]}
		*/
		
		// 페이지 처리
		
		return list;
	}
}