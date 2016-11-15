package com.yuna.comeback.hhtp;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.yuna.comeback.modle.data.HttpResponse;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/11/15 0015.
 */

public abstract class BaseHttpCallback <T> implements Callback {
    private HttpResponse<T> httpResponse ;//= new HttpResponse();
    @Override
    public void onFailure(Call call, IOException e) {
        onError(e);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        Gson gson = new Gson();
        httpResponse = gson.fromJson(response.body().string(),HttpResponse.class);
        Log.d("HttpManager", "onResponse: "+httpResponse.toString());
        onFinish(httpResponse);
    }
    public abstract void onFinish(HttpResponse<T> response);
    public abstract void onError(IOException e);
}
