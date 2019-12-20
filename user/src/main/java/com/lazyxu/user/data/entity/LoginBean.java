package com.lazyxu.user.data.entity;


import com.lazyxu.user.data.entity.db.User;

public class LoginBean {


    @Override
    public String toString() {
        return "LoginBean{" +
                "loginData=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    private User data;
    private int errorCode;
    private String errorMsg;

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
