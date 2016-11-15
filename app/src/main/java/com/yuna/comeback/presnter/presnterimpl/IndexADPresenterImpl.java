package com.yuna.comeback.presnter.presnterimpl;

import android.os.Handler;
import android.util.Log;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.yuna.comeback.R;
import com.yuna.comeback.hhtp.BaseHttpCallback;
import com.yuna.comeback.hhtp.HttpManager;
import com.yuna.comeback.modle.data.HttpResponse;
import com.yuna.comeback.modle.data.IndexADInfo;
import com.yuna.comeback.presnter.ipresnter.IIndesADPresnter;
import com.yuna.comeback.presnter.iview.IIndexADView;

import java.io.IOException;
import java.net.URI;

/**
 * Created by Administrator on 2016/11/14 0014.
 */

public class IndexADPresenterImpl implements IIndesADPresnter {
    private String TAG = getClass().getSimpleName();
    private IIndexADView mIndexADView;
    private Handler uiHandler = new Handler();
    public IndexADPresenterImpl(IIndexADView view){
        this.mIndexADView = view;
    }
    @Override
    public void showAD() {
        if (mIndexADView!=null && mIndexADView.getADView()!=null){
            mIndexADView.setADreource(R.mipmap.splash);
        }

        HttpManager.getHttpManager().getADInfo(new BaseHttpCallback<IndexADInfo>() {
            @Override
            public void onFinish(HttpResponse<IndexADInfo> response) {
                Log.d(TAG, "onFinish: "+response.toString());
    /*            IndexADInfo adinfo = response.getData();
                if (adinfo != null && adinfo.imagetUrl != null){
                    showADs(adinfo.imagetUrl);
                }*/
            }

            @Override
            public void onError(IOException e) {

            }
        });
    }

    @Override
    public void openAD() {

    }

    private void showADs(final String url){
        uiHandler.post(new Runnable() {
            @Override
            public void run() {
                mIndexADView.setADreource(url);
            }
        });
    }

}
