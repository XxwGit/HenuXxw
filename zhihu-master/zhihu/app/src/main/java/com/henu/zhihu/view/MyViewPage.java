package com.henu.zhihu.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by 随大大 on 2017/4/3.
 */

/*
        重写ViewPage的原因：设置一个boolean值使得可以自行更改ViewPage是否有滑动切换的效果
 */
public class MyViewPage extends ViewPager{
    /**是否禁止左右滑动，true为禁止，false为不禁止*/
    private boolean noScroll = true;

    public MyViewPage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewPage(Context context) {
        super(context);
    }

    public void setNoScroll(boolean noScroll) {
        this.noScroll = noScroll;
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        if (noScroll)
            return false;
        else
            return super.onTouchEvent(arg0);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (noScroll)
            return false;
        else
            return super.onInterceptTouchEvent(arg0);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
    }


}