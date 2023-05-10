package com.example.exam.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (request.getMethod().equals("OPTIONS")){
            return true;
        }
        String token = request.getHeader("token");
        if (token==null){
            System.out.println("未登录");
            return false;
        }
        //中间写逻辑代码，比如判断是否登录成功，失败则返回false
        return true;
    }

}