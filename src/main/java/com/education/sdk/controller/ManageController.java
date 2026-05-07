package com.education.sdk.controller;

import com.education.sdk.common.BaseController;
import com.education.sdk.common.ReturnMsg;
import com.education.sdk.dto.ManageDTO;
import com.education.sdk.service.ManageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.education.sdk.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
/**
* @description: 管理员表对外接口层
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@RestController
@RequestMapping("/manage")
public class ManageController extends BaseController<ManageService, ManageDTO> {


    @Override
    @Resource(name = "manageService")
    protected void setBaseService(ManageService manageService) {
        this.baseService = manageService;
    }

    /**
    * 默认分页查询
    * @param manageDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody ManageDTO manageDTO) {
        return ReturnMsg.ok(baseService.basePage(manageDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param manageDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody ManageDTO manageDTO) {
        return ReturnMsg.ok(baseService.findList(manageDTO));
    }


}

