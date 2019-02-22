package com.henu.zhihu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.henu.zhihu.R;
import com.henu.zhihu.utils.MyOkHttp;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by 随大大 on 2017/5/20.
 */

public class A extends Activity implements MyOkHttp.GetResponse{

    private Handler handle = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    break;
                case 2:
                    break;
            }
        }
    };

    private TextView textView;
    private EditText z;
    private EditText m;
    private Button bt;
    private String ss = "http://123.206.209.168:8080/AndroidService/regist?userName=123456&passWord=1234562";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        textView = (TextView) findViewById(R.id.ttt);
//        z = (EditText) findViewById(R.id.editText);
//        m = (EditText) findViewById(R.id.editText1);
//        bt = (Button) findViewById(R.id.bb);
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//              regist();
//            }
//        });
    }

    private void regist() {
        String zhang = z.getText().toString();
        String mima = m.getText().toString();
        MyOkHttp m = new MyOkHttp(this);
        m.run(ss);
    }

    @Override
    public void doSuccess(String str) {
        Message m = new Message();
        if (str.equals("SUCCESS")){
            m.what = 1;
        }
        if (str.equals("FAILE")){
            m.what = 2;
        }
        handle.sendMessage(m);
    }

    @Override
    public void doError(Request request, IOException e) {

    }
}
