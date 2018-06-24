package com.example.demo.pojo;

/*
 * 定义Response返回结构
 * */
public class ResponseModel {
    private String status;

    private Object result = null;

    public ResponseModel() {
        this.status = "fail";
    }

    public ResponseModel(String status, Object result) {
        this.status = status;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
