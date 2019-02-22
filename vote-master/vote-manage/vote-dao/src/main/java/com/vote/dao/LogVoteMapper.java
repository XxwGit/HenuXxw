package com.vote.dao;

import com.vote.pojo.LogVote;

public interface LogVoteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogVote record);

    int insertSelective(LogVote record);

    LogVote selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogVote record);

    int updateByPrimaryKey(LogVote record);
}