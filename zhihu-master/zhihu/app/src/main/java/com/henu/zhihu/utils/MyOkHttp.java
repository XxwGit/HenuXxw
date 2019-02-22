package com.henu.zhihu.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import bean.MyData;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by 随大大 on 2017/2/17.
 */

public class MyOkHttp {
    private GetResponse getResponse;
    public MyOkHttp(){}
    private OkHttpClient okHttpClient = new OkHttpClient();
    public MyOkHttp(GetResponse getResponse){
        okHttpClient.setWriteTimeout(30, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(30,TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(30,TimeUnit.SECONDS);
        this.getResponse = getResponse;

    }

    /**
     * 方法一：采用异步方式获取网络文本    or  下载一个文档
     * 下载一个文件，打印他的响应头，以string形式打印响应体。
     * 响应体的 string() 方法对于小文档来说十分方便、高效。但是如果响应体太大（超过1MB）
     *，应避免适应 string()方法 ，因为他会将把整个文档加载到内存中。对于超过1MB的响应body，应使用流的方式来处理body。
     *
     * @param url
     */
    public void run(String url){
        Request request = new Request.Builder().url(url).build();
        String ss = null;
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                getResponse.doError(request,e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()) {
                    String ss = response.body().string();
                    Log.e("网络请求","---成功："+ss);
                    getResponse.doSuccess(ss);
                }
                else {
                    Log.e("网络请求","---失败");
                    try {
                        throw new Exception("网络请求失败");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }




    /**
     * 方法二：采取同步方式获取网络文本  or  下载一个文档
     * 如果要打印文件的相应头应该使用同步的方式去打印
     * Headers responseHeaders = response.headers();
     *for (int i=0;i<responseHeaders.size();i++){
     * Log.e("header",responseHeaders.name(i)+":"+responseHeaders.value(i));
     *}
     * * @param url
     */
    public void run2(String url){

        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()){
                String str = response.body().string();
                Headers responseHeaders = response.headers();
                for (int i=0;i<responseHeaders.size();i++){
                    Log.e("header",responseHeaders.name(i)+":"+responseHeaders.value(i));
                }
                Log.e("请求",response.body().string());
            }
            else {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法一：获取网络图片
     * @param url
     */
    public void getImage(String url){
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()){
                    InputStream inputStream = response.body().byteStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                }
                else{

                }
            }
        });
    }

    /**
     * 方法一：异步post 网络请求
     * @param url
     * @param name
     * @param psw
     */
    public void postRequest(String url,String name,String psw){
        RequestBody requestBody = new FormEncodingBuilder()
                .add("name",name)
                .add("psw",psw)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()){
                    Log.e("post",response.body().string());
                }else{
                    Log.e("post","失败的post");
                }
            }
        });
    }


    /**
     * 方法二：同步post网络请求
     * @param url
     * @param name
     * @param psw
     */
    public void postRequest2(String url,String name,String psw){
        RequestBody requestBody = new FormEncodingBuilder()
                .add("name",name)
                .add("psw",psw)
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        new Thread(){
            @Override
            public void run() {
                Response response = null;
                try {
                    response = okHttpClient.newCall(request).execute();
                    if (response.isSuccessful()){
                        Log.e("post2",response.body().string());
                    }
                    else {
                        Log.e("post2","失败post2");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * 上传文件
     */
    public void putFile(){
        File file = new File(Environment.getExternalStorageDirectory(),"/_5ServiceRecAckFromSdk2.txt");
        final Request request = new Request.Builder()
                .url("http://api.nohttp.net/upload")
                .post(RequestBody.create(MediaType.parse("text/plain"),file)).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Log.e("响应",response.body().string());
            }
        });
    }
    public static List<MyData> getDatas(String URL){
        //用于servlet判别请求，执行相应方法
        String check = "check_regist";
        //模拟发送自定义类型的List数据
        URL url = null;
        URLConnection con = null;
        HttpURLConnection httpUrlConnection = null;
        InputStream inStrm = null;
        ObjectInputStream ois = null;
        OutputStream oStrm  = null;
        List<MyData> datas = new ArrayList<MyData>();
        try
        {
            url = new URL(URL);
            con = url.openConnection();
            httpUrlConnection = (HttpURLConnection) con;
            httpUrlConnection.setUseCaches(false);
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.setDoInput(true);
            httpUrlConnection.setRequestProperty("Content-type",
                    "application/x-java-serialized-object");

            httpUrlConnection.setRequestMethod("POST");
            httpUrlConnection.connect();
            inStrm = httpUrlConnection.getInputStream();
            ois = new ObjectInputStream(inStrm);
            //输出流第一段数据是QuestId的值
            check = (String) ois.readObject();
            Log.e("接收数据",check);
            //第二段数据是List数据
            datas = (List<MyData>) ois.readObject();
            if(datas == null)
                Log.e("请求数据失败","-------");
            else
                Log.e("数据",datas.size()+"");
            for (MyData myData : datas) {
                System.out.println("---------"+myData.getCid() + "===" + myData.getTitle());
            }
            inStrm = httpUrlConnection.getInputStream();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }  finally{

        }
        return datas;
    }




    public interface GetResponse{
        void doSuccess(String str);
        void doError(Request request, IOException e);
    }
}
