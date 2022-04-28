package com.liuqiang.commons.utils;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author LiuQiang
 * @date 10:31 下午
 */
public class ResultBody<T> implements Serializable {
    private static final long serialVersionUID = -6190689122701100762L;

    protected boolean success = true;

    /**
     * 响应编码
     */
    private Integer code = ReturnCodeUtils.SUCCESS.getCode();

    /**
     * 提示消息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 调用链requestId
     */
    private String requestId;

    /**
     * 响应时间
     */
    private long timestamp = System.currentTimeMillis();

    public ResultBody() {
        this.requestId = UUID.randomUUID().toString().trim().replaceAll("-", "");
    }

    public boolean isSuccess() {
        return success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getRequestId() {
        return requestId;
    }

    public ResultBody(T data, boolean success) {
        this.success = success;
        this.code = ReturnCodeUtils.SUCCESS.getCode();
        this.message = ReturnCodeUtils.SUCCESS.getMessage();
        this.data = data;
        this.requestId = UUID.randomUUID().toString();
    }

    public ResultBody(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> ResultBody<T> ok(T data) {
        return new ResultBody<>(data, true);
    }

    public static <T> ResultBody<T> ok() {
        return new ResultBody<>(null, true);
    }

    public static <T> ResultBody<T> fail(Integer errorCode, String errorMsg) {
        ResultBody<T> resp = new ResultBody<T>();
        resp.setCode(errorCode);
        resp.setMessage(errorMsg);
        return resp;
    }

    public static <T> ResultBody<T> ok(String message, T data) {
        ResultBody<T> resp = new ResultBody<T>();
        resp.setCode(ReturnCodeUtils.SUCCESS.getCode());
        resp.setMessage(message);
        resp.setData(data);
        return resp;
    }

    public static <T> ResultBody<T> ok(String message) {
        ResultBody<T> resp = new ResultBody<T>();
        resp.setCode(ReturnCodeUtils.SUCCESS.getCode());
        resp.setMessage(message);
        return resp;
    }


    public static <T> ResultBody<T> fail(String message, T data) {
        ResultBody<T> resp = new ResultBody<>();
        resp.setCode(-1);
        resp.setMessage(message);
        resp.setData(data);
        return resp;
    }

    public static <T> ResultBody<T> fail() {
        ResultBody<T> resp = new ResultBody<T>();
        resp.setCode(HttpStatus.BAD_REQUEST.value());
        resp.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        return resp;
    }


    public static <T> ResultBody<T> result(boolean success, T message) {
        ResultBody<T> resp = new ResultBody<T>();
        resp.success = success;
        resp.setData( message);
        return resp;
    }

    public ResultBody<T> code(Integer code) {
        this.code = code;
        return this;
    }

    public ResultBody<T> data(T data) {
        this.data = data;
        return this;
    }

    public ResultBody<T> requestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    @Override
    public String toString() {
        return "ResultBody{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", requestId=" + requestId +
                ", timestamp=" + timestamp +
                '}';
    }


}
