package com.shop.mall.config;

import com.shop.mall.anno.ResultAnno;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {

    /**
     * 标记名称
     */
    public static final String RESPONSE_RESULT_TYPE = "RESULT-ANNO";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
       if(handler instanceof HandlerMethod)
       {
           final HandlerMethod handlerMethod = (HandlerMethod) handler;
           final Class<?> clazz = handlerMethod.getBeanType();
           final Method method = handlerMethod.getMethod();
           //判断是否在类上加的注解
           if(clazz.isAnnotationPresent(ResultAnno.class))
               //设置此请求返回体，需包装，向下传递，在responseBodyAdvice中判断
               request.setAttribute(RESPONSE_RESULT_TYPE,clazz.getAnnotation(ResultAnno.class));
           else if(method.isAnnotationPresent(ResultAnno.class))
               request.setAttribute(RESPONSE_RESULT_TYPE,method.getAnnotation(ResultAnno.class));
       }

        return true;
    }
}
