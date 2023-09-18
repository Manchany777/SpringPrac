package user.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.Setter;
import user.bean.UserDTO;

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
		// 구현체 무슨 클래소 구현할지는 사람마다 조금씩 다르다. (강사님은 BeanPropertyRowMapper 클래스를 사용)
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserDTO.class)); 
		// 디비에서 꺼내서 DTO 클래스와 연동을 해라라고 선언 후 리스트에서 꺼내라고 선언
	}
}
