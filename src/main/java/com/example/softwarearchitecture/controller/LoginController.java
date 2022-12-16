package com.example.softwarearchitecture.controller;

import com.example.softwarearchitecture.dto.User;
import com.example.softwarearchitecture.exception.XException;
import com.example.softwarearchitecture.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/")
public class LoginController {
    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    public Map<String, Object> login(@RequestBody User user, HttpServletResponse response) {
        User u = userService.getUser(user.getAccount(), user.getPassword()) ;
        if(u == null) {
            throw new XException("用户不存在");
        }

        response.setHeader("uid", u.getId().toString());
        response.setHeader("role", u.getRole().toString());

        return Map.of();
    }
}
