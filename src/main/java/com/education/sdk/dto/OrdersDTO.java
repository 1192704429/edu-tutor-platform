package com.education.sdk.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.education.sdk.entity. Orders;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @description: 预约订单数据传输层
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@Data
@ToString
@TableName("orders")
public class OrdersDTO extends Orders {

    /**
    * 学科名称
    */
    @TableField(exist = false)
    private String subjectName;
    /**
    * 用户昵称
    */
    @TableField(exist = false)
    private String nickName;
    /**
    * 头像
    */
    @TableField(exist = false)
    private String avatar;
    /**
    * 老师姓名
    */
    @TableField(exist = false)
    private String name;
    /**
    * 头像
    */
    @TableField(exist = false)
    private String headImg;

    @TableField(exist = false)
    private String typeName;

}
