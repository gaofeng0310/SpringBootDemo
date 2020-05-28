package com.xnpool.gaogtest.entity;

/**
 * 返回json数据
 */


import java.io.Serializable;
import java.util.Map;

public class ResponseResult<T> implements Serializable {
    public static final Integer SUCCESS = 200;
    public static final Integer FALSE = 500;
    /**
     *
     */
    private static final long serialVersionUID = -1626793180717240861L;
    private Integer status;
    private String message;
    private T data;
    private Map<String,Object> ext;
    private T accesstoken;
    public ResponseResult() {
        super();
    }

    public ResponseResult(Integer status) {
        super();
        setStatus(status);
    }



    public ResponseResult(Integer status, String message) {
        this(status);
        setMessage(message);
    }

    public ResponseResult(Integer status, String message, T data) {
        this(status,message);
        setData(data);
    }
    public ResponseResult(Integer status, Exception e) {
        this(status, e.getMessage());
    }



    public ResponseResult(Integer status, T data) {
        this(status);
        setData(data);
    }

    public ResponseResult(Integer status, T data, Map<String, Object> ext) {
        this(status,data);
        setExt(ext);
    }
    public ResponseResult(Integer status, T data, T accesstoken) {
        this(status,data);
        setAccesstoken(accesstoken);
    }

    public ResponseResult(Integer status, String message, T data, T accesstoken) {
        this(status,message,data);
        setAccesstoken(accesstoken);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Map<String, Object> getExt() {
        return ext;
    }

    public void setExt(Map<String, Object> ext) {
        this.ext = ext;
    }

    public T getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(T accesstoken) {
        this.accesstoken = accesstoken;
    }
}
