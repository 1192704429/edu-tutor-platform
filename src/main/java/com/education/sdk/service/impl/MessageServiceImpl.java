package com.education.sdk.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.sdk.dao.MessageDao;
import com.education.sdk.dto.MessageDTO;
import com.education.sdk.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 聊天业务层实现类
* @author: wuming
* @create: 2025.02.22 10:30:14
*/
@Service("messageService")
public class MessageServiceImpl extends ServiceImpl<MessageDao, MessageDTO> implements MessageService {

    @Override
    public Page<MessageDTO> basePage(MessageDTO messageDTO) {
        if (null != messageDTO.getCurrent() && null != messageDTO.getPageSize())
            messageDTO.setCurrent((messageDTO.getCurrent() - 1) * messageDTO.getPageSize());
        List<MessageDTO> list = this.baseMapper.findList(messageDTO);
        int count = this.baseMapper.findPageCount(messageDTO);
        Page<MessageDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<MessageDTO> findList(MessageDTO messageDTO) {
        return this.baseMapper.findList(messageDTO);
    }

}
