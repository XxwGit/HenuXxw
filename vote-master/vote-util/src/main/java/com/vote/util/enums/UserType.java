package com.vote.util.enums;

/**
 * 用户类型
 */
public enum UserType {

    普通用户(0,"CUSTOMER"),
    特权用户(1,"VIP"),
    管理员(2,"ADMIN");

    private int code;
    private String value;

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    UserType(int code, String value){
        this.code = code;
        this.value = value;

    }
}
