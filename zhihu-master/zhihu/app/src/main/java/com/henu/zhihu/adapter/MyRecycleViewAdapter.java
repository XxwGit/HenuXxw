package com.henu.zhihu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.henu.zhihu.R;
import bean.MyData;

import java.util.List;

/**
 * Created by 随大大 on 2017/5/17.
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder> {

    public static String build_title;
    public static String build_content;
    private Context context;
    private List<MyData> list;
    public boolean showImage;
    private OnRCVItemClickListener onRCVItemClickListener;
    public MyRecycleViewAdapter(Context context,List list,boolean showImage){
        this.context = context;
        this.list = list;
        this.showImage = showImage;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.view_recycle_view_item,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        if (onRCVItemClickListener != null) {

            holder.title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onRCVItemClickListener.onItemTitleClick(view,position);
                }
            });
            holder.from.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onRCVItemClickListener.onItemFromClick(view,position);
                }
            });
            holder.content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    build_title = list.get(position).getTitle();
                    build_content = list.get(position).getContent();
                    onRCVItemClickListener.onItemContentClick(view,position);
                }
            });
        }

        holder.from.setText(list.get(position).getFrom());
        holder.title.setText("搞笑段子");
        holder.content.setText(list.get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItem(List<MyData> update) {
        update.addAll(list);
        list.removeAll(update);
        list.addAll(update);
        notifyDataSetChanged();
    }

    public void addMoreItem(List<MyData> update) {
        list.addAll(update);
        notifyDataSetChanged();
    }

    class MyViewHolder extends RefreshRecyclerAdapter.ViewHolder{
        ImageView image;
        TextView from;
        TextView title;
        TextView content;
        //ImageView content_image;

        public MyViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.rc_image);
            if(showImage){
                image.setVisibility(View.VISIBLE);
            }
            else {
                image.setVisibility(View.GONE);
            }
            from = (TextView) itemView.findViewById(R.id.rc_from);
            title = (TextView) itemView.findViewById(R.id.rc_title);
            content = (TextView) itemView.findViewById(R.id.rc_context);

        }


    }

    public interface OnRCVItemClickListener{
        void onItemFromClick(View v,int position);
        void onItemTitleClick(View v,int position);
        void onItemContentClick(View v,int position);
    }

    public void setOnRCVItemClickListener(OnRCVItemClickListener onRCVItemClickListener){
             this.onRCVItemClickListener = onRCVItemClickListener;
    }
}
