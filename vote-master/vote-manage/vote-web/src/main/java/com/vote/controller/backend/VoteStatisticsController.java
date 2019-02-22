package com.vote.controller.backend;

import com.vote.controller.base.BaseController;
import com.vote.pojo.User;
import com.vote.pojo.Vote;
import com.vote.service.backend.VoteStatisticsService;
import com.vote.util.Const;
import com.vote.util.PageData;
import com.vote.util.VoteSingleAction;
import com.vote.util.enums.ResponseCode;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class VoteStatisticsController extends BaseController{

    @Autowired
    private VoteStatisticsService voteStatisticsService;

    @RequestMapping(value = "getBollotJSON.do",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getBollotJSON(@Param("name") String name){
        Map<String,Object> result = new HashMap<>();
        PageData pageData = voteStatisticsService.getBollotJSON(name);
        result.put("pd",pageData);
        return result;
    }
    @RequestMapping("show.do")
    public ModelAndView show(){
        ModelAndView mv = this.getModelAndView();
        String name = request.getParameter("name");
        mv.setViewName("/jsp/a/show");
        mv.addObject("name",name);
        return mv;
    }

    @RequestMapping(value = "getlist.do")
    @ResponseBody
    public List<Vote> getList(){
        List list = new ArrayList();
        User user = (User) session.getAttribute("user");
        list = voteStatisticsService.getVote(user.getId());
        System.out.println(list);
        return list;
    }

    @RequestMapping("vote.do")
    public ModelAndView vote(){
        ModelAndView mv = this.getModelAndView();
        String name = request.getParameter("name");
        PageData pageData = voteStatisticsService.getBollotJSON(name);
        mv.addObject("pd",pageData);
        mv.setViewName("vote");
        return mv;
    }

    @RequestMapping(value = "doVote.do",method = RequestMethod.POST)
    public ModelAndView doVote(){
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        System.out.println(pd);
        if (isVote(pd.getString("cip"),pd.getString("cname"),pd.getString("vote"))){
            ResponseCode rcode= voteStatisticsService.doVote(pd);
            if (rcode == ResponseCode.成功){
                mv.setViewName("success");
            }else{
                mv.setViewName("faile");
            }
        }else{
            mv.setViewName("hasVote");
        }
        return mv;
    }
    public boolean isVote(String ip,String city,String voteid){
        ServletContext sc = request.getSession().getServletContext();
        VoteSingleAction vsa = (VoteSingleAction) sc.getAttribute(voteid);
        if (vsa == null) {
            vsa = VoteSingleAction.getCleanVoteSingleAction();
        }
        if (vsa.put(city,ip)){
            sc.setAttribute(voteid,vsa);
            return true;
        }else{
            sc.setAttribute(voteid,vsa);
            return false;
        }
    }
    //    @Param("url")String url
    @RequestMapping(value = "createEWM.do")
    public void createEWM(){
//        String url = "http://10.12.26.49:8080/jsp/a/show.jsp";
//        String url = "http://10.12.26.49:8080/vote.do?name=1";
        String url = request.getParameter("url");
        url = "http://www.henusyl.cn/" +url;
        System.out.println(url + " ---");
        ByteArrayOutputStream out= QRCode.from(url).to(ImageType.PNG).stream();
        response.reset();
        response.setContentType("image/png");
        response.setContentLength(out.size());
        try {
            OutputStream os = response.getOutputStream();
            BufferedOutputStream bout = new BufferedOutputStream(os);
            bout.write(out.toByteArray());
            bout.close();
            os.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
