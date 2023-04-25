package com.example.exam.service;


import com.example.exam.dao.User;
import com.example.exam.mapper.UserMapper;
import com.example.exam.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public R getUser(){
        User user = userMapper.selectById(1);

        return R.success(user);
    }
}
