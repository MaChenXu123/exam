package com.example.exam;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.exam.dao.Paper;
import com.example.exam.dao.aExam;
import com.example.exam.mapper.PaperMapper;
import com.example.exam.mapper.aExamMapper;
import com.example.exam.temp.CountDown;
import com.example.exam.temp.CountdownThread;
import com.example.exam.temp.InterruptThread;
import com.example.exam.utils.RedisUtils;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class ExamApplicationTests {
    @Autowired
    private aExamMapper aExamMapper;
    private String M_token;
    public  static List<Integer> aaExamList;
    @Test
    void contextLoads() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("测试1", "测试1");
        map.put("测试2", "测试2");
        Calendar instance = Calendar.getInstance();
        // 20秒后令牌token失效
        instance.add(Calendar.SECOND, 100);

        String token = JWT.create()
                .withHeader(map) // header可以不写，因为默认值就是它
                .withClaim("userId", 21)  //payload
                .withClaim("username", "xiaoshuang")
                .withExpiresAt(instance.getTime()) // 指定令牌的过期时间
                .sign(Algorithm.HMAC256("XIAOSHUANG"));//签名
        M_token = token;
        System.out.println(token);
    }


    @Test
    public void test() {
        contextLoads();
        // 通过签名生成验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("XIAOSHUANG")).build();

        DecodedJWT verify = jwtVerifier.verify(M_token);
        System.out.println(verify.getClaim("userId"));
        System.out.println(verify.getClaim("username"));
        System.out.println("令牌过期时间：" + verify.getExpiresAt());

    }

    @Autowired
    RedisUtils redisUtils;

    @Test
    public void tempTest() {
      int[] arr = new int[10];
      arr[0]=1;
        System.out.println(arr.length);
    }
    @Autowired
    PaperMapper paperMapper;
    @Test
    public void Time() {
        List<Paper> papers = paperMapper.selectList(null);
        System.out.println(papers);
    }
    @Test
    public void aaaa() throws InterruptedException {
        CountdownThread countdownThread = new CountdownThread(10);
        Thread t1 = new Thread(countdownThread);

        InterruptThread interruptThread = new InterruptThread(t1);
        Thread t2 = new Thread(interruptThread);

        t1.start();
        t2.start();

        // Wait for threads to finish
        t1.join();
        t2.join();
    }


    @Test
    public  void aaaaa() throws InterruptedException {
        CountDown countDown = new CountDown(20);
        Thread thread = new Thread(countDown);

        Thread thread1 = new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(5000);
                thread.interrupt();
            }
        };
        thread.start();
        thread1.start();

        thread.join();
        thread1.join();
        System.out.println("看看执行的位置");


    }

}

