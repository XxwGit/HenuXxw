package com.henu.zhihu.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.henu.zhihu.R;
import com.henu.zhihu.activity.MainActivity;
import com.henu.zhihu.activity.ShowRecycleViewItemActivity;
import com.henu.zhihu.adapter.MyRecycleViewAdapter;
import com.henu.zhihu.listener.EndlessRecyclerOnScrollListener;
import com.henu.zhihu.listener.MyRecycleViewOnScrollListener;
import com.henu.zhihu.utils.MyOkHttp;
import com.henu.zhihu.view.MyTitleView;
import com.henu.zhihu.view.TabBarView;

import java.util.List;

import bean.MyData;

/**
 * Created by 随大大 on 2017/4/3.
 */

public class TwoFragment extends Fragment implements ViewPager.OnPageChangeListener, MyRecycleViewAdapter.OnRCVItemClickListener {
    LinearLayout linearLayout_zhuanlan;
    LinearLayout linearLayout_Live;
    LinearLayout linearLayout_shudian;
    LinearLayout linearLayout_shoucang;
    LinearLayout linearLayout_yuanzhuo;
    private List<MyData> updata;
    private List<MyData> downUpData;
    public static int POSITION;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView rv;
    private List<MyData> list ;
    private MyRecycleViewAdapter myAdapter;
    private MyTitleView top;
    private TabBarView down;
    private SwipeRefreshLayout.OnRefreshListener refreshListener;
    private LinearLayoutManager layoutManager;
    private static int start = 80;
    private static int size = 10;

    private static LinearLayout linearLayout1;
    private  static LinearLayout linearLayout2;
    private  static LinearLayout linearLayout3;
    private  static LinearLayout linearLayout4;
    private  static LinearLayout linearLayout5;
    private  static LinearLayout linearLayout6;
    private  static LinearLayout linearLayout7;
    private  static LinearLayout linearLayout8;
    private static TextView text1;
    private static TextView text2;
    private static TextView text3;
    private static TextView text4;
    private static TextView text5;
    public TwoFragment(TabBarView down){

        this.down = down;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        linearLayout1=(LinearLayout)view.findViewById(R.id.two);
        linearLayout2=(LinearLayout) view.findViewById(R.id.mydaohang);
        linearLayout3=(LinearLayout) view.findViewById(R.id.live);
        linearLayout4=(LinearLayout) view.findViewById(R.id.zhaunlan);
        linearLayout5=(LinearLayout) view.findViewById(R.id.shudian);
        linearLayout6=(LinearLayout) view.findViewById(R.id.shoucang);
        linearLayout7=(LinearLayout) view.findViewById(R.id.mydaohang);
        linearLayout8=(LinearLayout) view.findViewById(R.id.yuanzhaun);
        text1=(TextView)view.findViewById(R.id.text11) ;
        text2=(TextView)view.findViewById(R.id.text22) ;
        text3=(TextView)view.findViewById(R.id.text33) ;
        text4=(TextView)view.findViewById(R.id.text44) ;
        text5=(TextView)view.findViewById(R.id.text55) ;
        linearLayout_zhuanlan = (LinearLayout) view.findViewById(R.id.zhaunlan);
        linearLayout_zhuanlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        initData();
        init(view);
        return view;
    }

    private void initData() {
        list = MainActivity.list;

    }

    private void init(View view) {
        rv = (RecyclerView) view.findViewById(R.id.id_recyclerview);
        layoutManager = new LinearLayoutManager(this.getActivity());
        rv.setLayoutManager(layoutManager);
        rv.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        rv.setOnScrollListener(new MyRecycleViewOnScrollListener(top,down,false,true));
        myAdapter = new MyRecycleViewAdapter(getContext(),list,true);
        myAdapter.setOnRCVItemClickListener(this);
        rv.setAdapter(myAdapter);

        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swip);
        //设置刷新时动画的颜色，可以设置4个
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                // TODO Auto-generated method stub
                new Thread(){
                    @Override
                    public void run() {
                        String url = "http://123.206.209.168:8080/AndroidService/getData?start="+start+"&size="+size;
                        updata = MyOkHttp.getDatas(url);
                        start +=10;
                    }
                }.start();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        if (myAdapter == null){
                            Toast.makeText(getContext(),"更新失败",Toast.LENGTH_SHORT).show();
                        }else{
                            Log.e("updata","---"+updata.size());
                            myAdapter.addItem(updata);
                        }
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });
        rv.addOnScrollListener(new EndlessRecyclerOnScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                simulateLoadMoreData();
            }
        });
    }

    private void simulateLoadMoreData() {
        new Thread(){
            @Override
            public void run() {
                String url = "http://123.206.209.168:8080/AndroidService/getData?start="+start+"&size="+size;
                downUpData =  updata = MyOkHttp.getDatas(url);
                start +=10;
            }
        }.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                if (downUpData == null){
                    Toast.makeText(getContext(),"更新失败",Toast.LENGTH_SHORT).show();
                }else{
                    Log.e("updata","---"+updata.size());
                    myAdapter.addItem(downUpData);
                    myAdapter.notifyDataSetChanged();
                }
                Toast.makeText(getContext(), "Load Finished!", Toast.LENGTH_SHORT).show();
            }
        }, 1000);

    }

    @Override
    public void onItemFromClick(View v, int position) {
        Toast.makeText(getContext(),"f",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemTitleClick(View v, int position) {
        Toast.makeText(getContext(),"Title",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemContentClick(View v, int position) {
        POSITION = position;
        Intent intent = new Intent(getContext(), ShowRecycleViewItemActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public static void night(){
        linearLayout1.setBackgroundColor(Color.parseColor("#212b30"));
        linearLayout2.setBackgroundColor(Color.parseColor("#37474f"));
        linearLayout3.setBackgroundColor(Color.parseColor("#37474f"));
        linearLayout4.setBackgroundColor(Color.parseColor("#37474f"));
        linearLayout5.setBackgroundColor(Color.parseColor("#37474f"));
        linearLayout6.setBackgroundColor(Color.parseColor("#37474f"));
        linearLayout7.setBackgroundColor(Color.parseColor("#37474f"));
       linearLayout8.setBackgroundColor(Color.parseColor("#37474f"));
        text1.setTextColor(Color.parseColor("#fdfefc"));
        text2.setTextColor(Color.parseColor("#fdfefc"));
        text3.setTextColor(Color.parseColor("#fdfefc"));
        text4.setTextColor(Color.parseColor("#fdfefc"));
        text5.setTextColor(Color.parseColor("#fdfefc"));

    }
    public static void day(){
        linearLayout1.setBackgroundColor(Color.parseColor("#F0F4F5"));
        linearLayout2.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout3.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout4.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout5.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout6.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout7.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout8.setBackgroundColor(Color.parseColor("#ffffff"));
        text1.setTextColor(Color.parseColor("#1b1b1b"));
        text2.setTextColor(Color.parseColor("#1b1b1b"));
        text3.setTextColor(Color.parseColor("#1b1b1b"));
        text4.setTextColor(Color.parseColor("#1b1b1b"));
        text5.setTextColor(Color.parseColor("#1b1b1b"));

    }
}
