package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DB;
import bean.MyData;
import bean.User;

public class DataMySqlDAO implements DataDAO{

	@Override
	public List<MyData> getDatas() {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		ResultSet rs = null;
		List<MyData> list = new ArrayList<MyData>();
		try {
			conn = DB.getConnection();
			String sql = "select * from data";
			rs = DB.executeQuery(conn, sql);
			while(rs.next()){
				MyData d = new MyData();
				d.setCid(rs.getInt("id"));
				d.setContent(rs.getString("content"));
				d.setFrom(rs.getString("from"));
				d.setTitle(rs.getString("title"));
				list.add(d);
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
	public List<MyData> getDatas(int start, int size) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		ResultSet rs = null;
		List<MyData> list = new ArrayList<MyData>();
		try {
			conn = DB.getConnection();
			String sql = "select * from data limit " + start + ","+ size;
			System.out.println(sql);
			rs = DB.executeQuery(conn, sql);
			while(rs.next()){
				MyData d = new MyData();
				d.setCid(rs.getInt("id"));
				d.setContent(rs.getString("content"));
				d.setFrom(rs.getString("from"));
				d.setTitle(rs.getString("title"));
				list.add(d);
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
	public boolean deleteDatarById(int dataId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDataById(int[] idArray) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateData(MyData d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isData(MyData d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addData(MyData d) {
		// TODO Auto-generated method stub
		return false;
	}

}
