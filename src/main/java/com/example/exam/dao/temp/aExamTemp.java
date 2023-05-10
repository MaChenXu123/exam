package com.example.exam.dao.temp;

import com.example.exam.dao.aSelect;
import lombok.Data;

import java.util.List;

@Data
public class aExamTemp {
    //唯一id
    private int id;

    //是单选还是多选
    private int oneAndMore;

    // 题目内容
    private String topic;

    //试卷对应的题目
    private int examNum;


    //第几套试卷
    private int paperId;

    // 对应的选择id
    private int selectID;

    private List<aSelect> selectArray;

    //正确的选项
    private int rightSelectID;
}
