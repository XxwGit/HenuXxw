package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DB;
import bean.User;

public class CopyOfRegistServlet extends HttpServlet {
	private static final String CHECK_REGIST = "check_regist";
	private String check;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 System.out.println("________---------开始接受客户端的信息--------_____________"); 
		 try {
			getListDataByObjectInputStream(req, resp);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	/** 
     * 获取输入流中的数据 
     *  
     * @param request 
     * @param response 
     * @throws IOException 
     * @throws ClassNotFoundException 
     */  
    private void getListDataByObjectInputStream(HttpServletRequest request,  
            HttpServletResponse response) throws IOException,  
            ClassNotFoundException  
    {  
        response.setContentType("text/html");  
        InputStream inStream = request.getInputStream();  
        ObjectInputStream objInStream = new ObjectInputStream(inStream);  
        check = (String) objInStream.readObject();  
        @SuppressWarnings("unchecked")  
        User user = (User) objInStream.readObject();
        if (check.equals(CHECK_REGIST))  
        {  
            System.out.println("开始进行注册");  
            submitOrderList(request, response, user);  
        }  
        objInStream.close();  
        System.out.println("注册成功");  
    }  
    /** 
     * @param request 
     * @param response 
     * @param inList 
     */  
    private void submitOrderList(HttpServletRequest request,  
            HttpServletResponse response, User user)  
    {  
        // 获取数据，插入数据库  
            System.out.println("UserName=" + user.getUserName());  
            System.out.println("Password=" + user.getPassWord());  
        /** 
         * 插入数据库代码可以写在这.. 
         */  
        Connection connection = DB.getConnection();
        
        
    }  
}




