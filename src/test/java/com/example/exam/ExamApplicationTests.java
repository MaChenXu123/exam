package com.example.exam;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.exam.mapper.aExamMapper;
import com.example.exam.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.HashMap;

@SpringBootTest
class ExamApplicationTests {
    @Autowired
    private aExamMapper aExamMapper;
    private String M_token;
    @Test
    void contextLoads() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("测试1","测试1");
        map.put("测试2","测试2");
        Calendar instance = Calendar.getInstance();
        // 20秒后令牌token失效
        instance.add(Calendar.SECOND,100);

        String token = JWT.create()
                .withHeader(map) // header可以不写，因为默认值就是它
                .withClaim("userId", 21)  //payload
                .withClaim("username", "xiaoshuang")
                .withExpiresAt(instance.getTime()) // 指定令牌的过期时间
                .sign(Algorithm.HMAC256("XIAOSHUANG"));//签名
        M_token=token;
        System.out.println(token);
    }


    @Test
    public void test(){
        contextLoads();
        // 通过签名生成验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("XIAOSHUANG")).build();

        DecodedJWT verify = jwtVerifier.verify(M_token);
        System.out.println(verify.getClaim("userId"));
        System.out.println(verify.getClaim("username"));
        System.out.println("令牌过期时间："+verify.getExpiresAt());

    }
    @Autowired
    RedisUtils redisUtils;
    @Test
    public void tempTest(){
        redisUtils.setString("keyM","valueMassdasds");
    }

}
