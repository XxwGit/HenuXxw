package com.henu.zhihu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.henu.zhihu.R;
import bean.MyData;

import com.henu.zhihu.fragment.FirstFragment;
import com.henu.zhihu.utils.Data;

import java.util.List;

import static com.henu.zhihu.adapter.MyRecycleViewAdapter.build_content;
import static com.henu.zhihu.adapter.MyRecycleViewAdapter.build_title;

public class ShowRecycleViewItemActivity extends Activity {

    private int position;
    private TextView content;
    private TextView title;
    private List<MyData> list;
    ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_recycle_view_item);
        init();
        btn = (ImageButton)findViewById(R.id.back_first);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowRecycleViewItemActivity.this.finish();
            }
        });
    }

    private void init() {
        position = FirstFragment.POSITION;
        list =  Data.getList();
        content = (TextView) findViewById(R.id.back_content);
        title = (TextView) findViewById(R.id.back_title);
        title.setText("搞笑段子");
        content.setText(build_content);
    }
}
