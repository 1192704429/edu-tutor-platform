package com.education.sdk.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.education.sdk.dto.SubjectDTO;
import java.util.List;
/**
* @description: 学科管理业务层接口
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
public interface SubjectService extends IService<SubjectDTO> {

    /**
    * 默认分页方法
    * @param subjectDTO
    * @return
    */
    Page<SubjectDTO> basePage(SubjectDTO subjectDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param subjectDTO
    * @return
    */
    List<SubjectDTO> findList(SubjectDTO subjectDTO);

}
