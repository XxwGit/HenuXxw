package com.vote.dao;

import com.vote.pojo.Vote;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface VoteStatisticsMapper {

    @Select("select * from vote where name = #{name} and enable = 1")
    @ResultType(Vote.class)
    Vote selectVoteBy(String name);

    @Update({"update vote_item set ballot = ballot +1,modifyTime = now() where id = #{id}"})
    @ResultType(int.class)
    int upDateBoallot(int id);

    @Select("select count(*) from log_vote where vote = #{vote} and ip = #{ip}")
    @ResultType(int.class)
    int selectHaveLogin(@Param("vote") Integer vote, @Param("ip") String ip);

    @Select("select * from vote where ecreator = #{id}")
    @ResultType(Vote.class)
    List<Vote> selectVotes(Integer id);
}
