package com.henu.zhihu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.henu.zhihu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 随大大 on 2017/4/23.
 */

public class RefreshRecyclerAdapter extends RecyclerView.Adapter<RefreshRecyclerAdapter.ViewHolder>{
    private LayoutInflater minflater;
    private List<String> mTitles = null;
    public RefreshRecyclerAdapter(Context context){
        this.minflater = LayoutInflater.from(context);
        this.mTitles = new ArrayList<>();
        for (int i=0;i<20;i++){
            int index =i+1;
            mTitles.add("item " + index);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = minflater.inflate(R.layout.view_tab_bar,parent,false) ;
        //事件监听绑定.
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RefreshRecyclerAdapter.ViewHolder holder, int position) {

        holder.item_tv.setText(mTitles.get(position));
        holder.itemView.setTag(position);
    }


    @Override
    public int getItemCount() {
        return mTitles.size();
    }
    public void addItem(List<String> newDatas){
        newDatas.addAll(mTitles);
        mTitles.remove(mTitles);
        mTitles.addAll(newDatas);
        notifyDataSetChanged();
    }
    public void addMoreItem(List<String> newDatas){
        mTitles.addAll(newDatas);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView item_tv;
        public ViewHolder(View itemView) {
            super(itemView);
            item_tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
