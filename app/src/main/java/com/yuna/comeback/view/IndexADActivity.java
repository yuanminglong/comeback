package com.yuna.comeback.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuna.comeback.R;
import com.yuna.comeback.app.BaseActivity;
import com.yuna.comeback.presnter.ipresnter.IIndesADPresnter;
import com.yuna.comeback.presnter.iview.IIndexADView;
import com.yuna.comeback.presnter.presnterimpl.IndexADPresenterImpl;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class IndexADActivity extends BaseActivity implements IIndexADView,View.OnClickListener{
    private ImageView mADView;
    private TextView mTime;
    private IIndesADPresnter mPresnter;

    protected void setOverTime(String content) {
        if (mTime != null) {
            mTime.setText(content);
        }
    }
    private Runnable setTimeRunnable = new Runnable() {
        private int mOverTime = 3;
        @Override
        public void run() {
            if (mOverTime>0){
                setOverTime("跳过广告"+mOverTime);
                mOverTime--;
                mTime.postDelayed(this,1000);
            }else {
                enterApp(null);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_index_ad);
        mADView = (ImageView) findViewById(R.id.iv_index_ad);
        mTime = (TextView) findViewById(R.id.tv_over_time);
        mTime.post(setTimeRunnable);
        mPresnter = new IndexADPresenterImpl(this);
        mPresnter.showAD();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    protected void enterApp(View view) {

        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }


    @Override
    protected void onDestroy() {
        mTime.removeCallbacks(setTimeRunnable);
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_index_ad:
                mPresnter.openAD();
                break;
            case R.id.tv_over_time:
                enterApp(null);
                break;
            default:
                break;
        }
    }

    @Override
    public void setADReource(Drawable drawable) {
        mADView.setImageDrawable(drawable);
    }

    @Override
    public void setADReource(Bitmap bitmap) {
        mADView.setImageBitmap(bitmap);
    }

    @Override
    public void setADreource(int reInt) {
        mADView.setImageResource(reInt);
    }

    @Override
    public void setADreource(Uri uri) {
        mADView.setImageURI(uri);
    }
}
