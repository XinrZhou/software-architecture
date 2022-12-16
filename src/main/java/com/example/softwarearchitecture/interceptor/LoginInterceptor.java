package com.example.softwarearchitecture.interceptor;

import com.example.softwarearchitecture.exception.XException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getHeader("uid") == null && request.getHeader("role") == null){
            throw new XException("未登录");
        }
        int uid = Integer.parseInt(request.getHeader("uid"));
        int role = Integer.parseInt(request.getHeader("role"));

        request.setAttribute("uid", uid);
        request.setAttribute("role",role);
        return true;
    }
}
