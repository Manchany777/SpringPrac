package user.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import user.bean.UserImageDTO;

public interface UserService {
	public void upload(List<UserImageDTO> userImageList);

	public List<UserImageDTO> getUploadList();

	public void deleteList(int seq);

	public UserImageDTO getImageFileName(int seq);

	public void update(UserImageDTO dto);

	//public void update(UserImageDTO userImageDTO, MultipartFile imgFile, HttpSession session);

}
