package com.example.exam.controller;

import com.example.exam.service.LoginService;
import com.example.exam.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("Login")
    private R Login(@RequestBody Map<String ,String> map){
        System.out.println(map);
        System.out.println("请求到了Login");
        return loginService.Login(map.get("userName"), map.get("passWord"));
    }
}
