package com.example.exam.service;

import com.example.exam.dao.aExam;
import com.example.exam.mapper.aExamMapper;
import com.example.exam.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class aExamService {
    @Autowired
    private aExamMapper aExamMapper;
    public R getExam() {
        aExam aExam = aExamMapper.selectById(1);
        System.out.println(aExam);
        return R.success(aExam);
    }
}
