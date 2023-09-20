package user.dao;

import user.bean.UserDTO;

public interface UserDAO {

	public UserDTO isExistId(String id);

	public void write(UserDTO userDTO);
}