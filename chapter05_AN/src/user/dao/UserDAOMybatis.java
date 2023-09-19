package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;

//@Component
@Repository // DB와 관련된 클래스는 @Repository 어노테이션을 더 선호
@Transactional // 하나씩 지정하기 귀찮으면 이렇게 해도 됨
public class UserDAOMybatis implements UserDAO {
	/* applicationContext.xml에서 SqlSessionFactory설정을 해줬기때문에 여기선 필요x */
	
	private final SqlSession sqlSession;
	
	@Autowired
	public UserDAOMybatis(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO); // (namespace.mapperId, 자료형)
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
