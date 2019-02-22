package com.henu.zhihu.bean;

import android.widget.ImageView;

import java.sql.Date;

/**
 * Created by 随大大 on 2017/5/17.
 */

public class RecycleViewItemBean {
    private String title;

    private String content;
    private String from;
    private int cid;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public int getCid() {
        return cid;
    }
    public void setCid(int cid) {
        this.cid = cid;
    }
}
