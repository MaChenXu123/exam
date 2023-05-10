package com.example.exam.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("aselect")
public class aSelect {

    //唯一id
    @TableField("id")
    private int id;

    // 对应哪一题的选择题Id
    @TableField("topicId")
    private int topicId;


    // 选项的内容
    @TableField("selectValue")
    private String selectValue;

    // 是否正确
    @TableField("ifRight")
    private int ifRight;

    //是否点击 不枉数据库中存 只拿来比较
    @TableField("ifClick")
    private int ifClick;

    // 是第几个选项
    @TableField("originalTitleNumber")
    private int originalTitleNumber;

}
