package com.education.sdk.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.education.sdk.dto.TypesDTO;
import java.util.List;
/**
* @description: 服务方式管理业务层接口
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
public interface TypesService extends IService<TypesDTO> {

    /**
    * 默认分页方法
    * @param typesDTO
    * @return
    */
    Page<TypesDTO> basePage(TypesDTO typesDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param typesDTO
    * @return
    */
    List<TypesDTO> findList(TypesDTO typesDTO);

}
