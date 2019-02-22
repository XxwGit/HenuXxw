package com.henu.zhihu.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.henu.zhihu.R;
import com.henu.zhihu.adapter.FragmentAdapter;
import com.henu.zhihu.adapter.SearchAdapter;
import bean.Bean;
import com.henu.zhihu.fragment.FifthFragement;
import com.henu.zhihu.fragment.FirstFragment;
import com.henu.zhihu.fragment.FourthFragement;
import com.henu.zhihu.fragment.ThirdFragement;
import com.henu.zhihu.fragment.TwoFragment;
import com.henu.zhihu.view.MyTitleView;
import com.henu.zhihu.view.MyViewPage;
import com.henu.zhihu.view.TabBarView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 随大大 on 2017/4/3.
 */

public class FragmentActivity extends android.support.v4.app.FragmentActivity implements ViewPager.OnPageChangeListener ,MyTitleView.OnSerchViewListener
,MyTitleView.OnEditAdapter{
    /**
     * 提示框显示项的个数
     */
    private static int hintSize = 4;

    /**
     * 热搜框列表adapter
     */
    private ArrayAdapter<String> hintAdapter;

    /**
     * 自动补全列表adapter
     */
    private ArrayAdapter<String> autoCompleteAdapter;

    /**
     * 搜索结果列表adapter
     */
    private SearchAdapter resultAdapter;

    private List<Bean> dbData;

    /**
     * 热搜版数据
     */
    private List<String> hintData;

    /**
     * 搜索过程中自动补全数据
     */
    private List<String> autoCompleteData;

    /**
     * 搜索结果的数据
     */
    private List<Bean> resultData;


    /**---**/
    private static final String[] TITLE_STRING = {"发现","图灵机器人","私信","更多"};
    /**
     * 顶部导航栏
     */
    private MyTitleView top_title;
    /**
     * fragment更新使用
     */
    public static  boolean[] fragmentsUpdateFlag = { false, false, false, false,false };
    /**
     * fragment的承载器
     */
    private MyViewPage viewPager;
    /**
     * 底部view
     */
    private TabBarView tabBarView;
    /**
     * ViewPage的fragmentadapter适配器
     */
    private FragmentAdapter fragmentAdapter;
    /**
     * 存储fragment的list容器
     */
    private List<Fragment> list = new ArrayList<>();
    /**
     * 资源文件被选中时的图片
     */
    private int[] selectedResIds = {R.drawable.blue_menu,R.drawable.blue_two,R.drawable.blue_three,R.drawable.blue_four,R.drawable.blue_five};
    /**
     * 资源文件 不被选中时的图片
     */
    private int[] unSelectedResIds = {R.drawable.gray_menu,R.drawable.gray_two,R.drawable.gray_three,R.drawable.gray_four,R.drawable.gray_five,};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        initData();
        init();
    }

    /**
     * 初始化各种参数
     */
    private void init() {

        top_title = (MyTitleView) findViewById(R.id.top_title);
        viewPager = (MyViewPage) findViewById(R.id.view_page);
        tabBarView = (TabBarView) findViewById(R.id.tab_bar_view);
        list.add(new FirstFragment(top_title,tabBarView));

        list.add(new TwoFragment(tabBarView));
        list.add(new ThirdFragement());
        list.add(new FourthFragement());
        list.add(new FifthFragement());
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),list);
        top_title.setVisibility(View.GONE,View.VISIBLE);
        top_title.setOnEditSerchListener(this);
        //为viewPage添加适配器
        viewPager.setAdapter(fragmentAdapter);
        viewPager.addOnPageChangeListener(this);
        viewPager.setOffscreenPageLimit(5);
        //将资源文件图片传入底部的view
        tabBarView.setTabBarItemImageRescoure(selectedResIds,unSelectedResIds);
        tabBarView.setOnTabBarItemSelectedListener(new TabBarView.OnTabBarItemSelectedListener() {
            @Override
            public void onTabBarItemSelected(int index) {
                selected(index);
            }
        });
        //设置初始的界面状态，底部的view和fragmen
        selected(0);

    }

    /**
     * 设置选中的fragment和底部的view
     * @param index
     */
    private void selected(int index) {
        tabBarView.setSelected(index);
        viewPager.setCurrentItem(index,false);
        if (index == 0){
            top_title.setVisibility(View.GONE,View.VISIBLE);
        }else {
            top_title.setVisibility(View.VISIBLE,View.GONE);
            top_title.setTitle(TITLE_STRING[index-1]);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * 页面选中时所做的操作
     * @param position
     */
    @Override
    public void onPageSelected(int position) {
        selected(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }


    /**
     * 获取db 数据
     */
    private void getDbData() {
        int size = 100;
        dbData = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            dbData.add(new Bean(R.drawable.icon, "android开发必备技能" + (i + 1), "Android自定义view——自定义搜索view", i * 20 + 2 + ""));
        }
    }

    /**
     * 获取热搜版data 和adapter
     */
    private void getHintData() {
        hintData = new ArrayList<>(hintSize);
        for (int i = 1; i <= hintSize; i++) {
            hintData.add("热搜版" + i + "：Android自定义View");
        }
        hintAdapter = new ArrayAdapter<String>(FragmentActivity.this, android.R.layout.simple_list_item_1, hintData);
    }

    /**
     * 获取自动补全data 和adapter
     */
    private void getAutoCompleteData(String text) {
        if (autoCompleteData == null) {
            //初始化
            autoCompleteData = new ArrayList<>(hintSize);
        } else {
            // 根据text 获取auto data
            autoCompleteData.clear();
            for (int i = 0, count = 0; i < dbData.size()
                    && count < hintSize; i++) {
                if (dbData.get(i).getTitle().contains(text.trim())) {
                    autoCompleteData.add(dbData.get(i).getTitle());
                    count++;
                }
            }
        }
        if (autoCompleteAdapter == null) {
            autoCompleteAdapter = new ArrayAdapter<String>(FragmentActivity.this, android.R.layout.simple_list_item_1, autoCompleteData);
        } else {
            autoCompleteAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 获取搜索结果data和adapter
     */
    private void getResultData(String text) {
        if (resultData == null) {
            // 初始化
            resultData = new ArrayList<>();
        } else {
            resultData.clear();
            for (int i = 0; i < dbData.size(); i++) {
                if (dbData.get(i).getTitle().contains(text.trim())) {
                    resultData.add(dbData.get(i));
                }
            }
        }
        if (resultAdapter == null) {
            resultAdapter = new SearchAdapter(FragmentActivity.this, resultData, R.layout.item_bean_list);
        } else {
            resultAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 初始化数据
     */
    private void initData() {
        //从数据库获取数据
        getDbData();
        //初始化热搜版数据
        getHintData();
        //初始化自动补全数据
        getAutoCompleteData(null);
        //初始化搜索结果数据
        getResultData(null);
    }
    /**
     * 当搜索框 文本改变时 触发的回调 ,更新自动补全数据
     * @param text
     */
    @Override
    public void onRefreshAutoComplete(String text) {
        Log.e("搜索","===+++++=");
        getAutoCompleteData(text);
    }
    /**
     * 点击搜索键时edit text触发的回调
     *
     * @param text
     */
    @Override
    public void onSearch(String text, ListView lvResults) {
        Log.e("搜索","=============");
        getResultData(text);
        lvResults.setVisibility(View.VISIBLE);
        Log.e("list","dsadas");
        //第一次获取结果 还未配置适配器
        if (lvResults.getAdapter() == null) {
            //获取搜索数据 设置适配器
            lvResults.setAdapter(resultAdapter);
        } else {
            //更新搜索数据
            resultAdapter.notifyDataSetChanged();
        }
        Toast.makeText(this, "完成搜素", Toast.LENGTH_SHORT).show();
    }

    @Override
    public ArrayAdapter<String> setHintAdapter() {
        return hintAdapter;
    }

    @Override
    public ArrayAdapter<String> setAutoCompleteAdapter() {
        return autoCompleteAdapter;
    }
}
