package com.education.sdk.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.education.sdk.dto.TeacherSubjectDTO;
import java.util.List;
/**
* @description: 老师绑定学科业务层接口
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
public interface TeacherSubjectService extends IService<TeacherSubjectDTO> {

    /**
    * 默认分页方法
    * @param teacherSubjectDTO
    * @return
    */
    Page<TeacherSubjectDTO> basePage(TeacherSubjectDTO teacherSubjectDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param teacherSubjectDTO
    * @return
    */
    List<TeacherSubjectDTO> findList(TeacherSubjectDTO teacherSubjectDTO);

}
