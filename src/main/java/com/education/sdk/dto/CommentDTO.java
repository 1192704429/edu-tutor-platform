package com.education.sdk.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.education.sdk.entity.Comment;
import lombok.Data;
import lombok.ToString;

/**
 * @description: 评论数据传输层
 * @author: wuming
 * @create: 2025.02.18 16:24:07
 */
@Data
@ToString
@TableName("comment")
public class CommentDTO extends Comment {

    /**
     * 用户昵称
     */
    @TableField(exist = false)
    private String nickName;
    /**
     * 用户编号
     */
    @TableField(exist = false)
    private String avatar;

    /**
     * 老师姓名
     */
    @TableField(exist = false)
    private String name;

    /**
     * 老师头像
     */
    @TableField(exist = false)
    private String headImg;

    @TableField(exist = false)
    private Long teacherIds;

    @TableField(exist = false)
    private String orderIds;


}
