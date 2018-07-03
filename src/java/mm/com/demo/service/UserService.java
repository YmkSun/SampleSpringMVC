package mm.com.demo.service;


import java.util.List;

import mm.com.demo.dao.UserDao;
import mm.com.demo.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
	@Autowired
    protected UserDao userDao;
    
	public List<User> getAllUserList() {
		return this.userDao.getAllUserList();
	}

	public User getUserById(int id) {
		return this.userDao.getUserById(id);
	}

	public String insert(User user) {
		return this.userDao.insert(user);
	}

	public String deleteUserById(int id) {
		return this.userDao.deleteUserById(id);
	}

	public String updateUser(User user) {
		return this.userDao.updateUser(user);
	}

}
