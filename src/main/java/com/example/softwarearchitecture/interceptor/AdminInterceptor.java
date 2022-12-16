package com.example.softwarearchitecture.interceptor;

import com.example.softwarearchitecture.dto.User;
import com.example.softwarearchitecture.exception.XException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        int role = (int) request.getAttribute("role");
        if(role != User.ADMIN) {
            throw new XException("无权限");
        }
        return true;
    }
}
