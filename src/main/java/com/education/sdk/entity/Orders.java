package com.education.sdk.entity;

import com.education.sdk.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 预约订单实体类
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Orders extends BaseEntity {

    /**
    * 订单编号
    */
    private Long id;
    /**
    * 用户编号
    */
    private Long userId;
    /**
    * 老师编号
    */
    private Long teacherId;
    /**
    * 上课时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date studentTime;
    /**
    * 上课地点
    */
    private String address;
    private String money;
    /**
    * 学科
    */
    private Long subjectId;
    /**
    * 状态
    */
    private Integer status;
    /**
    * 备注信息
    */
    private String remark;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
    * 授课方式
    */
    private Long typeId;


}
