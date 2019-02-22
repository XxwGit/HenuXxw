package com.henu.zhihu.listener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.henu.zhihu.view.MyTitleView;
import com.henu.zhihu.view.TabBarView;

/**
 * Created by 随大大 on 2017/5/20.
 */

/**
 * 实现下拉隐藏标题栏，上拉显示标题栏。
 */
public class MyRecycleViewOnScrollListener extends RecyclerView.OnScrollListener {

    private MyTitleView top;
    private TabBarView down;
    private boolean isShow;
    private boolean one;
    private boolean two;
    private int disy;

    public MyRecycleViewOnScrollListener(MyTitleView top,TabBarView down,boolean one,boolean two){
        this.top = top;
        this.down =  down;
        this.one = one;
        this.two = two;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
       // Log.e("滑动",dx + "  " + dy);
        //获取第一个item
        int firsstVisibleItem = ((LinearLayoutManager)recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        //当前可见item的第一个是否是列表的第一个，如果是第一个应该显示

            if(dy >2 && isShow){
                if (one) {
                    top.hideBar();
                }
                if(two) {
                    down.hideBar();
                }
            }
            if(dy < -2 ){
                if (one){
                    top.showBar();
                }
                if(two) {
                    down.showBar();
                }
                isShow = false;
            }
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int lastVisibleItem = manager.findLastCompletelyVisibleItemPosition();//获取最后一个完全显示的ItemPosition
        // 当不滚动时
        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//            disy =
          //  Log.e("滑动","newState TDLE----" + newState);
//            top.showBar();
//            down.showBar();
//            isShow = false;
//            top.hideBar();
//            down.hideBar();
//            isShow = true;
        } else {//拖动中
          //  Log.e("滑动","newState----" + newState);
            isShow = true;
        }
    }
}
