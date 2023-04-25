package com.example.exam.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.exam.dao.User;
import com.example.exam.mapper.UserMapper;
import com.example.exam.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    public R Login(String username,String passWord){
        try {
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.eq("userName",username);
            User user = userMapper.selectOne(userQueryWrapper);
            System.out.println(user);
            if (user.getIdCard().equals(passWord)){

                return R.success("登陆成功");
            }else {
                return R.error("密码错误");
            }
        }catch (Exception e) {
            return R.error("Login错误");
        }
    }
}
