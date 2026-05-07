package com.education.sdk.controller;

import com.education.sdk.common.BaseController;
import com.education.sdk.common.ReturnMsg;
import com.education.sdk.dto.UsersDTO;
import com.education.sdk.service.UsersService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.education.sdk.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
import java.util.Date;
/**
* @description: 用户管理对外接口层
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@RestController
@RequestMapping("/users")
public class UsersController extends BaseController<UsersService, UsersDTO> {


    @Override
    @Resource(name = "usersService")
    protected void setBaseService(UsersService usersService) {
        this.baseService = usersService;
    }

    /**
    * 默认分页查询
    * @param usersDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody UsersDTO usersDTO) {
        return ReturnMsg.ok(baseService.basePage(usersDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param usersDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody UsersDTO usersDTO) {
        return ReturnMsg.ok(baseService.findList(usersDTO));
    }

    @Override
    protected void beforeSave(UsersDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

