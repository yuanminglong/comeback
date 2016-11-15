package com.yuna.comeback.hhtp;

import com.yuna.comeback.modle.data.HttpResponse;

import java.io.IOException;

import okhttp3.Callback;

/**
 * Created by Administrator on 2016/11/15 0015.
 */

public interface OnHttpCallback<T> extends Callback{
    void onFinish(HttpResponse<T> response);
    void onError(IOException e);
}
