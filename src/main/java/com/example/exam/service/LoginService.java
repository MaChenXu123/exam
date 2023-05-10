package com.example.exam.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.exam.dao.User;
import com.example.exam.mapper.UserMapper;
import com.example.exam.utils.JwtUtils;
import com.example.exam.utils.R;
import com.example.exam.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private UserMapper userMapper;

    public R Login(String username, String passWord) {
        try {
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.eq("userName", username);
            List<User> users = userMapper.selectList(userQueryWrapper);
            for (User user : users) {
                if (user.getIdCard().equals(passWord)) {
                    String token = jwtUtils.createToken(username, passWord);
                    redisUtils.setString(token,passWord);
                    return R.success(token);
                }
            }
        } catch (Exception e) {
            return R.error("Login错误");
        }
        return R.error("登录错误");
    }
}
