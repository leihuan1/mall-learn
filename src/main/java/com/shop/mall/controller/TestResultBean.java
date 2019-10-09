package com.shop.mall.controller;

import com.shop.mall.tdo.ResultBean;
import com.shop.mall.tdo.ResultEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResultBean {

    @GetMapping("/show")
    public ResultBean test1()throws Exception
    {
        return new ResultBean(ResultEnum.OK);
    }

    @GetMapping("/show2")
    public ResponseEntity test2()throws Exception
    {
        return new ResponseEntity(HttpStatus.OK);
    }
}
