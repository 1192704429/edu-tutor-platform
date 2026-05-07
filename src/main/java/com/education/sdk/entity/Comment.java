package com.education.sdk.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.education.sdk.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
* @description: 评论实体类
* @author: wuming
* @create: 2025.02.18 16:24:07
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment extends BaseEntity {

    /**
    * 评论编号
    */
    private Long id;
    /**
    * 评论内容
    */
    private String content;
    /**
    * 文章编号
    */
    private Long orderId;
    private Long teacherId;
    /**
    * 用户编号
    */
    private Long userId;
    /**
    * 父评论编号
    */
    private Long parentId;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
