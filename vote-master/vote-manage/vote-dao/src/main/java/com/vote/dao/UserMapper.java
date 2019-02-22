package com.vote.dao;

import com.vote.pojo.User;
import com.vote.util.PageData;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUserId(PageData pd);

    User selectLogin(PageData pd);
}