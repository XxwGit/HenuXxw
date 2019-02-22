package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DataManager;
import bean.MyData;
import bean.User;

public class SendServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		    response.setContentType("text/html");  
		    response.setCharacterEncoding("utf-8");
		    int start = Integer.parseInt(request.getParameter("start"));
		    int size = Integer.parseInt(request.getParameter("size"));
		    
		    
	        OutputStream out = response.getOutputStream();  
	        ObjectOutputStream obOs = new ObjectOutputStream(out);  
	        obOs.writeObject("SUCCESS");
	        
	        List<MyData> datas = DataManager.getInstance().getDatas(start,size);
	        obOs.writeObject(datas);
	        obOs.flush();
	        obOs.close();
	        out.close();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
