package com.shop.mall.config;

import com.shop.mall.anno.ResultAnno;
import com.shop.mall.exception.MyException;
import com.shop.mall.tdo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice {

    /**
     * 标记名称
     */
    public static final String RESPONSE_RESULT_TYPE = "RESULT-ANNO";

    /**
     * 是否包含包装注解，没有的直接返回
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class clazz)
    {
        ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        //判断request中是否有标识
        ResultAnno resultAnno = (ResultAnno) request.getAttribute(RESPONSE_RESULT_TYPE);
        return resultAnno == null ? false : true;
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter methodParameter, MediaType mediaType,
                                  Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse)
    {
        log.info("注解处理返回值");
        if (data instanceof MyException) {
            log.error("出现 MyException 异常");
            return Response.failure((MyException) data);
        } else if(data instanceof Exception) {
            log.error("出现 Exception 异常");
            return Response.failure();
        }
        return Response.successs(data);
    }
}
