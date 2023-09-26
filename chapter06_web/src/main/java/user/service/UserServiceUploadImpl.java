package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserImageDTO;
import user.dao.UserDAOUpload;

@Service
public class UserServiceUploadImpl implements UserServiceUpload {
	@Autowired
	private UserDAOUpload userDAOUpload;
	
	public void upload(UserImageDTO userImageDTO, List<String> fileNameList) {
		userDAOUpload.upload(userImageDTO,fileNameList);
	}
	
	@Override
	public List<UserImageDTO> getUpload_list_AJax() {
		// TODO Auto-generated method stub
		return userDAOUpload.getUpload_list_AJax();
	}
}