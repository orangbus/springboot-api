package com.orangbus.video.common;



public class ApiResponse<T> {

    private Integer status;
    private String msg;
    private T data;

    private static final int SUCCESS_CODE=200;
    private static final String SUCCESS_MSG="success";

    private static final int ERROR_CODE=202;
    private static final String ERROR_MSG="error";

    /**
     * 构造函数
     * @param status
     * @param msg
     * @param data
     */
    public ApiResponse (Integer status,String msg,T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ApiResponse(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    /**
     * 两个参数的构造
     */
    public ApiResponse(){
        this(SUCCESS_CODE,SUCCESS_MSG);
    }

    /**
     * 成功返回
     */
    public static <T> ApiResponse<T> success(){
        return new ApiResponse<>();
    }

    public static <T> ApiResponse<T> success(String message){
        ApiResponse<T> response = new ApiResponse<>();
        response.setMsg(message);
        return response;
    }

    public static <T> ApiResponse<T> success(String message,int code){
        ApiResponse<T> response = new ApiResponse<>();
        response.setMsg(message);
        response.setStatus(code);
        return response;
    }

    public static <T> ApiResponse<T> success(T result){
        ApiResponse<T> response = new ApiResponse<>();
        response.setData(result);
        return response;
    }

    /**
     * 失败返回
     */
    public static <T> ApiResponse<T> error(){
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatus(ERROR_CODE);
        response.setMsg(ERROR_MSG);
        return response;
    }

    public static <T> ApiResponse<T> error(String message){
        ApiResponse<T> response = new ApiResponse<>();
        response.setMsg(message);
        response.setStatus(ERROR_CODE);
        return response;
    }

    /**
     * 返回分页结果集合
     * @return
     */
//    public static <T> ApiResponse<T> resData(T result,int total){
//        ApiResponse<T> response = new ApiResponse<>();
//    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
