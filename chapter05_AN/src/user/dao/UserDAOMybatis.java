package user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import user.bean.UserDTO;

@Component
@Transactional // 하나씩 지정하기 귀찮으면 이렇게 해도 됨
public class UserDAOMybatis implements UserDAO {

	
	/* applicationContext.xml에서 SqlSessionFactory설정을 해줬기때문에 여기선 필요x */
	
	//@Transactional // commit, close까지 자동으로 해줌(xml에서 설정해준 것을 어노테이션으로 선언함)
	@Override
	public void write(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); // 생성 (SqlSession는 인터페이스이므로 직접 new가 불가능)
		sqlSession.insert("userSQL.write", userDTO); // (namespace.mapperId, 자료형)
		sqlSession.commit();
		sqlSession.close();
		
		//sqlSession.insert("userSQL.write", userDTO);
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
