package com.yuna.comeback.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import com.yuna.comeback.R;
import com.yuna.comeback.app.BaseActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class IndexADActivity extends BaseActivity {
    private ImageView mADView;
    private TextView mTime;
    private Runnable mSetOverTime = new Runnable() {
        private int mTimes = 3;

        @Override
        public void run() {
            if (mTimes >= 0) {
                setOverTime("跳过广告" + mTimes);
                mTimes--;
                mTime.postDelayed(mSetOverTime, 1000);
            } else {
                //enterApp(null);
            }
        }
    };

    protected void setOverTime(String content) {
        if (mTime != null) {
            mTime.setText(content);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_index_ad);
        mADView = (ImageView) findViewById(R.id.iv_index_ad);
        mADView.setImageResource(R.mipmap.splash);
        mTime = (TextView) findViewById(R.id.tv_over_time);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://192.168.0.101/Comeback/index").tag("get").build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mTime.post(mSetOverTime);
    }

    protected void enterApp(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    @Override
    public void finish() {
        mTime.removeCallbacks(mSetOverTime);
        super.finish();
    }

    @Override
    protected void onDestroy() {
        mTime.removeCallbacks(mSetOverTime);
        super.onDestroy();
    }
}