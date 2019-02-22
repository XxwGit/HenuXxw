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


public class LoginActivity extends AppCompatActivity implements MyOkHttp.GetResponse {
    private Handler handle = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    startActivity(new Intent(LoginActivity.this,FragmentActivity.class));
                    break;
                case 2:
                    Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(LoginActivity.this,"网络连接错误："+((IOException)msg.obj).toString(),Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    };
    private Button tv_register;
    private Button btn_login;
    private EditText account;
    private EditText password;
    private MyOkHttp m;
    private Message msg = new Message();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        m = new MyOkHttp(this);
        account = (EditText) findViewById(R.id.account);
        tv_register = (Button) findViewById(R.id.link_signup);
        password = (EditText) findViewById(R.id.password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accountS = account.getText().toString();
                String passwordS = password.getText().toString();
                String ss = "http://123.206.209.168:8080/AndroidService/login?userName=" + accountS + "&passWord=" + passwordS;
                Log.e("登录",ss);
                m.run(ss);
                Log.e("登录","---------");
            }
        });
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
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

//        Message msg1 = new Message();
//        if (str.equals("SUCCESS")){
//            msg1.what = 1;
//            handle.sendMessage(msg1);
//        }
//        if (str.equals("FAILE")){
//            Log.e("失败操作","---");
//            Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
//            msg1.what = 2;
//            handle.sendMessage(msg1);
//        }
    }

    @Override
    public void doError(Request request, IOException e) {
        msg.what = 3;
        msg.obj = e;
        Log.e("错误日志",e.toString());
        handle.sendMessage(msg);
    }
}
