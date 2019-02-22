package com.henu.zhihu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.henu.zhihu.R;
import com.henu.zhihu.view.MyTitleView;
import com.henu.zhihu.view.TabBarView;
import com.henu.zhihu.widge.SearchView;

public class FifthFragement extends Fragment {

    private Switch aSwitch;
    private ImageView imageView1,imageView2,imageView3,imageView4,imageView5;
    private TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9;
    private LinearLayout linearLayout, linearLayout1,linearLayout2,linearLayout3,linearLayout4,linearLayout5,linearLayout6,linearLayout7,linearLayout8,linearLayout9,linearLayout10;
    Boolean isLogin = false;
    public FifthFragement(){
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragement_fifith, container, false);
   initalize(view);


        if(isLogin){
            return  view;
        }
        else{
            return  view;

        }
    }

protected void initalize(View view){
    aSwitch=(Switch)view.findViewById(R.id.switch1);
    linearLayout=(LinearLayout)view.findViewById(R.id.fragement_fifith);
    linearLayout1=(LinearLayout)view.findViewById(R.id.load);
    linearLayout2=(LinearLayout)view.findViewById(R.id.myAttention);
    linearLayout3=(LinearLayout)view.findViewById(R.id.myCollection);
    linearLayout4=(LinearLayout)view.findViewById(R.id.myPaper);
    linearLayout5=(LinearLayout)view.findViewById(R.id.recentView);
    linearLayout6=(LinearLayout)view.findViewById(R.id.mybook);
    linearLayout7=(LinearLayout)view.findViewById(R.id.mylive);
    linearLayout8=(LinearLayout)view.findViewById(R.id.myzhi);
    linearLayout9=(LinearLayout)view.findViewById(R.id.night);
    linearLayout10=(LinearLayout)view.findViewById(R.id.set);
    textView1=(TextView)view.findViewById(R.id.myAttention1);
    textView2=(TextView)view.findViewById(R.id.myCollection1);
    textView3=(TextView)view.findViewById(R.id.myPaper1);
    textView4=(TextView)view.findViewById(R.id.recentView1);
    textView5=(TextView)view.findViewById(R.id.mybook1);
    textView6=(TextView)view.findViewById(R.id.mylive1);
    textView7=(TextView)view.findViewById(R.id.myzhi1);
    textView8=(TextView)view.findViewById(R.id.night1);
    textView9=(TextView)view.findViewById(R.id.set1);
    aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            if(isChecked){
                TabBarView.night();
                MyTitleView.night();
                nightight();
                FourthFragement.night();
                FirstFragment.night();
                TwoFragment.night();
                SearchView.night();
            }else{
//
                TabBarView.day();
                MyTitleView.day();
                FirstFragment.day();
                FourthFragement.day();
                TwoFragment.day();
                SearchView.day();
                day();
            }
        }
    });
}
    public   void nightight(){
         linearLayout.setBackgroundColor(this.getResources().getColor(R.color.nightAll));
        linearLayout1.setBackgroundColor(this.getResources().getColor(R.color.nightLine));
        linearLayout2.setBackgroundColor(this.getResources().getColor(R.color.nightLine));
        linearLayout3.setBackgroundColor(this.getResources().getColor(R.color.nightLine));
        linearLayout4.setBackgroundColor(this.getResources().getColor(R.color.nightLine));
        linearLayout5.setBackgroundColor(this.getResources().getColor(R.color.nightLine));
        linearLayout6.setBackgroundColor(this.getResources().getColor(R.color.nightLine));
        linearLayout7.setBackgroundColor(this.getResources().getColor(R.color.nightLine));
        linearLayout8.setBackgroundColor(this.getResources().getColor(R.color.nightLine));
        linearLayout9.setBackgroundColor(this.getResources().getColor(R.color.nightLine));
        linearLayout10.setBackgroundColor(this.getResources().getColor(R.color.nightLine));
        textView1.setTextColor(this.getResources().getColor(R.color.nightText));
        textView2.setTextColor(this.getResources().getColor(R.color.nightText));
        textView3.setTextColor(this.getResources().getColor(R.color.nightText));
        textView4.setTextColor(this.getResources().getColor(R.color.nightText));
        textView5.setTextColor(this.getResources().getColor(R.color.nightText));
        textView6.setTextColor(this.getResources().getColor(R.color.nightText));
        textView7.setTextColor(this.getResources().getColor(R.color.nightText));
        textView8.setTextColor(this.getResources().getColor(R.color.nightText));
        textView9.setTextColor(this.getResources().getColor(R.color.nightText));
    }
    public  void day(){

        linearLayout.setBackgroundColor(this.getResources().getColor(R.color.dayAll));
        linearLayout1.setBackgroundColor(this.getResources().getColor(R.color.dayLine));
        linearLayout2.setBackgroundColor(this.getResources().getColor(R.color.dayLine));
        linearLayout3.setBackgroundColor(this.getResources().getColor(R.color.dayLine));
        linearLayout4.setBackgroundColor(this.getResources().getColor(R.color.dayLine));
        linearLayout5.setBackgroundColor(this.getResources().getColor(R.color.dayLine));
        linearLayout6.setBackgroundColor(this.getResources().getColor(R.color.dayLine));
        linearLayout7.setBackgroundColor(this.getResources().getColor(R.color.dayLine));
        linearLayout8.setBackgroundColor(this.getResources().getColor(R.color.dayLine));
        linearLayout9.setBackgroundColor(this.getResources().getColor(R.color.dayLine));
        linearLayout10.setBackgroundColor(this.getResources().getColor(R.color.dayLine));
    }

}