package com.henu.zhihu.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
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
import bean.MyData;

import com.henu.zhihu.listener.EndlessRecyclerOnScrollListener;
import com.henu.zhihu.listener.MyRecycleViewOnScrollListener;
import com.henu.zhihu.utils.MyOkHttp;
import com.henu.zhihu.view.MyTitleView;
import com.henu.zhihu.view.RecycleViewDivider;
import com.henu.zhihu.view.TabBarView;

import java.text.SimpleDateFormat;
import java.util.List;

@SuppressLint("ValidFragment")
public class FirstFragment extends Fragment implements MyRecycleViewAdapter.OnRCVItemClickListener {

    private static LinearLayout linearLayout;
    private static TextView textView;
    private List<MyData> updata;
    private List<MyData> downUpData;
    public static int POSITION;
    private TextView tv;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView rv;
    private List<MyData> list ;
    private MyRecycleViewAdapter myAdapter;
    private MyTitleView top;
    private TabBarView down;
    private SwipeRefreshLayout.OnRefreshListener refreshListener;
    private LinearLayoutManager layoutManager;
    private static int start = 10;
    private static int size = 10;

//    private static

    public FirstFragment(MyTitleView top,TabBarView down){
        this.top = top;
        this.down = down;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        linearLayout=(LinearLayout)view.findViewById(R.id.first);
        textView=(TextView)view.findViewById(R.id.textView1);
        init(view);
        return view;
    }



    private void init(View view) {

        list = MainActivity.list;
        tv = (TextView)view.findViewById(R.id.textView1);
        rv = (RecyclerView) view.findViewById(R.id.id_recyclerview);
        layoutManager = new LinearLayoutManager(this.getActivity());
        rv.setLayoutManager(layoutManager);
        rv.addItemDecoration(new RecycleViewDivider(getContext(),LinearLayoutManager.VERTICAL));
        rv.setOnScrollListener(new MyRecycleViewOnScrollListener(top,down,true,true));
        myAdapter = new MyRecycleViewAdapter(getContext(),list,true);
        myAdapter.setOnRCVItemClickListener(this);
        rv.setAdapter(myAdapter);

        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swip);
        //设置刷新时动画的颜色，可以设置4个
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
              upData();
            }
        });
        rv.addOnScrollListener(new EndlessRecyclerOnScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                simulateLoadMoreData();
            }
        });
    }

    private void upData() {
        new Thread(){
            @Override
            public void run() {
                String url = "http://123.206.209.168:8080/AndroidService/getData?start="+start+"&size="+size;
                updata = MyOkHttp.getDatas(url);
                start +=10;
            }
        }.start();
        tv.setText("正在刷新");
        // TODO Auto-generated method stub
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                SimpleDateFormat sDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");
                String date = sDateFormat.format(new java.util.Date());

                tv.setText("刷新完成:"+date);
                if (updata == null){
                    Toast.makeText(getContext(),"更新失败",Toast.LENGTH_SHORT).show();
                }else{
                    Log.e("updata","---"+updata.size());
                    myAdapter.addItem(updata);
                }
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 3000);
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
        }, 3000);

    }



    @Override
    public void onItemFromClick(View v, int position) {
        Toast.makeText(getContext(),"来源",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemTitleClick(View v, int position) {
        Toast.makeText(getContext(),"标题",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemContentClick(View v, int position) {
        POSITION = position;
        Intent intent = new Intent(getContext(), ShowRecycleViewItemActivity.class);
        startActivity(intent);
    }

    public static void night(){

        linearLayout.setBackgroundColor(Color.parseColor("#212b30"));
        textView.setTextColor(Color.parseColor("#fdfefc"));
    }
    public static void day(){
        linearLayout.setBackgroundColor(Color.parseColor("#F0F4F5"));
        textView.setTextColor(Color.parseColor("#1b1b1b"));
    }

}
