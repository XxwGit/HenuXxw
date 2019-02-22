package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UserManager;
import bean.User;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 resp.setContentType("text/html"); 
		PrintWriter out = resp.getWriter();
		int userName = Integer.parseInt(req.getParameter("userName"));
		int passWord = Integer.parseInt(req.getParameter("passWord"));
		User user = new User(userName, passWord);
//		UserDAO u
		if (UserManager.getInstance().isUser(user)) {
			out.println("SUCCESS");
		}else {
			out.println("FAILE");
		}
		   out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
