package com.shop.mall.tdo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultBean<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;

    public ResultBean() {
    }

    public ResultBean(ResultEnum resultEnum) {
        this.code = resultEnum.code();
        this.msg = resultEnum.msg();
    }

    public ResultBean(ResultEnum resultEnum,T data) {
        this.code = resultEnum.code();
        this.msg = resultEnum.msg();
        this.data = data;
    }
}
