package com.education.sdk.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.education.sdk.dto.MessageInfoDTO;

import java.util.List;
/**
* @description: 聊天详情业务层接口
* @author: wuming
* @create: 2025.02.22 10:30:14
*/
public interface MessageInfoService extends IService<MessageInfoDTO> {

    /**
    * 默认分页方法
    * @param messageInfoDTO
    * @return
    */
    Page<MessageInfoDTO> basePage(MessageInfoDTO messageInfoDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param messageInfoDTO
    * @return
    */
    List<MessageInfoDTO> findList(MessageInfoDTO messageInfoDTO);

}
