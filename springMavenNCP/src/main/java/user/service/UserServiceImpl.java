package user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserImageDTO;
import user.dao.UserDAO;

@Service
@Transactional // 메서드마다 일일이 트랜잭션 걸어도 된다.
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ObjectStorageService objectStorageService;
	
	private String bucketName = "bitcamp-edu-bucket-112";
	
	@Override
	public void upload(List<UserImageDTO> userImageList) {
		userDAO.upload(userImageList);
	}
	
	@Override
	public List<UserImageDTO> getUploadList() {
		return userDAO.getUploadList();
	}

	@Override
	public void deleteList(int seq) {
		String imageFileName = "storage/";
		imageFileName+=userDAO.getImageFileName(seq);
		
		System.out.println("UserServiceImpl : " + imageFileName);
		objectStorageService.deleteList(bucketName, imageFileName);
		
		userDAO.deleteList(seq);
	}

	@Override
	public UserImageDTO getImageFileName(int seq) {
		UserImageDTO userImageDTO = userDAO.getImageFileName(seq);
		
		userImageDTO.setSeq(seq);
		userImageDTO.setImageName(userImageDTO.getImageName());
		userImageDTO.setImageContent(userImageDTO.getImageContent());
		userImageDTO.setImageFileName(userImageDTO.getImageFileName());
		userImageDTO.setImageOriginalName(userImageDTO.getImageOriginalName());
		
		return userImageDTO;
	}
}