package com.shop.mall.exception;

import lombok.Data;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class MyException extends RuntimeException{

    private Integer code;

    //private String msg;￿

    public MyException(){}

//    public MyException(Integer code, String msg)
    public MyException(Integer code)
    {
        this.code = code;
       // this.msg = msg;
    }
}