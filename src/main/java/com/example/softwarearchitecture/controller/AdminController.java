package com.example.softwarearchitecture.controller;


import com.example.softwarearchitecture.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {

    private  final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("users/{uid}")
    public Map<String, Object> getUser(@PathVariable int uid) {
        return Map.of("user",userService.getUser(uid));
    }

}
