package com.henu.zhihu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.henu.zhihu.R;


/**
 * Created by 随大大 on 2017/4/3.
 */

public class TabBarItemView extends LinearLayout{

    /**
     * 获取图片对象
     */
    private ImageView imageView;
    /**
     * 标志位 是否选中
     */
    private boolean isSelected;
    /**
     * 没有被选中图片的资源ID
     */
    private int unSelectedResId = 0;
    /**
     * 被选中的图片资源ID
     */
    private int selectedResId = 0;

    /**
     * 构造器
     * @param context
     * @param attrs
     */
    public TabBarItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
       // View view = LayoutInflater.from(context).inflate(R.layout.view_tab_bar_item,null);
        LayoutInflater.from(context).inflate(R.layout.view_tab_bar_item,this,true);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    /**
     * 获取是否选中的状态
     * @return
     */
    public boolean IsSelected(){
           return isSelected;
    }

    /**
     * 设置选中 同时改变图片
     */
    public void setSelected(){
        isSelected = true;
        if (selectedResId !=0 ){
            imageView.setImageResource(selectedResId);
        }
    }

    /**
     * 设置不被选中 同时改变图片
     */
    public void unSelected(){
        isSelected = false;
        if (unSelectedResId !=0){
            imageView.setImageResource(unSelectedResId);
        }
    }

    /**
     * 将选中和不被选中的图片资源ID传进item的内部
     * @param selectedResId
     * @param unSelectedResId
     */

    public void setImageResource(int selectedResId,int unSelectedResId){
       if (unSelectedResId!=0){
           imageView.setImageResource(unSelectedResId);

       }
        this.unSelectedResId = unSelectedResId;
        this.selectedResId = selectedResId;

    }


}
