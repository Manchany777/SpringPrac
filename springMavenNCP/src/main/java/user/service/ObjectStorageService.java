package user.service;

import org.springframework.web.multipart.MultipartFile;

import user.bean.UserImageDTO;

public interface ObjectStorageService {
	
	public String uploadFile(String bucketName, String string, MultipartFile img);

	public void deleteList(String bucketName, String imageFileName);
}
