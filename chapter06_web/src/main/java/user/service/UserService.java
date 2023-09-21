package user.service;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;
import user.bean.UserPaging;

public interface UserService {

	public String isExistId(String id);

	public void write(UserDTO userDTO);

	public Map<String, Object> getUserList(String pg);

	public UserDTO getUser(String id);
}
