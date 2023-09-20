package user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import user.bean.UserDTO;

@Repository // DB와 연동을 위한 클래스임을 선언
public class UserDAOMybatis implements UserDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public UserDTO isExistId(String id) {
		return sqlSession.selectOne("userSQL.isExistId", id); // 아이디 중복조회는 한 사람 분량의 데이터이므로 selectOne
		//return sqlSession.selectOne("userSQL.getUser", id);  //  userMapper.xml에서 sql문을 처리하고 값을 반환 (userSQL.getUser로 바꿔도 된다. 하는 역할이 똑같으므로)
	}

	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
	}
}
