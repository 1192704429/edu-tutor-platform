package com.education.sdk.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.education.sdk.entity. Teacher;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @description: 教师管理数据传输层
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@Data
@ToString
@TableName("teacher")
public class TeacherDTO extends Teacher {

    /**
    * 方式名称
    */
    @TableField(exist = false)
    private String typeName;

    @TableField(exist = false)
    private String ids;


}
