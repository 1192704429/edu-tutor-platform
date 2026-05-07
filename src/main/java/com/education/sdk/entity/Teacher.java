package com.education.sdk.entity;

import com.education.sdk.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 教师管理实体类
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Teacher extends BaseEntity {

    /**
    * 老师编号
    */
    private Long id;
    /**
    * 老师姓名
    */
    private String name;
    /**
    * 年龄
    */
    private Integer age;
    /**
    * 性别
    */
    private Integer sex;
    /**
    * 用户名
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    /**
    * 头像
    */
    private String headImg;
    /**
    * 毕业院校
    */
    private String collegiate;
    /**
    * 学历
    */
    private String educational;
    /**
    * 毕业证书
    */
    private String educationalImg;
    /**
    * 个人简介
    */
    private String info;
    /**
    * 状态
    */
    private Integer status;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 服务方式
    */
    private Long typeId;


}
