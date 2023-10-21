package user.service;

import java.util.List;

import user.bean.UserImageDTO;

public interface UserService {
	public void upload(List<UserImageDTO> userImageList);

	public List<UserImageDTO> getUploadList();

	public void deleteList(int seq);

	public UserImageDTO getImageFileName(int seq);

}
