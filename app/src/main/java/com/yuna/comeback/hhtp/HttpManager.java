package com.yuna.comeback.hhtp;

import android.util.Log;

import com.yuna.comeback.modle.data.IndexADInfo;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/11/9 0009.
 */

public class HttpManager {
    private OkHttpClient client = new OkHttpClient();
    private static HttpManager instance;
    private HttpManager(){

    }
    public static HttpManager getHttpManager(){
        if (instance==null){
            instance = new HttpManager();
        }
        return instance;
    }

    public String getADInfo(Callback lisener){
        Request request = new Request.Builder().url("http://192.168.0.104/Comeback/index").build();
        Call call = client.newCall(request);
        call.enqueue(lisener);
        return null;
    }
}
