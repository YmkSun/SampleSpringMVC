package mm.com.demo.daoimpl;

import java.util.ArrayList;
import java.util.List;

import mm.com.demo.dao.UserDao;
import mm.com.demo.entity.User;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	static List<User> userList = new ArrayList<User>();
	
	{
		userList.add(new User(1,"Liam","Sun","12/YGN(N)112445","liamsun@gmail.com","0943022115", 1001, "USR001"));
		userList.add(new User(2,"Margret","Sulan","13/PKN(N)092355","msulan@gmail.com","09976922301", 1002, "USR002"));
		userList.add(new User(3,"Dean","McChrew","9/KAZ(N)057381","dean.mc@gmail.com","09799297415", 1003, "USR003"));
		userList.add(new User(4,"Percy","Parker","8/AKN(N)087112","p.parker@gmail.com","09976293549", 1004, "USR004"));
	}

	public List<User> getAllUserList() {
		return userList;
	}

	public User getUserById(int id) {
		User user = new User();
		for(User usr : userList){
			if(usr.getId()==id){
				user = usr;
				break;
			}
		}
		return user;
	}

	public String insert(User user) {
		user.setId(getMaxId()+1);
		userList.add(user);
		return "Saved successfully";
	}
	
	private int getMaxId(){
		int maxId = 0;
		
		for(User usr : userList){
			if(usr.getId()>maxId){
				maxId = usr.getId();
			}
		}
		
		return maxId;
	}

	public String deleteUserById(int id) {
		int index = -1;
		String message = "Deleting failed!";
		for(int i=0;i<userList.size();i++){
			if(userList.get(i).getId()==id){
				index = i;
				message = "Deleted successfully";
				break;
			}
		}
		
		if(index!=-1)
			userList.remove(index);
		return message;
	}

	public String updateUser(User user) {
		int index = -1;
		String message = "Updating failed!";
		for(int i=0;i<userList.size();i++){
			if(userList.get(i).getId()==user.getId()){
				index = i;
				message = "Updated successfully";
				break;
			}
		}
		
		if(index!=-1)
			userList.set(index,user);
		return message;
	}

}
