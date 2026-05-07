package com.education.sdk.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.sdk.dao.MessageInfoDao;
import com.education.sdk.dto.MessageInfoDTO;
import com.education.sdk.service.MessageInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 聊天详情业务层实现类
* @author: wuming
* @create: 2025.02.22 10:30:14
*/
@Service("messageInfoService")
public class MessageInfoServiceImpl extends ServiceImpl<MessageInfoDao, MessageInfoDTO> implements MessageInfoService {

    @Override
    public Page<MessageInfoDTO> basePage(MessageInfoDTO messageInfoDTO) {
        if (null != messageInfoDTO.getCurrent() && null != messageInfoDTO.getPageSize())
            messageInfoDTO.setCurrent((messageInfoDTO.getCurrent() - 1) * messageInfoDTO.getPageSize());
        List<MessageInfoDTO> list = this.baseMapper.findList(messageInfoDTO);
        int count = this.baseMapper.findPageCount(messageInfoDTO);
        Page<MessageInfoDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<MessageInfoDTO> findList(MessageInfoDTO messageInfoDTO) {
        return this.baseMapper.findList(messageInfoDTO);
    }

}
