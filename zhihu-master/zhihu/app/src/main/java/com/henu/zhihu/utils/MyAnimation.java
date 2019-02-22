package com.henu.zhihu.utils;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * Created by 随大大 on 2017/5/20.
 */

public class MyAnimation {
    public static TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                                           0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                                           Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                                           1.0f);
    public static TranslateAnimation mShowAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
            Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
            1.0f, Animation.RELATIVE_TO_SELF, 0.0f);

    public static  void setDTime(){
        mHiddenAction.setDuration(500);
        mShowAction.setDuration(500);
    }
}
