package com.education.sdk.entity;

import com.education.sdk.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 老师绑定学科实体类
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeacherSubject extends BaseEntity {

    /**
    * 编号
    */
    private Long id;
    /**
    * 老师编号
    */
    private Long teacherId;
    /**
    * 学科编号
    */
    private Long subjectId;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
