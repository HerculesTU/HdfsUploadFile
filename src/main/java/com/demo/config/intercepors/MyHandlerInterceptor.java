package com.demo.config.intercepors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author 涂德东
 * Date on 2021/7/3  14:35
 * JavaVersion 1.8
 * @Description 自定义拦截器
 */
@Component
public class MyHandlerInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String name = request.getParameter("name");
        if ("tom".equals(name)) {
            // 如果是tom的请求就拒绝访问
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json; charset=utf-8");
            response.setStatus(403);
            PrintWriter writer = response.getWriter();
            writer.println("禁止访问！");
            return false;

        } else {
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }


}
