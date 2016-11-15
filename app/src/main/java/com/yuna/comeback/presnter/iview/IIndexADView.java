package com.yuna.comeback.presnter.iview;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/11/14 0014.
 */

public interface IIndexADView {
    void setADReource(Drawable drawable);
    void setADReource(Bitmap bitmap);
    void setADreource(int reInt);
    void setADreource(Uri uri);
    void setADreource(String utl);
    ImageView getADView();
}
