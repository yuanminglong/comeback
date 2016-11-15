package com.yuna.comeback.presnter.presnterimpl;

import com.yuna.comeback.R;
import com.yuna.comeback.hhtp.HttpManager;
import com.yuna.comeback.presnter.ipresnter.IIndesADPresnter;
import com.yuna.comeback.presnter.iview.IIndexADView;

/**
 * Created by Administrator on 2016/11/14 0014.
 */

public class IndexADPresenterImpl implements IIndesADPresnter {
    private IIndexADView mIndexADView;
    public IndexADPresenterImpl(IIndexADView view){
        this.mIndexADView = view;
    }
    @Override
    public void showAD() {
        mIndexADView.setADreource(R.mipmap.splash);
        HttpManager.getHttpManager().getADInfo();
    }

    @Override
    public void openAD() {

    }



}
