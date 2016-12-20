package com.yoflying.drivingschool.utils.json;

import java.io.Serializable;

/**
 * Json统一格式返回
 * Created by arvin on 2016/12/14.
 */
public class JsonResult <T> implements Serializable {
    
    /**
     * 是否成功
     */
    private int status;
    /**
     * 信息
     */
    private String message;
    /**
     * 当前第几页
     */
    private int pageNum;
    /**
     * 总公几页
     */
    private long total;
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

    public JsonResult(int status, String message, T data ) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public JsonResult(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public JsonResult(int status, String message, int pageNum, long total, T data) {
        this.status = status;
        this.message = message;
        this.pageNum = pageNum;
        this.total = total;
        this.data = data;
    }

    public JsonResult(int status) {
        this.status = status;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
