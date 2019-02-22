package com.vote.controller.admin;

import com.github.pagehelper.PageInfo;
import com.vote.controller.base.BaseController;
import com.vote.pojo.User;
import com.vote.pojo.VoteItem;
import com.vote.service.backend.AdminService;
import com.vote.util.Const;
import com.vote.util.PageData;
import com.vote.util.enums.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user/")
public class LoginController extends BaseController{

    @Autowired
    private AdminService adminService;

    private ResultSet resultSet = null;
    @RequestMapping(value = "login.do" , method = RequestMethod.POST)
    public String login(){
        PageData pd = this.getPageData();
        PageData pageData = null;
        try{
           pageData=adminService.login(pd);
            System.out.print(pageData);
            System.out.print(pageData.getInt(Const.CODE));
            if (pageData.getInt(Const.CODE) == ResponseCode.成功.getCode()){
                User user = (User) pageData.get("user");
                session.setAttribute("userName",pageData.get("username"));
                session.setAttribute("user",user);
                System.out.print(pageData.get("username"));
                System.out.print("登录成功");
                return "/user/Vote";
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.toString());
        }
        return "redirect:/";
    }

    @RequestMapping(value = "newUser.do" ,method = RequestMethod.POST)

    public String newUser(){

        Map<String,Object> result = new HashMap<>();

        System.out.println("注册用户");
        PageData pd = this.getPageData();
        System.out.println(pd);
        PageData pageData =null;
        try {
            System.out.println("注册用户");
            pageData = adminService.newUser(pd);
            System.out.println("注册用户");
            result.putAll(pageData);
            System.out.println("注册成功");
            return "../Login";
        } catch (Exception e) {
            logger.error(e.toString());
            result.put(Const.CODE, ResponseCode.异常.getCode());
        }
        return "redirect:/";
    }

    @RequestMapping(value = "createVote.do",method = RequestMethod.POST)
    public String vote(){

        Map<String,Object> result = new HashMap<>();
        String a = (String) session.getAttribute("userName");
        User user = (User) session.getAttribute("user");
        PageData pd = this.getPageData();
        pd.put("userid",user.getId());
        System.out.println(pd);
        System.out.println("投票名称"+pd.get("voteName"));
        ResponseCode code = null;
        try{
            code = adminService.createVote(pd);
            System.out.println("提交成功");
            session.setAttribute("votename" ,pd.get("voteName"));
            return "VoteItem";
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.toString());
            result.put(Const.CODE,ResponseCode.异常.getCode());
        }
        /*result.put(Const.CODE,code.getCode());*/
        return "../redicted/";
    }
    @RequestMapping(value = "InsertVoteItemBefore.do")
    public ModelAndView InsertVoteItemBefore(){
        ModelAndView mv = this.getModelAndView();
        try{
            System.out.println("选项列表");
            String string = (String) session.getAttribute("votename");
            System.out.println("投票名称"+string);
            int voteid = adminService.selectVoteId(string);
            System.out.println("投票id"+voteid);
            List<VoteItem> list = adminService.voteItemBefore(voteid);
            System.out.println("选项列表"+list);
            for (VoteItem voteitem :list
                 ) {
                System.out.println(voteitem);
            }
            mv.addObject("list",list);
            PageInfo<VoteItem> pageInfo = new PageInfo<>(list);
        }catch (Exception e){
            mv.addObject(Const.CODE,ResponseCode.错误.getCode());
            logger.error(e.toString());
        }
        mv.setViewName("VoteItem");
        return mv;
    }
    @RequestMapping(value = "newvoteItem.do",method = RequestMethod.POST)
    public Map<String,Object> newVoteItem(){

        Map<String,Object> result = new HashMap<>();
        User user = (User)session.getAttribute(Const.USER);
        PageData pd = this.getPageData();
        String string = (String) session.getAttribute("votename");
        System.out.println("投票名称"+string);
        int voteid = adminService.selectVoteId(string);
        System.out.println("投票id"+voteid);
        pd.put("voteid",voteid);
        ResponseCode code = null;
        try{
            code = adminService.createVoteItem(pd);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.toString());
            result.put(Const.CODE,ResponseCode.异常.getCode());
        }
        result.put(Const.CODE,code.getCode());
        return result;
    }


    @RequestMapping(value = "quit.do",method = RequestMethod.GET)
    public void quit(){

        User user = (User) session.getAttribute(Const.USER);
        session.removeAttribute(Const.USER);
        try {
            response.sendRedirect("Vote.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
