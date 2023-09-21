package user.service;

import java.util.List;

import user.bean.UserDTO;

public interface UserService {

	public String isExistId(String id);

	public void write(UserDTO userDTO);

	public List<UserDTO> getUserList(String pg);

}
