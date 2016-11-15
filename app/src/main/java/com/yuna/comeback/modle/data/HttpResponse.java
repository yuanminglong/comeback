package com.yuna.comeback.modle.data;

/**
 * Created by Administrator on 2016/11/15 0015.
 */

public class HttpResponse<T> {

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String code;
    public String msg;
    public String status;
    public T data;

    @Override
    public String toString() {
        return "code:"+code+" msg:"+msg+" status:"+status+" data:"+data;
    }
}
