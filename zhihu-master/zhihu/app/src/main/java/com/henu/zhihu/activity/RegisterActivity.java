package com.henu.zhihu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.henu.zhihu.R;
import com.henu.zhihu.utils.MyOkHttp;
import com.squareup.okhttp.Request;

import java.io.IOException;

public class RegisterActivity extends AppCompatActivity implements MyOkHttp.GetResponse{
    private Button btn_signup;
    private EditText input_password;
    private EditText input_account;
    private Message msg = new Message();
    private MyOkHttp m ;
    private Handler handle = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                    break;
                case 2:
                    Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(RegisterActivity.this,"网络连接错误："+((IOException)msg.obj).toString(),Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        m = new MyOkHttp(this);
        input_account = (EditText) findViewById(R.id.input_account);
        input_password = (EditText) findViewById(R.id.input_password);
        btn_signup = (Button) findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = input_account.getText().toString();
                String password = input_password.getText().toString();
                String ss = "http://123.206.209.168:8080/AndroidService/regist?userName=" + account + "&passWord=" + password;
                Log.e("注册",ss);
                m.run(ss);

            }
        });
    }


    @Override
    public void doSuccess(String str) {
        String s = str;
        if (s.contains("S")){
            msg.what = 1;
            handle.sendMessage(msg);
        }else {
            msg.what = 2;
            handle.sendMessage(msg);
        }
    }

    @Override
    public void doError(Request request, IOException e) {
        msg.what = 3;
        msg.obj = e;
        handle.sendMessage(msg);
    }
}
