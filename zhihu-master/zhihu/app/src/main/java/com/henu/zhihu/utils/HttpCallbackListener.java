package com.henu.zhihu.utils;

/**
 * Created by 13111 on 2017/5/22.
 */

public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
