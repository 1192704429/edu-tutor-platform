package com.education.sdk.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.education.sdk.entity.TeacherSubject;
import lombok.Data;
import lombok.ToString;

/**
 * @description: 老师绑定学科数据传输层
 * @author: wuming
 * @create: 2025.02.28 10:20:21
 */
@Data
@ToString
@TableName("teacher_subject")
public class TeacherSubjectDTO extends TeacherSubject {

    @TableField(exist = false)
    private String subjectName;

}
