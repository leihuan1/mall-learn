package com.shop.mall.tdo;

public enum ResultEnum {

    OK(0,"ok"),
    FAIL(1,"fail")
    ;


    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer code() {
        return code;
    }

    public String msg(){
        return msg;
    }
}
