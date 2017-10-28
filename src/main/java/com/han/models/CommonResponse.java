package com.han.models;

/**
 * Created by high on 2017. 10. 26..
 */
/*
반환 해줄때 사용자의 편리성을 위해 만들어 놓은 클래스입니다
 */
public class CommonResponse<T> {
    public final static String fail = "fail";

    private String status = "success";
    private String msg;
    private T data;

    public CommonResponse() {}

    public CommonResponse(String status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public CommonResponse(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public CommonResponse(T data) {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
