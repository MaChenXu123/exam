package com.example.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.exam.dao.Paper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaperMapper extends BaseMapper<Paper> {
}
