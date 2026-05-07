package com.education.sdk.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.education.sdk.dto.MessageDTO;

import java.util.List;
/**
* @description: 聊天业务层接口
* @author: wuming
* @create: 2025.02.22 10:30:14
*/
public interface MessageService extends IService<MessageDTO> {

    /**
    * 默认分页方法
    * @param messageDTO
    * @return
    */
    Page<MessageDTO> basePage(MessageDTO messageDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param messageDTO
    * @return
    */
    List<MessageDTO> findList(MessageDTO messageDTO);

}
