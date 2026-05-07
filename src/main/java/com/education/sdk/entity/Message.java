package com.education.sdk.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.education.sdk.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
/**
* @description: 聊天实体类
* @author: wuming
* @create: 2025.02.22 10:30:14
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message extends BaseEntity {

    /**
    * 消息ID
    */
    private Long id;
    /**
    * 发送用户ID
    */
    private Long sendUserId;
    /**
    * 发送用户ID
    */
    private Long acceptUserId;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
