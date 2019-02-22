package com.vote.filter;

import com.vote.pojo.User;
import com.vote.util.Const;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginFilter implements Filter{
    private List<String> list= new ArrayList();
    private String url = "Login.jsp";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        list.add("/Result.jsp");
        list.add("/user/Vote.jsp");
        list.add("/user/VoteItem.jsp");
        list.add("/Quit.jsp");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Const.USER);
        String path = request.getServletPath();
        System.out.println(path + " pppppppppppppppp");
        if (url.contains(path) || path.contains(url)){
            if (user != null){
                response.sendRedirect("Result.jsp");
                return;
            }
            chain.doFilter(servletRequest,servletResponse);
            return;
        }
        if (list.contains(path)){
            if (user != null){
                chain.doFilter(servletRequest,servletResponse);
            }else{
                response.sendRedirect( "/");
                return;
            }
        }else{
            chain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
