package com.shop.mall.tdo;

import com.shop.mall.exception.MyException;

import java.io.Serializable;

public class Response implements Serializable {

    /**
     * 成功
     */
    public static ResultBean successs()
    {
        ResultBean res = new ResultBean();
        res.setCode(ResultEnum.OK.code());
        res.setMsg(ResultEnum.OK.msg());
        return res;
    }

    /**
     * 成功
     */
    public static<T> ResultBean<T> successs(T data)
    {
        ResultBean res = new ResultBean();
        res.setCode(ResultEnum.OK.code());
        res.setMsg(ResultEnum.OK.msg());
        res.setData(data);
        return res;
    }

    /**
     * 失败
     */
    public static ResultBean failure()
    {
        ResultBean res = new ResultBean();
        res.setCode(ResultEnum.OK.code());
        res.setMsg(ResultEnum.OK.msg());
        return res;
    }

    /**
     * 失败
     */
    public static ResultBean failure(MyException e)
    {
        ResultBean res = new ResultBean();
        res.setCode(e.getCode());
//        res.setMsg(e.getMsg());
        return res;
    }
}
