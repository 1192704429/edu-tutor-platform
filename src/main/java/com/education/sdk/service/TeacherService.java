package com.education.sdk.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.education.sdk.dto.TeacherDTO;
import java.util.List;
/**
* @description: 教师管理业务层接口
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
public interface TeacherService extends IService<TeacherDTO> {

    /**
    * 默认分页方法
    * @param teacherDTO
    * @return
    */
    Page<TeacherDTO> basePage(TeacherDTO teacherDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param teacherDTO
    * @return
    */
    List<TeacherDTO> findList(TeacherDTO teacherDTO);

}
