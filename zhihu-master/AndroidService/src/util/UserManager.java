package util;

import java.sql.Date;
import java.util.List;


import dao.UserDAO;
import dao.UserMysqlDAO;
import bean.User;

public class UserManager {
	
	private UserDAO dao = null;
	private static UserManager um = null;
	private UserManager(){}
	static{
		
		if (um == null) {
			um = new UserManager();
			um.setUserDAO(new UserMysqlDAO());
		}
	}
	
	public static UserManager getInstance(){
		return um;
	}
	
	public void setUserDAO(UserDAO dao){
		this.dao = dao;
	}
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return dao.getUsers();
	}

	public List<User> getUsers(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean deleteUserById(int categoryId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUserById(int[] idArray) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateUser(User p) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addUser(User p) {
		// TODO Auto-generated method stub
		return dao.addUser(p);
	}

	public int getUsers(List<User> products, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean isUser(User u) {
		// TODO Auto-generated method stub
		return dao.isUser(u);
	}

}
