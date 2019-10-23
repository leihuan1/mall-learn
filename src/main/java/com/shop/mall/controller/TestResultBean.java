package com.shop.mall.controller;

import com.shop.mall.anno.ResultAnno;
import com.shop.mall.dto.ResultBean;
import com.shop.mall.dto.ResultEnum;
import com.shop.mall.exception.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TestResultBean {

    @GetMapping("/show")
    public ResultBean test1()throws Exception
    {
        return new ResultBean(ResultEnum.OK,"初次使用docker构建Springboot项目");
    }

    @GetMapping("/show2")
    public ResponseEntity test2()throws Exception
    {
        return new ResponseEntity(HttpStatus.OK);
    }

    @ResultAnno
    @GetMapping("/show3")
    public String test3()throws Exception
    {
        String str = "测试";
        return str;
    }

    @ResultAnno
    @GetMapping("/show4")
    public String test4()throws MyException
    {
        String str = "测试";
        if(Optional.ofNullable(str).isPresent())
        {
            throw new MyException(204);
        }
        return str;
    }
}
