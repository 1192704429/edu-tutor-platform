package com.education.sdk.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.education.sdk.entity.Message;
import lombok.Data;
import lombok.ToString;

/**
* @description: 聊天数据传输层
* @author: wuming
* @create: 2025.02.22 10:30:14
*/
@Data
@ToString
@TableName("message")
public class MessageDTO extends Message {

    /**
    * 学生姓名
    */
    @TableField(exist = false)
    private String stuName;
    /**
    * 照片
    */
    @TableField(exist = false)
    private String stuImg;
    /**
    * 老师姓名
    */
    @TableField(exist = false)
    private String teaName;
    /**
    * 头像
    */
    @TableField(exist = false)
    private String teaImg;

}
