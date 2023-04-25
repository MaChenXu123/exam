package com.example.exam.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableId
    private int id;

    @TableField("userName")
    private String userName;


    @TableField("userPhone")
    private Long userPhone;

    @TableField("idCard")
    private String idCard;
}
