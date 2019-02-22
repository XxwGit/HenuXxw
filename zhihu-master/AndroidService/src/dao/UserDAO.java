package dao;

import java.sql.Date;
import java.util.List;

import bean.User;


public interface UserDAO {
	
	public List<User> getUsers();
	public  List<User> getUsers(int pageNo,int pageSize);
	

	
	public boolean deleteUserById(int categoryId);
	
	
	public boolean deleteUserById(int[] idArray);
	
	public boolean updateUser(User p);
	
	public boolean isUser(User u);
	
	public boolean addUser(User p);
	
	public int getUsers(List<User> products, int pageNo, int pageSize);
	

	
}
