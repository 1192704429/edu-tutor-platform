package com.education.sdk.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.education.sdk.dto.ManageDTO;
import java.util.List;
/**
* @description: 管理员表业务层接口
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
public interface ManageService extends IService<ManageDTO> {

    /**
    * 默认分页方法
    * @param manageDTO
    * @return
    */
    Page<ManageDTO> basePage(ManageDTO manageDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param manageDTO
    * @return
    */
    List<ManageDTO> findList(ManageDTO manageDTO);

}
