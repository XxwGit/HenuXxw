package com.vote.service.backend;

import com.vote.pojo.VoteItem;
import com.vote.util.PageData;
import com.vote.util.enums.ResponseCode;

import java.util.List;

public interface AdminService {
    PageData login(PageData pd);

    ResponseCode createVote(PageData pd);

    PageData newUser(PageData pd);

    ResponseCode createVoteItem(PageData pd);

    int selectVoteId(String string);

    List<VoteItem> voteItemBefore(int voteid);
}
