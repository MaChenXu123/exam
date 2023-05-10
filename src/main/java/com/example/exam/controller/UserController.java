package com.example.exam.controller;

import com.example.exam.service.UserService;
import com.example.exam.utils.R;
import com.example.exam.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("getUser")
    public R getUser() {
        return userService.getUser();
    }
}
