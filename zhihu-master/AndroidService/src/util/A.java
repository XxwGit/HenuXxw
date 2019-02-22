package util;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import bean.MyData;
import bean.User;


public class A {
	 private static final String BASIC_URL_QUEST =  
	          "http://localhost:8080/AndroidService/getData?start=1&size=10";  

	 public static void main(String[] args) {
		get();
	}
	 public static void get(){
	      //用于servlet判别请求，执行相应方法  
	      String check = "check_regist";  
	      //模拟发送自定义类型的List数据  
	      URL url = null;
	      URLConnection con = null;
	      HttpURLConnection httpUrlConnection = null; 
	      InputStream inStrm = null;
	      ObjectInputStream ois = null;
	      OutputStream oStrm  = null;
	      List<MyData> datas = new ArrayList<MyData>();
	      try  
	      {  
	    	  url = new URL(BASIC_URL_QUEST);
	          con = url.openConnection();  
	          httpUrlConnection = (HttpURLConnection) con;  
	          httpUrlConnection.setUseCaches(false);  
	          httpUrlConnection.setDoOutput(true);  
	          httpUrlConnection.setDoInput(true);  
	          httpUrlConnection.setRequestProperty("Content-type",  
	                  "application/x-java-serialized-object");  
	          //不设置这个默认为Get,服务器会没反应，不知道什么情况，  
	          //纠结了很久，改成Post的话,servlet里的  
	          //doPost方法就有反应了  
	          httpUrlConnection.setRequestMethod("POST");  
	          httpUrlConnection.connect();  
	          inStrm = httpUrlConnection.getInputStream();  
	          ois = new ObjectInputStream(inStrm);  
	          //输出流第一段数据是QuestId的值  
	          check = (String) ois.readObject();  
	          //System.out.println(check);
	          //第二段数据是List数据  
	          datas = (List<MyData>) ois.readObject();
	    
	         for (MyData myData : datas) {
				System.out.println("---------"+myData.getCid() + "===" + myData.getTitle());
			}
	          inStrm = httpUrlConnection.getInputStream();  
	      }  

	      catch (Exception e)  
	      {  
	          e.printStackTrace();  
	      }  finally{
	    	
	      }

	 }
	 
	 
	 
	  /** 
	   * 上传处理结果 
	   *  
	   * @throws IOException 
	   *  
	   */  
	  public static void sendDataToServer(int userName,int passWord) 
	  {  
	      //用于servlet判别请求，执行相应方法  
	      String check = "check_regist";  
	      //模拟发送自定义类型的List数据  
	      User user = new User(userName,passWord);
	      URL url = null;
	      URLConnection con = null;
	      HttpURLConnection httpUrlConnection = null; 
	      OutputStream outStrm = null;
	      ObjectOutputStream oos = null;
	      InputStream inStrm  = null;
	      try  
	      {  
	    	  url = new URL(BASIC_URL_QUEST);
	          con = url.openConnection();  
	          httpUrlConnection = (HttpURLConnection) con;  
	          httpUrlConnection.setUseCaches(false);  
	          httpUrlConnection.setDoOutput(true);  
	          httpUrlConnection.setDoInput(true);  
	          httpUrlConnection.setRequestProperty("Content-type",  
	                  "application/x-java-serialized-object");  
	          //不设置这个默认为Get,服务器会没反应，不知道什么情况，  
	          //纠结了很久，改成Post的话,servlet里的  
	          //doPost方法就有反应了  
	          httpUrlConnection.setRequestMethod("POST");  
	          httpUrlConnection.connect();  
	          outStrm = httpUrlConnection.getOutputStream();  
	          oos = new ObjectOutputStream(outStrm);  
	          //输出流第一段数据是QuestId的值  
	          oos.writeObject(check);  
	          //第二段数据是List数据  
	          oos.writeObject(user);      
	          oos.flush();  
	          oos.close();  
	          inStrm = httpUrlConnection.getInputStream();  
	      }  

	      catch (Exception e)  
	      {  
	          e.printStackTrace();  
	      }  finally{
	    	  try {
				inStrm.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      }
	  }  
}
