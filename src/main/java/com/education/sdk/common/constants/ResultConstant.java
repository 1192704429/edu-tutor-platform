package com.education.sdk.common.constants;

/**
 * controller 返回时，一些常用量值的封装
 * @author wuming
 * @create: 2025-02-28 10:20:21
 */
public class ResultConstant {

	/**常量msg*/
	public final static String MSG = "msg";
	/**拦截器中写入的状态属性字段key  CODE*/
	public final static String CODE = "code";
	/** 返回给页面上的数据 */
	public final static String DATA = "data";
	/**常量current*/
	public final static String CURRENT = "current";
	/**默认当前页*/
	public final static Long DEFAULT_CURRENT = 1L;
	/**常量pageSize*/
	public final static String PAGE_SIZE = "pageSize";
	/**默认每页数量*/
	public final static Long DEFAULT_PAGE_SIZE = 10L;
	/**成功状态码*/
	public final static Integer RESULT_CODE_200 = 200;
	/**后台服务器错误*/
	public final static Integer RESULT_CODE_500 = 500;

    /**返回信息提示*/
	public final static String DEFAULT_SUCCESS_MSG = "操作成功!";
	public final static String DEFAULT_FAIL_MSG = "服务器繁忙,请稍后重试!";
	public final static String UPDATE_DATA_FALL_MSG = "更新数据失败,请稍后重试!";
	public final static String INSERT_DATA_FALL_MSG = "新增数据失败,请稍后重试!";
	public final static String DELETE_DATA_FALL_MSG = "删除数据失败,请稍后重试!";
	public final static String SELECT_DATA_FALL_MSG = "数据查询失败,请稍后重试!";

}
