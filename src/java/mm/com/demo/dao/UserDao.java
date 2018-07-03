package mm.com.demo.dao;

import java.util.List;

import mm.com.demo.entity.User;

public interface UserDao {
	public List<User> getAllUserList();
	public User getUserById(int id);
	public String insert(User student);
	public String deleteUserById(int id);	
	public String updateUser(User student);
}
