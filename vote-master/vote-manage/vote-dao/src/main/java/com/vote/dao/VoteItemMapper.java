package com.vote.dao;

import com.vote.pojo.VoteItem;

import java.util.List;

public interface VoteItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VoteItem record);

    int insertSelective(VoteItem record);

    VoteItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VoteItem record);

    int updateByPrimaryKey(VoteItem record);

    List<VoteItem> selectListByVoteId(Integer voteid);

    List<VoteItem> selectListByVoteParentId(int voteid);
}