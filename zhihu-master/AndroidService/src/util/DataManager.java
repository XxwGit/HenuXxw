package util;

import java.util.List;

import bean.MyData;
import dao.DataDAO;
import dao.DataMySqlDAO;

public class DataManager {
	private static DataManager dm = null;
	private DataDAO dao = null;
	private DataManager(){}
	
	public static DataManager getInstance(){
		return dm;
	}
	static{
	
		if(dm == null){
			dm = new DataManager();
			dm.setDataDao(new DataMySqlDAO());
			System.out.println("创建");
		}
	}
	private void setDataDao(DataDAO dao){
		this.dao = dao;
	}
	public List<MyData> getDatas(){
		return dao.getDatas();
	}
	public List<MyData> getDatas(int start,int size){
		return dao.getDatas(start, size);
	}
	
	public boolean deleteDataById(int[] idArray){
		return dao.deleteDataById(idArray);
	}
	
	public boolean updateData(MyData d){
		return dao.addData(d);
	}
	
	public boolean isData(MyData d){
		return dao.isData(d);
	}
	
	public boolean addData(MyData d){
		return dao.addData(d);
	}
}
