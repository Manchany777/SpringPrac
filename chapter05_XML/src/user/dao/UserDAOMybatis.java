package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import user.bean.UserDTO;

@Transactional // 하나씩 지정하기 귀찮으면 이렇게 해도 됨
public class UserDAOMybatis implements UserDAO {
	@Setter
	private SqlSession sqlSession; // mybatis-config.xml 연결을 위한 SqlSession 설정
	
	/* applicationContext.xml에서 SqlSessionFactory설정을 해줬기때문에 여기선 필요x */
	
	//@Transactional // commit, close까지 자동으로 해줌(xml에서 설정해준 것을 어노테이션으로 선언함)
	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
	}

	@Override
	public List<UserDTO> getUserList() {
		return sqlSession.selectList("userSQL.getUserList");
	}

	@Override
	public UserDTO getUser(String id) {
		return sqlSession.selectOne("userSQL.getUser", id);
	}

	@Override
	public void update(Map<String, String> map) {
		sqlSession.update("userSQL.update", map);
	}

	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete", id);

	}

}
