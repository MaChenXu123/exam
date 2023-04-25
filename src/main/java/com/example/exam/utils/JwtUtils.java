package com.example.exam.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.HashMap;

@Component
public class JwtUtils {

    public String createToken(String username,String password){
        HashMap<String, Object> map = new HashMap<>();
        Calendar instance = Calendar.getInstance();
        // 20秒后令牌token失效
        instance.add(Calendar.SECOND,100);

        String token = JWT.create()
                .withHeader(map) // header可以不写，因为默认值就是它
                .withClaim("username", username)  //payload
                .withClaim("password", password)
                .withExpiresAt(instance.getTime()) // 指定令牌的过期时间
                .sign(Algorithm.HMAC256("MaChenXuPassWord"));//签名
        return token;
    }

    public void getToken(String token){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("MaChenXuPassWord")).build();

        DecodedJWT verify = jwtVerifier.verify(token);
        System.out.println(verify.getClaim("userId"));
        System.out.println(verify.getClaim("username"));
        System.out.println("令牌过期时间："+verify.getExpiresAt());
    }

}
