package com.henu.zhihu.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.henu.zhihu.R;


/**
 * Created by 随大大 on 2017/4/3.
 */

public class TabBarView extends LinearLayout{

    public static LinearLayout l ;
    /**
     * 获取tabBarItem的对象
     */
    private TabBarItemView[] items;
    /**
     * 设置  tabBarItem 的监听事件
     */
    private OnTabBarItemSelectedListener onTabBarItemSelectedListener;
    /**
     * 构造器初始化各种参数
     * @param context
     * @param attrs
     */
    public TabBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_tab_bar,this,true);
        l = (LinearLayout) findViewById(R.id.l);
        items = new TabBarItemView[5];
        items[0] = (TabBarItemView)findViewById(R.id.tb_item_one);
        items[1] = (TabBarItemView)findViewById(R.id.tb_item_two);
        items[2] = (TabBarItemView) findViewById(R.id.tb_item_three);
        items[3] = (TabBarItemView)findViewById(R.id.tb_item_four);
        items[4] = (TabBarItemView) findViewById(R.id.tb_item_five);
        init();
        setSelected(0);
    }

    public TabBarView(Context context) {
        super(context);
    }

    /**
     * 对tabBarItem进行事件的绑定
     */
    private void init() {
        for (int i=0;i<items.length;i++){
            final int finalI = i;
            items[i].setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onTabBarItemSelectedListener!=null){
                        onTabBarItemSelectedListener.onTabBarItemSelected(finalI);
                    }
                }
            });
        }
    }

    /**
     * 为每个tabBarItem传入图片的资源ID
     * @param selectedResIds
     * @param unSelectedResIds
     */
    public void setTabBarItemImageRescoure(int[] selectedResIds,int[] unSelectedResIds){
        if (selectedResIds.length<5||unSelectedResIds.length<5){
            try {
                throw new Exception("资源缺少");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for(int i=0;i<items.length;i++){
            items[i].setImageResource(selectedResIds[i],unSelectedResIds[i]);
        }
    }

    /**
     * 设置选中的tabBarItem 同时更改其他的tabBarItem状态
     * @param index
     */
    public void setSelected(int index){
        for(int i=0;i<items.length;i++){
            if (i!=index)
                items[i].unSelected();
        }
        items[index].setSelected();
    }

    /**
     * 回调
     * @param onTabBarItemSelectedListener
     */
    public void setOnTabBarItemSelectedListener(OnTabBarItemSelectedListener onTabBarItemSelectedListener){
        this.onTabBarItemSelectedListener = onTabBarItemSelectedListener;
    }


    /**
     * 创建tabBarItem的时间监听接口
     */
    public interface OnTabBarItemSelectedListener{
        void onTabBarItemSelected(int index);
    }

    public void hideBar(){
//        ObjectAnimator animator = ObjectAnimator.ofFloat(this,View.TRANSLATION_Y,0,this.getHeight());
//        animator.setDuration(500);
//        animator.start();
//        MyAnimation.setDTime();
//        startAnimation(MyAnimation.mHiddenAction);
        setVisibility(View.GONE);
    }
    public void showBar(){
//        ObjectAnimator animator = ObjectAnimator.ofFloat(this,View.TRANSLATION_Y,this.getHeight());
//        animator.setDuration(500);
//        animator.start();
//        MyAnimation.setDTime();
//        startAnimation(MyAnimation.mShowAction);
        setVisibility(View.VISIBLE);
    }

    public static void night(){

        l.setBackgroundColor(Color.parseColor("#212b30"));
    }
    public static void day(){
        l.setBackgroundColor(Color.parseColor("#F0F4F5"));
    }
}
