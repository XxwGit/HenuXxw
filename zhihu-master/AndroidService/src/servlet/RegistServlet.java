package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DB;
import util.UserManager;
import bean.User;

public class RegistServlet extends HttpServlet {
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
        PrintWriter out = response.getWriter();
        int userName = Integer.parseInt(request.getParameter("userName"));
        int passWord = Integer.parseInt(request.getParameter("passWord"));
        User p = new User(userName, passWord);
        if (UserManager.getInstance().addUser(p)) {
			out.println("SUCCESS");
		}else {
			out.println("FAILE");
		}
        out.close();
        
    }  
    /** 
     * @param request 
     * @param response 
     * @param inList 
     */  

}




