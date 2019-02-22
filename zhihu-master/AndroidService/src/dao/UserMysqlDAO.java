package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




import util.DB;
import bean.User;

public class UserMysqlDAO implements UserDAO {

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		Connection conn = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		try {
			conn = DB.getConnection();
			String sql = "select * from user";
			rs = DB.executeQuery(conn, sql);
			while(rs.next()){
				User u = new User();
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			DB.close(rs);
			DB.close(conn);
		}
		return list;
	}
	

	@Override
	public List<User> getUsers(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUserById(int categoryId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUserById(int[] idArray) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(User p) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConnection();
			String sql = "insert into user values (null,?,?)";
			pstmt = DB.getPreparedStatement(conn, sql);
			pstmt.setInt(1, p.getUserName());
			pstmt.setInt(2, p.getPassWord());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}finally{
			DB.close(pstmt);
			DB.close(conn);
		}
		
		return true;
	}

	@Override
	public int getUsers(List<User> products, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isUser(User u) {
		// TODO Auto-generated method stub
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from user where userName = " +u.getUserName()
				+ " and passWord = " + u.getPassWord();
		try {
			conn = DB.getConnection();
			rs = DB.executeQuery(conn, sql);
			while(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DB.close(rs);
			DB.close(conn);
		}
		
		
		return false;
		
	}


}
