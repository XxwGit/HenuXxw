package com.henu.zhihu.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.henu.zhihu.R;
import com.henu.zhihu.widge.SearchView;

/**
 * Created by 随大大 on 2017/4/23.
 */

public class MyTitleView extends LinearLayout implements SearchView.SearchViewListener {


    private static LinearLayout l;
    private OnEditTextFocusChangeListener onEditTextFocusChangeListener;
    private TextView tv;
    private SearchView edt;
    private ListView lvResults;
    private OnSerchViewListener on;
    private OnEditAdapter allAdapter;

    public MyTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View v = LayoutInflater.from(context).inflate(R.layout.search_layout,null);
        LayoutInflater.from(context).inflate(R.layout.view_title,this,true);
        l = (LinearLayout) findViewById(R.id.l);
        lvResults = (ListView) v.findViewById(R.id.search_lv_tips);

        tv = (TextView) findViewById(R.id.title);
        edt = (SearchView) findViewById(R.id.title_edt);
        edt.setSearchViewListener(this);

        if(allAdapter != null){
            edt.setTipsHintAdapter(allAdapter.setHintAdapter());
            edt.setAutoCompleteAdapter(allAdapter.setAutoCompleteAdapter());
        }

    }

    public void setEListVisibility(int v){
        lvResults.setVisibility(v);
    }
    public void setTitle(String title){
        tv.setText(title);
    }
    public void setVisibility (int one,int two){
        tv.setVisibility(one);
        edt.setVisibility(two);
    }
    public void setOnEditTextFocusChangeListener(OnEditTextFocusChangeListener onEditTextFocusChangeListener){
        this.onEditTextFocusChangeListener = onEditTextFocusChangeListener;
    }
    public void setOnEditAllAdapter(OnEditAdapter allAdapter){
        this.allAdapter = allAdapter;
    }

    public void setOnEditSerchListener(OnSerchViewListener on){
        this.on = on;
    }

    @Override
    public void onRefreshAutoComplete(String text) {
        if(on!=null){
            on.onRefreshAutoComplete(text);
        }
    }

    @Override
    public void onSearch(String text) {

        if(on!=null){
            on.onSearch(text,lvResults);
        }
    }

    public interface OnEditTextFocusChangeListener{
        void onEditTextFocusChanged(ListView l);
    }
    public interface OnSerchViewListener{
        void onRefreshAutoComplete(String text);
        void onSearch(String text,ListView lvResults);
    }
    public interface OnEditAdapter{
        ArrayAdapter<String> setHintAdapter();
        ArrayAdapter<String> setAutoCompleteAdapter();
    }

    public void hideBar(){
//        ObjectAnimator animator = ObjectAnimator.ofFloat(this,View.TRANSLATION_Y,0,-this.getHeight());
//        animator.setDuration(500);
//        animator.start();
//        MyAnimation.setDTime();
//        startAnimation(MyAnimation.mHiddenAction);
        setVisibility(View.GONE);
    }
    public void showBar(){
//        ObjectAnimator animator = ObjectAnimator.ofFloat(this,View.TRANSLATION_Y,-this.getHeight());
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
        l.setBackgroundColor(Color.parseColor("#1C89E6"));
    }
}
