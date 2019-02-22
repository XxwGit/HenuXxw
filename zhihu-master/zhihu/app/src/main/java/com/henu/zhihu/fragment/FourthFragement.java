package com.henu.zhihu.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.henu.zhihu.R;

public class FourthFragement extends Fragment {

    private static RelativeLayout l ;
    public FourthFragement(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_fourth, container, false);
        l = (RelativeLayout) view.findViewById(R.id.fragement_fourth);
        return view;
    }
    public static void night(){

        l.setBackgroundColor(Color.parseColor("#212b30"));
    }
    public static void day(){
        l.setBackgroundColor(Color.parseColor("#F0F4F5"));
    }
}
