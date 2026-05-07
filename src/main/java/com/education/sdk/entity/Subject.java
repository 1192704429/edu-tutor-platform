package com.education.sdk.entity;

import com.education.sdk.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 学科管理实体类
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Subject extends BaseEntity {

    /**
    * 学科编号
    */
    private Long id;
    /**
    * 学科名称
    */
    private String subjectName;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
