package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import user.bean.UserDTO;



//@Component // UserDAO를 오버라이딩한 UserDAOImpl클래스를 빈으로 등록해라
@Repository // DB와 연관된 클래스임을 명시적으로 알려주는 어노테이션 (물론 @Component써도 상관은 없다.) 
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	@Autowired // DataSource 데이터 타입을 찾아서 set으로 전달하도록 자동 매핑 설정
	public void setDS(DataSource dataSource) {
		setDataSource(dataSource); 	// JdbcDaoSupport에 있는 setDataSource(~~)를 호출
	}
	
	@Override
	public void write(UserDTO userDTO) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		
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
