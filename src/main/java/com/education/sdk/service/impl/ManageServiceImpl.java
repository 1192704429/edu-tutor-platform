package com.education.sdk.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.sdk.dao.ManageDao;
import com.education.sdk.dto.ManageDTO;
import com.education.sdk.service.ManageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 管理员表业务层实现类
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@Service("manageService")
public class ManageServiceImpl extends ServiceImpl<ManageDao, ManageDTO> implements ManageService {

    @Override
    public Page<ManageDTO> basePage(ManageDTO manageDTO) {
        if (null != manageDTO.getCurrent() && null != manageDTO.getPageSize())
            manageDTO.setCurrent((manageDTO.getCurrent() - 1) * manageDTO.getPageSize());
        List<ManageDTO> list = this.baseMapper.findList(manageDTO);
        int count = this.baseMapper.findPageCount(manageDTO);
        Page<ManageDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<ManageDTO> findList(ManageDTO manageDTO) {
        return this.baseMapper.findList(manageDTO);
    }

}
