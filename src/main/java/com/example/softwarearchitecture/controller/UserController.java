package com.example.softwarearchitecture.controller;

import com.example.softwarearchitecture.dto.Address;
import com.example.softwarearchitecture.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("addresses")
    public Map<String, Object> getAddresses(@RequestAttribute int uid) {
        List<Address> addresses = userService.listAddresses(uid);
        return Map.of("addresses",addresses);
    }
}
