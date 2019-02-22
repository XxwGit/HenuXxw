package bean;

import java.io.Serializable;

public class User implements Serializable {
 
	public User(){}
	public User(int userName,int passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}
	
	
	private int userName;
	private int passWord;
	public int getUserName() {
		return userName;
	}
	public void setUserName(int userName) {
		this.userName = userName;
	}
	public int getPassWord() {
		return passWord;
	}
	public void setPassWord(int passWord) {
		this.passWord = passWord;
	}
	
}
