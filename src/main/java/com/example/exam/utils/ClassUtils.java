package com.example.exam.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.exam.dao.aExam;
import com.example.exam.dao.aSelect;
import com.example.exam.dao.temp.aExamTemp;
import com.example.exam.mapper.aSelectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ClassUtils {

    @Autowired
    private aSelectMapper aSelectmapper;
    public aExamTemp aExamAndaEx10amTemp(aExam aexam ) {
        aExamTemp aExamTemp = new aExamTemp();
        aExamTemp.setExamNum(aexam.getExamNum());
        aExamTemp.setId(aexam.getId());
        aExamTemp.setPaperId(aexam.getPaperId());
        aExamTemp.setTopic(aexam.getTopic());
        aExamTemp.setRightSelectID(aexam.getRightSelectID());
        aExamTemp.setOneAndMore(aexam.getOneAndMore());
        aExamTemp.setSelectID(aexam.getSelectID());


        QueryWrapper<aSelect> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("topicId", aexam.getId());
        List<aSelect> aSelects = aSelectmapper.selectList(objectQueryWrapper);
        for (int i = 0; i <aSelects.size() ; i++) {
            aSelects.get(i).setIfClick(0);
        }
        aExamTemp.setSelectArray(aSelects);

        return aExamTemp;
    }

}
