package com.orangbus.video.common;

import lombok.Data;

import java.util.List;

public class ApiResponsePage<T> {
    private int status;
    private String messge;
    private T data;
    private int total;

    private static final Integer SUCCESS_CODE=200;
    private static final String SUCCESS_MSG="OK";
    private static final Integer TOTAL=0;

    public ApiResponsePage(Integer status, String messge, T data, int total) {
        this.status = status;
        this.messge = messge;
        this.data = data;
        this.total = total;
    }

    public ApiResponsePage(Integer status, String messge,int total) {
        this.status = status;
        this.messge = messge;
        this.total = total;
    }



    public ApiResponsePage(){
        this(SUCCESS_CODE,SUCCESS_MSG,TOTAL);
    }

    public static  <T> ApiResponsePage<T> success(T result,int total, String message,int code){
        ApiResponsePage<T> response = new ApiResponsePage<>();
        response.setData(result);
        response.setTotal(total);
        response.setMessge(message);
        response.setStatus(code);
        return response;
    }

    public static  <T> ApiResponsePage<T> success(T result,int total){
        ApiResponsePage<T> response = new ApiResponsePage<>();
        response.setData(result);
        response.setTotal(total);
        return response;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessge() {
        return messge;
    }

    public void setMessge(String messge) {
        this.messge = messge;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
