package com.vote.service.impl;

import com.vote.dao.LogVoteMapper;
import com.vote.dao.VoteItemMapper;
import com.vote.dao.VoteStatisticsMapper;
import com.vote.pojo.LogVote;
import com.vote.pojo.Vote;
import com.vote.pojo.VoteItem;
import com.vote.service.backend.VoteStatisticsService;
import com.vote.util.PageData;
import com.vote.util.enums.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("voteStatisticsService")
public class VoteStatisticsServiceImpl implements VoteStatisticsService {
    @Autowired
    private LogVoteMapper logVoteMapper;
    @Autowired
    private VoteItemMapper voteItemMapper;

    @Autowired
    private VoteStatisticsMapper voteStatisticsMapper;
    @Override
    public PageData getBollotJSON(String name) {
        System.out.println(name);
        PageData pageData = new PageData();
        Vote vote = voteStatisticsMapper.selectVoteBy(name);
        System.out.println(vote.getId());
        List<VoteItem> voteItemList = voteItemMapper.selectListByVoteId(vote.getId());
        System.out.println(voteItemList);
        if (vote != null && voteItemList != null){
            pageData.put("vote",vote);
            pageData.put("voteItemList",voteItemList);
            pageData.put("code", ResponseCode.成功.getCode());
        }else{
            pageData.put("code",ResponseCode.错误.getCode());
        }
        return pageData;
    }

    @Override
    public ResponseCode doVote(PageData pageData) {
        int result = voteStatisticsMapper.upDateBoallot(pageData.getInt("voteItem"));
        LogVote logVote = new LogVote();
        logVote.setName(pageData.getString("cname"));
        logVote.setIp(pageData.getString("cip"));
        logVote.setEnable(1);
        logVote.setType(0);
        logVote.setVote(pageData.getInt("vote"));
        logVote.setVoteitem(pageData.getInt("voteItem"));
        int result2 = logVoteMapper.insert(logVote);
        if (result >0 && result2 >0){
            return ResponseCode.成功;
        }
        return ResponseCode.错误;
    }

    @Override
    public boolean isVote(PageData pageData) {
        int count = voteStatisticsMapper.selectHaveLogin(pageData.getInt("vote"),pageData.getString("cip"));
        System.out.println(count + "---------");
        return count > 0 ? true : false;
    }

    @Override
    public List<Vote> getVote(Integer id) {
        List<Vote> list = new ArrayList<>();
        list = voteStatisticsMapper.selectVotes(id);
        return list;
    }
}
