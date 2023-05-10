package com.example.exam.service;

import com.example.exam.dao.Paper;
import com.example.exam.mapper.PaperMapper;
import com.example.exam.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperService {

    @Autowired
    PaperMapper paperMapper;
    public R getPaperList(){
        List<Paper> papers = paperMapper.selectList(null);
        return R.success(papers);
    }
}
