package com.education.sdk.controller;

import com.education.sdk.common.BaseController;
import com.education.sdk.common.ReturnMsg;
import com.education.sdk.dto.MessageDTO;
import com.education.sdk.service.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
/**
* @description: 聊天对外接口层
* @author: wuming
* @create: 2025.02.22 10:30:14
*/
@RestController
@RequestMapping("/message")
public class MessageController extends BaseController<MessageService, MessageDTO> {


    @Override
    @Resource(name = "messageService")
    protected void setBaseService(MessageService messageService) {
        this.baseService = messageService;
    }

    /**
    * 默认分页查询
    * @param messageDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody MessageDTO messageDTO) {
        return ReturnMsg.ok(baseService.basePage(messageDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param messageDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody MessageDTO messageDTO) {
        return ReturnMsg.ok(baseService.findList(messageDTO));
    }

    @Override
    protected void beforeSave(MessageDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

