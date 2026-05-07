package com.education.sdk.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.sdk.dao.UsersDao;
import com.education.sdk.dto.UsersDTO;
import com.education.sdk.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 用户管理业务层实现类
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@Service("usersService")
public class UsersServiceImpl extends ServiceImpl<UsersDao, UsersDTO> implements UsersService {

    @Override
    public Page<UsersDTO> basePage(UsersDTO usersDTO) {
        if (null != usersDTO.getCurrent() && null != usersDTO.getPageSize())
            usersDTO.setCurrent((usersDTO.getCurrent() - 1) * usersDTO.getPageSize());
        List<UsersDTO> list = this.baseMapper.findList(usersDTO);
        int count = this.baseMapper.findPageCount(usersDTO);
        Page<UsersDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<UsersDTO> findList(UsersDTO usersDTO) {
        return this.baseMapper.findList(usersDTO);
    }

}
