package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import lombok.Setter;
import user.bean.UserDTO;

// 1번
/*
public class UserDAOImpl implements UserDAO {
	// DB와 연결하는 과정을 대신 해주는 탬플릿 메소드(spring framework의 jdbc에 있다)
	@Setter  //setter로 인젝션
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void write(UserDTO userDTO) {
		String sql = "insert into usertable values(?,?,?)"; // myBatis에서는 이게 xml로 빠진다.
		jdbcTemplate.update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd()); // 스프링에서 jdbc는 insert라는 함수가 없고 Update를 쓴다.
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		
		// query(String sql, RowMapper <T> rowMapper);
		// => RowMapper <T> rowMapper - row(열) 한 줄씩 꺼내주는 인터페이스 - 구현체 필요 (jdbc에서 rs.next()로 일일이 꺼내주던 작업을 대신해줌)
		//                            - 조건 : db의 컬럼명과 DTO의 필드명이 일치해야 한다.
		// 구현체 - 무슨 클래소 구현할지는 사람마다 조금씩 다르다. (강사님은 BeanPropertyRowMapper 클래스를 사용)
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserDTO.class)); 
		// 디비에서 꺼내서 DTO 클래스와 연동을 해라라고 선언(new BeanPropertyRowMapper<>(UserDTO.class) 후 리스트로 꺼내라고 선언(return jdbcTemplate.query)
	}
}*/


// 2번 - JdbcDaoSupport 사용
/*
// 주의) implements와 extends는 반드시 extend가 먼저 나와야 한다.
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {
	// JdbcDaoSupport가 private JdbcTemplate jdbcTemplate;을 대신함
	// 이제 jdbcTemplate 템플릿 및 bean을 선언했던 applicationContext.xml의 <property name="jdbcTemplate" ref="jdbcTemplate"></property>도 제거가능
	
	@Override
	public void write(UserDTO userDTO) {
		String sql = "insert into usertable values(?,?,?)";
		getJdbcTemplate().update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd()); // getJdbcTemplate() - JdbcDaoSupport가 제공하는 메소드
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<>(UserDTO.class)); 
			// 디비에서 꺼내서 DTO 클래스와 연동을 해라라고 선언 후 리스트로 꺼내라고 선언
	}
}*/

// 3번 - NamedParameterJdbcDaoSupport 사용
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	@Override
	public void write(UserDTO userDTO) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pdw", userDTO.getPwd());
		
		// NamedParameterJdbcDaoSupport는 ?에 직접 컬럼명 입력 가능
		String sql = "insert into usertable values(:name, :id, :pwd)";
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		// NamedParameterJdbcDaoSupport의 부모가 JdbcTemplate이기때문에 이대로 사용해도 문제x
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<>(UserDTO.class)); 
			// 디비에서 꺼내서 DTO 클래스와 연동을 해라라고 선언 후 리스트로 꺼내라고 선언
	}
	
	@Override
	public UserDTO getUser(String id) {
		String sql = "select * from usertable where id=?";
		try {			
			return getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class), id); 
			// queryForObject : 한 사람 분량의 데이터 꺼내올 때 사용 (마지막 인자값에 id="?"에 해당하는 컬럼명을 적어줘야함
		} catch(EmptyResultDataAccessException e) {
			// 해당 에러가 나면 에러메시지를 찍지 말고 null을 리턴하게 함 (EmptyResultDataAccessException : 해당 입력값이 없을 때 나는 에러)
			return null;
		}
	}

	@Override
	public void update(Map<String, String> map) {
		String sql = "update usertable set name=:name, pwd=:pwd where id=:id";
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public void delete(String id) {
		String sql = "delete from usertable where id=:id";
		getJdbcTemplate().update(sql, id);
	}
}
