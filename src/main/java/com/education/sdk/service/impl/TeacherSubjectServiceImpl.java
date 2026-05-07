package com.education.sdk.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.sdk.dao.TeacherSubjectDao;
import com.education.sdk.dto.TeacherSubjectDTO;
import com.education.sdk.service.TeacherSubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 老师绑定学科业务层实现类
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@Service("teacherSubjectService")
public class TeacherSubjectServiceImpl extends ServiceImpl<TeacherSubjectDao, TeacherSubjectDTO> implements TeacherSubjectService {

    @Override
    public Page<TeacherSubjectDTO> basePage(TeacherSubjectDTO teacherSubjectDTO) {
        if (null != teacherSubjectDTO.getCurrent() && null != teacherSubjectDTO.getPageSize())
            teacherSubjectDTO.setCurrent((teacherSubjectDTO.getCurrent() - 1) * teacherSubjectDTO.getPageSize());
        List<TeacherSubjectDTO> list = this.baseMapper.findList(teacherSubjectDTO);
        int count = this.baseMapper.findPageCount(teacherSubjectDTO);
        Page<TeacherSubjectDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<TeacherSubjectDTO> findList(TeacherSubjectDTO teacherSubjectDTO) {
        return this.baseMapper.findList(teacherSubjectDTO);
    }

}
