package com.vote.service.backend;

import com.vote.pojo.Vote;
import com.vote.util.PageData;
import com.vote.util.enums.ResponseCode;

import java.util.List;

public interface VoteStatisticsService {
    PageData getBollotJSON(String name);

    ResponseCode doVote(PageData pageData);

    boolean isVote(PageData pageData);

    List<Vote> getVote(Integer id);
}
