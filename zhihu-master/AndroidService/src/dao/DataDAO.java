package dao;

import java.util.List;

import bean.MyData;

public interface DataDAO {

	List<MyData> getDatas();
	List<MyData> getDatas(int start,int size);
	public boolean deleteDatarById(int dataId);
	
	
	public boolean deleteDataById(int[] idArray);
	
	public boolean updateData(MyData d);
	
	public boolean isData(MyData d);
	
	public boolean addData(MyData d);
}
