package com.education.sdk.entity;

import com.education.sdk.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 用户管理实体类
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Users extends BaseEntity {

    /**
    * 用户编号
    */
    private Long id;
    /**
    * 用户昵称
    */
    private String nickName;
    /**
    * 头像
    */
    private String avatar;
    /**
    * 用户名
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    private String school;
    private String address;
    private String info;
    private String classes;
    /**
    * 性别
    */
    private Integer sex;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
