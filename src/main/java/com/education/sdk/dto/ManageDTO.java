package com.education.sdk.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.education.sdk.entity. Manage;
import lombok.Data;
import lombok.ToString;

/**
* @description: 管理员表数据传输层
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@Data
@ToString
@TableName("manage")
public class ManageDTO extends Manage {


}
