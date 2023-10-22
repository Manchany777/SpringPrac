package user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import user.bean.UserImageDTO;

@Mapper
public interface UserDAO {
	public void upload(List<UserImageDTO> userImageList);

	public List<UserImageDTO> getUploadList();

	public void deleteList(int seq);

	public UserImageDTO getImageFileName(int seq);

	public void update(UserImageDTO dto);
}