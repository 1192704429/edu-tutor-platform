package com.education.sdk.common;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.education.sdk.common.constants.ResultConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * @Description: 控制层接口的基类
 * @Author: wuming
 */
@Controller
@SuppressWarnings("all")
public abstract class BaseController<T extends IService, E extends BaseEntity> {

    protected T baseService;

    protected abstract void setBaseService(T sevice);


    /**
     * 根据实体类中条件进行全等查询
     *
     * @param params
     * @return mybatis-plus 分页对象
     * @throws Exception
     */
    @PostMapping(value = "/list/param")
    public ReturnMsg baseGetListPage(@RequestBody Map<String, Object> params) throws Exception {
        return pageByWrapper(params);
    }

    /**
     * 根据实体类中条件进行全等查询
     *
     * @param params
     * @return mybatis-plus 返回所有数据
     * @throws Exception
     */
    @PostMapping(value = "/list/all")
    public ReturnMsg baseGetListAll(@RequestBody Map<String, Object> params) throws Exception {
        QueryWrapper<E> wrapper = beforeGetListAll(params);
        return afterGetListAll(baseService.list());
    }

    /**
     * 根据id获取信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/get/{id}")
    public ReturnMsg baseGetById(@PathVariable("id") Long id) throws Exception {
        beforeGetById(id);
        return afterGetById((E) baseService.getById(id));
    }

    /**
     * 保存或者修改信息方法
     *
     * @param entity 实体对象
     * @return 返回信息
     * @throws Exception
     */
    @PostMapping(value = "/save/update")
    public ReturnMsg baseSaveOrUpdate(@RequestBody E entity) throws Exception {
        // 是否是修改
        boolean isUpdate = ObjectUtil.isNotEmpty(entity.getId());
        if (isUpdate) {
            beforeUpdate(entity);
        } else {
            beforeSave(entity);
        }
        boolean flag = baseService.saveOrUpdate(entity);
        if (isUpdate) {
            afterUpdate(entity);
            return afterSaveOrUpdate(entity, flag, ResultConstant.UPDATE_DATA_FALL_MSG);
        } else {
            afterSave(entity);
            return afterSaveOrUpdate(entity, flag, ResultConstant.INSERT_DATA_FALL_MSG);
        }
    }

    /**
     * 修改之后的操作
     *
     * @param entity
     */
    protected void afterUpdate(E entity) throws Exception{
    }

    /**
     * 修改之前的操作
     *
     * @param entity
     */
    protected void afterSave(E entity) throws Exception{
    }

    /**
     * 修改之前的操作
     *
     * @param entity
     */
    protected void beforeUpdate(E entity) throws Exception{
    }

    /**
     * 保存之前的操作
     *
     * @param entity
     */
    protected void beforeSave(E entity) throws Exception{
    }

    /**
     * 据ID删除数据
     *
     * @param id 主键编号
     * @return 实体对象
     * @throws Exception
     */
    @GetMapping(value = "/remove/{id}")
    public ReturnMsg baseRemoveById(@PathVariable("id") Long id) throws Exception {
        beforeRemoveById(id);
        boolean flag = baseService.removeById(id);
        return afterRemoveById(flag, id);
    }

    /**
     * 根据ID集合进行删除
     *
     * @param idList 主键id的List集合
     * @return
     * @throws Exception
     */
    @PostMapping("/remove")
    public ReturnMsg baseRemoveByIds(@RequestBody List<Long> idList) throws Exception {
        beforeRemoveByIds(idList);
        boolean flag = baseService.removeByIds(idList);
        return afterRemoveByIds(flag, idList);
    }

    /**
     * 分页
     *
     * @param params
     * @return
     */
    protected ReturnMsg pageByWrapper(Map<String, Object> params) {
        QueryWrapper<E> wrapper = beforeGetListPage(params);
        if (StrUtil.isEmptyIfStr(params.get(ResultConstant.CURRENT))) {
            params.put(ResultConstant.CURRENT, ResultConstant.DEFAULT_CURRENT);
        }
        if (StrUtil.isEmptyIfStr(params.get(ResultConstant.PAGE_SIZE))) {
            params.put(ResultConstant.PAGE_SIZE, ResultConstant.DEFAULT_PAGE_SIZE);
        }
        Page<E> selectPageList = (Page<E>) baseService.page(new Page(
                Long.parseLong(params.get(ResultConstant.CURRENT).toString())
                , Long.parseLong(params.get(ResultConstant.PAGE_SIZE).toString())), wrapper);
        return afterGetListPage(selectPageList, params);
    }

    /**
     * 分页前对wrapper的处理
     *
     * @param params
     * @return
     */
    private QueryWrapper<E> beforeGetListPage(Map<String, Object> params) {
        return beforeGetListPage(params, null);
    }

    /**
     * 重载分页前对wrapper的处理
     *
     * @param params
     * @param sqlWrapper
     * @return
     */
    protected QueryWrapper<E> beforeGetListPage(Map<String, Object> params, QueryWrapper<E> sqlWrapper) {
        if (null == sqlWrapper) {
            sqlWrapper = new QueryWrapper<>();
        }
        return sqlWrapper;
    }

    /**
     * 分页处理完后的数据响应
     *
     * @param obj
     * @return
     */
    protected ReturnMsg afterGetListPage(Object obj, Map<String, Object> params) {
        return ReturnMsg.ok(obj);
    }

    /**
     * 查询所有数据前对wrapper的处理
     *
     * @param params
     * @return
     */
    protected QueryWrapper<E> beforeGetListAll(Map<String, Object> params) {
        return null;
    }

    /**
     * 查询所有数据后对wrapper的处理
     *
     * @param params
     * @return
     */
    protected ReturnMsg afterGetListAll(Object obj) {
        return ReturnMsg.ok(obj);
    }

    /**
     * 查看单个数据前操作
     *
     * @param id
     */
    protected void beforeGetById(Long id) throws Exception{

    }

    /**
     * 查看单个数据后操作
     *
     * @param entity
     */
    protected ReturnMsg afterGetById(E entity) throws Exception{
        return entity != null ? ReturnMsg.ok(entity)
                : ReturnMsg.error(ResultConstant.SELECT_DATA_FALL_MSG);
    }

    /**
     * 保存修改后的操作
     *
     * @param entity
     * @return
     */
    protected ReturnMsg afterSaveOrUpdate(E entity, boolean flag, String msg) {
        return flag ? ReturnMsg.ok(entity)
                : ReturnMsg.error(msg);
    }

    /**
     * 单个删除前的操作
     *
     * @param entity
     * @return
     */
    protected void beforeRemoveById(Long id) throws Exception{
    }

    /**
     * 单个删除后的操作
     *
     * @param entity
     * @return
     */
    protected ReturnMsg afterRemoveById(boolean flag, Long id) throws Exception{
        return flag ? ReturnMsg.ok()
                : ReturnMsg.error(ResultConstant.DEFAULT_FAIL_MSG);
    }

    /**
     * 根据ID集合进行删除前操作
     *
     * @param entity
     * @return
     */
    protected void beforeRemoveByIds(List<Long> idList) throws Exception{
    }

    /**
     * 根据ID集合进行删除后操作
     *
     * @param entity
     * @return
     */
    protected ReturnMsg afterRemoveByIds(boolean flag, List<Long> list) throws Exception{
        return flag ? ReturnMsg.ok()
                : ReturnMsg.error(ResultConstant.DELETE_DATA_FALL_MSG);
    }

}
