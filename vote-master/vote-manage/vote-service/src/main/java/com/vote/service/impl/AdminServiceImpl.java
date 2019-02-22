package com.vote.service.impl;

import com.vote.dao.UserMapper;
import com.vote.dao.VoteItemMapper;
import com.vote.dao.VoteMapper;
import com.vote.pojo.User;
import com.vote.pojo.Vote;
import com.vote.pojo.VoteItem;
import com.vote.service.backend.AdminService;
import com.vote.util.Const;
import com.vote.util.DateTimeUtil;
import com.vote.util.PageData;
import com.vote.util.enums.Enable;
import com.vote.util.enums.ResponseCode;
import com.vote.util.enums.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private VoteMapper voteMapper;
    @Autowired
    private VoteItemMapper voteItemMapper;
    @Override
    public PageData login(PageData pd) {
        PageData pageData = new PageData();
        int count = userMapper.checkUserId(pd);
        if (count == 0){
            pageData.put(Const.CODE, ResponseCode.错误.getCode());
            pageData.put(Const.MSG,"帐号错误");
            return pageData;
        }
        User user = userMapper.selectLogin(pd);

        if (user == null){
            pageData.put(Const.CODE, ResponseCode.错误.getCode());
            pageData.put(Const.MSG,"密码错误");
            return pageData;
        }
        pageData.put(Const.USERTYPE, UserType.管理员.getCode());
        pageData.put("user",user);
        pageData.put("username",user.getUsername());
        pageData.put(Const.CODE,ResponseCode.成功.getCode());
        return pageData;
    }

    @Override
    public ResponseCode createVote(PageData pd) {
        PageData pageData = new PageData();
        Vote vote = new Vote();
        vote.setName(pd.getString("voteName"));
        vote.setDescription(pd.getString("voteDescription"));
        vote.setStarttime(DateTimeUtil.strToDate2(pd.getString("startTime")));
        vote.setEndtime(DateTimeUtil.strToDate2(pd.getString("endTime")));
        vote.setEcreator(pd.getInt("userid"));
        vote.setEnable(Enable.可用.getCode());
        int count = voteMapper.insert(vote);
        if (count>0){
            return ResponseCode.成功;
        }
        return ResponseCode.错误;

    }

    @Override
    public PageData newUser(PageData pd) {
        PageData pageData = new PageData();
        User user = new User();
        user.setUsername(pd.getString("username"));
        user.setPassword(pd.getString("password"));
        user.setEnable(Enable.可用.getCode());
        user.setPhone(Integer.parseInt(pd.getString("telphone").trim()));
        int count = userMapper.insert(user);
        if (count>0){
            pageData.put(Const.CODE,ResponseCode.成功.getCode());
            return pageData;
        }
        pageData.put(Const.CODE,ResponseCode.错误.getCode());
        return pageData;
    }

    @Override
    public ResponseCode createVoteItem(PageData pd) {
        PageData pageData = new PageData();
        VoteItem voteItem = new VoteItem();
        voteItem.setName(pd.getString("voteItemName"));
        voteItem.setDescription(pd.getString("voteItemDescription"));
        voteItem.setEnable(Enable.可用.getCode());
        voteItem.setParent(pd.getInt("voteid"));
        voteItem.setBallot(0);
        int count = voteItemMapper.insert(voteItem);
        if (count>0){
            return ResponseCode.成功;
        }
        return ResponseCode.错误;
    }

    @Override
    public int selectVoteId(String string) {
        PageData pageData = new PageData();
        Vote vote = new Vote();
        int voteid = voteMapper.selectVoteIdByName(string);
        return voteid;
    }

    @Override
    public List<VoteItem> voteItemBefore(int voteid) {
        List<VoteItem> votes = new ArrayList<>();
        votes = voteItemMapper.selectListByVoteParentId(voteid);
        return votes;
    }


}
