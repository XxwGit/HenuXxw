package com.henu.zhihu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.henu.zhihu.R;
import bean.MyData;

import com.henu.zhihu.launcher.LauncherView;
import com.henu.zhihu.utils.MyOkHttp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 随大大 on 2017/5/20.
 */

public class MainActivity extends Activity {
    public static List<MyData> list = new ArrayList<>();
    private Handler handle = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    String ss = msg.obj.toString();
                    break;
            }
        }
    };
    private Button bt;
    private String ss = "http://123.206.209.168:8080/AndroidService/login?userName=123456&passWord=1234562";
    private static String url = "http://123.206.209.168:8080/AndroidService/getData?start="+1+"&size="+10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LauncherView launcherView = (LauncherView) findViewById(R.id.load_view);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                launcherView.start();
            }
        },500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                findViewById(R.id.start).setVisibility(View.VISIBLE);
            }
        },3450);

//        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,LoginActivity.class));
//            }
//        });
        bt = (Button) findViewById(R.id.start);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run() {
                                // TODO Auto-generated method stub
                                list = MyOkHttp.getDatas(url);
                                Log.e("--------",list.size() + " ");
                                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                            }
                }.start();


            }
        });
    }



//    private void login1() {
//        MyOkHttp m = new MyOkHttp(this);
//        m.run(ss);
//    }
//
//    @Override
//    public void doSuccess(String str) {
//            Message m= new Message();
//            m.what =1;
//            m.obj = str;
//            handle.sendMessage(m);
//    }
//    @Override
//    public void doError(Request request, IOException e) {
//
//    }

}