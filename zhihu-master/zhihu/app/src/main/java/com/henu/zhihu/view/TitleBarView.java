package com.henu.zhihu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.henu.zhihu.R;

/**
 * Created by 随大大 on 2017/4/3.
 */

public class TitleBarView extends LinearLayout implements View.OnClickListener {

    private ImageButton one;
    private ImageButton two;
    private ImageButton three;
    private TextView tv;
    /**
     * 绑定事件接口
     */
    private OnTitleBarClickListener onTitleBarClickListener;

    /**
     * 构造器
     * @param context
     * @param attrs
     */
    public TitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_title_bar,this,true);
        one = (ImageButton) findViewById(R.id.img_one);
        two = (ImageButton) findViewById(R.id.img_two);
        three = (ImageButton) findViewById(R.id.img_three);
        tv = (TextView) findViewById(R.id.tv);
        init();
    }


    /**
     * 绑定事件
     */
    private void init() {
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        tv.setOnClickListener(this);
    }

    /**
     * 实现的click方法
     * @param view
     */
    @Override
    public void onClick(View view) {
          switch (view.getId()){
              case R.id.img_one:
                  onTitleBarClickListener.c_img_one();
                  break;
              case R.id.img_two:
                  onTitleBarClickListener.c_img_two();
                  break;
              case R.id.img_three:
                  onTitleBarClickListener.c_img_three();
                  break;
              case R.id.tv:
                  onTitleBarClickListener.c_tv();
                  break;
          }
    }

    /**
     * 一下四个方法是返回顶部view的控件的对象的引用
     * @return
     */
    public ImageButton getImageOne(){return one;}
    public ImageButton getImageTwo(){return two;}
    public ImageButton getImageOThree(){return three;}
    public TextView getTextView(){return tv;}


    /**
     * 设置各个控件是否显示
     * @param a
     * @param b
     * @param c
     * @param d
     */
    public void setVisible(boolean a,boolean b,boolean c,boolean d){
        one.setVisibility(a ? View.VISIBLE : View.INVISIBLE);
        tv.setVisibility(b ? View.VISIBLE : View.INVISIBLE);
        two.setVisibility(c ? View.VISIBLE : View.INVISIBLE);
        three.setVisibility(d ? View.VISIBLE : View.INVISIBLE);
    }

    /**
     * 回调
     * @param onTitleBarClickListener
     */
    public void setOnTitleBarClickListener(OnTitleBarClickListener onTitleBarClickListener ){ this.onTitleBarClickListener = onTitleBarClickListener;}

    /**
     * 需要实现接口的方法
     */
    public interface OnTitleBarClickListener{
        void c_img_one();
        void c_img_two();
        void c_img_three();
        void c_tv();

    }
}
