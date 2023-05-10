package com.example.exam.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.exam.dao.Global;
import com.example.exam.dao.aExam;
import com.example.exam.dao.aSelect;
import com.example.exam.dao.temp.aExamTemp;
import com.example.exam.mapper.aExamMapper;
import com.example.exam.utils.ClassUtils;
import com.example.exam.utils.R;
import com.example.exam.utils.RedisUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class aExamService {
    @Autowired
    private aExamMapper aExamMapper;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    private ClassUtils classUtils;
    public R getExam(int examNum) {
        // exam的标识key 用来存如redis的key
        Integer examNumberKey = (examNum / 10 + 1) * 10;
        //用来下面循环用
        Integer temp = examNumberKey - 10 + 1;

        //存储获取到的exam的数组
        List<aExamTemp> examList = new ArrayList<>();
//        循环看看是否已经被缓存了 先判断一下全局aExamList是否为空
        if (Global.aExamList.size() > 0) {
            for (int i = 0; i <= Global.aExamList.size(); i++) {
                //如果已经缓存了 就直接从缓存中读取
                if (examNumberKey == Global.aExamList.get(i)) {
//                    读取缓存的数据
                    String JsonExam = redisUtils.getString(Integer.toString(examNumberKey));
                    if (JsonExam==null){
                        System.out.println("缓存失效 再取一次");
                        setRedisExam(examNumberKey,temp);
                    }
                    JsonExam = redisUtils.getString(Integer.toString(examNumberKey));
                    List list = JSON.parseObject(JsonExam, List.class);
                    return R.success(list);
                }
            }
        }
        while (examNumberKey >= temp) {
            QueryWrapper<aExam> objectQueryWrapper = new QueryWrapper<>();
            objectQueryWrapper.eq("examNum", temp);
            aExam aExam = aExamMapper.selectOne(objectQueryWrapper);
            temp++;
            if (aExam == null) {
                break;
            }
            aExamTemp aExamTemp = classUtils.aExamAndaEx10amTemp(aExam);
            // 把正确的选项变为0 不让前端获取到
            aExam.setRightSelectID(0);
            examList.add(aExamTemp);
        }
        Global.aExamList.add(examNumberKey);
        redisUtils.setString(String.valueOf(examNumberKey), JSON.toJSONString(examList));
        return R.success(examList);
    }


    public void setRedisExam( int examNumberKey,int temp ){
        //存储获取到的exam的数组
        List<aExam> examList = new ArrayList<>();
        while (examNumberKey >= temp) {
            QueryWrapper<aExam> objectQueryWrapper = new QueryWrapper<>();
            objectQueryWrapper.eq("examNum", temp);
            aExam aExam = aExamMapper.selectOne(objectQueryWrapper);
            temp++;
            if (aExam == null) {
                continue;
            }
            // 把正确的选项变为0 不让前端获取到
            aExam.setRightSelectID(0);
            examList.add(aExam);
        }
        redisUtils.setString(String.valueOf(examNumberKey), JSON.toJSONString(examList));
    }




}
