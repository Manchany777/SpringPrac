package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;
import user.bean.UserImageDTO;

@Repository
@Transactional // commit & close를 위해
public class UserDAOUploadMybatis implements UserDAOUpload {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void upload(UserImageDTO userImageDTO, List<String> fileNameList) {
		for(String filename : fileNameList) {
			userImageDTO.setImage1(filename); // UserImageDTO의 img1에다 밀어넣기
			sqlSession.insert("userUploadSQL.upload", userImageDTO);
		} // for
	}

	@Override
	public List<UserImageDTO> getUpload_list_AJax() {
		return sqlSession.selectList("userUploadSQL.getUpload_list_AJax");
	}
}
