package com.education.sdk.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.sdk.dao.TeacherDao;
import com.education.sdk.dto.TeacherDTO;
import com.education.sdk.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 教师管理业务层实现类
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@Service("teacherService")
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, TeacherDTO> implements TeacherService {

    @Override
    public Page<TeacherDTO> basePage(TeacherDTO teacherDTO) {
        if (null != teacherDTO.getCurrent() && null != teacherDTO.getPageSize())
            teacherDTO.setCurrent((teacherDTO.getCurrent() - 1) * teacherDTO.getPageSize());
        List<TeacherDTO> list = this.baseMapper.findList(teacherDTO);
        int count = this.baseMapper.findPageCount(teacherDTO);
        Page<TeacherDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<TeacherDTO> findList(TeacherDTO teacherDTO) {
        return this.baseMapper.findList(teacherDTO);
    }

}
