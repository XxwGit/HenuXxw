package com.vote.dao;

import com.vote.pojo.Vote;

public interface VoteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Vote record);

    int insertSelective(Vote record);

    Vote selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Vote record);

    int updateByPrimaryKeyWithBLOBs(Vote record);

    int updateByPrimaryKey(Vote record);

    int selectVoteIdByName(String string);
}