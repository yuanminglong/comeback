package com.yuna.comeback.modle;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/14 0014.
 */

public class BaseRequest implements Serializable {
    public static String mac;
    public static String appversion;
    public Object data;
    public BaseRequest(Object data){
        this.data = data;
    }
    public BaseRequest(){
    }
}
