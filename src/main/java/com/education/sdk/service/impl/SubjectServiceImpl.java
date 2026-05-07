package com.education.sdk.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.sdk.dao.SubjectDao;
import com.education.sdk.dto.SubjectDTO;
import com.education.sdk.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 学科管理业务层实现类
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@Service("subjectService")
public class SubjectServiceImpl extends ServiceImpl<SubjectDao, SubjectDTO> implements SubjectService {

    @Override
    public Page<SubjectDTO> basePage(SubjectDTO subjectDTO) {
        if (null != subjectDTO.getCurrent() && null != subjectDTO.getPageSize())
            subjectDTO.setCurrent((subjectDTO.getCurrent() - 1) * subjectDTO.getPageSize());
        List<SubjectDTO> list = this.baseMapper.findList(subjectDTO);
        int count = this.baseMapper.findPageCount(subjectDTO);
        Page<SubjectDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<SubjectDTO> findList(SubjectDTO subjectDTO) {
        return this.baseMapper.findList(subjectDTO);
    }

}
