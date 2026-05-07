package com.education.sdk.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description: 基础实体类  包含所有表大部分共同字段
 * @author: wuming
 * @create: 2025-02-28 10:20:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseEntity implements Serializable {

	/**编号*/
	@TableId(type = IdType.AUTO)
	private Long id;

	/**分页页数*/
	@TableField(exist = false)
	private Integer current;

	/**数据数量*/
	@TableField(exist = false)
	private Integer pageSize;

}
