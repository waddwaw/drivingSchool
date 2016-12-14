package com.yoflying.drivingschool.utils.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Json统一格式返回
 * Created by arvin on 2016/12/14.
 */
public class JsonResult <T> implements Serializable {
    private final Logger logger = LoggerFactory.getLogger(JsonResult.class);
    /**
     * 是否成功
     */
    private int status;
    /**
     * 信息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public JsonResult(T data, String message, int status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public JsonResult(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public JsonResult(int status) {
        this.status = status;
    }
}
