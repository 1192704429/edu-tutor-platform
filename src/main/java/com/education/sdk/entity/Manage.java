package com.education.sdk.entity;

import com.education.sdk.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 管理员表实体类
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Manage extends BaseEntity {

    /**
    * 管理员编号
    */
    private Long id;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 密码
    */
    private String passWord;
    /**
    * 图片
    */
    private String photoImg;
    /**
    * 名称
    */
    private String name;


}
