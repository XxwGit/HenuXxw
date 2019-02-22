package com.henu.zhihu.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.henu.zhihu.R;
import com.henu.zhihu.adapter.ChatMessageAdapter;
import com.henu.zhihu.bean.ChatMessage;
import com.henu.zhihu.bean.ChatMessage.Type;
import com.henu.zhihu.utils.HttpUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThirdFragement extends Fragment {


    View view;
    /**
     * 展示消息的listview
     */
    private ListView mChatView;
    /**
     * 文本域
     */
    private EditText mMsg;
    /**
     * 存储聊天消息
     */
    private List<ChatMessage> mDatas = new ArrayList<ChatMessage>();
    /**
     * 适配器
     */
    private ChatMessageAdapter mAdapter;

    private Handler mHandler = new Handler()
    {
        public void handleMessage(Message msg)
        {
            ChatMessage from = (ChatMessage) msg.obj;
            mDatas.add(from);
            mAdapter.notifyDataSetChanged();
            mChatView.setSelection(mDatas.size() - 1);
        };
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.fragement_third, container, false);
        initView();
        mAdapter = new ChatMessageAdapter(getActivity(), mDatas);
        mChatView.setAdapter(mAdapter);
        Button btn = (Button) view.findViewById(R.id.id_chat_send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String msg = mMsg.getText().toString();
                if (TextUtils.isEmpty(msg))
                {
                    Toast.makeText(getActivity(), "您还没有填写信息呢...", Toast.LENGTH_SHORT).show();
                    return;
                }
                ChatMessage to = new ChatMessage(Type.OUTPUT, msg);

                to.setDate(new Date());
                mDatas.add(to);

                mAdapter.notifyDataSetChanged();
                mChatView.setSelection(mDatas.size() - 1);


                mMsg.setText("");

                // 关闭软键盘
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                // 得到InputMethodManager的实例
                if (imm.isActive())
                {
                    // 如果开启
                    imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
                            InputMethodManager.HIDE_NOT_ALWAYS);
                    // 关闭软键盘，开启方法相同，这个方法是切换开启与关闭状态的
                }
                new Thread()
                {
                    public void run()
                    {
                        ChatMessage from = null;
                        try
                        {
                            from = HttpUtils.sendMsg(msg);
                        } catch (Exception e)
                        {
                            from = new ChatMessage(Type.INPUT, "服务器挂了呢...");
                        }
                        Message message = Message.obtain();
                        message.obj = from;
                        mHandler.sendMessage(message);
                    };
                }.start();
            }
        });
        return view;
    }

    private void initView() {
        mChatView = (ListView) view.findViewById(R.id.id_chat_listView);
        mMsg = (EditText) view.findViewById(R.id.id_chat_msg);
        mDatas.add(new ChatMessage(Type.INPUT, "很高兴为您服务"));
    }


//    public void sendMessage(View view1)
//    {
//        Log.e("錯誤","-----");
//        final String msg = mMsg.getText().toString();
//        if (TextUtils.isEmpty(msg))
//        {
//            Toast.makeText(getActivity(), "您还没有填写信息呢...", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        ChatMessage to = new ChatMessage(Type.OUTPUT, msg);
//        to.setDate(new Date());
//        mDatas.add(to);
//
//        mAdapter.notifyDataSetChanged();
//        mChatView.setSelection(mDatas.size() - 1);
//
//        mMsg.setText("");
//
//        // 关闭软键盘
//        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//        // 得到InputMethodManager的实例
//        if (imm.isActive())
//        {
//            // 如果开启
//            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
//                    InputMethodManager.HIDE_NOT_ALWAYS);
//            // 关闭软键盘，开启方法相同，这个方法是切换开启与关闭状态的
//        }
//
//        new Thread()
//        {
//            public void run()
//            {
//                ChatMessage from = null;
//                try
//                {
//                    from = HttpUtils.sendMsg(msg);
//                } catch (Exception e)
//                {
//                    from = new ChatMessage(Type.INPUT, "服务器挂了呢...");
//                }
//                Message message = Message.obtain();
//                message.obj = from;
//                mHandler.sendMessage(message);
//            };
//        }.start();
//
//        }
}
