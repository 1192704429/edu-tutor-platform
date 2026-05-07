package com.education.sdk.controller;

import com.education.sdk.common.BaseController;
import com.education.sdk.common.ReturnMsg;
import com.education.sdk.dto.MessageInfoDTO;
import com.education.sdk.service.MessageInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
/**
* @description: 聊天详情对外接口层
* @author: wuming
* @create: 2025.02.22 10:30:14
*/
@RestController
@RequestMapping("/messageInfo")
public class MessageInfoController extends BaseController<MessageInfoService, MessageInfoDTO> {


    @Override
    @Resource(name = "messageInfoService")
    protected void setBaseService(MessageInfoService messageInfoService) {
        this.baseService = messageInfoService;
    }

    /**
    * 默认分页查询
    * @param messageInfoDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody MessageInfoDTO messageInfoDTO) {
        return ReturnMsg.ok(baseService.basePage(messageInfoDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param messageInfoDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody MessageInfoDTO messageInfoDTO) {
        return ReturnMsg.ok(baseService.findList(messageInfoDTO));
    }

    @Override
    protected void beforeSave(MessageInfoDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

