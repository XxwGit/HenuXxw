package com.henu.zhihu.utils;

import bean.MyData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 随大大 on 2017/5/20.
 */

public class Data {
    public static List<MyData> list = new ArrayList<>();

    public static List<MyData> getList(){
        for (int i = 0 ;i <10;i++){
            MyData r = new MyData();
            r.setFrom("测试数据");
            r.setTitle("来自android的测试");
            r.setContent("这是一条测试数据，为了换行我写多点，写点什么呢？这是一条测试数据，为了换行我写多点，写点什么呢？这是一条测试数据，为了换行我写多点，写点什么呢？");
            list.add(r);
        }
        return list;
    }
}
