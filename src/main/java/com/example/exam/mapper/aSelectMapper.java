package com.example.exam.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.exam.dao.aExam;
import com.example.exam.dao.aSelect;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public  interface aSelectMapper extends BaseMapper<aSelect> {
}
