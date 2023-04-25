package com.example.exam.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("aexam")
public class aExam {

    //唯一id
    @TableId
    private int id;

    //是单选还是多选
    @TableField("oneAndMore")
    private int oneAndMore;

    // 题目内容
    @TableField("topic")
    private String topic;

    //试卷对应的题目
    @TableField("examNum")
    private int examNum;

    //第几套试卷
    @TableField("paperId")
    private int paperId;

    // 对应的选择id
    @TableField("selectID")
    private int selectID;

    //正确的选项
    @TableField("rightSelectID")
    private int rightSelectID;

}
